package team3.odermenu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Payment2 extends JFrame {
	
	JTable table;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment2 frame = new Payment2();
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
	public Payment2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 150, 500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel paymentPanel = new JPanel();
		paymentPanel.setBackground(Color.WHITE);
		
		JScrollPane payjsp = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_paymentPanel = new GroupLayout(paymentPanel);
		gl_paymentPanel.setHorizontalGroup(
			gl_paymentPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 444, Short.MAX_VALUE)
				.addComponent(payjsp, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
		);
		gl_paymentPanel.setVerticalGroup(
			gl_paymentPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 304, Short.MAX_VALUE)
				.addGroup(gl_paymentPanel.createSequentialGroup()
					.addComponent(payjsp, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		paymentPanel.setLayout(gl_paymentPanel);
		
		JPanel BackButtonPanel = new JPanel();
		BackButtonPanel.setBackground(SystemColor.info);
		
		JButton BackButton = new JButton("뒤로가기");
		BackButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		BackButton.setBackground(Color.WHITE);
		
		JButton HomeButton = new JButton("HOME");
		HomeButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		HomeButton.setBackground(Color.WHITE);
		GroupLayout gl_BackButtonPanel = new GroupLayout(BackButtonPanel);
		gl_BackButtonPanel.setHorizontalGroup(
			gl_BackButtonPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 211, Short.MAX_VALUE)
				.addGroup(gl_BackButtonPanel.createSequentialGroup()
					.addGroup(gl_BackButtonPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(BackButton, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
						.addComponent(HomeButton, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_BackButtonPanel.setVerticalGroup(
			gl_BackButtonPanel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 197, Short.MAX_VALUE)
				.addGroup(gl_BackButtonPanel.createSequentialGroup()
					.addComponent(HomeButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
					.addComponent(BackButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
		);
		BackButtonPanel.setLayout(gl_BackButtonPanel);
		
		JPanel payButtonPanel = new JPanel();
		payButtonPanel.setBackground(SystemColor.info);
		
		JButton payButton = new JButton("결제 하기");
		payButton.setBackground(SystemColor.window);
		payButton.setForeground(SystemColor.infoText);
		payButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(SystemColor.window);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"결제수단 선택", "카드", "현금"}));
		GroupLayout gl_payButtonPanel = new GroupLayout(payButtonPanel);
		comboBox.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		gl_payButtonPanel.setHorizontalGroup(
			gl_payButtonPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(payButton, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
				.addComponent(comboBox, 0, 211, Short.MAX_VALUE)
		);
		gl_payButtonPanel.setVerticalGroup(
			gl_payButtonPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_payButtonPanel.createSequentialGroup()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
					.addComponent(payButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
		);
		payButtonPanel.setLayout(gl_payButtonPanel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(paymentPanel, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(BackButtonPanel, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
							.addComponent(payButtonPanel, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(paymentPanel, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(BackButtonPanel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
						.addComponent(payButtonPanel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}