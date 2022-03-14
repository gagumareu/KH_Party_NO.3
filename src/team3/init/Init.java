package team3.init;

import java.sql.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		setTitle("로그인");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(SystemColor.info);
		setContentPane(contentPane);
		setVisible(true);
		setLocationRelativeTo(null);

		
		JPanel panel_top = new JPanel();
		panel_top.setBackground(SystemColor.info);
		getContentPane().add(panel_top, BorderLayout.NORTH);
		panel_top.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_title = new JPanel();
		panel_title.setBackground(SystemColor.info);
		panel_top.add(panel_title, BorderLayout.NORTH);
		
		JLabel jl0_title = new JLabel("만화카페 사용자 시스템");
		jl0_title.setFont(new Font("휴먼편지체", Font.BOLD, 32));
		panel_title.add(jl0_title);
		
		JPanel panel_bottonBtns = new JPanel();
		panel_bottonBtns.setBackground(SystemColor.info);
		getContentPane().add(panel_bottonBtns, BorderLayout.SOUTH);
		panel_bottonBtns.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_wrapBtns = new JPanel();
		panel_wrapBtns.setBackground(SystemColor.info);
		panel_bottonBtns.add(panel_wrapBtns);
		
		JButton btnSignUp = new JButton("회원가입");
		btnSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SignUp();
			}
		});
		btnSignUp.setBackground(Color.WHITE);
		panel_wrapBtns.add(btnSignUp);
		
		JButton btnFindIdPwd = new JButton("아이디/비밀번호 찾기");
		btnFindIdPwd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FindIdPassword();
			}
		});
		btnFindIdPwd.setBackground(Color.WHITE);
		panel_wrapBtns.add(btnFindIdPwd);
		
		JLabel jl_indentBtm = new JLabel(" ");
		panel_bottonBtns.add(jl_indentBtm, BorderLayout.NORTH);
		
		JPanel panel_login = new JPanel();
		panel_login.setBackground(SystemColor.info);
		getContentPane().add(panel_login, BorderLayout.CENTER);
		panel_login.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_fields = new JPanel();
		panel_login.add(panel_fields, BorderLayout.CENTER);
		panel_fields.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel_fields.add(panel, BorderLayout.CENTER);
		
		tf_id = new JTextField();
		tf_id.setColumns(10);
		
		JLabel jl1 = new JLabel("아이디:    ");
		
		pf_pwd = new JPasswordField();
		pf_pwd.setColumns(10);
		
		JLabel jl2 = new JLabel("비밀번호: ");
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
				checkLoginValid(tf_id.getText(), String.valueOf(pf_pwd.getPassword()));
			}
		});
		btnLogin.setPreferredSize(new Dimension(82, 40));
		btnLogin.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images/제목 없음2.jpg"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(jl2)
							.addGap(5)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(pf_pwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(jl1)
							.addGap(5)
							.addComponent(tf_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(78))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(26)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(jl1))
								.addComponent(tf_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(jl2))
								.addComponent(pf_pwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_icon = new JPanel();
		panel_icon.setBackground(SystemColor.info);
		contentPane.add(panel_icon, BorderLayout.WEST);
		
		
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
					new MyPage(id);	//고객에 맞춘 윈도우 생성
					//고객에 맞춘 윈도우 생성
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
