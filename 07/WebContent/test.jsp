<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test.jsp</h1>
	<h2>${param.val}</h2>
	<h2><%=request.getParameter("val") %></h2>
	<%@ include file="test2.jsp" %>
	<jsp:include page="test2.jsp">
		<jsp:param value="100" name="val"/>
	</jsp:include>
	<iframe src="test2.jsp"></iframe>
	<jsp:forward page="test2.jsp"></jsp:forward>
</body>
</html>