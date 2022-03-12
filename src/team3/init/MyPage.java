package team3.init;

import java.awt.*;
import java.awt.event.*;

import java.sql.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import team3.booktable.booktable;
import team3.odermenu.OrderMenu;

public class MyPage extends JFrame {
	Connection con = null;
	
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	String sql = null;
	DefaultTableModel model;

	JTable table;

	static String id;
	private JPanel contentPane;

	/**
	 * Application launched by other application - Init
	 * 기본 생성자는 사용되지 않음.
	 */

	/**
	 * Create the frame.
	 */

	public MyPage(String id) {
		
		
		setTitle("마이 페이지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		JPanel container = new JPanel();
		
		JPanel container1 = new JPanel();
		container1.setBackground(SystemColor.info);

		
		JLabel jl1= new JLabel("메뉴 목록");
	
		JLabel jl2= new JLabel("도서 목록");
		
		
		jl1.setFont(new Font("휴먼편지체",Font.BOLD, 70));
		jl2.setFont(new Font("휴먼편지체",Font.BOLD, 70));
		
		getContentPane().add(container1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\git\\KH_PartyNo3\\images\\dreview.png"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\git\\KH_PartyNo3\\images\\dmenu.png"));
		
		JLabel jl_greet1 = new JLabel("안녕하세요, " + id + "님.");
		
		JLabel jl_greet2 = new JLabel("마이 페이지에 오신 것을 환영합니다.");
		
		jl_greet1.setFont(new Font("휴먼편지체",Font.BOLD, 30));
		jl_greet2.setFont(new Font("휴먼편지체",Font.BOLD, 30));
		
		JButton btnCheck = new JButton("회원정보 확인");
		btnCheck.setBackground(SystemColor.window);
		btnCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberInfoCheck(id);
			}
		});
		
		JButton btnEdit = new JButton("회원정보 수정");
		btnEdit.setBackground(SystemColor.window);
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberInfoEdit(id);
			}
		});
		
		btnCheck.setFont(new Font("휴먼편지체",Font.BOLD, 30));
		btnEdit.setFont(new Font("휴먼편지체",Font.BOLD, 30));
		GroupLayout gl_container1 = new GroupLayout(container1);
		gl_container1.setHorizontalGroup(
			gl_container1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_container1.createSequentialGroup()
					.addContainerGap(250, Short.MAX_VALUE)
					.addGroup(gl_container1.createParallelGroup(Alignment.TRAILING)
						.addComponent(jl1)
						.addGroup(gl_container1.createSequentialGroup()
							.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
								.addComponent(jl_greet2)
								.addComponent(lblNewLabel_1)
								.addComponent(jl_greet1))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_container1.createSequentialGroup()
							.addGap(80)
							.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
								.addComponent(btnEdit)
								.addComponent(btnCheck)))
						.addGroup(gl_container1.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_container1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(jl2))))
					.addGap(240))
		);
		gl_container1.setVerticalGroup(
			gl_container1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_container1.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_container1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_container1.createSequentialGroup()
							.addComponent(jl_greet1)
							.addGap(26)
							.addComponent(jl_greet2))
						.addGroup(gl_container1.createSequentialGroup()
							.addComponent(btnCheck)
							.addGap(26)
							.addComponent(btnEdit)))
					.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
					.addGroup(gl_container1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addGap(36)
					.addGroup(gl_container1.createParallelGroup(Alignment.BASELINE)
						.addComponent(jl2)
						.addComponent(jl1)))
		);
		container1.setLayout(gl_container1);
		
		
		setBounds(200,200,800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setVisible(true);
		
		
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new OrderMenu();
				dispose();
				super.mouseClicked(e);
			}
		});
		
		lblNewLabel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				new booktable(id);
				dispose();
				super.mouseClicked(e);
			}
		});
		
		jl1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new OrderMenu();
				dispose();
				super.mouseClicked(e);
			}
		});
		jl2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new booktable(id);
				dispose();
				super.mouseClicked(e);
			}
		});
		
	
	}
}
