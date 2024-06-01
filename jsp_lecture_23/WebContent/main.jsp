<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 로그아웃 상태에서 들어왔으면 로그인 페이지로 이동시킨다. -->
<% if(session.getAttribute("ValidMem") == null) { %>
	<jsp:forward page="login.jsp" />
<% } %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>메인 화면</title>

<script language="javascript">
function updateInfoConfirm() {

	window.location='modify.jsp';
	
}
</script>

</head>
<body>

	<%!
		String id;
		String name;
	%>
	
	<%
		id = (String) session.getAttribute("id");
		name = (String) session.getAttribute("name");
	%>

	<h1><%=name %>님, 환영합니다.</h1><br />
		
	<input type="button" value="회원정보 수정" onclick="updateInfoConfirm()" /> <br />
	<input type="button" value="로그아웃" onclick="javascript:window.location='logout.jsp'" />

</body>
</html>