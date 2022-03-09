package team3.init;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MemberInfoEdit extends JFrame {
	Connection con = null;              // DB와 연결하는 객체.
	PreparedStatement pstmt = null;     // SQL문을 DB에 전송하는 객체.
	ResultSet rs = null;	// SQL문을 실행한 후의 결과값을 가지고 있는 객체.
	String sql = null;		// SQL문 저장 문자열 변수

	private JPanel contentPane;
	private JPasswordField pf4_pwdConfirm, pf5_changePwd;
	private JTextField tf6_changeCont, tf7_changeAddr;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberInfoEdit frame = new MemberInfoEdit();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MemberInfoEdit() {
		setTitle("회원 정보 수정");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		JLabel jl1_counter = new JLabel("회원 이름, 아이디 변경은 카운터에 문의하세요.");
		contentPane.add(jl1_counter, BorderLayout.NORTH);
		
		JPanel panel_center = new JPanel();
		contentPane.add(panel_center, BorderLayout.CENTER);
		
		JPanel panel_wrapcenter = new JPanel();
		panel_center.add(panel_wrapcenter);
		panel_wrapcenter.setLayout(new GridLayout(7, 1));
		
		JPanel panel1_num = new JPanel();
		panel_wrapcenter.add(panel1_num);
		
		JLabel jl1_num1 = new JLabel("회원 번호: ");
		panel1_num.add(jl1_num1);
		
		JLabel jl1_num2 = new JLabel("New label");
		panel1_num.add(jl1_num2);
		
		JPanel panel2_name = new JPanel();
		panel_wrapcenter.add(panel2_name);
		
		JLabel jl2_name1 = new JLabel("회원 이름: ");
		panel2_name.add(jl2_name1);
		
		JLabel jl2_name2 = new JLabel("New label");
		panel2_name.add(jl2_name2);
		
		JPanel panel3_id = new JPanel();
		panel_wrapcenter.add(panel3_id);
		
		JLabel jl3_id1 = new JLabel("회원 아이디: ");
		panel3_id.add(jl3_id1);
		
		JLabel jl3_id2 = new JLabel("New label");
		panel3_id.add(jl3_id2);
		
		JPanel panel4_pwdConfirm = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel4_pwdConfirm.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_wrapcenter.add(panel4_pwdConfirm);
		
		JLabel jl4_pwdConfirm = new JLabel("기존 비밀번호 입력: ");
		panel4_pwdConfirm.add(jl4_pwdConfirm);
		
		pf4_pwdConfirm = new JPasswordField();
		pf4_pwdConfirm.setColumns(10);
		panel4_pwdConfirm.add(pf4_pwdConfirm);
		
		JPanel panel5_changePwd = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel5_changePwd.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_wrapcenter.add(panel5_changePwd);
		
		JLabel jl5_changePwd = new JLabel("비밀번호 변경: ");
		panel5_changePwd.add(jl5_changePwd);
		
		pf5_changePwd = new JPasswordField();
		pf5_changePwd.setColumns(10);
		panel5_changePwd.add(pf5_changePwd);
		
		JPanel panel6_changeCont = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel6_changeCont.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_wrapcenter.add(panel6_changeCont);
		
		JLabel jl6_changeCont = new JLabel("연락처 변경: ");
		panel6_changeCont.add(jl6_changeCont);
		
		tf6_changeCont = new JTextField();
		tf6_changeCont.setColumns(10);
		panel6_changeCont.add(tf6_changeCont);
		
		JPanel panel7_changeAddr = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel7_changeAddr.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		panel_wrapcenter.add(panel7_changeAddr);
		
		JLabel jl7_changeAddr = new JLabel("주소 변경: ");
		panel7_changeAddr.add(jl7_changeAddr);
		
		tf7_changeAddr = new JTextField();
		tf7_changeAddr.setColumns(10);
		panel7_changeAddr.add(tf7_changeAddr);
		
		JPanel panel_btn = new JPanel();
		contentPane.add(panel_btn, BorderLayout.SOUTH);
		
		JButton btnConfirm = new JButton("수정 완료");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_btn.add(btnConfirm);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_btn.add(btnCancel);
		setVisible(true);
	}
	
	public MemberInfoEdit(String id) {
		setTitle("회원 정보 수정");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		JLabel jl1_counter = new JLabel("회원 이름, 아이디 변경은 카운터에 문의하세요.");
		contentPane.add(jl1_counter, BorderLayout.NORTH);
		
		JPanel panel_center = new JPanel();
		contentPane.add(panel_center, BorderLayout.CENTER);
		
		JPanel panel_wrapcenter = new JPanel();
		panel_center.add(panel_wrapcenter);
		panel_wrapcenter.setLayout(new GridLayout(7, 1));
		
		JPanel panel1_num = new JPanel();
		panel_wrapcenter.add(panel1_num);
		
		JPanel panel2_name = new JPanel();
		panel_wrapcenter.add(panel2_name);
		
		JPanel panel3_id = new JPanel();
		panel_wrapcenter.add(panel3_id);
		
		
		getMemberInfo(id);
		
		
		JLabel jl1_num1 = new JLabel("회원 번호: ");
		JLabel jl2_name1 = new JLabel("회원 이름: ");
		JLabel jl3_id1 = new JLabel("회원 아이디: ");
		panel1_num.add(jl1_num1);
		panel2_name.add(jl2_name1);
		panel3_id.add(jl3_id1);
		
		JLabel jl1_num2 = null, jl2_name2 = null, jl3_id2 = null;
		try {
			jl1_num2 = new JLabel(rs.getString("mem_num"));
			jl2_name2 = new JLabel(rs.getString("mem_name"));
			jl3_id2 = new JLabel(rs.getString("mem_id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		panel1_num.add(jl1_num2);
		panel2_name.add(jl2_name2);
		panel3_id.add(jl3_id2);
		
		
		
		JPanel panel4_pwdConfirm = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel4_pwdConfirm.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_wrapcenter.add(panel4_pwdConfirm);
		
		JLabel jl4_pwdConfirm = new JLabel("기존 비밀번호 입력*: ");
		panel4_pwdConfirm.add(jl4_pwdConfirm);
		
		pf4_pwdConfirm = new JPasswordField();
		pf4_pwdConfirm.setColumns(10);
		panel4_pwdConfirm.add(pf4_pwdConfirm);
		
		JPanel panel5_changePwd = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel5_changePwd.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_wrapcenter.add(panel5_changePwd);
		
		JLabel jl5_changePwd = new JLabel("비밀번호 변경: ");
		panel5_changePwd.add(jl5_changePwd);
		
		pf5_changePwd = new JPasswordField();
		pf5_changePwd.setColumns(10);
		panel5_changePwd.add(pf5_changePwd);
		
		JPanel panel6_changeCont = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel6_changeCont.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_wrapcenter.add(panel6_changeCont);
		
		JLabel jl6_changeCont = new JLabel("연락처 변경: ");
		panel6_changeCont.add(jl6_changeCont);
		
		tf6_changeCont = new JTextField();
		tf6_changeCont.setColumns(10);
		panel6_changeCont.add(tf6_changeCont);
		
		JPanel panel7_changeAddr = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel7_changeAddr.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		panel_wrapcenter.add(panel7_changeAddr);
		
		JLabel jl7_changeAddr = new JLabel("주소 변경: ");
		panel7_changeAddr.add(jl7_changeAddr);
		
		tf7_changeAddr = new JTextField();
		tf7_changeAddr.setColumns(10);
		panel7_changeAddr.add(tf7_changeAddr);
		
		JLabel jl8 = new JLabel("*는 필수 입력");
		panel_center.add(jl8);
		
		
		JPanel panel_btn = new JPanel();
		contentPane.add(panel_btn, BorderLayout.SOUTH);
		
		JButton btnConfirm = new JButton("수정 완료");
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(connectInsertInfo(id)) {
					dispose();
				}
			}
		});
		panel_btn.add(btnConfirm);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_btn.add(btnCancel);
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
	
	boolean connectInsertInfo(String id) {
		try {
			connectGetInfo(id);
			rs.next();
			String password = rs.getString("mem_password");
			
			String Confirmingpwd = String.valueOf(pf4_pwdConfirm.getPassword());
			String changingPwd = String.valueOf(pf5_changePwd.getPassword());
			String changingCont = tf6_changeCont.getText();
			String changingAddr = tf7_changeAddr.getText();
			
			//기존 비밀번호 체크
			if(Confirmingpwd.equals(password)) {
				if(changingPwd.equals(null) && changingCont.equals(null)
						&& changingAddr.equals(null)) {	//다 변경하지 않을 경우
					JOptionPane.showMessageDialog(null, "적용할 변경사항이 없습니다.");
				}
				else {
					int count = 0;
					int check;
					if(!changingPwd.equals("")) {
						check = updatePwd(id, changingPwd);
						if(check==0) {
							JOptionPane.showMessageDialog(null, "비밀번호 변경 실패");
							count++;
						}
					}
					if(!changingCont.equals("")) {
						check = updateCont(id, changingCont);
						if(check==0) {
							JOptionPane.showMessageDialog(null, "연락처 변경 실패");
							count++;
						}
					}
					if(!changingAddr.equals("")) {
						check = updateAddr(id, changingAddr);
						if(check==0) {
							JOptionPane.showMessageDialog(null, "주소 변경 실패");
							count++;
						}
					}
					
					if(count==0) {
						JOptionPane.showMessageDialog(null, "변경이 성공적으로 완료되었습니다.");
						return true;
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "기존 비밀번호가 일치하지 않습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	int updatePwd(String id, String pwd) {
		int res = 0;
		try {
			sql = "update member set mem_password='" + pwd 
					+ "' where mem_id='" + id + "'";
			pstmt = con.prepareStatement(sql);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	int updateCont(String id, String cont) {
		int res = 0;
		try {
			sql = "update member set mem_contact='" + cont 
					+ "' where mem_id='" + id + "'";
			pstmt = con.prepareStatement(sql);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	int updateAddr(String id, String addr) {
		int res = 0;
		try {
			sql = "update member set mem_addr='" + addr 
					+ "' where mem_id='" + id + "'";
			pstmt = con.prepareStatement(sql);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
