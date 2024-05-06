<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>age로 받은 변수 확인</title>
</head>
<body>

	<%!
		int age;
	%>

	<%
		age = Integer.parseInt(request.getParameter("age"));
	
		if(age >= 20) {
			response.sendRedirect("pass.jsp?age=" + age);
		}
		else {
			response.sendRedirect("fail.jsp?age=" + age);
		}
	
	%>

</body>
</html>