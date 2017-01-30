<%@ page language="java" 
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
         import="java.util.Random"
         import="ExamplePackage.UserBean"
         import="ExamplePackage.ConnectionManager"
         import= "java.sql.PreparedStatement"
         import= "com.mysql.jdbc.Connection"
         
 %>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Open Checking Account</title>
</head>
<body bgcolor="fuschia">


 Your Session ID is: 
      <% String id=session.getId();
         session.setAttribute("currentSessionId", id);
	     out.println(id);     
     %> <br>
     
      <% UserBean user = (UserBean) session.getAttribute("currentSessionUser"); %>

         <p><h5> Welcome to your Checking Account Administration page <%=user.getFirstName() %></h5><br>


<%

int accNumber = 0; 
accNumber = (int)((Math.random() * 900000000)+1000000000); 
String myAccount = String.valueOf(accNumber);

Connection con=(Connection) ConnectionManager.getConnection();
String command = "INSERT INTO checkingAccount (userId,accountNumber,balance) VALUES(?,?,?)";
PreparedStatement ps= con.prepareStatement(command);
ps.setString(1, user.getUsername());
ps.setString(2, myAccount);
ps.setString(3, request.getParameter("balance"));

ps.executeUpdate();  

%>
Your Account is updated!! <br>

<a href="../userLogged.jsp">Back to your account</a>


</body>
</html>