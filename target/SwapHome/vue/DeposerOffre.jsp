<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="controleur.*" %>
<%@ page import="java.util.*" %>

<div class="background3">
<h3 style="color:white;" class="titre_inscription"> Déposer votre logements</h3>

<% 
		Logement leLogement = null;
	if (request.getParameter("action") != null && request.getParameter("idlogement") !=null)
	{
		String action 	=	request.getParameter("action");
		int idlogement 	= 	Integer.parseInt(request.getParameter("idlogement"));
		
		switch(action)
		{
			case "sup" : Controleur.deleteLogement(idlogement);break;
			case "edit": 
				leLogement = Controleur.selectWhereLogement(idlogement);
				out.print(idlogement);
				break;		
		}
	}
%>


<% 	
	
	ArrayList<Localite> lesLocalites1 = Controleur.selectAllLocalites();
	
	String optionLocalites = "";
	for (Localite uneLocalite : lesLocalites1)
	{
		optionLocalites +=  "<option value=\"" + uneLocalite.getCodelocalite() + "\" " + (leLogement!=null && leLogement.getCodelocalite() == uneLocalite.getCodelocalite() ? " \"selected \"" : "") + " >" + uneLocalite.getLibelle() + "</option>";
	}
	
	
	ArrayList<TypeLogement> lesTypeLogements1= Controleur.selectAllTypeLogements();
	
	String optionTypeLogements = "";
	for ( TypeLogement unTypeLogement: lesTypeLogements1)
	{
		optionTypeLogements +=  "<option value=\"" + unTypeLogement.getCodetypelogement() + "\" " + (leLogement!=null && leLogement.getCodetypelogement() == unTypeLogement.getCodetypelogement() ? " \"selected \"" : "") + " >" + unTypeLogement.getLibelle() + "</option>";
	}
%>
<form method="post">
	<table class="insert_info">
		<tr>
		 	<td> Code localite </td> 	
		 	<td>
	 			<select name="codelocalite" id="codelocalite">  
				   <%= optionLocalites%> 
				</select>	 		
	 		</td>
		 </tr>
		 
		 <tr>
		 	<td> Code Type logement </td>
		 	<td> 
		 	<select name="codetypelogement" id="codetypelogement">  
		 	 <%= optionTypeLogements%> 
		 	 </td>
		 </tr>
		 
		 <tr>
		 	<td> Libelle </td>
		 	<td> <input type="text" name ="libelle" 
		 	value='<%= (leLogement!=null)?leLogement.getLibelle() : "" %>'> </td>
		 </tr>
		 
		 <tr>
		 	<td> Description </td>
		 	<td> <input type="text" name ="description" 
		 	value='<%= (leLogement!=null)?leLogement.getDescription() : "" %>'> </td>
		 </tr>
		 
		 <tr>
		 	<td> Caracteristique </td>
		 	<td> <input type="text" name ="caracteristique" 
		 	value='<%= (leLogement!=null)?leLogement.getCaracteristique() : "" %>'> </td>
		 </tr>
		 
		 <tr>
		 	<td> Superficie (m2) </td>
		 	<td> <input type="text" name ="superficie" 
		 	value='<%= (leLogement!=null)?leLogement.getSuperficie() : "" %>'> </td>
		 </tr>
		 
		 <tr>
		 	<td> Animaux </td>
		 	<td>
		 		<select name="animaux" id="animaux">  
				    <option value="oui" <%= leLogement!=null && leLogement.getAnimaux().equals("oui") ? "selected" : "" %>>oui</option>
				    <option value="non" <%= leLogement!=null &&leLogement.getAnimaux().equals("non") ? "selected" : "" %>>non</option>			   
				</select>		 	
		 	</td>
		 </tr>
		 
		 <tr>
		 	<td> Enfants </td>
		 	<td>
		 		<select name="enfants" id="enfants">  
				    <option value="oui" <%= leLogement!=null && leLogement.getEnfants().equals("oui") ? "selected" : "" %>>oui</option>
				    <option value="non" <%= leLogement!=null && leLogement.getEnfants().equals("non") ? "selected" : "" %>>non</option>			   
				</select>		 	
		 	</td>
		 </tr>
		 
		 <tr>
		 	<td> Adresse </td>
		 	<td> <input type="text" name ="adresse" 
		 	value='<%= (leLogement!=null)?leLogement.getAdresse() : "" %>'> </td>
		 </tr>
		 
		 <tr>
		 	<td> Code Postal logement</td>
		 	<td> <input type="text" name ="cplogement" 
		 	value='<%= (leLogement!=null)?leLogement.getCplogement() : "" %>'> </td>
		 </tr>
		 
		 <tr>
		 	<td> Ville </td>
		 	<td> <input type="text" name ="villelogment" 
		 	value='<%= (leLogement!=null)?leLogement.getVillelogment() : "" %>'> </td>
		 </tr>
		 
		 
		 <tr>
		 	<td> Atouts  </td>
		 	<td> <input type="text" name ="atouts" 
		 	value='<%= (leLogement!=null)?leLogement.getAtouts() : "" %>'> </td>
		 </tr>
		 
		  <tr>
		 	<td> Disponibilité </td>
		 	<td>
		 		<select name="disponibilite" id="disponibilite">  
				    <option value="oui" <%= leLogement!=null && leLogement.getDisponibilite().equals("oui") ? "selected" : "" %>>oui</option>
				    <option value="non" <%= leLogement!=null && leLogement.getDisponibilite().equals("non") ? "selected" : "" %>>non</option>			   
				</select>	
				 	
		 	</td>
		 </tr>
		 
		  
		 
		 <tr>
		 	<td><input type="reset" name="Annuler" value="Annuler"> </td>
		 	<td> <input type="submit" 
		 	<%=  (leLogement!=null)? "name ='Modifier' value='Modifier'" :
		 				"name ='Valider' value='Valider'" %>
		 	> </td>
		 </tr>
		 
	</table>
</form>

<% 	int idproprietaire_session = (Integer)session.getAttribute("idproprietaire");
	if (request.getParameter("Valider") != null)
	{		
		int codelocalite = Integer.parseInt(request.getParameter("codelocalite"));
		int codetypelogement = Integer.parseInt(request.getParameter("codetypelogement"));
		int idproprietaire = idproprietaire_session;
		
		String libelle = request.getParameter("libelle");
		String description = request.getParameter("description");
		String caracteristique = request.getParameter("caracteristique");
		Float superficie = Float.parseFloat(request.getParameter("superficie"));
		String animaux = request.getParameter("animaux");
		String enfants = request.getParameter("enfants");
		String adresse = request.getParameter("adresse");
		String cplogement = request.getParameter("cplogement");
		String villelogment = request.getParameter("villelogment");
		String atouts=request.getParameter("cplogement");
		String disponibilite=request.getParameter("disponibilite");
		String photo="";

		//On instancie la classe logement
		
		Logement unLogement= new Logement(codelocalite,  codetypelogement,  idproprietaire,  libelle,
			 description,  caracteristique,  superficie,  animaux,  enfants,
			 adresse,  cplogement,  villelogment,  atouts,  disponibilite,photo);
		//appel du controleur pour execute l'insertion		
		Controleur.insertLogement(unLogement);
		out.print("<br/>  Insertion réussie");
	}
	
	//vue mes maisons
	


	// à faire: find id_proprietaire
	//int idproprietaire=1;
	
	int idproprietaire2 = (Integer)session.getAttribute("idproprietaire");
	ArrayList<Logement> MesMaisons1 =  Controleur.selectAllMesMaisons(idproprietaire2);
%>
<br><br>
<h2 style="color:white;" class="titre_inscription">Liste de mes logements</h2>
<div class="leslogments">
<table class="table_admin">
	<thead>
	<tr>
		<th>Id logement</th> 
		<th>Code Localite </th> 
		<th>Type logement</th> 
		<th>Proprietaire </th> 
		<th>Libelle</th> 
		<th>Description </th> 
		<th>Caracteristique</th> 
		<th>Superficie </th> 
		<th>Animaux </th>
		<th>Enfants </th>
		<th>Adresse </th>
		<th>CP logment </th>
		<th>Disponibilite</th>
		<th>Atouts </th>
		<th>Disponibilite </th>
		<th>Photo</th>
		<th>Action </th>
		
		
	</tr>
	</thead><tbody>
	<%
		String mesMaisons1 = ""; 
		for (Logement unLogement : MesMaisons1)
		{
			mesMaisons1 += "<tr> <td>"+unLogement.getIdlogement()+"</td>"; 
			mesMaisons1 += "     <td>"+unLogement.getCodelocalite()+"</td>"; 
			mesMaisons1 += "     <td>"+unLogement.getCodetypelogement()+"</td>"; 
			mesMaisons1 += "     <td>"+unLogement.getIdproprietaire()+"</td>"; 
			mesMaisons1 += "     <td>"+unLogement.getLibelle()+"</td>"; 
			mesMaisons1 += "     <td>"+unLogement.getDescription()+"</td>"; 
			mesMaisons1 += "     <td>"+unLogement.getCaracteristique()+"</td>"; 
			mesMaisons1 += "     <td>"+unLogement.getSuperficie()+"</td>"; 
			mesMaisons1 += "     <td>"+unLogement.getAnimaux()+"</td>"; 
			mesMaisons1 += "     <td>"+unLogement.getEnfants()+"</td>"; 
			mesMaisons1 += "     <td>"+unLogement.getAdresse()+"</td>"; 
			mesMaisons1 += "     <td>"+unLogement.getCplogement()+"</td>"; 
			mesMaisons1 += "     <td>"+unLogement.getVillelogment()+"</td>"; 
			mesMaisons1 += "     <td>"+unLogement.getAtouts()+"</td>"; 
			mesMaisons1 += "     <td>"+unLogement.getDisponibilite()+"</td>"; 
			mesMaisons1 += "     <td>"+unLogement.getPhoto()+"</td>"; 
					
			
			mesMaisons1 += "<td> "; 
			
			mesMaisons1 += "<a href='indexswap.jsp?page=9&action=sup&idlogement="+unLogement.getIdlogement()+"'>";
			mesMaisons1 += "<img src='images/sup.png' height='20' width='20'> </a>";
			
			mesMaisons1 += "<a href='indexswap.jsp?page=9&action=edit&idlogement="+unLogement.getIdlogement()+"'>";
			mesMaisons1 += "<img src='images/edit.png' height='20' width='20'> </a>";
			
			mesMaisons1 += "<a href='indexswap.jsp?page=15&idlogement="+unLogement.getIdlogement()+"'>";
			mesMaisons1 += "<img src='images/photo.png' height='20' width='20'> </a>";
			
			mesMaisons1 += "</td>";
			mesMaisons1 += "</tr>";
		}
		out.print(mesMaisons1); 
	%>
	</tbody>
</table>

	
	<%
		int idproprietaire_session_modif = (Integer)session.getAttribute("idproprietaire");
			if (request.getParameter("Modifier") != null) {
				int idlogement = Integer.parseInt(request.getParameter("idlogement"));
				int codelocalite = Integer.parseInt(request.getParameter("codelocalite"));
				int codetypelogement = Integer.parseInt(request.getParameter("codetypelogement"));
				int idproprietaire = idproprietaire_session_modif;
				String libelle = request.getParameter("libelle");
				String description = request.getParameter("description");
				String caracteristique = request.getParameter("caracteristique");
				float superficie = Float.parseFloat(request.getParameter("superficie"));
				String animaux = request.getParameter("animaux");
				String enfants = request.getParameter("enfants");
				String adresse = request.getParameter("adresse");
				String cplogement = request.getParameter("cplogement");
				String villelogment = request.getParameter("villelogment");
				String atouts = request.getParameter("atouts");
				String disponibilite = request.getParameter("disponibilite");
				String photo="";

				Logement unLogement = new Logement(idlogement, codelocalite, codetypelogement, idproprietaire, libelle, description,
				caracteristique, superficie, animaux, enfants, adresse, cplogement, villelogment, atouts,
				disponibilite,photo);
				Controleur.updateLogement(unLogement);

				// Update Controleur.updateLogement(logement);	

				out.print("<br/>  Modification réussie");
				//response.sendRedirect("indexswap.jsp?page=9");
			}
		%>
	

</div>
	

<footer>
  <p>Author: Ilios Travel<br>
  <a style="text-decoration:none;" href="mailto:hege@example.com">info@iliostravel.com</a></p>
</footer>














