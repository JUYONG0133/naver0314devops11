<%@ page import="data.dto.UserDto" %>
<%@ page import="data.dao.UserDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");

    String userid = request.getParameter("userid");
    String userpassword = request.getParameter("userpassword");

    // 입력값이 null 또는 빈 문자열인지 확인
    if (userid == null || userid.isEmpty() || userpassword == null || userpassword.isEmpty()) {
        // 입력 필드가 비어있는 경우
        response.sendRedirect("userlogin.jsp?error=empty");
    } else {
        UserDto dto = new UserDto();
        dto.setUserid(userid);
        dto.setUserpassword(userpassword);

        UserDao dao = new UserDao();

        boolean loginSuccess = dao.loginUser(dto);

        if (loginSuccess) {
            // 인증 성공 시 메인 페이지로 리다이렉트
            response.sendRedirect("main.jsp");
        } else {
            // 로그인 실패 시 알림 메시지 출력
            String errorMessage = "아이디 또는 비밀번호가 올바르지 않습니다.";
%>
<script>
    var userpassword = '<%= userpassword %>'; // 사용자가 입력한 비밀번호

    if (userpassword.trim() === '') {
        alert("비밀번호를 입력해주세요.");
    } else {
        alert("<%= errorMessage %>");
    }
    window.location.href = "userlogin.jsp"; // 로그인 페이지로 리다이렉트
</script>
<%
        }
    }
%>
