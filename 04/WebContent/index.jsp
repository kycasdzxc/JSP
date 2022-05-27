<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello world</h1>
	<%
		int num = 10;
		for(int i = 2 ; i <= 9 ; i++) {
			for(int j = 1 ; j <= 9 ; j++) {
				out.write(i + "*" + j + "=" + i*j + "<br>");
			}
		}
	%>
	<h1>안녕 세상</h1>
</body>
</html>