<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<link type="text/css" rel="stylesheet" href="css/mainStyle.css" />
<script type="text/javascript">
function validate(){
	var amount = document.getElementById("withdrawAmount").value;
	if(amount.length == 0 ){
		errorAmount.innerText = "Please enter the amount";
		return false;
	}
}
</script>
</head>
<body>
<h2 align="center"><u>Welcome to amount withdrawal section</u></h2>
<br/><br/><br/>
<form action="CustomerActionController" onsubmit="return validate()">
<table align="center">
<tr><td>Enter the amount to withdraw : Rs. <input type="number" name="amount" id="withdrawAmount"></td>
<td><input type="hidden" name = "action" id="action" value="withdraw" readonly="readonly"></td>
<td><font color="red"><div id="errorAmount"></div></font></td></tr>
<br/>
<br/>
<tr><td><input type = "submit" value="Withdraw money" class="btn btn-primary btn btn-outline-dark"></td></tr>
</table>
<br/><br/>
<h2><button formaction="customerUserStories.html" class="btn btn-primary btn btn-outline-dark">Home</button></h2><br/>
</form>
</body>
</html>