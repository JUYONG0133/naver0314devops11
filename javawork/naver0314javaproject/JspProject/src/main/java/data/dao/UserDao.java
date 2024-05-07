package data.dao;

import data.dto.CaroptionDto;
import data.dto.UserDto;
import db.common.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private MysqlConnect db = new MysqlConnect();

    // 사용자 ID 존재 여부 확인 메서드
    public boolean checkUserIdExists(String userid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean userIdExists = false;

        try {
            conn = db.getConnection();
            String sql = "SELECT * FROM user WHERE userid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userid);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                userIdExists = true; // 이미 사용 중인 사용자 ID가 존재함
            }
        } catch (SQLException e) {
            throw new RuntimeException("사용자 ID 확인 중 오류 발생: " + e.getMessage());
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

        return userIdExists;
    }

    // 사용자 추가 메서드
    public void insertUser(UserDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = db.getConnection();
            String sql = "INSERT INTO user (userid, userpassword, username, usergender) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getUserid());
            pstmt.setString(2, dto.getUserpassword());
            pstmt.setString(3, dto.getUsername());
            pstmt.setString(4, dto.getUsergender());

            pstmt.executeUpdate(); // 데이터베이스에 사용자 정보 삽입

        } catch (SQLException e) {
            throw new RuntimeException("사용자 추가 중 오류 발생: " + e.getMessage());
        } finally {
            db.dbClose(pstmt, conn); // 리소스 닫기
        }
    }

    // 사용자 인증 메서드
    public boolean loginUser(UserDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean loginSuccess = false;

        try {
            conn = db.getConnection();
            String sql = "SELECT * FROM user WHERE userid=? AND userpassword=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getUserid());
            pstmt.setString(2, dto.getUserpassword());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                loginSuccess = true; // 인증 성공: 사용자 정보가 일치함
            }
        } catch (SQLException e) {
            throw new RuntimeException("로그인 과정에서 오류 발생: " + e.getMessage());
        } finally {
            db.dbClose(rs, pstmt, conn); // 리소스 닫기
        }

        return loginSuccess;
    }

    // 사용자 이름 조회 메서드
    public String findUsernameById(String userid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String username = null;

        try {
            conn = db.getConnection();
            String sql = "SELECT username FROM user WHERE userid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userid);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                username = rs.getString("username");
            }
        } catch (SQLException e) {
            throw new RuntimeException("사용자 이름 조회 중 오류 발생: " + e.getMessage());
        } finally {
            db.dbClose(rs, pstmt, conn); // 리소스 닫기
        }

        return username;
    }

}
