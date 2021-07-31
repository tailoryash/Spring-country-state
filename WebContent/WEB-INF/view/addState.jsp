<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>State ADD</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>

<h4>Enter State Details here !</h4>

<f:form action="addStateData.html" method = "Post" modelAttribute="sVO">
	Select Country: <f:select path = "cVO.id">
							<option value = "Select">Select </option> 
						<c:forEach items="${clist}" var="i">
  							<f:option value="${i.id}">${i.cname}</f:option>
  						</c:forEach>
					</f:select> <br><br>
					<f:hidden path = "id"/>
		
	<div class="form-group">
    <label for="formGroupExampleInput">State Name:</label>
    <f:input path = "sname" value = "${sVO.sname}" class="form-control" placeholder="Enter state name"/>
  	</div>  <br>
  	
	<div class="form-group">
    <label for="formGroupExampleInput">Description:</label>
    <f:input path = "sdesc" value = "${sVO.sdesc}" class="form-control" placeholder="Enter state description"/>
  	</div> <br> <br>
	 
	<button type="submit" class="btn btn-primary">ADD</button>  <hr>

</f:form>
</body>
</html>