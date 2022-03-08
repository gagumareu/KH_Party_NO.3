package team3.odermenu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Payment extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
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
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	String sql = null;
	DefaultTableModel model;
	JTable table;
	


	
	public Payment() {
		setTitle("결제 화면");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\JUNGHWAN\\OneDrive\\바탕 화면\\새 폴더\\cartoon\\comic.png"));
		setBackground(SystemColor.window);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 150, 500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel paymentPanel = new JPanel();
		paymentPanel.setBackground(SystemColor.window);
		
		JPanel payButton_1 = new JPanel();
		payButton_1.setBackground(SystemColor.info);
		
		JButton btnNewButton_1 = new JButton("결제 하기");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\OneDrive\\바탕 화면\\새 폴더\\cartoon\\coin2.jpg"));
		btnNewButton_1.setBackground(Color.WHITE);
		GroupLayout gl_payButton_1 = new GroupLayout(payButton_1);
		gl_payButton_1.setHorizontalGroup(
			gl_payButton_1.createParallelGroup(Alignment.LEADING)
				.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
		);
		gl_payButton_1.setVerticalGroup(
			gl_payButton_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_payButton_1.createSequentialGroup()
					.addContainerGap(131, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
		);
		payButton_1.setLayout(gl_payButton_1);
		
		JPanel payButton = new JPanel();
		payButton.setBackground(SystemColor.info);
		
		JButton btnNewButton_1_1 = new JButton("뒤로가기");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\OneDrive\\바탕 화면\\새 폴더\\cartoon\\back-button2.jpg"));
		btnNewButton_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(SystemColor.window);
		
		JButton btnNewButton_1_1_1 = new JButton("HOME");
		btnNewButton_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\OneDrive\\바탕 화면\\새 폴더\\cartoon\\home22.jpg"));
		btnNewButton_1_1_1.setBackground(SystemColor.window);
		GroupLayout gl_payButton = new GroupLayout(payButton);
		gl_payButton.setHorizontalGroup(
			gl_payButton.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_payButton.createSequentialGroup()
					.addGroup(gl_payButton.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_payButton.setVerticalGroup(
			gl_payButton.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_payButton.createSequentialGroup()
					.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
					.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
		);
		payButton.setLayout(gl_payButton);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(paymentPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(payButton, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
							.addComponent(payButton_1, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(paymentPanel, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(payButton_1, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
						.addComponent(payButton, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		// 결제창 테이블
		String[] paymentHeader = 
			{"주문번호", "이름", "가격", "수량", "분류", "주문날짜"};
		model = new DefaultTableModel(paymentHeader, 0);
		table = new JTable(model);
		table.setBackground(SystemColor.window);
		
		JScrollPane payjsp = new JScrollPane(
				table, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_paymentPanel = new GroupLayout(paymentPanel);
		gl_paymentPanel.setHorizontalGroup(
			gl_paymentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(payjsp, GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
		);
		gl_paymentPanel.setVerticalGroup(
			gl_paymentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_paymentPanel.createSequentialGroup()
					.addComponent(payjsp, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		paymentPanel.setLayout(gl_paymentPanel);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
		
		
		
		
		
		
		
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
	
	
	void select() {
		
		
		try {
			sql = "select * from payment";

			pstmt = con.prepareStatement(sql);
			
			res = pstmt.executeQuery();
			
			while(res.next()) {
				int oderno = res.getInt("orderno");
				String fname = res.getString("fname");
				int price = res.getInt("price");
				int amount = res.getInt("amount");
				String type = res.getString("type");
				String regdate = res.getString("ragdate");
				
				Object[] paydate = {oderno, fname, price, amount, type, regdate};
				
				model.addRow(paydate);
				
			}
			res.close();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
			
	}
}
