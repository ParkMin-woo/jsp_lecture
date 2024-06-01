<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.javalec.ex.dao.LoginMemberDAO"%>
<%@page import="com.javalec.ex.dto.LoginMemberDTO"%>
<%@page import="java.util.Arrays"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% if(session.getAttribute("ValidMem") == null) { %>
	<jsp:forward page="login.jsp" />
<% } %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>회원정보 수정</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
		String id = (String) session.getAttribute("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String address = request.getParameter("address");
		String graduatedAcademy = request.getParameter("graduatedAcademy");
		String major = request.getParameter("major");
		
		String[] hobbies = request.getParameterValues("hobby");
		String hobbyStr = Arrays.toString(hobbies).replace("[", "");
		hobbyStr = hobbyStr.replace("]", "");
		
		String gender = request.getParameter("gender");
		
		LoginMemberDTO loginMemberDTO = new LoginMemberDTO();
		
		loginMemberDTO.setName(name);
		loginMemberDTO.setId(id);
		loginMemberDTO.setPwd(pwd);
		loginMemberDTO.setAddress(address);
		loginMemberDTO.setGraduatedAcademy(graduatedAcademy);
		loginMemberDTO.setMajor(major);
		loginMemberDTO.setHobby(hobbyStr);
		loginMemberDTO.setGender(gender);
		System.out.println("loginMemberDTO => " + loginMemberDTO);
		
		LoginMemberDAO loginMemberDAO = LoginMemberDAO.getInstance();
		int updateLoginSql = loginMemberDAO.updateLoginSql(loginMemberDTO);
		
		if(updateLoginSql >= 1) {
			session.setAttribute("name", name);
	%>
	
		<script language="javascript">
			alert("회원정보가 수정되었습니다.");
			window.location='modify.jsp';
			// history.back();	// 이건 좀 아님...;;;
		</script>

	<%
		} else {
	%>
	
		<script language="javascript">
			alert("회원정보가 수정에 실패했습니다. \n관리자에게 문의하세요.");
			window.location='modify.jsp';
			// history.back();	// 이건 좀 아님...;;;
		</script>

	<%
		}
	%>

</body>
</html>