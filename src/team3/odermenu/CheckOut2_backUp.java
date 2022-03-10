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

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class CheckOut2_backUp extends JFrame {

	private JPanel contentPane;
	private JTextField totalTextField;
	static JTable jtbl;
	JTable cTable;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql;
	
	DefaultTableModel cModel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					CheckOut2_backUp frame = new CheckOut2_backUp(jtbl);
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
	 */
	public CheckOut2_backUp(JTable jtbl) {
		
		OrderMenu2_backUP order = new OrderMenu2_backUP();
		cModel = new DefaultTableModel();
		jtbl = new JTable(cModel);
		
		System.out.println("check out2 amount : " + order.tAmount);
		System.out.println("check out2 sale : " + order.tSale);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 230, 650, 650);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel HomePanel = new JPanel();
		HomePanel.setBackground(SystemColor.info);
		
		JPanel orderPanel = new JPanel();
		
		JLabel totalLabel = new JLabel("총금액");
		totalLabel.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		
		
		totalTextField = new JTextField();
		totalTextField.setColumns(10);
		GroupLayout gl_orderPanel = new GroupLayout(orderPanel);
		gl_orderPanel.setHorizontalGroup(
			gl_orderPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_orderPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(totalLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(totalTextField, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(194, Short.MAX_VALUE))
		);
		gl_orderPanel.setVerticalGroup(
			gl_orderPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_orderPanel.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_orderPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(totalLabel)
						.addComponent(totalTextField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(86, Short.MAX_VALUE))
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addComponent(orderPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(108)
					.addComponent(HomePanel, GroupLayout.PREFERRED_SIZE, 477, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(319)
					.addComponent(orderPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(HomePanel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);
		contentPane.setLayout(gl_contentPane);
		
		setVisible(true);
		
		btnHome.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				checkOut1();
				
			}
		});
		
		
		
		
		
		
	} // 생성자 end
	
	
		
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
	
	void checkOut1() {
		
		
		//	model = (DefaultTableModel) table.getModel();
			
			try {
				
				sql = "insert into test1 values( ?, ?, ?, ?)";
				pstmt = con.prepareStatement(sql);
			
				for(int i = 0; i < cModel.getRowCount(); i++) {
					
					pstmt.setString(1, cModel.getValueAt(i, 0).toString());
					pstmt.setInt(2, (Integer)(cModel.getValueAt(i, 1)));
					pstmt.setInt(3, (Integer)(cModel.getValueAt(i, 2)));
					pstmt.setString(4,  cModel.getValueAt(i, 3).toString());
					
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
