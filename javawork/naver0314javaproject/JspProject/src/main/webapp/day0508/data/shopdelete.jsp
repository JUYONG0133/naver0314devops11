<%@ page import="data.dto.ShopDto" %>
<%@ page import="data.dao.ShopDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int shopidx = Integer.parseInt(request.getParameter("shopidx"));
    ShopDao dao = new ShopDao();

    dao.deleteShop(shopidx);
%>

