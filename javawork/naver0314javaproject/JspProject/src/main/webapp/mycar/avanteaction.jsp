<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="data.dto.CaroptionDto" %>
<%@ page import="data.dao.CaroptionDao" %>
<%@ page import="data.dto.UserDto" %>
<%@ page import="data.dao.UserDao" %>
<%@ page import="java.util.Arrays" %>

<%
    // 세션을 통해 사용자 ID 가져오기
    String userid = (String) session.getAttribute("userid");

    // 세션에서 사용자 ID가 존재하는지 확인
    if (userid != null && !userid.isEmpty()) {
        // 폼에서 전달된 데이터 가져오기
        String wheel = request.getParameter("wheel");
        String nav = request.getParameter("nav");
        String key = request.getParameter("key");
        String option = request.getParameter("option");
        String carname = "아반떼"; // 모델명은 고정일 수도 있습니다.

        // CaroptionDto 객체 생성 및 값 설정
        CaroptionDto dto = new CaroptionDto();
        dto.setUserid(userid);
        dto.setCarname(carname);
        dto.setWheel(wheel);
        dto.setNav(nav);
        dto.setCarkey(key);
        dto.setCaroption(option);

        // CaroptionDao 객체 생성
        CaroptionDao dao = new CaroptionDao();

        // 데이터베이스에 데이터 삽입
        dao.insertCaroption(dto);

        // 차량 옵션 등록 성공 후 메시지 처리
        response.sendRedirect("index.jsp");
    } else {
        // 로그인 상태가 아니면 로그인 페이지로 리다이렉트
        response.sendRedirect("userlogin.jsp");
    }
%>
