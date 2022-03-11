package team3.booktable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import team3.init.MyPage;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JScrollPane;

public class booktable extends JFrame {
	
	Connection con = null; // DB와 연결하는 객체
	PreparedStatement pstmt = null; // sql문을 db에 전송하는 객체
	ResultSet rs = null; // sql문 실행 결과를 가지고 있는 객체
	String sql = null; // sql문을 저장하는 문자열 변수.

	private JPanel contentPane;
	private JTextField jtf1;
	private JTable table;
	
	DefaultTableModel model;

	JComboBox<String> jcb1;
	JComboBox<String> jcb2;
	JComboBox<String> jcb3;
	String genre;
	// search
	String str2;
	String str;

	String sort;
	// sort
	String sortbname = "";
	String sortjenre = "";
	String sortsuch = "";
	String sortmgr = "n";
	
	String mtable="";
	
	String mname = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					booktable frame = new booktable("ogj5555");
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
	public booktable(String id) {
		
		String mname = name(id);
		
		setTitle("도서 검색");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 906, 471);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("info"));
		contentPane.setForeground(UIManager.getColor("activeCaptionText"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jcb3 = new JComboBox();
		jcb3.setBounds(464, 87, 80, 28);
		jcb3.setBackground(UIManager.getColor("Table.background"));
		jcb3.setModel(new DefaultComboBoxModel(new String[] {"장르 전체"}));
		contentPane.add(jcb3);
		
		jcb1 = new JComboBox();
		jcb1.setBounds(553, 87, 80, 28);
		jcb1.setBackground(UIManager.getColor("Table.background"));
		jcb1.setModel(new DefaultComboBoxModel(new String[] {"도서명", "작가명"}));
		contentPane.add(jcb1);
		
		jtf1 = new JTextField();
		jtf1.setBounds(464, 125, 185, 28);
		contentPane.add(jtf1);
		jtf1.setColumns(10);
		
		JButton jb1 = new JButton("검 색");
		jb1.setBounds(661, 124, 97, 28);
		jb1.setBackground(UIManager.getColor("Table.selectionBackground"));
		jb1.setForeground(UIManager.getColor("InternalFrame.inactiveTitleForeground"));
		contentPane.add(jb1);
		
		jcb2 = new JComboBox();
		jcb2.setBounds(28, 167, 74, 21);
		jcb2.setBackground(UIManager.getColor("Table.background"));
		jcb2.setModel(new DefaultComboBoxModel(new String[] {"이름 순", "별점 순", "리뷰 순"}));
		contentPane.add(jcb2);
		
		JButton jb3 = new JButton("리뷰 작성");
		jb3.setBounds(28, 48, 121, 28);
		jb3.setFont(new Font("돋움", Font.BOLD, 14));
		jb3.setBackground(UIManager.getColor("Table.selectionBackground"));
		contentPane.add(jb3);
		
		JButton jb4 = new JButton("리뷰 보기");
		jb4.setBounds(28, 86, 121, 28);
		jb4.setFont(new Font("돋움", Font.BOLD, 14));
		jb4.setBackground(UIManager.getColor("Table.selectionBackground"));
		contentPane.add(jb4);
		
		JButton jb2 = new JButton("전체 보기");
		jb2.setBounds(28, 10, 121, 28);
		jb2.setFont(new Font("돋움", Font.BOLD, 14));
		jb2.setBackground(UIManager.getColor("Table.selectionBackground"));
		contentPane.add(jb2);
		
		JButton jb5 = new JButton("Home");
		jb5.setForeground(new Color(0, 0, 0));
		jb5.setIcon(null);
		jb5.setBounds(28, 124, 121, 28);
		jb5.setFont(new Font("돋움", Font.BOLD, 14));
		jb5.setBackground(UIManager.getColor("info"));
		contentPane.add(jb5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 198, 821, 204);
		contentPane.add(scrollPane);
		String[] header = { "장르", "도서명", "작가명", "평균별점", "리뷰수", "도서위치" };
		model = new DefaultTableModel(header, 0);
		table = new JTable();
		table.setModel(model
		);
		scrollPane.setViewportView(table);
		
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
						
						if(mtable.equals("")) {
							JOptionPane.showMessageDialog(null, "도서를 선택하세요");
						}else {

							viewer v2 = new viewer(mtable,mname);
							v2.setVisible(true);
							}

						
					}
				});
				
				jb3.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						SimpleDateFormat sys = new SimpleDateFormat("yyyy-MM-dd");

						Date now = new Date();
						String sysdate = sys.format(now);
						connect();
						

						
						
						if(mtable.equals("")) {
							JOptionPane.showMessageDialog(null, "도서를 선택하세요");
						}
						else if(sysdate(bnumber(mtable),mname).substring(0,10).equals(sysdate)){
							JOptionPane.showMessageDialog(null, "이미 오늘 리뷰를 작성하셨습니다. 같은책의 리뷰는 하루 한번 가능합니다.");
						}
						else {
							stre st = new stre(mtable,mname);
							st.setVisible(true);
							}

					}
				});
				
				jb5.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						new MyPage(id);
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
	
	String sysdate(int bnumber , String mname) {
		String sysdate = "ddddddddddddddddd";
		
		
		try {
			sql = "select regdate from review where bnumber = ? and rname = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			pstmt.setString(2, mname);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				sysdate = rs.getString("regdate");
			}
			con.close();
			pstmt.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sysdate; 
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
	// ----------책이름 > 책번호 ----------------------
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
	
	// ==id > 이름 ====
	
	String name(String id) {
		
		connect();
		String mem_name = "";
		try {
			sql = "select mem_name from member where mem_id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mem_name = rs.getString("mem_name");
			}
			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mem_name;

	}
}
