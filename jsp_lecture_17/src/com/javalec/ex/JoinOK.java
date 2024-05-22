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

/**
 * Servlet implementation class JoinOK
 */
@WebServlet(description = "회원가입 OK 여부를 판별하는 Servlet", urlPatterns = { "/JoinOK" })
public class JoinOK extends HttpServlet {
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
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		/*
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
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("이름 : " + name + "<br />");
		writer.println("아이디 : " + id + "<br />");
		writer.println("패스워드 : " + pwd + "<br />");
		writer.println("주소 : " + address + "<br />");
		writer.println("학력 : " + graduated_academy + "<br />");
		writer.println("전공 : " + major + "<br />");
		// writer.println("취미 : " + Arrays.toString(hobbies) + "<br />");
		writer.println("취미 : " + hobbyStr + "<br />");
		writer.println("성별 : " + gender + "<br />");
		writer.println("</body></html>");
		
		writer.close();
		*/
		
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
//			int result = 0;
//			
//			Class.forName(DB_DRIVER_CLASS);
//			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//			System.out.println("DriverManager.getConnection 연결성공");
//			
//			stm = conn.createStatement();
//			// rs = stm.executeQuery("select * from employees where 1=1");
//			String duplicateIdSelectSql = "SELECT * FROM login_table WHERE 1=1 and id = ?";
//			pstm = conn.prepareStatement(duplicateIdSelectSql);
//			pstm.setString(1, id);
//			rs = pstm.executeQuery();
//			
//			response.setContentType("text/html; charset=utf-8");
//			
//			while(rs.next()) {
//				PrintWriter writer = response.getWriter();
//				writer.print("<html>");
//				writer.print("<head>");
//				writer.print("</head>");
//				writer.print("<body>");
//				writer.print(rs.getString("id") + "가 존재합니다. 다른 ID를 입력해 주세요. <br />");
//				writer.print("<a href='join.html'>회원가입 페이지로 이동</a>");
//				writer.print("</body>");
//				writer.print("</html>");
//				writer.close();
//				// response.sendRedirect("join.html");
//				return;
//			}
//			
//			String maxSeqSelectSql = "SELECT nvl(MAX(seq), 0) AS max_seq FROM login_table WHERE 1=1";
//			rs = stm.executeQuery(maxSeqSelectSql);
//			
//			// PrintWriter writer = response.getWriter();
//			
//			int maxSeq = 0;
//			
//			while(rs.next()) {
//				maxSeq = rs.getInt("max_seq");
//				maxSeq++;
//			}
//			System.out.println("maxSeq => " + maxSeq);
//			
//			String insertSql = "INSERT INTO login_table VALUES(?, ?, ?, ?, ?, ? ,? ,? ,?)";
//			
//			pstm = conn.prepareStatement(insertSql);
//			pstm.setInt(1, maxSeq);
//			pstm.setString(2, id);
//			pstm.setString(3, pwd);
//			pstm.setString(4, name);
//			pstm.setString(5, address);
//			pstm.setString(6, graduated_academy);
//			pstm.setString(7, major);
//			pstm.setString(8, hobbyStr);
//			pstm.setString(9, gender);
//			
//			result = pstm.executeUpdate();
//			System.out.println("result => " + result);
//			
//			if(result != 0) {
//				System.out.println("login_table 등록 완료");
//				response.sendRedirect("joinResult.jsp?id=" + id);
//			}
//			
//			// response.setContentType("text/html; charset=utf-8");
//			
//			/*
//			PrintWriter writer = response.getWriter();
//			
//			writer.print("<html>");
//			writer.print("<head>");
//			writer.print("</head>");
//			writer.print("<body>");
//			
//			while(rs.next()) {
//				String employeeId = rs.getString("employee_id");
//				String firstName = rs.getString("first_name");
//				String lastName = rs.getString("last_name");
//				String birthDate = rs.getString("birth_date");
//				
//				writer.println("직번 : " + employeeId + ", 성 : " + lastName + ", 이름 : " + firstName + ", 생년월일 : " + birthDate + "<br />");
//			}
//			writer.print("</body>");
//			writer.print("</html>");
//			*/
//			
//			// writer.close();
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
			
			int result = 0;
			
			Class.forName(DB_DRIVER_CLASS);
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			System.out.println("DriverManager.getConnection 연결성공");
			
			stm = conn.createStatement();
			// rs = stm.executeQuery("select * from employees where 1=1");
			String duplicateIdSelectSql = "SELECT * FROM login_table WHERE 1=1 and id = ?";
			pstm = conn.prepareStatement(duplicateIdSelectSql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			response.setContentType("text/html; charset=utf-8");
			
			while(rs.next()) {
				PrintWriter writer = response.getWriter();
				writer.print("<html>");
				writer.print("<head>");
				writer.print("</head>");
				writer.print("<body>");
				writer.print(rs.getString("id") + "가 존재합니다. 다른 ID를 입력해 주세요. <br />");
				writer.print("<a href='join.html'>회원가입 페이지로 이동</a>");
				writer.print("</body>");
				writer.print("</html>");
				writer.close();
				// response.sendRedirect("join.html");
				return;
			}
			
			String maxSeqSelectSql = "SELECT nvl(MAX(seq), 0) AS max_seq FROM login_table WHERE 1=1";
			rs = stm.executeQuery(maxSeqSelectSql);
			
			// PrintWriter writer = response.getWriter();
			
			int maxSeq = 0;
			
			while(rs.next()) {
				maxSeq = rs.getInt("max_seq");
				maxSeq++;
			}
			System.out.println("maxSeq => " + maxSeq);
			
			String insertSql = "INSERT INTO login_table VALUES(?, ?, ?, ?, ?, ? ,? ,? ,?)";
			
			pstm = conn.prepareStatement(insertSql);
			pstm.setInt(1, maxSeq);
			pstm.setString(2, id);
			pstm.setString(3, pwd);
			pstm.setString(4, name);
			pstm.setString(5, address);
			pstm.setString(6, graduated_academy);
			pstm.setString(7, major);
			pstm.setString(8, hobbyStr);
			pstm.setString(9, gender);
			
			result = pstm.executeUpdate();
			System.out.println("result => " + result);
			
			if(result != 0) {
				System.out.println("login_table 등록 완료");
				response.sendRedirect("joinResult.jsp");
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
