package team3.khie_dohyung;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Manage extends JFrame {
	
	public Manage() {
		
		setTitle("관리자 테이블");
		
		JPanel title=new JPanel();
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		JPanel container4 = new JPanel();
		JPanel container5 = new JPanel();
		
		
		JButton jb1 = new JButton("회원 정보 관리");
		JButton jb2 = new JButton("매출 금액 관리");
		JButton jb3 = new JButton("음식 메뉴 관리");
		JButton jb4 = new JButton("요금 메뉴 관리");
		
		JButton jb5 = new JButton("만화 도서 관리");
		JButton jb6 = new JButton("리뷰 별점 관리");
				
		
		JLabel login = new JLabel("관리자 화면");
		
		
		login.setForeground(new Color(5,0,153));
		login.setFont(new Font("휴먼편지체",Font.BOLD, 25));
		
		title.add(login);
		container1.add(jb1);
		container1.add(jb2);
		container2.add(jb3);
		container2.add(jb4);
		container3.add(jb5);
		container3.add(jb6);
		
		jb1.setFont(new Font("휴먼편지체",Font.BOLD, 20));
		jb2.setFont(new Font("휴먼편지체",Font.BOLD, 20));
		jb3.setFont(new Font("휴먼편지체",Font.BOLD, 20));
		jb4.setFont(new Font("휴먼편지체",Font.BOLD, 20));
		jb5.setFont(new Font("휴먼편지체",Font.BOLD, 20));
		jb6.setFont(new Font("휴먼편지체",Font.BOLD, 20));
		
		JPanel group1 = new JPanel((new BorderLayout()));
		JPanel group = new JPanel((new BorderLayout()));
		
		group1.add (title, BorderLayout.NORTH);
		group1.add(container1, BorderLayout.CENTER);
		group1.add(container2, BorderLayout.SOUTH);
		//group.add(container3, BorderLayout.NORTH);
		//group.add(container4, BorderLayout.CENTER);
		//group.add(container5, BorderLayout.SOUTH);
		
	
		
		add(group1,BorderLayout.NORTH);
		add(container3,BorderLayout.CENTER);
		setBounds(200,200,420,240);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manage_Inform_search();
				dispose();
				
			}
		});
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manage_Foodmenu();
				dispose();
				
			}
		});
		
		jb5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manage_Manwha();
				dispose();
				
			}
		});
		jb6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manage_Review();
				dispose();
				
			}
		});
	}
	

	public static void main(String[] args) {
		
		new Manage();
		

	}

}
