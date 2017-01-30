<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@page import="ExamplePackage.RegisterDao"%>  

<jsp:useBean id="obj" class="ExamplePackage.UserBean"/>  
<jsp:setProperty property="*" name="obj"/>  
  

<%  
int status= RegisterDao.register(obj);  
if(status>0)  
out.print("You are successfully registered");  
  
%>  