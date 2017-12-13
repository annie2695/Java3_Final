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
<title>Annuaire</title>
</head>
<body>
	
	<h1>Annuaire!</h1>
	<hr>
	
	<table>
		<thead>
			<tr>
				<th>Id</th>
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
				<td><%= ((Contact)c).getId()%></td>
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
				<td><%= ((Contact)c).getId()%></td>
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
</body>
</html>