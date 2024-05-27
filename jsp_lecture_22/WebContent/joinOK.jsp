<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.javalec.ex.dto.LoginMemberDTO"%>
<%@page import="com.javalec.ex.dao.LoginMemberDAO"%>
<%@page import="java.util.Arrays"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>회원 가입</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		
		String name = request.getParameter("name");
		// String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String address = request.getParameter("address");
		String graduatedAcademy = request.getParameter("graduated_academy");
		String major = request.getParameter("major");
		
		String[] hobbies = request.getParameterValues("hobby");
		String hobbyStr = Arrays.toString(hobbies).replace("[", "");
		hobbyStr = hobbyStr.replace("]", "");
		
		String gender = request.getParameter("gender");
		
		LoginMemberDAO dao = new LoginMemberDAO();
		int i = dao.duplicateIdSelect(id);
		
		response.setContentType("text/html; charset=utf-8");
		
		if(i == 0) {
			int maxSeq = dao.getMaxSeq();
			System.out.println("maxSeq => " + maxSeq);
			
			LoginMemberDTO loginMemberDTO = new LoginMemberDTO();
			loginMemberDTO.setSeq(maxSeq);
			loginMemberDTO.setId(id);
			loginMemberDTO.setPwd(pwd);
			loginMemberDTO.setName(name);
			loginMemberDTO.setAddress(address);
			loginMemberDTO.setGraduatedAcademy(graduatedAcademy);
			loginMemberDTO.setSeq(maxSeq);
			loginMemberDTO.setMajor(major);
			loginMemberDTO.setHobby(hobbyStr);
			loginMemberDTO.setGender(gender);
			
			int insertLoginSql = dao.insertLoginSql(loginMemberDTO);
			
			if(insertLoginSql != 0) {
				System.out.println("login_table 등록 완료");
				response.sendRedirect("login.jsp");
			}
		}
		else {
			PrintWriter writer = response.getWriter();
			writer.print("<html>");
			writer.print("<head>");
			writer.print("</head>");
			writer.print("<body>");
			writer.print(id + "가 존재합니다. 다른 ID를 입력해 주세요. <br />");
			writer.print("<a href='join.jsp'>회원가입 페이지로 이동</a>");
			writer.print("</body>");
			writer.print("</html>");
			writer.close();
			return;
		}
	%>

</body>
</html>