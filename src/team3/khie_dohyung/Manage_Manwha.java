package team3.khie_dohyung;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Manage_Manwha extends JFrame {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql= null;
	
	DefaultTableModel model;
	JTable table;
	JTextField  jtf2, jtf3, jtf4;
	JComboBox<String>jcb1,jcb2;
	
	
	public Manage_Manwha() {
		getContentPane().setBackground(SystemColor.info);
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/제목 없음2.jpg"));
		
		setTitle("만화책 관리 화면");
		
		JPanel container1 = new JPanel();
		container1.setBackground(SystemColor.info);

		JPanel container2 = new JPanel();
		container2.setBackground(SystemColor.info);

		
		JLabel jl1 = new JLabel("책위치:");
		jcb1 = new JComboBox<String>();
		
		JLabel jl2 = new JLabel("장   르:");
		jcb2 = new JComboBox<String>();
		
		JLabel jl3 = new JLabel("책번호:");
		jtf2= new JTextField(8);
		
		JLabel jl4 = new JLabel("책이름:");
		jtf3= new JTextField(10);
		
		JLabel jl5 = new JLabel("글쓴이:");
		jtf4= new JTextField(10);
		
		
		
		jcb1.addItem("선택");
		jcb2.addItem("선택");
		
		String[] header= {"책위치","장르", "책번호","책이름","글쓴이"};
		
		model = new DefaultTableModel(header,0);
		
		table = new JTable(model);
		
		JScrollPane jsp = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton jb1 = new JButton("전체 목록");
		jb1.setBackground(Color.CYAN);
		JButton jb2 = new JButton("도서 추가");
		jb2.setBackground(Color.CYAN);
		JButton jb3 = new JButton("도서 수정");
		jb3.setBackground(Color.CYAN);
		JButton jb4 = new JButton("도서 삭제");
		jb4.setBackground(Color.CYAN);
		JButton jb5 = new JButton("돌아 가기");
		jb5.setBackground(Color.CYAN);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("images/scomic.png"));
		GroupLayout gl_container1 = new GroupLayout(container1);
		gl_container1.setHorizontalGroup(
			gl_container1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container1.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_container1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_container1.createSequentialGroup()
							.addComponent(jl3)
							.addGap(5)
							.addComponent(jtf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_container1.createSequentialGroup()
							.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_container1.createSequentialGroup()
									.addComponent(jl2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(jcb2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(124)
									.addComponent(jl1))
								.addGroup(gl_container1.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_container1.createSequentialGroup()
										.addComponent(jl5)
										.addGap(5)
										.addComponent(jtf4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_container1.createSequentialGroup()
										.addComponent(jl4)
										.addGap(5)
										.addComponent(jtf3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(5)
							.addComponent(jcb1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(120, Short.MAX_VALUE))
		);
		gl_container1.setVerticalGroup(
			gl_container1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_container1.createSequentialGroup()
					.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_container1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_container1.createSequentialGroup()
									.addGap(3)
									.addComponent(jl3))
								.addComponent(jtf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_container1.createSequentialGroup()
									.addGap(3)
									.addComponent(jl4))
								.addComponent(jtf3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
							.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_container1.createSequentialGroup()
									.addGap(3)
									.addComponent(jl5))
								.addComponent(jtf4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18))
						.addGroup(gl_container1.createSequentialGroup()
							.addGap(20)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
						.addComponent(jcb1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jl1)
						.addGroup(gl_container1.createSequentialGroup()
							.addGap(3)
							.addComponent(jl2))
						.addComponent(jcb2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		container1.setLayout(gl_container1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images/제목 없음2.jpg"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(container2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
							.addComponent(container1, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE))
						.addComponent(jsp, GroupLayout.PREFERRED_SIZE, 784, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(52)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(container1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(container2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addComponent(jsp, GroupLayout.PREFERRED_SIZE, 526, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_container2 = new GroupLayout(container2);
		gl_container2.setHorizontalGroup(
			gl_container2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_container2.createParallelGroup(Alignment.LEADING)
						.addComponent(jb1)
						.addComponent(jb2)
						.addComponent(jb3)
						.addComponent(jb4)
						.addComponent(jb5))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_container2.setVerticalGroup(
			gl_container2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container2.createSequentialGroup()
					.addGap(5)
					.addComponent(jb1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jb2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jb3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jb4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jb5)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		container2.setLayout(gl_container2);
		getContentPane().setLayout(groupLayout);
		
		
		setBounds(200,200,800,800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		connect();
		comboLoc();
		comboGenre() ;
		
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				model.setRowCount(0);
				select();
				
			}
		});

		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();		// 데이터베이스 연결 하는 메서드 호출
				insert();			//데이터 베이스에서 저장하는 메서드 호출
				//입력 텍스트필드영역 초기화
				jcb1.setSelectedIndex(0);
				jtf2.setText("");
				jtf3.setText("");
				jtf4.setText("");
				jcb2.setSelectedIndex(0);
				jtf2.requestFocus();
				
				model.setRowCount(0);		//전체 테이블의 화면을 지워주는 메서드
				select();		
				
			}
		});
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				update();
				
				jcb1.setSelectedIndex(0);
				jtf2.setText("");
				jtf3.setText("");
				jtf4.setText("");
				jcb2.setSelectedIndex(0);
				jtf2.requestFocus();
				model.setRowCount(0);		//전체 테이블의 화면을 지워주는 메서드
				select();	
				
			}
		});
		
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result= JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
				if(result== JOptionPane.CLOSED_OPTION) {
					JOptionPane.showMessageDialog(null, "취소를 클릭하셨습니다.");
				}else if(result==JOptionPane.YES_OPTION) {
					connect();
					delete();
					jtf2.setText("");
					jtf3.setText(""); jtf4.setText("");
					jcb1.setSelectedIndex(0);
					jcb2.setSelectedIndex(0);
					
					jtf2.requestFocus();
				}
			}
		});
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				
				jcb1.setSelectedItem(model.getValueAt(row, 0).toString());
				jcb2.setSelectedItem(model.getValueAt(row, 1).toString());
				
				jtf2.setText(model.getValueAt(row, 2).toString());
				jtf3.setText(model.getValueAt(row, 3).toString());
				jtf4.setText(model.getValueAt(row, 4).toString());

				
			}
		});
		
		jb5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manage();
				dispose();
				
				
				
			}
		});
		
	}
	
	void connect() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="web";
		String password="1234";
		
		//1. 접속할 오라클 드라이버
		try {
			Class.forName(driver);
			
		// 2. 오라클 데이터 베이스와 연결을 시도.
			con =DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}// connect()메서드 end
	
	void comboLoc() {
		
		
		try {
			sql= "select distinct(blocation) from books order by blocation";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String loc= rs.getString("blocation");
				jcb1.addItem(loc);
			}
			rs.close();pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	void comboGenre() {
		
		try {
			sql= "select distinct(bgenre) from books order by bgenre";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String genre= rs.getString("bgenre");
				jcb2.addItem(genre);
			}
			rs.close();pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				

		}
	}
	
	
	void select() {
		try {
			sql="select * from books";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String bloc= rs.getString("BLOCATION");
				String bgenre=rs.getString("BGENRE");
				int bnum= rs.getInt("BNUMBER");
				String bname=rs.getString("BNAME");
				String bwr=rs.getString("BWRITER");
				
				Object[] data= {bloc,bgenre,bnum,bname,bwr};
				model.addRow(data);
			
			}
			rs.close();pstmt.close();con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	void insert() {
		
		try {
			sql="insert into books values (?,?,booknum_seq.nextval,?,?,null,null)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, jcb1.getSelectedItem().toString());
			pstmt.setString(2, jcb2.getSelectedItem().toString());
			pstmt.setString(3, jtf3.getText());
			pstmt.setString(4, jtf4.getText());
			
			int res=pstmt.executeUpdate();
			
			if(res>0) {
				JOptionPane.showMessageDialog(null, "도서 추가 성공!!!!");
			} else {
				JOptionPane.showMessageDialog(null, "도서 추가 실패~~~~");
			}
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void update() {
		
		try {
			sql="update books set blocation =?, bgenre=?, bname=?,bwriter=? where bnumber=? ";
			pstmt= con.prepareStatement(sql);
			
			pstmt.setString(1, jcb1.getSelectedItem().toString());
			pstmt.setString(2, jcb2.getSelectedItem().toString());
			pstmt.setString(3, jtf3.getText());
			pstmt.setString(4, jtf4.getText());
			pstmt.setInt(5, Integer.parseInt(jtf2.getText()));
			
			int res=pstmt.executeUpdate();
			if(res>0) {
				JOptionPane.showMessageDialog(null, "도서 수정 성공!!");
			}else {
				JOptionPane.showMessageDialog(null, "도서 수정 실패!!");
			}
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	void delete() {
		
		
		try {
			sql="delete  from books where bnumber = ?";
			pstmt=con.prepareStatement(sql);
			int row =table.getSelectedRow();
			pstmt.setInt(1, (int)model.getValueAt(row, 2));
			
			int res= pstmt.executeUpdate();
			if(res>0) {
				JOptionPane.showMessageDialog(null, "도서 삭제 성공");
			} else {
				JOptionPane.showMessageDialog(null, "도서 삭제 실패");
			}
			model.removeRow(row);
			pstmt.close();con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	
	

	public static void main(String[] args) {
		new Manage_Manwha();

	}

}
