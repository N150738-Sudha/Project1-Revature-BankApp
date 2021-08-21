<%@page import="com.revature.pms.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="css/mainStyle.css" />

</head>
<h2 align="center"><u>My Profile</u></h2>
<body>
<form action="CustomerActionController" onsubmit="true">
<table cellpadding="10" cellspacing="10" align="center">
	<tr><td>Customer Id </td><td><input  type="text" name="customerId" id="id" value = <%=session.getAttribute("customerId") %> readonly="readonly"></td></tr>

	<tr><td>Customer Name </td><td><input  type="text" name="customerName" id="username" value = <%=session.getAttribute("customerName") %>></td></tr>
	<tr><td>Password </td><td><input  type="password" name="password" id="password" value = <%=session.getAttribute("password") %>/></td></tr>

	<tr><td>Mobile Number </td><td><input  type="text" name="mobileNumber" id="mobile" value = <%=session.getAttribute("mobile") %>/></td></tr>

	<tr><td>Email </td><td><input  type="email" name="emailId" id="emailId" placeholder="name@domain.com" value = <%=session.getAttribute("email") %>/></td></tr>
	<tr><input type="hidden" name="action" value="update"></tr>
	
<tr><h2><input type="submit" value="Update Profile" class="btn btn-primary btn btn-outline-dark"></h2></tr><br/>

	
</table>
</form>

<a href="customerUserStories.html">Home</a>
</body>
</html>