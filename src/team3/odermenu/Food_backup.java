package team3.odermenu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.SpinnerNumberModel;

public class Food_backup extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Food_backup frame = new Food_backup();
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
	
	
	
	
	
	public Food_backup() {
		
		setTitle("음식 메뉴 주문");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\log.png"));
		
		String[] cartHeader = {"주문번호", "상품명", "가격	", "수량", "날짜"};
		DefaultTableModel model = new DefaultTableModel(cartHeader, 0);
		JTable table = new JTable(model);
		table.setBackground(SystemColor.window);
		
		
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
		
		JScrollPane carjsp = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton cartButton = new JButton("장바구니");
		cartButton.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\cart2.jpg"));
		cartButton.setBackground(SystemColor.window);
		
		JButton payButton = new JButton("결제");
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
					.addGroup(gl_ButtonPanal.createParallelGroup(Alignment.LEADING)
						.addComponent(payButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_ButtonPanal.createSequentialGroup()
							.addComponent(plusButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(minuButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
						.addComponent(cartButton, GroupLayout.PREFERRED_SIZE, 147, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_ButtonPanal.setVerticalGroup(
			gl_ButtonPanal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ButtonPanal.createSequentialGroup()
					.addComponent(cartButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(gl_ButtonPanal.createParallelGroup(Alignment.LEADING)
						.addComponent(plusButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(minuButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addComponent(payButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
		);
		ButtonPanal.setLayout(gl_ButtonPanal);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addComponent(OderTebbedPanel, GroupLayout.PREFERRED_SIZE, 744, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(92)
					.addComponent(cartPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(ButtonPanal, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(OderTebbedPanel, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(cartPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ButtonPanal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		
		JPanel mealpanel = new JPanel();
		mealpanel.setBackground(SystemColor.window);
		OderTebbedPanel.addTab("스낵", new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\dish.png"), mealpanel, null);
		
		JPanel kimPanel = new JPanel();
		kimPanel.setBackground(Color.WHITE);
		
		JSpinner kimchSpinner = new JSpinner();
		kimchSpinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		kimchSpinner.setForeground(SystemColor.window);
		kimchSpinner.setBackground(SystemColor.window);
		
		JButton kimchAddButton = new JButton("담기");
		kimchAddButton.setBackground(SystemColor.window);
		
		JLabel kimchImageLabel = new JLabel("");
		kimchImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\김치베이컨2.jpg"));
		kimchImageLabel.setBackground(SystemColor.window);
		
		JLabel kimNameLabel = new JLabel("김치베이컨 볶음밥");
		kimNameLabel.setBackground(SystemColor.window);
		
		JLabel kimPriceLabel_1 = new JLabel("6,000원");
		kimPriceLabel_1.setBackground(SystemColor.window);
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
							.addComponent(kimPriceLabel_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_kimPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(kimNameLabel)))
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
					.addComponent(kimNameLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(kimPriceLabel_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		kimPanel.setLayout(gl_kimPanel);
		
		JPanel chickPanel = new JPanel();
		chickPanel.setBackground(Color.WHITE);
		
		JSpinner chickSpinner = new JSpinner();
		chickSpinner.setForeground(Color.WHITE);
		chickSpinner.setBackground(SystemColor.window);
		
		JButton chickAddButton = new JButton("담기");
		chickAddButton.setBackground(SystemColor.window);
		
		JLabel chicImageLabel = new JLabel("");
		chicImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\치킨가라아게덥밥2.jpg"));
		chicImageLabel.setBackground(SystemColor.window);
		
		JLabel chickNameLabel_1_1 = new JLabel("치킨 가라아게 덮밥");
		chickNameLabel_1_1.setBackground(SystemColor.window);
		
		JLabel chickPriceLabel_1_2 = new JLabel("6,000원");
		chickPriceLabel_1_2.setBackground(SystemColor.window);
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
							.addComponent(chickPriceLabel_1_2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_chickPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(chickNameLabel_1_1, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
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
					.addComponent(chickNameLabel_1_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chickPriceLabel_1_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		chickPanel.setLayout(gl_chickPanel);
		
		JPanel spamPanel = new JPanel();
		spamPanel.setBackground(Color.WHITE);
		
		JSpinner spamSpinner = new JSpinner();
		spamSpinner.setForeground(Color.WHITE);
		spamSpinner.setBackground(SystemColor.window);
		
		JButton spamAddButton = new JButton("담기");
		spamAddButton.setBackground(SystemColor.window);
		
		JLabel spamImageLabel = new JLabel("");
		spamImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\스펨계란볶음밥2.jpg"));
		spamImageLabel.setBackground(SystemColor.window);
		
		JLabel spamNameLabel_1 = new JLabel("스팸계란 볶음밥");
		spamNameLabel_1.setBackground(Color.WHITE);
		
		JLabel spamPriceLabel_1_1 = new JLabel("6,000원");
		spamPriceLabel_1_1.setBackground(Color.WHITE);
		GroupLayout gl_spamPanel = new GroupLayout(spamPanel);
		gl_spamPanel.setHorizontalGroup(
			gl_spamPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_spamPanel.createSequentialGroup()
					.addContainerGap(54, Short.MAX_VALUE)
					.addComponent(spamPriceLabel_1_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(45))
				.addGroup(gl_spamPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_spamPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_spamPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(spamNameLabel_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
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
					.addComponent(spamNameLabel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(spamPriceLabel_1_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
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
		
		JPanel ramyeonPanel_1 = new JPanel();
		ramyeonPanel_1.setBackground(Color.WHITE);
		
		JSpinner ameriSpinner = new JSpinner();
		ameriSpinner.setForeground(Color.WHITE);
		ameriSpinner.setBackground(SystemColor.window);
		
		JButton ameriAddButton = new JButton("담기");
		ameriAddButton.setBackground(SystemColor.window);
		
		JLabel ameriImageLabel = new JLabel("");
		ameriImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\아이스아메리카노2.png"));
		ameriImageLabel.setBackground(SystemColor.window);
		
		JLabel ameriNameLabel_1 = new JLabel("아메리카노");
		ameriNameLabel_1.setBackground(SystemColor.window);
		
		JLabel ameriPriceLabel_1_1 = new JLabel("3,000원");
		ameriPriceLabel_1_1.setBackground(Color.WHITE);
		GroupLayout gl_ramyeonPanel_1 = new GroupLayout(ramyeonPanel_1);
		gl_ramyeonPanel_1.setHorizontalGroup(
			gl_ramyeonPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ramyeonPanel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ramyeonPanel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ramyeonPanel_1.createSequentialGroup()
							.addComponent(ameriSpinner, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ameriAddButton))
						.addComponent(ameriImageLabel)
						.addGroup(gl_ramyeonPanel_1.createSequentialGroup()
							.addGap(39)
							.addComponent(ameriPriceLabel_1_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(13, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_ramyeonPanel_1.createSequentialGroup()
					.addContainerGap(42, Short.MAX_VALUE)
					.addComponent(ameriNameLabel_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(34))
		);
		gl_ramyeonPanel_1.setVerticalGroup(
			gl_ramyeonPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ramyeonPanel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(ameriImageLabel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ramyeonPanel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(ameriSpinner, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(ameriAddButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ameriNameLabel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ameriPriceLabel_1_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(135, Short.MAX_VALUE))
		);
		ramyeonPanel_1.setLayout(gl_ramyeonPanel_1);
		
		JPanel caramelPanel = new JPanel();
		caramelPanel.setBackground(SystemColor.window);
		
		JSpinner caraSpinner = new JSpinner();
		caraSpinner.setForeground(Color.WHITE);
		caraSpinner.setBackground(SystemColor.window);
		
		JButton caraAddButton = new JButton("담기");
		caraAddButton.setBackground(SystemColor.window);
		
		JLabel caraImageLabel = new JLabel("");
		caraImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\카라멜마끼아또4.jpg"));
		caraImageLabel.setBackground(SystemColor.window);
		
		JLabel caraNameLabel = new JLabel("카라멜마끼아또");
		caraNameLabel.setBackground(SystemColor.window);
		
		JLabel caraPriceLabel_1_1_2 = new JLabel("4,300원");
		caraPriceLabel_1_1_2.setBackground(SystemColor.window);
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
							.addComponent(caraPriceLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
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
					.addComponent(caraPriceLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(292, Short.MAX_VALUE))
		);
		caramelPanel.setLayout(gl_caramelPanel);
		
		JPanel caferaPanel = new JPanel();
		caferaPanel.setBackground(Color.WHITE);
		
		JSpinner caferaSpinner = new JSpinner();
		caferaSpinner.setForeground(Color.WHITE);
		caferaSpinner.setBackground(SystemColor.window);
		
		JButton caferaButton = new JButton("담기");
		caferaButton.setBackground(SystemColor.window);
		
		JLabel caferaImageLabel = new JLabel("");
		caferaImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\카페라떼3.jpg"));
		caferaImageLabel.setBackground(SystemColor.window);
		
		JLabel caferaNameLabel = new JLabel("카페라떼");
		caferaNameLabel.setBackground(SystemColor.window);
		
		JLabel caferaPriceLabel = new JLabel("4,300원");
		caferaPriceLabel.setBackground(SystemColor.window);
		GroupLayout gl_caferaPanel = new GroupLayout(caferaPanel);
		gl_caferaPanel.setHorizontalGroup(
			gl_caferaPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_caferaPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(caferaSpinner, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(caferaButton)
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
						.addComponent(caferaButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
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
					.addComponent(ramyeonPanel_1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(ramyeonPanel_1, GroupLayout.PREFERRED_SIZE, 226, Short.MAX_VALUE)
						.addComponent(caferaPanel, 0, 0, Short.MAX_VALUE)
						.addComponent(caramelPanel, 0, 0, Short.MAX_VALUE))
					.addContainerGap(267, Short.MAX_VALUE))
		);
		drinkPanel.setLayout(gl_drinkPanel);
		
		JPanel snackPanel = new JPanel();
		snackPanel.setBackground(SystemColor.window);
		OderTebbedPanel.addTab("식사", new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\snack.png"), snackPanel, null);
		
		JPanel ramyeonPanel = new JPanel();
		ramyeonPanel.setBackground(SystemColor.window);
		
		JPanel ddeockPanl = new JPanel();
		ddeockPanl.setBackground(Color.WHITE);
		
		JLabel ddeockImageLabel = new JLabel("");
		ddeockImageLabel.setIcon(new ImageIcon("C:\\Users\\JUNGHWAN\\git\\Junghwan3\\KH_Party_NO.3\\cartoon\\떡볶이2.jpg"));
		ddeockImageLabel.setBackground(SystemColor.window);
		
		JSpinner ddeockSpinner = new JSpinner();
		ddeockSpinner.setForeground(SystemColor.window);
		ddeockSpinner.setBackground(SystemColor.window);
		
		JButton ddeockAddButton = new JButton("담기");
		ddeockAddButton.setBackground(Color.WHITE);
		
		JLabel ddeockNameLabel = new JLabel("떡볶이");
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
		
		JSpinner rabockSpinner = new JSpinner();
		rabockSpinner.setForeground(Color.WHITE);
		rabockSpinner.setBackground(SystemColor.window);
		
		JButton rabockAddButton = new JButton("담기");
		rabockAddButton.setBackground(SystemColor.window);
		
		JLabel rabockNameLabel = new JLabel("라볶이");
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
		
		JSpinner ramyeonSpinner = new JSpinner();
		ramyeonSpinner.setForeground(SystemColor.window);
		ramyeonSpinner.setBackground(SystemColor.window);
		
		JButton ramyeonAddButton = new JButton("담기");
		ramyeonAddButton.setBackground(SystemColor.window);
		
		JLabel ramyeonNameLabel = new JLabel("라면");
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
				.addComponent(carjsp, GroupLayout.PREFERRED_SIZE, 502, GroupLayout.PREFERRED_SIZE)
		);
		gl_cartPanel.setVerticalGroup(
			gl_cartPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(carjsp, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
		);
		cartPanel.setLayout(gl_cartPanel);
		contentPane.setLayout(gl_contentPane);
	}
}
