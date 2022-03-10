package team3.booktable;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;

import javax.swing.*;

public class reviewmake extends JFrame {

	Connection con = null; // DB와 연결하는 객체
	PreparedStatement pstmt = null; // sql문을 db에 전송하는 객체
	ResultSet rs = null; // sql문 실행 결과를 가지고 있는 객체
	String sql = null; // sql문을 저장하는 문자열 변수.

	JTextArea jta1;
	JPasswordField jpf1;
	String pass;
	JTextField jtf1;

	int ran = 0;

	int star = 0;

	public reviewmake() {
	}

	public void reviewmake(String bname) {

		setTitle("리뷰 작성");

		JLabel jtf = new JLabel("도서명 :  " + bname);
		JLabel jl1 = new JLabel("이      름 : ");
		jtf1 = new JTextField(8);
		JLabel jl2 = new JLabel("비밀번호 : ");
		JLabel jl3 = new JLabel("(숫자 8자 이내)");
		jpf1 = new JPasswordField(10);

		jta1 = new JTextArea(13, 5);
		JScrollPane jsp = new JScrollPane(jta1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

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
		JLabel jl = new JLabel("별점");

		JButton jb1 = new JButton("정 정");
		JButton jb2 = new JButton("등 록");
		JButton jb3 = new JButton("취 소 ");

		JPanel con = new JPanel();
		JPanel con1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel con2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel con3 = new JPanel();
		JPanel con4 = new JPanel();
		JPanel con5 = new JPanel();
		JPanel con6 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel con7 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		con.add(jtf);
		con1.add(jl1);
		con1.add(jtf1);
		con2.add(jl2);
		con2.add(jpf1);
		con6.add(jl3);
		con3.add(jrb1);
		con3.add(jrb2);
		con3.add(jrb3);
		con3.add(jrb4);
		con3.add(jrb5);
		con4.add(jb1);
		con4.add(jb2);
		con4.add(jb3);
		con5.add(jl);

		JPanel group1 = new JPanel(new BorderLayout());
		JPanel group2 = new JPanel(new BorderLayout());
		JPanel group4 = new JPanel(new BorderLayout());

		group4.add(jsp, BorderLayout.NORTH);
		group4.add(con7, BorderLayout.SOUTH);

		group1.add(con1, BorderLayout.NORTH);
		group1.add(con2, BorderLayout.CENTER);
		group1.add(con6, BorderLayout.SOUTH);
		group2.add(con5, BorderLayout.NORTH);
		group2.add(con3, BorderLayout.CENTER);
		group2.add(con4, BorderLayout.SOUTH);

		JPanel group3 = new JPanel(new BorderLayout());
		group3.add(con, BorderLayout.NORTH);
		group3.add(group1, BorderLayout.EAST);

		jrb5.setSelected(true);

		add(group3, BorderLayout.NORTH);
		add(group4, BorderLayout.CENTER);
		add(group2, BorderLayout.SOUTH);

		setSize(450, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

		jb2.addActionListener(new ActionListener() {

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

				pass = new String(jpf1.getPassword());
				boolean pa = false;
				for (int i = 0; i < pass.length(); i++) {
					char tmp = pass.charAt(i);
					if (!('0' <= tmp && tmp <= '9')) {
						pa = true;
					}
				}
				if (pa == true) {
					JOptionPane.showMessageDialog(null, "패스워드는 반드시 숫자 로 입력해 주세요");
					jpf1.setText("");
				} else

				if (jtf1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요");
				} else if (pass.equals("")) {
					JOptionPane.showMessageDialog(null, "패스워드를 입력하세요");
				} else if (jta1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "리뷰내용을 입력하세요");
				} else {
					connect();
					review(bnumber(bname));
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

		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jtf1.setText("");
				jpf1.setText("");
				jta1.setText("");
				jrb5.setSelected(true);
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

	void review(int bnumber) {

		try {

			sql = "insert into review values (?,reviewnum_seq.nextval,?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			pstmt.setInt(2, Integer.parseInt(pass));
			pstmt.setString(3, jtf1.getText());
			pstmt.setString(4, jta1.getText());
			pstmt.setInt(5, star);

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

	public static void main(String[] args) {
		reviewmake rm = new reviewmake();
		rm.reviewmake("나루토");

	}

}
