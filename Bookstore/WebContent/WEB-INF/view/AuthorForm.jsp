<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Find Book Author</title>
</head>
<body>
<div align="center">
	<h1>Books</h1>
    <form:form action="/Bookstore/listAuthor" method="POST">
    
    <table>
    <tr>
     <td>  Title:
       <input name="author" type="text" /><form:errors path="author" ></form:errors>
       </td>
       </tr>
     
  
         <tr>
     <td> 
        <input type="submit" value="Find"/>
         </td>
       </tr> 
        
         </table>
    </form:form>
    
    
    
     <form action="/Bookstore/home">
        <input type="submit" value="Logout"/>
    </form>
    </div>
</body>
</html>