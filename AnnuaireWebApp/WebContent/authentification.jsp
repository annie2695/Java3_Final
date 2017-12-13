<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.bean.compte.User"%> 
<%@page import="com.bean.IBean"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%User user = (User) request.getAttribute("user");%>

<h1>Bienvenue à toi 
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

<form method="post" action="ControleurAnnuaire?action=consulterAnnuaire">
			  <div class="container" style="background-color:#f1f1f1">
			     <button type="submit">Consulter Annuaire</button>
			  </div>
			</form>


</body>
</html>