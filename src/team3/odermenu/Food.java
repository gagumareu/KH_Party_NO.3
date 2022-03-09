package team3.odermenu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import java.awt.Font;

public class Food extends JFrame {

	private JPanel contentPane;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Food frame = new Food();
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
	JTable cartTable;
	
	
	JSpinner kimchSpinner, spamSpinner, chickSpinner, ameriSpinner,
	caraSpinner, caferaSpinner, ramyeonSpinner, ddeockSpinner, rabockSpinner;
	JLabel kimchNameLabel, spamNameLabel, chickNameLabel,
	ameriNameLabel, caraNameLabel, caferaNameLabel, ramyeonNameLabel, ddeockNameLabel, rabockNameLabel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	
	
	
	public Food() {
		
		setTitle("음식 메뉴 주문");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\JUNGHWAN\\Downloads\\꼬리치레\\comic.png"));
		
		String[] cartHeader = {"상품명", "가격	", "수량", "분류"};
		model = new DefaultTableModel(cartHeader, 0);
		cartTable = new JTable(model);
		cartTable.setBackground(SystemColor.window);
		
		
		setBackground(SystemColor.window);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 150, 800, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane OderTebbedPanel = new JTabbedPane(JTabbedPane.LEFT);
		OderTebbedPanel.setBackground(SystemColor.window);
		
		JPanel ButtonPanal = new JPanel();
		ButtonPanal.setBackground(SystemColor.info);
		
		JPanel cartPanel = new JPanel();
		cartPanel.setBackground(SystemColor.window);
		
		JScrollPane carjsp = new JScrollPane(cartTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton removeButton = new JButton("삭제");
		removeButton.setFont(new Font("굴림", Font.BOLD, 17));
		
		
		removeButton.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\OneDrive\\바탕 화면\\새 폴더\\cartoon\\삭제2.jpg"));
		removeButton.setBackground(SystemColor.window);
		
		JButton payButton = new JButton("결제");
		payButton.setFont(new Font("굴림", Font.BOLD, 17));
		payButton.setBackground(SystemColor.window);
		payButton.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\payment.png"));
		
		JButton plusButton = new JButton("");
		
		plusButton.setBackground(SystemColor.window);
		plusButton.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\plus.jpg"));
		
		JButton minuButton = new JButton("");
		
		minuButton.setBackground(SystemColor.window);
		minuButton.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\min.jpg"));
		GroupLayout gl_ButtonPanal = new GroupLayout(ButtonPanal);
		gl_ButtonPanal.setHorizontalGroup(
			gl_ButtonPanal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ButtonPanal.createSequentialGroup()
					.addGroup(gl_ButtonPanal.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(removeButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_ButtonPanal.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_ButtonPanal.createParallelGroup(Alignment.LEADING, false)
								.addComponent(payButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_ButtonPanal.createSequentialGroup()
									.addComponent(plusButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(minuButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_ButtonPanal.setVerticalGroup(
			gl_ButtonPanal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ButtonPanal.createSequentialGroup()
					.addComponent(removeButton, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(gl_ButtonPanal.createParallelGroup(Alignment.LEADING)
						.addComponent(minuButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(plusButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(payButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
		);
		ButtonPanal.setLayout(gl_ButtonPanal);
		
		JPanel timeTablePanel = new JPanel();
		timeTablePanel.setBackground(SystemColor.window);
		OderTebbedPanel.addTab("시간", new ImageIcon("C:\\Users\\JUNGHWAN\\Downloads\\꼬리치레\\times2.jpg"), timeTablePanel, null);
		
		JPanel costPanel = new JPanel();
		costPanel.setBackground(SystemColor.window);
		
		JPanel oneHourPanel = new JPanel();
		oneHourPanel.setBackground(SystemColor.window);
		
		JLabel oneImageLabel = new JLabel("");
		oneImageLabel.setBackground(SystemColor.window);
		oneImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\Downloads\\꼬리치레\\1hours.jpg"));
		
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
		twoImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\Downloads\\꼬리치레\\22.jpg"));
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
		threeImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\Downloads\\꼬리치레\\33.jpg"));
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
		
		JLabel sixPriceLabel = new JLabel("4,000원");
		sixPriceLabel.setFont(new Font("한컴 고딕", Font.BOLD, 19));
		sixPriceLabel.setBackground(SystemColor.window);
		
		JButton sixButton = new JButton("6시간 추가");
		sixButton.setFont(new Font("한컴 고딕", Font.BOLD, 17));
		sixButton.setBackground(SystemColor.window);
		
		JLabel sixImageLabel = new JLabel("");
		sixImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\Downloads\\꼬리치레\\66.jpg"));
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
		sixImageLabel_1.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\Downloads\\꼬리치레\\12.jpg"));
		sixImageLabel_1.setBackground(SystemColor.window);
		
		JButton twelButton = new JButton("6시간 추가");
		twelButton.setFont(new Font("한컴 고딕", Font.BOLD, 17));
		twelButton.setBackground(SystemColor.window);
		
		JLabel twelPriceLabel = new JLabel("6,000원");
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
		twenImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\Downloads\\꼬리치레\\24.jpg"));
		twenImageLabel.setBackground(SystemColor.window);
		
		JButton twenButton = new JButton("24시간 추가");
		twenButton.setFont(new Font("한컴 고딕", Font.BOLD, 17));
		twenButton.setBackground(SystemColor.window);
		
		JLabel twenPriceLabel = new JLabel("10,000원");
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
		OderTebbedPanel.addTab("식사", new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\dish.png"), mealpanel, null);
		
		JPanel kimPanel = new JPanel();
		kimPanel.setBackground(Color.WHITE);
		
		kimchSpinner = new JSpinner();
		kimchSpinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		kimchSpinner.setForeground(Color.WHITE);
		kimchSpinner.setBackground(SystemColor.window);
		
		JButton kimchAddButton = new JButton("담기");
		kimchAddButton.setBackground(SystemColor.window);
		
		
		
		
		JLabel kimchImageLabel = new JLabel("");
		kimchImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\김치베이컨2.jpg"));
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
		chicImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\치킨가라아게덥밥2.jpg"));
		chicImageLabel.setBackground(SystemColor.window);
		
		chickNameLabel = new JLabel("치킨 가라아게 덮밥");
		chickNameLabel.setBackground(SystemColor.window);
		
		JLabel chickPriceLabel = new JLabel("5900원");
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
		spamImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\스펨계란볶음밥2.jpg"));
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
		OderTebbedPanel.addTab("음료", new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\drink.png"), drinkPanel, null);
		
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
		ameriImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\아이스아메리카노2.png"));
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
		caraImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\카라멜마끼아또4.jpg"));
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
		caferaImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\카페라떼3.jpg"));
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
		OderTebbedPanel.addTab("스낵", new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\snack.png"), snackPanel, null);
		
		JPanel ramyeonPanel = new JPanel();
		ramyeonPanel.setBackground(SystemColor.window);
		
		JPanel ddeockPanl = new JPanel();
		ddeockPanl.setBackground(Color.WHITE);
		
		JLabel ddeockImageLabel = new JLabel("");
		ddeockImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\떡볶이2.jpg"));
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
		rabockImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\라볶이2.jpg"));
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
		ramyeonImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\ramyeon2.jpg"));
		
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
		GroupLayout gl_cartPanel = new GroupLayout(cartPanel);
		gl_cartPanel.setHorizontalGroup(
			gl_cartPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(carjsp, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
		);
		gl_cartPanel.setVerticalGroup(
			gl_cartPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(carjsp, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
		);
		cartPanel.setLayout(gl_cartPanel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\OneDrive\\바탕 화면\\새 폴더\\cartoon\\home.png"));
		btnNewButton.setBackground(SystemColor.window);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(OderTebbedPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cartPanel, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(ButtonPanal, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(14))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(OderTebbedPanel, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(ButtonPanal, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
							.addComponent(cartPanel, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
					.addGap(22))
		);
		contentPane.setLayout(gl_contentPane);
		
		

		
		
///////////////////////////////////    담기 버튼 액션        ///////////////////////////////////////////////////////////////////////////
		
		// 식사 버튼
		kimchAddButton.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				
				connect();
				mealSelect("김치베이컨 볶음밥",  Integer.parseInt(kimchSpinner.getValue().toString()));
				
			}
		});
		
		
		spamAddButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				connect();
				mealSelect("스팸계란 볶음밥", Integer.parseInt(spamSpinner.getValue().toString()));
				
			}
		});
		
		chickAddButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				connect();
				mealSelect("치킨카라아게 덮밥", Integer.parseInt(chickSpinner.getValue().toString()));
				
			}
		});
		
		// 음료 버튼	
		ameriAddButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				connect();
				drinkSelect("아메리카노", Integer.parseInt(ameriSpinner.getValue().toString()));
				
							
			}
		});
		
		
		caferaAddButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				connect();
				drinkSelect("카페 라떼", Integer.parseInt(caferaSpinner.getValue().toString()));
				
			}
		});
		
		
		caraAddButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				connect();
				drinkSelect("카라멜 마끼아또", Integer.parseInt(caraSpinner.getValue().toString()));
				
			}
		});
		
		
		//스낵
		ramyeonAddButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				connect();
				snackSelect("라면", Integer.parseInt(ramyeonSpinner.getValue().toString()));
				
			}
		});
		
		ddeockAddButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				connect();
				snackSelect("떡볶이", Integer.parseInt(ddeockSpinner.getValue().toString()));
				
			}
		});
		
		rabockAddButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				connect();
				snackSelect("라볶이", Integer.parseInt(rabockSpinner.getValue().toString()));

				
			}
		});     

		
		//삭제 버튼
		removeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				removerow();
				
				
			}
		}); 
		
		
		// 결제창 버튼
		payButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {


					connect();
					payment();
					
					JTable jtbl = new JTable(model);
//					Payment newWindow = new Payment(jtbl);
					new Payment(jtbl);
//					newWindow.setModal(true);
//					//newWindow.setPaytable(table);
//					newWindow.setVisible(true);
					

				super.mouseClicked(e);
			}
		});
		
		// 플러스 버튼
		plusButton.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				
				model = (DefaultTableModel) cartTable.getModel();
				
				int row = cartTable.getSelectedRow();
				Integer plus = (Integer) model.getValueAt(row, 2);
				plus +=1;
				model.setValueAt(plus, row, 2);
				
				
				
			}
		});
		
		// 마이너스 버튼
		minuButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				model = (DefaultTableModel) cartTable.getModel();
				
				int row = cartTable.getSelectedRow();
				Integer minus = (Integer) model.getValueAt(row, 2);
				minus += -1;
				model.setValueAt(minus, row, 2);
			}
		});
		

		oneButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				connect();
				timePlan(1);
			}
		});

		twoButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				connect();
				timePlan(2);
			}
		});
		
		threeButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				connect();
				timePlan(3);
			}
		});
		
		sixButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				connect();
				timePlan(6);
			}
		});
		
		twelButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				connect();
				timePlan(12);
			}
		});
		
		twenButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				connect();
				timePlan(24);
			}
		});
		
		
	}  // 생성자 end 
		
	
////////////////////////////////////    메소드               ////////////////////////////////////////////////////

	
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
	void mealSelect (String mealorder, int mealSpinner) {
		
		try {
			sql = "select fname, price , mealtype from food where fname = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, mealorder);
			
			res = pstmt.executeQuery();
			
			while(res.next()) {
				
				String fname = res.getString("fname");
				int price = res.getInt("price");
				String mealtype = res.getString("mealtype");
				Object[] cart = {fname, (price * mealSpinner), mealSpinner, mealtype};
					
				
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
	void drinkSelect (String drinkOrder, int drinkSpinner) {
	
		try {
			sql = "select fname, price, mealtype from food where fname = ?";
	
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, drinkOrder);
			res = pstmt.executeQuery();
			
			while(res.next()) {
				
				String fname = res.getString("fname");
				int price = res.getInt("price");
				String mealtype = res.getString("mealtype");
				Object[] cart = {fname, (price * drinkSpinner), drinkSpinner, mealtype};
					
				
				model.addRow(cart);
								
			}
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// 스낵 메뉴
	void snackSelect (String snackOrder, int snackSpinner) {
		
		try {
			sql = "select fname, price, mealtype from food where fname = ?";
	
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, snackOrder);
			res = pstmt.executeQuery();
			
			while(res.next()) {
				
				String fname = res.getString("fname");
				int price = res.getInt("price");
				String mealtype = res.getString("mealtype");
				Object[] cart = {fname, (price * snackSpinner), snackSpinner, mealtype};
					
				
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
		
		
	}

	
	
	
	// 결제창 
	void payment() {
		
	
		model = (DefaultTableModel) cartTable.getModel();
		
		try {
			
			sql = "insert into payment values(orderNO_sqe.nextval, ?, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
		
			for(int i = 0; i < model.getRowCount(); i++) {
				
				
				pstmt.setString(1, model.getValueAt(i, 0).toString());
				pstmt.setInt(2, (Integer)(model.getValueAt(i, 1)));
				pstmt.setString(4,  model.getValueAt(i, 3).toString());
				pstmt.setInt(3, (Integer)(model.getValueAt(i, 2)));
				pstmt.executeUpdate();
				
//				pstmt.addBatch();
//				pstmt.clearParameters();

			}

//			pstmt.executeBatch();
			
			con.close();
			pstmt.close();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
	
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
				
				Object[] tdate = {tname, tprice, amount, type};
				
				model.addRow(tdate);
				
			}
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
} // 마지막 
