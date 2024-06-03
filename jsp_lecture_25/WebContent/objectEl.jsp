<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>EL Object Example</title>

<script language="javascript">
function login() {

	if(document.loginForm.id.value.length == 0) {
		alert("ID를 입력해 주세요.");
		loginForm.id.focus();
		return;
	}
	
	if(document.loginForm.pwd.value.length == 0) {
		alert("비밀번호를 입력해 주세요.");
		loginForm.pwd.focus();
		return;
	}
	
	document.loginForm.submit();
	
}
</script>

</head>

<body>
	
	<form action="objectElOK.jsp" name="loginForm" method="post">
		ID : <input type="text" name="id" size="50" /> <br />
		패스워드 : <input type="password" name="pwd" size="50" /> <br />
		
		<input type="button" value="로그인" onclick="login()" /> <br />
	</form>
	
	<%
		application.setAttribute("application_name", "application_value");
		session.setAttribute("session_name", "session_value");
		pageContext.setAttribute("page_name", "page_value");
		request.setAttribute("request_name", "request_value");
	%>

</body>
</html>