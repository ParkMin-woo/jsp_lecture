package com.javalec.ex.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.dao.LoginMemberDAO;
import com.javalec.ex.dto.LoginMemberDTO;

/**
 * Servlet implementation class ModifyOK
 */
@WebServlet(description = "회원정보 수정 OK 여부 판별", urlPatterns = { "/ModifyOK" })
public class ModifyOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyOK() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			actionDo(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		try {
			actionDo(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// 한글 data 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		System.out.println("session에서 가져온 id => " + id);
		String name = request.getParameter("name");
		// String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String address = request.getParameter("address");
		String graduated_academy = request.getParameter("graduated_academy");
		String major = request.getParameter("major");
		
		String[] hobbies = request.getParameterValues("hobby");
		String hobbyStr = Arrays.toString(hobbies).replace("[", "");
		hobbyStr = hobbyStr.replace("]", "");
		
		String gender = request.getParameter("gender");
		
		LoginMemberDTO loginMemberDTO = new LoginMemberDTO();
		
		System.out.println("===================== loginMemberDTO에 parameter 세팅 Start =====================");
		loginMemberDTO.setName(name);
		loginMemberDTO.setId(id);
		loginMemberDTO.setPwd(pwd);
		loginMemberDTO.setAddress(address);
		loginMemberDTO.setGraduatedAcademy(graduated_academy);
		loginMemberDTO.setMajor(major);
		loginMemberDTO.setHobby(hobbyStr);
		loginMemberDTO.setGender(gender);
		System.out.println("===================== loginMemberDTO에 parameter 세팅 End =====================");
		
		System.out.println("===================== ModifyOK.java parameter Start =====================");
		System.out.println("name => " + loginMemberDTO.getName());
		System.out.println("id => " + loginMemberDTO.getId());
		System.out.println("pwd => " + loginMemberDTO.getPwd());
		System.out.println("address => " + loginMemberDTO.getAddress());
		System.out.println("graduated_academy => " + loginMemberDTO.getGraduatedAcademy());
		System.out.println("major => " + loginMemberDTO.getMajor());
		System.out.println("hobbyStr => " + loginMemberDTO.getHobby());
		System.out.println("gender => " + loginMemberDTO.getGender());
		System.out.println("===================== ModifyOK.java parameter End =====================");
		
		LoginMemberDAO dao = new LoginMemberDAO();
		int updateLoginSql = dao.updateLoginSql(loginMemberDTO);
		
		if(updateLoginSql != 0) {
			System.out.println("login_table 수정 완료");
			response.sendRedirect("modifyResult.jsp");
		}
		
	}

}
