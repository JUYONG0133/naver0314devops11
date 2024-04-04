package day0404db;

import java.sql.*;

public class Ex01_MysqlSawon {
    static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
    static final String USERNAME = "root";
    static final String PASSWORD = "1234";

    public Ex01_MysqlSawon(){
        try {
            Class.forName(MYSQL_DRIVER);
            System.out.println("MYsql8 드라이버 성공!");
        } catch (ClassNotFoundException e) {
            System.out.println("MYsql8 드라이버 오류!"+e.getMessage());
        }
    }
    static public void showTitle(){
        System.out.println("=".repeat(40));
        System.out.println("시퀀스\t이름\t\t\t성별\t부서\t점수");
        System.out.println("=".repeat(40));
    }
    public void writeSawon(){
        //url username password 모두 맞으면 connection을 얻는다
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;  // select문일경우에만 필요한 클래스
        String sql = "select * from sawon order by num";
        // sql 문장이 길경우 자바텍스트블록(""" """) 사용 JDK15 부터 사용가능

        try {
            conn= DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
            System.out.println("MySql 서버 연결 성공");

            showTitle();
            stmt = conn.createStatement(); //sql을 실행하기 위한 statement 얻기
            rs = stmt.executeQuery(sql);    //select 문을경우는 무조건 executeQuery로 실행한다.
            // rs.next() 는 다음 레코드로 이동하면서 true반환, 그런데 이동할 데이터가 더이상 없으면 false 반환
            while (rs.next()){
                //데이터를 가져올때는 컬럼번호 또는 컬럼명으로 가져오면 된다.
                //1. 컬럼번호로 가져오기
//                int num = rs.getInt(1);
//                String name = rs.getString(2);
//                int scroe = rs.getInt(3);
//                String gender = rs.getString(4);
//                String buseo = rs.getString(5);
//                System.out.println(num+"\t\t"+name+"\t\t\t"+gender+"\t"+buseo+"\t"+scroe);
                //2, 컬럼명으로 가져오기
                int num = rs.getInt("num");
                String name = rs.getString("name");
                int scroe = rs.getInt("score");
                String gender = rs.getString("gender");
                String buseo = rs.getString("buseo");
                System.out.println(num+"\t\t"+name+"\t\t\t"+gender+"\t"+buseo+"\t"+scroe);
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
        Ex01_MysqlSawon ex1 = new Ex01_MysqlSawon();

        ex1.writeSawon();
    }
}
