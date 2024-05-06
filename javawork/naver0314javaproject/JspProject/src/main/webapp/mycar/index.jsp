<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>자동차 구매</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <!-- Bootstrap JS (including jQuery) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body {
            font-family: 'Jua', sans-serif;
            background-color: #f8f8f8;
            text-align: center;
            padding: 50px;
        }
        .jumbotron {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333333;
        }
        p {
            font-size: 18px;
            color: #555555;
            margin-bottom: 20px;
        }
        .btn-custom {
            font-size: 20px;
            padding: 12px 30px;
            margin-top: 20px;
            border-radius: 8px;
        }
        .btn-login {
            background-color: #007bff;
            color: #ffffff;
            border: none;
        }
        .btn-register {
            background-color: #28a745;
            color: #ffffff;
            border: none;
        }
        .btn-custom:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1>자동차 구매</h1>
        <p>신차를 구매하실 고객님은 회원가입을 먼저 해주세요.</p>
        <a href="userlogin.jsp" class="btn btn-custom btn-login">로그인</a>&nbsp;&nbsp;&nbsp;
        <a href="userjoin.jsp" class="btn btn-custom btn-register">회원가입</a>
    </div>
    <h6>비회원으로 차량 견적짜려면<a href="main.jsp">여기 클릭</a></h6>
</div>
</body>
</html>
