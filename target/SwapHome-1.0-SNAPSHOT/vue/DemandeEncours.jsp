<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="controleur.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.Date" %>

<div class="background_demandeencours">
<h1 style="color:white;weight:bolder;font-size:25px;padding-top:40px;padding-bottom:20px;"class="sous_titre">Liste de demandes avec leur status</h1>
<%
		int idproprietaire_encours= (Integer)session.getAttribute("idproprietaire");

		ArrayList<Echanger> lesDemandesPlusStatus = Controleur.selectAllDemandesPlusStatus(idproprietaire_encours);

%>
<table class="table_admin">
	<tr>
		<th>Id echanger</td> 
		<th> ID proprietaire envoyer  </th> 
		<th> ID proprietaire recu  </th>
		<th> Id logement 1  </th>
		<th> Id logement 2  </th>
		<th> Date demande  </th>
		<th> Date repondre  </th>
		<th> Date entree  </th>
		<th> Date sortie  </th>
		<th> Status  </th>
		
	</tr>
	
	<%
		String chaineDemandeEncours = ""; 
		for (Echanger uneEchange : lesDemandesPlusStatus)
		{
			chaineDemandeEncours += "<tr> <td>"+uneEchange.getIdechanger()+"</td>"; 
			chaineDemandeEncours += "     <td>"+uneEchange.getIdpro1()+"</td>"; 
			chaineDemandeEncours += "     <td>"+uneEchange.getIdpro2()+"</td>"; 
			chaineDemandeEncours += "     <td>"+uneEchange.getIdlog1()+"</td>"; 
			chaineDemandeEncours += "     <td>"+uneEchange.getIdlog2()+"</td>"; 
			chaineDemandeEncours += "     <td>"+uneEchange.getDatedemande()+"</td>"; 
			chaineDemandeEncours += "     <td>"+uneEchange.getDaterepondre()+"</td>"; 
			chaineDemandeEncours += "     <td>"+uneEchange.getDateentre()+"</td>"; 
			chaineDemandeEncours += "     <td>"+uneEchange.getDatesortie()+"</td>"; 
			chaineDemandeEncours += "     <td>"+uneEchange.getStatus()+"</td>"; 
			
			chaineDemandeEncours += "</tr>";
		}
		out.print(chaineDemandeEncours); 
	%>
</table>
</div>
<footer>
  <p>Author: Ilios Travel<br>
  <a style="text-decoration:none;" href="mailto:hege@example.com">info@iliostravel.com</a></p>
</footer>
