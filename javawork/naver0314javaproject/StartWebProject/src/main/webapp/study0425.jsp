<%@ page import="java.util.List" %>
<%@ page import="test.data.CarDto" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>자동차 상점</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body * {
            font-family: 'Jua';
        }
        div.car {
            float: left;
            margin: 5px;
            border: 2px solid gray;
            border-radius: 20px;
            padding: 15px;
            width: 250px;
            height: 400px;
        }
        div.car img {
            width: 180px;
            height: 200px;
            border-radius: 20px;
        }
    </style>
</head>
<body>
<%
    List<CarDto> list = new ArrayList<>();
    list.add(new CarDto("그랜저", "car1.png", 3000, 3, "darkgray"));
    list.add(new CarDto("싼타페", "car6.png", 5000, 1, "white"));
    list.add(new CarDto("소나타(금)", "car3.png", 2500, 5, "gold"));
    list.add(new CarDto("소나타(흰)", "car4.png", 26000, 8, "lightgray"));
    list.add(new CarDto("아반떼", "car5.png", 2000, 3, "red"));
%>

<%
    for (CarDto dto : list) {
%>
<div class="car" style="background-color: <%= dto.getColor() %>">
    <img src="./car/<%= dto.getPhoto() %>" id="photo">
    <br>
    <h5 id="model">상품명 : <%= dto.getModel() %></h5>
    <h5 id="price">가격 : <%= dto.getPrice() %></h5>
    <h5 id="count">수량 : <%= dto.getCount() %>개</h5>
    <button type="button" class="btn btn-info buy" data-model="<%= dto.getModel() %>"
            data-price="<%= dto.getPrice() %>" data-count="<%= dto.getCount() %>">구매</button>
</div>
<%
    }
%>

<div class="bresult" style="white-space: pre-line">결과</div>

<script>
    $(document).ready(function () {
        $(".buy").click(function () {
            let model = $(this).data('model');
            let price = $(this).data('price');
            let count = $(this).data('count');

            let s = "이름 : " + model + "<br>" + "가격 : " + price + "<br>" + "구매후 남은 수량 : " + count;
            $(".bresult").html(s);
        });
    });
</script>
</body>
</html>
