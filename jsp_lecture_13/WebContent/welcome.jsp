<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Session을 이용한 login Example</title>
</head>
<body>

	<%
		String sName;
		String sValue;
		Enumeration enumeration = session.getAttributeNames();
		while(enumeration.hasMoreElements()) {
			sName = enumeration.nextElement().toString();
			sValue = session.getAttribute(sName).toString();
			if(sValue.equals("pd0a6645")) {
				/*
				out.println("sName => " + sName + "<br />");
				out.println("sValue => " + sValue + "<br />");
				*/
				out.println(sValue + "님, 환영합니다!<br />");
			}
		}
		
	%>
	
	<a href="logout.jsp">로그아웃</a>

</body>
</html>