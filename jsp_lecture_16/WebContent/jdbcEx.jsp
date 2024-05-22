<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>jsp JDBC Example</title>
</head>
<body>

	<%!
		private static final String DB_DRIVER_CLASS = "org.mariadb.jdbc.Driver";
		private static final String DB_URL = "jdbc:mariadb://192.168.35.173:3306/test";
		// private static final String DB_URL = "jdbc:mariadb://localhost:3306/test";
		
		private static final String DB_USERNAME = "temp1";
		private static final String DB_PASSWORD = "1234";
		
		private static Connection conn;
		// PreparedStatement pstm = null;
		Statement stm = null;
		ResultSet rs = null;
	%>
	
	<%
		try {
			System.out.println("DB_DRIVER_CLASS => " + DB_DRIVER_CLASS);
			Class.forName(DB_DRIVER_CLASS);
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			System.out.println("연결성공");
			
			stm = conn.createStatement();
			rs = stm.executeQuery("select * from employees where 1=1");
			
			while(rs.next()) {
				String employeeId = rs.getString("employee_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String birthDate = rs.getString("birth_date");
				
				out.println("직번 : " + employeeId + ", 성 : " + lastName + ", 이름 : " + firstName + ", 생년월일 : " + birthDate + "<br />");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이브 로딩 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// System.out.println(e.toString());
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		} finally {
			try {
				if(rs != null) rs.close();
				if(stm != null) stm.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// System.out.println(e.toString());
				e.printStackTrace();
				System.out.println("연결 해제 오류 발생");
			}
		}
	%>

</body>
</html>