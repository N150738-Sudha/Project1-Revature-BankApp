function validate(){
		var username = document.getElementById("username").value
		var password = document.getElementById("password").value
		var confirmpassword = document.getElementById("confirmpassword").value
		var emailId = document.getElementById("emailId").value
		var mobile = document.getElementById("mobile").value

		
		if(username.length ==0)
		{
			alert("User name is mandatory");
			return false;
		}
		else if(password.length ==0)
		{
				alert("Password is mandatory");
				return false;
		}
		else if(confirmpassword.length ==0)
		{
				alert("Confirm Password is mandatory");
				return false;
		}
		else if(confirmpassword != password)
		{
				alert("Confirm Password and password must be same");
				return false;
		}
		else if(emailId.length ==0)
		{
				alert("Email is mandatory");
				return false;
		}
		else if(mobile.length ==0)
		{
				alert("Mobile is mandatory");
				return false;
		}
		else
		{
			alert("Welcome :"+username);
			return true;
		}
}