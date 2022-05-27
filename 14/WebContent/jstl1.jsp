<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
	request.setAttribute("request", request);
%> --%>
<form method="post">
	<button formmethod="get">GET 전송</button>
	<button>POST 전송</button>
</form>
<h2><%=request.getMethod() %></h2>
<h2>${request.getMethod()}</h2>
<h2>${request.method}</h2>
<h2>${pageContext.request.method}</h2>
<!-- c:if를 이용해 GET > 겟 출력, POST 포스트 출력 -->
<c:if test="${pageContext.request.method == 'GET'}">
	<h2>겟</h2>
</c:if>
<c:if test="${pageContext.request.method == 'POST'}">
	<h2>포스트</h2>
</c:if>
<c:choose>
	<c:when test="${pageContext.request.method == 'GET'}">
		<h2>겟</h2>
	</c:when>
	<c:when test="${pageContext.request.method == 'POST'}">
		<h2>포스트</h2>
	</c:when>
	<%-- <c:otherwise>
		<h2>포스트</h2>
	</c:otherwise> --%>
</c:choose>
</body>
</html>