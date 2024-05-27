package com.javalec.ex.servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.dao.LoginMemberDAO;

/**
 * Servlet implementation class LoginOK
 */
@WebServlet(description = "로그인 성공여부 판단", urlPatterns = { "/LoginOK" })
public class LoginOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginOK() {
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
		// System.out.println("DB_DRIVER_CLASS => " + DB_DRIVER_CLASS);
		// 한글 data 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		LoginMemberDAO dao = new LoginMemberDAO();
		int i = dao.existedLoginIdSelect(id, pwd);
		
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		
		if(i == 0) {
			response.sendRedirect("loginResult.jsp?flag=N");
		}
		else {
			response.sendRedirect("loginResult.jsp?flag=Y");
		}
	}

}
