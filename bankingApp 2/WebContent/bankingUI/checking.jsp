<html>
<body bgcolor="fuschia">
<head>
<style>
.div1 {
    width: 300px;
    height: 50px;
    border: 1px solid blue; 
}
.div2 {
    width: 300px;
    height: 60px;
    border: 1px solid blue; 
}
</style>
</head>
<%@ page import="banking.Checking"%>
<%@ page import="ExamplePackage.UserBean"%>
<%@ page import="ExamplePackage.ConnectionManager"%>
<%@ page import="com.mysql.jdbc.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>


 Your Session ID is: 
      <% String id=(String) session.getAttribute("currentSessionId");
        out.println(id);     
     %> <br>
     
      <% UserBean user = (UserBean) session.getAttribute("currentSessionUser"); %>

<h5> Shiwakoti Banking Institution</h5>
<h1> Checking Account </h1><br><br>

<%=user.getFirstName() + " " + user.getLastName()%>


<% 
double currBalance=0.0;
String accountNum="";
try{  
			
			Connection connection=(Connection) ConnectionManager.getConnection();
			String command = "Select balance from checkingAccount where userId="+ "'" + user.getUsername() + "'";
			String command2 = "Select accountNumber from checkingAccount where userId="+"'"+ user.getUsername() + "'";
			
		
			PreparedStatement ps= connection.prepareStatement(command);
			PreparedStatement ps2= connection.prepareStatement(command2);
			ResultSet rs = ps.executeQuery(command);
			ResultSet rs2 = ps2.executeQuery(command2);
			
			while(rs.next()){
			 currBalance =  rs.getDouble("balance");
			}

			while(rs2.next()){
			 accountNum =  rs2.getString("accountNumber");
			}

}catch(Exception e){
	System.out.println(e);
}
%>


<div class="div1">
Account No:<% out.println(accountNum); %> <br>
Available Balance: $<%out.println(currBalance); %><br>
</div>

<br><br><br>

<div class="div2">

<form action="addBalance.jsp">
  Add Balance:<br>
  Enter Amount <input type="text" name="addBalance"><br>
 <input type="submit" value="Add Balance">
  </form> <br><br>
  </div>
  
  <br>
  <div class="div2">
  <form action="withdraw.jsp">
  WithDraw:<br>
  Enter Amount: <input type="text" name="withdrawAmount"><br>
<input type="submit" value="Withdraw Amount">
</form>
</div>

<br><br><br>
	
	 <a href="logout.jsp">Logout</a>
</body>
</html>
