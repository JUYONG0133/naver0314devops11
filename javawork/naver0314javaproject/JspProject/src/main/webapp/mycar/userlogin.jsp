<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card p-4">
                <h1 class="text-center mb-4">로그인</h1>
                <form method="post" action="uesrloginaction.jsp">
                    <div class="mb-3">
                        <label for="userid" class="form-label">아이디 : </label>
                        <input type="text" id="userid" name="userid" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="userpassword" class="form-label">비밀번호 : </label>
                        <input type="password" id="userpassword" name="userpassword" class="form-control" required>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">로그인</button>
                </form>
                <p class="text-center mt-3">계정이 없으시다면 ? <a href="userjoin.jsp">회원가입</a></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
