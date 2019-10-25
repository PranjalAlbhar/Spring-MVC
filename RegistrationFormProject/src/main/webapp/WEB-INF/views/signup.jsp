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
	<%! String emaildata;%>
	<%= emaildata=request.getParameter("errorMessage") %>

	<form >
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>
	
	  <label for="firstname"><b>First Name</b></label>
    <input type="text" placeholder="Enter First Name" name="fname" required><br><br>
	
	  <label for="lastname"><b>Last Name</b></label>
    <input type="text" placeholder="Enter Last Name" name="lname" required><br><br>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required><br><br>
	    <c:if test = "${emaildata!=null}">
         <p>Error  <c:out value = "Already exists........"/><p>
      </c:if>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required><br><br>

    <p><b>Please select your gender:</b></p>
  <input type="radio" name="gender" value="male"> Male<br>
  <input type="radio" name="gender" value="female"> Female<br><br> 
   
	</div>
	 <label for="City"><b>City</b></label> 
	<select  name="city" >
    <option value="0">City:</option>
    <option  value="Pune">Pune</option>
    <option value="Ahmednagar">Ahmednagar</option>
    <option   value="Mumbai">Mumbai</option>
    <option value="Nagpur">Nagpur</option>
    <option value="Kolhapur">Kolhapur</option>
    <option value="Nashik">Nashik</option>
  
  </select>
   
   

 <button type="submit">Register</button>
  <div class="container signin">
    <p>view Data <a href="viewData">View Data</a>.</p>
    <hr>
  </div>
</form>




</body>
</html>