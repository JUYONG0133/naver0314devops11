<%@ page import="data.dto.ShopDto" %>
<%@ page import="data.dao.ShopDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //1.엔코딩
    request.setCharacterEncoding("utf-8");
    //2. 6개의 상품데이터 읽기
    //shopidx 값 읽기
    String shopidx = request.getParameter("shopidx");
    String sname=request.getParameter("sname");
    String scolor=request.getParameter("scolor");
    String sphoto=request.getParameter("sphoto");
    int sprice = Integer.parseInt(request.getParameter("sprice"));
    int scount = Integer.parseInt(request.getParameter("scount"));

    //3. dto에 넣기 -setter 로 넣기
    ShopDto dto = new ShopDto();
    dto.setShopidx(shopidx);   // 상품 인덱스 설정
    dto.setSname(sname);       // 상품명 설정
    dto.setScolor(scolor);     // 색상 설정
    dto.setSphoto(sphoto);     // 사진 경로 설정
    dto.setSprice(sprice);     // 가격 설정
    dto.setScount(scount);     // 수량 설정
    //4. dao 선언
    ShopDao dao = new ShopDao();
    //5. update 메소드 호출
    dao.updateShop(dto);
    //6. shoplist.jsp로 이동
    response.sendRedirect("shoplist.jsp"); //url 주소 바뀜
%>
