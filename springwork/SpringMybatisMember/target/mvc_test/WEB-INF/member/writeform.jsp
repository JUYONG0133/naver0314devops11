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
<script type="text/javascript">
    let jungbok=false;
    $(function (){
        $("#myfile").change(function (){
            //console.log($(this));
            let reg=/(.*?)\/(jpg|jpeg|png|gif)$/;
            let f = $(this)[0].files[0];
            if(!f.type.match(reg)){
                alert("이미지 파일만 가능합니다.");
                return;
            }
            if($(this)[0].files[0]){
                let reader = new FileReader();
                reader.onload=function (e){
                    $("#showimg1").attr("src",e.target.result);
                }
                reader.readAsDataURL($(this)[0].files[0]);
            }
        });
        $("#btncheckid").click(function (){
            if($("#myid").val()==''){
                alert("가입할 아이디를 입력해주세요");
                return;
            }
            $.ajax({
                type:"get",
                dataType:"json",
                url:"./idcheck",
                data:{"searchid":$("#myid").val()},
                success:function (data){
                    if(data.count==0){
                        alert("가입 가능한 아아디 입니다.");
                        jungbok=true;
                    }
                    else {
                        alert("이미 가입된 아이디 입니다.");
                        jungbok=false;
                        $("#myid").val("");
                    }
                }
            });
        });
        $("#myid").keyup(function (){
            jungbok=false;
        });
    });

    function check(){
        if(!jungbok){
            alert("아이디 중복확인을 눌러주세요");
            return false;
        }
    }
</script>

<body>
<form action="./insert" method="post" enctype="multipart/form-data" onsubmit="return check()">
    <table class="table table-bordered" style="width: 400px;">
        <caption align="top">
            <h3><b>회원 가입</b></h3>
        </caption>
        <tr>
            <th width="100" class="table-info">이름</th>
            <td colspan="2">
                <input type="text" name="name" class="form-control" required>
            </td>
        </tr>
        <tr>
        <th width="100" class="table-info">아이디</th>
        <td  colspan="2">
            <div class="input-group">
            <input type="text" name="myid" id="myid" class="form-control" required>&nbsp;<button type="button" class="btn btn-sm btn-success" id="btncheckid">중복확인</button>
            </div>
        </td>
        </tr>
        <tr>
            <th width="100" class="table-info">사진</th>
            <td width="200">
                <input type="file" name="myfile" id="myfile" class="form-control" required>
            </td>
            <td rowspan="2">
                <img src="" id="showimg1" style="width: 100%;" onerror="this.src='../image/image1.png'">
            </td>
        </tr>
        <tr>
            <th width="100" class="table-info">비밀번호</th>
            <td width="200">
                <input type="password" name="passwd" class="form-control" required maxlength="8">
            </td>

        </tr>
        <tr>
            <th width="100" class="table-info">핸드폰</th>
            <td width="200" colspan="2">
                <input type="tel" name="hp" class="form-control" required pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="000-0000-0000">
            </td>
        </tr>
        <tr>
            <th width="100" class="table-info">이메일 주소</th>
            <td width="200" colspan="2">
                <input type="email" name="email" class="form-control" required >
            </td>
        </tr>
        <tr>
            <th width="100" class="table-info">주소</th>
            <td width="200" colspan="2">
                <input type="text" name="addr" class="form-control" required >
            </td>
        </tr>
        <tr>
            <th width="100" class="table-info">생년월일</th>
            <td width="200" colspan="2">
                <input type="date" name="birthday" class="form-control" value="2001-03-03">
            </td>
        </tr>
        <tr>
            <td colspan="3" align="center">
                <button type="submit" class="btn btn-outline-primary" style="width: 100px;">회원가입</button>
                <button type="reset" class="btn btn-outline-danger" style="width: 100px;">초기화</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

