<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>jsp declaration Example</title>
</head>
<body>
	<h1>jsp declaration Example</h1>
	
	<%!
		int i = 4;
		String str1 = "ABCD";
		String str2 = "박민우";
		
		public int sum(int x, int y) {
			return x + y;
		}
	%>
	
	<%
		out.println("i => " + i + "<br />");
		out.println("str1 => " + str1 + "<br />");
		out.println("str2 => " + str2 + "<br />");
		out.println("sum => " + sum(3, 4) + "<br />");
	%>
</body>
</html>