<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int num = 10;
		
		// EL에서 사용되는 변수는 scope의 attr이름
	%>
	<h1>el의 변수 활용</h1>
	<h2>EL : ${num}</h2>
	<h2>EL(page) : ${pageScope.num}</h2>
	<h2>EL(request) : ${requestScope.num}</h2>
	<h2>EL(session) : ${sessionScope.num}</h2>
	<h2>EL(application) : ${applicationScope.num}</h2>
	<h2>expr : <%=num %></h2>
</body>
</html>