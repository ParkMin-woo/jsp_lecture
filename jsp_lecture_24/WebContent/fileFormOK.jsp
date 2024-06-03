<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>File Upload Example</title>

</head>
<body>

	<%
		String path = request.getRealPath("fileFolder");
	
		int size = 1024 * 1024 * 10;	// 10M
		String file = "";
		String originFile = "";
		
		try {
			MultipartRequest multi = new MultipartRequest(request , path, size, "UTF-8", new DefaultFileRenamePolicy());
			
			Enumeration files = multi.getFileNames();
			String str = (String) files.nextElement();
			
			file = multi.getFilesystemName(str);
			originFile = multi.getOriginalFileName(str);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	%>
	
	<h1>File Upload Success!</h1> <br />
	<input type="button" value="파일 업로드로 다시 가기" onclick="javascript:window.location='fileForm.jsp'" />

</body>
</html>