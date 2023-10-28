<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="controleur.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.Date" %>


<h2 class="sous_titre_black">Liste des offres disponibles</h2>

<% 
	int idproprietaire_Envoyer 	= 	Integer.parseInt(request.getParameter("idproprietaire_envoyer"));
	ArrayList<Logement>  lesLogements2 = Controleur.selectAllMaisonsDispo(idproprietaire_Envoyer);
	
	String strDivs = "";
	for(Logement unLogement : lesLogements2)
	{
		strDivs +=  "<div>"
					+    	"<input type=\"radio\" id=\"" + unLogement.getIdlogement() + "\" name=\"logement\" value=\"" + unLogement.getIdlogement() + "\" "				    
				    + 		"<label for=\"" + unLogement.getIdlogement() + "\">" + unLogement.getLibelle() +"-"+unLogement.getDescription()+"-"+unLogement.getAdresse()+ "</label>"
				    + "</div>";
	}
	
%>

<form method="POST">
<fieldset>
    <legend>Selectioner un logement</legend>
	<%= strDivs%>
</fieldset>
 <input type="submit" value="Valider" name="Valider">
 <input type="submit" value="Refuser" name="Refuser">


</form >

<%
	if (request.getParameter("Valider") != null)
	{
		 
		Object oLogement = request.getParameter("logement");		
		
		if(oLogement == null)
			out.print("<br/>  Veuillez choisir un logement");
		else
		{
			
			String daterepondre1 = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
			int idechanger=Integer.parseInt(request.getParameter("idechanger"));
			int idlog1_new=Integer.parseInt(request.getParameter("logement"));			
			Controleur.updateEchanger(idechanger,idlog1_new,daterepondre1, "valide");
			response.sendRedirect("indexswap.jsp?page=17");
		}
			
	}
		if (request.getParameter("Refuser") != null)
		{
			Object oLogement = request.getParameter("logement");		
			
			if(oLogement == null)
				out.print("<br/> Veuillez choisir un logement");
			else
			{
				
				String daterepondre1 = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
				int idechanger=Integer.parseInt(request.getParameter("idechanger"));
				int idlog1_new=Integer.parseInt(request.getParameter("logement"));			
				Controleur.updateEchanger(idechanger,idlog1_new,daterepondre1, "refuse");	
				response.sendRedirect("indexswap.jsp?page=17");
			}
		}

%>






