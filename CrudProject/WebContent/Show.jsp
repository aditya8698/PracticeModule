<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.practice.dao.UserDao,java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Details Table</h2><br>
<input type="button" value="Add info"
			onclick="window.location.href='Home.jsp';return false;"><br>
		<br>
<table border = "1">
<tr>
<th>Id</th>
<th>Name</th>
<th>City</th>
<th>Action</th>
</tr>
<%
UserDao dao = new UserDao(); 
ResultSet rs5 = dao.getUser();
while(rs5.next()){
%>
<tr>
	 <td><%=rs5.getInt(1) %></td> 
	<td><%=rs5.getString(2) %></td>
	<td><%=rs5.getString(3) %></td>
	<td><a href="BeforeUpdate?id=<%=rs5.getInt(1) %>">Update</a>|<a href="DeleteUser?id=<%= rs5.getInt(1)%>">Delete</a></td>
</tr>
<% } %>
</table>
</body>
</html>