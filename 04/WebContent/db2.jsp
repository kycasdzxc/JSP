<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="800" cellpadding="10" style="margin: 0 auto;">
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>학과번호</th>
			<th>핫하</th>
		</tr>
		
		<c:forEach items="${students}" var="s">
		<tr>
			<td>${s.studno}</td>
			<td>${s.name}</td>
			<td>${s.deptno}</td>
			<td>${s.getTest()}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>