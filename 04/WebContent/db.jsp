<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "student", "1234");
	PreparedStatement pstmt = conn.prepareStatement("SELECT STUDNO, NAME, DEPTNO FROM STUDENT");
	ResultSet rs = pstmt.executeQuery();
%>

	<table border="1" width="800" cellpadding="10" style="margin: 0 auto;">
	<tr>
		<th>학번</th>
		<th>이름</th>
		<th>학과번호</th>
	</tr>

<%
	while(rs.next()) {
		out.print("<tr>");
		out.print("<td>");
		out.print(rs.getInt(1));
		out.print("</td>");
		out.print("<td>");
		out.print(rs.getString(2));
		out.print("</td>");
		out.print("<td>");
		out.print(rs.getString(3));
		out.print("</td>");
		out.print("</tr>");
	}
%>
	</table>
</body>
</html>