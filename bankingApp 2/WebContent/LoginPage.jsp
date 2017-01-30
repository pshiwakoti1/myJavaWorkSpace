<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>Login Page</title>
	</head>
<style>
.div2 {
    width: 300px;
    height: 175px;
    padding: 50px;
    border: 1px solid red;
}
</style>
    <body>
    <div class="div2">
      <h4><font color="red">Please login using your credentials</font></h4><br>
		<form action="LoginServlet">

			Please enter your username: <input type="text" name="userName"/><br>		
			Please enter your password: <input type="text" name="password"/>
			                            <input type="submit" value="submit">			
		    <h5>If you haven't registered before, please <a href="register.jsp">register</a> here.</h5>
		</form>
		</div>
	</body>
	
</html>
