<%@ page import="data.dao.StudentDao" %>
<%@ page import="data.dto.StudentDto" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
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
    int num = Integer.parseInt(request.getParameter("num"));
    StudentDao dao = new StudentDao();
    StudentDto dto = dao.getData(num);
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<body>
<div style="margin: 10px;width: 500px;">

    <span style="font-size: 14px;color: gray;">
		등록일 :  <%=sdf.format(dto.getWriteday()) %>
	</span>

    <table>
        <tr>
            <td>
                <h5>이 름 : <%=dto.getName() %></h5>
                <h5>혈액형 : <%=dto.getBlood() %>형</h5>
                <h5>운전면허 : <%=dto.getLicense()=='y'?"운전면허 보유":"운전면허 없음"%></h5>
                <h5>자바 점수 : <%=dto.getJava()%></h5>
                <h5>스프링 점수 : <%=dto.getSpring()%></h5>
                <h5>HTML 점수 : <%=dto.getHtml()%></h5>
                <h5>총점수 : <%=dto.getHtml()+dto.getSpring()+dto.getJava()%></h5>
                <h5>평 균 : <%=String.format("%.2f",(dto.getHtml()+dto.getSpring()+dto.getJava())/3.0)%></h5>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="button" class="btn btn-outline-danger btn-sm"
                        style="width: 80px;"
                        onclick="location.href='list.jsp'">목록</button>

                <button type="button" class="btn btn-outline-danger btn-sm"
                        style="width: 80px;"
                        onclick="location.href='updateform.jsp?num=<%=dto.getNum()%>'">수정</button>

                <button type="button" class="btn btn-outline-danger btn-sm"
                        style="width: 80px;"
                        num="<%=num%>" id="delstu" name="<%=dto.getName()%>">삭제</button>

                <button type="button" class="btn btn-outline-danger btn-sm"
                        style="width: 80px;"
                        onclick="location.href='writeform.jsp'">상품추가</button>
            </td>
        </tr>
    </table>
</div>
<script type="text/javascript">
    //삭제2버튼 이벤트
    $("#delstu").click(function(){
        let num=$(this).attr("num");
        let name=$(this).attr("name");
        let a=confirm(`\${name} 사원정보를  삭제할까요?`);//jsp에서는 $기능이 이미 있으므로 스크립트에서 변수를 넣을경우 \${변수명}
        if(a){
            location.href="delete.jsp?num="+num;//페이지 이동
        }
    });
</script>

</body>
</html>

