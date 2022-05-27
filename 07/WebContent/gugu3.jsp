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
	<table>
		<tr>
			<th>${param.num} 단 출력</th>
		</tr>
		<c:forEach begin="1" end="9" var="i">
			<tr>
				<th>${param.num} * ${i}</th>
				<th>${param.num * i}</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>