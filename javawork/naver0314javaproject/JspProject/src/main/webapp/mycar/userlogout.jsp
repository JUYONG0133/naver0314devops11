<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException" %>

<%
    // 세션을 무효화하여 로그아웃 처리
    if (request != null && request.getSession(false) != null) {
        request.getSession().invalidate();
    }
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그아웃</title>
</head>
<body>
<h1>로그아웃 되었습니다.</h1>
<p>원하는 내용을 추가로 표시할 수 있습니다.</p>
<p><a href="userlogin.jsp">다시 로그인하러 가기</a></p>
<p><a href="index.jsp">메인으로 돌아가기</a></p>
</body>
</html>
