<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>jsp request 객체 사용법</title>
</head>
<body>

	<%
		out.println("서버 => " + request.getServerName() + "<br />");
		out.println("포트 번호 => " + request.getServerPort() + "<br />");
		out.println("요청 방식 => " + request.getMethod() + "<br />");
		out.println("프로토콜 => " + request.getProtocol() + "<br />");
		out.println("URL => " + request.getRequestURL() + "<br />");
		out.println("URI => " + request.getRequestURI() + "<br />");
	%>

</body>
</html>