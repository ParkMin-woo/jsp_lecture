package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginOK
 */
@WebServlet(description = "로그인 성공 여부를 판단", urlPatterns = { "/LoginOK" })
public class LoginOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String DB_DRIVER_CLASS = "org.mariadb.jdbc.Driver";
	private static final String DB_URL = "jdbc:mariadb://192.168.35.173:3306/test";
	// private static final String DB_URL = "jdbc:mariadb://localhost:3306/test";
	
	private static final String DB_USERNAME = "temp1";
	private static final String DB_PASSWORD = "1234";
	
	private static Connection conn;
	PreparedStatement pstm = null;
	Statement stm = null;
	ResultSet rs = null;
       
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
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
//		try {
//			// System.out.println("DB_DRIVER_CLASS => " + DB_DRIVER_CLASS);
//			// 한글 data 깨짐 방지
//			request.setCharacterEncoding("UTF-8");
//			
//			String id = request.getParameter("id");
//			String pwd = request.getParameter("pwd");
//			int i = 0;
//			
//			Class.forName(DB_DRIVER_CLASS);
//			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//			System.out.println("DriverManager.getConnection 연결성공");
//			
//			stm = conn.createStatement();
//			String existedIdSelectSql = "SELECT * FROM login_table WHERE 1=1 and id = ? and pwd = ?";
//			pstm = conn.prepareStatement(existedIdSelectSql);
//			pstm.setString(1, id);
//			pstm.setString(2, pwd);
//			rs = pstm.executeQuery();
//			
//			response.setContentType("text/html; charset=utf-8");
//			
//			PrintWriter writer = response.getWriter();
//			
//			while(rs.next()) {
//				i++;
//			}
//			
//			if(i == 0) {
//				/*
//				writer.print("<html>");
//				writer.print("<head>");
//				writer.print("</head>");
//				writer.print("<body>");
//				writer.print("ID와 패스워드 확인해주세요. ID 등록하지 않으셨다면 회원가입부터 해주세요. <br />");
//				writer.print("<a href='login.html'>로그인 페이지로 이동</a> <br />");
//				writer.print("<a href='join.html'>회원가입 페이지로 이동</a>");
//				writer.print("</body>");
//				writer.print("</html>");
//				*/
//				response.sendRedirect("loginResult.jsp?flag=N&id="+id);
//			}
//			else {
//				response.sendRedirect("loginResult.jsp?flag=Y&id="+id);
//				/*
//				writer.print("<html>");
//				writer.print("<head>");
//				writer.print("</head>");
//				writer.print("<body>");
//				writer.print(id + "님 환영합니다. <br />");
//				writer.print("<a href='loginResult.jsp'>로그인 결과 페이지로 이동</a>");
//				writer.print("</body>");
//				writer.print("</html>");
//				*/
//			}
//			writer.close();
//		}
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("드라이브 로딩 실패");
//		}
//		catch (SQLException e) {
//			// TODO Auto-generated catch block
//			// System.out.println(e.toString());
//			e.printStackTrace();
//			System.out.println("DB 연결 실패");
//		}
//		finally {
//			try {
//				if(rs != null) rs.close();
//				if(stm != null) stm.close();
//				if(conn != null) conn.close();
//				if(pstm != null) pstm.close();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				// System.out.println(e.toString());
//				e.printStackTrace();
//				System.out.println("연결 해제 오류 발생");
//			}
//		}
		actionDo(request, response);
		
	}
	
	public void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// System.out.println("DB_DRIVER_CLASS => " + DB_DRIVER_CLASS);
			// 한글 data 깨짐 방지
			request.setCharacterEncoding("UTF-8");
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			int i = 0;
			
			Class.forName(DB_DRIVER_CLASS);
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			System.out.println("DriverManager.getConnection 연결성공");
			
			stm = conn.createStatement();
			String existedIdSelectSql = "SELECT * FROM login_table WHERE 1=1 and id = ? and pwd = ?";
			pstm = conn.prepareStatement(existedIdSelectSql);
			pstm.setString(1, id);
			pstm.setString(2, pwd);
			rs = pstm.executeQuery();
			
			response.setContentType("text/html; charset=utf-8");
			
			// PrintWriter writer = response.getWriter();
			
			while(rs.next()) {
				i++;
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			
			if(i == 0) {
				/*
				writer.print("<html>");
				writer.print("<head>");
				writer.print("</head>");
				writer.print("<body>");
				writer.print("ID와 패스워드 확인해주세요. ID 등록하지 않으셨다면 회원가입부터 해주세요. <br />");
				writer.print("<a href='login.html'>로그인 페이지로 이동</a> <br />");
				writer.print("<a href='join.html'>회원가입 페이지로 이동</a>");
				writer.print("</body>");
				writer.print("</html>");
				*/
				response.sendRedirect("loginResult.jsp?flag=N");
			}
			else {
				response.sendRedirect("loginResult.jsp?flag=Y");
				/*
				writer.print("<html>");
				writer.print("<head>");
				writer.print("</head>");
				writer.print("<body>");
				writer.print(id + "님 환영합니다. <br />");
				writer.print("<a href='loginResult.jsp'>로그인 결과 페이지로 이동</a>");
				writer.print("</body>");
				writer.print("</html>");
				*/
			}
			// writer.close();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이브 로딩 실패");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			// System.out.println(e.toString());
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stm != null) stm.close();
				if(conn != null) conn.close();
				if(pstm != null) pstm.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// System.out.println(e.toString());
				e.printStackTrace();
				System.out.println("연결 해제 오류 발생");
			}
		}
	}

}
