<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Country</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"  %>
<h4>View &amp; Edit Country Details here</h4>
	<table border = "1px solid black">
	
		<tr>
			<th>Country Name</th>
			<th>Description</th>
			<th colspan = "2">Action</th>
		
		</tr>
		<c:forEach items="${clist}" var="i">
		<tr>
		
			<td>${i.cname}</td>
			<td>${i.cdesc}</td>
			<td colspan = "2">
							<a href="deleteCountry.html?id=${i.id}"><button type="submit" class="btn btn-primary">Delete</button></a>&nbsp;&nbsp;
							<a href="editCountry.html?id=${i.id}"><button type="submit" class="btn btn-primary">Edit</button></a>
			</td>
		
		</tr>
		</c:forEach>
	
	</table>

</body>
</html>