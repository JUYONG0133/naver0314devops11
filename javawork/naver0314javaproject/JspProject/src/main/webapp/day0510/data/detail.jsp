<%@ page import="data.dto.ShopDto" %>
<%@ page import="data.dao.ShopDao" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("utf-8");
    int shopidx=Integer.parseInt(request.getParameter("shopidx"));
    //dao 선언
    ShopDao dao=new ShopDao();
    //dto 데이타 가져오기
    ShopDto dto=dao.getSangpum(shopidx);
    //날짜 포멧양식 지정

%>


