<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"	href="./styles.css">
<title>Particulier</title>
</head>
<body>

<form method="post" action="ControleurAnnuaire?action=nouveauParticulier">
	<div class="container">
		<label><b>Prenom</b></label> 
		<input type="text" name="prenom" required>
		<label><b>Nom</b></label> 
		<input type="text" name="nom" required>
		<label><b>Téléphone</b></label> 
		<input type="text" name="phone" required>
		<label><b>Courriel</b></label> 
		<input type="text" name="email" required>
		<label><b>Numero civique</b></label> 
		<input type="text" name="numCivique" required>
		<label><b>Rue</b></label> 
		<input type="text" name="rue" required>
		<label><b>Ville</b></label> 
		<input type="text" name="ville" required>
		<label><b>Code Postal</b></label> 
		<input type="text" name="postalCode" required>
		<label><b>Province</b></label> 
		<input type="text" name="province" required>
		
		<input type="hidden" name="admin" value="<%=request.getParameter("admin")%>">
		<div class="clearfix">
			<button type="button" class="cancelbtn">Cancel</button>
			<button type="submit" class="signupbtn">Créer</button>
		</div>
	</div>
</form>

</body>
</html>