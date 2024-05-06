<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>includeEx01.jsp 페이지입니다.</title>
</head>
<body>
	<h1>includeEx01.jsp입니다.</h1>
	<jsp:include page="includeEx02.jsp" flush="true" />
	<h1>다시 includeEx01.jsp입니다.</h1>
</body>
</html>