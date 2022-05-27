<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>el을 이용한 파라미터 처리</h2>
<h3>${param.id}</h3>
<h3>${param.pw}</h3>
<h3>${param.name}</h3>
<h3>${param.email}</h3>

<h2>useBean을 이용한 파라미터 바인딩</h2>
<jsp:useBean id="member" class="domain.Member" />
<jsp:setProperty property="id" name="member" param="id"/>
<jsp:setProperty property="pw" name="member" param="pwd"/>
<jsp:setProperty property="name" name="member" param="name"/>
<jsp:setProperty property="email" name="member" param="email"/>
<h2>${member}</h2>

<h2>useBean을 이용한 파라미터 바인딩2</h2>
<jsp:useBean id="member2" class="domain.Member" />
<jsp:setProperty property="*" name="member2"/>
<h2>${member2}</h2>

</body>
</html>