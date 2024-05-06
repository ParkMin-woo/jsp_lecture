<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>forwardParamEx.jsp</title>
</head>
<body>

	<%!
		String name, id;
	%>
	
	<%
		/* request.setCharacterEncoding("UTF-8"); */
		/* response.setContentType("text/html; charset=UTF-8"); */
		name = request.getParameter("name");
		id = request.getParameter("id");
		/* out.println(name); */
	%>
	
	이름 : <%=URLDecoder.decode(name, "UTF-8")%> <br />
	id : <%= id %>

</body>
</html>