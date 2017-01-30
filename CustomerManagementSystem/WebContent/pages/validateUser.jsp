
<%@ page import="com.s3s.services.*, com.s3s.models.*"%>
<%@ page import="java.util.*" %>

<jsp:useBean id="customerService"
	class="com.s3s.services.CustomerService" scope="request"></jsp:useBean>
<%
	String userName = request.getParameter("userName");
	String password = request.getParameter("password");
	List<Customer> userList = customerService.getCustomers();
	for(Customer customer: userList){
		if(customer.getEmail().equalsIgnoreCase(userName)){
			response.sendRedirect(request.getContextPath()+"/pages/userDetails.jsp");
		}
		else{
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	}
%>