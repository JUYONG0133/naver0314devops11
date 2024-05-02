        <%@ page import="java.sql.Timestamp" %>
<%@ page import="data.dto.StudentDto" %>
        <%@ page import="data.dao.StudentDao" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("utf-8");

    String name = request.getParameter("name");
    String blood = request.getParameter("blood");
    int java = Integer.parseInt(request.getParameter("java"));
    int spring = Integer.parseInt(request.getParameter("spring"));
    int html = Integer.parseInt(request.getParameter("html"));
    //Timestamp writeday = Timestamp.valueOf(request.getParameter("writeday"));
    char license = request.getParameter("license")==null?'n':'y';

    StudentDto dto = new StudentDto();
    dto.setName(name);
    dto.setBlood(blood);
    dto.setJava(java);
    dto.setSpring(spring);
    dto.setHtml(html);
    dto.setLicense(license);

    StudentDao dao = new StudentDao();
    dao.insertStudent(dto);
    response.sendRedirect("list.jsp");
%>