<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 24. 4. 25.
  Time: 오후 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="dao" class="data.dao.ShopDao"/>
<jsp:useBean id="dto" class="data.dto.ShopDto"/>

<jsp:setProperty name="dto" property="*"/>

<%
    dao.insertShop(dto);
%>
