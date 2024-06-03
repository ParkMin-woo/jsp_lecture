<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>elOperator example</title>
</head>
<body>
	
	<h1>EL 표기법(연산자)</h1>
	${ 1+2 }<br />
	${ 1-2 }<br />
	${ 2 * 5 }<br />
	${ 3/4 }<br />
	${ 1>2 }<br />
	${ 1<2 }<br />
	${ (1>2) ? 1 : 2 }<br />
	${ (1>2) || (1<2) }<br />
	${ (1 < 2) && (4 > 3) }<br />
	${ (1 < 2) && (3 > 4) }<br />
	
	<hr />
	
	<h1>JSP Expression 표기법(연산자)</h1>
	<%= 1+2 %><br />
	<%= 1-2 %><br />
	<%= 2 * 5 %><br />
	<%= 3/4 %><br />
	<%= 1>2 %><br />
	<%= 1<2 %><br />
	<%= (1>2) ? 1 : 2 %><br />
	<%= (1>2) || (1<2) %><br />
	<%= (1 < 2) && (4 > 3) %><br />
	<%= (1 < 2) && (3 > 4) %><br />

</body>
</html>