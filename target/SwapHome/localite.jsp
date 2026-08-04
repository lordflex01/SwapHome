

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="controleur.*" %>
<%@ page import="java.util.*" %>

<div class="contenu_body background1">
<div class="contenu_donnee ">
<h1 class="titre_page">Gerez vos localités</h1>
<% 
	Localite laLocalite = null;
	if (request.getParameter("action") != null && request.getParameter("codelocalite") !=null)
	{
		String action =request.getParameter("action");
		int codelocalite = Integer.parseInt(request.getParameter("codelocalite"));
		
		switch(action)
		{
		case "sup" : Controleur.deleteLocalite(codelocalite);break;
		case "edit": laLocalite = Controleur.selectWhereLocalite(codelocalite);break;		
		}
	}
%>


<% 
	if (request.getParameter("Valider") != null)
	{
		 
		String libelle = request.getParameter("libelle");
		int codepays= Integer.parseInt(request.getParameter("codepays"));
		
		Localite uneLocalite = new Localite(libelle,codepays);
		
		//appel du controleur pour execute l'insertion
		Controleur.insertLocalite(uneLocalite);
		out.print("<br/>  Insertion réussie");
		
		
	}
if (request.getParameter("Modifier") != null)
{
	int codepays = Integer.parseInt(request.getParameter("codepays"));	
	String libelle = request.getParameter("libelle");
	int codelocalite = Integer.parseInt(request.getParameter("codelocalite"));	
	Localite uneLocalite = new Localite(codelocalite, libelle,codepays);	
	Controleur.updateLocalite(uneLocalite);	
	out.print("<br/>  Modification réussie");	
	response.sendRedirect("indexswap.jsp?page=4");
}

	ArrayList<Localite> lesLocalites = Controleur.selectAllLocalites();
	
	ArrayList<Pays> lesPays1 = Controleur.selectAllPays();
%>

<%@ include file="vue/vueInsertLocalite.jsp" %>

<%@ include file="vue/vueLesLocalites.jsp" %>

</div></div>