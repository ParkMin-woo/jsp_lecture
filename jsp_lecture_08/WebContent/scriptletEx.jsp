<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>jsp scriptlet Example</title>
</head>
<body>

	<h1>구구단 2단을 위한 scriptlet 예제</h1>
	<%
		int i = 0;
		while(true) {
			i++;
			out.println("2 * " + i + "= " + (2 * i) + "<br />");
	%>
			========================= <br />
	<%
			if(i >= 9) break;
		}
	%>

</body>
</html>