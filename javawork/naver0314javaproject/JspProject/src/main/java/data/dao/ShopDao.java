package data.dao;

import data.dto.ShopDto;
import db.common.MysqlConnect;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class ShopDao {
    MysqlConnect connect=new MysqlConnect();

    public void insertShop(ShopDto dto)
    {
        Connection conn=null;
        PreparedStatement pstmt=null;

        String sql=" insert into myshop (sname,sprice,scount,scolor,sphoto,writeday) values (?,?,?,?,?,now()) ";
        conn=connect.getConnection();//db 연결
        try {
            pstmt=conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, dto.getSname());
            pstmt.setInt(2, dto.getSprice());
            pstmt.setInt(3, dto.getScount());
            pstmt.setString(4, dto.getScolor());
            pstmt.setString(5, dto.getSphoto());
            //실행
            pstmt.execute();

        } catch (SQLException e) {
            System.out.println("insert 오류:"+e.getMessage());
        }finally {
            connect.dbClose(pstmt, conn);
        }

    }

    public List<ShopDto> getShopDatas()
    {
        List<ShopDto> list=new Vector<ShopDto>();
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select * from myshop order by shopidx desc";

        conn=connect.getConnection();
        try {
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()) {
                ShopDto dto=new ShopDto();
                //db 에서 가져와서 dto에 넣기
                dto.setShopidx(rs.getString("shopidx"));
                dto.setSname(rs.getString("sname"));
                dto.setSprice(rs.getInt("sprice"));
                dto.setScount(rs.getInt("scount"));
                dto.setScolor(rs.getString("scolor"));
                dto.setSphoto(rs.getString("sphoto"));
                dto.setWriteday(rs.getTimestamp("writeday"));

                //list 추가
                list.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("select 오류:"+e.getMessage());
        }finally {
            connect.dbClose(rs, pstmt, conn);
        }

        return list;
    }

    public ShopDto getSangpum(int shopidx)
    {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select * from myshop where shopidx=?";

        ShopDto dto=new ShopDto();

        conn=connect.getConnection();
        try {
            pstmt=conn.prepareStatement(sql);
            //바인딩
            pstmt.setInt(1, shopidx);
            //실행
            rs=pstmt.executeQuery();
            if(rs.next()) {
                dto.setShopidx(rs.getString("shopidx"));
                dto.setSname(rs.getString("sname"));
                dto.setSprice(rs.getInt("sprice"));
                dto.setScount(rs.getInt("scount"));
                dto.setScolor(rs.getString("scolor"));
                dto.setSphoto(rs.getString("sphoto"));
                dto.setWriteday(rs.getTimestamp("writeday"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            connect.dbClose(rs, pstmt, conn);
        }

        return dto;

    }

    public void updateShop(ShopDto dto) {
        String sql = "update myshop set sname=?, scolor=?, sprice=?, scount=?, sphoto=? where shopidx=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
       // ResultSet rs = null;
        conn = connect.getConnection();
        try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, dto.getSname());     // 상품명
                pstmt.setString(2, dto.getScolor());    // 색상
                pstmt.setInt(3, dto.getSprice());       // 가격
                pstmt.setInt(4, dto.getScount());       // 수량
                pstmt.setString(5, dto.getSphoto());    // 사진 경로
                pstmt.setInt(6, Integer.parseInt(dto.getShopidx()));   // 상품 인덱스
                pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("updateShop 오류: " + e.getMessage(), e);
        } finally {
            connect.dbClose(pstmt, conn);
        }

    }



    public void deleteShop(int shopidx){
        String sql = "delete from myshop where shopidx=?";
        Connection conn = null;
        PreparedStatement pstmt =null;
        conn=connect.getConnection();
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,shopidx);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connect.dbClose(pstmt,conn);
        }
    }
}
