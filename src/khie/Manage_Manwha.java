package khie;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Manage_Manwha extends JFrame {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql= null;
	
	DefaultTableModel model;
	JTable table;
	JTextField jtf1, jtf2, jtf3, jtf4,jtf5;
	
	
	public Manage_Manwha() {
		
		setTitle("��ȭå ���� ȭ��");
		
		JPanel container1 = new JPanel();

		JPanel container2 = new JPanel();

		
		JLabel jl1 = new JLabel("å��ġ:");
		jtf1 = new JTextField(2);
		
		JLabel jl2 = new JLabel("å��ȣ:");
		jtf2= new JTextField(8);
		
		JLabel jl3 = new JLabel("å�̸�:");
		jtf3= new JTextField(10);
		
		JLabel jl4 = new JLabel("�۾���:");
		jtf4= new JTextField(10);
		
		JLabel jl5 = new JLabel("�帣:");
		jtf5=new JTextField(15);
		
		String[] header= {"å��ġ","å��ȣ","å�̸�","�۾���","�帣"};
		
		model = new DefaultTableModel(header,0);
		
		table = new JTable(model);
		
		JScrollPane jsp = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton jb1 = new JButton("��ü ���");
		JButton jb2 = new JButton("���� �߰�");
		JButton jb3 = new JButton("���� ����");
		JButton jb4 = new JButton("���� ����");
		JButton jb5 = new JButton("���� ����");
		
		container1.add(jl1);container1.add(jtf1);
		container1.add(jl2);container1.add(jtf2);
		container1.add(jl3);container1.add(jtf3);
		container1.add(jl4);container1.add(jtf4);
		container1.add(jl5);container1.add(jtf5);
		
		container2.add(jb1);
		container2.add(jb2);
		container2.add(jb3);
		container2.add(jb4);
		container2.add(jb5);
		
		
		add(container1,BorderLayout.NORTH);
		add(jsp,BorderLayout.CENTER);
		add(container2,BorderLayout.SOUTH);
		
		setBounds(200,200,800,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				model.setRowCount(0);
				select();
				
			}
		});

		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();		// �����ͺ��̽� ���� �ϴ� �޼��� ȣ��
				insert();			//������ ���̽����� �����ϴ� �޼��� ȣ��
				//�Է� �ؽ�Ʈ�ʵ念�� �ʱ�ȭ
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				jtf4.setText("");
				jtf5.setText("");
				jtf1.requestFocus();
				
				model.setRowCount(0);		//��ü ���̺��� ȭ���� �����ִ� �޼���
				select();		
				
			}
		});
		
		
	}
	
	void connect() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="web";
		String password="1234";
		
		//1. ������ ����Ŭ ����̹�
		try {
			Class.forName(driver);
			
		// 2. ����Ŭ ������ ���̽��� ������ �õ�.
			con =DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}// connect()�޼��� end
	
	void select() {
		try {
			sql="select B.BLOCATION,BNUMBER,BNAME,BWRITER,B.BGENRE "
					+ "from BLOCATION B join BOOKS D "
					+ "on B.BLOCATION =D.BLOCATION";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String bloc= rs.getString("BLOCATION");
				int bnum= rs.getInt("BNUMBER");
				String bname=rs.getString("BNAME");
				String bwr=rs.getString("BWRITER");
				String bgenre=rs.getString("BGENRE");
				Object[] data= {bloc,bnum,bname,bwr,bgenre};
				model.addRow(data);
			
			}
			rs.close();pstmt.close();con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	void insert() {
		
		try {
			sql="insert into books values (?,booknum_seq.nextval,?,?)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, jtf1.getText());
			pstmt.setString(2, jtf3.getText());
			pstmt.setString(3, jtf4.getText());
			
			int res=pstmt.executeUpdate();
			
			if(res>0) {
				JOptionPane.showMessageDialog(null, "���� �߰� ����!!!!");
			} else {
				JOptionPane.showMessageDialog(null, "���� �߰� ����~~~~");
			}
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

	public static void main(String[] args) {
		new Manage_Manwha();

	}

}
