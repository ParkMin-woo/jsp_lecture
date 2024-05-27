<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>메인 화면</title>
</head>
<body>

	<%
		String flag = request.getParameter("flag");
		String id = (String) session.getAttribute("id");
		if(flag.equals("N")) {
			session.removeAttribute("id");
	%>
		<h1>ID와 패스워드 확인해주세요. ID 등록하지 않으셨다면 회원가입부터 해주세요.</h1> <br />
		<a href='login.jsp'>로그인 페이지로 이동</a> <br />
		<a href='join.jsp'>회원가입 페이지로 이동</a> <br />
	<%
		} else {
			// session.setAttribute("id", id);
	%>
			
			<h1><%=id %> 님 환영합니다.</h1> <br />
			<a href='modify.jsp'>회원 수정 페이지로 이동</a> <br />
			<a href='logout.jsp'>로그아웃 페이지로 이동</a> <br />
	<%
		}
	%>
	

</body>
</html>