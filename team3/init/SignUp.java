package src.init;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class SignUp extends JFrame {
	Connection con = null;              // DB와 연결하는 객체.
	PreparedStatement pstmt = null;     // SQL문을 DB에 전송하는 객체.
	ResultSet rs = null;	// SQL문을 실행한 후의 결과값을 가지고 있는 객체.
	String sql = null;		// SQL문 저장 문자열 변수

	private JPanel contentPane;
	private JTextField tfId;
	private JPasswordField pfpwd;
	private JTextField tfName;
	private JTextField tfCont;
	private JTextField tfAddr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setTitle("회원가입");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_info = new JPanel();
		contentPane.add(panel_info, BorderLayout.CENTER);
		
		JSplitPane splitPane_id = new JSplitPane();
		
		JLabel jl1_id = new JLabel("아이디: ");
		splitPane_id.setLeftComponent(jl1_id);
		
		tfId = new JTextField();
		splitPane_id.setRightComponent(tfId);
		tfId.setColumns(10);
		
		JSplitPane splitPane_pwd = new JSplitPane();
		
		JLabel jl2_pwd = new JLabel("비밀번호: ");
		splitPane_pwd.setLeftComponent(jl2_pwd);
		
		pfpwd = new JPasswordField();
		pfpwd.setColumns(10);
		splitPane_pwd.setRightComponent(pfpwd);
		
		JSplitPane splitPane_name = new JSplitPane();
		
		JLabel jl3_name = new JLabel("이름: ");
		splitPane_name.setLeftComponent(jl3_name);
		
		tfName = new JTextField();
		splitPane_name.setRightComponent(tfName);
		tfName.setColumns(10);
		
		JSplitPane splitPane_cont = new JSplitPane();
		
		JLabel il4_cont = new JLabel("연락처: ");
		splitPane_cont.setLeftComponent(il4_cont);
		
		tfCont = new JTextField();
		splitPane_cont.setRightComponent(tfCont);
		tfCont.setColumns(10);
		
		JSplitPane splitPane_addr = new JSplitPane();
		
		JLabel jl5_addr = new JLabel("주소: ");
		splitPane_addr.setLeftComponent(jl5_addr);
		
		tfAddr = new JTextField();
		splitPane_addr.setRightComponent(tfAddr);
		tfAddr.setColumns(20);
		panel_info.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_info.add(splitPane_id);
		panel_info.add(splitPane_pwd);
		panel_info.add(splitPane_name);
		panel_info.add(splitPane_cont);
		panel_info.add(splitPane_addr);
		
		JPanel panel_btn = new JPanel();
		contentPane.add(panel_btn, BorderLayout.SOUTH);
		
		JButton btnSignUp = new JButton("회원가입");
		panel_btn.add(btnSignUp);
		
		JButton btnCancel = new JButton("취소");
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
