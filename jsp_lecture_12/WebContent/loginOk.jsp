<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Cookie를 이용한 login example</title>
</head>
<body>

	<%!
		String id, pwd;
	%>
	
	<%
		id = request.getParameter("id");
		pwd = request.getParameter("pwd");
		
		
		if(id.equals("pd0a6645") && pwd.equals("roqkf12!")) {
			Cookie cookie1 = new Cookie("id" , id);
			Cookie cookie2 = new Cookie("pwd" , pwd);
			cookie1.setMaxAge(60 * 60);
			cookie2.setMaxAge(60 * 60);
			
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.sendRedirect("welcome.jsp");
		}
		else {
			response.sendRedirect("login.html");
		}
		
		/*
		Cookie cookie1 = new Cookie("id" , id);
		Cookie cookie2 = new Cookie("pwd" , pwd);
		cookie1.setMaxAge(60 * 60);
		cookie2.setMaxAge(60 * 60);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		*/
	%>

</body>
</html>