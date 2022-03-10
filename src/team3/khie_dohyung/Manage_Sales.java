package team3.khie_dohyung;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;






import javax.swing.*;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;




public class Manage_Sales extends JFrame {
	Connection con = null;
	
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	String sql = null;
	DefaultTableModel model;
	JLabel jl1,jl2,jl3;
	
	int sales, total;
	int card, cash;
	
	
	
	JTable table;
	
	public Manage_Sales() {
		
		setTitle("매출관리 화면");
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		
		jl1 = new JLabel("총 매출 :");
		jl2 = new JLabel("카드:");
		jl3 = new JLabel("현금:");
		
		String [] header = {"주문번호","결제메뉴","수량","총금액","메뉴분류","결제방법","결제일"};
		
		model = new DefaultTableModel(header,0);
		table = new JTable(model);
		
		JScrollPane jsp = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton jb1 = new JButton("전체 목록");
		JButton jb2 = new JButton("날짜별 매출");
		JButton jb3 = new JButton("음식별 매출");
		JButton jb4 = new JButton("요금제 매출");
		JButton jb5 = new JButton("돌아 가기");
		
		container1.add(jl1);
		container1.add(jl2);
		container1.add(jl3);
		
		container2.add(jb1);
		container2.add(jb2);
		container2.add(jb3);
		container2.add(jb4);
		container2.add(jb5);
		
		add(container1,BorderLayout.NORTH);
		add(jsp,BorderLayout.CENTER);
		add(container2,BorderLayout.SOUTH);
		
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
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				model.setRowCount(0);
				select();
				sales=0;card=0;cash=0;
				
		

				
				
			}
		});
		
		
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
