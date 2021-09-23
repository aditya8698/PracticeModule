<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.practice.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
User u = new User();
u = (User)request.getAttribute("Values");
%>
<form action="UpdateServlet" method="get">
<h4>Update Form</h4>
Id : <input type="text" name="id" value="<%= u.getId()%>"><br>
<br>
Name : <input type="text" name="name" value="<%= u.getName()%>"><br>
<br>
City : <input type="text" name="city" value="<%= u.getCity()%>"><br>
<br>
<input type="submit" value="update">
</form>
</body>
</html>