package data.dao;

import data.dto.MemoDto;
import db.common.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class MemoDao {

    MysqlConnect db = new MysqlConnect();

    public void insertMemo(MemoDto dto){
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into mymemo (uploadphoto,title,content,writeday) values (?,?,?,now())";

        try {
            pstmt= conn.prepareStatement(sql);
            pstmt.setString(1,dto.getUploadPhoto());
            pstmt.setString(2, dto.getTitle());
            pstmt.setString(3,dto.getContent());
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            db.dbClose(pstmt,conn);
        }
    }
    public List<MemoDto> getAllMemo() {
        List<MemoDto> list = new Vector<>();
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from mymemo order by num desc";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                MemoDto dto = new MemoDto();
                dto.setNum(rs.getInt("num"));
                dto.setUploadPhoto(rs.getString("uploadphoto"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWriteday(rs.getTimestamp("writeday"));
                list.add(dto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(pstmt, conn);

        }
        return list;
    }
    public MemoDto getData(int num){
        MemoDto dto = new MemoDto();
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from mymemo where num=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,num);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto.setNum(rs.getInt("num"));
                dto.setUploadPhoto(rs.getString("uploadphoto"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWriteday(rs.getTimestamp("writeday"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(pstmt, conn);

        }
        return dto;
    }
}
