<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.1/css/bootstrap.min.css" integrity="sha512-Ez0cGzNzHR1tYAv56860NLspgUGuQw16GiOOp/I2LuTmpSK9xDXlgJz3XN4cnpXWDmkNBKXR/VDMTCnAaEooxA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.1/js/bootstrap.min.js" integrity="sha512-EKWWs1ZcA2ZY9lbLISPz8aGR2+L7JVYqBAYTq5AXgBkSjRSuQEGqWx8R1zAX16KdXPaCjOCaKE8MCpU0wcHlHA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
    // 유효성 검증 예정
    window.onload = function() {
        document.frm.onsubmit = function() {
        	var id = document.frm.id;
    		var pwd = document.frm.pwd;
    		var name = document.frm.name;
    		var email = document.frm.email;
    		
            if(!id.value) {
                alert("아이디를 입력하세요")
                id.focus();
                return false;
            }
            if(!pwd.value) {
                alert("비밀번호를 입력하세요")
                pwd.focus();
                return false;
            }
            if(!name.value) {
                alert("이름을 입력하세요")
                name.focus();
                return false;
            }
            if(!email.value) {
                alert("이메일을 입력하세요")
                email.focus();
                return false;
            }
        }
    }
</script>
</head>
<body>
<div class="container">
	<div class="col-6 mx-auto">
		<form class="form-control" name="frm" method="post" >
			<label for="userId" class="form-label">아이디</label>
			<input type="text" name="id" id="userId" class="form-control">
			<label for="password" class="form-label">비밀번호</label>
			<input type="text" name="pwd" id="password" class="form-control">
			<label for="name" class="form-label">이름</label>
			<input type="text" name="name" id="userId" class="form-control">
			<label for="email" class="form-label">이메일</label>
			<input type="text" name="email" id="password" class="form-control">
			<div class="d-grid">
				<button class="btn btn-primary btn-block my-3">회원가입</button>
			</div>
				<button type="reset" class="btn btn-danger">다시입력</button>
		</form>
	</div>
</div>
</body>
</html>