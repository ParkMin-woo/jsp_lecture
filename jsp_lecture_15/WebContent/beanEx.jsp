<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>jsp Bean Example</title>
</head>
<body>

	<!-- 자바 빈 선언 -->
	<jsp:useBean id="student" class="com.javalec.ex.StudentDTO" scope="page" />

	<!-- 
	private String name;
	private int age;
	private int grade;
	private int studentNum;
	 -->
	<jsp:setProperty name="student" property="name" value="박민우" />
	<jsp:setProperty name="student" property="age" value="22" />
	<jsp:setProperty name="student" property="grade" value="1" />
	<jsp:setProperty name="student" property="studentNum" value="20113311" />
	
	이름 : <jsp:getProperty name="student" property="name"  /> <br />
	나이 : <jsp:getProperty name="student" property="age"  /> <br />
	학년 : <jsp:getProperty name="student" property="grade"  /> <br />
	학번 : <jsp:getProperty name="student" property="studentNum"  /> <br />

</body>
</html>