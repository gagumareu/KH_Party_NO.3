package team3.odermenu;

import javax.swing.JOptionPane;

public class cash_checkOut {

	
	calculator();                   // 총 수량 및 총 결제 금액 메서드
	
	
	String paySelect = chooseComboBox.getSelectedItem().toString();				
	if(paySelect.equals(" 결제수단선택")) {           // 1-1. 결제 방식 선택 안했을 때 
		String[] cashOrCreadit = {"카드", "현금"};
		Object choose = JOptionPane.showInputDialog(
				null, 
				"지불 방법을 선택해주세요", 
				"결제수단", 
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				cashOrCreadit, 
				"결제수단");
		if(choose == "카드") {            // 1-2. 결제 방식 선택 안했을 때 - 카드 선택					
			chooseComboBox.setSelectedItem("카드");
			connect();
			//checkOut();
			cardReceipt();
		//	tAmount = 0;
		//   tSales = 0;
			 model.setRowCount(0);
		}else if(choose == "현금"){       // 1-3. 결제 방식 선택 안했을 때 - 현금 선택
			chooseComboBox.setSelectedItem("현금");
			connect();
			while(true) {
				if(cashTextField.getText().equals(null)) {
					String cashplz = JOptionPane.showInputDialog("현금을 입금 해주세요");
					cashTextField.setText(cashplz);
				}if(Integer.parseInt(cashTextField.getText().toString()) < tSales) {
					String reCheck = JOptionPane.showInputDialog("주문 하신 금액 이상으로 입금 부탁드립니다");
							cashTextField.setText(reCheck);
				}
				
			}
		}					
	}else if(paySelect.equals("카드")) {    // 2. 결제 방식 선택 후 				                                      
		connect();
		checkOut();
		cardReceipt();
		tAmount = 0;
		tSales = 0;
		model.setRowCount(0);					
	}else if(paySelect.equals("현금")){     // 2-2. 현금 결제
		connect();
		// 현금 입금 안했을 시 경고 창
		while(cashTextField.getText().equals(null)) {
			String cashplease = JOptionPane.showInputDialog("현금을 입급하세요");
			cashTextField.setText(cashplease);
			while(Integer.parseInt(cashTextField.getText().toString()) < tSales) {
				String recheck = JOptionPane.showInputDialog("주문 하신 총 결제 금액 이상으로 입금 하세요");
				cashTextField.setText(recheck);
			}
		}					
		checkOut();
		cashReceipt();
		tAmount = 0;
		tSales = 0;
		model.setRowCount(0);					
	}
}
