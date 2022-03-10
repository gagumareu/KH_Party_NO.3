package team3.init;

import java.sql.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import team3.khie_dohyung.ManwhaMain;
import javax.swing.GroupLayout.Alignment;

public class Init extends JFrame {
	Connection con = null;              // DB와 연결하는 객체.
	PreparedStatement pstmt = null;     // SQL문을 DB에 전송하는 객체.
	ResultSet rs = null;	// SQL문을 실행한 후의 결과값을 가지고 있는 객체.
	String sql = null;		// SQL문 저장 문자열 변수
	
	private JPanel contentPane;
	private JTextField tf_id;
	private JPasswordField pf_pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Init frame = new Init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Init() {
		setTitle("초기 화면");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		JPanel info_panel = new JPanel();
		getContentPane().add(info_panel, BorderLayout.NORTH);
		info_panel.setLayout(new BorderLayout(0, 0));
		
		JPanel id_panel = new JPanel();
		info_panel.add(id_panel, BorderLayout.NORTH);
		
		JLabel jl1 = new JLabel("아이디: ");
		
		tf_id = new JTextField();
		tf_id.setColumns(10);
		GroupLayout gl_id_panel = new GroupLayout(id_panel);
		gl_id_panel.setHorizontalGroup(
			gl_id_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_id_panel.createSequentialGroup()
					.addGap(129)
					.addComponent(jl1)
					.addGap(5)
					.addComponent(tf_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_id_panel.setVerticalGroup(
			gl_id_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_id_panel.createSequentialGroup()
					.addGap(8)
					.addComponent(jl1))
				.addGroup(gl_id_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(tf_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		id_panel.setLayout(gl_id_panel);
		
		JPanel pwd_panel = new JPanel();
		info_panel.add(pwd_panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("비밀번호: ");
		
		pf_pwd = new JPasswordField();
		pf_pwd.setColumns(10);
		GroupLayout gl_pwd_panel = new GroupLayout(pwd_panel);
		gl_pwd_panel.setHorizontalGroup(
			gl_pwd_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pwd_panel.createSequentialGroup()
					.addGap(123)
					.addComponent(lblNewLabel)
					.addGap(5)
					.addComponent(pf_pwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_pwd_panel.setVerticalGroup(
			gl_pwd_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pwd_panel.createSequentialGroup()
					.addGap(8)
					.addComponent(lblNewLabel))
				.addGroup(gl_pwd_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(pf_pwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		pwd_panel.setLayout(gl_pwd_panel);
		
		JPanel signup_find_panel = new JPanel();
		getContentPane().add(signup_find_panel, BorderLayout.SOUTH);
		
		JButton btnSignUp = new JButton("회원가입");
		btnSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SignUp();
			}
		});
		
		JButton btnFindIdPwd = new JButton("아이디/비밀번호 찾기");
		btnFindIdPwd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FindIdPassword();
			}
		});
		GroupLayout gl_signup_find_panel = new GroupLayout(signup_find_panel);
		gl_signup_find_panel.setHorizontalGroup(
			gl_signup_find_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_signup_find_panel.createSequentialGroup()
					.addGap(93)
					.addComponent(btnSignUp)
					.addGap(5)
					.addComponent(btnFindIdPwd))
		);
		gl_signup_find_panel.setVerticalGroup(
			gl_signup_find_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_signup_find_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_signup_find_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSignUp)
						.addComponent(btnFindIdPwd)))
		);
		signup_find_panel.setLayout(gl_signup_find_panel);
		
		JPanel login_panel = new JPanel();
		getContentPane().add(login_panel, BorderLayout.CENTER);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				
				checkLoginValid(tf_id.getText(), String.valueOf(pf_pwd.getPassword()));
			}
		});
		GroupLayout gl_login_panel = new GroupLayout(login_panel);
		gl_login_panel.setHorizontalGroup(
			gl_login_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_login_panel.createSequentialGroup()
					.addGap(177)
					.addComponent(btnLogin))
		);
		gl_login_panel.setVerticalGroup(
			gl_login_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_login_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(btnLogin))
		);
		login_panel.setLayout(gl_login_panel);
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
			sql = "select mem_password from member where mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			boolean found = rs.next();
			
			if(found) {
				if(pw.equals(rs.getString("mem_password"))) {
					JOptionPane.showMessageDialog(null, "로그인되었습니다.");
					//merge 이후 여기에서 고객 창 생성
					new ManwhaMain();	//고객에 맞춘 윈도우 생성
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "아이디나 비밀번호를 잘못 입력하셨거나 등록되지 않은 아이디입니다.");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "아이디나 비밀번호를 잘못 입력하셨거나 등록되지 않은 아이디입니다.");
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
}