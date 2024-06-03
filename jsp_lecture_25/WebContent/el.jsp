<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>el example</title>
</head>
<body>

	<%!
		String id;
	%>

	<%
		id = "mwpark0930";
	%>
	
	<h1><%=id %> 님 환영합니다.</h1>
	
	${10}<br />
	${99.99}<br />
	${"ABC"}<br />
	${true}<br />
	${id}<br />
	
	<%-- <form>
		ID : <input type="text" name="id" size="50" value="${id}" readonly /> <br />
	</form> --%>

</body>
</html>