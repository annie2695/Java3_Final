<%@page import="com.bean.contact.Entreprise"%>
<%@page import="com.bean.contact.Particulier"%>
<%@page import="com.bean.annuaire.Annuaire"%>
<%@page import="com.bean.contact.Contact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.bean.compte.User"%> 
<%@page import="com.bean.IBean"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Ma page</title>
</head>
<body>
	
	<%User user = (User) request.getAttribute("user");%>

<h1>Bienvenue � toi 
<%	
	user.getId();
	if(user.getPrenom() == null){
		out.println(user.getCredentials().getUsername().substring(1)); 
	}
	else{
		out.println(user.getPrenom());
	}	
 %>
 

</h1>

<div class="container" style="background-color:#f1f1f1">
<form method="post" action="ControleurUser?action=consulterAnnuaire" style="float:left;">
	<input type="hidden" name="user" value="<%= user.getId()%>">
    <button type="submit">Consulter Annuaire</button>
</form>
<form method="post" action="ControleurUser?action=generePDF">
	<input type="hidden" name="user" value="<%= user.getId()%>">
    <button type="submit">Generer mon carnet</button>
</form>
</div>

<div class="container">
	<h1>Favoris</h1>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nom</th>
				<th>T�l�phone</th>
				<th>Courriel</th>
				<th>Adresse</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
	<% 
		for(IBean c : user.getAddressBook().getFavoris()){
	
	%>
			<tr>
		<%
			if (c instanceof Particulier){
		%>
				<td><%= ((Particulier)c).getPrenom()%> <%= ((Particulier)c).getNom()%></td>
		<%
			} else {
		%>
				<td><%= ((Entreprise)c).getNom()%></td>
		<%
			}
		%>
				<td><%= ((Contact)c).getTelephone()%></td>
				<td><%= ((Contact)c).getCourriel()%></td>
				<td><%= ((Contact)c).getAddress().toString()%></td>
				<td>
					<form action="ControleurUser?action=supprimeFavoris<%=c.getClass().getSimpleName()%>" method="post">
						<input type="hidden" name="user" value="<%=user.getId()%>">
						<input type="hidden" name="contact" value="<%=c.getId()%>">
						<input type="hidden" name="contactInstance" value="<%=c.getId()%>">
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

<div class="container">
	<h1>Contacts</h1>
	
	<h4>Particuliers</h4>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nom</th>
				<th>T�l�phone</th>
				<th>Courriel</th>
				<th>Adresse</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
	<%
		for(IBean c : user.getAddressBook().getListeParticuliers()){
	%>
			<tr>
				<td><%= ((Particulier)c).getPrenom()%> <%= ((Particulier)c).getNom()%></td>
				<td><%= ((Contact)c).getTelephone()%></td>
				<td><%= ((Contact)c).getCourriel()%></td>
				<td><%= ((Contact)c).getAddress().toString()%></td>
				<td>
					<form action="ControleurUser?action=AjoutFavorisP" method="post">
						<input type="hidden" name="user" value="<%=user.getId()%>">
						<input type="hidden" name="contact" value="<%=c.getId()%>">
						<button type="submit">Ajout Favoris</button>
					</form>
				</td>
				<td>
					<form action="ControleurUser?action=supprimeParticulier" method="post">
						<input type="hidden" name="user" value="<%=user.getId()%>">
						<input type="hidden" name="contact" value="<%=c.getId()%>">
						<button type="submit">Supprime</button>
					</form>
				</td>			
			</tr>
	<%
		}
	%>
		</tbody>
	</table>
	
	<h4>Entreprises</h4>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nom</th>
				<th>T�l�phone</th>
				<th>Courriel</th>
				<th>Adresse</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
	
	<%
		for(IBean c : user.getAddressBook().getListeEntreprises()){
	%>
			<tr>
				<td><%= ((Entreprise)c).getNom()%></td>
				<td><%= ((Contact)c).getTelephone()%></td>
				<td><%= ((Contact)c).getCourriel()%></td>
				<td><%= ((Contact)c).getAddress().toString()%></td>
				<td>
					<form action="ControleurUser?action=ajoutFavorisE" method="post">
						<input type="hidden" name="user" value="<%=user.getId()%>">
						<input type="hidden" name="contact" value="<%=c.getId()%>">
						<button type="submit">Ajout Favoris</button>
					</form>
				</td>
				<td>
					<form action="ControleurUser?action=supprimeEntreprise" method="post">
						<input type="hidden" name="user" value="<%=user.getId()%>">
						<input type="hidden" name="contact" value="<%=c.getId()%>">
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