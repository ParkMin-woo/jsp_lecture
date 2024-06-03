<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.javalec.ex.dto.LoginMemberDTO"%>
<%@page import="com.javalec.ex.dao.LoginMemberDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="loginMemberDTO" class="com.javalec.ex.dto.LoginMemberDTO" scope="page" />
<jsp:setProperty name="loginMemberDTO" property="name" value="유희영" />
<jsp:setProperty name="loginMemberDTO" property="id" value="ironlady" />
<jsp:setProperty name="loginMemberDTO" property="pwd" value="roqkf12#" />
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Comparison between EL and JSP Action Tag</title>

</head>
<body>
	
	<%-- <%!
		LoginMemberDTO loginMemberDTO;
	%> --%>

	<%
		request.setCharacterEncoding("UTF-8");
		
		LoginMemberDAO loginMemberDAO = LoginMemberDAO.getInstance();
		loginMemberDTO = loginMemberDAO.retrieveLoginId("mwpark0930");
		
		System.out.println("로그인 결과 => " + loginMemberDTO.toString());
	%>
	
	<h1>Using JSP Action Tag</h1>
	이름 : <jsp:getProperty name="loginMemberDTO" property="name" /> <br />
	ID : <jsp:getProperty name="loginMemberDTO" property="id" /> <br />
	패스워드 : <jsp:getProperty name="loginMemberDTO" property="pwd" /> <br />
	
	<hr />
	
	<!-- loginMemberDTO는 scriptlet의 변수가 아닌 jsp:useBean Action Tag의 id값 -->
	<h1>Using EL</h1>
	이름 : ${loginMemberDTO.name} <br />
	ID : ${loginMemberDTO.id} <br />
	패스워드 : ${loginMemberDTO.pwd} <br />

</body>
</html>