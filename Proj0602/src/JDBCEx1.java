import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCEx1 {

    public static void main(String[] args) {
    	
        try {
            // MySQL JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결 (DB URL, 사용자명, 비번)
            DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "dongyang");

            // 연결 성공 메시지
            System.out.println("db 연결 okkkkk");

        } catch (ClassNotFoundException | SQLException e) {
            // 예외 처리
            System.out.println("db 연결 에러");
            e.printStackTrace();
        }
    }
}
