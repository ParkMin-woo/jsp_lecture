<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>page directive Example</title>
</head>
<body>

	<%
		int[] i = {10, 20, 30};
		out.println("out.println 사용 <br />");
		out.println("Elements of Array i => " + Arrays.toString(i) + "<br />");
		out.println("====================================<br />");

		out.println("Advanced for문과 expression 이용 <br />");
		for(int ie : i) {
	%>
			<%= ie %><br />
	<%
		}
	%>
	

</body>
</html>