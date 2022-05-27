<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>page 2</h1>
	
	<%
		// 리다이렉트
		// response.sendRedirect("https://www.naver.com");
		//response.sendRedirect("page3.jsp");
		
		// 포워드
		request.getRequestDispatcher("page3.jsp").forward(request, response);
		
	%>
</body>
</html>