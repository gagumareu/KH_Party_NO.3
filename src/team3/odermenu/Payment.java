package team3.odermenu;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.sql.*;

import team3.khie_dohyung.ManwhaMain;


public class Payment extends JFrame {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	String paySelect;

	String sql = null;
	DefaultTableModel model,model1;
	
	JPanel contentPane;
	static JTable orderTable;
	
	
	
	
//	public JTable getPaytable() {
//		return paytable;
//	}

//	public void setPaytable(JTable paytable) {
//		this.paytable = paytable;
//	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment(orderTable);
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
	
	
	


	
	public Payment(JTable orderTable) {
		
	//	
		
		setTitle("결제 화면");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\JUNGHWAN\\OneDrive\\바탕 화면\\새 폴더\\cartoon\\comic.png"));
		setBackground(SystemColor.window);
//		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(790, 250, 500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel paymentPanel = new JPanel();
		paymentPanel.setBackground(SystemColor.window);
		
		JPanel payButtonPanel = new JPanel();
		payButtonPanel.setBackground(SystemColor.info);
		
		JButton payButton = new JButton("결제 하기");
		payButton.setBackground(SystemColor.window);
		payButton.setForeground(SystemColor.infoText);
		payButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		payButton.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\OneDrive\\바탕 화면\\새 폴더\\cartoon\\coin2.jpg"));
		
		
		final JComboBox<String> payComboBox = new JComboBox<String>();
		payComboBox.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		payComboBox.setModel(new DefaultComboBoxModel(new String[] {"     결제수단 선택", "            카드", "            현금"}));
		payComboBox.setBackground(SystemColor.window);
		GroupLayout gl_payButtonPanel = new GroupLayout(payButtonPanel);
		gl_payButtonPanel.setHorizontalGroup(
			gl_payButtonPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(payButton, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
				.addComponent(payComboBox, 0, 211, Short.MAX_VALUE)
		);
		gl_payButtonPanel.setVerticalGroup(
			gl_payButtonPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_payButtonPanel.createSequentialGroup()
					.addComponent(payComboBox, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
					.addComponent(payButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
		);
		payButtonPanel.setLayout(gl_payButtonPanel);
		
		JPanel BackButtonPanel = new JPanel();
		BackButtonPanel.setBackground(SystemColor.info);
		
		JButton BackButton = new JButton("뒤로가기");
		BackButton.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\OneDrive\\바탕 화면\\새 폴더\\cartoon\\back-button2.jpg"));
		BackButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		BackButton.setBackground(SystemColor.window);
		
		JButton HomeButton = new JButton("HOME");
		HomeButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		HomeButton.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\OneDrive\\바탕 화면\\새 폴더\\cartoon\\home22.jpg"));
		HomeButton.setBackground(SystemColor.window);
		GroupLayout gl_BackButtonPanel = new GroupLayout(BackButtonPanel);
		gl_BackButtonPanel.setHorizontalGroup(
			gl_BackButtonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_BackButtonPanel.createSequentialGroup()
					.addGroup(gl_BackButtonPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(BackButton, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
						.addComponent(HomeButton, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_BackButtonPanel.setVerticalGroup(
			gl_BackButtonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_BackButtonPanel.createSequentialGroup()
					.addComponent(HomeButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
					.addComponent(BackButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
		);
		BackButtonPanel.setLayout(gl_BackButtonPanel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(paymentPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(BackButtonPanel, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
							.addComponent(payButtonPanel, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(paymentPanel, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(payButtonPanel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
						.addComponent(BackButtonPanel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		// 결제창 테이블
//		String[] paymentHeader = 
//			{"주문번호", "이름", "가격", "수량", "분류", "주문날짜"};
//		model = new DefaultTableModel(paymentHeader, 0);
//		table = new JTable(model);
//		table.setBackground(SystemColor.window);
		
		JScrollPane payjsp = new JScrollPane(
				orderTable, 
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
		
		
		HomeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ManwhaMain();
				dispose();
				
			}
		});
		payComboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				String paySelect = payComboBox.getSelectedItem().toString();
			}
		});
		
		
		payButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				connect();
				payment();
				
			}
		});
		
		BackButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				new Food();
				dispose();
			}
		});
		
		
		
	} // 생성자 end
	
	void connect() {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "web";
		String password = "1234";
		
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	void payment() {
		
		
		model1 = new DefaultTableModel();
		orderTable = new JTable(model1);
		
		model = (DefaultTableModel) orderTable.getModel();
		
		try {
			
			sql = "insert into payment values(orderNO_sqe.nextval, ?, ?, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			
			System.out.println(orderTable);
			
		
			for(int i = 0; i < orderTable.getRowCount(); i++) {
				
				
				pstmt.setString(1, orderTable.getValueAt(i, 0).toString());
				pstmt.setInt(2, (Integer)(orderTable.getValueAt(i, 1)));
				pstmt.setInt(3, (Integer)(orderTable.getValueAt(i, 2)));
				pstmt.setString(4,  orderTable.getValueAt(i, 3).toString());
				pstmt.setString(5, paySelect);
				pstmt.executeUpdate();
				
				pstmt.addBatch();
				pstmt.clearParameters();

			}

			pstmt.executeBatch();

		

			
			con.close();
			pstmt.close();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	
	
	
	
	
} 