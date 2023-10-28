
<%@ page import="controleur.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.Date" %>
<center>
<div class="background_demandeEchange">
<h2 class="titre_inscription">Veulliez de saisir les informations suivants</h2>
	
	
	<div class="form_inscription">
	<form class="w3-container w3-card-4" method="post">
	 <label class="w3-text-blue">Profilvoyageur</label><br>
	 <select name="profil" id="profil">
	    <option value="">--Please choose an option--</option>
	    <option value="Solo">Solo</option>
	    <option value="En couple">En couple</option>
	</select>
	  <br><br>
	
	  
	  
	  <input style="margin-bottom:30px;" class="w3-btn w3-blue" type="submit" value="Valider" name="Valider">
	</form> 
	</div>
<% 
	
	if (request.getParameter("Valider") != null)
	{ 
		String dateinscription = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		
		//String dateinscription="2022/09/09";
		String profilvoyageur = request.getParameter("profil");
		String photoprofil = request.getParameter("photo");
		
		String datedernierconnexion=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(new Date());
		//String datedernierconnexion="2022/09/09";
		
		int iduser= Integer.valueOf(request.getParameter("id_user")); 
	
		Proprietaire unProprietaire=new Proprietaire(dateinscription, profilvoyageur, datedernierconnexion,iduser);
		//insert into table user
		Controleur.insertProprietaire(unProprietaire);		
		//out.print("<br/>  Insertion réussie");
		
	}

%>
</div>
</center>
