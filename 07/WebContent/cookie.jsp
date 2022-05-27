<%@page import="java.net.URLDecoder"%>
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
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies) {
		out.print(cookie.getName() + "<br>");
		out.print(URLDecoder.decode(cookie.getValue(), "utf-8")  + "<br>");
	}
%>
</body>
</html>