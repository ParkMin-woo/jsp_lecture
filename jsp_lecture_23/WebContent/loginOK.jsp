<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.javalec.ex.dto.LoginMemberDTO"%>
<%@page import="com.javalec.ex.dao.LoginMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>로그인 화면</title>

<!-- <script language="javascript">
	alert("login.jsp 진입");
</script> -->

</head>

<body>

	<%
		request.setCharacterEncoding("UTF-8");
	
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		LoginMemberDAO loginMemberDAO = LoginMemberDAO.getInstance();
		int ri = loginMemberDAO.existedLoginIdSelect(id, pwd);
		
		System.out.println("로그인 결과 => " + ri);
		
		if(ri == LoginMemberDAO.MEMBER_LOGIN_SUCCESS) {
			// session.setAttribute("id", id);
			LoginMemberDTO loginMemberDTO = loginMemberDAO.retrieveLoginId(id);
			
			// 로그인 시 해킹이나 기타 다른 이유로 데이터가 유실될 수 있으므로 이전에 로그인 성공 결과로 나와도 다시 한번 검증한다.
			if(loginMemberDTO == null) {
	%>
	
		<script language="javascript">
			alert("존재하지 않는 회원입니다. \n관리자에게 문의해 주세요.");
			window.location='login.jsp';
			// history.back();	// 이건 좀 아님...;;;
		</script>
	
	<%
			} else {
				String name = loginMemberDTO.getName();
				session.setAttribute("id", id);
				session.setAttribute("name", name);
				session.setAttribute("ValidMem", "yes");
				response.sendRedirect("main.jsp");
			}
		} else {
			if(ri == LoginMemberDAO.MEMBER_LOGIN_PW_NO_GOOD) {
	%>
	
		<script language="javascript">
			alert("등록된 ID와 패스워드가 다릅니다. \n다시 로그인 해주세요.");
			window.location='login.jsp';
		</script>
		
	<%	
			} else {
	%>
	
		<script language="javascript">
			alert("존재하지 않는 회원입니다. \n회원가입부터 진행해 주세요.");
			window.location='join.jsp';
			// history.go(-1);		// 이것도 좀...;;;
		</script>
		
	<%
				
			}
		}
	%>

</body>
</html>