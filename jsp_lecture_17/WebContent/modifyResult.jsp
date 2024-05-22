<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>회원 수정 페이지</title>
</head>
<body>

	<%!
		private static final String DB_DRIVER_CLASS = "org.mariadb.jdbc.Driver";
		private static final String DB_URL = "jdbc:mariadb://192.168.35.173:3306/test";
		// private static final String DB_URL = "jdbc:mariadb://localhost:3306/test";
		
		private static final String DB_USERNAME = "temp1";
		private static final String DB_PASSWORD = "1234";
		
		private static Connection conn;
		PreparedStatement pstm = null;
		Statement stm = null;
		ResultSet rs = null;
		
		String id = null;
		String name = null;
		String pwd = null;
		String address = null;
		String graduated_academy = null;
		String major = null;
		String hobby = null;
		String gender = null;
		
		String graduated_code = null;
		String graduated_academy2 = null;
		String hobby_code = null;
		String hobby2 = null;
		// String[] hobbyArr = null;
		List<Map<Object, String>> graduatedList = new ArrayList<>();
		List<Map<Object, String>> hobbyList = new ArrayList<>();
	%>

	<%
		id = (String) session.getAttribute("id");
		
		try {
			// System.out.println("DB_DRIVER_CLASS => " + DB_DRIVER_CLASS);
			Class.forName(DB_DRIVER_CLASS);
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			System.out.println("연결성공");
			
			stm = conn.createStatement();
			String existedIdSelectSql = "SELECT * FROM login_table WHERE 1=1 and id = ?";
			pstm = conn.prepareStatement(existedIdSelectSql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				name = rs.getString("name");
				pwd = rs.getString("pwd");
				address = rs.getString("address");
				graduated_academy = rs.getString("graduated_academy");
				major = rs.getString("major");
				hobby = rs.getString("hobby");
				gender = rs.getString("gender");
			}
			
			rs = stm.executeQuery("select * from graduated_table where 1=1 order by seq asc");
			// int i = 0;
			while(rs.next()) {
				Map<Object, String> graduatedMap = new HashMap<Object, String>();
				// i++;
				graduated_code = rs.getString("gratuated_code");
				graduated_academy2 = rs.getString("graduated_academy");
				// out.println("graduated_code => " + graduated_code + ", graduated_academy2 => " + graduated_academy2 + "<br />");
				// out.println("i => " + i + "<br />");
				graduatedMap.put("graduated_code", graduated_code);
				graduatedMap.put("graduated_academy", graduated_academy2);
				graduatedList.add(graduatedMap);
			}
			
			// out.println("graduatedList => " + graduatedList.toString());
			
			rs = stm.executeQuery("SELECT * FROM hobby_table WHERE 1=1 ORDER BY seq asc");
			while(rs.next()) {
				Map<Object, String> hobbyMap = new HashMap<Object, String>();
				// i++;
				hobby_code = rs.getString("hobby_code");
				hobby2 = rs.getString("hobby");
				// out.println("graduated_code => " + graduated_code + ", graduated_academy2 => " + graduated_academy2 + "<br />");
				// out.println("i => " + i + "<br />");
				hobbyMap.put("hobby_code", hobby_code);
				hobbyMap.put("hobby", hobby2);
				hobbyList.add(hobbyMap);
			}
			// out.println("originHobbyList => " + originHobbyList.toString() + "<br />");
			
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
	
	<c:set var="graduated_academy" value="<%=graduated_academy %>"></c:set>
	<c:set var="gender" value="<%=gender %>"></c:set>
	<c:set var="hobby" value="<%=hobby %>"></c:set>
	
	<form>
		<h1><%=id %>님, 회원 정보가 수정되었습니다.</h1><br />
		이름 : <input type="text" name="name" size="50" value="<%=name %>" readonly /> <br />
		ID : <input type="text" name="id" size="50" value="<%=id %>" readonly /> <br />
		패스워드 : <input type="password" name="pwd" size="50" value="<%=pwd %>" readonly /> <br />
		주소 : <input type="text" name="address" size="100" value="<%=address %>" readonly /> <br />
		
		학력 : <select name="graduated_academy" readonly>
			<c:forEach var="list" items="<%=graduatedList %>">
				<option value="${list.graduated_code}"  <c:if test ="${list.graduated_code eq graduated_academy}">selected="selected"</c:if>>${list.graduated_academy}</option>
			</c:forEach>
		</select> <br />
		
		전공 : <input type="text" name="major" size="100"  value="<%=major %>" readonly /> <br />
		
		취미 : <c:forEach var="list" items="<%=hobbyList %>">
			<input type="checkbox" name="hobby" value="${list.hobby_code}" <c:if test="${fn:contains(hobby, list.hobby_code)}" >checked="checked"</c:if> disabled />${list.hobby}
		</c:forEach><br />
		
		성별 : <input type="radio" name="gender" value="M"  <c:if test ="${gender eq 'M'}">checked="checked"</c:if> disabled />남
		<input type="radio" name="gender" value="W"  <c:if test ="${gender eq 'W'}">checked="checked"</c:if> disabled />여<br />
		
		<a href='login.html'>로그인 페이지로 이동</a> <br />
		<a href='logout.jsp'>로그아웃 페이지로 이동</a> <br />
	</form>
	
</body>
</html>