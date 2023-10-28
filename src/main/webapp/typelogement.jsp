<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="controleur.*" %>
<%@ page import="java.util.*" %>

<div class="contenu_body background2">
<div class="contenu_donnee">
<h1 class="titre_page">Gerez les types de logement</h1>
<% 
	TypeLogement leTypeLogement = null;
	if (request.getParameter("action") != null && request.getParameter("codetypelogement") !=null)
	{
		String action =request.getParameter("action");
		int codetypelogement = Integer.parseInt(request.getParameter("codetypelogement"));
		
		switch(action)
		{
		case "sup" : Controleur.deleteTypeLogement(codetypelogement);break;
		case "edit": leTypeLogement = Controleur.selectWhereTypeLogement(codetypelogement);break;		
		}
	}
%>


<% 
	if (request.getParameter("Valider") != null)
	{
		 
		String libelle = request.getParameter("libelle");
		
		TypeLogement unTypeLogement = new TypeLogement(libelle);
		
		//appel du controleur pour execute l'insertion
		Controleur.insertTypeLogement(unTypeLogement);
		out.print("<br/>  Insertion réussie");
		
		
	}
if (request.getParameter("Modifier") != null)
{
	int codetypelogement = Integer.parseInt(request.getParameter("codetypelogement"));	
	String libelle = request.getParameter("libelle");	
	TypeLogement unTypeLogement = new TypeLogement(codetypelogement, libelle);	
	Controleur.updateTypeLogement(unTypeLogement);	
	out.print("<br/>  Modification réussie");	
	response.sendRedirect("indexswap.jsp?page=3");
}

	ArrayList<TypeLogement> lesTypeLogements = Controleur.selectAllTypeLogements();
%>

<%@ include file="vue/vueInsertCodeTypeLogement.jsp" %>

<%@ include file="vue/vueLesCodeTypeLogements.jsp" %>

</div></div>

