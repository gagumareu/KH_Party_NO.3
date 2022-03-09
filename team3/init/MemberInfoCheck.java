package team3.init;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MemberInfoCheck extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberInfoCheck frame = new MemberInfoCheck();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MemberInfoCheck() {
		setTitle("회원 정보 확인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("회원 정보 수정");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("닫기");
		panel_1.add(btnNewButton_1);
		
		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel_9.add(panel);
		panel.setLayout(new GridLayout(7, 1));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("회원 번호: ");
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		panel_2.add(lblNewLabel_5);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("회원 이름: ");
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		panel_3.add(lblNewLabel_6);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JLabel lblNewLabel_10 = new JLabel("회원 아이디: ");
		panel_4.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		panel_4.add(lblNewLabel_11);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JLabel lblNewLabel_2 = new JLabel("회원 연락처: ");
		panel_5.add(lblNewLabel_2);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		panel_5.add(lblNewLabel_7);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		JLabel lblNewLabel_3 = new JLabel("회원 주소: ");
		panel_6.add(lblNewLabel_3);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		panel_6.add(lblNewLabel_8);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		
		JLabel lblNewLabel_4 = new JLabel("보유 마일리지: ");
		panel_7.add(lblNewLabel_4);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		panel_7.add(lblNewLabel_9);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		JButton btnNewButton_2 = new JButton("비밀번호 찾기 질문 답 확인");
		panel_8.add(btnNewButton_2);
		setVisible(true);
	}

}
