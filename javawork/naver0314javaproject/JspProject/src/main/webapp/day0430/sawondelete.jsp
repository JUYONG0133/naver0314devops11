
<%@ page import="data.dao.SawonDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    //shopidx int 타입으로 읽기
    int num = Integer.parseInt(request.getParameter("num"));
    //dao 선언
    SawonDao dao = new SawonDao();
    //delete 메소드 호출
    dao.deleteSawon(num);
    //목록 shoplist.jsp 로 이동
    response.sendRedirect("sawonlist.jsp"); //url 주소 바뀜
%>