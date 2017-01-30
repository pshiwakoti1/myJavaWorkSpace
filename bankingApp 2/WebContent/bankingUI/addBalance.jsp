<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="fuschia">
<%@ page import="banking.Checking"%>
<%@ page import="ExamplePackage.UserBean"%>

Your Session ID is: 
      <% String id=(String) session.getAttribute("currentSessionId");
        
	     out.println(id);     
     %> <br>

<br><br>
 
 <% UserBean user = (UserBean) session.getAttribute("currentSessionUser"); %>

<%
Checking checking = new Checking();


double balanceToAdd = Double.parseDouble(request.getParameter("addBalance"));
checking.deposit(balanceToAdd, user.getUsername());
out.println("Your balance $" + balanceToAdd+ " have beed added.");

%>

<br><br><br>
	
	 <a href="logout.jsp">Logout</a>

</body>
</html>