package team3.khie_dohyung;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import team3.booktable.Booktable;
import team3.odermenu.Food;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.Color;

public class ManwhaMain extends JFrame {
	
	Connection con = null;
	
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	String sql = null;
	DefaultTableModel model;
	JTextField jtf1,jtf2,jtf3,jtf4;
	JTable table;
	JComboBox<String>jcb1;
	
	public ManwhaMain() {
		
		setTitle("메인 메뉴 테이블");
		
		JPanel container1 = new JPanel();
		container1.setBackground(SystemColor.info);
		
		JButton jb1= new JButton("메뉴 목록");
		jb1.setBackground(Color.CYAN);
		JButton jb2= new JButton("도서검색 목록");
		jb2.setBackground(Color.CYAN);
		
		getContentPane().add(container1);
		
		
		jb1.setFont(new Font("휴먼편지체",Font.BOLD, 40));
		jb2.setFont(new Font("휴먼편지체",Font.BOLD, 40));
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\git\\KH_PartyNo3\\images\\StartIcon.png"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\git\\KH_PartyNo3\\images\\dfood.png"));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\git\\KH_PartyNo3\\images\\dmenu.png"));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\git\\KH_PartyNo3\\images\\dreview.png"));
		
		JLabel lblNewLabel_4 = new JLabel("");
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\git\\KH_PartyNo3\\images\\dcomic.png"));
		
		JLabel lblNewLabel_8 = new JLabel("3조 김도형 박정원");
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 25));
		
		JLabel lblNewLabel_8_1 = new JLabel("고지혜 오경종");
		lblNewLabel_8_1.setFont(new Font("Dialog", Font.BOLD, 25));
		GroupLayout gl_container1 = new GroupLayout(container1);
		gl_container1.setHorizontalGroup(
			gl_container1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container1.createSequentialGroup()
					.addGap(25)
					.addComponent(jb1, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(jb2, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
				.addGroup(gl_container1.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel_1)
					.addGap(50)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
					.addComponent(lblNewLabel_3)
					.addGap(37)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4)
					.addGap(71))
				.addGroup(gl_container1.createSequentialGroup()
					.addGap(47)
					.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(lblNewLabel)
					.addGap(58)
					.addComponent(lblNewLabel_8_1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		gl_container1.setVerticalGroup(
			gl_container1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_container1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_container1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_container1.createSequentialGroup()
							.addGroup(gl_container1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_3))
							.addGap(18))
						.addGroup(gl_container1.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addGap(65)))
					.addGroup(gl_container1.createParallelGroup(Alignment.BASELINE)
						.addComponent(jb2, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
						.addComponent(jb1, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_container1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel))
						.addGroup(gl_container1.createSequentialGroup()
							.addGap(81)
							.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_container1.createSequentialGroup()
							.addGap(84)
							.addComponent(lblNewLabel_8_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
					.addGap(36))
		);
		container1.setLayout(gl_container1);
		
		setBounds(200,200,800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Food();
				dispose();
				
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Booktable();
				dispose();
				
				
			}
		});
		
	}
	
	

	public static void main(String[] args) {
	new ManwhaMain();

	}

}
