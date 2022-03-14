package team3.khie_dohyung;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Manage_Review extends JFrame{
Connection con = null;
	
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	String sql = null;
	DefaultTableModel model;
	JTextField jtf1,jtf2,jtf3,jtf5;
	JTextArea jtf4;
	JTable table;
	
	public Manage_Review() {
		getContentPane().setBackground(SystemColor.info);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/sreview.png"));
		
		setTitle("회원 리뷰 테이블");
		JPanel container3= new JPanel();
		container3.setBackground(SystemColor.info);
		
	    String header[] = {"책 번호","리뷰 번호","책 이름", "회원 이름", "별점","리뷰"};
	    model = new DefaultTableModel(header,0);
	    
	    table = new JTable(model);
	    
	    JScrollPane jsp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    
	    JButton jb1 = new JButton("리뷰검색");
	    jb1.setBackground(Color.CYAN);
	    JButton jb2 = new JButton("리뷰삽입");
	    jb2.setBackground(Color.CYAN);
	    JButton jb3 = new JButton("리뷰수정");
	    jb3.setBackground(Color.CYAN);
	    JButton jb4 = new JButton("리뷰삭제");
	    jb4.setBackground(Color.CYAN);
	
	    JButton jb5 = new JButton("돌아가기");
	    jb5.setBackground(Color.CYAN);
	    
	    JPanel group = new JPanel(new BorderLayout());
	    
	    JPanel container1= new JPanel();
	    container1.setBackground(SystemColor.info);
	    
	    JLabel jl1= new JLabel("책 번호:");
	    jl1.setBackground(new Color(255, 255, 224));
	    jtf1 = new JTextField(5);
	    
	    JLabel jl5= new JLabel("리뷰 번호:");
	    jl5.setBackground(new Color(255, 255, 224));
	    jtf5 = new JTextField(5);
	    
	    		JLabel jl2= new JLabel("회원 이름:");
	    		jl2.setBackground(new Color(255, 255, 224));
	    		jtf2 = new JTextField(10);
	    		
	    				
	    				JLabel jl3= new JLabel("별점:");
	    				jl3.setBackground(new Color(255, 255, 224));
	    				jtf3 = new JTextField(10);
	    				
	    				JLabel lblNewLabel_1 = new JLabel("");
	    				lblNewLabel_1.setIcon(new ImageIcon("images/sreview.png"));
	    				GroupLayout gl_container1 = new GroupLayout(container1);
	    				gl_container1.setHorizontalGroup(
	    					gl_container1.createParallelGroup(Alignment.LEADING)
	    						.addGroup(gl_container1.createSequentialGroup()
	    							.addGap(10)
	    							.addComponent(jl2)
	    							.addGap(5)
	    							.addComponent(jtf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	    							.addGap(18)
	    							.addComponent(jl3)
	    							.addGap(5)
	    							.addComponent(jtf3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	    							.addContainerGap(15, Short.MAX_VALUE))
	    						.addGroup(gl_container1.createSequentialGroup()
	    							.addContainerGap()
	    							.addGroup(gl_container1.createParallelGroup(Alignment.TRAILING)
	    								.addGroup(gl_container1.createSequentialGroup()
	    									.addComponent(jl5)
	    									.addGap(5)
	    									.addComponent(jtf5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    								.addGroup(gl_container1.createSequentialGroup()
	    									.addComponent(jl1)
	    									.addPreferredGap(ComponentPlacement.RELATED)
	    									.addComponent(jtf1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	    							.addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
	    							.addComponent(lblNewLabel_1)
	    							.addGap(81))
	    				);
	    				gl_container1.setVerticalGroup(
	    					gl_container1.createParallelGroup(Alignment.LEADING)
	    						.addGroup(gl_container1.createSequentialGroup()
	    							.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
	    								.addGroup(gl_container1.createSequentialGroup()
	    									.addGap(24)
	    									.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
	    										.addGroup(Alignment.TRAILING, gl_container1.createParallelGroup(Alignment.LEADING)
	    											.addGroup(gl_container1.createSequentialGroup()
	    												.addGap(3)
	    												.addComponent(jl5))
	    											.addComponent(jtf5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    										.addComponent(lblNewLabel_1))
	    									.addGap(31)
	    									.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
	    										.addComponent(jtf3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	    										.addGroup(gl_container1.createParallelGroup(Alignment.TRAILING)
	    											.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
	    												.addGroup(gl_container1.createSequentialGroup()
	    													.addGap(3)
	    													.addComponent(jl2))
	    												.addComponent(jtf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    											.addComponent(jl3))))
	    								.addGroup(gl_container1.createSequentialGroup()
	    									.addContainerGap()
	    									.addGroup(gl_container1.createParallelGroup(Alignment.BASELINE)
	    										.addComponent(jl1)
	    										.addComponent(jtf1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
	    							.addContainerGap(23, Short.MAX_VALUE))
	    				);
	    				container1.setLayout(gl_container1);
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(SystemColor.info);
	    
	    JLabel lblNewLabel = new JLabel("");
	    lblNewLabel.setIcon(new ImageIcon("images/제목 없음2.jpg"));
	    GroupLayout groupLayout = new GroupLayout(getContentPane());
	    groupLayout.setHorizontalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
	    				.addComponent(group, GroupLayout.PREFERRED_SIZE, 784, GroupLayout.PREFERRED_SIZE)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addContainerGap()
	    					.addComponent(container3, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
	    					.addGap(56)
	    					.addComponent(lblNewLabel)
	    					.addGap(74)
	    					.addComponent(container1, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE))
	    				.addComponent(jsp, GroupLayout.PREFERRED_SIZE, 784, GroupLayout.PREFERRED_SIZE)
	    				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
	    					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 733, GroupLayout.PREFERRED_SIZE)
	    					.addGap(24)))
	    			.addContainerGap())
	    );
	    groupLayout.setVerticalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addComponent(group, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	    			.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    						.addGroup(groupLayout.createSequentialGroup()
	    							.addGap(42)
	    							.addComponent(lblNewLabel))
	    						.addGroup(groupLayout.createSequentialGroup()
	    							.addPreferredGap(ComponentPlacement.RELATED)
	    							.addComponent(container3, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
	    					.addPreferredGap(ComponentPlacement.RELATED))
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addComponent(container1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
	    					.addGap(27)))
	    			.addPreferredGap(ComponentPlacement.RELATED)
	    			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
	    			.addPreferredGap(ComponentPlacement.UNRELATED)
	    			.addComponent(jsp, GroupLayout.PREFERRED_SIZE, 593, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	    );
	    jtf4 = new JTextArea(5,60);
	    
	    JLabel jl4= new JLabel("리뷰:");
	    GroupLayout gl_panel = new GroupLayout(panel);
	    gl_panel.setHorizontalGroup(
	    	gl_panel.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_panel.createSequentialGroup()
	    			.addContainerGap()
	    			.addComponent(jl4)
	    			.addGap(18)
	    			.addComponent(jtf4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap(415, Short.MAX_VALUE))
	    );
	    gl_panel.setVerticalGroup(
	    	gl_panel.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_panel.createSequentialGroup()
	    			.addContainerGap()
	    			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(jtf4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(jl4))
	    			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
	    			.addContainerGap(648, Short.MAX_VALUE))
	    );
	    gl_container3.setVerticalGroup(
	    	gl_container3.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_container3.createSequentialGroup()
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
	    			.addContainerGap(19, Short.MAX_VALUE))
	    );
	    container3.setLayout(gl_container3);
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
				jtf5.setText("");
				
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
				
				jtf1.requestFocus();
				model.setRowCount(0);
				select();
				
			}
		});
	    
	    jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result= JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
				if(result== JOptionPane.CLOSED_OPTION) {
					JOptionPane.showMessageDialog(null, "취소를 클릭하셨습니다.");
				}else if(result==JOptionPane.YES_OPTION) {
					connect();
					delete();
					jtf1.setText("");
					jtf2.setText("");
					jtf3.setText("");
					jtf4.setText("");
					jtf5.setText("");
					
		
					
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
				jtf5.setText(model.getValueAt(row, 1).toString());
				jtf2.setText(model.getValueAt(row, 3).toString());
				jtf3.setText(model.getValueAt(row, 4).toString());
				jtf4.setText(model.getValueAt(row, 5).toString());
				
				
			}
		});
	    
	    
	    
	    
		
		
	}
	
	void connect(){
		String driver ="oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user="web";
		String password="1234";
		
		try {
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,user,password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void select() {
		
		
		try {
			sql= "select b.bnumber,reviewnum,rname,bname,starsum,review\r\n" + 
					"from review r join books b\r\n" + 
					"on r.bnumber=b.bnumber";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int bnum=rs.getInt("bnumber");
				int rnum=rs.getInt("reviewnum");
				String bname = rs.getString("bname");
				String rname = rs.getString("rname");
				int star=rs.getInt("starsum");
				String review = rs.getString("review");
				
				Object[] data= {bnum,rnum,bname,rname,star,review};
				model.addRow(data);
				
				
			}
			rs.close();pstmt.close();rs.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	void insert() {
		
		try {
			sql="insert into review values(?,reviewnum_seq.nextval,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(jtf1.getText()));
			pstmt.setString(2, jtf2.getText());
			pstmt.setString(3, jtf4.getText());
			pstmt.setInt(4, Integer.parseInt(jtf3.getText()));
			
			int res= pstmt.executeUpdate();
			if(res>0) {
				JOptionPane.showMessageDialog(null,"리뷰 추가 성공");
			}else {
				JOptionPane.showMessageDialog(null, "리뷰 추가 실패");
			}
			pstmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void update() {
		
		
		try {
			sql="update review set rname=?,starsum=?,review=? where reviewnum=?";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, jtf2.getText());
			pstmt.setInt(2, Integer.parseInt(jtf3.getText()));
			pstmt.setString(3, jtf4.getText());
			pstmt.setInt(4, Integer.parseInt(jtf5.getText()));
			
			int res=pstmt.executeUpdate();
			
			if(res>0) {
				JOptionPane.showMessageDialog(null, "리뷰 수정 성공!!");
			} else {
				JOptionPane.showMessageDialog(null, "리뷰 수정 실패!!");
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
			sql="delete from review where reviewnum = ?";
			pstmt=con.prepareStatement(sql);
			
			
			int row= table.getSelectedRow();
			
			
			pstmt.setInt(1, (int)model.getValueAt(row, 1));
			
			// 2.오라클 데이터베이스에 SQL문 전송 및 SQL문 실행
			int res =pstmt.executeUpdate();
			if(res>0) {
				JOptionPane.showMessageDialog(null, "리뷰삭제 성공!!!");
			} else {
				JOptionPane.showMessageDialog(null, "리뷰삭제 실패~~~");
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
		
		new Manage_Review();
		

	}
}
