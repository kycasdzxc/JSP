<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여러가지 산술 연산자</h1>
	<h2>\${10+10} : ${10+10}</h2>
	<h2>\${3.14+1} : ${3.14+1}</h2>
	<h2>\${20-10} : ${20-10}</h2>
	<h2>\${10*10} : ${10*10}</h2>
	<h2>\${100/9} : ${100/9}</h2>
	<h2>\${100/0} : ${100/0}</h2>
	<h2>\${0/0} : ${0/0}</h2>
	<%-- <h2>\${100 div 9} : ${100 div 9}</h2> --%>
	<h2>\${100%9} : ${100%9}</h2>
	<h2>\${100 mod 9} : ${100 mod 9}</h2>


	<h2>\${10 eq 10} : ${10 eq 10}</h2>
	<%-- <h2>\${'10' eq 10} : ${'10' eq 10}</h2> --%>
	<h2>\${not true} : ${not true}</h2>
	
</body>
</html>