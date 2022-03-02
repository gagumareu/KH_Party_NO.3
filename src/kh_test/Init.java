package kh_test;

import java.sql.*;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Init extends JFrame {
	Connection con = null;              // DB와 연결하는 객체.
	PreparedStatement pstmt = null;     // SQL문을 DB에 전송하는 객체.
	ResultSet rs = null;	// SQL문을 실행한 후의 결과값을 가지고 있는 객체.
	String sql = null;		// SQL문 저장 문자열 변수
	DefaultTableModel model;
	JTextField jtf1, jtf2;
	JTable table;
	
	public Init() {
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
	}
}
