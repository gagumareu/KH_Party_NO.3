package booktable;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Booktable extends JFrame{
	
	Connection con = null; // DB와 연결하는 객체
	PreparedStatement pstmt = null; // sql문을 db에 전송하는 객체
	ResultSet rs = null; // sql문 실행 결과를 가지고 있는 객체
	String sql = null; // sql문을 저장하는 문자열 변수.
	
	DefaultTableModel model;
	JTable table;
	
	
	
	public Booktable() {
		
		setTitle("도서검색");
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel(new BorderLayout());
		JPanel container3 = new JPanel();
		JPanel container4 = new JPanel();
		
		String[] bname = {"도서명","작가명"};
		
		JComboBox<String> jcb1 = new JComboBox<String>(bname);
		String[] bname2 = {"이름 순","리뷰 순","별점 순"};
		
		JComboBox<String> jcb2 = new JComboBox<String>(bname2);
		
		JTextField jtf1 = new JTextField(15);
		JButton jb1 = new JButton("검색");
		
		JLabel jl1 = new JLabel("정렬");
		
		String[] header = { "도서명", "작가명","평균별점", "리뷰수","도서위치"  };

		model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		JScrollPane jsp = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JButton jb2 = new JButton("전체 보기");
		JButton jb3 = new JButton("리뷰 쓰기");
		JButton jb4 = new JButton("리뷰 보기");
		JButton jb5 = new JButton("닫 기");
		
		container1.add(jcb1);
		container1.add(jtf1);
		container1.add(jb1);
		container2.add(jcb2, BorderLayout.WEST);
		container2.add(jl1);
		container3.add(jb2);
		container3.add(jb3);
		container3.add(jb4);
		container4.add(jb5);
		
		JPanel group1 = new JPanel(new BorderLayout());
		JPanel group2 = new JPanel(new BorderLayout());
		group1.add(container1, BorderLayout.NORTH);
		group1.add(container2, BorderLayout.SOUTH);
		group2.add(container3, BorderLayout.NORTH);
		group2.add(container4, BorderLayout.SOUTH);
		
		add(group1, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		add(group2, BorderLayout.SOUTH);
		
		
		
		
		
	
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(900, 400);
		setLocationRelativeTo(null);
		
		
		
		
		setVisible(true);

		connect();
	
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
	//특정 책의 리뷰 수를 불러오는 메서드
	int review (int bnumber) {
		int num = bnumber;
		int review = 0;

				try {
					sql = "select count(*) from review where bnumber=? ";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
					rs=pstmt.executeQuery();
					
					
					while(rs.next()) {
						review = rs.getInt("count(*)");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
		return review;
	}
	
	// 특정 책의 별점합을 구하는 메서드
	int star (int bnumber) {
		int num=bnumber;
		int star = 0;

		try {
			sql = "select sum(starsum) from review where bnumber=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				star = rs.getInt("sum(starsum)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return star;
		
	}

	// 전체화면을 출력
	// 실행시, 전체보기 클릭시
	
	void view() {
		

		try {
			sql = "select * from books order by bname";
			pstmt= con.prepareStatement(sql);
			
			rs= pstmt.executeQuery();
			
			while (rs.next()) {
				String bname = rs.getString("bname");
				String blocation = rs.getString("blocation");
				String bwriter = rs.getString("bwriter");
				int review = review(rs.getInt("bnumber"));
				int starsum = star(rs.getInt("bnumber"));
				int star = starsum/review;
				
				Object[] data = {bname,bwriter,star,review,blocation};
				model.addRow(data);
			}
			
			rs.close(); pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
				
		
	}


	
	

	public static void main(String[] args) {
		
		new Booktable();

	}

}
