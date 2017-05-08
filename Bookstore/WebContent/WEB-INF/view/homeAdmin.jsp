<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Manager Home</title>
    </head>
    <body>
    
    You are logged as Admin.
    
    	<div align="center">
	        <h1>User List</h1>
	        <h3><a href="newUser">New User</a></h3>
	        <table border="1">
	        	<th>ID</th>
	        	<th>Name</th>
	        	<th>Username</th>
	        	<th>Password</th>
	        	<th>Email</th>
	        	<th>Action</th>
	        	
				<c:forEach var="user" items="${userList}">
	        	<tr>
	        		<td>${user.idUser}</td>
					<td>${user.name}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.email}</td>
					<td>
						<a href="editUser?idUser=${user.idUser}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteUser?idUser=${user.idUser}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
			<a href="/Bookstore/listBook">See Books</a>
			
			<form action="/Bookstore/home">
        <input type="submit" value="Logout"/>
    </form>
    
    	</div>
    </body>
</html>