<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.javalec.ex.dao.LoginMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>로그인 페이지</title>
</head>
<body>

	<%!
		int i;
	%>

	<%
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		session.setAttribute("id", id);
		
		LoginMemberDAO dao = new LoginMemberDAO();
		
		i = dao.existedLoginIdSelect(id, pwd);
		
		if(i == 0) {
			response.sendRedirect("main.jsp?flag=N");
		}
		else {
			response.sendRedirect("main.jsp?flag=Y");
		}
	%>
	
</body>
</html>