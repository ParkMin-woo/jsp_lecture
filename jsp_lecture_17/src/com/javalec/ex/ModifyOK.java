package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyOK
 */
@WebServlet(description = "회원정보 수정 OK 여부 판별", urlPatterns = { "/ModifyOK" })
public class ModifyOK extends HttpServlet {
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
    public ModifyOK() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
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
//			String name = request.getParameter("name");
//			String id = request.getParameter("id");
//			String pwd = request.getParameter("pwd");
//			String address = request.getParameter("address");
//			String graduated_academy = request.getParameter("graduated_academy");
//			String major = request.getParameter("major");
//			
//			String[] hobbies = request.getParameterValues("hobby");
//			String hobbyStr = Arrays.toString(hobbies).replace("[", "");
//			hobbyStr = hobbyStr.replace("]", "");
//			
//			String gender = request.getParameter("gender");
//			
//			Class.forName(DB_DRIVER_CLASS);
//			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//			System.out.println("DriverManager.getConnection 연결성공");
//			
//			System.out.println("===================== ModifyOK.java parameter =====================");
//			System.out.println("name => " + name);
//			System.out.println("id => " + id);
//			System.out.println("pwd => " + pwd);
//			System.out.println("address => " + address);
//			System.out.println("graduated_academy => " + graduated_academy);
//			System.out.println("major => " + major);
//			System.out.println("hobbyStr => " + hobbyStr);
//			System.out.println("gender => " + gender);
//			
//			int result = 0;
//			
//			String updateSql = "UPDATE login_table SET pwd = ? , name = ? , address = ? , graduated_academy =? , major =? , hobby = ? , gender = ? WHERE 1=1 AND id = ?";
//			
//			pstm = conn.prepareStatement(updateSql);
//			pstm.setString(1, pwd);
//			pstm.setString(2, name);
//			pstm.setString(3, address);
//			pstm.setString(4, graduated_academy);
//			pstm.setString(5, major);
//			pstm.setString(6, hobbyStr);
//			pstm.setString(7, gender);
//			pstm.setString(8, id);
//			
//			result = pstm.executeUpdate();
//			System.out.println("result => " + result);
//			
//			if(result != 0) {
//				System.out.println("login_table 수정 완료");
//				response.sendRedirect("modifyResult.jsp?id=" + id);
//			}
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
			
			String name = request.getParameter("name");
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String address = request.getParameter("address");
			String graduated_academy = request.getParameter("graduated_academy");
			String major = request.getParameter("major");
			
			String[] hobbies = request.getParameterValues("hobby");
			String hobbyStr = Arrays.toString(hobbies).replace("[", "");
			hobbyStr = hobbyStr.replace("]", "");
			
			String gender = request.getParameter("gender");
			
			Class.forName(DB_DRIVER_CLASS);
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			System.out.println("DriverManager.getConnection 연결성공");
			
			System.out.println("===================== ModifyOK.java parameter =====================");
			System.out.println("name => " + name);
			System.out.println("id => " + id);
			System.out.println("pwd => " + pwd);
			System.out.println("address => " + address);
			System.out.println("graduated_academy => " + graduated_academy);
			System.out.println("major => " + major);
			System.out.println("hobbyStr => " + hobbyStr);
			System.out.println("gender => " + gender);
			
			int result = 0;
			
			String updateSql = "UPDATE login_table SET pwd = ? , name = ? , address = ? , graduated_academy =? , major =? , hobby = ? , gender = ? WHERE 1=1 AND id = ?";
			
			pstm = conn.prepareStatement(updateSql);
			pstm.setString(1, pwd);
			pstm.setString(2, name);
			pstm.setString(3, address);
			pstm.setString(4, graduated_academy);
			pstm.setString(5, major);
			pstm.setString(6, hobbyStr);
			pstm.setString(7, gender);
			pstm.setString(8, id);
			
			result = pstm.executeUpdate();
			System.out.println("result => " + result);
			
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			
			if(result != 0) {
				System.out.println("login_table 수정 완료");
				response.sendRedirect("modifyResult.jsp");
			}
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
