<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>입력한 아이디 : ${param.user_id}</h1>
	<h1>입력한 비밀번호 : ${param.user_pw}</h1>
	<h1>입력한 과목선택 : ${Arrays.toString(paramValues.subject)}</h1>
</body>
</html>