 
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
     
     


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<h1>Employees List</h1>

	<%--
	*************************Whole data*****************
	
	 <c:forEach items="${allData}" var="item">
    ${item}<br>
</c:forEach> --%>

<form action="UpdatePage" method="POST">
	<table border="2" width="70%" >

	<tr><th>First Name</th><th> Last Name</th><th>Gender</th><th>City</th><th>E-mail</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach items="${allData}" var="item"> 
    <tr><td>${item.fname}</td>
  	<td>${item.lname}</td>
  	<td>${item.gender}</td>
  	<td>${item.city}</td>
    <td>${item.email}</td>
    <td><button>edit</button></td>
    <!-- <td><a href="UpdatePage">Edit</a></td> -->
    <td><a href="delete">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="registerData">Add New Employee</a>
	



</form>
	
</body>
</html>