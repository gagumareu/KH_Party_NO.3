package team3.init;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.sql.*;

public class FindIdPassword extends JFrame {
	Connection con = null;              // DB와 연결하는 객체.
	PreparedStatement pstmt = null;     // SQL문을 DB에 전송하는 객체.
	ResultSet rs = null;	// SQL문을 실행한 후의 결과값을 가지고 있는 객체.
	String sql = null;		// SQL문 저장 문자열 변수

	private JPanel contentPane;
	private JTextField tf_idName, tf_pwName, tf_pwId, tf_pwAns;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindIdPassword frame = new FindIdPassword();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FindIdPassword() {
		//윈도우 설정, 기본이 되는 컨테이너 생성
		setTitle("아이디/비밀번호 찾기");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		
		//아이디 찾기 tab
		JPanel panelFindId = new JPanel();
		tabbedPane.addTab("아이디 찾기", null, panelFindId, null);
		panelFindId.setLayout(new GridLayout(3, 1));
		
		
		JPanel panel_id1 = new JPanel();
		panelFindId.add(panel_id1);
		JLabel jl1_ex = new JLabel("아이디를 찾기 위한 정보를 입력하세요.");
		panel_id1.add(jl1_ex);
		
		
		JPanel panel_id2 = new JPanel();
		panelFindId.add(panel_id2);
		
		JLabel jl1_name = new JLabel("이름: ");
		panel_id2.add(jl1_name);
		
		tf_idName = new JTextField();
		tf_idName.setColumns(10);
		panel_id2.add(tf_idName);
		
		
		JPanel panel_idBtn = new JPanel();
		panelFindId.add(panel_idBtn);
		JButton btnFindId = new JButton("아이디 찾기");
		btnFindId.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				searchId(tf_idName.getText());
			}
		});
		panel_idBtn.add(btnFindId);
		
		
		
		//비밀번호 찾기 tab
		JPanel panelFindPwd = new JPanel();
		tabbedPane.addTab("비밀번호 찾기", null, panelFindPwd, null);
		panelFindPwd.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_pwd1 = new JPanel();
		panelFindPwd.add(panel_pwd1, BorderLayout.NORTH);
		JLabel jl2_ex = new JLabel("비밀번호 찾기를 위한 정보를 입력하세요.");
		panel_pwd1.add(jl2_ex);
		
		
		JPanel panel_pwd2 = new JPanel();
		panelFindPwd.add(panel_pwd2, BorderLayout.CENTER);
		JPanel panel_wrapPwdInfo = new JPanel();
		panel_pwd2.add(panel_wrapPwdInfo);
		panel_wrapPwdInfo.setLayout(new GridLayout(3, 1));
		
		
		JPanel panel_pwdInfo1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel_wrapPwdInfo.add(panel_pwdInfo1);
		
		JLabel jl2_name = new JLabel("이름: ");
		panel_pwdInfo1.add(jl2_name);
		
		tf_pwName = new JTextField();
		tf_pwName.setColumns(10);
		panel_pwdInfo1.add(tf_pwName);
		
		
		JPanel panel_pwdInfo2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel_wrapPwdInfo.add(panel_pwdInfo2);
		
		JLabel jl2_id = new JLabel("아이디: ");
		panel_pwdInfo2.add(jl2_id);
		
		tf_pwId = new JTextField();
		tf_pwId.setColumns(10);
		panel_pwdInfo2.add(tf_pwId);
		
		
		JPanel panel_pwdInfo3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel_wrapPwdInfo.add(panel_pwdInfo3);
		
		JLabel jl2_ans = new JLabel("어릴 때 살던 동네는? ");
		panel_pwdInfo3.add(jl2_ans);
		
		tf_pwAns = new JTextField();
		tf_pwAns.setColumns(10);
		panel_pwdInfo3.add(tf_pwAns);
		
		
		JPanel panel_pwdBtn = new JPanel();
		panelFindPwd.add(panel_pwdBtn, BorderLayout.SOUTH);
		
		JButton btnFindPwd = new JButton("비밀번호 찾기");
		btnFindPwd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				searchPassword(tf_pwName.getText(), tf_pwId.getText(), tf_pwAns.getText());
			}
		});
		panel_pwdBtn.add(btnFindPwd);
		
		
		//하단의 모든 탭이 공통으로 갖는 취소 버튼
		JPanel panelCancel = new JPanel();
		contentPane.add(panelCancel, BorderLayout.SOUTH);
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelCancel.add(btnCancel);
	}
	
	void connect() {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void searchId(String name) {
		try {
			sql = "select * from member where mem_name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			boolean found = rs.next();
			
			if(found) {
				String id = "이 이름으로 등록된 아이디: " + rs.getString("mem_id");
				while(rs.next()) {
					id += ", " + rs.getString("mem_id");
				}
				
				JOptionPane.showMessageDialog(null, id);
			}
			else {
				JOptionPane.showMessageDialog(null, "이 이름으로 등록된 아이디가 없습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void searchPassword(String name, String id, String answer) {
		try {
			sql = "select * from member where mem_id=? and mem_name=? and mem_findpwd_ans=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, answer);
			
			rs = pstmt.executeQuery();
			
			boolean found = rs.next();
			
			if(found) {
				String string = "해당 정보로 가입된 아이디의 비밀번호는 " + rs.getString("mem_password") + "입니다.";
				
				JOptionPane.showMessageDialog(null, string);
			}
			else {
				JOptionPane.showMessageDialog(null, "입력된 정보가 올바르지 않거나, 해당 정보로 가입된 아이디가 없습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
