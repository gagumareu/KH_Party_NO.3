package team3.booktable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import sun.net.www.content.image.jpeg;

public class reviewcorrection extends JFrame{
	Connection con = null; // DB와 연결하는 객체
	PreparedStatement pstmt = null; // sql문을 db에 전송하는 객체
	ResultSet rs = null; // sql문 실행 결과를 가지고 있는 객체
	String sql = null; // sql문을 저장하는 문자열 변수.

	JTextArea jta2;
	String rccom=null;
	int star;
	public reviewcorrection() {}
	
	public void reviewcorrection(String review, int no1) {
		
		
		setTitle("리뷰 수정");
		jta2 = new JTextArea(20,20);
		JScrollPane jsp = new JScrollPane(jta2, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jta2.setLineWrap(true);   
		jta2.setText(review);
		JButton jb4 = new JButton("수정 완료");
		JButton jb5 = new JButton("취소");
		JRadioButton jrb1 = new JRadioButton("1");
		JRadioButton jrb2 = new JRadioButton("2");
		JRadioButton jrb3 = new JRadioButton("3");
		JRadioButton jrb4 = new JRadioButton("4");
		JRadioButton jrb5 = new JRadioButton("5");
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		bg.add(jrb4);
		bg.add(jrb5);
		JLabel jl5 = new JLabel("별점");
		
		JPanel jb = new JPanel(new BorderLayout());
		JPanel jb1 = new JPanel();
		JPanel jl5p = new JPanel();
		jl5p.add(jl5);
		
		JPanel bg1 = new JPanel();
		bg1.add(jrb1);
		bg1.add(jrb2);
		bg1.add(jrb3);
		bg1.add(jrb4);
		bg1.add(jrb5);
		
		jb1.add(jb4);
		jb1.add(jb5);
		jb.add(bg1, BorderLayout.NORTH);
		jb.add(jb1, BorderLayout.SOUTH);
		
		JPanel jb2 = new JPanel(new BorderLayout());
		
		jb2.add(bg1, BorderLayout.CENTER);
		jb2.add(jb, BorderLayout.SOUTH);
		add(jsp, BorderLayout.NORTH);
		add(jl5p);
		add(jb2, BorderLayout.SOUTH);
		
		
		if (starco(no1)==1) {
			jrb1.setSelected(true);
		}else if(starco(no1)==2) {
			jrb2.setSelected(true);
		}else if(starco(no1)==3) {
			jrb3.setSelected(true);
		}else if(starco(no1)==4) {
			jrb4.setSelected(true);
		}else if(starco(no1)==5) {
			jrb5.setSelected(true);
		};
		
		
		setSize(400,450);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jrb1.isSelected()) {
					star = 1;
				}else if(jrb2.isSelected()) {
					star = 2;
				}else if(jrb3.isSelected()) {
					star = 3;
				}else if(jrb4.isSelected()) {
					star = 4;
				}else if(jrb5.isSelected()) {
					star = 5;
				};
				
				
				
				rccom = jta2.getText();
				JOptionPane.showMessageDialog(null, "수정 완료!");
				setVisible(false);
				connect();
				reviewupdate(rccom ,no1);
				connect();
				starupdate(star,no1);
				
				
			}
		});
		
		
		jb5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				
			}
		});
		

	}
	
	void connect() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "web";
		String password = "1234";

		// 1. 접속할 오라클 데이터베이스 드라이버를 메모리에 올리자. - 동적작업
		try {
			Class.forName(driver);

			// 2. 오라클 데이터 베이스와 연결을 시도하자.
			con = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void reviewupdate(String rccom , int no1){
		
		
		try {
			sql="update review set review = ? where reviewnum = ?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, rccom);
			pstmt.setInt(2, no1);
			int res=pstmt.executeUpdate();
			if(res>0) {
			}else {
			}
			con.close(); pstmt.close(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	void starupdate(int star, int no1){
		
		
		try {
			sql="update review set starsum = ? where reviewnum = ?";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, star);
			pstmt.setInt(2, no1);
			int res=pstmt.executeUpdate();
			if(res>0) {
			}else {
			}
			con.close(); pstmt.close(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	int starco(int no1) {
		connect();
		int star=0;
		try {
			sql = "select starsum from review where reviewnum = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no1);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				star = rs.getInt("starsum");
			}
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return star;
		
	}
	
		
	    
	

	public static void main(String[] args) {
		reviewcorrection rc = new reviewcorrection();
		rc.reviewcorrection("수정 전 리뷰",1);

	}

}
