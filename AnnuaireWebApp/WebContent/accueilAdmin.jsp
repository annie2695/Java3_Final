<%@page import="com.bean.contact.Entreprise"%>
<%@page import="com.bean.contact.Contact"%>
<%@page import="com.bean.contact.Particulier"%>
<%@page import="com.bean.annuaire.Annuaire"%>
<%@page import="com.bean.IBean"%>
<%@page import="com.bean.compte.Admin"%>
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
<title>Admin</title>
</head>
<body>
	<%Admin admin = (Admin) request.getAttribute("admin");%>


<h1>Bienvenue a toi 
<%	
	admin.getId();
	if(admin.getPrenom() == null){
		out.println(admin.getCredentials().getUsername().substring(1)); 
	}
	else{
		out.println(admin.getPrenom());
	}	
 %>
</h1>
<hr>

<div class="container">
<div class="container" style="background-color:#f1f1f1">
   <a class="btn btn-info" role="button" href="newParticulier.jsp?admin=<%= admin.getId()%>">Ajouter Particulier</a>
   <a class="btn btn-info" role="button" href="newEntreprise.jsp">Ajouter Entreprise</a>
 </div>
	<h4>Particuliers</h4>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nom</th>
				<th>Téléphone</th>
				<th>Courriel</th>
				<th>Adresse</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
	<%
		for(IBean c : Annuaire.getInstance().getListeParticulier()){
	%>
			<tr>
				<td><%= ((Particulier)c).getPrenom()%> <%= ((Particulier)c).getNom()%></td>
				<td><%= ((Contact)c).getTelephone()%></td>
				<td><%= ((Contact)c).getCourriel()%></td>
				<td><%= ((Contact)c).getAddress().toString()%></td>
				<td>
					<form action="ControleurAnnuaire?action=supprimeAnnuaireP" method="post">
						<input type="hidden" name="admin" value="<%= admin.getId()%>">
						<input type="hidden" name="contact" value="<%= c.getId()%>">
						<button type="submit">Supprime</button>
					</form>
				</td>
			</tr>
	<%
		}
	%>
		</tbody>
	</table>
	
	<h4>Enterprises</h4>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nom</th>
				<th>Téléphone</th>
				<th>Courriel</th>
				<th>Adresse</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
	
	<%
		for(IBean c : Annuaire.getInstance().getListeEntreprise()){
	%>
			<tr>
				<td><%= ((Entreprise)c).getNom()%></td>
				<td><%= ((Contact)c).getTelephone()%></td>
				<td><%= ((Contact)c).getCourriel()%></td>
				<td><%= ((Contact)c).getAddress().toString()%></td>
				<td>
					<form action="ControleurAnnuaire?action=supprimeAnnuaireE" method="post">
						<input type="hidden" name="admin" value="<%= admin.getId()%>">
						<input type="hidden" name="contact" value="<%= c.getId()%>">
						<button type="submit">Supprime</button>
					</form>
				</td>				
			</tr>
	<%
		}
	%>
		</tbody>
	</table>
</div>
</body>
</html>