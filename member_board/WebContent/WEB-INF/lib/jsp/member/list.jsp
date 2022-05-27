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
	<div>
		<c:if test="${empty member}">
		<p>로그인 하지 않은 상태</p>
		<a href="${pageContext.request.contextPath}/member/login">로그인 하러 가기</a>
		</c:if>
		<c:if test="${not empty member}">
		<p>로그인 한 상태</p>
		<p>${member.name}님 환영합니다</p>
		<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
		</c:if>
	</div>
	<div>
		<form>
			<input type="text" name="keyword"><button>검색</button>
		</form>
	</div>
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>가입일</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${members}" var="member">
		<tr>
			<td>${member.id}</td>
			<td>${member.pwd}</td>
			<td>${member.name}</td>
			<td>${member.email}</td>
			<td>${member.joinDate}</td>
			<td><a href="remove?id=${member.id}">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
		<a href="${pageContext.request.contextPath}/member/register">회원 등록</a>
</body>
</html>