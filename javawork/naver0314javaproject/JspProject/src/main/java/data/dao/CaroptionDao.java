package data.dao;

import data.dto.CaroptionDto;
import db.common.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CaroptionDao {
    private MysqlConnect db = new MysqlConnect();

    // 사용자 추가 메서드
    public void insertCaroption(CaroptionDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = db.getConnection();
            String sql = "INSERT INTO caroption (userid, carname, wheel, nav, carkey,etc, caroption,writeday) VALUES (?, ?, ?, ?, ?, ?,?,now())";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getUserid());
            pstmt.setString(2, dto.getCarname());
            pstmt.setString(3, dto.getWheel());
            pstmt.setString(4, dto.getNav());
            pstmt.setString(5, dto.getCarkey());
            pstmt.setString(6, dto.getEtc());
            pstmt.setString(7, dto.getCaroption());


            pstmt.executeUpdate(); // 데이터베이스에 사용자 정보 삽입

        } catch (SQLException e) {
            throw new RuntimeException("사용자 추가 중 오류 발생: " + e.getMessage());
        } finally {
            db.dbClose(pstmt, conn); // 리소스 닫기
        }
    }

    // 사용자별 옵션 정보 조회 메서드
    public List<CaroptionDto> getOptionsByUserId(String userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<CaroptionDto> options = new ArrayList<>();

        try {
            conn = db.getConnection();
            String sql = "SELECT * FROM caroption WHERE userid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                CaroptionDto option = new CaroptionDto();
                option.setNum(rs.getInt("num"));
                option.setUserid(rs.getString("userid"));
                option.setEtc(rs.getString("etc"));
                option.setCarname(rs.getString("carname"));
                option.setWheel(rs.getString("wheel"));
                option.setNav(rs.getString("nav"));
                option.setCarkey(rs.getString("carkey"));
                option.setCaroption(rs.getString("caroption"));
                options.add(option);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 예외 처리: 좀 더 세부적인 예외 처리가 필요할 수 있음
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

        return options;
    }

    // 옵션 정보 업데이트 메서드
    public boolean updateOption(CaroptionDto option) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            conn = db.getConnection();
            String sql = "UPDATE caroption SET wheel=?, nav=?, carkey=?, caroption=? WHERE num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, option.getWheel());
            pstmt.setString(2, option.getNav());
            pstmt.setString(3, option.getCarkey());
            pstmt.setString(4, option.getCaroption());
            pstmt.setInt(5, option.getNum());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 예외 처리: 좀 더 세부적인 예외 처리가 필요할 수 있음
        } finally {
            db.dbClose(pstmt, conn);
        }

        return success;
    }

    // 옵션 번호로 옵션 정보 조회 메서드
    public CaroptionDto getOptionByNum(int optionNum) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        CaroptionDto option = null;

        try {
            conn = db.getConnection();
            String sql = "SELECT * FROM caroption WHERE num = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, optionNum);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                option = new CaroptionDto();
                option.setNum(rs.getInt("num"));
                option.setUserid(rs.getString("userid"));
                option.setCarname(rs.getString("carname"));
                option.setWheel(rs.getString("wheel"));
                option.setNav(rs.getString("nav"));
                option.setCarkey(rs.getString("carkey"));
                option.setCaroption(rs.getString("caroption"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

        return option;
    }
    public void deleteoption(int num){
        String sql = "delete from caroption where num=?";
        Connection conn = null;
        PreparedStatement pstmt =null;
        conn=db.getConnection();
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,num);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            db.dbClose(pstmt,conn);
        }
    }
}
