<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>page 3</h1>
	<%
		request.getRequestDispatcher("page1.jsp").forward(request, response);
	%>
</body>
</html>