<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>로그인 페이지</title>
</head>
<body>

	<form action="LoginOK" method="post">
		ID : <input type="text" name="id" size="50" /> <br />
		패스워드 : <input type="password" name="pwd" size="50" /> <br />
		
		<input type="submit" value="로그인" />
	</form>
</body>
</html>