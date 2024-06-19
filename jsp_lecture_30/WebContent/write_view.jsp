<?xml version="1.0" encoding="UTF-8" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>게시글쓰기</title>
</head>

<script language="javascript">
function writeBoard() {

	if(document.writeForm.bName.value == "") {
		alert("이름을 입력해 주세요.");
		writeForm.bName.focus();
		return;
	}

	if(document.writeForm.bTitle.value == "") {
		alert("제목을 입력해 주세요.");
		writeForm.bTitle.focus();
		return;
	}
	
	if(document.writeForm.bContent.value == "") {
		alert("내용을 입력해 주세요.");
		writeForm.bContent.focus();
		return;
	}
	
	alert("등록되었습니다.");
	// window.location = "write.do";
	document.writeForm.submit();
	
}

function boardAllSearch() {
	
	var confirm = window.confirm("게시판 목록으로 돌아갈 경우 게시글이 저장되지 않습니다.\n목록으로 돌아가시겠습니까?");
	
	console.log("[confirm]    " , confirm);
	
	if(confirm) {
		window.location = "list.do";
	}
	
	// window.location = "list.do";
	
}
</script>

<body>

	<form action="write.do" name="writeForm" method="post">
		<table width="500" cellpadding="0" border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName" size="50" /></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" size="50" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="bContent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="입력" onclick="writeBoard()" /> <br />
					<input type="button" value="전체 게시글 조회" onclick="boardAllSearch()" />
				</td>
			</tr>
		
		</table>
	</form>

</body>
</html>