package team3.khie_dohyung;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Manage extends JFrame {
	
	public Manage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/제목 없음2.jpg"));
		
		setTitle("관리자 테이블");
		
		JPanel title=new JPanel();
		title.setBackground(SystemColor.window);
		JPanel container3 = new JPanel();
		container3.setBackground(SystemColor.window);
		JPanel container4 = new JPanel();
		JPanel container5 = new JPanel();
				
		
		JLabel login = new JLabel("관리자 화면");
		
		
		login.setForeground(new Color(5,0,153));
		login.setFont(new Font("휴먼편지체",Font.BOLD, 35));
		
		title.add(login);
		
		JPanel group1 = new JPanel((new BorderLayout()));
		group1.setBackground(SystemColor.window);
		
		
		group1.add (title, BorderLayout.SOUTH);
		
		JTextPane textPane = new JTextPane();
		title.add(textPane);
		//group.add(container3, BorderLayout.NORTH);
		//group.add(container4, BorderLayout.CENTER);
		//group.add(container5, BorderLayout.SOUTH);
		
	
		
		getContentPane().add(group1,BorderLayout.NORTH);
		getContentPane().add(container3,BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(SystemColor.window);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		JButton jb3 = new JButton("음식 메뉴 관리");
		jb3.setBackground(Color.CYAN);
		jb3.setFont(new Font("휴먼편지체",Font.BOLD, 35));
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manage_Foodmenu();
				dispose();
				
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("images/sfood.png"));
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(jb3)
					.addContainerGap())
		);
		gl_panel_1_1.setVerticalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_1_1)
						.addGroup(gl_panel_1_1.createSequentialGroup()
							.addComponent(jb3)
							.addGap(3)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel_1_1.setLayout(gl_panel_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(SystemColor.window);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		
		JButton jb5 = new JButton("만화 도서 관리");
		jb5.setBackground(Color.CYAN);
		jb5.setFont(new Font("휴먼편지체",Font.BOLD, 35));
		
		jb5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manage_Manwha();
				dispose();
				
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("images/scomic.png"));
		GroupLayout gl_panel_1_1_1 = new GroupLayout(panel_1_1_1);
		gl_panel_1_1_1.setHorizontalGroup(
			gl_panel_1_1_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1_1_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1_1_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1_1)
						.addComponent(lblNewLabel_5))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(jb5)
					.addContainerGap())
		);
		gl_panel_1_1_1.setVerticalGroup(
			gl_panel_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1_1_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1_1)
						.addGroup(gl_panel_1_1_1.createSequentialGroup()
							.addComponent(jb5)
							.addGap(14)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1_1_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel_5)
					.addContainerGap())
		);
		panel_1_1_1.setLayout(gl_panel_1_1_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(SystemColor.window);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		JButton jb2 = new JButton("매출 금액 관리");
		jb2.setBackground(Color.CYAN);
		jb2.setFont(new Font("휴먼편지체",Font.BOLD, 35));
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manage_Sales();
				dispose();
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images/ssales.png"));
		GroupLayout gl_panel_1_2 = new GroupLayout(panel_1_2);
		gl_panel_1_2.setHorizontalGroup(
			gl_panel_1_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_2)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(jb2)
					.addContainerGap())
		);
		gl_panel_1_2.setVerticalGroup(
			gl_panel_1_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1_2)
						.addGroup(gl_panel_1_2.createSequentialGroup()
							.addComponent(jb2)
							.addGap(3)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel_1_2.setLayout(gl_panel_1_2);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(SystemColor.window);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		JButton jb4 = new JButton("요금 메뉴 관리");
		jb4.setBackground(Color.CYAN);
		jb4.setFont(new Font("휴먼편지체",Font.BOLD, 35));
		
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manage_TimeTable();
				dispose();
				
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("images/smenu.png"));
		GroupLayout gl_panel_1_3 = new GroupLayout(panel_1_3);
		gl_panel_1_3.setHorizontalGroup(
			gl_panel_1_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_3.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_panel_1_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_3)
						.addComponent(lblNewLabel_6))
					.addContainerGap(102, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1_3.createSequentialGroup()
					.addContainerGap(115, Short.MAX_VALUE)
					.addComponent(jb4)
					.addContainerGap())
		);
		gl_panel_1_3.setVerticalGroup(
			gl_panel_1_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_6)
						.addGroup(gl_panel_1_3.createSequentialGroup()
							.addComponent(jb4)
							.addGap(8)
							.addComponent(lblNewLabel_1_3)))
					.addGap(17))
		);
		panel_1_3.setLayout(gl_panel_1_3);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setBackground(SystemColor.window);
		
		JLabel lblNewLabel_1_4 = new JLabel("");
		JButton jb6 = new JButton("리뷰 별점 관리");
		jb6.setBackground(Color.CYAN);
		jb6.setFont(new Font("휴먼편지체",Font.BOLD, 35));
		jb6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manage_Review();
				dispose();
				
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("images/sreview.png"));
		GroupLayout gl_panel_1_4 = new GroupLayout(panel_1_4);
		gl_panel_1_4.setHorizontalGroup(
			gl_panel_1_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1_4.createSequentialGroup()
					.addGap(9)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1_4.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1_4.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1_4)
							.addContainerGap(296, Short.MAX_VALUE))
						.addGroup(gl_panel_1_4.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jb6)
							.addContainerGap())))
		);
		gl_panel_1_4.setVerticalGroup(
			gl_panel_1_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1_4.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addContainerGap())
						.addGroup(gl_panel_1_4.createSequentialGroup()
							.addComponent(jb6)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1_4)
							.addContainerGap(14, Short.MAX_VALUE))))
		);
		panel_1_4.setLayout(gl_panel_1_4);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("images/comic2.png"));
		
		JLabel lblNewLabel_8 = new JLabel("3조 김도형 박정원");
		
		lblNewLabel_8.setFont(new Font("휴먼편지체",Font.BOLD, 25));
		
		JLabel lblNewLabel_8_1 = new JLabel("고지혜 오경종");
		lblNewLabel_8_1.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(63)
							.addComponent(lblNewLabel_8)
							.addGap(44)
							.addComponent(lblNewLabel_9)
							.addGap(50)
							.addComponent(lblNewLabel_8_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel_1_1_1, 0, 0, Short.MAX_VALUE)
								.addComponent(panel_1_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 365, Short.MAX_VALUE))
							.addGap(26)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(panel_1_3, 0, 0, Short.MAX_VALUE)
									.addComponent(panel_1_2, GroupLayout.PREFERRED_SIZE, 368, Short.MAX_VALUE))
								.addComponent(panel_1_4, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(96)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1_2, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1_3, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panel_1_1_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(panel_1_4, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(60)
							.addComponent(lblNewLabel_8))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(59)
							.addComponent(lblNewLabel_8_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(27)
							.addComponent(lblNewLabel_9)))
					.addGap(31))
		);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("images/suser.png"));
		
		
		JButton jb1 = new JButton("회원 정보 관리");
		jb1.setBackground(Color.CYAN);
		
		jb1.setFont(new Font("휴먼편지체",Font.BOLD, 36));
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manage_Inform_search();
				dispose();
				
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jb1)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(jb1)
						.addComponent(lblNewLabel_1))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		GroupLayout gl_container3 = new GroupLayout(container3);
		gl_container3.setHorizontalGroup(
			gl_container3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_container3.createSequentialGroup()
					.addGap(4)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 780, Short.MAX_VALUE))
		);
		gl_container3.setVerticalGroup(
			gl_container3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container3.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 687, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		container3.setLayout(gl_container3);
		setBounds(200,200,800,800);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		
		new Manage();
		

	}
}
