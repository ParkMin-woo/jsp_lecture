<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>jsp Cookie Example(set)</title>
</head>
<body>

	<%
		Cookie cookie1 = new Cookie("CookieN" , "CookieV");
		Cookie cookie2 = new Cookie("name" , "박민우");
		Cookie cookie3 = new Cookie("id" , "mwpark0930");
		cookie1.setMaxAge(60 * 60);	// 1시간으로 쿠키 지속시간을 정한다.
		cookie2.setMaxAge(60 * 60);
		cookie3.setMaxAge(60 * 60);
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
	%>
	
	<a href="cookieGet.jsp">cookie get으로 이동</a>

</body>
</html>