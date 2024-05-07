<%@ page import="data.dao.CaroptionDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");

    String numParam = request.getParameter("num");

    if (numParam != null && !numParam.isEmpty()) {

        int num = Integer.parseInt(numParam);
        CaroptionDao dao = new CaroptionDao();
        dao.deleteoption(num);
        response.sendRedirect("list.jsp"); // 삭제 후 목록 페이지로 이동
    }
%>
