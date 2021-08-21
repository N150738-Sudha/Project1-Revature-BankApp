function validate() {
	var username = document.getElementById("userId").value;
	var password = document.getElementById("password").value;
	if (username.length == 0) {
		alert("Please enter your username")
		return false;
	}
	else if (password.length == 0) {
		alert("Please enter your password")
		return false;
	}
	else {
		alert("Welcome :" + username)
	}
}