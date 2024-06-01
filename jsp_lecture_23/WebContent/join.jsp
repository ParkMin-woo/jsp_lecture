<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.javalec.ex.dao.HobbyDAO"%>
<%@page import="com.javalec.ex.dao.GraduatedDAO"%>
<%@page import="com.javalec.ex.dto.HobbyDTO"%>
<%@page import="com.javalec.ex.dto.GraduatedDTO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>회원 가입</title>

<script language="javascript" src="loginMembers.js"></script>

</head>

<!-- <script language="javascript">
	alert("join.jsp 진입");
</script> -->

<body>

	<%!
		ArrayList<GraduatedDTO> graduatedDTOList;
		ArrayList<HobbyDTO> hobbyDTOList;
	%>

	<%
		// GraduatedDAO graduatedDAO = new GraduatedDAO();
		GraduatedDAO graduatedDAO = GraduatedDAO.getInstance();		// Singleton Object
		graduatedDTOList = graduatedDAO.graduatedListSelect();
	
		// HobbyDAO hobbyDAO = new HobbyDAO();
		HobbyDAO hobbyDAO = HobbyDAO.getInstance();
		hobbyDTOList = hobbyDAO.hobbyListSelect();
	%>
	
	<%-- <c:set var="graduatedDTOList" value="<%=graduatedDTOList %>"></c:set>
	<c:set var="hobbyDTOList" value="<%=hobbyDTOList %>"></c:set> --%>
	
	<form action="joinOK.jsp" name="regFrm" method="post">
		이름 : <input type="text" name="name" size="50" /> <br />
		ID : <input type="text" name="id" size="50" /> <br />
		패스워드 : <input type="password" name="pwd" size="50" /> <br />
		패스워드 확인 : <input type="password" name="pwdCheck" size="50" /> <br />
		주소 : <input type="text" name="address" size="100" /> <br />
		
		학력 : <select name="graduatedAcademy">
			<c:forEach var="list" items="<%=graduatedDTOList %>">
			<%-- <c:forEach var="list" items="${graduatedDTOList}"> --%>
				<option value="${list.gratuatedCode}"  <c:if test ="${list.gratuatedCode eq 'two year college'}">selected="selected"</c:if>>${list.graduatedAcademy}</option>
			</c:forEach>
		</select> <br />
		
		전공 : <input type="text" name="major" size="100" /> <br />
		
		취미 : <c:forEach var="list" items="<%=hobbyDTOList %>">
			<input type="checkbox" name="hobby" value="${list.hobbyCode}" <c:if test ="${list.hobbyCode eq 'jogging'}">checked="checked"</c:if>/>${list.hobby}
		</c:forEach><br />
		
		성별 : <input type="radio" name="gender" value="M" />남
		<input type="radio" name="gender" value="W" />여<br />
		
		<input type="button" value="회원가입" onclick="insertInfoConfirm()" /> <br />
		<!-- <input type="reset" value="취소" onclick="javascript:window.location='login.jsp'" /> -->
		<input type="button" value="취소" onclick="javascript:window.location='login.jsp'" />
	</form>
	
</body>
</html>