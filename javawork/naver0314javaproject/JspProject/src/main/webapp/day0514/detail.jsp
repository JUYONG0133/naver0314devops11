<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body *{
            font-family: 'Jua';
        }
        .qwer{
            margin-top: 30px;
            margin-left: 50px;
        }
        .button{
            margin-left: 100px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<div class="qwer">
<table style="width: 700px;">
    <tr>
        <th><h2>${dto.subject}</h2></th>

    </tr>
    <tr>
        <th>${dto.writer}</th>
        <th><span style="text-align: left">${dto.writeday}</span></th>
    </tr>
    <tr>
        <th>조회수 : ${dto.readcount}</th>
        <th><b style="margin-left: 10px; color: gray;">추천<span class="chu">${dto.chu}</span></b>
            <i class="bi bi-hand-thumbs-up mychu" style="font-size: 20px;cursor: pointer;"></i>
        </th>
    </tr>
    <tr>
        <th><img src="../image/s${dto.avata}.JPG"></th>
    </tr>
    <tr>
        <th>${dto.content}</th>
    </tr>
</table>
</div>
<div class="button">
    <button type="button" class="btn btn-sm btn-outline-success" onclick="location.href='./form'">글쓰기</button>
    <button type="button" class="btn btn-sm btn-outline-success" onclick="location.href='./updateform?num=${dto.num}&currentPage=${currentPage}' ">수정</button>
    <button type="button" class="btn btn-sm btn-outline-success" onclick="del()">삭제</button>
    <button type="button" class="btn btn-sm btn-outline-success" onclick="location.href='list?currentPage=${currentPage}'">목록</button>

</div>
<script type="text/javascript">
    function del(){
        let num = ${dto.num};
        let cp = ${currentPage};
        let a = confirm("해당 개시글을 삭제하시겠습니까?");
        if(a){
            location.href=`./delete?num=\${num}&currentPage=\${cp}`;
        }
    }

    //추천클릭시 숫자증가
    $(".mychu").click(function (){
        let num = ${dto.num};
        $.ajax({
            type:"get",
            dataType:"json",
            data:{"num":num},
            url:"./updatechu",
            success:function (data){
                $("span.chu").text(data.chu);
            }
        });
    });
</script>
</body>
</html>