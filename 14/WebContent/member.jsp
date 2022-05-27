<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="domain.Member"%>
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
	Member member = new Member("javaman", "1234", "자바맨", "javaman@gmail.com");
	// System.out.println(member);



	request.setAttribute("men", member);
	
	Gson gson = new Gson();
	String jsonStr = gson.toJson(member);
	// System.out.println(jsonStr);
	
	Member member2 = gson.fromJson(jsonStr, Member.class);
	System.out.println(member2);
	
	Map<String, Object> map = gson.fromJson(jsonStr, HashMap.class);
	// System.out.println(map);
	
%>
<h2>${men}</h2>
<h2>${men.id}</h2>
<h2>${men.pw}</h2>
<h2>${men.name}</h2>
<h2>${men.email}</h2>
</body>
</html>