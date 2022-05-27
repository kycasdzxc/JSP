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
                        <form>
						  <div class="mb-3 mt-3">
						    <label for="bno" class="form-label"><i class="fas fa-list-ol"></i> bno</label>
						    <input type="text" class="form-control" id="bno" name="bno" value="${board.bno}" disabled>
						  </div>
						  <div class="mb-3">
						    <label for="title" class="form-label"><i class="fas fa-heading"></i> title</label>
						    <input type="text" class="form-control" id="title" name="title" value="${board.title}" disabled>
						  </div>
						  <div class="mb-3">
						    <label for="content" class="form-label"><i class="far fa-comment"></i> content</label>
						    <c:if test="${cri.category==3}">
						    <div>
						    	<c:forEach items="${board.attachs}" var="attach">
						    		<c:if test="${attach.image}">
						    		<div class='text-center my-3'>
										<img class="mw-100" src="${pageContext.request.contextPath}/display?uuid=${attach.uuid}&path=${attach.path}" alt="${attach.origin}">
						    		</div>
						    		</c:if>
						    	</c:forEach>
						    </div>
							</c:if>						    
						    <textarea class="form-control" id="content" name="content" disabled>${board.content}</textarea>
						  </div>
						  <div class="mb-3">
						    <label for="regDate" class="form-label"><i class="far fa-clock"></i> regDate</label>
						    <input type="text" class="form-control" id="regDate" name="regDate" value="${board.regDate}" disabled>
						  </div>
						  <div class="mb-3">
						    <label for="writer" class="form-label"><i class="far fa-user"></i> writer</label>
						    <input type="text" class="form-control" id="writer" name="writer" value="${board.writer}" disabled>
						  </div>
						  <div class="mb-3">
						    <label for="attach" class="form-label"><i class="far fa-file-archive"></i> attach</label>
						    <ul class="list-group">
						    <c:forEach items="${board.attachs}" var="attach">
							  <li class="list-group-item"><i class="fas fa-download"></i> <a href="${pageContext.request.contextPath}/download${attach.params}">${attach.origin}</a></li>
						    </c:forEach>
							</ul>
						  </div>
						  <div class="mb-3">
						    <div class="clearfix">
							    <span class="form-label mb-4"><i class="far fa-edit"></i> replies</span>
						    </div>
						    <div class="row p-4">
						    	<div class="col-10">
						    		<textarea class="w-100" id="replyContent"></textarea>
						    	</div>
						    	<div class="col-2">
						    		<button class="btn btn-primary" id="btnReplyReg" type="button">글 등록</button>
						    	</div>
						    </div>
						    <ul class="list-group list-group-flush my-3 small replies">
						    	
						    </ul>
						  </div>
						  <a href="list${cri.params2}" class="btn btn-outline-secondary">list</a>
						  <c:if test="${not empty member && member.id == board.writer}">
						  <a href="modify${cri.params2}&bno=${board.bno}" class="btn btn-outline-warning">modify</a>
						  <a href="remove${cri.params2}&bno=${board.bno}" class="btn btn-outline-danger" onclick="return confirm('삭제하시겠습니까?')">remove</a>
						  </c:if>
						</form>
                    </div>
                </div>
            </div>
        </main>
        <%@ include file="../common/footer.jsp" %>
		<script>
			const cp = '${pageContext.request.contextPath}';

			// replyService.get(100, function(data) {
			// 	console.log(data);
			// }, cp);
			// replyService.get(100, function(data) {
			// 	console.log(data);
			// }, cp);
			// replyService.list(273, function(data) {
			// 	console.log(data);
			// }, cp);
			// replyService.add({bno:273, content:'get.jsp 내용', writer:'javaman'}, function(data) {
			// 	console.log(data);
			// }, cp);

			$(function() {
				const bno = '${board.bno}';
				showList();
			
				function showList() {
					replyService.list(bno, function(data) {
						console.log(data);
						var str = "";
						for(var i in data) {
							str += '';
str +='				<li class="list-group-item" data-rno="' + data[i].rno + '">'
str +='					<div class="list-group-item list-group-item-info small">'
str +='						<span>' + data[i].writer + '</span>'
str +='						<span class="small float-end">' + data[i].regDate + '</span>'
str +='						<span class="small float-end mx-2 btnReplyRemove"><i class="fas fa-trash-alt" style="cursor:pointer"></i></span>'
str +='					</div>'
str +='					<div class="list-group-item">' + data[i].content + '</div>'
str +='				</li>'
						}
						$(".replies").html(str);
					}, cp);
				}

				// 댓글 상세 조회
				$(".replies").on("click", ".btnReplyRemove", function() {
					var rno = $(this).closest("li").data("rno");
					var reply = {"rno":rno};
					replyService.remove(reply, function(data) {
						alert("댓글이 삭제되었습니다.");
						showList();
					}, cp);
				});

				// 댓글 등록 버튼 클릭 이벤트
				$("#btnReplyReg").click(function() {
					var reply =
					{bno:bno, content:$("#replyContent").val(), writer:'javaman'};
					replyService.add(reply, function(data) {
						showList();
						$("#replyContent").val("");
						alert("댓글이 등록되었습니다.");
					}, cp);
				});

				// 댓글 수정 버튼 클릭 이벤트
				$("#replyModal .modal-footer button:eq(1)").click(function() {
					var reply = {rno:$("#replyModal").data("rno"), content:$("#replyContent").val()};
					replyService.modify(reply, function(data) {
						showList();
						$("#replyModal").modal("hide")
					}, cp);
				});

				// 댓글 삭제 버튼 클릭 이벤트
				$("#replyModal .modal-footer button:eq(2)").click(function() {
					var reply = {rno:$("#replyModal").data("rno")};
					replyService.remove(reply, function(data) {
						showList();
						$("#replyModal").modal("hide")
					}, cp);
				});
			});
		</script>
    </body>
</html>