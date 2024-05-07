<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 24. 4. 25.
  Time: 오후 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    String amho = request.getParameter("amho");
    if(amho.equals("1234")) {
        Cookie cookie = new Cookie("amho", "yes");
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 3);
        response.addCookie(cookie);

        response.sendRedirect("cookie.jsp");
    }else {%>
<script>
    alert("암호가 맞지 않습니다");
    history.back();
</script>
    <%}
%>