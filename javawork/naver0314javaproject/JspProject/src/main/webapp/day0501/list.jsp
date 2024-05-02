<%@ page import="data.dto.StudentDto" %>
<%@ page import="data.dao.StudentDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
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
    //dao 선언
    StudentDao dao=new StudentDao();
    //db에 등록된 상품들 가져오기
    List<StudentDto> list=dao.getAllStudents();
    //날짜형식
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd.");
%>
<body>
<div style="margin: 10px;width: 400px;">
    <button type="button" class="btn btn-outline-primary"
            style="margin-top: 10px;margin-left: 100px;"
            onclick="location.href='./writeform.jsp'">학생정보 추가</button>
    <table class="table table-bordered">
        <tr class="table-danger">
            <th width="100">이름</th>
            <th width="150">등록일</th>
            <th width="100">상세보기</th>
        </tr>
        <tr>
                <%
            for(StudentDto dto:list){%>
        <tr>
            <td>
                <h5 align="center"><%=dto.getName()%></h5>
            </td>
            <td align="center">
                <%=sdf.format(dto.getWriteday()) %>
            </td>
            <td>
                <button type="button" onclick="location.href='detail.jsp?num=<%=dto.getNum()%>'">상세보기</button>
            </td>
        </tr>
        <%}
        %>
    </table>
</div>

</body>
</html>

