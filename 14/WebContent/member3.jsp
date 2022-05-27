<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.Member"%>
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
	List<Member> members = new ArrayList<>();
	members.add(new Member("javaman", "1234", "자바맨", "email"));
	members.add(new Member("babamba", "1234", "바밤바", "email"));
	members.add(new Member("amanna", "1234", "아맛나", "email"));

	request.setAttribute("members", members);
%>
<h2>${members[0].id}</h2>
<h2>${members[0].pw}</h2>
<h2>${members[0].name}</h2>
<h2>${members[0].email}</h2>
<h2>${members[1].id}</h2>
<h2>${members[1].pw}</h2>
<h2>${members[1].name}</h2>
<h2>${members[1].email}</h2>
<h2>${members[2].id}</h2>
<h2>${members[2].pw}</h2>
<h2>${members[2].name}</h2>
<h2>${members[2].email}</h2>

<%
	// [{"a":1, "b":2}, {"a":2, "b":4}]
	List<Map<String, Object>> list = new ArrayList<>();
	Map<String, Object> map = new HashMap<>();
	map.put("a", 1);
	map.put("b", 1);
	list.add(map);
	
	map = new HashMap<>();
	map.put("a", 2);
	map.put("b", 4);
	list.add(map);
	
	request.setAttribute("list", list);
%>
<h2>${list}</h2>
<h2>${list[1].b}</h2>
<h2>${list[1]["b"]}</h2>

</body>
</html>