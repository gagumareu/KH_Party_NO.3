package team3.khie_dohyung;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import team3.booktable.booktable;
//import team3.odermenu.Food;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ManwhaMain extends JFrame {
	
	Connection con = null;
	
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	String sql = null;
	DefaultTableModel model;
	JTextField jtf1,jtf2,jtf3,jtf4;
	JTable table;
	JComboBox<String>jcb1;
	
	public ManwhaMain(String id) {
		
		setTitle("메인 메뉴 테이블");
		
		JPanel container1 = new JPanel();
		container1.setBackground(SystemColor.info);

		
		JLabel jl1= new JLabel("메뉴 목록");
	
		JLabel jl2= new JLabel("도서 목록");
		
		
		jl1.setFont(new Font("휴먼편지체",Font.BOLD, 70));
		jl2.setFont(new Font("휴먼편지체",Font.BOLD, 70));
		
		getContentPane().add(container1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\git\\KH_PartyNo3\\images\\dreview.png"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\git\\KH_PartyNo3\\images\\dmenu.png"));
		GroupLayout gl_container1 = new GroupLayout(container1);
		gl_container1.setHorizontalGroup(
			gl_container1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addGroup(gl_container1.createSequentialGroup()
							.addGap(27)
							.addComponent(jl1)))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(gl_container1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addGroup(gl_container1.createSequentialGroup()
							.addComponent(jl2)
							.addGap(14)))
					.addGap(41))
		);
		gl_container1.setVerticalGroup(
			gl_container1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_container1.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_container1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addGap(33)
					.addGroup(gl_container1.createParallelGroup(Alignment.BASELINE)
						.addComponent(jl2)
						.addComponent(jl1))
					.addContainerGap(253, Short.MAX_VALUE))
		);
		container1.setLayout(gl_container1);
		
		
		setBounds(200,200,800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//new Food();
				dispose();
				super.mouseClicked(e);
			}
		});
		
		lblNewLabel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				new booktable(id);
				dispose();
				super.mouseClicked(e);
			}
		});
		
		jl1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//new Food();
				dispose();
				super.mouseClicked(e);
			}
		});
		jl2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new booktable(id);
				dispose();
				super.mouseClicked(e);
			}
		});
		
	
	}
	
	

	public static void main(String[] args) {
	new ManwhaMain("id");

	}
}
