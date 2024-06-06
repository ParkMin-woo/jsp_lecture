<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>HttpServletResponse Example</title>
</head>
<body>

	<%
		request.setAttribute("id", "id_value");
		request.setAttribute("pwd", "pwd_value");
		
		response.sendRedirect("RequestObj2");
		// response.sendRedirect("RequestObj2?id="+request.getAttribute("id")+"&pwd="+request.getAttribute("pwd"));
	%>

</body>
</html>