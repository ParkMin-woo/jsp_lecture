<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>jsp request parameter Example</title>
</head>
<body>

	<!-- writer.println("이름 : " + name + "<br />");
	writer.println("아이디 : " + id + "<br />");
	writer.println("패스워드 : " + pwd + "<br />");
	writer.println("취미 : " + Arrays.toString(hobbies) + "<br />");
	writer.println("전공 : " + major + "<br />");
	writer.println("프로토콜 : " + protocol + "<br />"); -->
	<%
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String[] hobbies = request.getParameterValues("hobby");
		String major = request.getParameter("major");
		String protocol = request.getParameter("protocol");
		
		out.println("이름 : " + name + "<br />");
		out.println("아이디 : " + id + "<br />");
		out.println("비밀번호 : " + pwd + "<br />");
		out.println("취미 : " + Arrays.toString(hobbies) + "<br />");
		out.println("전공 : " + major + "<br />");
		out.println("프로토콜 : " + protocol + "<br />");
	%>

</body>
</html>