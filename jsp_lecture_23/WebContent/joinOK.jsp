<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.Arrays"%>
<%@page import="com.javalec.ex.dao.LoginMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="loginMemberDTO" class="com.javalec.ex.dto.LoginMemberDTO" />
<jsp:setProperty name="loginMemberDTO" property="*" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>회원 가입</title>

<!-- <script language="javascript">
	alert("joinOK.jsp 화면입니다.");
</script> -->

</head>
<body>

	<%
		String id = request.getParameter("id");
	
		String[] hobbies = request.getParameterValues("hobby");
		String hobbyStr = Arrays.toString(hobbies).replace("[", "");
		hobbyStr = hobbyStr.replace("]", "");
		
		loginMemberDTO.setHobby(hobbyStr);
		
		LoginMemberDAO loginMemberDAO = LoginMemberDAO.getInstance();
		int maxSeq = loginMemberDAO.getMaxSeq();
		loginMemberDTO.setSeq(maxSeq);
		if(loginMemberDAO.duplicateIdSelect( id/* loginMemberDTO.getId() */ ) == LoginMemberDAO.MEMBER_EXISTENT) {
	%>
	
		<script language="javascript">
			alert("이미 존재하는 ID입니다. \n다른 ID를 입력해 주세요.");
			window.location='join.jsp';
			// history.back();	// 이건 좀 아님...;;;
		</script>

	<%
			// response.sendRedirect("join.jsp");
			// 해당 코드는 바로 redirect되는 callback 함수 느낌???
		} else {
			System.out.println("request에서 가져온 id값과 dto에서 가져온 id값 서로 비교해보기");
			System.out.println(id == loginMemberDTO.getId());
			/*
			out.println("이름 => " + loginMemberDTO.getName());
			out.println("ID => " + loginMemberDTO.getId());
			out.println("패스워드 => " + loginMemberDTO.getPwd());
			out.println("주소 => " + loginMemberDTO.getAddress());
			out.println("학력 => " + loginMemberDTO.getGraduatedAcademy());
			out.println("전공 => " + loginMemberDTO.getMajor());
			out.println("취미 => " + loginMemberDTO.getHobby());
			out.println("성별 => " + loginMemberDTO.getGender());
			*/
			
			int ri = loginMemberDAO.insertLoginSql(loginMemberDTO);
			if(ri == LoginMemberDAO.MEMBER_JOIN_SUCCESS) {
				// session.setAttribute("id" , id);		// 회원가입만 했는데, session에 id값 넣는건 현재 안하고 있는 기법으로 알고있음.
	%>
	
		<script language="javascript">
			alert("회원가입을 축하합니다.");
			window.location='login.jsp';
			// history.back();	// 이건 좀 아님...;;;
		</script>

	<%
			} else {
	%>
	
		<script language="javascript">
			alert("회원가입에 실패했습니다.");
			window.location='join.jsp';
		</script>

	<%
			}
		}
	%>

</body>
</html>