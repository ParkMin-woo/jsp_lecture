<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>File Upload Example</title>

<!-- <script language="javascript">
function fileUpload() {
	
	document.fileUpload.submit();
	
}
</script>
 -->
</head>
<body>

	<!-- enctype="multipart/form-data" 파일이 정상적으로 첨부가 되어서 서버쪽으로 송신할 수 있다. -->
	<form action="fileFormOK.jsp" name="fileUpload" method="post" enctype="multipart/form-data">
		파일 : <input type="file" name="file" /> <br />
		<input type="submit" value="File Upload" />
	</form>

</body>
</html>