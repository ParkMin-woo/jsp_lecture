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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>회원 수정</title>
</head>
<body>

	<%!
		ArrayList<GraduatedDTO> graduatedDTOList;
		ArrayList<HobbyDTO> hobbyDTOList;
		LoginMemberDTO retrieveLoginId;
		String graduatedAcademy;
		String hobby;
		String gender;
	%>

	<%
		request.setCharacterEncoding("UTF-8");
		String id = (String) session.getAttribute("id");
		// out.println("id => " + id);
	
		GraduatedDAO graduatedDAO = new GraduatedDAO();
		graduatedDTOList = graduatedDAO.graduatedListSelect();
	
		HobbyDAO hobbyDAO = new HobbyDAO();
		hobbyDTOList = hobbyDAO.hobbyListSelect();
	
		LoginMemberDAO loginMemberDAO = new LoginMemberDAO();
		retrieveLoginId = loginMemberDAO.retrieveLoginId(id);
		graduatedAcademy = retrieveLoginId.getGraduatedAcademy();
		hobby = retrieveLoginId.getHobby();
		gender = retrieveLoginId.getGender();
	%>
	
	<c:set var="graduatedDTOList" value="<%=graduatedDTOList %>"></c:set>
	<c:set var="hobbyDTOList" value="<%=hobbyDTOList %>"></c:set>
	<c:set var="retrieveLoginId" value="<%=retrieveLoginId %>"></c:set>
	<c:set var="graduatedAcademy" value="<%=graduatedAcademy %>"></c:set>
	<c:set var="hobby" value="<%=hobby %>"></c:set>
	<c:set var="gender" value="<%=gender %>"></c:set>
	
	<form action="modifyOK.jsp" method="post">
		이름 : <input type="text" name="name" size="50" value="<%=retrieveLoginId.getName() %>" /> <br />
		ID : <input type="text" name="id" size="50" value="<%=id %>" readonly /> <br />
		패스워드 : <input type="password" name="pwd" size="50" value="<%=retrieveLoginId.getPwd() %>" /> <br />
		주소 : <input type="text" name="address" size="100" value="<%=retrieveLoginId.getAddress() %>" /> <br />
		
		학력 : <select name="graduated_academy">
			<c:forEach var="list" items="<%=graduatedDTOList %>">
				<option value="${list.gratuatedCode}"  <c:if test ="${list.gratuatedCode eq graduatedAcademy }">selected="selected"</c:if>>${list.graduatedAcademy}</option>
			</c:forEach>
		</select> <br />
		
		전공 : <input type="text" name="major" size="100"  value="<%=retrieveLoginId.getMajor() %>" /> <br />
		
		취미 : <c:forEach var="list" items="<%=hobbyDTOList %>">
			<input type="checkbox" name="hobby" value="${list.hobbyCode}" <c:if test="${fn:contains(hobby, list.hobbyCode)}" >checked="checked"</c:if>/>${list.hobby}
		</c:forEach><br />
		
		성별 : <input type="radio" name="gender" value="M"  <c:if test ="${gender eq 'M'}">checked="checked"</c:if> />남
		<input type="radio" name="gender" value="W"  <c:if test ="${gender eq 'W'}">checked="checked"</c:if> />여<br />
		
		<input type="submit" value="회원정보수정" /> <br />
		<a href='logout.jsp'>로그아웃 페이지로 이동</a> <br />
	</form>
	
</body>
</html>