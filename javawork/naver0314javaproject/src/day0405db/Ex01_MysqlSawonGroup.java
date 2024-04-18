package day0405db;


import java.sql.*;

public class Ex01_MysqlSawonGroup {
    static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
    static final String USERNAME = "root";
    static final String PASSWORD = "1234";

    public Ex01_MysqlSawonGroup() {
        try {
            Class.forName(MYSQL_DRIVER);
            System.out.println("Mysql8 드라이버 성공!");
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql8 드라이버 오류!" + e.getMessage());
        }
    }

    public void writeSawonGroup() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select buseo,count(*) inwon,max(score) maxscore,ceiling(avg(score)) avgscore from sawon group by buseo";

        try {
            conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            System.out.println("\t== 부서별 현황==\n");
            System.out.println("부서명\t인원수\t최고점수\t평균점수");
            System.out.println("=".repeat(30));
            while (rs.next()) {
                String tbuseo = rs.getString("buseo");
                String tinwon = rs.getString("inwon");
                String tmax = rs.getString("maxscore");
                String tavg = rs.getString("avgscore");

                System.out.println(tbuseo + "\t" + tinwon + "명\t\t" + tmax + "점\t\t" + tavg + "점");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
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
        Ex01_MysqlSawonGroup ex1 = new Ex01_MysqlSawonGroup();
        ex1.writeSawonGroup();
    }
}
