package day0405db;

import day0404db.Ex01_MysqlSawon;

import java.sql.*;
import java.util.Scanner;

public class Ex10_SawonUpdate2 {

    static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
    static final String USERNAME = "root";
    static final String PASSWORD = "1234";
    public Ex10_SawonUpdate2(){
        try {
            Class.forName(MYSQL_DRIVER);
          //  System.out.println("Mysql8 드라이버 성공!");
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql8 드라이버 오류!"+e.getMessage());
        }
    }
    public void updateSawon(){
        Ex01_MysqlSawon sawon = new Ex01_MysqlSawon();
        sawon.writeSawon();
        System.out.println("-".repeat(50));
        Scanner sc = new Scanner(System.in);
        String updateName, updateBuseo;
        int updateScore;
        System.out.println("수정할 사람의 이름은?");
        updateName = sc.nextLine();
        System.out.println("수정할 점수는? ");
        updateScore = Integer.parseInt(sc.nextLine());
        System.out.println("수정할 부서명은 ? ");
        updateBuseo = sc.nextLine();

        String sql = "update sawon set score = ? ,buseo = ? where name = ? ";
        //System.out.println(sql);

        Connection conn = null;
        PreparedStatement pstmt = null;
       // Statement stmt = null;
        try {
            conn = DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
            //stmt = conn.createStatement();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,updateScore);
            pstmt.setString(2,updateBuseo);
            pstmt.setString(3,updateName);

            int n = pstmt.executeUpdate();
            if(n==0){
                System.out.println(updateName+" 님이 존재하지 않습니다.");
            }
            else {
                System.out.println(updateName+" 님의 정보가 수정되었습니다.");
                sawon.writeSawon();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
               // stmt.close();
                pstmt.close();
                conn.close();
            } catch (SQLException | NullPointerException e) {
                throw new RuntimeException(e);
            }

        }

    }
    public static void main(String[] args) {
        Ex10_SawonUpdate2 ex10 = new Ex10_SawonUpdate2();
       // Ex01_MysqlSawon sawon = new Ex01_MysqlSawon();
        ex10.updateSawon();;
    }
}
