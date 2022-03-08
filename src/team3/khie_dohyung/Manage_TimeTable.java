package src.team3.khie_dohyung;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Manage_TimeTable extends JFrame{
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs= null;
	String sql = null;
	DefaultTableModel model;
	JTextField jtf1, jtf2,jtf3,jtf4;
	JTable table;
	
	public Manage_TimeTable () {
		setTitle("시간 메뉴 테이블");
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		
		JLabel jl1 = new JLabel("시간:");
		jtf1= new JTextField(5);
		
		JLabel jl2 = new JLabel("시간제이름:");
		jtf2= new JTextField(15);
		
		JLabel jl3 = new JLabel("금액:");
		jtf3= new JTextField(10);
		
		JLabel jl4 = new JLabel("패키지종류:");
		jtf4= new JTextField(10);
		
		String[] header= {"시간","시간제이름","금액","패키지종류"};
		
		model = new DefaultTableModel(header,0);
		table = new JTable(model);
		
		JScrollPane jsp = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JButton jb1= new JButton("시간제 목록");
		JButton jb2= new JButton("시간제 추가");
		JButton jb3= new JButton("시간제 수정");
		JButton jb4= new JButton("시간제 삭제");
		JButton jb5= new JButton("돌아가기");
		
		container1.add(jl1);container1.add(jtf1);
		container1.add(jl2);container1.add(jtf2);
		container1.add(jl3);container1.add(jtf3);
		container1.add(jl4);container1.add(jtf4);
		
		container2.add(jb1);
		container2.add(jb2);
		container2.add(jb3);
		container2.add(jb4);
		container2.add(jb5);
		add(container1,BorderLayout.NORTH);
		add(jsp,BorderLayout.CENTER);
		add(container2,BorderLayout.SOUTH);
		
		setBounds(200,200,750,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
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
				jtf4.setText("");
				
				
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
				jtf4.setText("");
				
				
				model.setRowCount(0);
				select();
				
			}
		});
		
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.CLOSED_OPTION) {
					JOptionPane.showMessageDialog(null, "취소를 클릭하셨습니다.");
				}else if(result==JOptionPane.YES_OPTION) {
					connect();
					delete();
					jtf1.setText("");
					jtf2.setText("");
					jtf3.setText("");
					jtf4.setText("");
					
					jtf1.requestFocus();
				}
				
				
				
			}
		});
		
		jb5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manage();
				dispose();
				
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
				jtf4.setText(model.getValueAt(row, 3).toString());
				
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

	void select() {
		
		
		try {
			sql = "select * from timeTable";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int tho= rs.getInt("hours");
				String tname= rs.getString("tname");
				int tprice= rs.getInt("tprice");
				String packag = rs.getString("package");
				
				Object[] data = {tho,tname,tprice,packag};
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
			sql = "insert into timeTable values(?,?,?,?)";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(jtf1.getText()));
			pstmt.setString(2, jtf2.getText());
			pstmt.setInt(3, Integer.parseInt(jtf3.getText()));
			pstmt.setString(4, jtf4.getText());
			
			int res = pstmt.executeUpdate();
			
			if(res>0) {
				JOptionPane.showMessageDialog(null, "시간제 추가 성공!!!");
			} else {
				JOptionPane.showMessageDialog(null, "시간제 추가 실패~~");
			}
			
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	void update() {
		
		
		try {
			sql="update timeTable set tname=?,tprice=?,package=? where hours=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, jtf2.getText());
			pstmt.setInt(2, Integer.parseInt(jtf3.getText()));
			pstmt.setString(3, jtf4.getText());
			pstmt.setInt(4, Integer.parseInt(jtf1.getText()));
			
			int res = pstmt.executeUpdate();
			
			if(res>0) {
				JOptionPane.showMessageDialog(null, "시간제 수정 성공!!!");
			} else {
				JOptionPane.showMessageDialog(null, "시간제 수정 실패~~");
			}
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void delete() {
		
		
		try {
			sql="delete from timeTable where hours=?";
			pstmt=con.prepareStatement(sql);
			
			int row=table.getSelectedRow();
			pstmt.setInt(1, (int)model.getValueAt(row, 0));
			
			int res=pstmt.executeUpdate();
			
			if(res>0) {
				JOptionPane.showMessageDialog(null, "시간제 삭제 성공!!!");
			}else {
				JOptionPane.showMessageDialog(null, "시간제 삭제 실패~~");

			}
			model.removeRow(row);
			pstmt.close();con.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		new Manage_TimeTable();
		
		
		

	}

}