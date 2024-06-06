<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Controller Example</title>
</head>
<body>

	<a href="insert.do">insert</a>
	<hr/>
	<a href="http://localhost:8100<%=request.getContextPath() %>/update.do">update</a>
	<hr/>
	<a href="http://localhost:8100/jsp_lecture_27/select.do">select</a>
	<hr/>
	<a href="<%=request.getContextPath() %>/delete.do"">delete</a>
	<hr/>

</body>
</html>