package ExamplePackage;

import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

public class RegisterDao {  
  
public static int register(UserBean u){  
int status=0;  
try{  
	
	Connection con=(Connection) ConnectionManager.getConnection();
	String command = "INSERT INTO users (FirstName,LastName,username,password) VALUES(?,?,?,?)";
	PreparedStatement ps= con.prepareStatement(command);
	ps.setString(1,u.getFirstName()); 
	ps.setString(2,u.getLastName());
	ps.setString(3,u.getUsername());  
	ps.setString(4,u.getPassword());
	
	status=ps.executeUpdate();  


}catch(Exception e){}  
      
return status;  
}  
  
}
