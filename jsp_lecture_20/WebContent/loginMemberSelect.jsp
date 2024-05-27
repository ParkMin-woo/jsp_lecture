<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.javalec.ex.dto.LoginMemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javalec.ex.dao.LoginMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Connection Pool 객체만 따로 생성하는 Class 생성 Example</title>
</head>
<body>

	<%
		LoginMemberDAO dao = new LoginMemberDAO();
		ArrayList<LoginMemberDTO> dtoList = dao.loginMemberSelect(); // new ArrayList<LoginMemberDTO>();
		
		for(LoginMemberDTO dto : dtoList) {
			int seq = dto.getSeq();
			String id = dto.getId();
			String pwd = dto.getPwd();
			String name = dto.getName();
			String address = dto.getAddress();
			String graduatedAcademy = dto.getGraduatedAcademy();
			String major = dto.getMajor();
			String hobby = dto.getHobby();
			String gender = dto.getGender();
			
			out.println("순번 : " + seq + ", ID : " + id + ", 비밀번호 : " + pwd + ", 이름 : " + name + ", 주소 : " + address + ", 최종학력 : " + graduatedAcademy + ", 전공 : " + major + ", 취미 : " + hobby + ", 성별 : " + gender + "<br />");
		}
		
		// out.close();
	%>
</body>
</html>