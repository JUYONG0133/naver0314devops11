<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="data.dao.CaroptionDao" %>
<%@ page import="data.dto.CaroptionDto" %>
<%@ page import="java.text.NumberFormat" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 옵션 정보</title>
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
        .btn-back {
            margin-bottom: 20px;
        }
        .option-image {
            max-width: 100px;
            height: auto;
        }
        .table th, .table td {
            vertical-align: middle;
        }
        .no-option {
            font-style: italic;
            color: #888;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="mb-5">내 옵션 정보</h1>
    <a href="./main.jsp" class="btn btn-danger btn-back">목록으로 돌아가기</a>
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">차량 이름</th>
            <th scope="col">차량 옵션 가격</th>
            <th scope="col">차량 총 가격</th>
            <th scope="col">휠</th>
            <th scope="col">디스플레이</th>
            <th scope="col">기타 옵션</th>
            <th scope="col">추가 옵션</th>
            <th scope="col">작업</th>
        </tr>
        </thead>
        <tbody>
        <%
            // 세션에서 사용자 아이디 가져오기
            String userId = (String) session.getAttribute("userid");

            // 사용자 아이디로 옵션 정보 조회
            CaroptionDao dao = new CaroptionDao();
            List<CaroptionDto> options = dao.getOptionsByUserId(userId);

            for (CaroptionDto option : options) {
                int basePrice = Integer.parseInt(option.getEtc());
                int totalPrice = 0;
                if(option.getCarname().equals("Avente")) {
                    totalPrice = basePrice + 20000000;
                }
                else if(option.getCarname().equals("Santa Fe")){
                    totalPrice = basePrice + 40000000;
                }else if(option.getCarname().equals("IONIQ 6")){
                    totalPrice = basePrice + 60000000;
                }

                // Create a NumberFormat instance for formatting numbers with commas
                NumberFormat numberFormat = NumberFormat.getNumberInstance();
                String formattedTotalPrice = numberFormat.format(totalPrice); // Format the number
        %>
        <tr>
            <td><%= option.getUserid() %></td>
            <td><%= option.getCarname() %></td>
            <td><%= basePrice %></td>
            <td><%= formattedTotalPrice %></td>
            <td><img src="<%= option.getWheel() %>" class="option-image"></td>
            <td><img src="<%= option.getNav() %>" class="option-image"></td>
            <td><img src="<%= option.getCarkey() %>" class="option-image"></td>
            <td>
                <%
                    String carOption = option.getCaroption();
                    if (carOption == null || carOption.isEmpty()) {
                %>
                <span class="no-option">없음</span>
                <%
                } else {
                    String[] optionsArray = carOption.split(",");
                    // 옵션을 줄바꿈과 함께 출력
                    for (String opt : optionsArray) {
                %>
                <%= opt.trim() %><br>
                <%
                        }
                    }
                %>
            </td>
            <td>
                <!-- 수정 버튼 -->
                <form action="editoption.jsp?num=<%=option.getNum()%>" method="post">
                    <input type="hidden" name="optionId" value="<%= option.getNum() %>">
                    <button type="submit" class="btn btn-info">수정</button>
                </form>
                <br>
                <!-- 삭제 버튼 -->
                <form action="deleteoption.jsp?num=<%=option.getNum()%>" method="post">
                    <input type="hidden" name="optionId" value="<%= option.getNum() %>">
                    <button type="submit" class="btn btn-danger">삭제</button>
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

<!-- 부트스트랩 JS (선택적으로 추가) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
