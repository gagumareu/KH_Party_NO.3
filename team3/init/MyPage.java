package team3.init;

import java.awt.*;
import java.awt.event.*;

import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MyPage extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPage frame = new MyPage();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyPage() {
		setTitle("마이 페이지");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel jl_greet1 = new JLabel("안녕하세요.");
		panel_1.add(jl_greet1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel jl_greet2 = new JLabel("마이 페이지에 온 것을 환영합니다.");
		panel_2.add(jl_greet2);
		
		JPanel panelBtn = new JPanel();
		contentPane.add(panelBtn, BorderLayout.SOUTH);
		
		JButton btnCheck = new JButton("회원정보 확인");
		btnCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberInfoCheck();
			}
		});
		panelBtn.add(btnCheck);
		
		JButton btnEdit = new JButton("회원정보 수정");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberInfoEdit();
			}
		});
		panelBtn.add(btnEdit);
		setVisible(true);
	}
	
	public MyPage(String id) {
		setTitle("마이 페이지");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel jl_greet1 = new JLabel("안녕하세요, " + id + "님.");
		panel_1.add(jl_greet1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel jl_greet2 = new JLabel("마이 페이지에 온 것을 환영합니다.");
		panel_2.add(jl_greet2);
		
		JPanel panelBtn = new JPanel();
		contentPane.add(panelBtn, BorderLayout.SOUTH);
		
		JButton btnCheck = new JButton("회원정보 확인");
		btnCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberInfoCheck();
			}
		});
		panelBtn.add(btnCheck);
		
		JButton btnEdit = new JButton("회원정보 수정");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberInfoEdit();
			}
		});
		panelBtn.add(btnEdit);
		setVisible(true);
	}
}
