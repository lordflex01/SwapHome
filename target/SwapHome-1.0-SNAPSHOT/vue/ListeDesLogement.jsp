
<h3 style="color:white;weight:bolder;padding-top:40px;padding-bottom:40px;font-size:50px;font-family: 'Playfair Display', serif;"class="sous_titre"> 
Liste des offres</h3>

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
		
		
	</tr>
	</thead>
	<tbody>
	
	
	<%
		
	
		int idproprietaire_encours1 = (Integer)session.getAttribute("idproprietaire");
		String lesOffres = ""; 
		for (Logement unLogement : lesLogements)
		{
			lesOffres += "<tr> <td>"+unLogement.getIdlogement()+"</td>"; 
			lesOffres += "     <td>"+unLogement.getCodelocalite()+"</td>"; 
			lesOffres += "     <td>"+unLogement.getCodetypelogement()+"</td>"; 
			lesOffres += "     <td>"+unLogement.getIdproprietaire()+"</td>"; 
			lesOffres += "     <td>"+unLogement.getLibelle()+"</td>"; 
			lesOffres += "     <td>"+unLogement.getDescription()+"</td>"; 
			lesOffres += "     <td>"+unLogement.getCaracteristique()+"</td>"; 
			lesOffres += "     <td>"+unLogement.getSuperficie()+"</td>"; 
			lesOffres += "     <td>"+unLogement.getAnimaux()+"</td>"; 
			lesOffres += "     <td>"+unLogement.getEnfants()+"</td>"; 
			lesOffres += "     <td>"+unLogement.getAdresse()+"</td>"; 
			lesOffres += "     <td>"+unLogement.getCplogement()+"</td>"; 
			lesOffres += "     <td>"+unLogement.getVillelogment()+"</td>"; 
			lesOffres += "     <td>"+unLogement.getAtouts()+"</td>"; 
			lesOffres += "     <td>"+unLogement.getDisponibilite()+"</td>"; 
			
			//id connexion en tant que propri sinon connexion
		
	
			
		}
		out.print(lesOffres); 
	%>
	</tbody>
</table>




