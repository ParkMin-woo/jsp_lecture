<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Cookie를 이용한 login example</title>
</head>
<body>

	<%!
		String id;
	%>

	<%
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("id")) {
					id = cookie.getValue();
					if(id.equals("pd0a6645")) out.println(id + "님, 환영합니다! <br />");
				}
			}
		}
		else {
	%>
		<h1>정상적인 방법으로 접근해 주세요.</h1>
	<%
		response.sendRedirect("login.html");
		}
	%>
	
	<%-- <h1><%= id %>님, 환영합니다!</h1> --%>
	<a href="cookieTest.jsp">쿠키 테스트로 이동</a>

</body>
</html>