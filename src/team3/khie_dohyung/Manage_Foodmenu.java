package team3.khie_dohyung;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
		setTitle("음식 메뉴 테이블");
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		
		JLabel jl1 = new JLabel("음식번호");
		jtf1= new JTextField(10);
		
		JLabel jl2 = new JLabel("음식이름");
		jtf2= new JTextField(10);
		
		JLabel jl3 = new JLabel("금액");
		jtf3= new JTextField(10);
		
		JLabel jl4 = new JLabel("음식분류");
		jcb1= new JComboBox<String>();
		
		jcb1.addItem("선택");
		
		String[] header={"음식번호","음식이름","금액","음식분류"};
		
		model = new DefaultTableModel(header,0);
		
		table = new JTable(model);
		
		JScrollPane jsp= new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton jb1= new JButton("음식 목록");
		JButton jb2= new JButton("음식 추가");
		JButton jb3= new JButton("음식 수정");
		JButton jb4= new JButton("음식 삭제");
		JButton jb5= new JButton("돌아 가기");
		
		container1.add(jl1);container1.add(jtf1);
		container1.add(jl2);container1.add(jtf2);
		container1.add(jl3);container1.add(jtf3);
		container1.add(jl4);container1.add(jcb1);
		
		container2.add(jb1);
		container2.add(jb2);
		container2.add(jb3);
		container2.add(jb4);
		container2.add(jb5);
		
		add(container1,BorderLayout.NORTH);
		add(jsp,BorderLayout.CENTER);
		add(container2,BorderLayout.SOUTH);
		
		setBounds(200,200,700,250);
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
