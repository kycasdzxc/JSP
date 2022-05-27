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
<jsp:useBean id="member" class="domain.Member" scope="request" />
<jsp:setProperty name="member" property="id" value="babamba" />
<jsp:setProperty name="member" property="pw" value="1234" />
<jsp:setProperty name="member" property="name" value="바밤바" />

<h2>${member.id}</h2>
<h2><%=member.getId()%></h2>
<h2><jsp:getProperty property="id" name="member"/></h2>
<h2><c:out value="${member.id}" /></h2>
</body>
</html>