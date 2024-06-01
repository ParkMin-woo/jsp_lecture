<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.javalec.ex.dao.LoginMemberDAO"%>
<%@page import="com.javalec.ex.dao.HobbyDAO"%>
<%@page import="com.javalec.ex.dao.GraduatedDAO"%>
<%@page import="com.javalec.ex.dto.LoginMemberDTO"%>
<%@page import="com.javalec.ex.dto.HobbyDTO"%>
<%@page import="com.javalec.ex.dto.GraduatedDTO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% if(session.getAttribute("ValidMem") == null) { %>
	<jsp:forward page="login.jsp" />
<% } %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>회원정보 수정</title>

<script language="javascript" src="loginMembers.js"></script>

</head>
<body>

	<%!
		ArrayList<GraduatedDTO> graduatedDTOList;
		ArrayList<HobbyDTO> hobbyDTOList;
		LoginMemberDTO retrieveLoginId;
	%>

	<%
		String id = (String) session.getAttribute("id");
		// GraduatedDAO graduatedDAO = new GraduatedDAO();
		GraduatedDAO graduatedDAO = GraduatedDAO.getInstance();		// Singleton Object
		graduatedDTOList = graduatedDAO.graduatedListSelect();
	
		// HobbyDAO hobbyDAO = new HobbyDAO();
		HobbyDAO hobbyDAO = HobbyDAO.getInstance();
		hobbyDTOList = hobbyDAO.hobbyListSelect();
		
		LoginMemberDAO loginMemberDAO = LoginMemberDAO.getInstance();
		retrieveLoginId = loginMemberDAO.retrieveLoginId(id);
		String graduatedAcademy = retrieveLoginId.getGraduatedAcademy();
		String hobby = retrieveLoginId.getHobby();
		String gender = retrieveLoginId.getGender();
	%>
	
	<c:set var="graduatedAcademy" value="<%=graduatedAcademy %>"></c:set>
	<c:set var="hobby" value="<%=hobby %>"></c:set>
	<c:set var="gender" value="<%=gender %>"></c:set>
	
	<form action="modifyOK.jsp" name="modiFrm" method="post">
		이름 : <input type="text" name="name" size="50" value="<%=retrieveLoginId.getName() %>" /> <br />
		ID : <input type="text" name="id" size="50" value="<%=id %>" readonly /> <br />
		<!-- 향후 패스워드 변경 화면은 따로 만들어 보도록... -->
		패스워드 : <input type="password" name="pwd" size="50" /> <br />
		패스워드 확인 : <input type="password" name="pwdCheck" size="50" /> <br />
		주소 : <input type="text" name="address" size="100" value="<%=retrieveLoginId.getAddress() %>" /> <br />
		
		학력 : <select name="graduatedAcademy">
			<c:forEach var="list" items="<%=graduatedDTOList %>">
				<option value="${list.gratuatedCode}"  <c:if test ="${list.gratuatedCode eq graduatedAcademy}">selected="selected"</c:if>>${list.graduatedAcademy}</option>
			</c:forEach>
		</select> <br />
		
		전공 : <input type="text" name="major" size="100" value="<%=retrieveLoginId.getMajor() %>" /> <br />
		
		취미 : <c:forEach var="list" items="<%=hobbyDTOList %>">
			<input type="checkbox" name="hobby" value="${list.hobbyCode}" <c:if test="${fn:contains(hobby, list.hobbyCode)}" >checked="checked"</c:if>/>${list.hobby}
		</c:forEach><br />
		
		성별 : <input type="radio" name="gender" value="M" <c:if test ="${gender eq 'M'}">checked="checked"</c:if> />남
		<input type="radio" name="gender" value="W" <c:if test ="${gender eq 'W'}">checked="checked"</c:if> />여<br />
		
		<input type="button" value="수정하기" onclick="updateInfoConfirm()" /> <br />
		<input type="button" value="메인화면" onclick="javascript:window.location='main.jsp'" />
		<!-- <input type="reset" value="취소" onclick="javascript:window.location='login.jsp'" />
		<input type="button" value="취소" onclick="javascript:window.location='login.jsp'" /> -->
	</form>

</body>
</html>