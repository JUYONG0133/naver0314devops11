package day0404db;

import java.sql.*;

public class Ex02_OraclePerson {
    static final String ORACLE_DRIVER="oracle.jdbc.OracleDriver";
    static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521/xe";
    static final String USERNAME = "angel";
    static final String PASSWORD = "angel";
    static public void showTitle(){
        System.out.println("=".repeat(40));
        System.out.println("시퀀스\t이름\t혈액형\t나이\t입사일");
        System.out.println("=".repeat(40));
    }
    public void writePerson(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "select pnum,pname,upper(pblood) pblood,page,to_char(IPSADAY,'YYYY-mm-dd') ipsaday from PERSON";
        try {
            conn= DriverManager.getConnection(ORACLE_URL,USERNAME,PASSWORD);
            System.out.println("오라클 서버 연결 성공!");
            showTitle();

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                String pnum  = rs.getNString("pnum");
                String pname = rs.getNString("pname");
                String pblood = rs.getNString("pblood");
                int page = rs.getInt("page");
                String ipsaday = rs.getNString("ipsaday");
                System.out.println(pnum+"\t"+pname+"\t"+pblood+"\t"+page+"\t"+ipsaday);
            }
        } catch (SQLException e) {
            System.out.println("오라클 서버 연결 실패! : "+e.getMessage());
        }finally {
            try {
                rs.close();
                stmt.close();;
                conn.close();
            } catch (SQLException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public Ex02_OraclePerson(){
        try {
            Class.forName(ORACLE_DRIVER);
            System.out.println("오라클 드라이버 성공!");


        } catch (ClassNotFoundException e) {
            System.out.println("오라클 드라이버 실패!"+e.getMessage());
        }
    }
    public static void main(String[] args) {
        Ex02_OraclePerson ex2 = new Ex02_OraclePerson();
        ex2.writePerson();
    }
}
