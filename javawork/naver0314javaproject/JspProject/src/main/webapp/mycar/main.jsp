<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>구매차량 모델선택</title>
    <!-- 부트스트랩 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 부트스트랩 JS (팝업창, 드롭다운 메뉴 등) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- 부트스트랩 아이콘 폰트 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <!-- 구글 폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>

    <style>
        body {
            font-family: 'Jua', sans-serif;
            background-color: #f8f9fa;
            padding: 20px;
            text-align: center;
        }

        h1 {
            color: #007bff;
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

        footer{
            position : fixed;
            bottom: 0px;
            font-size: 13px;
        }
    </style>
</head>
<body>
<h1>구매차량 모델선택</h1>

<div class="model">
    <div class="model-item">
        <img src="../model/sedan.png" alt="승용차" onclick="location.href='./avante.jsp'">
        <br><br><div>승용차</div>
    </div>
    <div class="model-item">
        <img src="../model/suv.png" alt="SUV">
        <br><br><div>SUV</div>
    </div>
    <div class="model-item">
        <img src="../model/electric.png" alt="전기차">
        <br><br><div>전기차</div>
    </div>
</div>


<footer>
    <p>&copy;  HYUNDAI MOTOR COMPANY. ALL RIGHTS RESERVED.</p>
</footer>

</body>
</html>
