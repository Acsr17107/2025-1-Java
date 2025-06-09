import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class InputEx1 extends JFrame {
	
	// 컴포넌트 선언
	JButton btnInsert, btnDelete, btnUpdate, btnSelect, btnSearch;
	JTextField tfId, tfName, tfDept, tfSearch;
	JTextArea ta;
	JRadioButton rbId, rbName, rbDept;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	FileWriter fout = null;

	public InputEx1() {
		// 프레임 기본 설정
		this.setTitle("학생 관리 프로젝트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// UI 생성
		createGUI();
		
		// 버튼 이벤트 리스너
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dbInsert();		// 입력
			}
		});
		
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dbDelete();		// 삭제
			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dbUpdate();		// 수정
			}
		});
		
		btnSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dbSelect();		// 조회
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dbSearch();		// 검색
			}
		});
		this.setSize(300, 550);
		this.setVisible(true);
	}
	
	// UI 요소 배치
	public void createGUI() {
		this.setLayout(new FlowLayout());
		
		// 입력 필드
		this.add(new JLabel("학번"));
		tfId = new JTextField(20);
		this.add(tfId);
		
		this.add(new JLabel("이름"));
		tfName = new JTextField(20);
		this.add(tfName);
		
		add(new JLabel("학과"));
		tfDept = new JTextField(20);
		this.add(tfDept);
		
		// 버튼
		btnInsert = new JButton("입력");
		this.add(btnInsert);
		btnUpdate = new JButton("수정");
		this.add(btnUpdate);
		btnDelete = new JButton("삭제");
		this.add(btnDelete);
		btnSelect = new JButton("조회");
		this.add(btnSelect);
		
		// 검색 부분
		tfSearch = new JTextField(18);
		rbId = new JRadioButton("학번", true);
		rbName = new JRadioButton("이름");
		rbDept = new JRadioButton("학과");
		
		// 라디오 버튼
		ButtonGroup group = new ButtonGroup();
		group.add(rbId);
		group.add(rbName);
		group.add(rbDept);
		
		btnSearch = new JButton("검색");
		
		// 검색창
		JPanel pn1 = new JPanel();
		pn1.add(new JLabel(" "));
		pn1.add(tfSearch);
		pn1.add(btnSearch);
		
		// 검색 조건
		JPanel pn2 = new JPanel();
		pn2.add(rbId);
		pn2.add(rbName);
		pn2.add(rbDept);
		
		JPanel pMiddle = new JPanel(new BorderLayout(0, 0));
		pMiddle.add(BorderLayout.NORTH, pn1);
		pMiddle.add(BorderLayout.CENTER, pn2);
		
		TitledBorder tb = new TitledBorder("검색");
		pMiddle.setBorder(tb);
		this.add(pMiddle);
		
		// 결과 출력
		ta = new JTextArea(15, 20);
		this.add(ta);
	}
	
	// 검색
	public void dbSearch() {
		try {
			conn = DBConn.dbConnection();
			String searchText = tfSearch.getText().toString();
			String searchSq1 = "";
			
			if(rbId.isSelected()) {
				searchSq1 = "select * from student where id = '" + searchText + "';";
			} else if(rbName.isSelected()) {
				searchSq1 = "select * from student where name = '" + searchText + "';";
			} else {
				searchSq1 = "select * from student where dept = '" + searchText + "';";
			}
			
			pstmt = conn.prepareStatement(searchSq1);
			rs = pstmt.executeQuery();
			
			String line = "";
			ta.setText("          id          name          dept\n");
			ta.append("--------------------------------------------\n");
			
			while(rs.next()) {
				String name = rs.getString("name");
				String dept = rs.getString("dept");
				String id = rs.getString("id");
				line = " | " + id + " | " + name + " | " + dept + "\n";
				System.out.println("rs => " + line);
				ta.append(line);
			}
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 조회
	public void dbSelect() {
		try {
			conn = DBConn.dbConnection();
			String sql = "select * from student;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			String line = "";
			ta.setText("          id          name          dept\n");
			ta.append("--------------------------------------------\n");
			
			while(rs.next()) {
				String name = rs.getString("name");
				String dept = rs.getString("dept");
				String id = rs.getString("id");
				line = " | " + id + " | " + name + " | " + dept + " \n";
				System.out.println("rs => " +line);
				ta.append(line);
			}
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 수정
	public void dbUpdate() {
		try {
			conn = DBConn.dbConnection();
			String sql = "update student set name = ?, dept = ? where id = ?;";
			String in_id = tfId.getText().toString();
			String in_name = tfName.getText().toString();
			String in_dept = tfDept.getText().toString();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, in_name);
			pstmt.setString(2, in_dept);
			pstmt.setString(3, in_id);
			pstmt.executeUpdate();
			System.out.println(in_name + "수정 완료");
			tfId.setText("");
			tfName.setText("");
			tfDept.setText("");
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정 에러");
		}
	}
	// 입력
	public void dbInsert() {
		try {
			conn = DBConn.dbConnection();
			String in_id = tfId.getText().toString();
			String in_name = tfName.getText().toString();
			String in_dept = tfDept.getText().toString();
			String sql = "insert into student(id, name, dept) values(?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, in_id);
			pstmt.setString(2, in_name);
			pstmt.setString(3, in_dept);
			
			pstmt.executeUpdate();
			System.out.println(in_name + "입력 완료");
			
			tfId.setText("");
			tfName.setText("");
			tfDept.setText("");
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 에러");
		}
	}
	// 삭제
	public void dbDelete() {
		try {
			conn = DBConn.dbConnection();
			String in_id = tfId.getText().toString();
			String sql = "delete from student where id =?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, in_id);
			pstmt.executeUpdate();
			System.out.println(in_id + "삭제 완료");
			
			tfId.setText("");
			tfName.setText("");
			tfDept.setText("");
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제 에러");
		}
	}
	public static void main(String[] args) {
		new InputEx1();
	}
}

	
	
