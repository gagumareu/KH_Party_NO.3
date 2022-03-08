package team3.init;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class FindIdPassword extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		JPanel panelFindId = new JPanel();
		tabbedPane.addTab("아이디 찾기", null, panelFindId, null);
		panelFindId.setLayout(new GridLayout(3, 1));
		
		JPanel panel_id1 = new JPanel();
		panelFindId.add(panel_id1);
		
		JLabel lblNewLabel = new JLabel("아이디를 찾기 위한 정보를 입력하세요.");
		panel_id1.add(lblNewLabel);
		
		JPanel panel_id2 = new JPanel();
		panelFindId.add(panel_id2);
		
		JLabel lblNewLabel_2 = new JLabel("이름: ");
		panel_id2.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_id2.add(textField);
		
		JPanel panel_idBtn = new JPanel();
		panelFindId.add(panel_idBtn);
		
		JButton btnFindId = new JButton("아이디 찾기");
		panel_idBtn.add(btnFindId);
		
		JPanel panelFindPwd = new JPanel();
		tabbedPane.addTab("비밀번호 찾기", null, panelFindPwd, null);
		panelFindPwd.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_pwd1 = new JPanel();
		panelFindPwd.add(panel_pwd1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호 찾기를 위한 정보를 입력하세요.");
		panel_pwd1.add(lblNewLabel_1);
		
		JPanel panel_pwd2 = new JPanel();
		panelFindPwd.add(panel_pwd2, BorderLayout.CENTER);
		
		JPanel panel_wrapPwdInfo = new JPanel();
		panel_pwd2.add(panel_wrapPwdInfo);
		panel_wrapPwdInfo.setLayout(new GridLayout(3, 1));
		
		JPanel panel_pwdInfo1 = new JPanel();
		FlowLayout fl_panel_pwdInfo1 = (FlowLayout) panel_pwdInfo1.getLayout();
		fl_panel_pwdInfo1.setAlignment(FlowLayout.RIGHT);
		panel_wrapPwdInfo.add(panel_pwdInfo1);
		
		JLabel lblNewLabel_3 = new JLabel("이름: ");
		panel_pwdInfo1.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_pwdInfo1.add(textField_1);
		
		JPanel panel_pwdInfo2 = new JPanel();
		FlowLayout fl_panel_pwdInfo2 = (FlowLayout) panel_pwdInfo2.getLayout();
		fl_panel_pwdInfo2.setAlignment(FlowLayout.RIGHT);
		panel_wrapPwdInfo.add(panel_pwdInfo2);
		
		JLabel lblNewLabel_4 = new JLabel("아이디: ");
		panel_pwdInfo2.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_pwdInfo2.add(textField_2);
		
		JPanel panel_pwdInfo3 = new JPanel();
		FlowLayout fl_panel_pwdInfo3 = (FlowLayout) panel_pwdInfo3.getLayout();
		fl_panel_pwdInfo3.setAlignment(FlowLayout.RIGHT);
		panel_wrapPwdInfo.add(panel_pwdInfo3);
		
		JLabel lblNewLabel_5 = new JLabel("어릴 때 살던 동네는? ");
		panel_pwdInfo3.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_pwdInfo3.add(textField_3);
		
		JPanel panel_pwdBtn = new JPanel();
		panelFindPwd.add(panel_pwdBtn, BorderLayout.SOUTH);
		
		JButton btnFindPwd = new JButton("비밀번호 찾기");
		panel_pwdBtn.add(btnFindPwd);
		
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

}
