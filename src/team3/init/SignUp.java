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
	private JTextField tfId, tfName, tfCont, tfAddr, tfAns;
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
		setBounds(100, 100, 250, 350);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setVisible(true);
		//기본 panel 세팅
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(SystemColor.info);
		panelCenter.setLayout(new FlowLayout());
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(SystemColor.info);
		panelInfo.setLayout(new GridLayout(7, 1));
		
		JPanel panelId = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelId.setBackground(SystemColor.info);
		JPanel panelPwd = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelPwd.setBackground(SystemColor.info);
		JPanel panelName = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelName.setBackground(SystemColor.info);
		JPanel panelCont = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelCont.setBackground(SystemColor.info);
		JPanel panelAddr = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelAddr.setBackground(SystemColor.info);
		
		
		JLabel jl1_id = new JLabel("아이디*: ");
		tfId = new JTextField();
		tfId.setColumns(10);
		panelId.add(jl1_id); panelId.add(tfId);
		
		JLabel jl2_pwd = new JLabel("비밀번호*: ");
		pfpwd = new JPasswordField();
		pfpwd.setColumns(10);
		panelPwd.add(jl2_pwd); panelPwd.add(pfpwd);
		
		JLabel jl3_name = new JLabel("이름*: ");
		tfName = new JTextField();
		tfName.setColumns(10);
		panelName.add(jl3_name); panelName.add(tfName);
		
		JLabel jl4_cont = new JLabel("연락처: ");
		tfCont = new JTextField();
		tfCont.setColumns(10);
		panelCont.add(jl4_cont); panelCont.add(tfCont);
		
		JLabel jl5_addr = new JLabel("주소: ");
		tfAddr = new JTextField();
		tfAddr.setColumns(10);
		panelAddr.add(jl5_addr); panelAddr.add(tfAddr);
		

		panelInfo.add(panelId); panelInfo.add(panelPwd);
		panelInfo.add(panelName); panelInfo.add(panelCont);
		panelInfo.add(panelAddr);
		
		
		JLabel jl6_Question = new JLabel("비밀번호 찾기 질문*: ");
		jl6_Question.setBackground(SystemColor.info);
		JPanel panelAns = new JPanel();
		panelAns.setBackground(SystemColor.info);
		panelInfo.add(jl6_Question); panelInfo.add(panelAns);
		
		JLabel jl6_Ans = new JLabel("어릴때 살던 동네는? ");
		tfAns = new JTextField();
		tfAns.setColumns(5);
		panelAns.add(jl6_Ans); panelAns.add(tfAns);
		
		panelCenter.add(panelInfo);
		
		JLabel jl7 = new JLabel("*는 필수 입력");
		panelCenter.add(jl7);
		
		contentPane.add(panelCenter);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setBackground(SystemColor.info);
		contentPane.add(panelBtn, BorderLayout.SOUTH);
		
		
		//버튼 이벤트 처리
		JButton btnSignUp = new JButton("가입하기");
		btnSignUp.setBackground(SystemColor.window);
		btnSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				insert();
			}
		});
		panelBtn.add(btnSignUp);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBackground(SystemColor.window);
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
			sql = "insert into member values(?,?,mem_seq.nextval,?,?,?,?,0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tfId.getText());
			pstmt.setString(2, String.valueOf(pfpwd.getPassword()));
			//mem_num은 시스템에서 부여.
			pstmt.setString(3, tfName.getText());
			pstmt.setString(4, tfCont.getText());
			pstmt.setString(5, tfAddr.getText());
			pstmt.setString(6, tfAns.getText());
			//mem_mileage는 초기 0에서 시작.
			
			int res = pstmt.executeUpdate();
			
			if(res > 0) {
				JOptionPane.showMessageDialog(null, "회원가입 완료.");
			}else {
				JOptionPane.showMessageDialog(null, "회원가입 실패.");
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "필수정보를 입력해주세요.");
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
