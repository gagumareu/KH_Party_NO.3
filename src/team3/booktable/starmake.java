package team3.booktable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class starmake extends JFrame {
	
	Connection con = null; // DB와 연결하는 객체
	PreparedStatement pstmt = null; // sql문을 db에 전송하는 객체
	ResultSet rs = null; // sql문 실행 결과를 가지고 있는 객체
	String sql = null; // sql문을 저장하는 문자열 변수.

	private JPanel contentPane;
	int star = 5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					starmake frame = new starmake("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public starmake(String bname) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jtf = new JLabel("도서 명 : ");
		jtf.setFont(new Font("굴림", Font.BOLD, 14));
		jtf.setBounds(94, 10, 257, 29);
		jtf.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(jtf);
		
		JButton st1 = new JButton("");
		st1.setForeground(UIManager.getColor("text"));
		st1.setBackground(UIManager.getColor("menu"));
		st1.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
		st1.setBounds(91, 77, 41, 36);
		st1.setFocusPainted(false);
		st1.setBorderPainted(false);;
		
		contentPane.add(st1);
		
		JButton st2 = new JButton("");
		st2.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
		st2.setForeground(Color.WHITE);
		st2.setFocusPainted(false);
		st2.setBorderPainted(false);
		st2.setBackground(SystemColor.menu);
		st2.setBounds(144, 77, 41, 36);
		contentPane.add(st2);
		
		JButton st3 = new JButton("");
		st3.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
		st3.setForeground(Color.WHITE);
		st3.setFocusPainted(false);
		st3.setBorderPainted(false);
		st3.setBackground(SystemColor.menu);
		st3.setBounds(197, 77, 41, 36);
		contentPane.add(st3);
		
		JButton st4 = new JButton("");
		st4.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
		st4.setForeground(Color.WHITE);
		st4.setFocusPainted(false);
		st4.setBorderPainted(false);
		st4.setBackground(SystemColor.menu);
		st4.setBounds(250, 77, 41, 36);
		contentPane.add(st4);
		
		JButton st5 = new JButton("");
		st5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		st5.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
		st5.setForeground(Color.WHITE);
		st5.setFocusPainted(false);
		st5.setBorderPainted(false);
		st5.setBackground(SystemColor.menu);
		st5.setBounds(303, 77, 41, 36);
		contentPane.add(st5);
		
		JLabel jtl2 = new JLabel(" (5점)    최고 에요!");
		jtl2.setBounds(94, 133, 246, 29);

		jtl2.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(jtl2);
		
		JButton jb1 = new JButton("확 인");
		jb1.setBounds(88, 204, 97, 36);
		contentPane.add(jb1);
		
		JButton jb2 = new JButton("취 소");
		jb2.setBounds(247, 204, 97, 36);
		contentPane.add(jb2);
		
		st1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				star = 1;
				jtl2.setText(" (1점)    별로 에요");
				st1.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
				st2.setIcon(new ImageIcon("team3/booktable/img/회색 별.jpg"));
				st3.setIcon(new ImageIcon("team3/booktable/img/회색 별.jpg"));
				st4.setIcon(new ImageIcon("team3/booktable/img/회색 별.jpg"));
				st5.setIcon(new ImageIcon("team3/booktable/img/회색 별.jpg"));
				
			}
		});
		st2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				star = 2;
				jtl2.setText(" (2점)    그냥 그래요");
				st1.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
				st2.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
				st3.setIcon(new ImageIcon("team3/booktable/img/회색 별.jpg"));
				st4.setIcon(new ImageIcon("team3/booktable/img/회색 별.jpg"));
				st5.setIcon(new ImageIcon("team3/booktable/img/회색 별.jpg"));
				
			}
		});
		st3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				star = 3;
				jtl2.setText(" (3점)    보통 이에요");
				st1.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
				st2.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
				st3.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
				st4.setIcon(new ImageIcon("team3/booktable/img/회색 별.jpg"));
				st5.setIcon(new ImageIcon("team3/booktable/img/회색 별.jpg"));
				
			}
		});
		st4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				star = 4;
				jtl2.setText(" (4점)    재미 있어요!");
				st1.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
				st2.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
				st3.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
				st4.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
				st5.setIcon(new ImageIcon("team3/booktable/img/회색 별.jpg"));
				
			}
		});
		st5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				star = 5;
				jtl2.setText(" (5점)    최고 에요!!");
				st1.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
				st2.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
				st3.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
				st4.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
				st5.setIcon(new ImageIcon("team3/booktable/img/노란 별.jpg"));
				
			}
		});
		
jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
				
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
		sql="insert into review values (?,null,null,null,?,sysdate)";
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

}


