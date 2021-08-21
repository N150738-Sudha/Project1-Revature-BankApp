<%@page import="com.revature.pms.model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="css/mainStyle.css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<form>
<body>
	<h2>Customer details</h2>
	<%
	List<Customer> customers = (List<Customer>) session.getAttribute("allCustomers");
	%>
	<table cellpadding="10" cellspacing="10">
		<th>Customer Id</th>
		<th>Customer Name</th>
		<th>Email</th>
		<th>Mobile</th>
		<th>Registration Date</th>
		<th>Delete</th>
		<%
		for (int i = 0; i < customers.size(); i++) {
			Customer customer = customers.get(i);
		%>
		<tr>
			<td><%= customer.getCustomerId() %></td>
			<td><%= customer.getCustomerName() %></td>
			<td><%= customer.getEmailId() %></td>
			<td><%= customer.getMobileNumber() %></td>
			<td><%= customer.getRegistrationDate() %></td>
			<td><a href="DeleteCustomerController?customerId=<%= customer.getCustomerId() %>">Delete</a></td>
		</tr>
		<%
		}
		%>

	</table>

<br/>
<br/>
<br/>
<h2><button formaction="getCustomerById.html" class="btn btn-primary btn btn-outline-dark">Search By Id</button></h2><br/>
<br/>
<br/>
<h2><button formaction="getCustomerByName.html" class="btn btn-primary btn btn-outline-dark">Search By Name</button></h2><br/>
<br/>
<br/>
<h2><button formaction="employeeUserStories.html" class="btn btn-primary btn btn-outline-dark">Home</button></h2><br/>
</form>
</body>
</html>