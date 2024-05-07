<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="data.dao.CaroptionDao" %>
<%@ page import="data.dto.CaroptionDto" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>옵션 정보 수정</title>
    <!-- 부트스트랩 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        @import url('https://fonts.googleapis.com/css?family=Amatic+SC');

        body {
            margin: 0;
            height: 100%;
            background-image: linear-gradient(to top, #d9afd9 0%, #97d9e1 100%);
            background-repeat: no-repeat;
            background-size: cover;
            background-attachment: fixed;
        }

        .button_container {
            position: absolute;
            left: 0;
            right: 0;
            top: 30%;
        }

        .description, .link {
            font-family: 'Amatic SC', cursive;
            text-align: center;
        }

        .description {
            font-size: 35px;
        }

        .btn {
            border: none;
            display: block;
            text-align: center;
            cursor: pointer;
            text-transform: uppercase;
            outline: none;
            overflow: hidden;
            position: relative;
            color: #fff;
            font-weight: 700;
            font-size: 15px;
            background-color: #222;
            padding: 17px 60px;
            margin: 0 auto;
            box-shadow: 0 5px 15px rgba(0,0,0,0.20);
        }

        .btn span {
            position: relative;
            z-index: 1;
        }

        .btn:after {
            content: "";
            position: absolute;
            left: 0;
            top: 0;
            height: 490%;
            width: 140%;
            background: #78c7d2;
            -webkit-transition: all .5s ease-in-out;
            transition: all .5s ease-in-out;
            -webkit-transform: translateX(-98%) translateY(-25%) rotate(45deg);
            transform: translateX(-98%) translateY(-25%) rotate(45deg);
        }

        .btn:hover:after {
            -webkit-transform: translateX(-9%) translateY(-25%) rotate(45deg);
            transform: translateX(-9%) translateY(-25%) rotate(45deg);
        }

        .link {
            font-size: 20px;
            margin-top: 30px;
        }

        .link a {
            color: #000;
            font-size: 25px;
        }

    </style>
</head>
<body>

<div class="container">
    <h1 class="mb-5">옵션 정보 수정</h1>

        <a class="btn" onclick="location.href='./list.jsp'">목록으로 돌아가기
        </a>

    <%
        // optionId를 request.getParameter로 받아옴
        String optionId = request.getParameter("optionId");
        // CaroptionDao 인스턴스 생성
        CaroptionDao dao = new CaroptionDao();
        // optionId에 해당하는 옵션 정보를 가져옴
        CaroptionDto option = dao.getOptionByNum(Integer.parseInt(optionId));
    %>
    <form action="updateoption.jsp" method="post">
        <!-- 수정할 옵션의 ID를 hidden input으로 전달 -->
        <input type="hidden" name="optionId" value="<%= option.getNum() %>">
        <table class="table">
            <tr>
                <th width="100">휠 선택:</th>
                <td width="150" align="center">
                    <img src="<%=option.getWheel()%>" class="wheel option-img" alt="Wheel Option">
                    <select class="form-select option-select" name="wheel" id="wheel"> <!-- ID 추가 -->
                        <option value="../aventeoption/wheel15.jpeg" <%= option.getWheel().equals("../aventeoption/wheel15.jpeg") ? "selected" : "" %>>15인치 알로이 휠 & 타이어</option>
                        <option value="../aventeoption/wheel16.jpeg" <%= option.getWheel().equals("../aventeoption/wheel16.jpeg") ? "selected" : "" %>>16인치 알로이 휠 & 타이어</option>
                        <option value="../aventeoption/wheel17.jpeg" <%= option.getWheel().equals("../aventeoption/wheel17.jpeg") ? "selected" : "" %>>17인치 알로이 휠 & 타이어</option>
                    </select>
                </td>

                <td width="150" align="center">
                    <img src="<%=option.getNav()%>" class="nav option-img" alt="Navigation Option">
                    <select class="form-select option-select" name="nav" id="nav"> <!-- ID 추가 -->
                        <option value="../aventeoption/nav1.jpeg" <%= option.getNav().equals("../aventeoption/nav1.jpeg") ? "selected" : "" %>>8인치 내비게이션</option>
                        <option value="../aventeoption/nav2.jpeg" <%= option.getNav().equals("../aventeoption/nav2.jpeg") ? "selected" : "" %>>12인치 내비게이션</option>
                    </select>
                </td>

                <td width="150" align="center">
                    <img src="<%=option.getCarkey()%>" class="carkey option-img" alt="Key Option">
                    <select class="form-select option-select" name="carkey" id="carkey"> <!-- ID 추가 -->
                        <option value="../aventeoption/key.jpeg" <%= option.getCarkey().equals("../aventeoption/key.jpeg") ? "selected" : "" %>>폴딩타입 도어 리모컨 키</option>
                        <option value="../aventeoption/smartkey.jpeg" <%= option.getCarkey().equals("../aventeoption/smartkey.jpeg") ? "selected" : "" %>>버튼시동 & 스마트키</option>
                    </select>
                </td>


            </tr>
        </table>
        <%
            // option.getCaroption()에서 반환된 값
            String carOptionsString = option.getCaroption(); // 예: "하이빔보조,전방차량출발알림,차로유지보조"

            // carOptionsString을 쉼표(,)를 기준으로 분할하여 배열로 저장
            String[] carOptions = carOptionsString.split(",");

            // 원하는 옵션들의 배열
            String[] desiredOptions = {
                    "하이빔 보조",
                    "전방 차량 출발 알림",
                    "지능형 속도 제한 보조",
                    "전방 충돌방지 보조",
                    "차로 유지 보조",
                    "차로 이탈방지 보조",
                    "운전자 주의 경고",
                    "후측방 충돌방지 보조"
            };
        %>
        <table class="table">
            <tr>
                <th colspan="4" class="table-info">지능형 안전기술옵션</th>
            </tr>
            <tr style="height: 200px;">
                <td>
                    <label class="option-label">
                        <img src="../aventeoption/hba.jpeg" alt="하이빔보조 Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalHBA">
                        <input type="checkbox" name="caroption" value="하이빔 보조" <%= Arrays.asList(carOptions).contains("하이빔보조") ? "checked" : "" %>> 하이빔 보조
                    </label>
                </td>
                <td>
                    <label class="option-label">
                        <img src="../aventeoption/fvsa.jpeg" alt="전방 차량 출발 알림 Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalFVSA">
                        <input type="checkbox" name="caroption" value="전방 차량 출발 알림" <%= Arrays.asList(carOptions).contains("전방 차량 출발 알림") ? "checked" : "" %>> 전방 차량 출발 알림
                    </label>
                </td>
                <td>
                    <label class="option-label">
                        <img src="../aventeoption/isla.jpeg" alt="지능형 속도 제한 보조 Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalISLA">
                        <input type="checkbox" name="caroption" value="지능형 속도 제한 보조" <%= Arrays.asList(carOptions).contains("지능형 속도 제한 보조") ? "checked" : "" %>> 지능형 속도 제한 보조
                    </label>
                </td>
                <td>
                    <label class="option-label">
                        <img src="../aventeoption/fca1.jpeg" alt="전방 충돌방지 보조 Option" class="option-img"   data-bs-toggle="modal" data-bs-target="#modalFCA">
                        <input type="checkbox" name="caroption" value="전방 충돌방지 보조" <%= Arrays.asList(carOptions).contains("전방 충돌방지 보조") ? "checked" : "" %>> 전방 충돌방지 보조
                    </label>
                </td>
            </tr>
            <tr style="height: 200px;">
                <td>
                    <label class="option-label">
                        <img src="../aventeoption/lfa.jpeg" alt="차로 유지 보조 Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalLFA">
                        <input type="checkbox" name="caroption" value="차로 유지 보조" <%= Arrays.asList(carOptions).contains("차로 유지 보조") ? "checked" : "" %>> 차로 유지 보조
                    </label>
                </td>
                <td>
                    <label class="option-label">
                        <img src="../aventeoption/lca.jpeg" alt="차로 이탈방지 보조 Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalLCA">
                        <input type="checkbox" name="caroption" value="차로 이탈방지 보조" <%= Arrays.asList(carOptions).contains("차로 이탈방지 보조") ? "checked" : "" %>> 차로 이탈방지 보조
                    </label>
                </td>
                <td>
                    <label class="option-label">
                        <img src="../aventeoption/daw.jpeg" alt="운전자 주의 경고 Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalDAW">
                        <input type="checkbox" name="caroption" value="운전자 주의 경고" <%= Arrays.asList(carOptions).contains("운전자 주의 경고") ? "checked" : "" %>> 운전자 주의 경고
                    </label>
                </td>
                <td>
                    <label class="option-label">
                        <img src="../aventeoption/bca1.jpeg" alt="후측방 충돌방지 보조 Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalBCA">
                        <input type="checkbox" name="caroption" value="후측방 충돌방지 보조" <%= Arrays.asList(carOptions).contains("후측방 충돌방지 보조") ? "checked" : "" %>> 후측방 충돌방지 보조
                    </label>
                </td>
            </tr>
        </table>


        <!-- 수정 완료 버튼 -->
        <button type="submit" class="btn btn-primary">저장</button>
        <!-- 취소 버튼 -->
        <a href="list.jsp" class="btn btn-secondary">취소</a>
    </form>
</div>

<!-- 부트스트랩 JS (선택적으로 추가) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
