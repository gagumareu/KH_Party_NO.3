package khie;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Manage_Inform_search extends JFrame {
	Connection con= null;
	
	PreparedStatement pstmt= null;
	ResultSet rs =null;
	String sql = null;
	DefaultTableModel model;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	JTable table;	
	
	public Manage_Inform_search() {
		setTitle("ȸ�� ���� ���̺�");
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		
		
		JLabel jl1 = new JLabel("ȸ�����̵�:");
		jtf1= new JTextField(10);
		JLabel jl2 = new JLabel("�н�����:");
		jtf2=new JTextField(10);
		JLabel jl3 = new JLabel("�̸�:");
		jtf3= new JTextField(10);
		JLabel jl4 = new JLabel("��ȭ��ȣ:");
		jtf4= new JTextField(15);
		JLabel jl5 = new JLabel("�ּ�");
		jtf5= new JTextField(30);
		JLabel jl6 = new JLabel("���ϸ���");
		jtf6= new JTextField(10);
		String [] header= {"ȸ�����̵�","�н�����","�̸�","��ȭ��ȣ","�ּ�","���ϸ���"};
		
		model = new DefaultTableModel(header, 0);
		
		table = new JTable(model);
		
		JScrollPane jsp = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton jb1 = new JButton("ȸ�� ���");
		JButton jb2 = new JButton("ȸ�� �߰�");
		JButton jb3 = new JButton("ȸ�� ����");
		JButton jb4 = new JButton("ȸ�� ����");
		JButton jb5 = new JButton("���� ����");
		
		container1.add(jl1);container1.add(jtf1);
		container1.add(jl2);container1.add(jtf2);
		container1.add(jl3);container1.add(jtf3);
		container1.add(jl4);container1.add(jtf4);
		
		container2.add(jl5);container2.add(jtf5);
		container2.add(jl6);container2.add(jtf6);
		
		container3.add(jb1);
		container3.add(jb2);
		container3.add(jb3);
		container3.add(jb4);
		container3.add(jb5);
		
		JPanel group = new JPanel(new BorderLayout());
		
		group.add(container2,BorderLayout.NORTH);
		group.add(jsp,BorderLayout.CENTER);
		group.add(container3,BorderLayout.SOUTH);
		
		add(container1,BorderLayout.NORTH);
		add(group,BorderLayout.CENTER);

	
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
				connect();
				insert();
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				jtf4.setText("");
				jtf5.setText("");
				jtf6.setText("");
				jtf1.requestFocus();
				model.setRowCount(0);
				select();
				
			}
		});
		
			jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				update();	
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				jtf4.setText("");
				jtf5.setText("");
				jtf6.setText("");
				jtf1.requestFocus();
				model.setRowCount(0);
				select();
					//DB���� ��ü ������ ��ȸ�ϴ� �޼��� ȣ��
			}
		});
		
			jb4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int result=JOptionPane.showConfirmDialog(null, "������ �����Ͻðڽ��ϱ�?","Ȯ��",JOptionPane.YES_NO_OPTION);
					if(result== JOptionPane.CLOSED_OPTION) {
						JOptionPane.showMessageDialog(null, "��Ҹ� Ŭ���ϼ̽��ϴ�.");
					}else if(result==JOptionPane.YES_OPTION) {
						connect();
						delete();
						
					}
					
				}
			});
			
			table.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					int row=table.getSelectedRow();
					jtf1.setText(model.getValueAt(row, 0).toString());
					jtf2.setText(model.getValueAt(row, 1).toString());
					jtf3.setText(model.getValueAt(row, 2).toString());
					jtf4.setText(model.getValueAt(row, 3).toString());
					jtf5.setText(model.getValueAt(row, 4).toString());
					jtf6.setText(model.getValueAt(row, 5).toString());
					
					
				}
			});
			
			jb5.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new Manage();
					dispose();
					
				}
			});
			
		
	}
	
	void connect() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user="web";
		String password="1234";
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} //connect ����
	
	void select() {
		
		try {
			sql="select * from member order by mem_name";
			
		
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String mid=rs.getString("mem_id");
				String mpw=rs.getString("mem_password");
				String mname=rs.getString("mem_name");
				String mphone=rs.getString("mem_contact");
				String maddr=rs.getString("mem_addr");
				int mmilleage=rs.getInt("mem_mileage");
				
				Object[] data = {mid,mpw,mname,mphone,maddr,mmilleage};
				model.addRow(data);

				
			}
			rs.close();pstmt.close();con.close();
		}catch(Exception e) {
			e.printStackTrace();
					
		}
	}
	
	void insert() {
		
		
		try {
			sql = "insert into member values(?,?,?,?,?,?)";
			pstmt= con.prepareStatement(sql);
			
			pstmt.setString(1, jtf1.getText());
			pstmt.setString(2, jtf2.getText());
			pstmt.setString(3, jtf3.getText());
			pstmt.setString(4, jtf4.getText());
			pstmt.setString(5, jtf5.getText());
			pstmt.setInt(6, Integer.parseInt(jtf6.getText()));
			
			int res=pstmt.executeUpdate();
			
			if(res>0) {
				JOptionPane.showMessageDialog(null, "ȸ�� �߰� ����");
			} else {
				JOptionPane.showMessageDialog(null, "ȸ�� �߰� ����");
				
			}
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void update() {
		// 1. �����ͺ��̽� ������ SQL�� �ۼ�
		
		
		try {
			sql="update member set mem_password=?,mem_name=? , mem_contact=?,mem_addr=?, mem_mileage=?  where mem_id=?";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, jtf2.getText());
			pstmt.setString(2, jtf3.getText());
			pstmt.setString(3, jtf4.getText());
			pstmt.setString(4, jtf5.getText());
			pstmt.setInt(5, Integer.parseInt(jtf6.getText()));
			pstmt.setString(6, jtf1.getText());
			
			// 2. ����Ŭ �����ͺ��̽��� SQL�� ���� �� SQL�� ����
			int res=pstmt.executeUpdate();
			if(res>0) {
				JOptionPane.showMessageDialog(null, "ȸ���������� ����!!!");
			} else {
				JOptionPane.showMessageDialog(null, "ȸ���������� ����~~~");
			}
			pstmt.close(); 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void delete() {
		//1. ����Ŭ �����ͺ��̽��� ������ SQL�� �ۼ�
		
		
		try {
			sql="delete from member where mem_id = ?";
			pstmt=con.prepareStatement(sql);
			
			
			int row= table.getSelectedRow();
			
			
			pstmt.setString(1, (String)model.getValueAt(row, 0));
			
			// 2.����Ŭ �����ͺ��̽��� SQL�� ���� �� SQL�� ����
			int res =pstmt.executeUpdate();
			if(res>0) {
				JOptionPane.showMessageDialog(null, "ȸ���������� ����!!!");
			} else {
				JOptionPane.showMessageDialog(null, "ȸ���������� ����~~~");
			}
			model.removeRow(row);		//���̺� ���� ���� ����
			
			//3. ����Ŭ �����ͺ��̽��� ����Ǿ� �ִ� �ڿ� ����.
			pstmt.close(); con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Manage_Inform_search();

	}

}
