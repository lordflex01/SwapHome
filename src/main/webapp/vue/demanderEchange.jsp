<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="controleur.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.Date" %>

<div class="background_demandeEchange">
<h1 >Demander une échange</h1>
<%
	
	if (request.getParameter("idlogement") == null
		|| request.getParameter("idproprietaire") == null)
	{
		out.print("Demande non valide, merci de la refaire");
		return;
	}
	
	int idlogement 	= 	Integer.parseInt(request.getParameter("idlogement"));
	Logement leLogement_echange = Controleur.selectWhereLogement(idlogement);
	
	String libelle=leLogement_echange.getLibelle();
	String description=leLogement_echange.getDescription();
	String adresse=leLogement_echange.getAdresse();
	
	String chaine_description="";
	chaine_description = "<div class=\"remarque_description\"> - " + libelle +"<br> - " + description +"<br> - " + adresse + "</div>";
	out.print(chaine_description);

%>

	<form method="post">
	  <label class="info_date" >Date de entree  </label>
	  <input type="date"  name="dateentre"><br><br>
	  <label class="info_date" >Date de sortie  </label>
	  <input type="date"  name="datesortie"><br><br>
	  <input class="button_demande_echange" style="color:black;" type="submit" name="Demander" value="Demander">
	</form>
	
	<%
	//insert into table echanger
	
	
	
	if (request.getParameter("Demander") != null)
	{
		int idpro1= (Integer)session.getAttribute("idproprietaire");
		int idpro2=leLogement_echange.getIdproprietaire();
		int idlog1=0;
		int idlog2=leLogement_echange.getIdlogement();
		String datedemande=new SimpleDateFormat("yyyy/MM/dd").format(new Date());;
		String daterepondre=null;
		String dateentre	=	request.getParameter("dateentre");
		String datesortie	=	request.getParameter("datesortie");
		String status="initial";
		
		Echanger unEchanger = new Echanger(idpro1, idpro2, idlog1,  idlog2,  datedemande,
				 							daterepondre,  dateentre,  datesortie,  status);
		
		Controleur.insertEchanger(unEchanger);
		response.sendRedirect("indexswap.jsp?page=17");
	}
	
	%>
	
	
</div>
	
	
	
	
	
	
	