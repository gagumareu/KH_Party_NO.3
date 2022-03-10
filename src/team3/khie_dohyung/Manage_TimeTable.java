package team3.khie_dohyung;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Manage_TimeTable extends JFrame{
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs= null;
	String sql = null;
	DefaultTableModel model;
	JTextField jtf1, jtf2,jtf3,jtf4;
	JTable table;
	
	public Manage_TimeTable () {
		getContentPane().setBackground(SystemColor.info);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\git\\KH_PartyNo3\\images\\제목 없음2.jpg"));
		setTitle("시간 메뉴 테이블");
		
		JPanel container1 = new JPanel();
		container1.setBackground(SystemColor.info);
		JPanel container2 = new JPanel();
		container2.setBackground(SystemColor.info);
		
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
		JButton jb1= new JButton("요금 목록");
		jb1.setBackground(Color.CYAN);
		JButton jb2= new JButton("요금 추가");
		jb2.setBackground(Color.CYAN);
		JButton jb3= new JButton("요금 수정");
		jb3.setBackground(Color.CYAN);
		JButton jb4= new JButton("요금 삭제");
		jb4.setBackground(Color.CYAN);
		JButton jb5= new JButton("돌아가기");
		jb5.setBackground(Color.CYAN);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\git\\KH_PartyNo3\\images\\smenu.png"));
		GroupLayout gl_container1 = new GroupLayout(container1);
		gl_container1.setHorizontalGroup(
			gl_container1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container1.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_container1.createSequentialGroup()
							.addComponent(jl1)
							.addGap(5)
							.addComponent(jtf1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_container1.createSequentialGroup()
							.addComponent(jl3)
							.addGap(5)
							.addComponent(jtf3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(126))
				.addGroup(gl_container1.createSequentialGroup()
					.addContainerGap()
					.addComponent(jl2)
					.addGap(5)
					.addComponent(jtf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(jl4)
					.addGap(5)
					.addComponent(jtf4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_container1.setVerticalGroup(
			gl_container1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_container1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addGroup(gl_container1.createSequentialGroup()
							.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_container1.createSequentialGroup()
									.addGap(8)
									.addComponent(jl1))
								.addGroup(gl_container1.createSequentialGroup()
									.addGap(5)
									.addComponent(jtf1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_container1.createSequentialGroup()
									.addGap(3)
									.addComponent(jl3))
								.addComponent(jtf3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(26)
					.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_container1.createSequentialGroup()
							.addGap(3)
							.addComponent(jl4))
						.addComponent(jtf4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_container1.createSequentialGroup()
							.addGap(3)
							.addComponent(jl2))
						.addComponent(jtf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		container1.setLayout(gl_container1);
		GroupLayout gl_container2 = new GroupLayout(container2);
		gl_container2.setHorizontalGroup(
			gl_container2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_container2.createParallelGroup(Alignment.LEADING)
						.addComponent(jb1, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
						.addComponent(jb2, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
						.addComponent(jb3, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
						.addComponent(jb4, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
						.addComponent(jb5, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
					.addGap(14))
		);
		gl_container2.setVerticalGroup(
			gl_container2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container2.createSequentialGroup()
					.addContainerGap()
					.addComponent(jb1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jb2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jb3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jb4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jb5)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		container2.setLayout(gl_container2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\git\\KH_PartyNo3\\images\\제목 없음2.jpg"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(container2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel)
							.addGap(28)
							.addComponent(container1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(jsp, GroupLayout.PREFERRED_SIZE, 783, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(container1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(container2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jsp, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		setBounds(200,200,800,800);
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
				String type = rs.getString("type");
				
				Object[] data = {tho,tname,tprice,type};
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
			sql="update timeTable set tname=?,tprice=?,type=? where hours=?";
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
