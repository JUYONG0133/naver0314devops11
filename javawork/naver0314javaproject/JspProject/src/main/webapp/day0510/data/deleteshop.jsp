<%@ page import="data.dao.ShopDao" %><%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 24. 4. 25.
  Time: 오후 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int shopidx = Integer.parseInt(request.getParameter("shopidx"));

    ShopDao dao = new ShopDao();
    dao.deleteShop(shopidx);
%>