<%@ page import="data.dto.UserDto" %>
<%@ page import="data.dao.UserDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("utf-8");

    String userid = request.getParameter("userid");
    String userpassword = request.getParameter("userpassword");
    String username = request.getParameter("username");
    String usergender = request.getParameter("usergender");

    UserDto dto = new UserDto();
    dto.setUserid(userid);
    dto.setUserpassword(userpassword);
    dto.setUsername(username);
    dto.setUsergender(usergender);

    UserDao dao = new UserDao();

    // UserDao 클래스에서 사용자 ID 중복 여부 확인 메서드 호출
    boolean userIdExists = dao.checkUserIdExists(userid); // UserDao 클래스의 메서드 호출 수정

    if (userIdExists) {
        // 이미 존재하는 사용자 ID인 경우
%>
<script>
    alert("이미 사용 중인 ID입니다. 다른 ID를 사용해주세요.");
    window.location.href = "index.jsp"; // 원하는 페이지로 리다이렉트
</script>
<%
    } else {
        // 사용자 ID가 존재하지 않는 경우, 사용자 추가 진행
        dao.insertUser(dto);
        response.sendRedirect("index.jsp"); // 성공적으로 추가된 경우 메인 페이지로 리다이렉트
    }
%>
