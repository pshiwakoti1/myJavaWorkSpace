<html>
<head>
<%@page import="com.s3s.models.*"%>
<%@page import="java.util.*"%>
<jsp:useBean id="customer" class="com.s3s.models.Customer" scope="page" />
<jsp:useBean id="customerSerivce"
	class="com.s3s.services.CustomerService" scope="page" />

<title>User Details</title>
</head>
<body>

	<%
		//populate request object
		
		customer.setFirstName(request.getParameter("firstName"));
		customer.setLastName(request.getParameter("lastName"));
		customer.setEmail(request.getParameter("email"));
		customer.setAddress(request.getParameter("address"));
		customer.setAge(Integer.parseInt(request.getParameter("age")));
		
		boolean success = customerSerivce.addCustomer(customer);
		
		if (!success) {
			response.sendRedirect(request.getContextPath() + "/pages/signUp.jsp");
		}
		List<Customer> customerList = customerSerivce.getCustomers();
	%>

	<table>
		<thead>
			<tr>
				<td>ID</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Email</td>
				<td>Address</td>
				<td>Age</td>

			</tr>
		</thead>
		<tbody>
			<%
				for (Customer cust : customerList) {
			%>
			<tr>
				<td><%=cust.getId()%></td>
				<td><%=cust.getFirstName()%></td>
				<td><%=cust.getLastName()%></td>
				<td><%=cust.getEmail()%></td>
				<td><%=cust.getAddress()%></td>
				<td><%=cust.getAge()%></td>

			</tr>

			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>