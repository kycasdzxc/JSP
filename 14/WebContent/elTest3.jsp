<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
		int num = 10;
		/* pageContext.setAttribute("num", 20);
		request.setAttribute("num", 30);
		session.setAttribute("num", 40); */
		application.setAttribute("num", 50);
		
		List<String> list = new ArrayList<>();
		list.add("가");
		list.add("나");
		list.add("다");
		list.add("라");
		request.setAttribute("list", list);
		// EL에서 사용되는 변수는 scope의 attr이름
	%>
	<h1>el의 변수 활용</h1>
	<h2>EL : ${num}</h2>
	<h2>EL(page) : ${pageScope.num}</h2>
	<h2>EL(request) : ${requestScope.num}</h2>
	<h2>EL(session) : ${sessionScope.num}</h2>
	<h2>EL(application) : ${applicationScope.num}</h2>
	<h2>EL(application) : ${applicationScope['num']}</h2>
	<h2>EL(empty) : ${empty test}</h2>
	<h2>EL(num) : ${empty num}</h2>
	<h2>expr : <%=num %></h2>
	<hr>
	<h2>list : ${list}</h2>
	<h2>list.get(0) : ${list.get(0)}</h2>
	<h2>list[0] : ${list[0]}</h2>
	<h2>list[0].concat("아아아") : ${list[0].concat("아아아")}</h2>
	
	<%-- <jsp:forward page="elTest3_2.jsp" /> --%>
</body>
</html>