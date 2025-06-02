import java.io.*;
import java.sql.*;

public class JDBCEx2 {

    public static void main(String[] args) {

        try {
            // MySQL JDBC ����̹� �ε�
            Class.forName("com.mysql.cj.jdbc.Driver");

            // �����ͺ��̽� ���� (DB URL, ����ڸ�, ���)
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "dongyang");
            System.out.println("db ���� ok");

            // SQL ���� ������ ���� Statement ��ü ����
            Statement stmt = conn.createStatement();
            String sql = "select * from student;";

            // SQL ���� �� ��� �ޱ�
            ResultSet rs = stmt.executeQuery(sql);

            // ��� ��� (�� �л��� ����)
            while (rs.next()) {
                System.out.println("\t |" + rs.getString(1));
                System.out.println("\t |" + rs.getString(2));
                System.out.println("\t |" + rs.getString(3));
                System.out.println();
            }

            // DB ���� ����
            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            // ���� ó��
            System.out.println("JDBC ����̹� �ε� ����");
        }
    }
}
