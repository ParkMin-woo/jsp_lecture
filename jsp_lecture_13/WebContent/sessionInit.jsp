<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>session Example</title>
</head>
<body>

	<%
		/*
		session.setAttribute("name", "박민우");
		session.setAttribute("id", "mwpark0930");
		*/
		session.setAttribute("mySessionName", "mySessionData");
		session.setAttribute("myNum", 12345);
	%>
	
	<a href="sessionGet.jsp">session 얻기</a>

</body>
</html>