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

<style>

.div1 {
    width: 300px;
    height: 100px;
    border: 1px solid blue;
    box-sizing: border-box;
}

</style>


<body bgcolor="fuschia">


 Your Session ID is: 
      <% String id=session.getId();
         session.setAttribute("currentSessionId", id);
	     out.println(id);     
     %> <br>
     
      <% UserBean user = (UserBean) session.getAttribute("currentSessionUser"); %>

         <p><h5> Welcome to your CheckingAccount Administration page <%=user.getFirstName() %></h5><br>


Your Account number will be auto generated for your UserID.<br>
<form action="openCheckingAccount2.jsp">


<div class="div1">
Enter the initial balance to open CheckingAccount <input type="text" name="balance" > <br>
<input type="submit" value="Submit">

</form>
</div>



</body>
</html>