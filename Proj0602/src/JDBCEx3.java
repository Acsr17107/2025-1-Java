import java.sql.*;

public class JDBCEx3 {

	public static void main(String[] args) {
		
		try {
            // MySQL JDBC ����̹� �ε�
            Class.forName("com.mysql.cj.jdbc.Driver");

            // �����ͺ��̽� ���� (DB URL, ����ڸ�, ���)
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "dongyang");
            System.out.println("db ���� ok");

            // SQL ���� ������ ���� Statement ��ü ����
            Statement stmt = conn.createStatement();
            
//          String sql = "select * from student;"; 
//          String sql = "insert into student values('0000004', '���̷�', 'AI S/w');";
//          String sql = "update student set dept ='�ΰ�����' where name = '���̷�';";
            
            String sql = "delete from student where name = '���̷�';";
            stmt.executeUpdate(sql);	// ����
            System.out.println("���� �Ϸ�");

            stmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            // ���� ó��
            e.printStackTrace();
        }
	}

}
