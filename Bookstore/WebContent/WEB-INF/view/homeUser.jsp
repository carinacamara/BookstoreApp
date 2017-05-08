<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Manager Home</title>
    </head>
    <body>
    
  You are logged as User.
    
    		<div align="center">
	        <h1>Book List</h1>
	        <table border="1">
	        	<th>ID</th>
	        	<th>Title</th>
	        	<th>Author</th>
	        	<th>Gender</th>
	        	<th>Price</th>
	        	<th>Stock</th>
	        	<th>Sell</th>
	        	
				<c:forEach var="book" items="${listBook}">
	        	<tr>
	        		<td>${book.idBook}</td>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.gender}</td>
					<td>${book.price}</td>
					<td>${book.stock}</td>
					<td>
						<a href="sellBook?idBook=${book.idBook}">Sell</a>
						
					</td>
				
	        	</tr>
				</c:forEach>	        	
			</table>
			

			<form action="/Bookstore/searchTitle">
        <input type="submit" value="Search Book Title"/>
         </form>
        
        <form action="/Bookstore/searchAuthor">
        <input type="submit" value="Search Book Author"/>
         </form>
        
        <form action="/Bookstore/searchGender">
        <input type="submit" value="Search Book Gender"/>
         </form>
         
        
			<form action="/Bookstore/home">
        <input type="submit" value="Logout"/>
    </form>
    
    	</div>
    </body>
</html>
