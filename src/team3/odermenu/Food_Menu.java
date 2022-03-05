package team3.odermenu;

import java.awt.BorderLayout;

import javax.swing.*;

public class Food_Menu extends JFrame{
	
	
	public Food_Menu() {
		
		setTitle("먹을거리 메뉴");


		JTabbedPane tab = new JTabbedPane(JTabbedPane.LEFT);
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		JPanel container4 = new JPanel();
		JPanel container5 = new JPanel();
					
		JButton jb1 = new JButton("HOME");
		
		JButton jb2 = new JButton("장바구니");
		JButton jb3 = new JButton("결제");
		
		
		tab.add("식사", container1);
		tab.add("음료", container2);
		tab.add("스낵", container3);
		container4.add(jb1);
		container5.add(jb2);
		container5.add(jb3);
		 
		add(container4, BorderLayout.NORTH);
		add(tab, BorderLayout.CENTER);
		add(container5, BorderLayout.SOUTH);
		
		setBounds(650, 150, 800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	}

	public static void main(String[] args) {

		new Food_Menu();
	}

}
