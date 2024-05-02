<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 24. 4. 25.
  Time: 오후 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
      rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
    body * {
        font-family: 'Jua';
    }
</style>

<body>
<h5>JSP로 폼태그 읽기</h5>
<form action="./Ex06_action.jsp" method="get"></form>
    <b>이름</b> :
    <input type="text" name="name" required>
    <br><br>
    <b>사진</b> :
    <select name="photo">
        <option value="../image/17.jpg">신민아</option>
        <option value="../image/15.jpg">설현</option>
        <option value="../image/18.jpg">신세경</option>
        <option value="../image/19.jpg">수지</option>
    </select>
    <br><br>
    <button type="submit">서버 전송</button>
</body>
</html>

