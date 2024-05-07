<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 24. 4. 25.
  Time: 오후 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
      rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
    body * {
        font-family: 'Jua';
    }
</style>
<%
    //amho 라는 쿠키가 있으면 true, 없으면 false
    boolean findAmho = false;
    Cookie []cookies = request.getCookies();
    if(cookies!=null){
        for(Cookie ck : cookies){
            String name = ck.getName();
            if(name.equals("amho")){
                findAmho=true;
                break;
            }
        }
    }
%>
<body>
<%
    if(findAmho){%>
<pre>
[파이낸셜뉴스] 김정은 북한 국무위원장이 매년 25명의 처녀들을 '기쁨조(Pleasure Squad)'로 선발해 자신을 접대하도록 한다는 탈북 여성의 주장이 나왔다.

영국 미러, 데일리스타 등 외신 보도에 따르면 탈북자인 박연미(30) 씨는 자신이 두 번이나 기쁨조 후보로 영입됐지만 가족의 지위 때문에 선발되지 않았다고 주장했다.

미러는 탈북여성 박연미 씨의 주장을 바탕으로 기사를 보도했다. 박 씨는 기쁨조가 언제 등장했고 어떤 여성들을 선발하는 지에 대해 소개했다.

박 씨의 주장에 따르면 김정은 정권 관계자들은 예쁜 소녀들을 찾기 위해 모든 교실과 운동장을 방문한다. 예쁜 소녀를 발견하면 그들의 가족 상황, 즉 정치적 지위를 확인하고, 북한을 탈출한 가족이 있거나 한국이나 다른 나라에 친척이 있는 소녀는 제외시킨다고 한다.

박 씨는 기쁨조 아이디어는 김정일이 1970년대 고안했다고 설명했다. 예쁜 여자를 몇 명 골라 아버지인 김일성이 가던 휴양지에 데려다준 게 시작이라고 주장했다.

김정일은 1983년에는 자신을 위해 두 번째 기쁨조를 창설했다고 박 씨는 주장했다.

그는 “세 남자의 선호 여성 취향이 달라 팀 구성이 달라졌다”며 “김정일은 키가 작아 160cm 이상이지만 너무 크지 않은 여성을, 김정은 국무위원장은 날씬하고 서구적인 여성을 선호한다”고 설명했다.

북한 생활에 대한 설명이 과장됐다고 지적받기도 한 박 씨는 김씨 일가에 대해 “신으로 숭배받기를 기대하는 소아성애자”라고 주장했다.
#김정은 #탈북민 #기쁨조
    </pre>
<%}else {%>
<script type="text/javascript">
    alert("먼저 암호를 입력하세요");
    history.back();
</script>
<%}
%>
</body>
</html>

