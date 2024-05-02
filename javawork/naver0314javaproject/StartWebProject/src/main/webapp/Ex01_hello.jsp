<%@ page import="java.util.Date" %><%--
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
<h3>html 주석과 jsp 주석 비교하기</h3>
<!--html 주석 -->
<%--jsp 주석 --%>

<%= new Date()%>
<h5>선언문의 변수는 위치 상관없이 출력가능하다.</h5>
<h5>이름 : <%=name%></h5>
<h5>나이 : <%=age%>세</h5>
<%!
    //선언문이라고 부른다.
    //여기서 선언하는 변수는 서블릿으로 변환시 위치 상관없이 멤버변수로 선언된다.
    String name = "송혜교";
    int age = 30;
%>
<hr>
<h5>이름2 : <%=name%></h5>
<h5>나이2 : <%=age%>세</h5>
<hr>

<%--<h5>주소 : <%=addr%></h5>  위에 선언하면 에러--%>
<%
    //스크립트릿 : 자바 영역 : 서블릿변환시 특정 메소드내의 지역변수로 선언된다
    String addr ="서울시 강남구";
    //내장 객체중 out을 이용해서 출력해도된다.
    out.print("나의 주소는"+addr+"입니다<br>"); //document.write(); 와 같음
%>
<h5>주소 : <%=addr%></h5>

</body>
</html>

