package kh_test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SignUpOldVersion extends JFrame {
	Connection con = null;              // DB와 연결하는 객체.
	PreparedStatement pstmt = null;     // SQL문을 DB에 전송하는 객체.
	ResultSet rs = null;	// SQL문을 실행한 후의 결과값을 가지고 있는 객체.
	String sql = null;		// SQL문 저장 문자열 변수
	DefaultTableModel model;
	JTextField jtf1ID, jtf2Pwd, jtf3Name, jtf4Cont, jtf5Addr;
	JTable table;
	
	public SignUpOldVersion() {
		setTitle("회원가입");
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		
		//1. 컴포넌트 생성
		JLabel jl1 = new JLabel("아이디: ");
		jtf1ID = new JTextField(10);
		
		JLabel jl2 = new JLabel("비밀번호: ");
		jtf2Pwd = new JPasswordField(10);
		
		//mem_num은 시스템에서 부여.
		
		JLabel jl3 = new JLabel("이름: ");
		jtf3Name = new JTextField(10);
		
		JLabel jl4 = new JLabel("연락처: ");
		jtf4Cont = new JTextField(10);
		
		JLabel jl5 = new JLabel("주소: ");
		jtf5Addr = new JTextField(10);
		
		//mem_mileage는 초기 0에서 시작.
		
		container1.setLayout(new GridLayout(5, 2, 1, 10));
		
		JButton jb1 = new JButton("회원가입");
		JButton jb2 = new JButton("취소");
		
		
		//2. 컨테이너에 컴포넌트 올리기
		container1.add(jl1); container2.add(jtf1ID);
		container1.add(jl2); container2.add(jtf2Pwd);
		container1.add(jl3); container2.add(jtf3Name);
		container1.add(jl4); container2.add(jtf4Cont);
		container1.add(jl5); container2.add(jtf5Addr);
		
		container3.add(jb1); container3.add(jb2);
		
		//3. 프레임에 컨테이너 올리기
		add(container1, BorderLayout.WEST);
		add(container2, BorderLayout.CENTER);
		add(container3, BorderLayout.SOUTH);
		
		setBounds(200, 200, 250, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		//4. 이벤트 처리
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				insert();
				
			}
		});	//회원가입 버튼 이벤트 처리
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	//취소 버튼 이벤트 처리
	}
	
	void insert() {
		try {
			sql = "insert into member values(?,?,mem_seq.nextval,?,?,?,0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, jtf1ID.getText());
			pstmt.setString(2, jtf2Pwd.getText());
			//mem_num은 시스템에서 부여.
			pstmt.setString(3, jtf3Name.getText());
			pstmt.setString(4, jtf4Cont.getText());
			pstmt.setString(5, jtf5Addr.getText());
			//mem_mileage는 초기 0에서 시작.
			
			int res = pstmt.executeUpdate();
			
			if(res > 0) {
				JOptionPane.showMessageDialog(null, "회원가입 완료.");
			}else {
				JOptionPane.showMessageDialog(null, "회원가입 실패.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void connect() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
