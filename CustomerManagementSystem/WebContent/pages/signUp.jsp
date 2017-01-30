<html>

<head>
<title>sign up page</title>
</head>


<body>
	<form name="signup" action="<%=request.getContextPath()%>/pages/userDetails.jsp"
		method="post">
		<table id="signupTable">
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>last Name:</td>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="reset" value="clear" /><input type="submit"
					value="sign up"></td>
			</tr>
		</table>
	</form>
</body>
</html>
