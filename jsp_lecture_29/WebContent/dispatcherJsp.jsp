<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>RequestDispatcher Example</title>
</head>
<body>

	<h1>dispatcherJsp.jsp</h1>
	
	<hr />
	
	id : <%=request.getAttribute("id") %> <br />
	패스워드 : <%=request.getAttribute("pwd") %>
	
<%-- 	<%
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	%> --%>

</body>
</html>