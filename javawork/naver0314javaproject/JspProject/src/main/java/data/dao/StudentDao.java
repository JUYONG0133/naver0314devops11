package data.dao;

import data.dto.StudentDto;

import db.common.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class StudentDao {
    MysqlConnect db = new MysqlConnect();

    // 추가
    public void insertStudent(StudentDto dto) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "insert into mystudent (name, blood, license, java, spring, html, writeday) values (?,?,?,?,?,?, now())";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getBlood());
            pstmt.setString(3, String.valueOf(dto.getLicense()));
            pstmt.setInt(4, dto.getJava());
            pstmt.setInt(5, dto.getSpring());
            pstmt.setInt(6, dto.getHtml());

            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(pstmt, conn);
        }

    }
    // 목록 출력
    public List<StudentDto> getAllStudents() {
        List<StudentDto> list = new Vector<StudentDto>();
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from mystudent order by num";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                StudentDto dto = new StudentDto();
                dto.setNum(rs.getInt("num"));
                dto.setName(rs.getString("name"));
                dto.setBlood(rs.getString("blood"));
                dto.setLicense(rs.getString("license").charAt(0));
                dto.setJava(rs.getInt("java"));
                dto.setSpring(rs.getInt("spring"));
                dto.setHtml(rs.getInt("html"));
                dto.setWriteday(rs.getTimestamp("writeday"));

                list.add(dto);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

        return list;
    }

    // 디테일
    public StudentDto getData(int num) {
        StudentDto dto = new StudentDto();
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from mystudent where num=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                dto.setNum(rs.getInt("num"));
                dto.setName(rs.getString("name"));
                dto.setBlood(rs.getString("blood"));
                dto.setLicense(rs.getString("license").charAt(0));
                dto.setJava(rs.getInt("java"));
                dto.setSpring(rs.getInt("spring"));
                dto.setHtml(rs.getInt("html"));
                dto.setWriteday(rs.getTimestamp("writeday"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }
        return dto;
    }
    public void deleteStudent(int num) {
        String sql = "delete from mystudent where num=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = db.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(pstmt, conn);
        }
    }
    public void updateStudent(StudentDto dto) {
        String sql = "update mystudent set name=?, blood=?, license=?, java=?, spring=?, html=?, writeday=now() where num=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        // ResultSet rs = null;
        conn = db.getConnection();
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getBlood());
            pstmt.setString(3, String.valueOf(dto.getLicense()));
            pstmt.setInt(4, dto.getJava());
            pstmt.setInt(5, dto.getSpring());
            pstmt.setInt(6, dto.getHtml());
            pstmt.setInt(7, dto.getNum());

            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException("update 오류: " + e.getMessage(), e);
        } finally {
            db.dbClose(pstmt, conn);
        }

    }
}
