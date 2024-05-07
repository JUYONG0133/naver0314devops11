<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 24. 4. 25.
  Time: 오후 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<%
    Cookie []cookies = request.getCookies();
    if(cookies!=null){
        for(Cookie ck : cookies){
            if(ck.getName().equals("amho")){
                ck.setMaxAge(0);
                ck.setPath("/");
                response.addCookie(ck);
            }
        }
    }
    response.sendRedirect("cookie.jsp");
%>