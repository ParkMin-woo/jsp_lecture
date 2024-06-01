<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 이미 로그인을 한 상태이면 main.jsp 화면으로 이동시킨다. -->
<% if(session.getAttribute("ValidMem") != null) { %>
	<jsp:forward page="main.jsp" />
<% } %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>로그인 화면</title>

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

	<form action="loginOK.jsp" name="loginForm" method="post">
		<%-- ID : <input type="text" name="id" value="<% if(session.getAttribute("id") != null) out.println(session.getAttribute("id")); %>" size="50" /> <br /> --%>
		<!-- ID input Tag의 value값에 session이 존재할 경우 id 자동입력은 보안상 좀 어긋남...;;; -->
		<!-- 안의 scriptlet으로 java logic 구현은 좀 새로움. 하지만 c, fn 태그 쓰면 코드 가독성이 조금 높아지는 측면은 있다. -->
		ID : <input type="text" name="id" size="50" /> <br />
		패스워드 : <input type="password" name="pwd" size="50" /> <br />
		
		<input type="button" value="로그인" onclick="login()" /> <br />
		<input type="button" value="회원가입" onclick="javascript:window.location='join.jsp'" />
	</form>
	
</body>
</html>