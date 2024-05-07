<%@ page import="data.dto.CaroptionDto" %>
<%@ page import="data.dao.CaroptionDao" %>
<%@ page import="java.util.Arrays" %>

<%
    request.setCharacterEncoding("UTF-8");

    // 세션을 통해 사용자 ID 가져오기
    String userid = (String) session.getAttribute("userid");

    // 사용자 ID가 존재하는지 확인
    if (userid != null && !userid.isEmpty()) {
        // 폼에서 전달된 데이터 가져오기
        String wheel = request.getParameter("wheel");
        String nav = request.getParameter("dis");
        String key = request.getParameter("led");
        String totalExtraCost = request.getParameter("totalExtraCost");
        System.out.println("totalExtraCost: " + totalExtraCost);

        // 선택된 옵션들을 배열로 받기
        String[] options = request.getParameterValues("options");

        // 모델명은 고정된 값
        String carname = "Santa Fe"; // 모델명은 고정일 수도 있습니다.

        // CaroptionDto 객체 생성 및 값 설정
        CaroptionDto dto = new CaroptionDto();
        dto.setUserid(userid);
        dto.setCarname(carname);
        dto.setWheel(wheel);
        dto.setNav(nav);
        dto.setCarkey(key);
        dto.setEtc(totalExtraCost);

        // 선택된 옵션들을 콤마(,)로 구분하여 문자열로 저장
        if (options != null && options.length > 0) {
            String selectedOptions = String.join(",", options);
            dto.setCaroption(selectedOptions);
        }

        // CaroptionDao 객체 생성
        CaroptionDao dao = new CaroptionDao();

        // 데이터베이스에 데이터 삽입
        dao.insertCaroption(dto);

        // 차량 옵션 등록 성공 후 메시지 처리
        response.sendRedirect("list.jsp"); // 등록 후 이동할 페이지 설정
    } else {
        // 로그인 상태가 아니면 로그인 페이지로 리다이렉트
        response.sendRedirect("userlogin.jsp");
    }
%>
