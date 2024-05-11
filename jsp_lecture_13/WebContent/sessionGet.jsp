<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>session Example</title>
</head>
<body>

	<%
		Object obj01 = session.getAttribute("mySessionName");
		String mySessionName = (String) obj01;
		out.println("mySessionName => " + mySessionName + "<br />");

		Object obj02 = session.getAttribute("myNum");
		Integer myNum = (Integer) obj02;
		out.println("myNum => " + myNum + "<br />");
		
		out.println("================================= <br />");
		
		String sName;
		String sValue;
		Enumeration enumeration = session.getAttributeNames();
		while(enumeration.hasMoreElements()) {
			sName = enumeration.nextElement().toString();
			sValue = session.getAttribute(sName).toString();
			out.println("sName => " + sName + "<br />");
			out.println("sValue => " + sValue + "<br />");
		}
		
		out.println("================================= <br />");
		
		String sessionID = session.getId();
		out.println("sessionID => " + sessionID + "<br />");
		
		int sessionInter = session.getMaxInactiveInterval();
		out.println("sessionInter => " + sessionInter + "<br />");
		
		out.println("================================= <br />");
		
		session.removeAttribute("mySessionName");
		Enumeration enumeration01 = session.getAttributeNames();
		while(enumeration01.hasMoreElements()) {
			sName = enumeration01.nextElement().toString();
			sValue = session.getAttribute(sName).toString();
			out.println("sName => " + sName + "<br />");
			out.println("sValue => " + sValue + "<br />");
		}
		
		out.println("================================= <br />");
		
		session.invalidate();
		if(request.isRequestedSessionIdValid()) {
			out.println("Session Valid. <br />");
		}
		else {
			out.println("Session inValid. <br />");
		}
	%>

</body>
</html>