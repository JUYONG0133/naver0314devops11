package day0405db;

import java.sql.*;
import java.util.Enumeration;
import java.util.Scanner;

public class Ex12_Student {

    static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
    static final String USERNAME = "root";
    static final String PASSWORD = "1234";
    public Ex12_Student(){
        try {
            Class.forName(MYSQL_DRIVER);
            //System.out.println("Mysql8 드라이버 성공!");
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql8 드라이버 오류!"+e.getMessage());
        }
    }

    public void insertStudent(String name,int java,int html,int spring){
        String sql = "insert into student (name,java,html,spring,testday) values (?,?,?,?,now())";
        Connection conn =null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setInt(2,java);
            pstmt.setInt(3,html);
            pstmt.setInt(4,spring);

            pstmt.execute();
            System.out.println(name+" 님의 성적을 등록하였습니다.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }



    }
    public void deleteStudent(String name){
        String sql = "delete from student where name = ? ";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            int n = pstmt.executeUpdate();
            if(n==0){
                System.out.println(name+" 님은 명단에 없습니다.");
            }
            else{
                System.out.println(n+" 명의 "+name+" 님을 삭제했습니다.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }


        //해당 학생이 없을경우 xxx님은 명단에 없어요
        //있을경우 xxx님의 성적 정보를 삭제하였습니다.
    }
    public void writeStudent(){
        String sql = "select num,name,java,html,spring, java+html+spring tot, round((java+html+spring)/3,1) avg, date_format(testday,'%Y-%m-%d %H:%i') testday from student";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println("=".repeat(40)+" 학생 정보 "+"=".repeat(40));
            System.out.println("=".repeat(89));
            System.out.println("번호\t\t이름\t\tjava\thtml\tspring\t\t총점\t\t평균\t\t날짜");
            System.out.println("=".repeat(89));
            while(rs.next()){
                int num = rs.getInt("num");
                String name = rs.getString("name");
                int java = rs.getInt("java");
                int html = rs.getInt("html");
                int spring = rs.getInt("spring");
                double tot = rs.getDouble("tot");
                double avg = rs.getDouble("avg");
                String testday = rs.getString("testday");

                System.out.println(num+"\t\t"+name+"\t"+java+"\t\t"+html+"\t\t"+spring+"\t\t\t"+tot+"\t"+avg+"\t"+testday);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public static void main(String[] args) {
        Ex12_Student ex12 = new Ex12_Student();
        Scanner sc = new Scanner(System.in);
        int menu = 0;
        String name;
        int java,html,spring;
        while (true){
            System.out.println("1.학생정보추가 2.이름으로삭제 3.전체출력 4.종료");
            menu = Integer.parseInt(sc.nextLine());
            if(menu==1){
                System.out.println("추가할 이름은 ?");
                name=sc.nextLine();
                System.out.println("Java 점수는 ?");
                java = Integer.parseInt(sc.nextLine());
                System.out.println("HTML 점수는 ?");
                html = Integer.parseInt(sc.nextLine());
                System.out.println("spring 점수는 ?");
                spring = Integer.parseInt(sc.nextLine());

                ex12.insertStudent(name,java,html,spring);
            }
            else if(menu==2){
                System.out.println("삭제할 학생의 이름은?");
                name = sc.nextLine();
                ex12.deleteStudent(name);
            }
            else if(menu==3){
                ex12.writeStudent();
            }
            else {
                System.out.println("프로그램 종료");
                break;
            }
            System.out.println();
        }
    }
}
