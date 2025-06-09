import java.sql.*;

public class DBTest1 {

	public static void main(String[] args) {
		try {
			// MySQL JDBC ����̹� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// DB ���� ���� ����
			String url = "jdbc:mysql://localhost:3306/sampledb";
			String user = "root";
			String password = "dongyang";
			
			// �����ͺ��̽� ���� �õ�
			Connection conn = 
					DriverManager.getConnection(url, user, password);
			System.out.println("DB ����");
			
			// ������ ������ �غ�
			String inid = "2025001";
			String inname = "������";
			String indept = "�ΰ����ɰ�";
			
			// SQL ���Թ� �غ�
			String sql = "insert into student values(?, ?, ?);";
			
			// PreparedStatement ��ü ���� �� �� ���ε�
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inid);	// ? 1��
			pstmt.setString(2, inname);	// ? 2��
			pstmt.setString(3, indept);	// ? 3��
			
			// SQL ����
			pstmt.executeUpdate();
			System.out.println("�Է� ���� " + inname);
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB ����");
			e.printStackTrace();
		}
	}
}
