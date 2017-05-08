<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Manager Home</title>
    </head>
    <body>
    
    You are logged as Admin.
    
    	<div align="center">
	        <h1>Book List</h1>
	        <h3><a href="newBook">New Book</a></h3>
	        <table border="1">
	        	<th>ID</th>
	        	<th>Title</th>
	        	<th>Author</th>
	        	<th>Gender</th>
	        	<th>Price</th>
	        	<th>Stock</th>
	        	<th>Action</th>
	        	
				<c:forEach var="book" items="${bookList}">
	        	<tr>
	        		<td>${book.idBook}</td>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.gender}</td>
					<td>${book.price}</td>
					<td>${book.stock}</td>
					<td>
						<a href="editBook?idBook${book.idBook}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteBook?idBook=${book.idBook}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
			
        
			<form action="/Bookstore/home">
        <input type="submit" value="Logout"/>
    </form>
    	</div>
    </body>
</html>