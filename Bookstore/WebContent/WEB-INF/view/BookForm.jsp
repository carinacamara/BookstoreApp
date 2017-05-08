<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Book</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Book</h1>
		<form:form action="saveBook" method="post" modelAttribute="book" commandName="book">
		<table>
			<tr>
				<td>Id:</td>
				<td><form:input path="idBook" /><form:errors path="idBook" ></form:errors></td>
			</tr>
			<tr>
				<td>Title:</td>
				<td><form:input path="title" /><form:errors path="title" ></form:errors></td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><form:input path="author" /><form:errors path="author" ></form:errors></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><form:input path="gender" /><form:errors path="gender" ></form:errors></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><form:input path="price" /><form:errors path="price" ></form:errors></td>
			</tr>
			<tr>
				<td>Stock:</td>
				<td><form:input path="stock" /><form:errors path="stock" ></form:errors></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
		
		<form action="/Bookstore/homeAdmin">
        <input type="submit" value="Logout"/>
    </form>
	</div>
</body>
</html>