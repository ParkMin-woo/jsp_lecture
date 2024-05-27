<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.javalec.ex.dao.GraduatedDAO"%>
<%@page import="com.javalec.ex.dto.GraduatedDTO"%>
<%@page import="com.javalec.ex.dto.HobbyDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javalec.ex.dao.HobbyDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>회원 가입</title>
</head>
<body>

	<%!
		ArrayList<GraduatedDTO> graduatedDTOList;
		ArrayList<HobbyDTO> hobbyDTOList;
	%>

	<%
		GraduatedDAO graduatedDAO = new GraduatedDAO();
		graduatedDTOList = graduatedDAO.graduatedListSelect();
	
		HobbyDAO hobbyDAO = new HobbyDAO();
		hobbyDTOList = hobbyDAO.hobbyListSelect();
	%>
	
	<c:set var="graduatedDTOList" value="<%=graduatedDTOList %>"></c:set>
	<c:set var="hobbyDTOList" value="<%=hobbyDTOList %>"></c:set>
	
	<form action="JoinOK" method="post">
		이름 : <input type="text" name="name" size="50" /> <br />
		ID : <input type="text" name="id" size="50" /> <br />
		패스워드 : <input type="password" name="pwd" size="50" /> <br />
		주소 : <input type="text" name="address" size="100" /> <br />
		
		학력 : <select name="graduated_academy">
			<c:forEach var="list" items="<%=graduatedDTOList %>">
				<option value="${list.gratuatedCode}"  <c:if test ="${list.gratuatedCode eq 'two year college'}">selected="selected"</c:if>>${list.graduatedAcademy}</option>
			</c:forEach>
		</select> <br />
		
		전공 : <input type="text" name="major" size="100" /> <br />
		
		취미 : <c:forEach var="list" items="<%=hobbyDTOList %>">
			<input type="checkbox" name="hobby" value="${list.hobbyCode}" <c:if test ="${list.hobbyCode eq 'jogging'}">checked="checked"</c:if>/>${list.hobby}
		</c:forEach><br />
		
		성별 : <input type="radio" name="gender" value="M" />남
		<input type="radio" name="gender" value="W" />여<br />
		
		<input type="submit" value="회원가입" /> <br />
		<input type="reset" value="초기화" />
	</form>
	
</body>
</html>