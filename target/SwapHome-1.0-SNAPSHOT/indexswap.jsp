
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="controleur.*" %>
<%@ page import="java.util.ArrayList" %>
<!-- 


 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/mystyle.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap" rel="stylesheet">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />


<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
<title>Admin SwapHome</title>
</head>
<body>
<center>



<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><img style="width:200px;" src="images/logoSwap.png"></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="indexswap.jsp?page=1">Accueil</a></li>
      
      <%
	
	if(session.getAttribute("login") != null && session.getAttribute("idproprietaire") == null)
	{
	%>
	 <li><a href="indexswap.jsp?page=2">Gestion des Pays</a></li>
     <li><a href="indexswap.jsp?page=3">Gestion Type logement</a></li>
     <li><a href="indexswap.jsp?page=4">Gestion Localite</a></li>
     <li><a href="indexswap.jsp?page=5">Liste de logements</a></li>
      
      <%		
	}
	else if(session.getAttribute("idproprietaire") != null)
	{	
	%>
      <li><a href="indexswap.jsp?page=9">Deposer une offre</a></li>
     <li><a href="indexswap.jsp?page=17">Offres</a></li>
     <li><a href="indexswap.jsp?page=12">Demande reçu</a></li>
     <li><a href="indexswap.jsp?page=11">Demande en cours</a></li>
     
      <%
	}
 	if(session.getAttribute("login") != null)
 	{
 	%>
 		<li><a href="indexswap.jsp?page=99">Deconnexion</a></li>
 	
 	<% 
 	}
 	else
	{
 	%>
 		<li><a href="indexswap.jsp?page=7">Inscription</a></li>
 		<li><a href="indexswap.jsp?page=8">Connexion</a></li>	
 	<% 
 	}
 	%>
 </ul>
  </div>
</nav>


	<%
		String chaine = ""; 
        int pages=1;
        if(request.getParameter("page") != null){
            pages = Integer.parseInt(request.getParameter("page"));
        } else {
            pages=1;
        }
        switch (pages){
        case 1 : %> <%@ include file="homeadmin.jsp" %> <% break;
        case 2 : %> <%@ include file="pays.jsp" %> <% break;
        case 3 : %> <%@ include file="typelogement.jsp" %> <% break;
        case 4 : %> <%@ include file="localite.jsp" %> <% break;
        case 5 : %> <%@ include file="logement.jsp" %> <% break;
        case 6 : %> <%@ include file="vue/mesMaisons.jsp" %> <% break;       
        case 7 : %> <%@ include file="inscription.jsp" %> <% break;       
        case 8 : %> <%@ include file="connexion.jsp" %> <% break;  
        case 9 : %> <%@ include file="vue/DeposerOffre.jsp" %> <% break; 
        case 10 : %> <%@ include file="vue/demanderEchange.jsp" %> <% break; 
        case 11 : %> <%@ include file="vue/DemandeEncours.jsp" %> <% break; 
        case 12 : %> <%@ include file="vue/DemandeRecu.jsp" %> <% break; 
        case 13 : %> <%@ include file="vue/infosProprietaireEnvoyer.jsp" %> <% break; 
        case 14 : %> <%@ include file="vue/vueProfil.jsp" %> <% break; 
        case 15 : %> <%@ include file="logement_photo_upload.jsp" %> <% break; 
        case 16 : %> <%@ include file="file_upload.jsp" %> <% break; 
        case 17 : %> <%@ include file="listeDesOffres.jsp" %> <% break; 
        case 99 : 
       		session.invalidate();
		 	response.sendRedirect("indexswap.jsp?page=1");
		 	break; 
        }
    %>
  
</center>
</body>   
</html>

