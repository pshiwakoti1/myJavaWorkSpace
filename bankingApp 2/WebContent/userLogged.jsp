<%@ page language="java" 
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
         import="ExamplePackage.UserBean"
   %>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
 <title>   User Logged in Successfully   </title>
 </head>
 
 <style>
     p {
    	border: 1px solid powderblue;
 	   }
</style>
 
<body bgcolor="fuschia">
      
      
      Your Session ID is: 
      <% String id=session.getId();
         session.setAttribute("currentSessionId", id);
	     out.println(id);     
     %> <br>
     
      <% UserBean user = (UserBean) session.getAttribute("currentSessionUser"); %>

         <p><h5> Welcome to your login page <%=user.getFirstName() %></h5><br>
         
         <h3><font color="green"> Here are the details of your profile: </font></h3><br> 
       
        <p>
         FirstName: <%=user.getFirstName() %> <br>
         LastName: <%=user.getLastName() %> <br> 
         UserName: <%=user.getUsername() %> <br> 
         Password: <%=user.getPassword() %> <br><br><br>
         
         
         <a href="bankingUI/openCheckingAccount.jsp">Open Checking Account</a><br>
         
          
            <a href="bankingUI/checking.jsp">My Checking Account</a> <br>
            <a href="bankingUI/savings.jsp">My Savings Account</a> <br>
            <a href="allUsers.jsp">See Other Bank Members</a> <br><br>
          </p>
      </body>
	 
	<br><br><br>
	
	 <a href="logout.jsp">Logout</a>
   </html>