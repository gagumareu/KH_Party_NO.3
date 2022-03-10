package team3.booktable;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class stre extends JFrame {
	
	public stre() {}
	public void stre(String bname) {
		
		setTitle("선택");
		
		JButton jb1 = new JButton("별점만 등록");
		JButton jb2 = new JButton("리뷰 등록");
		JButton jb3 = new JButton("취소");
		
		JPanel jp = new JPanel(new GridLayout(1,2,15,15));
		jp.add(jb1);
		jp.add(jb2);
		JPanel jp2 = new JPanel();
		jp2.add(jb3);
		
		add(jp, BorderLayout.NORTH);
		add(jp2, BorderLayout.SOUTH);
		
		setSize(300, 120);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reviewmake rm = new reviewmake();
				rm.reviewmake(bname);
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
				starmake sm = new starmake();
				sm.starmake(bname);
				
			}
		});
		
	}

	public static void main(String[] args) {
		stre st = new stre();
		
		st.stre("test");

	}

}
