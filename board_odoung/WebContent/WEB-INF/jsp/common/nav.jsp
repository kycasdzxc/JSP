<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="${pageContext.request.contextPath}/board/list"><i class="fab fa-500px"></i> Odoung Board</a>
            <!-- Sidebar Toggle-->
            <ul class="navbar-nav">
	            <li class="nav-item"><a class="ps-3 small nav-link" href="${pageContext.request.contextPath}/board/list?category=1">자유게시판</a></li>
	            <li class="nav-item"><a class="ps-3 small nav-link" href="${pageContext.request.contextPath}/board/list?category=2">공지사항</a></li>
	            <li class="nav-item"><a class="ps-3 small nav-link" href="${pageContext.request.contextPath}/board/list?category=3">갤러리</a></li>
            </ul>
            
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <c:if test="${not empty member}">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/member/myPage">${member.name} Settings</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/member/logout">Logout</a></li>
                        </c:if>
                        <c:if test="${empty member}">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/member/join">join</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/member/login">login</a></li>
                        </c:if>
                    </ul>
                </li>
            </ul>
        </nav>