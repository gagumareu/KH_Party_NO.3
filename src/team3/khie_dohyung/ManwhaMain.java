package team3.khie_dohyung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import team3.booktable.Booktable;
import team3.odermenu.Food;

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
		
		JButton jb1= new JButton("결제 목록");
		JButton jb2= new JButton("도서검색 목록");
		
		container1.add(jb1);
		container1.add(jb2);
		
		add(container1);
		
		setBounds(200,200,700,250);
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
