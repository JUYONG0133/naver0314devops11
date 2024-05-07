<%@ page import="data.dto.UserDto" %>
<%@ page import="data.dto.CaroptionDto" %>
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
            /*cursor: pointer; !* 이미지에 커서를 포인터로 변경하여 클릭 가능하게 만듦 *!*/
        }
        #totalExtraCost {
            font-weight: bold;
            font-size: 18px;
            color: #007bff;
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
    </style>
</head>
<body>

<div class="container mt-3">
    <div class="row">
        <div class="col-md-4">
            <h1>전기차</h1>
            <p>당신의 자동차를 만들어보세요</p>
        </div>
        <div class="col-md-6 d-flex justify-content-end">
            <table class="model">
                <tr>
                    <td width="500" align="left">
                        <h5>모 델 명: 전기차</h5>
                        <h6>기본 차량 가격 : 60,000,000</h6>

                    </td>
                    <td width="1000" align="right">
                        <img src="../model/electric.png" alt="아이오닉 6 이미지" style="max-width: 100%;">
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>

<%
    // 사용자 정보를 생성합니다.
    CaroptionDto dto = new CaroptionDto();
%>

<form action="./ioniqaction.jsp" method="post" id="optionsForm">
    <input type="hidden" name="num" value="<%=dto.getNum()%>">
    <input type="hidden" name="totalExtraCost" id="extraCostInsert" value="0" min="0">
    <table class="table">
        <tr>
            <th width="100">옵션 선택 : </th>
            <td width="150" align="center">
                <img id="wheelImage" src="../ioniqoption/wheel18.jpeg" class="wheel option-img" alt="Wheel Option">
                <select class="form-select option-select" name="wheel" id="wheelSelect">
                    <option value="../ioniqoption/wheel18.jpeg" data-price="0">18인치 알로이 휠 & 타이어</option>
                    <option value="../ioniqoption/wheel20.jpeg" data-price="1300000">20인치 알로이 휠 & 타이어 (+1,300,000)</option>
                </select>
            </td>
            <td width="150" align="center">
                <img id="navImage" src="../ioniqoption/mir.jpeg" class="nav option-img" alt="Navigation Option">
                <select class="form-select option-select" name="nav" id="navSelect">
                    <option value="../ioniqoption/mir.jpeg" data-price="0">아웃사이드 미러</option>
                    <option value="../ioniqoption/mir2.jpeg" data-price="1380000">디지털 사이드 미러 (+1,380,000)</option>
                </select>
            </td>
            <td width="150" align="center">
                <img id="keyImage" src="../ioniqoption/53kwh.jpg" class="key option-img" alt="Key Option">
                <select class="form-select option-select" name="key" id="keySelect">
                    <option value="../ioniqoption/53kwh.jpg" data-price="0">53.0kWh 리튬 이온 배터리</option>
                    <option value="../ioniqoption/77kwh.jpg" data-price="1600000">77.4kWh 리튬 이온 배터리 (+1,600,000)</option>
                </select>
            </td>
        </tr>
        <tr>
            <th>추가 비용:</th>
            <td colspan="4" id="totalExtraCost">
                <input type="number" name="totalExtraCost" id="extraCostInput" value="0" min="0"> 원
            </td>

        </tr>
    </table>
    <table class="table">
        <tr>
            <th colspan="4" class="table-info">추가 옵션</th>
        </tr>
        <tr style="height: 200px;">
            <td>
                <label class="option-label">
                    <img src="../ioniqoption/hba.jpeg" alt="하이빔보조 Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalHBA">
                    <input type="checkbox" name="options" value="하이빔 보조"> 하이빔 보조
                </label>
            </td>
            <td>
                <label class="option-label">
                    <img src="../ioniqoption/scc.jpeg" alt="스마트 크루즈 컨트롤(운전 스타일 연동 포함) Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalFVSA">
                    <input type="checkbox" name="options" value="스마트 크루즈 컨트롤(운전 스타일 연동 포함)"> 스마트 크루즈 컨트롤(운전 스타일 연동 포함)
                </label>
            </td>
            <td>
                <label class="option-label">
                    <img src="../ioniqoption/airbag.jpeg" alt="7에어백 시스템 Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalISLA">
                    <input type="checkbox" name="options" value="7에어백 시스템"> 7에어백 시스템
                </label>
            </td>
            <td>
                <label class="option-label">
                    <img src="../ioniqoption/v2l.jpeg" alt="실외 V2L 커넥터 Option" class="option-img"   data-bs-toggle="modal" data-bs-target="#modalFCA">
                    <input type="checkbox" name="options" value="실외 V2L 커넥터"> 실외 V2L 커넥터
                </label>
            </td>
        </tr>
        <tr style="height: 200px;">
            <td>
                <label class="option-label">
                    <img src="../ioniqoption/12_3.jpg" alt="12.3인치 내비게이션" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalLFA">
                    <input type="checkbox" name="options" value="12.3인치 내비게이션"> 12.3인치 내비게이션
                </label>
            </td>
            <td>
                <label class="option-label">
                    <img src="../ioniqoption/lca.jpeg" alt="차로 이탈방지 보조 Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalLCA">
                    <input type="checkbox" name="options" value="차로 이탈방지 보조"> 차로 이탈방지 보조
                </label>
            </td>
            <td>
                <label class="option-label">
                    <img src="../ioniqoption/sbw.jpeg" alt="전자식 변속 칼럼 Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalDAW">
                    <input type="checkbox" name="options" value="전자식 변속 칼럼"> 전자식 변속 칼럼
                </label>
            </td>
            <td>
                <label class="option-label">
                    <img src="../ioniqoption/48.jpeg" alt="800V 멀티 충전 시스템 Option" class="option-img"  data-bs-toggle="modal" data-bs-target="#modalBCA">
                    <input type="checkbox" name="options" value="800V 멀티 충전 시스템"> 800V 멀티 충전 시스템
                </label>
            </td>
        </tr>
    </table>
    <div class="d-grid gap-2 col-6 mx-auto mt-3">
    <button type="submit" class="btn btn-info">적용하기</button>
        </div>
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
            // 이미지를 클릭하면 모달에 이미지 표시
            $(".option-img").click(function () {
                let imgSrc = $(this).attr("src");
                $(".modal-img").attr("src", imgSrc);
                $("#imageModal").modal("show");
            });

            // 휠 선택 시 이미지 변경
            $("#wheelSelect").change(function () {
                let selectedWheelOption = $(this).find('option:selected');
                let wheelImgSrc = selectedWheelOption.val();
                $("#wheelImage").attr("src", wheelImgSrc);
                updateTotalExtraCost();
            });

            // 네비게이션 선택 시 이미지 변경
            $("#navSelect").change(function () {
                let selectedNavOption = $(this).find('option:selected');
                let navImgSrc = selectedNavOption.val();
                $("#navImage").attr("src", navImgSrc);
                updateTotalExtraCost();
            });

            // 키 선택 시 이미지 변경
            $("#keySelect").change(function () {
                let selectedKeyOption = $(this).find('option:selected');
                let keyImgSrc = selectedKeyOption.val();
                $("#keyImage").attr("src", keyImgSrc);
                updateTotalExtraCost();
            });

            // 추가 비용 업데이트 함수
        function updateTotalExtraCost() {
            let totalCost = 0;

            // 휠 선택 추가 비용 계산
            let wheelExtraPrice = parseInt($("#wheelSelect option:selected").data('price')) || 0;
            totalCost += wheelExtraPrice;

            // 내비게이션 선택 추가 비용 계산
            let navExtraPrice = parseInt($("#navSelect option:selected").data('price')) || 0;
            totalCost += navExtraPrice;

            // 키 선택 추가 비용 계산
            let keyExtraPrice = parseInt($("#keySelect option:selected").data('price')) || 0;
            totalCost += keyExtraPrice;

            // 총 추가 비용 화면에 업데이트
            let formattedCost = totalCost.toLocaleString('ko-KR') + '원';
            $("#totalExtraCost").text(formattedCost);

            // #extraCostInput에 값 업데이트
            $("#extraCostInsert").val(totalCost); // input 요소의 값을 업데이트

            return totalCost; // 업데이트된 총 비용 반환
        }

            // 페이지 로드 시 초기 계산 수행
            updateTotalExtraCost();
        });

</script>

</body>
</html>
