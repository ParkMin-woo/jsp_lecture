<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>게시글 수정</title>
</head>

<script language="javascript">
function updateBoard() {
	
	alert("수정되었습니다.");
	// window.location = "write.do";
	document.modifyForm.submit();
	
}
</script>

<body>

	<form action="modify.do" name="modifyForm" method="post">
	<input type="hidden" name="bId" value="<%=session.getAttribute("bId") %>" />
	
		<table width="500" cellpadding="0" border="1">
			<tr>
				<td>번호</td>
				<td><%=session.getAttribute("bId") %></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><%=session.getAttribute("bName") %></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><%=session.getAttribute("bTitle") %></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="bContent"><%=session.getAttribute("bContent") %></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="수정하기" onclick="updateBoard()" /> <br />
					<!-- <input type="button" value="전체 게시글 조회" onclick="boardAllSearch()" /> -->
				</td>
			</tr>
		</table>
	</form>

</body>
</html>