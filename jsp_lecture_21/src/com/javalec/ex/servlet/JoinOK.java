package com.javalec.ex.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.dao.LoginMemberDAO;
import com.javalec.ex.dto.LoginMemberDTO;

/**
 * Servlet implementation class JoinOK
 */
@WebServlet(description = "회원가입 OK 여부를 판별하는 Servlet", urlPatterns = { "/JoinOK" })
public class JoinOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinOK() {
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
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		
		String name = request.getParameter("name");
		// String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String address = request.getParameter("address");
		String graduatedAcademy = request.getParameter("graduated_academy");
		String major = request.getParameter("major");
		
		String[] hobbies = request.getParameterValues("hobby");
		String hobbyStr = Arrays.toString(hobbies).replace("[", "");
		hobbyStr = hobbyStr.replace("]", "");
		
		String gender = request.getParameter("gender");
		
		LoginMemberDAO dao = new LoginMemberDAO();
		int i = dao.duplicateIdSelect(id);
		
		response.setContentType("text/html; charset=utf-8");
		
		if(i == 0) {
			int maxSeq = dao.getMaxSeq();
			System.out.println("maxSeq => " + maxSeq);
			
			LoginMemberDTO loginMemberDTO = new LoginMemberDTO();
			loginMemberDTO.setSeq(maxSeq);
			loginMemberDTO.setId(id);
			loginMemberDTO.setPwd(pwd);
			loginMemberDTO.setName(name);
			loginMemberDTO.setAddress(address);
			loginMemberDTO.setGraduatedAcademy(graduatedAcademy);
			loginMemberDTO.setSeq(maxSeq);
			loginMemberDTO.setMajor(major);
			loginMemberDTO.setHobby(hobbyStr);
			loginMemberDTO.setGender(gender);
			
			int insertLoginSql = dao.insertLoginSql(loginMemberDTO);
			
			if(insertLoginSql != 0) {
				System.out.println("login_table 등록 완료");
				response.sendRedirect("joinResult.jsp");
			}
		}
		else {
			PrintWriter writer = response.getWriter();
			writer.print("<html>");
			writer.print("<head>");
			writer.print("</head>");
			writer.print("<body>");
			writer.print(id + "가 존재합니다. 다른 ID를 입력해 주세요. <br />");
			writer.print("<a href='join.jsp'>회원가입 페이지로 이동</a>");
			writer.print("</body>");
			writer.print("</html>");
			writer.close();
			return;
		}
	}

}
