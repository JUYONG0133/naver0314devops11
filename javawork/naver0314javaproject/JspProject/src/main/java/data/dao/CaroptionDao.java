package data.dao;

import data.dto.CaroptionDto;

import data.dto.UserDto;
import db.common.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CaroptionDao {
    private MysqlConnect db = new MysqlConnect();
    // 사용자 추가 메서드
    public void insertCaroption(CaroptionDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = db.getConnection();
            String sql = "INSERT INTO user (wheel, nav, carkey, caroption) VALUES (?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getWheel());
            pstmt.setString(2, dto.getNav());
            pstmt.setString(3, dto.getCarkey());
            pstmt.setString(4, dto.getCaroption());
            //pstmt.setString(5,dto.getUserid());

            pstmt.executeUpdate(); // 데이터베이스에 사용자 정보 삽입

        } catch (SQLException e) {
            throw new RuntimeException("사용자 추가 중 오류 발생: " + e.getMessage());
        } finally {
            db.dbClose(pstmt, conn); // 리소스 닫기
        }
    }
}
