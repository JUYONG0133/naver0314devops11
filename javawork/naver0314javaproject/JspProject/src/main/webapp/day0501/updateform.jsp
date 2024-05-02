<%@ page import="data.dao.StudentDao" %>
<%@ page import="data.dto.StudentDto" %><%--
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
    //shopidx int 타입으로 읽기
    int num=Integer.parseInt(request.getParameter("num"));
    //dao 선언
    StudentDao dao=new StudentDao();
    //dto 가져오기
    StudentDto dto=dao.getData(num);

%>

<body>
<div style="margin: 10px;width: 400px;">
    <form action="./updateaction.jsp" method="post">
        <input type="hidden" name="num" value="<%=num%>">
        <table class="table table-bordered">
            <caption align="top"><b>[학생정보입력]</b></caption>
            <tr>
                <th class="table-warning" width="100">이름</th>
                <td>
                    <input type="text" name="name" class="form-control" style="width: 130px;" value="<%=dto.getName()%>" required>
                </td>
            </tr>
            <tr>
                <th class="table-warning" width="100">혈액형</th>
                <td>
                    <select class="form-select" name="blood">
                        <%
                            String s[] = {"A", "B", "AB", "O"};
                            String selectedblood = dto.getBlood(); // dto에서 부서 값을 가져옴

                            for (int j = 0; j < s.length; j++) {
                                if (s[j].equals(selectedblood)) {
                        %>
                        <option value="<%=s[j]%>" selected><%=s[j]%></option>
                        <%
                        } else {
                        %>
                        <option value="<%=s[j]%>"><%=s[j]%></option>
                        <%
                                }
                            }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <th class="table-warning" width="100">운전면허</th>
                <td>
                    <label>
                        <input type="checkbox" name="license" <%=dto.getLicense()=='y'?"checked":""%>>&nbsp;운전면허 보유
                    </label>
                </td>
            </tr>
            <tr>
                <th class="table-warning" width="100">자바점수</th>
                <td>
                    <input type="number" min="0" max="100" value="<%=dto.getJava()%>" name="java" class="form-control" style="width: 130px;" required>
                </td>
            </tr>
            <tr>
                <th class="table-warning" width="100">스프링점수</th>
                <td>
                    <input type="number" min="0" max="100" value="<%=dto.getSpring()%>" name="spring" class="form-control" style="width: 130px;" required>
                </td>
            </tr>
            <tr>
                <th class="table-warning" width="100">html점수</th>
                <td>
                    <input type="number" min="0" max="100" value="<%=dto.getHtml()%>" name="html" class="form-control" style="width: 130px;" required>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center" >
                    <button type="submit" class="btn btn-info">학생정보수정</button>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>

