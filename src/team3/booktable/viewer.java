package team3.booktable;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class viewer extends JFrame {
	

	Connection con = null; // DB와 연결하는 객체
	PreparedStatement pstmt = null; // sql문을 db에 전송하는 객체
	ResultSet rs = null; // sql문 실행 결과를 가지고 있는 객체
	String sql = null; // sql문을 저장하는 문자열 변수.
	
	JComboBox jcb;
	
	String rname ; 
	int no1;
	String review2 = null;


	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	
	JTextArea jta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewer frame = new viewer("궁","오경종");
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
	public viewer(String bname , String mname) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("도서 명 : " + bname);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel.setBounds(150, 10, 203, 15);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 72, 472, 141);
		contentPane.add(scrollPane);
		
		String[] header = { "No.", "작성자", "리뷰 내용", "별  점", "작성 날짜" };
		model = new DefaultTableModel(header, 0);
		table = new JTable();
		table.setModel(model
		);
		scrollPane.setViewportView(table);
		
		jcb = new JComboBox();
		jcb.setModel(new DefaultComboBoxModel(new String[] { "최근 등록순", "오래된 등록순", "별점 높은순", "별점 낮은순" }));
		jcb.setBounds(12, 41, 102, 21);
		contentPane.add(jcb);
		
		jta = new JTextArea();
		jta.setBounds(12, 216, 472, 154);
		contentPane.add(jta);
		
		JButton jb1 = new JButton("나의 리뷰 보기");
		jb1.setBounds(12, 413, 127, 23);
		contentPane.add(jb1);
		
		JButton jb3 = new JButton("닫 기");
		jb3.setBounds(357, 413, 127, 23);
		contentPane.add(jb3);
		
		JButton jb2 = new JButton("전체 보기");
		jb2.setBounds(184, 413, 127, 23);
		contentPane.add(jb2);
		
		JLabel lblNewLabel_1 = new JLabel("평균 별점 : " + staravg(bname));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(150, 25, 203, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton jb4 = new JButton("수정하기");
		jb4.setBounds(387, 380, 97, 23);
		contentPane.add(jb4);
		jb4.setEnabled(false);
		
		connect();
		view(bname);
		
		jcb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				model.setRowCount(0);
				view(bname);

			}
		});
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				model.setRowCount(0);
				myview(bname,mname);
				
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				model.setRowCount(0);
				view(bname);
				
			}
		});
		jb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);

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
				no1 = Integer.parseInt(model.getValueAt(row, 0).toString());
				connect();
				show2(no1);
				if (rname.equals(mname)) {
					jb4.setEnabled(true);
				}else {
					jb4.setEnabled(false);
				}

			}
		});
		
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				reviewmake_2 rm3 = new reviewmake_2(bname,mname,no1,review2(no1));
				rm3.setVisible(true);
				
				
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
	
	void view(String bname) {
		String rname2 = null;
		String review2 = null;

		try {
			if (jcb.getSelectedItem().toString().equals("최근 등록순")) {
				sql = "select reviewnum,rname , review , starsum , regdate  from review r join books b on r.bnumber = b.bnumber where bname = ? and not review is null order by regdate desc";
			} else if (jcb.getSelectedItem().toString().equals("오래된 등록순")) {
				sql = "select reviewnum,rname , review , starsum , regdate  from review r join books b on r.bnumber = b.bnumber where bname = ? and not review is null order by regdate";
			} else if (jcb.getSelectedItem().toString().equals("별점 높은순")) {
				sql = "select reviewnum,rname , review , starsum , regdate  from review r join books b on r.bnumber = b.bnumber where bname = ? and not review is null order by starsum desc";
			} else if (jcb.getSelectedItem().toString().equals("별점 낮은순")) {
				sql = "select reviewnum,rname , review , starsum , regdate  from review r join books b on r.bnumber = b.bnumber where bname = ? and not review is null order by starsum";
			}

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bname);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				int rnum = rs.getInt("reviewnum");
				String rname = rs.getString("rname"); 
				review2 = rs.getString("review");
				

				rname2 = rname.substring(0, 2) + "*";

				if (review2 == null) {
					continue;
				}
				if (review2.length() > 10) {
					review2 = review2.substring(0, 10) + "...";
				}

				String regdate = rs.getString("regdate").substring(0, 10);
				double star = rs.getDouble("starsum");

				Object[] data = { rnum, rname2, review2, star, regdate };
				model.addRow(data);
			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	void myview(String bname, String mname) {
		String rname2 = null;
		String review2 = null;

		try {
			if (jcb.getSelectedItem().toString().equals("최근 등록순")) {
				sql = "select reviewnum,rname , review , starsum , regdate  from review r join books b on r.bnumber = b.bnumber where bname = ? and rname = ? and not review is null order by regdate desc";
			} else if (jcb.getSelectedItem().toString().equals("오래된 등록순")) {
				sql = "select reviewnum,rname , review , starsum , regdate  from review r join books b on r.bnumber = b.bnumber where bname = ? and rname = ? and not review is null order by regdate";
			} else if (jcb.getSelectedItem().toString().equals("별점 높은순")) {
				sql = "select reviewnum,rname , review , starsum , regdate  from review r join books b on r.bnumber = b.bnumber where bname = ? and rname = ? and not review is null order by starsum desc";
			} else if (jcb.getSelectedItem().toString().equals("별점 낮은순")) {
				sql = "select reviewnum,rname , review , starsum , regdate  from review r join books b on r.bnumber = b.bnumber where bname = ? and rname = ? and not review is null order by starsum";
			}

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, mname);

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
				model.addRow(data);
			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	void show2(int no) {
		try {
			sql = "select review,rname from review where reviewnum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				jta.setText(rs.getString("review"));
				rname = rs.getString("rname");
				//review = rs.getString("review");

			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	double staravg(String bname) {
		
		connect();
		
		double staravg=0.0;
		try {
			sql = "select  bstaravg  from books where bname = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bname);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				staravg = rs.getDouble("bstaravg");

			}
			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staravg;

	}
	
	String review2(int no) {
		String review = "";
		
		
		try {
			sql = "select review from review where reviewnum = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				review = rs.getString("review");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return review;
		
	}
	
	

}
