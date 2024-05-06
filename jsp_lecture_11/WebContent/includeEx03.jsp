<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>includeEx03.jsp</title>
</head>
<body>

	<!-- 한글 깨져보이는 사항 찾아서 개선할 것 -->
	<jsp:include page="includeParamEx.jsp" flush="true" >
		<jsp:param name="name" value="MinWoo Park" />
		<jsp:param name="id" value="mwpark0930" />
	</jsp:include>

</body>
</html>