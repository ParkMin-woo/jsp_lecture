<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>jsp Cookie Example(get)</title>
</head>
<body>

	<%
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				String strName = cookie.getName();
				// if(strName.equals("CookieN")) {
					out.println("cookie.getName => " + strName + "<br />");
					out.println("cookie.getValue => " + cookie.getValue() + "<br />");
					out.println("============================================ <br />");
				// }
			}
		}
		else {
	%>
			<h1>생성된 쿠키가 없습니다...</h1>
	<%
		}
	%>
	
	<a href="cookieDel.jsp">cookie del로 이동</a>

</body>
</html>