package team3.init;

import java.awt.EventQueue;

public class Run {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Init in = new Init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
