<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="data.dao.CaroptionDao" %>
<%@ page import="data.dto.CaroptionDto" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>옵션 정보 업데이트</title>
    <!-- 부트스트랩 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Noto Sans KR', sans-serif;
            background-color: #f8f9fa;
        }
        .container {
            padding-top: 50px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="mb-5">옵션 정보 업데이트</h1>
    <%
        request.setCharacterEncoding("utf-8");
        String optionId = request.getParameter("optionId");
        String wheel = request.getParameter("wheel");
        String nav = request.getParameter("nav");
        String carkey = request.getParameter("carkey");
        String[] options = request.getParameterValues("caroption");

        CaroptionDao dao = new CaroptionDao();
        CaroptionDto option = new CaroptionDto();
        option.setNum(Integer.parseInt(optionId)); // 옵션 ID 설정
        option.setWheel(wheel);
        option.setNav(nav);
        option.setCarkey(carkey);
        if (options != null && options.length > 0) {
            String selectedOptions = String.join(",", options);
            option.setCaroption(selectedOptions);
        }

        boolean success = dao.updateOption(option);
    %>
    <% if (success) { %>
    <div class="alert alert-success" role="alert">
        옵션 정보가 성공적으로 업데이트되었습니다.
    </div>
    <% } else { %>
    <div class="alert alert-danger" role="alert">
        옵션 정보 업데이트에 실패했습니다.
    </div>
    <% } %>
    <a href="list.jsp" class="btn btn-primary">돌아가기</a>
</div>

<!-- 부트스트랩 JS (선택적으로 추가) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
