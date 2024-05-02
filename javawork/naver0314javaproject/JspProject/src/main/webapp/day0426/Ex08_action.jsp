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
<%
    request.setCharacterEncoding("utf-8");

    String name = request.getParameter("name");
    String pass = request.getParameter("pass");
    String gender = request.getParameter("gender");
    String lic = request.getParameter("lic");
    String blood = request.getParameter("blood");
    String []itlang = request.getParameterValues("itlang");
%>

<body>
<div style="font-size: 20px">
    이름 : <%=name%><br>
    비밀번호 : <%=pass%><br>
    성별 : <%=gender%><br>
    운전면허 : <%=lic%> : <%=lic==null?"없음":"있음"%><br>
    혈액형 : <%=blood%><br>
    <h5>
    <%
        if(itlang==null){%>
            가능한 it 언어 없음
    <%}else{
            for(String s : itlang){%>
            [<%=s%>]
        <%}%>
            언어가 가능합니다.
    <%}
    %>
    </h5>
</div>

</body>
</html>

