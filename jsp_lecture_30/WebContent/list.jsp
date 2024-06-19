<?xml version="1.0" encoding="UTF-8" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>게시글조회</title>
</head>
<body>

	<table width="750" cellpadding="0" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>게시일</td>
			<td>수정일</td>
			<td>조회수</td>
		</tr>
		<!-- boardList는 request의 attribute에 담겨져 있음. -->
		<%-- scriptlet이나 expression 또는 <c:set ~ >으로 불러오지 않아도 --%>
		<!-- jsp에서 자동으로 인식해주는 것 같음 -->
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td>${board.bId}</td>
				<td>${board.bName}</td>
				<%-- <td>${board.bTitle}</td> --%>
				<td>
					<c:forEach begin="1" end="${board.bIndent}">-</c:forEach>
					<a href="content_view.do?bId=${board.bId}">${board.bTitle}</a>
				</td>
				<td>${board.bRegistDate}</td>
				<td>${board.bUpdateDate}</td>
				<td>${board.bHit}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6">
				<a href="write_view.do">글작성</a>
			</td>
		</tr>
	
	</table>

</body>
</html>