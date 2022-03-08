package team3.khie_dohyung;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Color;

public class Manage_Foodmenu extends JFrame {
	Connection con = null;
	
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	String sql = null;
	DefaultTableModel model;
	JTextField jtf1,jtf2,jtf3;
	JTable table;
	JComboBox<String>jcb1;
	
	public Manage_Foodmenu() {
		getContentPane().setBackground(SystemColor.info);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\git\\KH_PartyNo3\\images\\제목 없음2.jpg"));
		setTitle("음식 메뉴 테이블");
		JPanel container1 = new JPanel();
		container1.setBackground(SystemColor.info);
		JPanel container2 = new JPanel();
		container2.setBackground(SystemColor.info);
		
		JLabel jl1 = new JLabel("음식번호:");
		jtf1= new JTextField(10);
		
		JLabel jl2 = new JLabel("음식이름:");
		jtf2= new JTextField(10);
		
		JLabel jl3 = new JLabel("금  액:");
		jtf3= new JTextField(10);
		
		JLabel jl4 = new JLabel("음식분류:");
		jcb1= new JComboBox<String>();
		
		jcb1.addItem("선택");
		
		String[] header={"음식번호","음식이름","금액","음식분류"};
		
		model = new DefaultTableModel(header,0);
		
		table = new JTable(model);
		
		JScrollPane jsp= new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton jb1= new JButton("음식 목록");
		jb1.setBackground(Color.CYAN);
		JButton jb2= new JButton("음식 추가");
		jb2.setBackground(Color.CYAN);
		JButton jb3= new JButton("음식 수정");
		jb3.setBackground(Color.CYAN);
		JButton jb4= new JButton("음식 삭제");
		jb4.setBackground(Color.CYAN);
		JButton jb5= new JButton("돌아 가기");
		jb5.setBackground(Color.CYAN);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\git\\KH_PartyNo3\\images\\제목 없음2.jpg"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(container2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addComponent(lblNewLabel)
					.addGap(67)
					.addComponent(container1, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addComponent(jsp, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(container2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(container1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
							.addGap(22))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(51)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jsp, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_container2 = new GroupLayout(container2);
		gl_container2.setHorizontalGroup(
			gl_container2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_container2.createParallelGroup(Alignment.LEADING)
						.addComponent(jb3)
						.addComponent(jb2)
						.addComponent(jb4)
						.addComponent(jb1)
						.addComponent(jb5))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_container2.setVerticalGroup(
			gl_container2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container2.createSequentialGroup()
					.addContainerGap()
					.addComponent(jb1)
					.addGap(10)
					.addComponent(jb2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jb3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jb4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jb5)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		container2.setLayout(gl_container2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\git\\KH_PartyNo3\\images\\sfood.png"));
		GroupLayout gl_container1 = new GroupLayout(container1);
		gl_container1.setHorizontalGroup(
			gl_container1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_container1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_container1.createSequentialGroup()
							.addGroup(gl_container1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_container1.createSequentialGroup()
									.addComponent(jl3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(jtf3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_container1.createSequentialGroup()
									.addComponent(jl1)
									.addGap(5)
									.addComponent(jtf1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
							.addGroup(gl_container1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_container1.createSequentialGroup()
									.addComponent(jl4)
									.addGap(5)
									.addComponent(jcb1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_container1.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(18)
									.addComponent(lblNewLabel_1)))
							.addGap(78))
						.addGroup(gl_container1.createSequentialGroup()
							.addComponent(jl2)
							.addGap(5)
							.addComponent(jtf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(218, Short.MAX_VALUE))))
		);
		gl_container1.setVerticalGroup(
			gl_container1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container1.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_container1.createSequentialGroup()
							.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_container1.createSequentialGroup()
									.addGap(3)
									.addComponent(jl1))
								.addComponent(jtf1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(5)
							.addComponent(lblNewLabel_1)
							.addGap(26)
							.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_container1.createSequentialGroup()
									.addGap(3)
									.addComponent(jl2))
								.addComponent(jtf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblNewLabel_2))
					.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_container1.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_container1.createSequentialGroup()
									.addGap(3)
									.addComponent(jl4))
								.addComponent(jcb1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtf3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_container1.createSequentialGroup()
							.addGap(34)
							.addComponent(jl3)))
					.addGap(24))
		);
		container1.setLayout(gl_container1);
		getContentPane().setLayout(groupLayout);
		
		setBounds(200,200,800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		connect();
		comboFood();
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				model.setRowCount(0);
				select();
				
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				insert();
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				jcb1.setSelectedIndex(0);
				
				model.setRowCount(0);
				select();
				
				
			}
		});
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				update();
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				jcb1.setSelectedIndex(0);
				model.setRowCount(0);
				select();
				
			}
		});
		
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result= JOptionPane.showConfirmDialog(null,"정말로 삭제하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.CLOSED_OPTION) {
					JOptionPane.showMessageDialog(null, "취소를 클릭하셨습니다.");
				}else if(result==JOptionPane.YES_OPTION) {
					connect();
					delete();
					jtf1.setText("");
					jtf2.setText("");
					jtf3.setText("");
					jcb1.setSelectedIndex(0);
					jtf1.requestFocus();
					
				}
				
			}
		});
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				jtf1.setText(model.getValueAt(row, 0).toString());
				jtf2.setText(model.getValueAt(row, 1).toString());
				jtf3.setText(model.getValueAt(row, 2).toString());
				jcb1.setSelectedItem(model.getValueAt(row, 3).toString());
				
				
			}
		});
		
		jb5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manage();
				dispose();
				
			}
		});
		
	}

	void connect() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="web";
		String password="1234";
		
		//1. 접속할 오라클 드라이버
		try {
			Class.forName(driver);
			
		// 2. 오라클 데이터 베이스와 연결을 시도.
			con =DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}// connect()메서드 end
	
	void comboFood() {
		
		
		try {
			sql="select distinct(mealtype) from food order by mealtype ";
			pstmt= con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String meal= rs.getString("mealtype");
				jcb1.addItem(meal);
			}
			rs.close();pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void select() {
		
		
		try {
			sql="select*from food order by mealtype, fname";
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int fno = rs.getInt("fno");
				String fname = rs.getString("fname");
				int price = rs.getInt("price");
				String meal= rs.getString("mealtype");
				
				Object[] data= {fno,fname,price,meal};
				model.addRow(data);
			}
			rs.close();pstmt.close();con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void insert() {
		
		
		try {
			sql="insert into food values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(jtf1.getText()));
			pstmt.setString(2,jtf2.getText());
			pstmt.setInt(3, Integer.parseInt(jtf3.getText()));
			pstmt.setString(4,jcb1.getSelectedItem().toString());
			
			int res = pstmt.executeUpdate();
			if(res>0) {
				JOptionPane.showMessageDialog(null, "음식 추가 성공!!");
			} else {
				JOptionPane.showMessageDialog(null, "음식 추가 실패~~");
			}
			
			pstmt.close();		
					}
		catch (SQLException e) {
				
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void update() {
		
		
		try {
			sql= "update food set fname=?,price=?, mealtype=? where fno=?";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, jtf2.getText());
			pstmt.setInt(2, Integer.parseInt(jtf3.getText()));
			pstmt.setString(3, jcb1.getSelectedItem().toString());
			pstmt.setInt(4, Integer.parseInt(jtf1.getText()));
			
			int res=pstmt.executeUpdate();
			
			if(res>0) {
				JOptionPane.showMessageDialog(null, "음식 수정 성공!!!");
			} else {
				JOptionPane.showMessageDialog(null, "음식 수정 실패!!!");
			}
			pstmt.close();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void delete() {
		
		try {
			sql="delete from food where fno=?";
			pstmt=con.prepareStatement(sql);
			int row=table.getSelectedRow();
			
			pstmt.setInt(1, (int)model.getValueAt(row, 0));
			
			int res=pstmt.executeUpdate();
			
			if(res>0) {
				JOptionPane.showMessageDialog(null, "음식 삭제 성공!!!");
			} else {
				JOptionPane.showMessageDialog(null, "음식 삭제 실패!!!");
			}
			model.removeRow(row);
			pstmt.close(); con.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
	new Manage_Foodmenu();
		
	}

}
