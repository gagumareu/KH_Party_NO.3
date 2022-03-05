package src.odermenu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Time_Menu extends JFrame{
	
	public Time_Menu() {
		
		setTitle("요금제 테이블");
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel();
		JPanel container4 = new JPanel(new BorderLayout());
		JPanel container5 = new JPanel();
		JPanel container6 = new JPanel();
		
		
		JRadioButton jrb1 = new JRadioButton("1시간추가");
		JRadioButton jrb2 = new JRadioButton("2시간추가");
		JRadioButton jrb3 = new JRadioButton("3시간추가");
		
		JRadioButton jrb4 = new JRadioButton("A요금제(5시간+음료");
		JRadioButton jrb5 = new JRadioButton("B요금제(8시간+음료)");
		JRadioButton jrb6 = new JRadioButton("C요금제(10시간+음료)");
		
		JRadioButton jrb7 = new JRadioButton("All-Day요금제(24시간)");
		
		
		JButton jb1 = new JButton("HOME");
		JButton jb2 = new JButton("장바구니");
		JButton jb3 = new JButton("음식 주문");
		JButton jb4 = new JButton("결제");

		JButton jb5 = new JButton("담기");
				
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		
		bg.add(jrb4);
		bg.add(jrb5);
		bg.add(jrb6);
		
		bg.add(jrb7);

		// 라디오 버튼 상
		container1.add(jrb1);
		container1.add(jrb2);
		container1.add(jrb3);
		//라디오 버튼 중
		container2.add(jrb4);
		container2.add(jrb5);
		container2.add(jrb6);
		// 라디오 버튼 하
		container3.add(jrb7);
		// 담기 버튼
		container6.add(jb5);
		
		// 라디오 버튼 컨테이너
		container4.add(container1, BorderLayout.NORTH);
		container4.add(container2, BorderLayout.CENTER);
		container4.add(container3, BorderLayout.SOUTH);
		
		// 하단 버튼 컨테이너
		container5.add(jb1);
		container5.add(jb2);
		container5.add(jb3);
		container5.add(jb4);
		
		add(container4, BorderLayout.NORTH);    
		add(container6, BorderLayout.CENTER);   
		add(container5, BorderLayout.SOUTH);   
		
		
		
		setBounds(750, 350, 500, 500);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Food_Menu();
				dispose();
				
			}
		});
		
		
		
	}
	
	
	

	public static void main(String[] args) {

		
		new Time_Menu();
	}

}
