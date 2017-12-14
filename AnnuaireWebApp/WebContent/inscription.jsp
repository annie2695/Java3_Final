<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"	href="./styles.css">
<title>Inscription</title>
</head>
<body>

	<form method="post" action="ControleurAnnuaire?action=inscription">
		<div class="container">
			<label><b>Email</b></label> 
			<input type="text" placeholder="Enter Email" name="email" required>
			<label><b>Username</b></label> 
			<input type="text" placeholder="Enter Username" name="username" required>  
			<label><b>Password</b></label>
			<input type="password" placeholder="Enter Password" name="psw"required><label><b>Repeat Password</b></label> 
			<input type="password" placeholder="Repeat Password" name="psw-repeat" required> 
			<label><b>Name</b></label> 
			<input type="text" placeholder="Enter Your Name" name="name">
			<label><b>Last Name</b></label> 
			<input type="text" placeholder="Enter Your Last Name" name="lname">
			<input type="checkbox" checked="checked">Remember me
			<p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
			
			<div class="clearfix">
				<button type="button" class="cancelbtn">Cancel</button>
				<button type="submit" class="signupbtn">Sign Up</button>
			</div>
		</div>
	</form>


</body>
</html>