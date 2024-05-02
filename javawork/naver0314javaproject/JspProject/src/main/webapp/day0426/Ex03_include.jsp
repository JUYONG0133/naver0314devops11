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
<script>
    $(function (){
        $("div.view").hide();
        $("h5.title").css("cursor","pointer");

        $("h5.title").click(function (){
            $("h5.title").next().hide();
            $(this).next().slideDown('slow');

        });
    });
</script>

<body>
<h3 class="alert alert-danger">JSP의 Action Tag include</h3>
<h5 class="title">2024-04-26  1번 예제</h5>
<div class="view">
    <jsp:include page="./Ex01_test.jsp"></jsp:include>
</div>
<h5 class="title">2024-04-26  2번 예제</h5>
<div class="view">
    <jsp:include page="./Ex02_gugudan.jsp"></jsp:include>
</div>

</body>
</html>

