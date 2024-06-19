<?xml version="1.0" encoding="UTF-8" ?>

<%@page import="com.javalec.ex.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>게시글 상세 조회</title>

</head>

<script language="javascript">

function updateBoardView() {

	document.contentForm.submit();
	
}

function boardAllSearch() {
	
	window.location = "list.do";
	
}

function deleteBoard() {
	
	alert("삭제되었습니다.");
	window.location = "delete.do?bId=${boardContent.bId}";
	
}

function insertReplyView() {
	
	window.location = "reply_view.do?bId=${boardContent.bId}";
	
}

</script>

<body>

	<%-- <c:out value="${boardContent}" /> <br />
	<c:out value="${ri}" /> --%>
	<!-- <input type="button" value="전체 게시글 조회" onclick="javascript:window.location='list.do'" /> -->
	<form action="modify_view.do" name="contentForm" method="post">
	<input type="hidden" name="bId" value="${boardContent.bId}" />
	<input type="hidden" name="bName" value="${boardContent.bName}" />
	<input type="hidden" name="bTitle" value="${boardContent.bTitle}" />
	<input type="hidden" name="bContent" value="${boardContent.bContent}" />
	<input type="hidden" name="bGroup" value="${boardContent.bGroup}" />
	<input type="hidden" name="bStep" value="${boardContent.bStep}" />
	<input type="hidden" name="bIndent" value="${boardContent.bIndent}" />
	
		<table width="500" cellpadding="0" border="1">
			<tr>
				<td>번호</td>
				<td><input type="text" name="bId" value="${boardContent.bId}" size="50" readonly="readonly" /></td>
				<%-- <td id="bId">${boardContent.bId}</td> --%>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName" value="${boardContent.bName}" size="50" readonly="readonly" /></td>
				<%-- <td id="bName">${boardContent.bName}</td> --%>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" value="${boardContent.bTitle}" size="50" readonly="readonly" /></td>
				<%-- <td id="bTitle">${boardContent.bTitle}</td> --%>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="bContent" readonly="readonly">${boardContent.bContent}</textarea></td>
				<%-- <td id="bContent">${boardContent.bContent}</td> --%>
			</tr>
			<tr>
				<td colspan="2">
					<%-- <input type="button" value="수정하기" onclick="javascript:window.location='modify_view.do?bId=${boardContent.bId}'" /> <br /> --%>
					<input type="button" value="수정하기" onclick="updateBoardView()" /> <br />
					<%-- <input type="button" value="삭제하기" onclick="javascript:window.location='delete.do?bId=${boardContent.bId}'" /> <br /> --%>
					<input type="button" value="삭제하기" onclick="deleteBoard()" <c:if test ="${remainCnt ne 1}">disabled</c:if> /> <br />
					<input type="button" value="답글쓰기" onclick="insertReplyView()" <c:if test ="${replyCnt ne 1}">disabled</c:if>  /> <br />
					<!-- <input type="button" value="수정하기" onclick="updateBoardView()" /> <br /> -->
					<input type="button" value="전체 게시글 조회" onclick="boardAllSearch()" />
				</td>
			</tr>
		</table>
	</form>

</body>
</html>