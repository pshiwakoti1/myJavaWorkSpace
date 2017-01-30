<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 
<html>
<head>
<title>SELECT Operation</title>
</head>
<body bgcolor="fuschia">
 
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/TEST"
     user="root"  password="wisdom1A%"/>
 
<sql:query dataSource="${snapshot}" var="result">
select * from users;
</sql:query>
 
<table border="1" width="80%">
<tr>
   <th>First Name</th>
   <th>Last Name</th>
   <th>User Name</th>
   <th>Password</th>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
   <td><c:out value="${row.firstName}"/></td>
   <td><c:out value="${row.lastName}"/></td>
   <td><c:out value="${row.username}"/></td>
   <td><c:out value="${row.password}"/></td>
</tr>
</c:forEach>
</table>
 
</body>
</html>