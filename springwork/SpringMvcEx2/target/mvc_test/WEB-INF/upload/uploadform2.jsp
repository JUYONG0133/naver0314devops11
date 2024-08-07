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
<h3>제목과 원하는 사진 여러개 업로드 하세요</h3>
<form action="./upload2" method="post" enctype="multipart/form-data">
    <h4>제목을 입력해주세요</h4>
    <input type="text" name="title">
    <h4>사진 여러장을 업로드해주세요</h4>
    <input type="file" name="upload" multiple>
    <br>
    <hr>
    <button type="submit" class="btn btn-danger">제목과 사진 업로드</button>
</form>

</body>
</html>

