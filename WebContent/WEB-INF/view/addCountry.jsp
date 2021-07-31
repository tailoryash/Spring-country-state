<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<h4>Enter Country Details here !</h4>
	<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
	
	<f:form action="addCountryData.html" method = "Post" modelAttribute="cVO">
	
	<div class="form-group">
    <label for="formGroupExampleInput">Country Name:</label>
    <f:input path = "cname" class="form-control" placeholder="Enter country name"/>
  	</div>  <br>
  	
	<div class="form-group">
    <label for="formGroupExampleInput">Description:</label>
    <f:input path = "cdesc" class="form-control" placeholder="Enter country description"/>
  	</div> <br> <br>
	 
	<button type="submit" class="btn btn-primary">ADD</button>
		<f:hidden path="id" />   <hr>

	</f:form>
</body>
</html>