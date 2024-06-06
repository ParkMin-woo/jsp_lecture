<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>JSTL Core Library Example</title>
</head>
<body>

	<c:set var="varName" value="varValue" />
	varName : <c:out value="${varName}" /> <br />
	<c:remove var="varName" />
	<!-- c:remove로 제거된 var를 비교해보면 빈 값(empty)이 아닌 null값으로 출력됨을 확인할 수 있다. -->
	varName : <c:out value="${varName}" />
	
	<hr />
	
	<c:catch var="error">
		<%=2/0 %>
	</c:catch>
	<br />
	<c:out value="${error}" />
	
	<hr />
	
	<c:if test="${1+2 == 3}">
		1+2 = 3
	</c:if>
	<c:if test="${1+2 != 3}">
		1+2 != 3
	</c:if>
	
	<hr />
	
	<c:forEach var="i" begin="0" end="10" step="1" >
		3 * ${i} = <c:out value="${3 * i}" /> <br />
	</c:forEach>
	
	<hr />
	
	<c:forEach var="j" begin="0" end="30" step="3" >
		${j} <br />
	</c:forEach>

</body>
</html>