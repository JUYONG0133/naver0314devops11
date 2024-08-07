<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        $("#photoupload").change(function (){
            let form = new FormData();
            form.append("upload",$("#photoupload")[0].files[0]);
            form.append("num",${dto.num});

            $.ajax({
                type:"post",
                dataType:"json",
                data:form,
                url:"./upload",
                processData:false,
                contentType:false,
                success:function (data){
                    $("#photo").attr("src","../image/"+data.photoname);
                }
            });
        });
    });
</script>

<body>
<table class="table-bordered" style="width: 500px; margin: 20px;">
    <caption align="top">
        <h2><b>${dto.name} 회원님의 정보확인</b></h2>
    </caption>
    <tr>
        <td width="200" align="center">
            <img src="../image/${dto.photo}" id="photo" class="rounded-circle" style="width: 150px;border: 2px solid black">
            <br><br>
            <input type="file" id="photoupload" style="display: none;">
            <button type="button" class="btn btn-success btn-sm" onclick="$('#photoupload').trigger('click')">사진수정</button>
        </td>
        <td valign="middle">
            아이디 : ${dto.myid}<br>
            핸드폰 : ${dto.hp}<br>
            이메일 : ${dto.email}<br>
            주 소 : ${dto.addr}<br>
            생년월일 : ${dto.birthday}<br>
            가입일 : <fmt:formatDate value="${dto.gaipday}" pattern="yyyy-MM-dd HH:mm"/>
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <button type="button" class="btn btn-sm btn-outline-secondary" style="width: 80px;" onclick="location.href='./list'">목록</button>
            <button type="button" class="btn btn-sm btn-outline-secondary" style="width: 80px;" onclick="location.href='./update?num=${dto.num}'">수정</button>
            <button type="button" class="btn btn-sm btn-outline-secondary" style="width: 80px;" onclick="del(${dto.num})">삭제</button>
            <script type="text/javascript">
                function del(num){
                    // alert(num);
                    let passwd = prompt("비밀번호를 입력해주세요");
                    $.ajax({
                        type: "get",
                        dataType: "json",
                        url: "./delete",
                        data: {"num":num,"passwd":passwd},
                        success:function (data){
                            if(data.status=='success'){
                                alert("삭제되었습니다");
                                location.href="./list";
                            }
                            else {
                                alert("비밀번호가 맞지 않습니다.");
                            }
                        }
                    });
                }
            </script>
        </td>
    </tr>
</table>

</body>
</html>

