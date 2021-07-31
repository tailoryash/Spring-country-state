<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"  %>
<h4>Edit &amp; View State Details here</h4>
	<table border = "1px solid black">
	
		<tr>
		
			<th>State Name</th>
			<th>Description</th>
			<th>Country Name</th>
			<th colspan = "2">Action</th>
		
		</tr>
		<c:forEach items="${slist}" var="i">
		<tr>

			<td>${i.sname}</td>
			<td>${i.sdesc}</td>
			<td>${i.cVO.cname}</td>
			<td colspan = "2">
							<a href="deleteState.html?sid=${i.id}&cid=${i.cVO.id}"><button type="submit" class="btn btn-primary">Delete</button></a> &nbsp; &nbsp;
							<a href="editState.html?sid=${i.id}&cid=${i.cVO.id}"><button type="submit" class="btn btn-primary">Edit</button></a>
			</td>
		
		</tr>
		</c:forEach>
	
	</table>

</body>
</html>