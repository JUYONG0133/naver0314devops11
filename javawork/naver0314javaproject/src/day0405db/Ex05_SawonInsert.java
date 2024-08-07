package day0405db;

import day0404db.Ex01_MysqlSawon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex05_SawonInsert {
    static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
    static final String USERNAME = "root";
    static final String PASSWORD = "1234";
    public Ex05_SawonInsert(){
        try {
            Class.forName(MYSQL_DRIVER);
            System.out.println("Mysql8 드라이버 성공!");
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql8 드라이버 오류!"+e.getMessage());
        }
    }
    public void insertSawon(){
        Scanner sc = new Scanner(System.in);
        String name,gender,buseo;
        int score,gnum,bnum;
        String sql = "";
        System.out.println("이름은 ? ");
        name = sc.nextLine();
        System.out.println("점수는 ? ");
        score = Integer.parseInt(sc.nextLine());
        System.out.println("성별은 ? 1.남자 2.여자");
        gnum = Integer.parseInt(sc.nextLine());
        gender = gnum==1?"남자":"여자";

        System.out.println("부서는 ? 1.홍보부 2.인사부 3.교육부");
        bnum = Integer.parseInt(sc.nextLine());
        buseo = bnum==1 ? "홍보부" : bnum ==2 ? "인사부" : "교육부" ;
        sql = "insert into sawon (name,score,gender,buseo) values ('"+name+"',"+score+",'"+gender+"','"+buseo+"') ";
        System.out.println(sql);

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
            stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("데이터 추가 성공 !");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException | NullPointerException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void main(String[] args) {
        Ex05_SawonInsert ex5 = new Ex05_SawonInsert();
        Ex01_MysqlSawon ex1 = new Ex01_MysqlSawon();
        ex5.insertSawon();
        ex1.writeSawon();
    }
}
