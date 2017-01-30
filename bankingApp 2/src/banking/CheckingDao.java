package banking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

import ExamplePackage.ConnectionManager;

public class CheckingDao {

	
	public double deposit(double amount, String userId){
		
		double total=0.0;
		try{  
			
			System.out.println(userId);
			Connection con=(Connection) ConnectionManager.getConnection();
			String command = "Select balance from checkingAccount where userId="+"'"+ userId + "'";
			PreparedStatement ps= con.prepareStatement(command);
			ResultSet rs = ps.executeQuery(command);
			
			double currBalance=0.0;
			
			while(rs.next()){
			 currBalance =  rs.getDouble("balance");
			}
			
			total= amount + currBalance;
			String myTotal = String.valueOf(total);
			System.out.println(myTotal);
			
			
			String command2 = "update checkingAccount set balance=" + myTotal + " where userId="+ "'"+ userId+ "'";
		    ps= con.prepareStatement(command2);
			ps.executeUpdate();
	
		

		}catch(Exception e){  
		    
			System.out.println(e);
		
	
	}
		return total;
}
	
	
public double withdraw(double amount, String userId){
		
		double total=0.0;
		try{  
			
			Connection con=(Connection) ConnectionManager.getConnection();
			String command = "Select balance from checkingAccount where userId="+ "'"+ userId+ "'";
			PreparedStatement ps= con.prepareStatement(command);
			ResultSet rs = ps.executeQuery(command);
			
		
			double currBalance=0.0;
			
			while(rs.next()){
			 currBalance =  rs.getDouble("balance");
			}
			
			total= currBalance - amount;
			String myTotal = String.valueOf(total);
			System.out.println(myTotal);
			
			
			String command2 = "update checkingAccount set balance=" + myTotal + " where userId=" + "'"+ userId + "'";
		    ps= con.prepareStatement(command2);
			ps.executeUpdate();
	
		

		}catch(Exception e){  
		    
			System.out.println(e);
		
	
	}
		return total;
}
	
	
}
