<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>구매차량 모델선택</title>
    <!-- 부트스트랩 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 구글 폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f8f9fa;
        }
        .navbar {
            background-color: #0d6efd;
        }
        .navbar-brand {
            font-weight: bold;
            font-size: 1.5rem;
        }
        .navbar-text {
            color: #ffffff;
            font-size: 1.2rem;
            margin-right: 20px;
        }
        .model {
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 30px;
            margin-top: 30px;
        }
        .model-item {
            text-align: center;
        }
        .model img {
            width: 200px;
            height: auto;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease;
            cursor: pointer;
        }
        .model img:hover {
            transform: scale(1.1);
        }
        /*버튼 디자인*/
        @import url('https://fonts.googleapis.com/css?family=Amatic+SC');

        body {
            margin: 0;
            height: 100%;
            background-image: linear-gradient(to top, #d9afd9 0%, #97d9e1 100%);
            background-repeat: no-repeat;
            background-size: cover;
            background-attachment: fixed;
        }

        .button_container {
            position: absolute;
            left: 0;
            right: 0;
            top: 30%;
        }

        .description, .link {
            font-family: 'Amatic SC', cursive;
            text-align: center;
        }

        .description {
            font-size: 35px;
        }

        .btn {
            border: none;
            display: block;
            text-align: center;
            cursor: pointer;
            text-transform: uppercase;
            outline: none;
            overflow: hidden;
            position: relative;
            color: #fff;
            font-weight: 700;
            font-size: 15px;
            background-color: #222;
            padding: 17px 60px;
            margin: 0 auto;
            box-shadow: 0 5px 15px rgba(0,0,0,0.20);
        }

        .btn span {
            position: relative;
            z-index: 1;
        }

        .btn:after {
            content: "";
            position: absolute;
            left: 0;
            top: 0;
            height: 490%;
            width: 140%;
            background: #78c7d2;
            -webkit-transition: all .5s ease-in-out;
            transition: all .5s ease-in-out;
            -webkit-transform: translateX(-98%) translateY(-25%) rotate(45deg);
            transform: translateX(-98%) translateY(-25%) rotate(45deg);
        }

        .btn:hover:after {
            -webkit-transform: translateX(-9%) translateY(-25%) rotate(45deg);
            transform: translateX(-9%) translateY(-25%) rotate(45deg);
        }

        .link {
            font-size: 20px;
            margin-top: 30px;
        }

        .link a {
            color: #000;
            font-size: 25px;
        }

    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container">
        <a class="navbar-brand" href="https://www.hyundai.com/kr/ko/e/">HYUNDAI MOTOR</a>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <%-- username 값이 null인 경우 로그인 링크로 변경 --%>
                    <%
                        String username = (String) session.getAttribute("username");
                        if (username == null) {
                    %>
                    <a class="nav-link" href="./userlogin.jsp">로그인 하기</a>
                    <% } else { %>
                    <span class="navbar-text">
                            <%= "안녕하세요, " + username + "님" %>
                        </span>
                    <a class="nav-link" href="./userlogout.jsp">로그아웃 하기</a>
                    <% } %>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <h1 class="text-center mb-5">구매차량 모델선택</h1>
    <div class="model">
        <div class="model-item">
            <img src="../model/sedan.png" alt="아반떼" onclick="location.href='./avante.jsp'">
            <div class="mt-3">아반떼</div>
        </div>
        <div class="model-item">
            <img src="../model/suv.png" alt="싼타페" onclick="location.href='./suv.jsp'">
            <div class="mt-3">싼타페</div>
        </div>
        <div class="model-item">
            <img src="../model/electric.png" alt="G80e" onclick="location.href='./ioniq.jsp'">
            <div class="mt-3">아이오닉 6</div>
        </div>
    </div>
</div>
<div class="container mt-5">
    <h1 class="text-center mb-5">구매 차종 목록</h1>
    <button class="btn" onclick="location.href='./list.jsp'"><span>구매 목록 보기</span></button>
</div>

<!-- 부트스트랩 JS 및 jQuery -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</body>
</html>
