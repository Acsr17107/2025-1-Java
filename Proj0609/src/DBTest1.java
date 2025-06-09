import java.sql.*;

public class DBTest1 {

	public static void main(String[] args) {
		try {
			// MySQL JDBC 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// DB 접속 정보 설정
			String url = "jdbc:mysql://localhost:3306/sampledb";
			String user = "root";
			String password = "dongyang";
			
			// 데이터베이스 연결 시도
			Connection conn = 
					DriverManager.getConnection(url, user, password);
			System.out.println("DB 성공");
			
			// 삽입할 데이터 준비
			String inid = "2025001";
			String inname = "안유진";
			String indept = "인공지능과";
			
			// SQL 삽입문 준비
			String sql = "insert into student values(?, ?, ?);";
			
			// PreparedStatement 객체 생성 및 값 바인딩
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inid);	// ? 1번
			pstmt.setString(2, inname);	// ? 2번
			pstmt.setString(3, indept);	// ? 3번
			
			// SQL 실행
			pstmt.executeUpdate();
			System.out.println("입력 성공 " + inname);
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB 에러");
			e.printStackTrace();
		}
	}
}
