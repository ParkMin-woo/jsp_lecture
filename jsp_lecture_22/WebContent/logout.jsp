<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>로그아웃</title>
</head>
<body>

	<%
		String id = (String) session.getAttribute("id");
	%>
	
	<h1><%=id %>님, 안녕히 가십시오.</h1><br />

	<%
		session.removeAttribute("id");
	%>
	<a href='login.jsp'>로그인 페이지로 이동</a> <br />
	
</body>
</html>