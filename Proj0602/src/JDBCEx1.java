import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCEx1 {

    public static void main(String[] args) {
    	
        try {
            // MySQL JDBC ����̹� �ε�
            Class.forName("com.mysql.cj.jdbc.Driver");

            // �����ͺ��̽� ���� (DB URL, ����ڸ�, ���)
            DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "dongyang");

            // ���� ���� �޽���
            System.out.println("db ���� okkkkk");

        } catch (ClassNotFoundException | SQLException e) {
            // ���� ó��
            System.out.println("db ���� ����");
            e.printStackTrace();
        }
    }
}
