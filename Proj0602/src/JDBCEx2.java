import java.io.*;
import java.sql.*;

public class JDBCEx2 {

    public static void main(String[] args) {

        try {
            // MySQL JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결 (DB URL, 사용자명, 비번)
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "dongyang");
            System.out.println("db 연결 ok");

            // SQL 쿼리 실행을 위한 Statement 객체 생성
            Statement stmt = conn.createStatement();
            String sql = "select * from student;";

            // SQL 실행 후 결과 받기
            ResultSet rs = stmt.executeQuery(sql);

            // 결과 출력 (각 학생의 정보)
            while (rs.next()) {
                System.out.println("\t |" + rs.getString(1));
                System.out.println("\t |" + rs.getString(2));
                System.out.println("\t |" + rs.getString(3));
                System.out.println();
            }

            // DB 연결 종료
            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            // 예외 처리
            System.out.println("JDBC 드라이버 로드 에러");
        }
    }
}
