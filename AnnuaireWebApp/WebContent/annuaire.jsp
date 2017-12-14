<%@page import="com.bean.contact.Entreprise"%>
<%@page import="com.bean.contact.Particulier"%>
<%@page import="com.bean.IBean"%>
<%@page import="com.bean.annuaire.Annuaire"%>
<%@page import="com.bean.contact.Contact"%>
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
<title>Annuaire</title>
</head>
<body>
<div class="container">
	<h1>Annuaire!</h1>
	<hr>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nom</th>
				<th>Téléphone</th>
				<th>Courriel</th>
				<th>Adresse</th>
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
			</tr>
	<%
		}
	%>
	
	<%
		for(IBean c : Annuaire.getInstance().getListeEntreprise()){
	%>
			<tr>
				<td><%= ((Entreprise)c).getNomEntreprise()%></td>
				<td><%= ((Contact)c).getTelephone()%></td>
				<td><%= ((Contact)c).getCourriel()%></td>
				<td><%= ((Contact)c).getAddress().toString()%></td>				
			</tr>
	<%
		}
	%>
		</tbody>
	</table>
</div>
</body>
</html>