<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>20살 이상</title>
</head>
<body>
	<%
		int age = Integer.parseInt(request.getParameter("age"));
	%>
	<h1>나이가 <%=age %>세입니다.</h1>
	<h1>회원가입 가능합니다.</h1>
	
	<a href="requestEx.html">처음으로 이동</a>
</body>
</html>