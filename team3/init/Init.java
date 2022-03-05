package src.init;

import java.sql.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Init extends JFrame {
	Connection con = null;              // DB와 연결하는 객체.
	PreparedStatement pstmt = null;     // SQL문을 DB에 전송하는 객체.
	ResultSet rs = null;	// SQL문을 실행한 후의 결과값을 가지고 있는 객체.
	String sql = null;		// SQL문 저장 문자열 변수
	DefaultTableModel model;
	JTextField jtf1, jtf2;
	JTable table;
	
	private JPanel contentPane;
	private JTextField tf_id;
	private JTextField tf_pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Init frame = new Init();
					frame.setVisible(true);
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
		
		JPanel info_panel = new JPanel();
		getContentPane().add(info_panel, BorderLayout.NORTH);
		info_panel.setLayout(new BorderLayout(0, 0));
		
		JPanel id_panel = new JPanel();
		info_panel.add(id_panel, BorderLayout.NORTH);
		
		JLabel jl1 = new JLabel("아이디: ");
		id_panel.add(jl1);
		
		tf_id = new JTextField();
		tf_id.setColumns(10);
		id_panel.add(tf_id);
		
		JPanel pwd_panel = new JPanel();
		info_panel.add(pwd_panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("비밀번호: ");
		pwd_panel.add(lblNewLabel);
		
		tf_pwd = new JTextField();
		pwd_panel.add(tf_pwd);
		tf_pwd.setColumns(10);
		
		JPanel signup_find_panel = new JPanel();
		getContentPane().add(signup_find_panel, BorderLayout.SOUTH);
		
		JButton btnSignUp = new JButton("회원가입");
		btnSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SignUp();
			}
		});
		signup_find_panel.add(btnSignUp);
		
		JButton btnFindIdPwd = new JButton("아이디/비밀번호 찾기");
		signup_find_panel.add(btnFindIdPwd);
		
		JPanel login_panel = new JPanel();
		getContentPane().add(login_panel, BorderLayout.CENTER);
		
		JButton btnLogin = new JButton("로그인");
		login_panel.add(btnLogin);
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
