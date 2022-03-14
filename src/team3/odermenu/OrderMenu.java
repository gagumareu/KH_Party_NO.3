package team3.odermenu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import team3.init.MyPage;

import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Member;

import javax.swing.JCheckBox;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class OrderMenu extends JFrame {

	private JPanel contentPane;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderMenu frame = new OrderMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		new OrderMenu();
	}

	
	/**
	 * Create the frame.
	 */
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	String sql = null;
	public DefaultTableModel model;
	public JTable cartTable;
	
	
	JSpinner kimchSpinner, spamSpinner, chickSpinner, ameriSpinner,
	caraSpinner, caferaSpinner, ramyeonSpinner, ddeockSpinner, rabockSpinner;
	JLabel kimchNameLabel, spamNameLabel, chickNameLabel,
	ameriNameLabel, caraNameLabel, caferaNameLabel, ramyeonNameLabel, ddeockNameLabel, rabockNameLabel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	JComboBox chooseComboBox;
	Object choose = null;
	String paySelect;
	int tAmount = 0;
	int tSales = 0;
	JTextField amountTextField;
	JTextField totalTextField;
	int minus = 0;
	int plus = 0;
	private JTextField cashTextField;
	int cash;
	private JTextField changeTextField;
	private JTextField earnCashTextField;
	private JTextField taxTextField;
	private JTextField sysdateTextField;
	
	
	
	
	// 생성자 
	public OrderMenu() {
		
		setTitle("음식 메뉴 주문");
		setIconImage(Toolkit.getDefaultToolkit().getImage(OrderMenu.class.getResource("/team3/odermenu/cartoon/comic.png")));
		
		String[] cartHeader = {"상품명", "수량", "가격", "분류"};
		model = new DefaultTableModel(cartHeader, 0);
		
		setBackground(SystemColor.window);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 150, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane OderTebbedPanel = new JTabbedPane(JTabbedPane.LEFT);
		OderTebbedPanel.setBackground(SystemColor.info);
		
		JPanel ButtonPanal = new JPanel();
		ButtonPanal.setBackground(SystemColor.info);
		
		JButton payButton = new JButton("결제");
		payButton.setFont(new Font("함초롬돋움", Font.BOLD, 25));
		payButton.setBackground(SystemColor.window);
		payButton.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/valid2.jpg")));
		
		chooseComboBox = new JComboBox();
		chooseComboBox.setFont(new Font("함초롬돋움", Font.PLAIN, 18));
		chooseComboBox.setBackground(SystemColor.window);
		chooseComboBox.setModel(new DefaultComboBoxModel(new String[] {" 결제수단선택", "카드", "현금"}));
		
		cashTextField = new JTextField();
		cashTextField.setToolTipText("");
		cashTextField.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		cashTextField.setColumns(10);
		cashTextField.setBackground(SystemColor.window);
		
		JButton cashPlzButton = new JButton("현금 입금");
		cashPlzButton.setFont(new Font("한컴산뜻돋움", Font.BOLD, 16));
		cashPlzButton.setBackground(SystemColor.window);
		cashPlzButton.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/left-arrow.jpg")));
		
		JButton deleteAllButton = new JButton(" 전체 삭제\r\n");
		deleteAllButton.setBackground(SystemColor.window);
		deleteAllButton.setFont(new Font("함초롬돋움", Font.BOLD, 25));
		

		
		deleteAllButton.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
//				underBalanceField.setText(null);
//				underAmountField.setText(null);
				tAmount = 0;
				tSales = 0;
		}
	});
		
		JButton removeButton = new JButton("");
		removeButton.setFont(new Font("굴림", Font.BOLD, 17));
		
		
		removeButton.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/삭제2.jpg")));
		removeButton.setBackground(SystemColor.window);
		
	////  요금제 버튼 끝 //////	
		
		//삭제 버튼
		removeButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {				
				removerow();								
			}
		});
		
		JButton homeButton = new JButton("HOME");
		homeButton.setFont(new Font("함초롬돋움", Font.BOLD, 23));
		homeButton.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/home22.jpg")));
		homeButton.setBackground(SystemColor.window);
		GroupLayout gl_ButtonPanal = new GroupLayout(ButtonPanal);
		gl_ButtonPanal.setHorizontalGroup(
			gl_ButtonPanal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ButtonPanal.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ButtonPanal.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ButtonPanal.createSequentialGroup()
							.addGroup(gl_ButtonPanal.createParallelGroup(Alignment.LEADING, false)
								.addComponent(homeButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(removeButton, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(payButton, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
						.addGroup(gl_ButtonPanal.createSequentialGroup()
							.addGroup(gl_ButtonPanal.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(deleteAllButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(chooseComboBox, 0, 173, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_ButtonPanal.createParallelGroup(Alignment.TRAILING)
								.addComponent(cashPlzButton, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
								.addComponent(cashTextField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))))
					.addGap(8))
		);
		gl_ButtonPanal.setVerticalGroup(
			gl_ButtonPanal.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_ButtonPanal.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_ButtonPanal.createParallelGroup(Alignment.BASELINE)
						.addComponent(chooseComboBox, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(cashTextField, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_ButtonPanal.createParallelGroup(Alignment.TRAILING)
						.addComponent(deleteAllButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addComponent(cashPlzButton, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_ButtonPanal.createParallelGroup(Alignment.LEADING, false)
						.addComponent(payButton, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_ButtonPanal.createSequentialGroup()
							.addComponent(removeButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(homeButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
					.addGap(8))
		);
		ButtonPanal.setLayout(gl_ButtonPanal);
		
		JPanel timeTablePanel = new JPanel();
		timeTablePanel.setBackground(SystemColor.window);
		OderTebbedPanel.addTab("시간", new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/times2.jpg")), timeTablePanel);
		
		JPanel costPanel = new JPanel();
		costPanel.setBackground(SystemColor.window);
		
		JPanel oneHourPanel = new JPanel();
		oneHourPanel.setBackground(SystemColor.window);
		
		JLabel oneImageLabel = new JLabel("");
		oneImageLabel.setBackground(SystemColor.window);
		oneImageLabel.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/1hours.jpg")));
		
		JLabel onePriceLabel = new JLabel("1,000원");
		onePriceLabel.setFont(new Font("한컴 고딕", Font.BOLD, 19));
		onePriceLabel.setBackground(SystemColor.window);
		
		JButton oneButton = new JButton("1시간 추가");
		oneButton.setBackground(SystemColor.window);
		oneButton.setFont(new Font("한컴 고딕", Font.BOLD, 17));
		GroupLayout gl_oneHourPanel = new GroupLayout(oneHourPanel);
		gl_oneHourPanel.setHorizontalGroup(
			gl_oneHourPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_oneHourPanel.createSequentialGroup()
					.addGroup(gl_oneHourPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_oneHourPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(oneButton))
						.addGroup(gl_oneHourPanel.createSequentialGroup()
							.addGap(34)
							.addComponent(onePriceLabel))
						.addGroup(gl_oneHourPanel.createSequentialGroup()
							.addGap(26)
							.addComponent(oneImageLabel)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_oneHourPanel.setVerticalGroup(
			gl_oneHourPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_oneHourPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(oneImageLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(oneButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(onePriceLabel)
					.addGap(5))
		);
		oneHourPanel.setLayout(gl_oneHourPanel);
		
		JPanel twoHourPanel = new JPanel();
		twoHourPanel.setBackground(SystemColor.window);
		
		JLabel twoPriceLabel = new JLabel("2,000원");
		twoPriceLabel.setFont(new Font("한컴 고딕", Font.BOLD, 19));
		twoPriceLabel.setBackground(Color.WHITE);
		
		JButton twoButton = new JButton("2시간 추가");
		twoButton.setFont(new Font("한컴 고딕", Font.BOLD, 17));
		twoButton.setBackground(Color.WHITE);
		
		JLabel twoImageLabel = new JLabel("");
		twoImageLabel.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/22.jpg")));
		twoImageLabel.setBackground(SystemColor.window);
		GroupLayout gl_twoHourPanel = new GroupLayout(twoHourPanel);
		gl_twoHourPanel.setHorizontalGroup(
			gl_twoHourPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_twoHourPanel.createSequentialGroup()
					.addGroup(gl_twoHourPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_twoHourPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(twoButton))
						.addGroup(gl_twoHourPanel.createSequentialGroup()
							.addGap(34)
							.addComponent(twoPriceLabel)))
					.addContainerGap(21, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_twoHourPanel.createSequentialGroup()
					.addContainerGap(34, Short.MAX_VALUE)
					.addComponent(twoImageLabel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
		);
		gl_twoHourPanel.setVerticalGroup(
			gl_twoHourPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_twoHourPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(twoImageLabel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(twoButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(twoPriceLabel)
					.addGap(5))
		);
		twoHourPanel.setLayout(gl_twoHourPanel);
		
		JPanel threeHourPanel = new JPanel();
		threeHourPanel.setBackground(SystemColor.window);
		
		JLabel threePriceLabel = new JLabel("3,000원");
		threePriceLabel.setFont(new Font("한컴 고딕", Font.BOLD, 19));
		threePriceLabel.setBackground(Color.WHITE);
		
		JButton threeButton = new JButton("3시간 추가");
		threeButton.setFont(new Font("한컴 고딕", Font.BOLD, 17));
		threeButton.setBackground(SystemColor.window);
		
		JLabel threeImageLabel = new JLabel("");
		threeImageLabel.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/33.jpg")));
		threeImageLabel.setBackground(SystemColor.window);
		GroupLayout gl_threeHourPanel = new GroupLayout(threeHourPanel);
		gl_threeHourPanel.setHorizontalGroup(
			gl_threeHourPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_threeHourPanel.createSequentialGroup()
					.addGroup(gl_threeHourPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_threeHourPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(threeButton))
						.addGroup(gl_threeHourPanel.createSequentialGroup()
							.addGap(34)
							.addComponent(threePriceLabel)))
					.addContainerGap(21, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_threeHourPanel.createSequentialGroup()
					.addContainerGap(34, Short.MAX_VALUE)
					.addComponent(threeImageLabel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
		);
		gl_threeHourPanel.setVerticalGroup(
			gl_threeHourPanel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 164, Short.MAX_VALUE)
				.addGroup(gl_threeHourPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(threeImageLabel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(threeButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(threePriceLabel)
					.addGap(5))
		);
		threeHourPanel.setLayout(gl_threeHourPanel);
		
		JPanel sixHourPanel = new JPanel();
		sixHourPanel.setBackground(SystemColor.window);
		
		JLabel sixPriceLabel = new JLabel("5,000원");
		sixPriceLabel.setFont(new Font("한컴 고딕", Font.BOLD, 19));
		sixPriceLabel.setBackground(SystemColor.window);
		
		JButton sixButton = new JButton("6시간 추가");
		sixButton.setFont(new Font("한컴 고딕", Font.BOLD, 17));
		sixButton.setBackground(SystemColor.window);
		
		JLabel sixImageLabel = new JLabel("");
		sixImageLabel.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/66.jpg")));
		sixImageLabel.setBackground(SystemColor.window);
		GroupLayout gl_sixHourPanel = new GroupLayout(sixHourPanel);
		gl_sixHourPanel.setHorizontalGroup(
			gl_sixHourPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_sixHourPanel.createSequentialGroup()
					.addGroup(gl_sixHourPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_sixHourPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(sixButton))
						.addGroup(gl_sixHourPanel.createSequentialGroup()
							.addGap(34)
							.addComponent(sixPriceLabel))
						.addGroup(gl_sixHourPanel.createSequentialGroup()
							.addGap(27)
							.addComponent(sixImageLabel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_sixHourPanel.setVerticalGroup(
			gl_sixHourPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_sixHourPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(sixImageLabel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(sixButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sixPriceLabel)
					.addGap(5))
		);
		sixHourPanel.setLayout(gl_sixHourPanel);
		
		JPanel twelHourPanel = new JPanel();
		twelHourPanel.setBackground(Color.WHITE);
		
		JLabel sixImageLabel_1 = new JLabel("");
		sixImageLabel_1.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/12.jpg")));
		sixImageLabel_1.setBackground(SystemColor.window);
		
		JButton twelButton = new JButton("12시간 추가");
		twelButton.setFont(new Font("한컴 고딕", Font.BOLD, 17));
		twelButton.setBackground(SystemColor.window);
		
		JLabel twelPriceLabel = new JLabel("8,000원");
		twelPriceLabel.setFont(new Font("한컴 고딕", Font.BOLD, 19));
		twelPriceLabel.setBackground(SystemColor.window);
		GroupLayout gl_twelHourPanel = new GroupLayout(twelHourPanel);
		gl_twelHourPanel.setHorizontalGroup(
			gl_twelHourPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 146, Short.MAX_VALUE)
				.addGroup(gl_twelHourPanel.createSequentialGroup()
					.addGroup(gl_twelHourPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_twelHourPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(twelButton))
						.addGroup(gl_twelHourPanel.createSequentialGroup()
							.addGap(34)
							.addComponent(twelPriceLabel))
						.addGroup(gl_twelHourPanel.createSequentialGroup()
							.addGap(27)
							.addComponent(sixImageLabel_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_twelHourPanel.setVerticalGroup(
			gl_twelHourPanel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 164, Short.MAX_VALUE)
				.addGroup(gl_twelHourPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(sixImageLabel_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(twelButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(twelPriceLabel)
					.addGap(5))
		);
		twelHourPanel.setLayout(gl_twelHourPanel);
		
		JPanel twenHourPanel = new JPanel();
		twenHourPanel.setBackground(SystemColor.window);
		
		JLabel twenImageLabel = new JLabel("");
		twenImageLabel.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/24.jpg")));
		twenImageLabel.setBackground(SystemColor.window);
		
		JButton twenButton = new JButton("24시간 추가");
		twenButton.setFont(new Font("한컴 고딕", Font.BOLD, 17));
		twenButton.setBackground(SystemColor.window);
		
		JLabel twenPriceLabel = new JLabel("12,000원");
		twenPriceLabel.setFont(new Font("한컴 고딕", Font.BOLD, 19));
		twenPriceLabel.setBackground(SystemColor.window);
		GroupLayout gl_twenHourPanel = new GroupLayout(twenHourPanel);
		gl_twenHourPanel.setHorizontalGroup(
			gl_twenHourPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 146, Short.MAX_VALUE)
				.addGap(0, 146, Short.MAX_VALUE)
				.addGroup(gl_twenHourPanel.createSequentialGroup()
					.addGroup(gl_twenHourPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_twenHourPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(twenButton))
						.addGroup(gl_twenHourPanel.createSequentialGroup()
							.addGap(34)
							.addComponent(twenPriceLabel))
						.addGroup(gl_twenHourPanel.createSequentialGroup()
							.addGap(27)
							.addComponent(twenImageLabel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_twenHourPanel.setVerticalGroup(
			gl_twenHourPanel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 164, Short.MAX_VALUE)
				.addGap(0, 164, Short.MAX_VALUE)
				.addGroup(gl_twenHourPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(twenImageLabel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(twenButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(twenPriceLabel)
					.addGap(5))
		);
		twenHourPanel.setLayout(gl_twenHourPanel);
		GroupLayout gl_costPanel = new GroupLayout(costPanel);
		gl_costPanel.setHorizontalGroup(
			gl_costPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_costPanel.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_costPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(oneHourPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(sixHourPanel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addGroup(gl_costPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(twoHourPanel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addComponent(twelHourPanel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
					.addGap(61)
					.addGroup(gl_costPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(twenHourPanel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addComponent(threeHourPanel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
					.addGap(49))
		);
		gl_costPanel.setVerticalGroup(
			gl_costPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_costPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_costPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(twoHourPanel, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
						.addComponent(threeHourPanel, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
						.addComponent(oneHourPanel, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_costPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(sixHourPanel, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
						.addComponent(twelHourPanel, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
						.addComponent(twenHourPanel, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		costPanel.setLayout(gl_costPanel);
		GroupLayout gl_timeTablePanel = new GroupLayout(timeTablePanel);
		gl_timeTablePanel.setHorizontalGroup(
			gl_timeTablePanel.createParallelGroup(Alignment.TRAILING)
				.addComponent(costPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
		);
		gl_timeTablePanel.setVerticalGroup(
			gl_timeTablePanel.createParallelGroup(Alignment.TRAILING)
				.addComponent(costPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
		);
		timeTablePanel.setLayout(gl_timeTablePanel);
		
		JPanel mealpanel = new JPanel();
		mealpanel.setBackground(SystemColor.window);
		OderTebbedPanel.addTab("식사", new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/dish.png")), mealpanel);
		
		JPanel kimPanel = new JPanel();
		kimPanel.setBackground(Color.WHITE);
		
		kimchSpinner = new JSpinner();
		kimchSpinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		kimchSpinner.setForeground(Color.WHITE);
		kimchSpinner.setBackground(SystemColor.window);
		
		JButton kimchAddButton = new JButton("담기");
		kimchAddButton.setBackground(SystemColor.window);
		
		
		
		
		JLabel kimchImageLabel = new JLabel("");
		kimchImageLabel.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/김치베이컨2.jpg")));
		kimchImageLabel.setBackground(SystemColor.window);
		
		kimchNameLabel = new JLabel("김치베이컨 볶음밥");
		kimchNameLabel.setBackground(SystemColor.window);
		
		JLabel kimchPriceLabel = new JLabel("5,900원");
		kimchPriceLabel.setBackground(SystemColor.window);
		GroupLayout gl_kimPanel = new GroupLayout(kimPanel);
		gl_kimPanel.setHorizontalGroup(
			gl_kimPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_kimPanel.createSequentialGroup()
					.addGroup(gl_kimPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_kimPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_kimPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_kimPanel.createSequentialGroup()
									.addComponent(kimchSpinner, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(kimchAddButton))
								.addComponent(kimchImageLabel)))
						.addGroup(gl_kimPanel.createSequentialGroup()
							.addGap(53)
							.addComponent(kimchPriceLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_kimPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(kimchNameLabel)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_kimPanel.setVerticalGroup(
			gl_kimPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_kimPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(kimchImageLabel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_kimPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(kimchSpinner, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(kimchAddButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(kimchNameLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(kimchPriceLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		kimPanel.setLayout(gl_kimPanel);
		
		JPanel chickPanel = new JPanel();
		chickPanel.setBackground(Color.WHITE);
		
		chickSpinner = new JSpinner();
		chickSpinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		chickSpinner.setForeground(Color.WHITE);
		chickSpinner.setBackground(SystemColor.window);
		
		JButton chickAddButton = new JButton("담기");
		chickAddButton.setBackground(SystemColor.window);
		
		JLabel chicImageLabel = new JLabel("");
		chicImageLabel.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/치킨가라아게덥밥2.jpg")));
		chicImageLabel.setBackground(SystemColor.window);
		
		chickNameLabel = new JLabel("치킨 가라아게 덮밥");
		chickNameLabel.setBackground(SystemColor.window);
		
		JLabel chickPriceLabel = new JLabel("5,900원");
		chickPriceLabel.setBackground(SystemColor.window);
		GroupLayout gl_chickPanel = new GroupLayout(chickPanel);
		gl_chickPanel.setHorizontalGroup(
			gl_chickPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_chickPanel.createSequentialGroup()
					.addGroup(gl_chickPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_chickPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_chickPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_chickPanel.createSequentialGroup()
									.addComponent(chickSpinner, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(chickAddButton))
								.addComponent(chicImageLabel)))
						.addGroup(gl_chickPanel.createSequentialGroup()
							.addGap(50)
							.addComponent(chickPriceLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_chickPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(chickNameLabel, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_chickPanel.setVerticalGroup(
			gl_chickPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_chickPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(chicImageLabel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_chickPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chickSpinner, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(chickAddButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chickNameLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chickPriceLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		chickPanel.setLayout(gl_chickPanel);
		
		JPanel spamPanel = new JPanel();
		spamPanel.setBackground(Color.WHITE);
		
		spamSpinner = new JSpinner();
		spamSpinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spamSpinner.setForeground(Color.WHITE);
		spamSpinner.setBackground(SystemColor.window);
		
		JButton spamAddButton = new JButton("담기");
		spamAddButton.setBackground(SystemColor.window);
		
		JLabel spamImageLabel = new JLabel("");
		spamImageLabel.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/스펨계란볶음밥2.jpg")));
		spamImageLabel.setBackground(SystemColor.window);
		
		spamNameLabel = new JLabel("스팸계란 볶음밥");
		spamNameLabel.setBackground(Color.WHITE);
		
		JLabel spamPriceLabel = new JLabel("5,900원");
		spamPriceLabel.setBackground(Color.WHITE);
		GroupLayout gl_spamPanel = new GroupLayout(spamPanel);
		gl_spamPanel.setHorizontalGroup(
			gl_spamPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_spamPanel.createSequentialGroup()
					.addContainerGap(54, Short.MAX_VALUE)
					.addComponent(spamPriceLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(45))
				.addGroup(gl_spamPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_spamPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_spamPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(spamNameLabel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_spamPanel.createSequentialGroup()
							.addComponent(spamSpinner, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spamAddButton))
						.addComponent(spamImageLabel))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_spamPanel.setVerticalGroup(
			gl_spamPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_spamPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(spamImageLabel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_spamPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(spamSpinner, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(spamAddButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spamNameLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(spamPriceLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		spamPanel.setLayout(gl_spamPanel);
		GroupLayout gl_mealpanel = new GroupLayout(mealpanel);
		gl_mealpanel.setHorizontalGroup(
			gl_mealpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mealpanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(kimPanel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addGap(78)
					.addComponent(spamPanel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
					.addComponent(chickPanel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_mealpanel.setVerticalGroup(
			gl_mealpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mealpanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_mealpanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(kimPanel, GroupLayout.PREFERRED_SIZE, 229, Short.MAX_VALUE)
						.addComponent(spamPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(chickPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(134, Short.MAX_VALUE))
		);
		mealpanel.setLayout(gl_mealpanel);
		
		JPanel drinkPanel = new JPanel();
		drinkPanel.setBackground(SystemColor.window);
		OderTebbedPanel.addTab("음료", new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/drink.png")), drinkPanel);
		
		JPanel ameriPanel = new JPanel();
		ameriPanel.setBackground(Color.WHITE);
		
		ameriSpinner = new JSpinner();
		ameriSpinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		ameriSpinner.setForeground(Color.WHITE);
		ameriSpinner.setBackground(SystemColor.window);
		
		JButton ameriAddButton = new JButton("담기");
		ameriAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ameriAddButton.setBackground(SystemColor.window);
		
		JLabel ameriImageLabel = new JLabel("");
		ameriImageLabel.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/아이스아메리카노2.png")));
		ameriImageLabel.setBackground(SystemColor.window);
		
		ameriNameLabel = new JLabel("아메리카노");
		ameriNameLabel.setBackground(SystemColor.window);
		
		JLabel ameriPriceLabel = new JLabel("3,000원");
		ameriPriceLabel.setBackground(Color.WHITE);
		GroupLayout gl_ameriPanel = new GroupLayout(ameriPanel);
		gl_ameriPanel.setHorizontalGroup(
			gl_ameriPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ameriPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ameriPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ameriPanel.createSequentialGroup()
							.addComponent(ameriSpinner, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ameriAddButton))
						.addComponent(ameriImageLabel)
						.addGroup(gl_ameriPanel.createSequentialGroup()
							.addGap(39)
							.addComponent(ameriPriceLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(13, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_ameriPanel.createSequentialGroup()
					.addContainerGap(42, Short.MAX_VALUE)
					.addComponent(ameriNameLabel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(34))
		);
		gl_ameriPanel.setVerticalGroup(
			gl_ameriPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ameriPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(ameriImageLabel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ameriPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ameriSpinner, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(ameriAddButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ameriNameLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ameriPriceLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(135, Short.MAX_VALUE))
		);
		ameriPanel.setLayout(gl_ameriPanel);
		
		JPanel caramelPanel = new JPanel();
		caramelPanel.setBackground(SystemColor.window);
		
		caraSpinner = new JSpinner();
		caraSpinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		caraSpinner.setForeground(Color.WHITE);
		caraSpinner.setBackground(SystemColor.window);
		
		JButton caraAddButton = new JButton("담기");
		caraAddButton.setBackground(SystemColor.window);
		
		JLabel caraImageLabel = new JLabel("");
		caraImageLabel.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/카라멜마끼아또4.jpg")));
		caraImageLabel.setBackground(SystemColor.window);
		
		caraNameLabel = new JLabel("카라멜마끼아또");
		caraNameLabel.setBackground(SystemColor.window);
		
		JLabel caraPriceLabel = new JLabel("4,300원");
		caraPriceLabel.setBackground(SystemColor.window);
		GroupLayout gl_caramelPanel = new GroupLayout(caramelPanel);
		gl_caramelPanel.setHorizontalGroup(
			gl_caramelPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_caramelPanel.createSequentialGroup()
					.addGroup(gl_caramelPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_caramelPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(caraSpinner, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(caraAddButton))
						.addGroup(gl_caramelPanel.createSequentialGroup()
							.addGap(30)
							.addComponent(caraImageLabel))
						.addGroup(gl_caramelPanel.createSequentialGroup()
							.addGap(53)
							.addComponent(caraPriceLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_caramelPanel.createSequentialGroup()
					.addContainerGap(27, Short.MAX_VALUE)
					.addComponent(caraNameLabel, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_caramelPanel.setVerticalGroup(
			gl_caramelPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_caramelPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(caraImageLabel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_caramelPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(caraSpinner, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(caraAddButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(caraNameLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(caraPriceLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(292, Short.MAX_VALUE))
		);
		caramelPanel.setLayout(gl_caramelPanel);
		
		JPanel caferaPanel = new JPanel();
		caferaPanel.setBackground(Color.WHITE);
		
		caferaSpinner = new JSpinner();
		caferaSpinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		caferaSpinner.setForeground(Color.WHITE);
		caferaSpinner.setBackground(SystemColor.window);
		
		JButton caferaAddButton = new JButton("담기");
		caferaAddButton.setBackground(SystemColor.window);
		
		JLabel caferaImageLabel = new JLabel("");
		caferaImageLabel.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/카페라떼3.jpg")));
		caferaImageLabel.setBackground(SystemColor.window);
		
		caferaNameLabel = new JLabel("카페라떼");
		caferaNameLabel.setBackground(SystemColor.window);
		
		JLabel caferaPriceLabel = new JLabel("3,800원");
		caferaPriceLabel.setBackground(SystemColor.window);
		GroupLayout gl_caferaPanel = new GroupLayout(caferaPanel);
		gl_caferaPanel.setHorizontalGroup(
			gl_caferaPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_caferaPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(caferaSpinner, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(caferaAddButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_caferaPanel.createSequentialGroup()
					.addContainerGap(35, Short.MAX_VALUE)
					.addComponent(caferaImageLabel)
					.addGap(28))
				.addGroup(gl_caferaPanel.createSequentialGroup()
					.addGap(53)
					.addComponent(caferaPriceLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(46, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_caferaPanel.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addComponent(caferaNameLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
		);
		gl_caferaPanel.setVerticalGroup(
			gl_caferaPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_caferaPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(caferaImageLabel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_caferaPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(caferaSpinner, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(caferaAddButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(caferaNameLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(caferaPriceLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(152, Short.MAX_VALUE))
		);
		caferaPanel.setLayout(gl_caferaPanel);
		GroupLayout gl_drinkPanel = new GroupLayout(drinkPanel);
		gl_drinkPanel.setHorizontalGroup(
			gl_drinkPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_drinkPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(ameriPanel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addGap(77)
					.addComponent(caferaPanel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
					.addComponent(caramelPanel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_drinkPanel.setVerticalGroup(
			gl_drinkPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_drinkPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_drinkPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(ameriPanel, GroupLayout.PREFERRED_SIZE, 226, Short.MAX_VALUE)
						.addComponent(caferaPanel, 0, 0, Short.MAX_VALUE)
						.addComponent(caramelPanel, 0, 0, Short.MAX_VALUE))
					.addContainerGap(267, Short.MAX_VALUE))
		);
		drinkPanel.setLayout(gl_drinkPanel);
		
		JPanel snackPanel = new JPanel();
		snackPanel.setBackground(SystemColor.window);
		OderTebbedPanel.addTab("스낵", new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/snack.png")), snackPanel);
		
		JPanel ramyeonPanel = new JPanel();
		ramyeonPanel.setBackground(SystemColor.window);
		
		JPanel ddeockPanl = new JPanel();
		ddeockPanl.setBackground(Color.WHITE);
		
		JLabel ddeockImageLabel = new JLabel("");
		ddeockImageLabel.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/떡볶이2.jpg")));
		ddeockImageLabel.setBackground(SystemColor.window);
		
		ddeockSpinner = new JSpinner();
		ddeockSpinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		ddeockSpinner.setForeground(SystemColor.window);
		ddeockSpinner.setBackground(SystemColor.window);
		
		JButton ddeockAddButton = new JButton("담기");
		ddeockAddButton.setBackground(Color.WHITE);
		
		ddeockNameLabel = new JLabel("떡볶이");
		ddeockNameLabel.setBackground(SystemColor.window);
		
		JLabel ddeockPriceLabel = new JLabel("4,500원");
		ddeockPriceLabel.setBackground(SystemColor.window);
		GroupLayout gl_ddeockPanl = new GroupLayout(ddeockPanl);
		gl_ddeockPanl.setHorizontalGroup(
			gl_ddeockPanl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ddeockPanl.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ddeockPanl.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ddeockPanl.createSequentialGroup()
							.addComponent(ddeockSpinner, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ddeockAddButton))
						.addComponent(ddeockImageLabel))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_ddeockPanl.createSequentialGroup()
					.addContainerGap(51, Short.MAX_VALUE)
					.addGroup(gl_ddeockPanl.createParallelGroup(Alignment.TRAILING)
						.addComponent(ddeockNameLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(ddeockPriceLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
					.addGap(49))
		);
		gl_ddeockPanl.setVerticalGroup(
			gl_ddeockPanl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ddeockPanl.createSequentialGroup()
					.addContainerGap()
					.addComponent(ddeockImageLabel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ddeockPanl.createParallelGroup(Alignment.BASELINE)
						.addComponent(ddeockSpinner, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(ddeockAddButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ddeockNameLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ddeockPriceLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(160, Short.MAX_VALUE))
		);
		ddeockPanl.setLayout(gl_ddeockPanl);
		
		JPanel rabockPanel = new JPanel();
		rabockPanel.setBackground(SystemColor.window);
		
		JLabel rabockImageLabel = new JLabel("");
		rabockImageLabel.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/라볶이2.jpg")));
		rabockImageLabel.setBackground(SystemColor.window);
		
		rabockSpinner = new JSpinner();
		rabockSpinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		rabockSpinner.setForeground(Color.WHITE);
		rabockSpinner.setBackground(SystemColor.window);
		
		JButton rabockAddButton = new JButton("담기");
		rabockAddButton.setBackground(SystemColor.window);
		
		rabockNameLabel = new JLabel("라볶이");
		rabockNameLabel.setBackground(SystemColor.window);
		
		JLabel rabockPriceLabel = new JLabel("5,000원");
		rabockPriceLabel.setBackground(Color.WHITE);
		GroupLayout gl_rabockPanel = new GroupLayout(rabockPanel);
		gl_rabockPanel.setHorizontalGroup(
			gl_rabockPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rabockPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_rabockPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_rabockPanel.createSequentialGroup()
							.addComponent(rabockSpinner, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rabockAddButton))
						.addComponent(rabockImageLabel))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_rabockPanel.createSequentialGroup()
					.addContainerGap(54, Short.MAX_VALUE)
					.addGroup(gl_rabockPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(rabockNameLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(rabockPriceLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
					.addGap(46))
		);
		gl_rabockPanel.setVerticalGroup(
			gl_rabockPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rabockPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(rabockImageLabel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_rabockPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rabockSpinner, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(rabockAddButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rabockNameLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rabockPriceLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(111, Short.MAX_VALUE))
		);
		rabockPanel.setLayout(gl_rabockPanel);
		GroupLayout gl_snackPanel = new GroupLayout(snackPanel);
		gl_snackPanel.setHorizontalGroup(
			gl_snackPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_snackPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(ramyeonPanel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addGap(78)
					.addComponent(ddeockPanl, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
					.addComponent(rabockPanel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_snackPanel.setVerticalGroup(
			gl_snackPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_snackPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_snackPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(rabockPanel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(ddeockPanl, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(ramyeonPanel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 228, Short.MAX_VALUE))
					.addContainerGap(249, Short.MAX_VALUE))
		);
		
		JLabel ramyeonImageLabel = new JLabel("");
		ramyeonImageLabel.setBackground(SystemColor.window);
		ramyeonImageLabel.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/ramyeon2.jpg")));
		
		ramyeonSpinner = new JSpinner();
		ramyeonSpinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		ramyeonSpinner.setForeground(SystemColor.window);
		ramyeonSpinner.setBackground(SystemColor.window);
		
		JButton ramyeonAddButton = new JButton("담기");
		ramyeonAddButton.setBackground(SystemColor.window);
		
		ramyeonNameLabel = new JLabel("라면");
		ramyeonNameLabel.setBackground(SystemColor.window);
		
		JLabel rameyonPriceLabel = new JLabel("3,500원");
		rameyonPriceLabel.setBackground(Color.WHITE);
		GroupLayout gl_ramyeonPanel = new GroupLayout(ramyeonPanel);
		gl_ramyeonPanel.setHorizontalGroup(
			gl_ramyeonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ramyeonPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ramyeonPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ramyeonPanel.createSequentialGroup()
							.addComponent(ramyeonSpinner, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ramyeonAddButton))
						.addComponent(ramyeonImageLabel))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_ramyeonPanel.createSequentialGroup()
					.addContainerGap(51, Short.MAX_VALUE)
					.addGroup(gl_ramyeonPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(rameyonPriceLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addComponent(ramyeonNameLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(49))
		);
		gl_ramyeonPanel.setVerticalGroup(
			gl_ramyeonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ramyeonPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(ramyeonImageLabel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ramyeonPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ramyeonSpinner, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(ramyeonAddButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ramyeonNameLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rameyonPriceLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		ramyeonPanel.setLayout(gl_ramyeonPanel);
		snackPanel.setLayout(gl_snackPanel);
		cartTable = new JTable(model);
		cartTable.setBackground(SystemColor.window);
		
		JScrollPane carjsp = new JScrollPane(cartTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(OderTebbedPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(carjsp, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
						.addComponent(ButtonPanal, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(OderTebbedPanel, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addComponent(panel, 0, 0, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(ButtonPanal, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
						.addComponent(carjsp, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
					.addGap(22))
		);
		
		JLabel receipPabel = new JLabel("     RECEIPT");
		receipPabel.setIcon(new ImageIcon(OrderMenu.class.getResource("/team3/odermenu/cartoon/loge2.jpg")));
		receipPabel.setFont(new Font("NSimSun", Font.BOLD | Font.ITALIC, 27));
		receipPabel.setBackground(SystemColor.info);
		
		amountTextField = new JTextField();
		amountTextField.setFont(new Font("한컴산뜻돋움", Font.BOLD, 21));
		amountTextField.setBackground(SystemColor.window);
		amountTextField.setColumns(10);
		
		totalTextField = new JTextField();
		totalTextField.setFont(new Font("함초롬돋움", Font.BOLD, 25));
		totalTextField.setColumns(10);
		totalTextField.setBackground(SystemColor.window);
		
		changeTextField = new JTextField();
		changeTextField.setFont(new Font("함초롬돋움", Font.BOLD, 17));
		changeTextField.setColumns(10);
		changeTextField.setBackground(SystemColor.window);
		
		earnCashTextField = new JTextField();
		earnCashTextField.setFont(new Font("함초롬돋움", Font.BOLD, 17));
		earnCashTextField.setColumns(10);
		earnCashTextField.setBackground(SystemColor.window);
		
		taxTextField = new JTextField();
		taxTextField.setFont(new Font("함초롬돋움", Font.BOLD, 23));
		taxTextField.setColumns(10);
		taxTextField.setBackground(SystemColor.window);
		
		sysdateTextField = new JTextField();
		sysdateTextField.setFont(new Font("함초롬돋움", Font.BOLD, 27));
		sysdateTextField.setColumns(10);
		sysdateTextField.setBackground(SystemColor.window);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("----------------------------------------------------------------------------------");
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("----------------------------------------------------------------------------------");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(25)
							.addComponent(receipPabel, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(25)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(sysdateTextField, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
								.addComponent(amountTextField, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(totalTextField, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
								.addComponent(taxTextField, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(25)
							.addComponent(earnCashTextField, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(changeTextField, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(12)
					.addComponent(receipPabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(sysdateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(amountTextField, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(totalTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(taxTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(earnCashTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(changeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);	
		setVisible(true);

		
		
///////////////////////////////////    담기 버튼 액션        ///////////////////////////////////////////////////////////////////////////
		
		// 식사 버튼
		kimchAddButton.addActionListener(new ActionListener() {					
			public void actionPerformed(ActionEvent e) {				
				connect();
				mealSelect(6,  Integer.parseInt(kimchSpinner.getValue().toString()));				
			}
		});
		
		
		spamAddButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {				
				connect();
				mealSelect(4, Integer.parseInt(spamSpinner.getValue().toString()));				
			}
		});
		
		chickAddButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				connect();
				mealSelect(5, Integer.parseInt(chickSpinner.getValue().toString()));				
			}
		});
		
		// 음료 버튼	
		ameriAddButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				connect();
				drinkSelect(7, Integer.parseInt(ameriSpinner.getValue().toString()));										
			}
		});
		
		
		caferaAddButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				connect();
				drinkSelect(8, Integer.parseInt(caferaSpinner.getValue().toString()));				
			}
		});
		
		
		caraAddButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				connect();
				drinkSelect(9, Integer.parseInt(caraSpinner.getValue().toString()));				
			}
		});
		
		
		//스낵
		ramyeonAddButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {				
				connect();
				snackSelect(1, Integer.parseInt(ramyeonSpinner.getValue().toString()));				
			}
		});
		
		ddeockAddButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {				
				connect();
				snackSelect(2, Integer.parseInt(ddeockSpinner.getValue().toString()));				
			}
		});
		
		rabockAddButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				connect();
				snackSelect(3, Integer.parseInt(rabockSpinner.getValue().toString()));			
			}
		});     

		////////////////// 요금제 버튼   ///////////////////////////
		oneButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				connect();
				timePlan(1);
//				underCalculator();
			}
		});

		twoButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				connect();
				timePlan(2);
//				underCalculator();
			}
		});
		
		threeButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				connect();
				timePlan(3);
//				underCalculator();
			}
		});
		
		sixButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				connect();
				timePlan(6);
//				underCalculator();
			}
		});
		
		twelButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				connect();
				timePlan(12);
//				underCalculator();
			}
		});
		
		twenButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				connect();
				timePlan(24);
//				underCalculator();

			}
		});
		
		
		// 결제창 버튼
		payButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculator();                   // 총 수량 및 총 결제 금액 메서드
				String paySelect = chooseComboBox.getSelectedItem().toString();				
				if(paySelect.equals(" 결제수단선택")) {           // 1-1. 결제 방식 선택 안했을 때 
					String[] cashOrCreadit = {"카드", "현금"};
					Object choose = JOptionPane.showInputDialog(
							null, 
							"지불 방법을 선택해주세요", 
							"결제수단", 
							JOptionPane.QUESTION_MESSAGE, 
							null, 
							cashOrCreadit, 
							"결제수단");
					if(choose == "카드") {            // 1-2. 결제 방식 선택 안했을 때 - 카드 선택					
						chooseComboBox.setSelectedItem("카드");
					}else if(choose == "현금"){       // 1-3. 결제 방식 선택 안했을 때 - 현금 선택
						chooseComboBox.setSelectedItem("현금");
						cashPlz();
					}else {
							//System.out.println("취소");        // 1-4. 취소 버튼   (생략 고민 중)
					}					
				}else if(paySelect.equals("카드")) {    // 2. 결제 방식 선택 후 				                                          // 2-1. 카드결제
					connect();
					checkOut();
					cardReceipt();
									 
				}else if(paySelect.equals("현금")){     // 2-2. 현금 결제
					connect();					
					cashPlz();					
					checkOut();
					cashReceipt();
								
				}	
				tAmount = 0;
				tSales = 0;
				model.setRowCount(0);
							
			}
		});  // checkout 끝
		
						
			
	cashPlzButton.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			while(cashTextField.getText().equals("")) {
				String cashplease = JOptionPane.showInputDialog("현금을 입금하세요");
				cashTextField.setText(cashplease);
				while(Integer.parseInt(cashTextField.getText().toString()) < tSales) {
					String recheck = JOptionPane.showInputDialog("주문하신 총 결제 금액 이상으로 입금하세요");
					cashTextField.setText(recheck);
				}
			}		
		}
	});
		
		
	homeButton.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {

//			new MyPage();
			dispose();
		}
	});
	
		
	}  // 생성자 end 
		
	
	
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
	
	// 식사 메뉴 
	void mealSelect (int fnumber, int mealSpinner) {		
		try {
			sql = "select fname, price , mealtype from food where fno = ?";
			pstmt = con.prepareStatement(sql);			
			pstmt.setInt(1, fnumber);			
			res = pstmt.executeQuery();			
			while(res.next()) {				
				String fname = res.getString("fname");
				int price = res.getInt("price");
				String mealtype = res.getString("mealtype");
				Object[] cart = {fname, mealSpinner, (price * mealSpinner), mealtype};									
				model.addRow(cart);								
			}			
			con.close();
			pstmt.close();
			res.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// 음료 메뉴
	void drinkSelect (int dnumber, int drinkSpinner) {
	
		try {
			sql = "select fname, price, mealtype from food where fno = ?";
	
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dnumber);
			res = pstmt.executeQuery();
			
			while(res.next()) {
				
				String fname = res.getString("fname");
				int price = res.getInt("price");
				String mealtype = res.getString("mealtype");
				Object[] cart = {fname, drinkSpinner, (price * drinkSpinner), mealtype};
					
				
				model.addRow(cart);
								
			}
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 스낵 메뉴
	void snackSelect (int snumber, int snackSpinner) {	
		try {
			sql = "select fname, price, mealtype from food where fno = ?";			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, snumber);
			res = pstmt.executeQuery();		
			while(res.next()) {			
				String fname = res.getString("fname");
				int price = res.getInt("price");
				String mealtype = res.getString("mealtype");
				Object[] cart = {fname, snackSpinner, (price * snackSpinner), mealtype};								
				model.addRow(cart);							
			}		
			con.close();		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 행 삭제 
	void removerow() {
		
		int row = cartTable.getSelectedRow();
		model.removeRow(row);
		
//		if(model.getValueAt(row, 0) == null) {
//		JOptionPane.showMessageDialog(null, "최소 한개 이상의 상품이 있어야 합니다.");				
//		}
		
//		if((true) model.getValueAt(0, 0)) {
//			JOptionPane.showMessageDialog(null, "최소 한개 이상의 상품이 있어야 합니다.");
//		}else {
//			model.removeRow(row);

//		}
		
	}
	
	// 결제 버튼 클릭시 SQL 전송 
	void checkOut() {	
		model = (DefaultTableModel) cartTable.getModel();		
		try {
			
			sql = "insert into payment values(orderNO_sqe.nextval, ?, ?, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);		
			for(int i = 0; i < model.getRowCount(); i++) {				
				pstmt.setString(1, model.getValueAt(i, 0).toString());
				pstmt.setInt(2, (Integer)(model.getValueAt(i, 1)));
				pstmt.setInt(3, (Integer)(model.getValueAt(i, 2)));
				pstmt.setString(4,  model.getValueAt(i, 3).toString());
				pstmt.setString(5, chooseComboBox.getSelectedItem().toString());				
				pstmt.executeUpdate();							
			}
			con.close();
			pstmt.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	// 현금 결제 방식 선택 안하고 현금 결제 클릭 시 결제 메서드 (삭제 보류중) 
	void checkOut2() {		
		try {
			sql = "insert into payment values(orderNO_sqe.nextval, ?, ?, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);				
			for(int i = 0; i < model.getRowCount(); i++) {								
				pstmt.setString(1, model.getValueAt(i, 0).toString());
				pstmt.setInt(2, (Integer)(model.getValueAt(i, 1)));
				pstmt.setInt(3, (Integer)(model.getValueAt(i, 2)));
				pstmt.setString(4,  model.getValueAt(i, 3).toString());
				pstmt.setString(5, choose.toString());								
				pstmt.executeUpdate();												
			}
			con.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 요금제 메뉴 SQL 전송
	void timePlan(int hours){				
		try {
			sql = "select tname, tprice , type from timetable where hours = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, hours);
			res = pstmt.executeQuery();
			while(res.next()) {
				String tname = res.getString("tname");
				int tprice = res.getInt("tprice");
				int amount = 1;
				String type = res.getString("type");				
				Object[] tdate = {tname, amount, tprice, type};				
				model.addRow(tdate);				
			}						
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	// 총수량 및 총 결제 금액 
	void calculator() {		
		JTable jtbl = new JTable(model);		
		for(int i = 0; i < jtbl.getRowCount(); i++) {
			tAmount = tAmount + Integer.parseInt((jtbl.getValueAt(i, 1).toString()));
		}		
		for(int i = 0; i < jtbl.getRowCount(); i++) {
			tSales = tSales + Integer.parseInt(jtbl.getValueAt(i, 2).toString());			
		}		
	}
	
	// 결제전 수량 및 금액 확인을 위한 메서드  (수정 필요)
	void underCalculator() {
		
		JTable jtbl = new JTable(model);		
		for(int i = 0; i < jtbl.getRowCount(); i++) {
			tAmount = tAmount + Integer.parseInt((jtbl.getValueAt(i, 1).toString()));
		}		
		for(int i = 0; i < jtbl.getRowCount(); i++) {
			tSales = tSales + Integer.parseInt(jtbl.getValueAt(i, 2).toString());			
		}	
		
//		underBalanceField.setText("총 금액 : " + tSales);
//		underAmountField.setText("총 수량 : " + tAmount);
	
	}
	
	// 카드 영수증
	void cardReceipt() {
		amountTextField.setText("총 수량 : " + (int)(tAmount) + "개");              // 총수량
		amountTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		totalTextField.setText("총 금액 : " + (int)(tSales) + "원");                // 총 금액		
		totalTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		taxTextField.setText("부가세 : " + (tSales * 0.1) + "원");
		taxTextField.setBorder(BorderFactory.createLineBorder(Color.white));

		LocalDate time = LocalDate.now();
		sysdateTextField.setText("[구매]" + time);                               // 현제 시간
		sysdateTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	//	DatetextField.setText();
	}
	
	// 현금 영수증 
	void cashReceipt() {		
		amountTextField.setText("총 수량 : " + (int)(tAmount) + "개");              // 총수량
		amountTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		totalTextField.setText("거래 금액 : " + (int)(tSales) + "원");                // 총 금액
		totalTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		int cash = Integer.parseInt(cashTextField.getText().toString());       // 입금액 
			
		earnCashTextField.setText("입금액 : " + (cash) + "원");                    // 입금한 현금액 텍스트 박스 전송
		earnCashTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		changeTextField.setText("잔돈 : " + (cash-tSales) + "원");                // 잔돈
		changeTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		taxTextField.setText("부가세 : " + (tSales * 0.1) + "원");                    // 부가세
		taxTextField.setBorder(BorderFactory.createLineBorder(Color.white));
		
		LocalDate time = LocalDate.now();
		sysdateTextField.setText("[구매]  " + time);                               // 현제 시간
		sysdateTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			
		
		cashTextField.setText(null);
	}
	
	// 총 수량 및 총 금액 초기화
	void reSetText() {
		
		amountTextField.setText("");
		totalTextField.setText("");
	}
	
	
	void cashPlz(){
		
		if(cashTextField.getText().equals("")) {
		String cashplease = JOptionPane.showInputDialog("현금을 입금하세요");
		cashTextField.setText(cashplease);
		}
		while(true) {
			if(Integer.parseInt(cashTextField.getText().toString()) < tSales) {
				String recheck = JOptionPane.showInputDialog("주문하신 총 결제 금액 이상으로 입금하세요");
				cashTextField.setText(recheck);				
			}
			break;
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // 마지막 
