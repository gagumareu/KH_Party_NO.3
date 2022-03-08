package team3.init;

import java.awt.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

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
		
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new FlowLayout());
		
		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new GridLayout(5, 1));
		
		JPanel panelId = new JPanel();
		JPanel panelPwd = new JPanel();
		JPanel panelName = new JPanel();
		JPanel panelCont = new JPanel();
		JPanel panelAddr = new JPanel();
		
		
		JPanel panel_id1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel panel_id2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel jl1_id = new JLabel("아이디: ");
		tfId = new JTextField();
		tfId.setColumns(10);
		
		panel_id1.add(jl1_id); panel_id2.add(tfId);
		panelId.add(panel_id1); panelId.add(panel_id2);
		
		
		JPanel panel_pwd1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel panel_pwd2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel jl2_pwd = new JLabel("비밀번호: ");
		pfpwd = new JPasswordField();
		pfpwd.setColumns(10);
		
		panel_pwd1.add(jl2_pwd); panel_pwd2.add(pfpwd);
		panelPwd.add(panel_pwd1); panelPwd.add(panel_pwd2);
		
		
		JPanel panel_name1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel panel_name2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel jl3_name = new JLabel("이름: ");
		tfName = new JTextField();
		tfName.setColumns(10);
		
		panel_name1.add(jl3_name); panel_name2.add(tfName);
		panelName.add(panel_name1); panelName.add(panel_name2);
		
		
		JPanel panel_cont1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel panel_cont2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel jl4_cont = new JLabel("연락처: ");
		tfCont = new JTextField();
		tfCont.setColumns(10);
		
		panel_cont1.add(jl4_cont); panel_cont2.add(tfCont);
		panelCont.add(panel_cont1); panelCont.add(panel_cont2);
		
		
		JPanel panel_addr1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel panel_addr2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel jl5_addr = new JLabel("주소: ");
		tfAddr = new JTextField();
		tfAddr.setColumns(15);
		
		panel_addr1.add(jl5_addr); panel_addr2.add(tfAddr);
		panelAddr.add(panel_addr1); panelAddr.add(panel_addr2);
		
		panelInfo.add(panelId); panelInfo.add(panelPwd);
		panelInfo.add(panelName); panelInfo.add(panelCont);
		panelInfo.add(panelAddr);
		
		panelCenter.add(panelInfo);
		
		contentPane.add(panelCenter);
		
		JPanel panelBtn = new JPanel();
		contentPane.add(panelBtn, BorderLayout.SOUTH);
		
		JButton btnSignUp = new JButton("회원가입");
		btnSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				insert();
			}
		});
		panelBtn.add(btnSignUp);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelBtn.add(btnCancel);
	}
	
	void insert() {
		try {
			sql = "insert into member values(?,?,mem_seq.nextval,?,?,?,0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tfId.getText());
			pstmt.setString(2, String.valueOf(pfpwd.getPassword()));
			//mem_num은 시스템에서 부여.
			pstmt.setString(3, tfName.getText());
			pstmt.setString(4, tfCont.getText());
			pstmt.setString(5, tfAddr.getText());
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
