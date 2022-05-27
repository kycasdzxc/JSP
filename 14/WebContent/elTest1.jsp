<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>\${100} : ${100}</h1>
	<h1>\${"안녕하세요"} : ${"안녕하세요"}</h1>
	<h1>\${'안녕하세요'} : ${'안녕하세요'}</h1>
	<h1>\${10+1} : ${10+1}</h1>
	<h1>\${"10"+1} : ${"10"+1}</h1>
	<%-- <h1>\${null+10} : ${null+10}</h1> --%>
	<h1>\${"hello"} \${"world"} : ${"hello"}${"world"}</h1>	
	<%-- <h1>\${"안녕"+10} : ${"안녕"+1}</h1> --%>
</body>
</html>