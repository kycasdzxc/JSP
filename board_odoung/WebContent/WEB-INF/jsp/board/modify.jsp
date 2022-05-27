<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <%@ include file="../common/head.jsp" %>
    </head>
    <body class="sb-nav-fixed">
        <%@ include file="../common/nav.jsp" %>
        <main class="mt-5 pt-5">
            <div class="container-fluid px-4">
                <h1 class="mt-4">Board</h1>
                <div class="card mb-4">
                    <div class="card-body">
                        <form method="post">
						  <div class="mb-3 mt-3">
						    <label for="bno" class="form-label">bno</label>
						    <input type="text" class="form-control" id="bno" name="bno" value="${board.bno}" readonly>
						  </div>
						  <div class="mb-3">
						    <label for="title" class="form-label">title</label>
						    <input type="text" class="form-control" id="title" name="title" value="${board.title}">
						  </div>
						  <div class="mb-3">
						    <label for="content" class="form-label">content</label>
						    <textarea class="form-control" id="content" name="content">${board.content}</textarea>
						  </div>
						  <div class="mb-3">
						    <label for="regDate" class="form-label">regDate</label>
						    <input type="text" class="form-control" id="regDate" name="regDate" value="${board.regDate}" disabled>
						  </div>
						  <div class="mb-3">
						    <label for="writer" class="form-label">writer</label>
						    <input type="text" class="form-control" id="writer" name="writer" value="${board.writer}" disabled>
						  </div>
						  <input type="hidden" name="amount" value="${cri.amount}">
						  <input type="hidden" name="category" value="${cri.category}">
						  <input type="hidden" name="pageNum" value="${cri.pageNum}">
						  <a href="list" class="btn btn-outline-secondary">list</a>
						  <button class="btn btn-outline-warning">modify</button>
						</form>
                    </div>
                </div>
            </div>
        </main>
        <%@ include file="../common/footer.jsp" %>
    </body>
</html>
