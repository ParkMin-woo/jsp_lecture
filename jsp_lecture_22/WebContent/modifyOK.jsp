<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.javalec.ex.dao.LoginMemberDAO"%>
<%@page import="com.javalec.ex.dto.LoginMemberDTO"%>
<%@page import="java.util.Arrays"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>회원 수정</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
		String id = (String) session.getAttribute("id");
		out.println("id => " + id);
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String address = request.getParameter("address");
		String graduated_academy = request.getParameter("graduated_academy");
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
		loginMemberDTO.setGraduatedAcademy(graduated_academy);
		loginMemberDTO.setMajor(major);
		loginMemberDTO.setHobby(hobbyStr);
		loginMemberDTO.setGender(gender);
		
		LoginMemberDAO dao = new LoginMemberDAO();
		int updateLoginSql = dao.updateLoginSql(loginMemberDTO);
		
		response.setContentType("text/html; charset=utf-8");
		
		if(updateLoginSql != 0) {
			System.out.println("login_table 수정 완료");
			response.sendRedirect("modify.jsp");
		}
	%>

</body>
</html>