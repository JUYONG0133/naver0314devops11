package day0405db;

import day0404db.Ex01_MysqlSawon;

import java.sql.*;
import java.util.Scanner;

public class Ex07_SawonDelete {
    static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
    static final String USERNAME = "root";
    static final String PASSWORD = "1234";
    public Ex07_SawonDelete(){
        try {
            Class.forName(MYSQL_DRIVER);
            System.out.println("Mysql8 드라이버 성공!");
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql8 드라이버 오류!"+e.getMessage());
        }
    }
    public void deleteSawon(){
        Scanner sc = new Scanner(System.in);
        System.out.println("삭제할 사람의 이름을 입력하세요.");
        String delName = "";
        delName = sc.nextLine();
//        String sql = "delete from sawon where name = ?";
        String sql = "delete from sawon where name = '"+delName+"'";

        Connection conn = null;
  //      PreparedStatement pstmt = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1,"delName");
//            pstmt.execute();
            stmt = conn.createStatement();
            //n = 0 이면 삭제할 데이터가 없다는의미
            int n = stmt.executeUpdate(sql);
            if(n==0){
                System.out.println(delName+" 님은 명단에 없습니다.");
            }
            else{
                System.out.println(n+" 명의 "+delName+" 님을 삭제했습니다.");
            }
            // 매번 워크벤치가서 확인하기 싫으면
            Ex01_MysqlSawon sawon = new Ex01_MysqlSawon();
            sawon.writeSawon();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                //pstmt.close();
                stmt.close();
                conn.close();
            } catch (SQLException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        Ex07_SawonDelete ex7 = new Ex07_SawonDelete();
        ex7.deleteSawon();

    }
}
