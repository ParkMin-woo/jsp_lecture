<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Session을 이용한 login Example</title>
</head>
<body>

	<%

		Enumeration enumeration = session.getAttributeNames();
		int i = 0;
		while(enumeration.hasMoreElements()) {
			i++;
			
			String sName = enumeration.nextElement().toString();
			String sValue = session.getAttribute(sName).toString();
			
			out.println("sName => " + sName + "<br />");
			out.println("sValue => " + sValue + "<br />");
		}
		if(i==0) out.println("해당 세션이 삭제되었습니다. <br />");
	
	%>

</body>
</html>