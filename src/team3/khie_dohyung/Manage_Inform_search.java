package team3.khie_dohyung;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Manage_Inform_search extends JFrame {
	Connection con= null;
	
	PreparedStatement pstmt= null;
	ResultSet rs =null;
	String sql = null;
	DefaultTableModel model;

	JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6, jtf7, jtf8;
	JTable table;	
	
	public Manage_Inform_search() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\git\\KH_PartyNo3\\images\\제목 없음2.jpg"));
		setTitle("회원 정보 테이블");
		JPanel container2 = new JPanel();
		container2.setBackground(SystemColor.info);
		JPanel container3 = new JPanel();
		container3.setBackground(SystemColor.info);
		JLabel jl6 = new JLabel("주소:");
		jtf6 = new JTextField(30);
		
		String [] header= {"회원아이디","패스워드","회원번호","이름","전화번호","주소","패스워드 정답","마일리지"};
		
		model = new DefaultTableModel(header, 0);
		
		table = new JTable(model);
		
		JScrollPane jsp = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton jb1 = new JButton("회원 목록");
		jb1.setBackground(Color.CYAN);
		JButton jb2 = new JButton("회원 추가");
		jb2.setBackground(Color.CYAN);
		JButton jb3 = new JButton("회원 수정");
		jb3.setBackground(Color.CYAN);
		JButton jb4 = new JButton("회원 삭제");
		jb4.setBackground(Color.CYAN);
		JButton jb5 = new JButton("돌아 가기");
		jb5.setBackground(Color.CYAN);
		
		JPanel group = new JPanel();
		group.setBackground(SystemColor.info);
		getContentPane().add(group,BorderLayout.CENTER);
		jtf5= new JTextField(15);
		JLabel jl5 = new JLabel("전화번호:");
		GroupLayout gl_container2 = new GroupLayout(container2);
		gl_container2.setHorizontalGroup(
			gl_container2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container2.createSequentialGroup()
					.addGroup(gl_container2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_container2.createSequentialGroup()
							.addGap(22)
							.addComponent(jl5)
							.addGap(35)
							.addComponent(jtf5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_container2.createSequentialGroup()
							.addGap(46)
							.addComponent(jl6)
							.addGap(35)
							.addComponent(jtf6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		gl_container2.setVerticalGroup(
			gl_container2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_container2.createSequentialGroup()
					.addGroup(gl_container2.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtf5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jl5))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_container2.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtf6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jl6))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		container2.setLayout(gl_container2);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		JPanel container1 = new JPanel();
		container1.setBackground(SystemColor.info);
		
		
		JLabel jl1 = new JLabel("회원아이디:");
		jtf1= new JTextField(10);
		JLabel jl2 = new JLabel("패스워드:");
		jtf2=new JTextField(10);
		JLabel jl3 = new JLabel("회원번호:");
		jtf3= new JTextField(10);
		JLabel jl4 = new JLabel("이름:");
		jtf4= new JTextField(10);
		GroupLayout gl_container1 = new GroupLayout(container1);
		gl_container1.setHorizontalGroup(
			gl_container1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_container1.createParallelGroup(Alignment.TRAILING)
						.addComponent(jtf3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_container1.createSequentialGroup()
							.addGroup(gl_container1.createParallelGroup(Alignment.TRAILING)
								.addComponent(jl2)
								.addComponent(jl1)
								.addComponent(jl3)
								.addComponent(jl4))
							.addGap(33)
							.addGroup(gl_container1.createParallelGroup(Alignment.TRAILING)
								.addComponent(jtf1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtf4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(125, Short.MAX_VALUE))
		);
		gl_container1.setVerticalGroup(
			gl_container1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_container1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_container1.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtf1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jl1))
					.addGap(18)
					.addGroup(gl_container1.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jl2))
					.addGap(18)
					.addGroup(gl_container1.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtf3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jl3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_container1.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtf4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jl4))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		container1.setLayout(gl_container1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\git\\KH_PartyNo3\\images\\제목 없음2.jpg"));
		GroupLayout gl_group = new GroupLayout(group);
		gl_group.setHorizontalGroup(
			gl_group.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_group.createSequentialGroup()
					.addGroup(gl_group.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_group.createSequentialGroup()
							.addContainerGap()
							.addComponent(container3, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_group.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_group.createSequentialGroup()
									.addComponent(container1, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
								.addComponent(container2, 0, 0, Short.MAX_VALUE)))
						.addComponent(jsp, GroupLayout.PREFERRED_SIZE, 796, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_group.setVerticalGroup(
			gl_group.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_group.createSequentialGroup()
					.addGroup(gl_group.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_group.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_group.createParallelGroup(Alignment.LEADING)
								.addComponent(container3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_group.createSequentialGroup()
									.addGroup(gl_group.createParallelGroup(Alignment.LEADING)
										.addComponent(container1, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
										.addComponent(panel, Alignment.TRAILING, 0, 0, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(container2, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_group.createSequentialGroup()
							.addGap(62)
							.addComponent(lblNewLabel_1)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jsp, GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
		);
		JLabel jl8 = new JLabel("패스워드 정답:");
		jtf8= new JTextField(10);
		JLabel jl7 = new JLabel("마일리지:");
		jtf7= new JTextField(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\git\\KH_PartyNo3\\images\\suser.png"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(jl8)
								.addComponent(jl7))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(jtf7, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtf8, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(77)
							.addComponent(lblNewLabel)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtf8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jl8))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtf7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jl7, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_container3 = new GroupLayout(container3);
		gl_container3.setHorizontalGroup(
			gl_container3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_container3.createParallelGroup(Alignment.LEADING)
						.addComponent(jb1)
						.addComponent(jb2)
						.addComponent(jb3)
						.addComponent(jb4)
						.addComponent(jb5))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_container3.setVerticalGroup(
			gl_container3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container3.createSequentialGroup()
					.addGap(22)
					.addComponent(jb1)
					.addGap(18)
					.addComponent(jb2)
					.addGap(18)
					.addComponent(jb3)
					.addGap(18)
					.addComponent(jb4)
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addComponent(jb5)
					.addGap(27))
		);
		container3.setLayout(gl_container3);
		group.setLayout(gl_group);

	
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
				jtf5.setText("");
				jtf6.setText("");
				jtf7.setText("");
				jtf8.setText("");
				jtf1.requestFocus();
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
				jtf5.setText("");
				jtf6.setText("");
				jtf7.setText("");
				jtf8.setText("");
				jtf1.requestFocus();
				model.setRowCount(0);
				select();
					//DB에서 전체 내역을 조회하는 메서드 호출
			}
		});
		
			jb4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int result=JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
					if(result== JOptionPane.CLOSED_OPTION) {
						JOptionPane.showMessageDialog(null, "취소를 클릭하셨습니다.");
					}else if(result==JOptionPane.YES_OPTION) {
						connect();
						delete();
						
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
					// TODO Auto-generated method stub
					int row=table.getSelectedRow();
					jtf1.setText(model.getValueAt(row, 0).toString());
					jtf2.setText(model.getValueAt(row, 1).toString());
					jtf3.setText(model.getValueAt(row, 2).toString());
					jtf4.setText(model.getValueAt(row, 3).toString());
					jtf5.setText(model.getValueAt(row, 4).toString());
					jtf6.setText(model.getValueAt(row, 5).toString());
					jtf8.setText(model.getValueAt(row, 6).toString());
					jtf7.setText(model.getValueAt(row, 7).toString());
					
					
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
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user="web";
		String password="1234";
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} //connect 엔드
	
	void select() {
		
		try {
			sql="select * from member order by mem_name";
			
		
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String mid=rs.getString("mem_id");
				String mpw=rs.getString("mem_password");
				String mnum=rs.getString("mem_num");
				String mname=rs.getString("mem_name");
				String mphone=rs.getString("mem_contact");
				String maddr=rs.getString("mem_addr");
				String mans=rs.getString("mem_findpwd_ans");
				int mmilleage=rs.getInt("mem_mileage");
				
				Object[] data = {mid,mpw,mnum,mname,mphone,maddr,mans,mmilleage};
				model.addRow(data);

				
			}
			rs.close();pstmt.close();con.close();
		}catch(Exception e) {
			e.printStackTrace();
					
		}
	}
	
	void insert() {
		
		
		try {
			sql = "insert into member values(?,?,mem_seq.nextval,?,?,?,?,?)";
			pstmt= con.prepareStatement(sql);
			
			pstmt.setString(1, jtf1.getText());
			pstmt.setString(2, jtf2.getText());
			pstmt.setString(3, jtf4.getText());
			pstmt.setString(4, jtf5.getText());
			pstmt.setString(5, jtf6.getText());
			pstmt.setString(6, jtf8.getText());
			pstmt.setInt(7, Integer.parseInt(jtf7.getText()));
			
			int res=pstmt.executeUpdate();
			
			if(res>0) {
				JOptionPane.showMessageDialog(null, "회원 추가 성공");
			} else {
				JOptionPane.showMessageDialog(null, "회원 추가 실패");
				
			}
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void update() {
		// 1. 데이터베이스 전송할 SQL문 작성
		
		
		try {
			sql="update member set  mem_id=? , mem_password=?,mem_name=? , mem_contact=?,mem_addr=?,  mem_findpwd_ans=? ,mem_mileage=?  where mem_num=? ";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, jtf1.getText());
			pstmt.setString(2, jtf2.getText());
			pstmt.setString(3, jtf4.getText());
			pstmt.setString(4, jtf5.getText());
			pstmt.setString(5, jtf6.getText());
			pstmt.setString(6, jtf8.getText());
			pstmt.setInt(7, Integer.parseInt(jtf7.getText()));
			pstmt.setInt(8, Integer.parseInt(jtf3.getText()));
			
			// 2. 오라클 데이터베이스에 SQL문 전송 및 SQL문 실행
			int res=pstmt.executeUpdate();
			if(res>0) {
				JOptionPane.showMessageDialog(null, "회원정보수정 성공!!!");
			} else {
				JOptionPane.showMessageDialog(null, "회원정보수정 실패~~~");
			}
			pstmt.close(); 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void delete() {
		//1. 오라클 데이터베이스에 전송할 SQL문 작성
		
		
		try {
			sql="delete from member where mem_num = ?";
			pstmt=con.prepareStatement(sql);
			
			
			int row= table.getSelectedRow();
			
			
			pstmt.setString(1, (String)model.getValueAt(row, 2));
			
			// 2.오라클 데이터베이스에 SQL문 전송 및 SQL문 실행
			int res =pstmt.executeUpdate();
			if(res>0) {
				JOptionPane.showMessageDialog(null, "회원정보삭제 성공!!!");
			} else {
				JOptionPane.showMessageDialog(null, "회원정보삭제 실패~~~");
			}
			model.removeRow(row);		//테이블 상의 한줄 삭제
			
			//3. 오라클 데이터베이스에 연결되어 있던 자원 종료.
			pstmt.close(); con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Manage_Inform_search();

	}

}
