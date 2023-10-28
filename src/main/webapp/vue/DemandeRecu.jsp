<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="controleur.*" %>
<%@ page import="java.util.*" %>

<div class="background_demanderecu">
<h1 style="color:white;weight:bolder;font-size:25px;padding-top:40px;"class="sous_titre" >Liste de demande reçu</h1>

<% 
	int idproprietaire_session_recu = (Integer)session.getAttribute("idproprietaire");
	ArrayList<DemandeRecu> mesDemandesRecus =  Controleur.selectAllDemandeRecus(idproprietaire_session_recu);

%>

<table class="table_admin">
	<tr>
		<th>ID echanger</th> 
		<th>Date_demande</th> 
		<th>id_proprietaire_envoyer </th> 
		<th>Nom</th> 
		<th>Prenom </th> 
		<th>Libelle</th> 
			<th>Action</th> 
	
	</tr>
	
<%
		String mesDemandeRecu = ""; 
		for (DemandeRecu uneDemandeRecu : mesDemandesRecus)
		{
			mesDemandeRecu += "<tr> <td>"+uneDemandeRecu.getIdechanger()+"</td>"; 
			mesDemandeRecu += " <td>"+uneDemandeRecu.getDatedemande()+"</td>"; 
			mesDemandeRecu += "     <td>"+uneDemandeRecu.getIdproprietaire_envoyer()+"</td>"; 
			mesDemandeRecu += "     <td>"+uneDemandeRecu.getNom()+"</td>"; 
			mesDemandeRecu += "     <td>"+uneDemandeRecu.getPrenom()+"</td>"; 
			mesDemandeRecu += "     <td>"+uneDemandeRecu.getLibelle()+"</td>"; 
			
					
			
			mesDemandeRecu += "<td> "; 
			
			mesDemandeRecu += "<a href='indexswap.jsp?page=13&action=voir&idproprietaire_envoyer=" + uneDemandeRecu.getIdproprietaire_envoyer() + "&idechanger=" + uneDemandeRecu.getIdechanger() +"'>";
			mesDemandeRecu += "Voir </a>";
			
			
			
			mesDemandeRecu += "</td>";
			mesDemandeRecu += "</tr>";
		}
		out.print(mesDemandeRecu); 
	%>
</table>
</div>

<footer>
  <p>Author: Ilios Travel<br>
  <a style="text-decoration:none;" href="mailto:hege@example.com">info@iliostravel.com</a></p>
</footer>


