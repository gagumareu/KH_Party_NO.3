package team3.booktable;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class starmake extends JFrame{
	Connection con = null; // DB와 연결하는 객체
	PreparedStatement pstmt = null; // sql문을 db에 전송하는 객체
	ResultSet rs = null; // sql문 실행 결과를 가지고 있는 객체
	String sql = null; // sql문을 저장하는 문자열 변수.
	
	int star=0;
	
	public starmake() {	}
	public void starmake(String bname) {
		
		setTitle("별점 부여");
		
		

		JLabel jtf = new JLabel("도서명 :  " + bname);
		JLabel jtf2 = new JLabel("별 점");
		
		JRadioButton jrb1 = new JRadioButton("1");
		JRadioButton jrb2 = new JRadioButton("2");
		JRadioButton jrb3 = new JRadioButton("3");
		JRadioButton jrb4 = new JRadioButton("4");
		JRadioButton jrb5 = new JRadioButton("5");
		ButtonGroup bg = new ButtonGroup();
		
		JButton jb1 = new JButton("등록");
		JButton jb2 = new JButton("취소");
		
		JPanel jp1 = new JPanel(new FlowLayout());
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel gr = new JPanel(new BorderLayout());
		JPanel jp4 = new JPanel(new FlowLayout());
		
		jp1.add(jtf);
		jp4.add(jtf2);
		jp4.add(jtf2);
		jp2.add(jrb1);
		jp2.add(jrb2);
		jp2.add(jrb3);
		jp2.add(jrb4);
		jp2.add(jrb5);
		jp3.add(jb1);
		jp3.add(jb2);
		gr.add(jp1, BorderLayout.NORTH);
		gr.add(jp4, BorderLayout.SOUTH);
		
		
		add(gr, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.SOUTH);
		
		jrb5.setSelected(true);

		setSize(250, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jrb1.isSelected()) {
					star = 1;
				} else if (jrb2.isSelected()) {
					star = 2;
				} else if (jrb3.isSelected()) {
					star = 3;
				} else if (jrb4.isSelected()) {
					star = 4;
				} else if (jrb5.isSelected()) {
					star = 5;
				}
				;
				
				
				connect();
				
				starsum(bnumber(bname));
				
				setVisible(false);
				
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			
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
	
	void starsum(int bnumber) {
	
		try {
			sql="insert into review values (?,null,null,null,null,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			pstmt.setInt(2, star);
			int res=pstmt.executeUpdate();
			
			if(res>0) {
				JOptionPane.showMessageDialog(null, "등록 성공!");
				pstmt.close();
				reviewsum(bnumber);
				staravg(bnumber);
			}else {
				JOptionPane.showMessageDialog(null, "등록 실패");
			}
			
			pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	//-------------책이름 > 책번호 메서드---------------
	int bnumber(String bname) {
		int bnumber = 0;
		try {
			sql = "select bnumber from books where bname = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bname);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bnumber = rs.getInt("bnumber");
			}
			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bnumber;

	}
	
	// 특정 책의 별점합을 구하는 메서드
	int stars(int bnumber) {
		int num = bnumber;
		int star = 0;

		try {
			sql = "select sum(starsum) from review where bnumber=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs2 = pstmt.executeQuery();

			while (rs2.next()) {
				star = rs2.getInt("sum(starsum)");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return star;

	}
	
	void staravg(int bnumber) {
		
		double staravg = (double)stars(bnumber)/(reviews(bnumber));
		System.out.println(staravg);
		System.out.println(reviews(bnumber));
		
		try {
			sql="update books set bstaravg = ? where bnumber=? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setDouble(1, staravg);
			pstmt.setInt(2, bnumber);
			
			int res = pstmt.executeUpdate();
			
			if(res>0) {
				System.out.println("리뷰수 더하기 성공");
			}else {
				System.out.println("리뷰수 더하기 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	// 특정 책의 리뷰 수를 불러오는 메서드
	int reviews(int bnumber) {
		int review = 0;

		try {
			sql = "select count(*) from review where bnumber=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			ResultSet rs1 = pstmt.executeQuery();

			while (rs1.next()) {
				review = rs1.getInt("count(*)");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return review;
	}
	
	void reviewsum(int bnumber) {
		
		
		
		int breviewsum = reviews(bnumber);
		System.out.println(breviewsum);
		System.out.println(reviews(bnumber));
		
	
		try {
			sql="update books set breviewsum = ? where bnumber=? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, breviewsum);
			pstmt.setInt(2, bnumber);
			
			int res = pstmt.executeUpdate();
			
			if(res>0) {
				System.out.println("리뷰수 더하기 성공");
			}else {
				System.out.println("리뷰수 더하기 실패");
			}
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	public static void main(String[] args) {
		starmake sm = new starmake();
		sm.starmake("더 파이팅");

	}

}