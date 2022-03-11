package team3.booktable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;

public class reviewmake extends JFrame {
	
	Connection con = null; // DB와 연결하는 객체
	PreparedStatement pstmt = null; // sql문을 db에 전송하는 객체
	ResultSet rs = null; // sql문 실행 결과를 가지고 있는 객체
	String sql = null; // sql문을 저장하는 문자열 변수.

	private JPanel contentPane;
	int star = 5;
	
	JTextArea jta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reviewmake frame = new reviewmake("","");
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
	public reviewmake(String bname,String mname) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jtf = new JLabel("도서 명 :   "+bname);
		jtf.setBounds(109, 10, 252, 31);
		jtf.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(jtf);
		
		jta = new JTextArea();
		jta.setBounds(46, 54, 368, 281);
		contentPane.add(jta);
		
		JButton jb1 = new JButton("등 록");
		jb1.setBounds(58, 422, 91, 44);
		contentPane.add(jb1);
		
		JButton jb2 = new JButton("정 정");
		jb2.setBounds(191, 422, 91, 44);
		contentPane.add(jb2);
		
		JButton jb3 = new JButton("취 소");
		jb3.setBounds(320, 422, 91, 44);
		contentPane.add(jb3);
		
		JButton st1 = new JButton("");
		st1.setForeground(Color.WHITE);
		st1.setFocusPainted(false);
		st1.setBorderPainted(false);
		st1.setBackground(SystemColor.menu);
		st1.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
		st1.setBounds(108, 345, 41, 36);
		contentPane.add(st1);
		
		JButton st2 = new JButton("");
		st2.setForeground(Color.WHITE);
		st2.setFocusPainted(false);
		st2.setBorderPainted(false);
		st2.setBackground(SystemColor.menu);
		st2.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
		st2.setBounds(161, 345, 41, 36);
		contentPane.add(st2);
		
		JButton st3 = new JButton("");
		st3.setForeground(Color.WHITE);
		st3.setFocusPainted(false);
		st3.setBorderPainted(false);
		st3.setBackground(SystemColor.menu);
		st3.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
		st3.setBounds(214, 345, 41, 36);
		contentPane.add(st3);
		
		JButton st4 = new JButton("");
		st4.setForeground(Color.WHITE);
		st4.setFocusPainted(false);
		st4.setBorderPainted(false);
		st4.setBackground(SystemColor.menu);
		st4.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
		st4.setBounds(267, 345, 41, 36);
		contentPane.add(st4);
		
		JButton st5 = new JButton("");
		st5.setForeground(Color.WHITE);
		st5.setFocusPainted(false);
		st5.setBorderPainted(false);
		st5.setBackground(SystemColor.menu);
		st5.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
		st5.setBounds(320, 345, 41, 36);
		contentPane.add(st5);
		
		JLabel jtl2 = new JLabel(" (5점)    최고 에요!");
		jtl2.setHorizontalAlignment(JLabel.CENTER);
		jtl2.setBounds(159, 391, 161, 15);
		contentPane.add(jtl2);
		
	st1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				star = 1;
				jtl2.setText(" (1점)    별로 에요");
				st1.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
				st2.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/회색 별.jpg")));
				st3.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/회색 별.jpg")));
				st4.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/회색 별.jpg")));
				st5.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/회색 별.jpg")));
				
			}
		});
		st2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				star = 2;
				jtl2.setText(" (2점)    그냥 그래요");
				st1.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
				st2.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
				st3.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/회색 별.jpg")));
				st4.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/회색 별.jpg")));
				st5.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/회색 별.jpg")));
				
			}
		});
		st3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				star = 3;
				jtl2.setText(" (3점)    보통 이에요");
				st1.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
				st2.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
				st3.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
				st4.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/회색 별.jpg")));
				st5.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/회색 별.jpg")));
				
			}
		});
		st4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				star = 4;
				jtl2.setText(" (4점)    재미 있어요!");
				st1.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
				st2.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
				st3.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
				st4.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
				st5.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/회색 별.jpg")));
				
			}
		});
		st5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				star = 5;
				jtl2.setText(" (5점)    최고 에요!!");
				st1.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
				st2.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
				st3.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
				st4.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
				st5.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
				
			}
		});
		
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {


				if (jta.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "리뷰내용을 입력하세요");
				} else {
					connect();
					review(bnumber(bname),mname);
				}

				setVisible(false);

			}
		});

		jb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});

		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jta.setText("");
				star = 5;
				jtl2.setText(" (5점)    최고 에요!!");
				st1.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
				st2.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
				st3.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
				st4.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
				st5.setIcon(new ImageIcon(starmake.class.getResource("/team3/booktable/img/노란 별.jpg")));
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

	void review(int bnumber,String mname) {

		try {

			sql = "insert into review values (?,reviewnum_seq.nextval,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			pstmt.setString(2, mname);
			pstmt.setString(3, jta.getText());
			pstmt.setInt(4, star);

			int res = pstmt.executeUpdate();

			if (res > 0) {
				JOptionPane.showMessageDialog(null, "성공적으로 리뷰가 작성되었습니다.");
				pstmt.close();
				reviewsum(bnumber);
				staravg(bnumber);
			} else {
				JOptionPane.showMessageDialog(null, "리뷰작성 실패");
			}

			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//-- 리뷰 수를 더하는 메서드--
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

	// -------------------책이름 = 책번호 변환---------------
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
}
