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
<div style="margin: 10px;width: 400px;">
    <form action="./writeaction.jsp" method="post">
        <table class="table table-bordered">
            <caption align="top"><b>[학생정보입력]</b></caption>
            <tr>
                <th class="table-warning" width="100">이름</th>
                <td>
                    <input type="text" name="name" class="form-control" style="width: 130px;" required>
                </td>
            </tr>
            <tr>
                <th class="table-warning" width="100">혈액형</th>
                <td>
                    <select class="form-warning" style="width: 100px" name="blood">
                        <option>A</option>
                        <option>B</option>
                        <option>AB</option>
                        <option>O</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th class="table-warning" width="100">운전면허</th>
                <td>
                    <label>
                        <input type="checkbox" name="license">&nbsp;운전면허 보유
                    </label>
                </td>
            </tr>
            <tr>
                <th class="table-warning" width="100">자바점수</th>
                <td>
                    <input type="number" min="0" max="100" value="0" name="java" class="form-control" style="width: 130px;" required>
                </td>
            </tr>
            <tr>
                <th class="table-warning" width="100">스프링점수</th>
                <td>
                    <input type="number" min="0" max="100" value="0" name="spring" class="form-control" style="width: 130px;" required>
                </td>
            </tr>
            <tr>
                <th class="table-warning" width="100">html점수</th>
                <td>
                    <input type="number" min="0" max="100" value="0" name="html" class="form-control" style="width: 130px;" required>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center" >
                    <button type="submit" class="btn btn-info">학생정보저장</button>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>

