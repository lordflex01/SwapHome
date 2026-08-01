
<div class="line_title"></div>
<div class="layout_logement">

<% 
int idproprietaire_encours2 = (Integer)session.getAttribute("idproprietaire");
String chaineVueLogement="";
for (VueLogement uneVueLogement : lesVuesLogements)
{
	
	chaineVueLogement += "<div class=\"layout_logement_1\" >";
	chaineVueLogement += "<div class=\"title_logement\">" + uneVueLogement.getLibelle() + "</div>";
	chaineVueLogement += "<img src=\""+ uneVueLogement.getPhoto() + "\" class=\"position_img\">";
	chaineVueLogement += "<div class=\"contenue_logement\">";
	chaineVueLogement += "- Nom & Prénom propriétaire: " + uneVueLogement.getNom_proprietaire() + "-" +uneVueLogement.getPrenom_proprietaire() +"<br>";
	chaineVueLogement += "- Email contact: " +uneVueLogement.getEmail() + "<br>";
	chaineVueLogement += "- Type Logement: " +uneVueLogement.getTypelogement() + "<br>";
	chaineVueLogement += "- Description: " +uneVueLogement.getDescription() +" "+ uneVueLogement.getCaracteristique() + "<br>";
	chaineVueLogement += "- Superficie: " +uneVueLogement.getSuperficie() + " m2 <br>";
	chaineVueLogement += "- Atouts: " +uneVueLogement.getAtouts() + "<br>";
	chaineVueLogement += "- Disponibilite: " +uneVueLogement.getDispo() + "<br>";
	chaineVueLogement += "- Enfants: " +uneVueLogement.getEnfants() + "<br>";
	chaineVueLogement += "- Animaux: " +uneVueLogement.getAnimaux() + "<br>";
			
	
	chaineVueLogement += "</div>";
	
	if(uneVueLogement.getIdproprietaire() != idproprietaire_encours2 )
	{
		chaineVueLogement += "<a class=\"button_envoyerDemande\" href='indexswap.jsp?page=10&idlogement=" +uneVueLogement.getIdlogement()+"&idproprietaire=" + uneVueLogement.getIdproprietaire() + "'>Envoyez</a>";
	}
	
	chaineVueLogement += "</div>";
} 
out.print(chaineVueLogement);
%>

</div>


