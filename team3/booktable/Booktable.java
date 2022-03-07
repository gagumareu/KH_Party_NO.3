package team3.booktable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import jdk.nashorn.internal.scripts.JO;

public class Booktable extends JFrame {

	Connection con = null; // DB와 연결하는 객체
	PreparedStatement pstmt = null; // sql문을 db에 전송하는 객체
	ResultSet rs = null; // sql문 실행 결과를 가지고 있는 객체
	String sql = null; // sql문을 저장하는 문자열 변수.

	DefaultTableModel model;
	JTable table;
	DefaultTableModel model2;
	JTable table2;

	JTextField jtf1;
	JComboBox<String> jcb1;
	JComboBox<String> jcb3;
	String genre;
	// search
	String str2;
	String str;

	JComboBox<String> jcb2;
	String sort;
	// sort
	String sortbname = "";
	String sortjenre = "";
	String sortsuch = "";
	String sortmgr = "n";
	
	String mtable=null;

	

	public Booktable() {

		setTitle("도서검색");

		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel(new BorderLayout());
		JPanel container3 = new JPanel();
		JPanel container4 = new JPanel();

		String[] bname = { "도서명", "작가명" };

		jcb3 = new JComboBox<>();

		jcb3.addItem("장르 전체");

		jcb1 = new JComboBox<String>(bname);
		String[] bname2 = { "이름 순", "리뷰 순", "별점 순" };

		jcb2 = new JComboBox<String>(bname2);

		jtf1 = new JTextField(15);
		JButton jb1 = new JButton("검색");

		JLabel jl1 = new JLabel("정렬");

		String[] header = { "장르", "도서명", "작가명", "평균별점", "리뷰수", "도서위치" };

		model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		JScrollPane jsp = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JButton jb2 = new JButton("전체 보기");
		JButton jb3 = new JButton("리뷰 쓰기");
		JButton jb4 = new JButton("리뷰 보기");
		JButton jb5 = new JButton("닫 기");

		container1.add(jcb3);
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
		combogenre();
		view();

		// 검색버튼 (특정부분만 입력해도 포함되어있는 값을 검색해주는 시스템)
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				connect();

				model.setRowCount(0);

				search();

				jtf1.setText("");

			}
		});

		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				model.setRowCount(0);
				view();

			}
		});

		jcb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String sort1 = jcb2.getSelectedItem().toString();

				connect();
				model.setRowCount(0);
				sort(sort1);

			}
		});

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				

				mtable = model.getValueAt(row, 1).toString();
				

				
			}
		});
		
		
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(mtable==null) {
					JOptionPane.showMessageDialog(null, "도서를 선택하세요");
				}else {

					connect();
					viewer vw = new viewer();
					vw.viewer(mtable);
					}

				
			}
		});
		
		
		
		
		
		
		

	}// --------------------------------생성자 end-------------------------------------

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

	// 특정 책의 리뷰 수를 불러오는 메서드
	int review(int bnumber) {
		int num = bnumber;
		int review = 0;

		try {
			sql = "select count(*) from review where bnumber=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs1 = pstmt.executeQuery();

			while (rs1.next()) {
				review = rs1.getInt("count(*)");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return review;
	}

	// 특정 책의 별점합을 구하는 메서드
	int star(int bnumber) {
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

	// 전체화면을 출력
	// 실행시, 전체보기 클릭시

	void view() {

		try {
			sql = "select * from books order by bname";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String bname = rs.getString("bname");
				String blocation = rs.getString("blocation");
				String bwriter = rs.getString("bwriter");
				String bgenre = rs.getString("bgenre");
				int reviewsum = rs.getInt("breviewsum");
				double star = rs.getDouble("bstaravg");

				Object[] data = { bgenre, bname, bwriter, star, reviewsum, blocation };
				model.addRow(data);
			}
			sortbname = "";
			sortjenre = "";
			sortsuch = "";
			sortmgr = "n";

			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 검색버튼 실행 시 메서드 (특정부분만 입력해도 포함되어있는 값을 검색해주는 시스템)
	void search() {

		str = "%" + jtf1.getText() + "%";
		sortbname = "%" + jtf1.getText() + "%";
		str2 = jcb1.getSelectedItem().toString();
		sortjenre = jcb3.getSelectedItem().toString();
		sortsuch = jcb1.getSelectedItem().toString();

		label: try {
			if (jcb3.getSelectedItem().toString().equals("장르 전체")) {
				if (jtf1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "장르를 선택 하거나 검색어 를 입력해 주세요.");
					view();
					break label;
				}
				if (str2 == "도서명") {
					sql = "select * from books where bname like ?  order by bname";

				} else {
					sql = "select * from books where bwriter like ? order by bname";

				}
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, str);

				rs = pstmt.executeQuery();

			} else {

				if (str2 == "도서명") {
					sql = "select * from books where bname like ? and bgenre = ? order by bname";

				} else {
					sql = "select * from books where bwriter like ? and bgenre = ? order by bname";

				}
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, str);
				pstmt.setString(2, jcb3.getSelectedItem().toString());

				rs = pstmt.executeQuery();
			}

			while (rs.next()) {
				String bname = rs.getString("bname");
				String blocation = rs.getString("blocation");
				String bwriter = rs.getString("bwriter");
				String bgenre = rs.getString("bgenre");
				int reviewsum = rs.getInt("breviewsum");
				double star = rs.getDouble("bstaravg");
				sortmgr = "y";

				Object[] data = { bgenre, bname, bwriter, star, reviewsum, blocation };
				model.addRow(data);

			}

			con.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	// 정렬 선택시 출력되는 메서드
	void sort(String sort1) {

		if (sortmgr.equals("n")) {
			try {

				sql = "select * from books order by ";
				switch (sort1) {
				case "이름 순":
					sql = sql + "bname";
					break;
				case "별점 순":
					sql = sql + "bstaravg desc";
					break;
				case "리뷰 순":
					sql = sql + "breviewsum desc";
					break;
				}
				pstmt = con.prepareStatement(sql);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					String bname = rs.getString("bname");
					String blocation = rs.getString("blocation");
					String bwriter = rs.getString("bwriter");
					String bgenre = rs.getString("bgenre");
					int reviewsum = rs.getInt("breviewsum");
					double star = rs.getDouble("bstaravg");

					Object[] data = { bgenre, bname, bwriter, star, reviewsum, blocation };
					model.addRow(data);
				}
				sortbname = "";
				sortjenre = "";
				sortsuch = "";
				sortmgr = "n";

				rs.close();
				pstmt.close();
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			try {
				if (sortjenre == ("장르 전체")) {
					if (sortsuch == "도서명") {
						sql = "select * from books where bname like ?  order by ";

					} else {
						sql = "select * from books where bwriter like ? order by ";

					}
					switch (sort1) {
					case "이름 순":
						sql = sql + "bname";
						break;
					case "별점 순":
						sql = sql + "bstaravg desc";
						break;
					case "리뷰 순":
						sql = sql + "breviewsum desc";
						break;
					}
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, str);

					rs = pstmt.executeQuery();

				} else {

					if (sortsuch == "도서명") {
						sql = "select * from books where bname like ? and bgenre = ? order by ";

					} else {
						sql = "select * from books where bwriter like ? and bgenre = ? order by ";

					}
					switch (sort1) {
					case "이름 순":
						sql = sql + "bname";
						break;
					case "별점 순":
						sql = sql + "bstaravg desc";
						break;
					case "리뷰 순":
						sql = sql + "breviewsum desc";
						break;
					}
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, str);
					pstmt.setString(2, jcb3.getSelectedItem().toString());

					rs = pstmt.executeQuery();
				}

				while (rs.next()) {
					String bname = rs.getString("bname");
					String blocation = rs.getString("blocation");
					String bwriter = rs.getString("bwriter");
					String bgenre = rs.getString("bgenre");
					int reviewsum = rs.getInt("breviewsum");
					double star = rs.getDouble("bstaravg");
					sortmgr = "y";

					Object[] data = { bgenre, bname, bwriter, star, reviewsum, blocation };
					model.addRow(data);

				}

				con.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	// 장르를 콤보박스에 넣음.
	void combogenre() {

		try {
			sql = "select distinct bgenre from books order by bgenre";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				jcb3.addItem(rs.getString("bgenre"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

// 리뷰수와 평균별점을 books 테이블의 해당 컬럼에 update
	void reviewset(int bnumber) {

		int num1 = bnumber;
		int num2 = review(num1);
		int num3 = star(num1);
		double num4 = (double) num3 / (double) num2;
		double num5 = Math.round(num4 * 10) / 10.0;

		try {
			sql = "update books set bstaravg = ? ,breviewsum = ? where bnumber = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, num5);
			pstmt.setInt(2, num2);
			pstmt.setInt(3, num1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
//	//-------------------------------리뷰 보기-----------------------------------------
//	void viewer(String mtable) {
//		setTitle("리뷰 목록");
//		
//		JLabel vjl1 = new JLabel("도서 명 : "+mtable);
//		JLabel vjl2 = new JLabel("평균 별점 : ");
//		String[] vjc = {"최근 등록순","오래된 등록순","별점 높은순","별점 낮은순"};
//		JComboBox<String> vjcb1 = new JComboBox<String>(vjc);
//		JLabel vjl3 = new JLabel("정렬");
//		
//		String[] header2 = { "리뷰 작성자","리뷰 내용", "평균별점" };
//		model2 = new DefaultTableModel(header2, 0);
//		table2 = new JTable(model2);
//		JScrollPane jsp2 = new JScrollPane(table2, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
//				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		
//		JTextArea vjta1 = new JTextArea(20,10);
//		
//		JButton vjb1 = new JButton("리뷰 수정");
//		JButton vjb2 = new JButton(" 닫   기 ");
//		
//		JPanel vcontainer1 = new JPanel();
//		JPanel vcontainer2 = new JPanel();
//		JPanel vcontainer3 = new JPanel();
//		JPanel vgroup1 = new JPanel(new BorderLayout());
//		JPanel vgroup2 = new JPanel(new BorderLayout());
//		JPanel vgroup3 = new JPanel(new BorderLayout());
//		
//		
//		
//		vcontainer1.add(vjl1);
//		vcontainer1.add(vjl2);
//		vcontainer2.add(vjcb1);
//		vcontainer2.add(vjl3);
//		vgroup1.add(vcontainer2, BorderLayout.WEST);
//		vcontainer3.add(vjb1);
//		vcontainer3.add(vjb2);
//		
//		vgroup2.add(vcontainer1,BorderLayout.NORTH);
//		vgroup2.add(vcontainer2);
//		vgroup2.add(jsp2, BorderLayout.SOUTH);
//		
//		vgroup3.add(vjta1, BorderLayout.NORTH);
//		vgroup3.add(vcontainer3, BorderLayout.SOUTH);
//		
//		add(vgroup2, BorderLayout.NORTH);
//		add(vgroup3, BorderLayout.SOUTH);
//		
//		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		setSize(900, 400);
//		setLocationRelativeTo(null);
//
//		setVisible(true);
//		
//		
//		
//		
//		
//	}
	
	

	public static void main(String[] args) {

		new Booktable();

	}

}
