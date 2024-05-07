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
[파이낸셜뉴스] 한 신축 아파트에서 건물 외벽은 물론 콘크리트 골조가 휘는 등의 하자가 발견돼 논란이다. 해당 아파트는 이번 달 말 입주를 앞두고 있어 입주민들 사이에서 불만의 목소리가 터져 나온 상황이다.

지난 6일 한 온라인 커뮤니티에는 '역대급 하자 나온 신축 아파트'라는 제목의 글이 게재됐다.

작성자 A씨는 "한눈에 봐도 건물 외벽이 휜 모습"이라며 "지진 나면 전부 다 죽는 거 아닌지 (모르겠다)"라고 우려를 표했다.

문제는 외벽뿐만 아니라 내부에서도 발견됐다. 그는 "엘리베이터 옆 바닥과 벽면 연결 부위가 휘었다"며 "타일과 벽 라인을 보면 수직, 수평이 안 맞고 난리가 났다"고 분통을 터뜨렸다.

최상층 실외기실 슬라브 사진도 첨부했다. 이에 대해 A씨는 "벌써 내려앉고 있는 중"이라며 "콘크리트 골조가 휘어진 모양새"라고 지적했다.

창과 바닥에 틈새가 생긴 사진도 보는 이들을 놀라게 했다. 공사 중 인부가 쓴 것으로 추정되는 낙서도 고스란히 남아 있었다. 또 계단 곳곳에는 파손된 타일들도 발견됐다.

A씨는 "집마다 하자가 평균 150개, 많게는 200개 이상 나오고 공용하자가 판을 친다"고 말했다.

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

