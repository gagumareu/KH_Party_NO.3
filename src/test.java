import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

public class test {
	
	

	public static void main(String[] args) {
		
		
		DefualtTableModel

		Connection con = null;                   
		
		PreparedStatement pstmt = null;  
		String driver = "oracle.jdbc.driver.OracleDriver";     
		
		String ur1 = "jdbc:oracle:thin:@localhost:1521:xe";
		
		String user = "sooriowl";
		
		String password = "0641";
		
		
		try {
			Class.forName(driver);
						
			con = DriverManager.getConnection(ur1, user, password);
			
			
			
			
	
			String sql = "insert into payment values(orderNo_seq.nextval, ?, ?, ?, ?,  sysdate)";
			pstmt = con.prepareStatement(sql);
			
			
			
		
			
			
			
			
			
			
			
			
			
		
			
		int result = pstmt.executeUpdate();
		
		if(result > 0) {
			System.out.println("성공");
		}else {
			System.out.println(" 실패 ");
		}
		
		pstmt.close();
		con.close();
		
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
		
		
		

	}
}
