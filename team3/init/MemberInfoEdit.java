package team3.init;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MemberInfoEdit extends JFrame {

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
					MemberInfoEdit frame = new MemberInfoEdit();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MemberInfoEdit() {
		setTitle("회원 정보 수정");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("수정 완료");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_9 = new JLabel("회원 이름, 아이디 변경은 카운터에 문의하세요.");
		contentPane.add(lblNewLabel_9, BorderLayout.NORTH);
		
		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel_9.add(panel);
		panel.setLayout(new GridLayout(7, 1));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JLabel lblNewLabel_7 = new JLabel("회원 번호: ");
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		panel_3.add(lblNewLabel_8);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("회원 이름: ");
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		panel_4.add(lblNewLabel_6);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JLabel lblNewLabel_4 = new JLabel("회원 아이디: ");
		panel_5.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		panel_5.add(lblNewLabel_5);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		JLabel lblNewLabel = new JLabel("기존 비밀번호 입력: ");
		panel_6.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_6.add(textField);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		
		JLabel lblNewLabel_10 = new JLabel("비밀번호 변경: ");
		panel_7.add(lblNewLabel_10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_7.add(textField_1);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		JLabel lblNewLabel_2 = new JLabel("연락처 변경: ");
		panel_8.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_8.add(textField_2);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("주소 변경: ");
		panel_2.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_2.add(textField_3);
		setVisible(true);
	}

}
