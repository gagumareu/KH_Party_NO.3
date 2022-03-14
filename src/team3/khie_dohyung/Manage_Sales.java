package team3.khie_dohyung;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;




public class Manage_Sales extends JFrame {
	Connection con = null;
	
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	String sql = null;
	DefaultTableModel model;
	JLabel jl1,jl2,jl3;
	
	int sales, total;
	int card, cash;
	String dat;
	
	SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
	
	
	
	JTable table;
	
	public Manage_Sales() {
		getContentPane().setBackground(SystemColor.info);
		
		setTitle("매출관리 화면");
		
		JPanel container1 = new JPanel();
		container1.setBackground(SystemColor.info);
		JPanel container2 = new JPanel();
		container2.setBackground(SystemColor.info);
		
		jl1 = new JLabel("총 매출:");
		jl2 = new JLabel("카드:");
		jl3 = new JLabel("현금:");
		
		String [] header = {"주문번호","결제메뉴","수량","총금액","메뉴분류","결제방법","결제일"};
		
		model = new DefaultTableModel(header,0);
		table = new JTable(model);
		
		JScrollPane jsp = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton jb1 = new JButton("전체 목록");
		jb1.setBackground(Color.CYAN);
		JButton jb2 = new JButton("선택");
		jb2.setBackground(Color.CYAN);
		
		JButton jb3 = new JButton("음식별 매출");
		jb3.setBackground(Color.CYAN);
		JButton jb4 = new JButton("요금제 매출");
		jb4.setBackground(Color.CYAN);
		JButton jb5 = new JButton("돌아 가기");
		jb5.setBackground(Color.CYAN);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images/제목 없음2.jpg"));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("images/ssales.png"));
		panel.add(lblNewLabel_1);
		
		JDateChooser jdc = new JDateChooser();
		GroupLayout gl_container2 = new GroupLayout(container2);
		gl_container2.setHorizontalGroup(
			gl_container2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_container2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_container2.createSequentialGroup()
							.addGroup(gl_container2.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jb3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jb1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jb4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jb5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap(99, Short.MAX_VALUE))
						.addGroup(gl_container2.createSequentialGroup()
							.addComponent(jdc, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jb2)
							.addGap(35))))
		);
		gl_container2.setVerticalGroup(
			gl_container2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container2.createSequentialGroup()
					.addContainerGap()
					.addComponent(jb1)
					.addGap(10)
					.addGroup(gl_container2.createParallelGroup(Alignment.TRAILING)
						.addComponent(jb2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(jdc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(jb3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jb4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jb5)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		container2.setLayout(gl_container2);
		GroupLayout gl_container1 = new GroupLayout(container1);
		gl_container1.setHorizontalGroup(
			gl_container1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container1.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_container1.createParallelGroup(Alignment.TRAILING)
						.addComponent(jl3)
						.addComponent(jl2)
						.addComponent(jl1))
					.addGap(141))
		);
		gl_container1.setVerticalGroup(
			gl_container1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container1.createSequentialGroup()
					.addContainerGap()
					.addComponent(jl3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jl2)
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addComponent(jl1)
					.addContainerGap())
		);
		container1.setLayout(gl_container1);
		
		
		
		setBounds(200,200,800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				model.setRowCount(0);
				select();
				sales=0;card=0;cash=0;
				
			}
		});
		
		
		
		jdc.getCalendarButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		}
				);
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				model.setRowCount(0);
				dat=sf.format(jdc.getDate());
				selectA();
				sales=0;card=0;cash=0;
				
			}
		
		});
		
	
		
		jl1.setFont(new Font("휴먼편지체",Font.BOLD, 30));
		jl2.setFont(new Font("휴먼편지체",Font.BOLD, 30));
		jl3.setFont(new Font("휴먼편지체",Font.BOLD, 30));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(container2, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(container1, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
				.addComponent(jsp, GroupLayout.PREFERRED_SIZE, 784, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(46)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
							.addComponent(container1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(container2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(jsp, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE))
		);
		getContentPane().setLayout(groupLayout);
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				model.setRowCount(0);
				selectB();
				sales=0;card=0;cash=0;
				
			}
		});
		
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				model.setRowCount(0);
				selectC();
				sales=0;card=0;cash=0;
				
			}
		});
		
		jb5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manage();
				dispose();
				sales=0;card=0;cash=0;
				
			}
		});
		
	}
	
	
	void connect() {
		String driver= "oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="web";
		String password="1234";
				
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url,user,password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	void select() {
		
		
		try {
			sql="select* from payment";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int oderno=rs.getInt("oderno");
				String pname = rs.getString("pname");
				int amount=rs.getInt("amount");
				total=rs.getInt("total");
				String sort=rs.getString("sort");
				String cashtype = rs.getString("cashtype");
				String regdate = rs.getString("regdate").substring(0,10);
				
				
				Object[] data= {oderno,pname,amount,total,sort,cashtype,regdate};
				model.addRow(data);
				sales+=total;
				if(cashtype.equalsIgnoreCase("카드")) {
					card+=total;
							
				} else  {
					cash+=total;
				}
				
			}
			
			
			jl1.setText("총 매출:"+String.format("%,d",sales));
			jl2.setText("카드:"+String.format("%,d",card));
			jl3.setText("현금:"+String.format("%,d",cash));
			
			rs.close();pstmt.close();con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
void selectA() {
		
		
		try {
			sql="select * from payment where regdate=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dat);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int oderno=rs.getInt("oderno");
				String pname = rs.getString("pname");
				int amount=rs.getInt("amount");
				total=rs.getInt("total");
				String sort=rs.getString("sort");
				String cashtype = rs.getString("cashtype");
				String regdate = rs.getString("regdate").substring(0,10);
				
				
				Object[] data= {oderno,pname,amount,total,sort,cashtype,regdate};
				model.addRow(data);
				sales+=total;
				if(cashtype.equalsIgnoreCase("카드")) {
					card+=total;
							
				} else  {
					cash+=total;
				}
				
			}
			
			
			jl1.setText("총 매출:"+String.format("%,d",sales));
			jl2.setText("카드:"+String.format("%,d",card));
			jl3.setText("현금:"+String.format("%,d",cash));
			
			rs.close();pstmt.close();con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
void selectB() {
		
		
		try {
			sql="select* from payment_food";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int oderno=rs.getInt("oderno");
				String pname = rs.getString("pname");
				int amount=rs.getInt("amount");
				total=rs.getInt("total");
				String sort=rs.getString("sort");
				String cashtype = rs.getString("cashtype");
				String regdate = rs.getString("regdate").substring(0,10);
				
				
				Object[] data= {oderno,pname,amount,total,sort,cashtype,regdate};
				model.addRow(data);
				sales+=total;
				if(cashtype.equalsIgnoreCase("카드")) {
					card+=total;
							
				} else  {
					cash+=total;
				}
				
			}
			
			
			jl1.setText("총 매출:"+String.format("%,d",sales));
			jl2.setText("카드:"+String.format("%,d",card));
			jl3.setText("현금:"+String.format("%,d",cash));
			
			rs.close();pstmt.close();con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

void selectC() {
	
	
	try {
		sql="select* from payment_hour";
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			int oderno=rs.getInt("oderno");
			String pname = rs.getString("pname");
			int amount=rs.getInt("amount");
			total=rs.getInt("total");
			String sort=rs.getString("sort");
			String cashtype = rs.getString("cashtype");
			String regdate = rs.getString("regdate").substring(0,10);
			
			
			Object[] data= {oderno,pname,amount,total,sort,cashtype,regdate};
			model.addRow(data);
			sales+=total;
			if(cashtype.equalsIgnoreCase("카드")) {
				card+=total;
						
			} else  {
				cash+=total;
			}
			
		}
		
		
		jl1.setText("총 매출:"+String.format("%,d",sales));
		jl2.setText("카드:"+String.format("%,d",card));
		jl3.setText("현금:"+String.format("%,d",cash));
		
		rs.close();pstmt.close();con.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}




	

	public static void main(String[] args) {
		
		new Manage_Sales();
	}
}
