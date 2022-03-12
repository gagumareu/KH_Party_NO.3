package team3.booktable;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class stre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stre frame = new stre("","");
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
	public stre(String bname , String mname) {
		
		
	// 디자인 할때 아래	두줄 주석처리
//	}
//	public void stre2(String bname) {
		
		//디자인 할대 윙 ㅔ두줄 주석처리
		
		setTitle("선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 293, 211);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton jb1 = new JButton("별점 등록");
		jb1.setIcon(null);
		jb1.setBackground(UIManager.getColor("textHighlight"));
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jb1.setForeground(UIManager.getColor("inactiveCaptionText"));
		jb1.setFont(new Font("굴림", Font.BOLD, 15));
		jb1.setBounds(12, 10, 115, 109);
		contentPane.add(jb1);
		
		JButton jb2 = new JButton("리뷰 등록");
		jb2.setIcon(null);
		jb2.setForeground(new Color(0, 0, 0));
		jb2.setFont(new Font("굴림", Font.BOLD, 15));
		jb2.setBounds(150, 10, 115, 109);
		contentPane.add(jb2);
		
		JButton jb3 = new JButton("취 소");
		jb3.setIcon(null);
		jb3.setForeground(new Color(0, 0, 0));
		jb3.setBounds(90, 139, 97, 23);
		contentPane.add(jb3);
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reviewmake rm = new reviewmake(bname,mname);
				rm.setVisible(true);
				setVisible(false);
			}
		});
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				starmake sm = new starmake(bname);
				sm.setVisible(true);
				
			}
		});
	}

}
