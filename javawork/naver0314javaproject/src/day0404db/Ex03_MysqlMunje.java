package day0404db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex03_MysqlMunje {
    static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
    static final String USERNAME = "root";
    static final String PASSWORD = "1234";


    public Ex03_MysqlMunje(){
        try {
            Class.forName(MYSQL_DRIVER);
            System.out.println("Mysql8 드라이버 성공!");
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql8 드라이버 오류!"+e.getMessage());
        }
    }
    static public void showTitle(){
        System.out.println("=".repeat(40));
        System.out.println("부서명\t인원\t최고점수\t평균점수");
        System.out.println("=".repeat(40));
    }
    public void writeSawon() {
        //url username password 모두 맞으면 connection을 얻는다
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;  // select문일경우에만 필요한 클래스
        String sql = "select buseo,count(*) inwon,max(score) maxscore,ceiling(avg(score)) avgscore from sawon group by buseo";

        try {
            conn= DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
            System.out.println("MySql 서버 연결 성공");
            showTitle();

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String tbuseo = rs.getString("buseo");
                String tinwon = rs.getString("inwon");
                String tmax = rs.getString("maxscore");
                String tavg = rs.getString("avgscore");

                System.out.println(tbuseo+"\t"+tinwon+"\t"+tmax+"\t"+tavg);
            }

        } catch (SQLException e) {
            System.out.println("URL,USERNAME,PASSWORD 확인 ; "+e.getMessage());
        }finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException | NullPointerException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public static void main(String[] args) {
        Ex03_MysqlMunje ex1 = new Ex03_MysqlMunje();
        ex1.writeSawon();
    }
}
