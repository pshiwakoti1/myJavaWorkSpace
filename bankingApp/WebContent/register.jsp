<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>


<style>
div {
    background-color: lightgrey;
    width: 300px;
    border: 25px solid green;
    padding: 25px;
    margin: 25px;
}
</style>




</head>

<body>
<div>
<h1> User Registration</h1>
<form action="process.jsp">
  First name: <input type="text" name="firstName" onclick="this.value=''"><br>
  Last name:  <input type="text" name="lastName" onclick="this.value=''"><br>
   User name: <input type="text" name="username" onclick="this.value=''"><br>
   Password: <input type="text" name="password" onclick="this.value=''"><br>
   <input type="submit" value="Register"/> <br>
</form>
</div>

</body>
</html>