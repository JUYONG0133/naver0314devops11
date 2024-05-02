<%@ page import="data.dao.SawonDao" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="data.dto.SawonDto" %><%--
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
<%
    int num = Integer.parseInt(request.getParameter("num"));
    SawonDao dao = new SawonDao();
    SawonDto dto = dao.getData(num);

%>
<body>
<div style="margin: 10px;width: 500px;">
    <h2><b> <%=dto.getName() %> 사원정보</b></h2>
    <table>
        <tr>
            <td width="300">
                <img src="<%=dto.getPhoto().equals("no")?"../image/photo1.png":dto.getPhoto()%>"
                     style="border: 10px groove orange;margin:10px;width:270px;">
            </td>
            <td>
                <h5>부 서 : <%=dto.getBuseo() %></h5>
                <h5>나 이 : <%=dto.getAge() %>세</h5>
                <h5>주 소 : <%=dto.getAddr()%></h5>
                <h5>성 별 : <%=dto.getGender()%></h5>
                <h5>입사년도 : <%=dto.getBirthday()%></h5>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="button" class="btn btn-outline-danger btn-sm"
                        style="width: 80px;"
                        onclick="location.href='sawonlist.jsp'">목록</button>

                <button type="button" class="btn btn-outline-danger btn-sm"
                        style="width: 80px;"
                        onclick="location.href='sawonupdateform.jsp?num=<%=dto.getNum()%>'">수정</button>

                <button type="button" class="btn btn-outline-danger btn-sm"
                        style="width: 80px;"
                        num="<%=dto.getNum()%>" id="delsawon" sawonname="<%=dto.getName()%>">삭제</button>

                <button type="button" class="btn btn-outline-danger btn-sm"
                        style="width: 80px;"
                        onclick="location.href='sawonform.jsp'">사원추가</button>
            </td>
        </tr>
    </table>
</div>
    <script type="text/javascript">
        //삭제2버튼 이벤트
        $("#delsawon").click(function(){
            let num=$(this).attr("num");
            let sawonname=$(this).attr("sawonname");
            let a=confirm(`\${sawonname} 사원정보를  삭제할까요?`);//jsp에서는 $기능이 이미 있으므로 스크립트에서 변수를 넣을경우 \${변수명}
            if(a){
                location.href="sawondelete.jsp?num="+num;//페이지 이동
            }
        });
    </script>
</body>
</html>

