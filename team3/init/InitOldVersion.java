package src.init;

import java.sql.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InitOldVersion extends JFrame {
	Connection con = null;              // DB와 연결하는 객체.
	PreparedStatement pstmt = null;     // SQL문을 DB에 전송하는 객체.
	ResultSet rs = null;	// SQL문을 실행한 후의 결과값을 가지고 있는 객체.
	String sql = null;		// SQL문 저장 문자열 변수
	DefaultTableModel model;
	JTextField jtf1, jtf2;
	JTable table;
	
	public InitOldVersion() {
		setTitle("초기 화면");
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		
		
		//1. 컴포넌트 생성
		JLabel jl1 = new JLabel("아이디: ");
		jtf1 = new JTextField(10);
		
		JLabel jl2 = new JLabel("비밀번호: ");
		jtf2 = new JPasswordField(10);
		
		JButton jb0 = new JButton("로그인");
		
		
		JButton jb1 = new JButton("회원가입");
		JButton jb2 = new JButton("아이디/비밀번호 찾기");
		
		
		//2. 컴포넌트를 컨테이너에 올리기
		container1.add(jl1); container1.add(jtf1);
		container1.add(jl2); container1.add(jtf2);
		
		container2.add(jb0);
		
		container3.add(jb1); container3.add(jb2);
		
		
		//3. 컨테이너를 프레임에 올리기
		add(container1, BorderLayout.NORTH);
		add(container2, BorderLayout.CENTER);
		add(container3, BorderLayout.SOUTH);
		
		setBounds(200, 200, 500, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		//4. 이벤트 처리
		jb0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				String id = jtf1.getText();
				String pw = jtf2.getText();
				checkLoginValid(id, pw);
				model.setRowCount(0);
			}
		});	//로그인 버튼 이벤트 처리
		
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SignUpOldVersion();
			}
		});	//회원가입 버튼 이벤트 처리
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	//아이디/비밀번호 찾기 버튼 이벤트 처리
	}
	
	void connect() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void checkLoginValid(String id, String pw) {
		try {
			sql = "select mem_password where mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
