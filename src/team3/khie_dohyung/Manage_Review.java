package src.team3.khie_dohyung;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
		
		setTitle("회원 리뷰 테이블");
		
		JPanel container1= new JPanel();
		JPanel container2= new JPanel();
		JPanel container3= new JPanel();
		
		JLabel jl1= new JLabel("책 번호");
		jtf1 = new JTextField(5);
		
		JLabel jl5= new JLabel("리뷰 번호");
		jtf5 = new JTextField(5);

		JLabel jl2= new JLabel("회원 이름");
		jtf2 = new JTextField(10);

		
		JLabel jl3= new JLabel("별점");
		jtf3 = new JTextField(10);
		
		JLabel jl4= new JLabel("리뷰");
		jtf4 = new JTextArea(5,45);
		
	    String header[] = {"책 번호","리뷰 번호","책 이름", "회원 이름", "별점","리뷰"};
	    model = new DefaultTableModel(header,0);
	    
	    table = new JTable(model);
	    
	    JScrollPane jsp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    
	    JButton jb1 = new JButton("리뷰 검색");
	    JButton jb2 = new JButton("리뷰 삽입");
	    JButton jb3 = new JButton("리뷰 수정");
	    JButton jb4 = new JButton("리뷰 삭제");
	
	    JButton jb5 = new JButton("돌아가기");
	    
	    container1.add(jl1); container1.add(jtf1);
	    container1.add(jl5); container1.add(jtf5);
	    container1.add(jl2); container1.add(jtf2);
	    container1.add(jl3); container1.add(jtf3);
	    
	    
	    container2.add(jl4); container2.add(jtf4);
	    
	    container3.add(jb1);container3.add(jb2);
	    container3.add(jb3);container3.add(jb4);
	    container3.add(jb5);
	    
	    JPanel group = new JPanel(new BorderLayout());
	    
	    group.add(container1,BorderLayout.NORTH);
	    group.add(container2,BorderLayout.CENTER);

	    
	    add(group, BorderLayout.NORTH);
	    add(jsp, BorderLayout.CENTER);
	    add(container3, BorderLayout.SOUTH);
	    
	    setBounds(200,200,600,400);
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
