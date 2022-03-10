package team3.odermenu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class Receipt extends JFrame {

	private JPanel contentPane;
	private JTextField totalTextField;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	DefaultTableModel model;
	ResultSet res = null;
	String sql = null;
	static JTable table;
	
	
//	String tSale, tAmount;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receipt frame = new Receipt(table);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param jtbl 
	 * @param jtbl 
	 */
	public Receipt(JTable jtbl) {
		
		OrderMenu order = new OrderMenu();
		
		model = (DefaultTableModel) order.cartTable.getModel();
		table = new JTable(model);
		
		
		
		System.out.println("checkout amout : " + order.totalAmount);
		System.out.println("checkout sale : " + order.totalSales);
		System.out.println(order.model);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 300, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel HomePanel = new JPanel();
		HomePanel.setBackground(SystemColor.info);
		
		table = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(jtbl, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JPanel orderPanel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addComponent(orderPanel, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(72, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(33, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(HomePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(table, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(37))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(orderPanel, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(HomePanel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel totalLabel = new JLabel("총금액");
		totalLabel.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		
		
		totalTextField = new JTextField(order.tSales);
		totalTextField.setColumns(10);
		GroupLayout gl_orderPanel = new GroupLayout(orderPanel);
		gl_orderPanel.setHorizontalGroup(
			gl_orderPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_orderPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_orderPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_orderPanel.createSequentialGroup()
							.addComponent(totalLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(totalTextField, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_orderPanel.setVerticalGroup(
			gl_orderPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_orderPanel.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_orderPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(totalLabel)
						.addComponent(totalTextField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		orderPanel.setLayout(gl_orderPanel);
		
		JButton btnHome = new JButton("HOME");
		btnHome.setBackground(SystemColor.window);
		btnHome.setForeground(SystemColor.infoText);
		GroupLayout gl_HomePanel = new GroupLayout(HomePanel);
		gl_HomePanel.setHorizontalGroup(
			gl_HomePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_HomePanel.createSequentialGroup()
					.addGap(107)
					.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(110, Short.MAX_VALUE))
		);
		gl_HomePanel.setVerticalGroup(
			gl_HomePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_HomePanel.createSequentialGroup()
					.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		HomePanel.setLayout(gl_HomePanel);
		contentPane.setLayout(gl_contentPane);
		
		setVisible(true);
		
		
		
		
		btnHome.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				connect();
				

				try {
					
					sql = "insert into test1 values( ?, ?, ?, ?)";
					pstmt = con.prepareStatement(sql);
				
					for(int i = 0; i < model.getRowCount(); i++) {
						
						pstmt.setString(1, model.getValueAt(i, 0).toString());
						pstmt.setInt(2, (Integer)(model.getValueAt(i, 1)));
						pstmt.setInt(3, (Integer)(model.getValueAt(i, 2)));
						pstmt.setString(4,  model.getValueAt(i, 3).toString());
						
						pstmt.executeUpdate();
										
						//pstmt.addBatch();
						//pstmt.clearParameters();

					}

					//pstmt.executeBatch();
					
					con.close();
					pstmt.close();
					
				} catch (Exception e1) {

					e1.printStackTrace();
				}				
				
			}
		});
		
		
		
	} // 생성자 endF

	
	void connect() {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "sooriowl";
		String password = "0641";
		
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	void checkOut() {
		
		
	//	model = (DefaultTableModel) table.getModel();
		
		try {
			
			sql = "insert into test1 values( ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
		
			for(int i = 0; i < model.getRowCount(); i++) {
				
				pstmt.setString(1, model.getValueAt(i, 0).toString());
				pstmt.setInt(2, (Integer)(model.getValueAt(i, 1)));
				pstmt.setInt(3, (Integer)(model.getValueAt(i, 2)));
				pstmt.setString(4,  model.getValueAt(i, 3).toString());
				
				pstmt.executeUpdate();
								
				//pstmt.addBatch();
				//pstmt.clearParameters();

			}

			//pstmt.executeBatch();
			
			con.close();
			pstmt.close();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
