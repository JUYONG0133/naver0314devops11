<%@ page import="data.dao.ShopDao" %>
<%@ page import="java.util.List" %>
<%@ page import="data.dto.ShopDto" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    ShopDao dao = new ShopDao();
    List<ShopDto> list = dao.getShopDatas();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    JSONArray array = new JSONArray();
    for(ShopDto dto : list){
        JSONObject ob = new JSONObject();
        ob.put("shopidx",dto.getShopidx());
        ob.put("sname",dto.getSname());
        ob.put("sprice",dto.getSprice());
        ob.put("scount",dto.getScount());
        ob.put("scolor",dto.getScolor());
        ob.put("sphoto",dto.getSphoto());
        ob.put("writeday",sdf.format(dto.getWriteday()));

        array.add(ob);
    }
%>
<%=array.toString()%>