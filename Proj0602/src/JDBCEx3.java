import java.sql.*;

public class JDBCEx3 {

	public static void main(String[] args) {
		
		try {
            // MySQL JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결 (DB URL, 사용자명, 비번)
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "dongyang");
            System.out.println("db 연결 ok");

            // SQL 쿼리 실행을 위한 Statement 객체 생성
            Statement stmt = conn.createStatement();
            
//          String sql = "select * from student;"; 
//          String sql = "insert into student values('0000004', '동미래', 'AI S/w');";
//          String sql = "update student set dept ='인공지능' where name = '동미래';";
            
            String sql = "delete from student where name = '동미래';";
            stmt.executeUpdate(sql);	// 실행
            System.out.println("삭제 완료");

            stmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            // 예외 처리
            e.printStackTrace();
        }
	}

}
