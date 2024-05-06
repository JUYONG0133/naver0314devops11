<%@ page import="data.dto.UserDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>승용 자동차 견적</title>
    <!-- 부트스트랩 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 구글 폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- 부트스트랩 자바스크립트 (팝오버 등) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f8f9fa;
            padding-top: 60px; /* 네비게이션 바의 높이만큼 상단 패딩 추가 */
        }
        .model img {
            height: 200px;
            width: 250px;
        }
        .option-label {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .option-label img {
            height: 150px;
            margin-bottom: 5px;
            cursor: pointer; /* 이미지에 커서를 포인터로 변경하여 클릭 가능하게 만듦 */
        }
    </style>
</head>
<body>

<div class="container mt-3">
    <div class="row">
        <div class="col-md-4">
            <h1>승용차</h1>
            <p>당신의 자동차를 만들어보세요</p>
        </div>
        <div class="col-md-6 d-flex justify-content-end">
            <table class="model">
                <tr>
                    <td width="500" align="left">
                        <h5>모 델 명: 아반떼</h5>
                    </td>
                    <td width="500" align="right">
                        <img src="../model/sedan.png" alt="아반떼 이미지" style="max-width: 100%;">
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>

<%
    // 사용자 정보를 생성합니다.
    UserDto dto = new UserDto();
%>

<form action="./avanteaction.jsp" method="post">
    <input type="hidden" name="num" value="<%=dto.getUserid()%>">
    <table class="table">
        <tr>
            <th width="100">휠 선택:</th>
            <td width="150" align="center">
                <img src="../aventeoption/wheel15.jpeg" class="wheel option-img" alt="Wheel Option">
                <select class="form-select option-select" name="wheel" id="wheel"> <!-- ID 추가 -->
                    <option value="../aventeoption/wheel15.jpeg" name="wheel">15인치 알로이 휠 & 타이어</option>
                    <option value="../aventeoption/wheel16.jpeg" name="wheel">16인치 알로이 휠 & 타이어</option>
                    <option value="../aventeoption/wheel17.jpeg" name="wheel">17인치 알로이 휠 & 타이어</option>
                </select>
            </td>
            <td width="150" align="center">
                <img src="../aventeoption/nav1.jpeg" class="nav option-img" alt="Navigation Option">
                <select class="form-select option-select" name="nav" id="nav"> <!-- ID 추가 -->
                    <option value="../aventeoption/nav1.jpeg">8인치 내비게이션</option>
                    <option value="../aventeoption/nav2.jpeg">12인치 내비게이션</option>
                </select>
            </td>
            <td width="150" align="center">
                <img src="../aventeoption/key.jpeg" class="key option-img" alt="Key Option">
                <select class="form-select option-select" name="key" id="key"> <!-- ID 추가 -->
                    <option value="../aventeoption/key.jpeg">폴딩타입 도어 리모컨 키</option>
                    <option value="../aventeoption/smartkey.jpeg">버튼시동 & 스마트키</option>
                </select>
            </td>

        </tr>
    </table>

    <table class="table">
        <tr>
            <th colspan="4" class="table-info">지능형 안전기술옵션</th>
        </tr>
        <tr style="height: 200px;">
            <td>
                <label class="option-label">
                    <img src="../aventeoption/hba.jpeg" alt="하이빔보조 Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalHBA">
                    <input type="checkbox" name="option"> 하이빔 보조
                </label>
            </td>
            <td>
                <label class="option-label">
                    <img src="../aventeoption/fvsa.jpeg" alt="전방 차량 출발 알림 Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalFVSA">
                    <input type="checkbox" name="option"> 전방 차량 출발 알림
                </label>
            </td>
            <td>
                <label class="option-label">
                    <img src="../aventeoption/isla.jpeg" alt="지능형 속도 제한 보조 Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalISLA">
                    <input type="checkbox" name="option"> 지능형 속도 제한 보조
                </label>
            </td>
            <td>
                <label class="option-label">
                    <img src="../aventeoption/fca1.jpeg" alt="전방 충돌방지 보조 Option" class="option-img"   data-bs-toggle="modal" data-bs-target="#modalFCA">
                    <input type="checkbox" name="option"> 전방 충돌방지 보조
                </label>
            </td>
        </tr>
        <tr style="height: 200px;">
            <td>
                <label class="option-label">
                    <img src="../aventeoption/lfa.jpeg" alt="차로 유지 보조 Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalLFA">
                    <input type="checkbox" name="option"> 차로 유지 보조
                </label>
            </td>
            <td>
                <label class="option-label">
                    <img src="../aventeoption/lca.jpeg" alt="차로 이탈방지 보조 Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalLCA">
                    <input type="checkbox" name="option"> 차로 이탈방지 보조
                </label>
            </td>
            <td>
                <label class="option-label">
                    <img src="../aventeoption/daw.jpeg" alt="운전자 주의 경고 Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalDAW">
                    <input type="checkbox" name="option"> 운전자 주의 경고
                </label>
            </td>
            <td>
                <label class="option-label">
                    <img src="../aventeoption/bca1.jpeg" alt="후측방 충돌방지 보조 Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalBCA">
                    <input type="checkbox" name="option"> 후측방 충돌방지 보조
                </label>
            </td>
        </tr>
    </table>
    <button type="submit" class="btn btn-outline-info">적용하기</button>
</form>

<!-- 모달 선언 -->
<div class="modal fade" id="imageModal" tabindex="-1" aria-labelledby="imageModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">이미지 상세보기</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <img src="" class="modal-img" alt="Modal Image" style="width: 100%;">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger btn-lg" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function() {
        // 이미지를 클릭하면 모달에 이미지 표시
        $(".option-img").click(function () {
            let imgSrc = $(this).attr("src");
            $(".modal-img").attr("src", imgSrc);
            $("#imageModal").modal("show");
        });

        // 휠 선택 시 이미지 변경
            // 휠 선택 시 이미지 변경
            $("#wheel").change(function () { // ID를 올바르게 참조
                let src = $(this).val();
                $(".wheel").attr("src", src);
            });

            // 네비게이션 선택 시 이미지 변경
            $("#nav").change(function() { // ID를 올바르게 참조
            let src = $(this).val();
            $(".nav").attr("src", src);
        });

            // 키 선택 시 이미지 변경
            $("#key").change(function() { // ID를 올바르게 참조
            let src = $(this).val();
            $(".key").attr("src", src);
        });
        });
</script>

</script>

</body>
</html>
