<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>EL Object Example</title>

</head>

<body>

	<%
		request.setCharacterEncoding("UTF-8");
	%>
	
	<h1>Using JSP Expression</h1>
	ID : <%=request.getParameter("id") %> <br />
	패스워드 : <%=request.getParameter("pwd") %> <br />
	
	<hr />
	
	<h1>Using Expression Language01</h1>
	ID : ${param.id} <br />
	패스워드 : ${param.pwd} <br />
	ID : ${param["id"]} <br />
	패스워드 : ${param["pwd"]} <br />
	
	<hr />
	
	<h1>Using Expression Language02</h1>
	applicationScope : ${applicationScope.application_name} <br />
	sessionScope : ${sessionScope.session_name} <br />
	requestScope : ${requestScope.request_name} <br />
	pageScope : ${pageScope.page_name} <br />
	
	<hr />
	
	${initParam.con_name} <br />
	${initParam.con_id} <br />
	${initParam.con_pwd} <br />

</body>
</html>