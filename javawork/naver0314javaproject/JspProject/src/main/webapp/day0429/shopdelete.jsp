<%@ page import="data.dao.ShopDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    //shopidx int 타입으로 읽기
    int shopidx = Integer.parseInt(request.getParameter("shopidx"));
    //dao 선언
    ShopDao dao = new ShopDao();
    //delete 메소드 호출
    dao.deleteShop(shopidx);
    //목록 shoplist.jsp 로 이동
    response.sendRedirect("shoplist.jsp"); //url 주소 바뀜
%>