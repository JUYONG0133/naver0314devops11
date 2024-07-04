<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    th, td {
         text-align: center;
        vertical-align : middle;
     }
</style>

<body>
<h2 class="alert alert-danger">
    총 ${totalCount}명의 회원이 있습니다..
    <span style="float: right;">
        <button type="button" class="btn btn-sm btn-success" onclick="location.href='./form'">멤버등록</button>
    </span>
</h2>
<table class="table table-bordered" style="width: 700px;">
    <caption align="top"><b>회원정보</b></caption>
    <tr class="table table-info" style="text-align: center">
        <th width="70">번호</th>
        <th width="230">회원명</th>
        <th width="100">아이디</th>
        <th>핸드폰번호</th>
        <th>상세보기</th>
    </tr>

        <c:forEach var="s"  items="${list}" >
            <tr style="text-align: center">
            <td>${s.num}</td>
            <td>
                <img src="/image/${s.photo}" style="width: 130px; height: 130px; border: 3px solid black" class="rounded-circle">&nbsp;
                ${s.name}
            </td>
            <td>${s.myid}</td>
            <td>${s.hp}</td>
            <td>
                <button type="button" class="btn btn-outline-primary" onclick="location.href='./detail?num=${s.num}'">상세보기</button>
            </td>
            </tr>
        </c:forEach>

</table>
</body>
</html>

