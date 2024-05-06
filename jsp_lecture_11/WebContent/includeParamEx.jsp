<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>includeParamEx.jsp</title>
</head>
<body>

	<%!
		String name, id;
	%>

	<%
		name = request.getParameter("name");
		id = request.getParameter("id");
	%>
	
	<h1>includeParamEx.jsp입니다.</h1>
	이름 : <%= name %> <br />
	id : <%= id %>

</body>
</html>