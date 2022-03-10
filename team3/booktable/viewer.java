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

public class viewer extends JFrame {

	Connection con = null; // DB와 연결하는 객체
	PreparedStatement pstmt = null; // sql문을 db에 전송하는 객체
	ResultSet rs = null; // sql문 실행 결과를 가지고 있는 객체
	String sql = null; // sql문을 저장하는 문자열 변수.

	DefaultTableModel model2;
	JTable table2;

	JComboBox<String> vjcb1;

	String bm;
	double staravg = 0.0;

	JLabel vjl2;

	JTextArea vjta1;
	int no1;

	String review;

	public viewer() {
	}

	public void viewer(String bname) {
		bm = bname;

		setTitle("리뷰 목록");

		JLabel vjl1 = new JLabel("도서 명 : " + bname + "                            ");

		vjl2 = new JLabel("평균 별점 : " + staravg);

		String[] vjc = { "최근 등록순", "오래된 등록순", "별점 높은순", "별점 낮은순" };
		vjcb1 = new JComboBox<String>(vjc);
		JLabel vjl3 = new JLabel("정렬");

		String[] header2 = { "No.", "작성자", "리뷰 내용", "별  점", "작성 날짜" };
		model2 = new DefaultTableModel(header2, 0);
		table2 = new JTable(model2);
		JScrollPane jsp2 = new JScrollPane(table2, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		vjta1 = new JTextArea(14, 5);
		vjta1.setLineWrap(true);
		JScrollPane jsp3 = new JScrollPane(vjta1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JButton vjb1 = new JButton("리뷰 수정");
		JButton vjb3 = new JButton("새로 고침");
		JButton vjb2 = new JButton(" 닫   기 ");

		JPanel vcontainer1 = new JPanel();
		JPanel vcontainer2 = new JPanel();
		JPanel vcontainer3 = new JPanel();
		JPanel vgroup1 = new JPanel(new BorderLayout());
		JPanel vgroup2 = new JPanel(new BorderLayout());
		JPanel vgroup3 = new JPanel(new BorderLayout());

		vcontainer1.add(vjl1);
		vcontainer1.add(vjl2);
		vcontainer2.add(vjcb1);
		vcontainer2.add(vjl3);
		vgroup1.add(vcontainer2, BorderLayout.WEST);
		vcontainer3.add(vjb1);
		vcontainer3.add(vjb3);
		vcontainer3.add(vjb2);

		vgroup2.add(vcontainer1, BorderLayout.NORTH);
		vgroup2.add(vcontainer2, BorderLayout.SOUTH);
		vgroup2.add(jsp2);

		vgroup3.add(jsp3, BorderLayout.NORTH);
		vgroup3.add(vcontainer3, BorderLayout.SOUTH);

		add(vgroup2, BorderLayout.NORTH);
		add(jsp2, BorderLayout.CENTER);
		add(vgroup3, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(600, 500);
		setLocationRelativeTo(null);

		setVisible(true);

		connect();
		staravg();
		view2();

		vjcb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				model2.setRowCount(0);
				view2();

			}
		});

		table2.addMouseListener(new MouseListener() {

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
				int row = table2.getSelectedRow();
				no1 = Integer.parseInt(model2.getValueAt(row, 0).toString());
				connect();
				show2(no1);

			}
		});

		vjb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String rccom = null;
				if (no1 == 0) {
					JOptionPane.showMessageDialog(null, "도서를 선택하세요");
				} else {

					String pass = JOptionPane.showInputDialog("리뷰 작성시 설정한 비밀번호를 입력하세요.");
					connect();
//				if(pass.equals(null)) {
//					JOptionPane.showMessageDialog(null, "패스워드를 입력해주세요.");
//				
//				}

					if (pass == null) {
					} else if (pass.equals("")) {
						JOptionPane.showMessageDialog(null, "패스워드를 입력해주세요.");
					} else if (Integer.parseInt(pass) == pass(no1)) {
						reviewcorrection rc = new reviewcorrection();
						rc.reviewcorrection(review, no1);

						model2.setRowCount(0);

					} else if (Integer.parseInt(pass) != pass(no1)) {
						JOptionPane.showMessageDialog(null, "패스워드가 틀립니다.");

					}

				}

			}

		});
		vjb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				model2.setRowCount(0);
				view2();

			}
		});

		vjb2.addActionListener(new ActionListener() {

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

	void view2() {
		String rname2 = null;
		String review2 = null;

		try {
			if (vjcb1.getSelectedItem().toString().equals("최근 등록순")) {
				sql = "select reviewnum,rname , review , starsum , regdate  from review r join books b on r.bnumber = b.bnumber where bname = ? and not review is null order by regdate desc";
			} else if (vjcb1.getSelectedItem().toString().equals("오래된 등록순")) {
				sql = "select reviewnum,rname , review , starsum , regdate  from review r join books b on r.bnumber = b.bnumber where bname = ? and not review is null order by regdate";
			} else if (vjcb1.getSelectedItem().toString().equals("별점 높은순")) {
				sql = "select reviewnum,rname , review , starsum , regdate  from review r join books b on r.bnumber = b.bnumber where bname = ? and not review is null order by starsum desc";
			} else if (vjcb1.getSelectedItem().toString().equals("별점 낮은순")) {
				sql = "select reviewnum,rname , review , starsum , regdate  from review r join books b on r.bnumber = b.bnumber where bname = ? and not review is null order by starsum";
			}

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bm);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				int rnum = rs.getInt("reviewnum");
				String rname = rs.getString("rname");

				rname2 = rname.substring(0, 2) + "*";

				review2 = rs.getString("review");
				if (review2 == null) {
					continue;
				}
				if (review2.length() > 10) {
					review2 = review2.substring(0, 10) + "...";
				}

				String regdate = rs.getString("regdate").substring(0, 10);
				double star = rs.getDouble("starsum");

				Object[] data = { rnum, rname2, review2, star, regdate };
				model2.addRow(data);
			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// --평균 별점--
	void staravg() {
		try {
			sql = "select  bstaravg  from books where bname = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bm);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				staravg = rs.getDouble("bstaravg");

			}

			vjl2.setText("평균 별점 : " + staravg);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// --리뷰 출력--
	void show2(int no) {
		try {
			sql = "select review from review where reviewnum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vjta1.setText(rs.getString("review"));
				review = rs.getString("review");

			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// -- 비밀번호 호출--
	int pass(int no) {
		int pass = 0;
		try {
			sql = "select reviewpass from review where reviewnum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pass = rs.getInt("reviewpass");

			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pass;

	}

	public static void main(String[] args) {

		viewer vw = new viewer();
		vw.viewer("더 파이팅");

	}

}
