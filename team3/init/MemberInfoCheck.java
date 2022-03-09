package team3.init;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MemberInfoCheck extends JFrame {
	Connection con = null;              // DB와 연결하는 객체.
	PreparedStatement pstmt = null;     // SQL문을 DB에 전송하는 객체.
	ResultSet rs = null;	// SQL문을 실행한 후의 결과값을 가지고 있는 객체.
	String sql = null;		// SQL문 저장 문자열 변수

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberInfoCheck frame = new MemberInfoCheck();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MemberInfoCheck() {
		setTitle("회원 정보 확인");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_center = new JPanel();
		contentPane.add(panel_center, BorderLayout.CENTER);
		
		JPanel panel_wrapCenter = new JPanel();
		panel_center.add(panel_wrapCenter);
		panel_wrapCenter.setLayout(new GridLayout(7, 1));
		
		JPanel panel1_num = new JPanel();
		panel_wrapCenter.add(panel1_num);
		
		JLabel jl1_num1 = new JLabel("회원 번호: ");
		panel1_num.add(jl1_num1);
		
		JLabel jl1_num2 = new JLabel("New label");
		panel1_num.add(jl1_num2);
		
		JPanel panel2_name = new JPanel();
		panel_wrapCenter.add(panel2_name);
		
		JLabel jl2_name1 = new JLabel("회원 이름: ");
		panel2_name.add(jl2_name1);
		
		JLabel jl2_name2 = new JLabel("New label");
		panel2_name.add(jl2_name2);
		
		JPanel panel3_id = new JPanel();
		panel_wrapCenter.add(panel3_id);
		
		JLabel jl3_id1 = new JLabel("회원 아이디: ");
		panel3_id.add(jl3_id1);
		
		JLabel jl3_id2 = new JLabel("New label");
		panel3_id.add(jl3_id2);
		
		JPanel panel4_contact = new JPanel();
		panel_wrapCenter.add(panel4_contact);
		
		JLabel jl4_cont1 = new JLabel("회원 연락처: ");
		panel4_contact.add(jl4_cont1);
		
		JLabel jl4_cont2 = new JLabel("New label");
		panel4_contact.add(jl4_cont2);
		
		JPanel panel5_address = new JPanel();
		panel_wrapCenter.add(panel5_address);
		
		JLabel jl5_addr1 = new JLabel("회원 주소: ");
		panel5_address.add(jl5_addr1);
		
		JLabel jl5_addr2 = new JLabel("New label");
		panel5_address.add(jl5_addr2);
		
		JPanel panel6_mileage = new JPanel();
		panel_wrapCenter.add(panel6_mileage);
		
		JLabel jl6_mile1 = new JLabel("보유 마일리지: ");
		panel6_mileage.add(jl6_mile1);
		
		JLabel jl6_mile2 = new JLabel("New label");
		panel6_mileage.add(jl6_mile2);
		
		JPanel panel_pwdFind = new JPanel();
		panel_wrapCenter.add(panel_pwdFind);
		
		JButton btnFindPwd = new JButton("비밀번호 찾기 질문 답 확인");
		panel_pwdFind.add(btnFindPwd);
		
		JPanel panel_south = new JPanel();
		contentPane.add(panel_south, BorderLayout.SOUTH);
		
		JButton btnToEdit = new JButton("회원 정보 수정");
		panel_south.add(btnToEdit);
		
		JButton btnClose = new JButton("닫기");
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_south.add(btnClose);
		setVisible(true);
	}

	public MemberInfoCheck(String id) {
		setTitle("회원 정보 확인");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_center = new JPanel();
		contentPane.add(panel_center, BorderLayout.CENTER);
		
		JPanel panel_wrapCenter = new JPanel();
		panel_center.add(panel_wrapCenter);
		panel_wrapCenter.setLayout(new GridLayout(7, 1));
		
		JPanel panel1_num = new JPanel();
		panel_wrapCenter.add(panel1_num);
		
		JPanel panel2_name = new JPanel();
		panel_wrapCenter.add(panel2_name);
		
		JPanel panel3_id = new JPanel();
		panel_wrapCenter.add(panel3_id);
		
		JPanel panel4_contact = new JPanel();
		panel_wrapCenter.add(panel4_contact);
		
		JPanel panel5_address = new JPanel();
		panel_wrapCenter.add(panel5_address);
		
		JPanel panel6_mileage = new JPanel();
		panel_wrapCenter.add(panel6_mileage);
		
		
		getMemberInfo(id);
		
		
		JLabel jl1_num1 = new JLabel("회원 번호: ");
		JLabel jl2_name1 = new JLabel("회원 이름: ");
		JLabel jl3_id1 = new JLabel("회원 아이디: ");
		JLabel jl4_cont1 = new JLabel("회원 연락처: ");
		JLabel jl5_addr1 = new JLabel("회원 주소: ");
		JLabel jl6_mile1 = new JLabel("보유 마일리지: ");
		panel1_num.add(jl1_num1);
		panel2_name.add(jl2_name1);
		panel3_id.add(jl3_id1);
		panel4_contact.add(jl4_cont1);
		panel5_address.add(jl5_addr1);
		panel6_mileage.add(jl6_mile1);
		
		
		JLabel jl1_num2 = null, jl2_name2 = null, jl3_id2 = null, 
				jl4_cont2 = null, jl5_addr2 = null, jl6_mile2 = null;
		try {
			jl1_num2 = new JLabel(rs.getString("mem_num"));
			jl2_name2 = new JLabel(rs.getString("mem_name"));
			jl3_id2 = new JLabel(rs.getString("mem_id"));
			jl4_cont2 = new JLabel(rs.getString("mem_contact"));
			jl5_addr2 = new JLabel(rs.getString("mem_addr"));
			jl6_mile2 = new JLabel(rs.getString("mem_mileage"));
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		panel1_num.add(jl1_num2);
		panel2_name.add(jl2_name2);
		panel3_id.add(jl3_id2);
		panel4_contact.add(jl4_cont2);
		panel5_address.add(jl5_addr2);
		panel6_mileage.add(jl6_mile2);
		
		
		JPanel panel_pwdFind = new JPanel();
		panel_wrapCenter.add(panel_pwdFind);
		
		JButton btnFindPwd = new JButton("비밀번호 찾기 질문 답 확인");
		btnFindPwd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog("비밀번호를 입력해 주세요.");
				checkPassword(id, input);
			}
		});
		panel_pwdFind.add(btnFindPwd);
		
		JPanel panel_south = new JPanel();
		contentPane.add(panel_south, BorderLayout.SOUTH);
		
		JButton btnToEdit = new JButton("회원 정보 수정");
		btnToEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberInfoEdit(id);
			}
		});
		panel_south.add(btnToEdit);
		
		JButton btnClose = new JButton("닫기");
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_south.add(btnClose);
		setVisible(true);
	}
	
	
	void connectGetInfo(String id) {
		try {
			con = DBConnection.getConnection();
			sql = "select * from member where mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void getMemberInfo(String id) {
		connectGetInfo(id);

		try {
			boolean found = rs.next();
			
			if(found) {
				return;
			}
			else {
				JOptionPane.showMessageDialog(null, "회원 정보를 제대로 가져오지 못했습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void checkPassword(String id, String password) {
		connectGetInfo(id);
		
		try {
			boolean found = rs.next();
			if(found) {
				if(password.equals(rs.getString("mem_password"))) {
					JOptionPane.showMessageDialog(null, "비밀번호 찾기 질문 답은 " + rs.getString("mem_findpwd_ans") + "입니다.");
				}
				else {
					JOptionPane.showMessageDialog(null, "비밀번호 입력 오류입니다.");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "회원 정보를 제대로 가져오지 못했습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
