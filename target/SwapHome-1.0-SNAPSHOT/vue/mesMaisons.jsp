<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="controleur.*" %>
<%@ page import="java.util.*" %>
<p>Mes maisons</p>

<% 
	// à faire: find id_proprietaire
	//int idproprietaire=1;
	
	int idproprietaire1 = (Integer)session.getAttribute("idproprietaire");
	ArrayList<Logement> MesMaisons =  Controleur.selectAllMesMaisons(idproprietaire1);
%>

<table border="1">
	<tr>
		<td>Id logement</td> 
		<td>Code Localite </td> 
		<td>Type logement</td> 
		<td>Proprietaire </td> 
		<td>Libelle</td> 
		<td>Description </td> 
		<td>Caracteristique</td> 
		<td>Superficie </td> 
		<td>Animaux </td>
		<td>Enfants </td>
		<td>Adresse </td>
		<td>CP logment </td>
		<td>Disponibilite</td>
		<td>Atouts </td>
		<td>Disponibilite </td>
		
	</tr>
	
	<%
		String mesMaisons = ""; 
		for (Logement unLogement : MesMaisons)
		{
			mesMaisons += "<tr> <td>"+unLogement.getIdlogement()+"</td>"; 
			mesMaisons += "     <td>"+unLogement.getCodelocalite()+"</td>"; 
			mesMaisons += "     <td>"+unLogement.getCodetypelogement()+"</td>"; 
			mesMaisons += "     <td>"+unLogement.getIdproprietaire()+"</td>"; 
			mesMaisons += "     <td>"+unLogement.getLibelle()+"</td>"; 
			mesMaisons += "     <td>"+unLogement.getDescription()+"</td>"; 
			mesMaisons += "     <td>"+unLogement.getCaracteristique()+"</td>"; 
			mesMaisons += "     <td>"+unLogement.getSuperficie()+"</td>"; 
			mesMaisons += "     <td>"+unLogement.getAnimaux()+"</td>"; 
			mesMaisons += "     <td>"+unLogement.getEnfants()+"</td>"; 
			mesMaisons += "     <td>"+unLogement.getAdresse()+"</td>"; 
			mesMaisons += "     <td>"+unLogement.getCplogement()+"</td>"; 
			mesMaisons += "     <td>"+unLogement.getVillelogment()+"</td>"; 
			mesMaisons += "     <td>"+unLogement.getAtouts()+"</td>"; 
			mesMaisons += "     <td>"+unLogement.getDisponibilite()+"</td>"; 
					
			/*
			mesMaisons += "<td> "; 
			
			mesMaisons += "<a href='indexswap.jsp?page=2&action=sup&codepays="+unPays.getCodepays()+"'>";
			mesMaisons += "<img src='images/sup.png' height='20' width='20'> </a>";
			
			mesMaisons += "<a href='indexswap.jsp?page=2&action=edit&codepays="+unPays.getCodepays()+"'>";
			mesMaisons += "<img src='images/edit.png' height='20' width='20'> </a>";
			
			mesMaisons += "</td>";*/
			mesMaisons += "</tr>";
		}
		out.print(mesMaisons); 
	%>
</table>