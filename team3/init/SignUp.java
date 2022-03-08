package team3.init;

import java.awt.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {
	Connection con = null;              // DB와 연결하는 객체.
	PreparedStatement pstmt = null;     // SQL문을 DB에 전송하는 객체.
	ResultSet rs = null;	// SQL문을 실행한 후의 결과값을 가지고 있는 객체.
	String sql = null;		// SQL문 저장 문자열 변수

	private JPanel contentPane;
	private JTextField tfId, tfName, tfCont, tfAddr;
	private JPasswordField pfpwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUp() {
		setTitle("회원가입");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setVisible(true);
		
		JPanel panel_info = new JPanel();
		contentPane.add(panel_info, BorderLayout.CENTER);
		
		
		JLabel jl1_id = new JLabel("아이디: ");
		tfId = new JTextField();
		tfId.setColumns(10);
		
		JLabel jl2_pwd = new JLabel("비밀번호: ");
		pfpwd = new JPasswordField();
		pfpwd.setColumns(10);
		
		JLabel jl3_name = new JLabel("이름: ");
		tfName = new JTextField();
		tfName.setColumns(10);
		
		JLabel jl4_cont = new JLabel("연락처: ");
		tfCont = new JTextField();
		tfCont.setColumns(10);
		
		JLabel jl5_addr = new JLabel("주소: ");
		tfAddr = new JTextField();
		tfAddr.setColumns(20);
		
		
		JPanel panel = new JPanel();
		panel_info.add(panel);

		JPanel panel_1 = new JPanel();
		panel_info.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_info.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_info.add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_info.add(panel_4);
		
		panel_info.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel.add(jl1_id); panel.add(tfId);
		panel_1.add(jl2_pwd); panel_1.add(pfpwd);
		panel_2.add(jl3_name); panel_2.add(tfName);
		panel_3.add(jl4_cont); panel_3.add(tfCont);
		panel_4.add(jl5_addr); panel_4.add(tfAddr);
		
		JPanel panel_btn = new JPanel();
		contentPane.add(panel_btn, BorderLayout.SOUTH);
		
		JButton btnSignUp = new JButton("회원가입");
		panel_btn.add(btnSignUp);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_btn.add(btnCancel);
	}
	
//	void insert() {
//		try {
//			sql = "insert into member values(?,?,mem_seq.nextval,?,?,?,0)";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, jtf1ID.getText());
//			pstmt.setString(2, jtf2Pwd.getText());
//			//mem_num은 시스템에서 부여.
//			pstmt.setString(3, jtf3Name.getText());
//			pstmt.setString(4, jtf4Cont.getText());
//			pstmt.setString(5, jtf5Addr.getText());
//			//mem_mileage는 초기 0에서 시작.
//			
//			int res = pstmt.executeUpdate();
//			
//			if(res > 0) {
//				JOptionPane.showMessageDialog(null, "회원가입 완료.");
//			}else {
//				JOptionPane.showMessageDialog(null, "회원가입 실패.");
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	void connect() {
//		try {
//			con = DBConnection.getConnection();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
