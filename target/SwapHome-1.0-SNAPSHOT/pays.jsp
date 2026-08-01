<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="controleur.*" %>
<%@ page import="java.util.*" %>

<div class="contenu_body">
<div class="contenu_donnee">
<h1 class="titre_page">Gérez les pays</h1>
<% 
	Pays lePays = null;
	if (request.getParameter("action") != null && request.getParameter("codepays") !=null)
	{
		String action =request.getParameter("action");
		int codepays = Integer.parseInt(request.getParameter("codepays"));
		
		switch(action)
		{
		case "sup" : Controleur.deletePays(codepays);break;
		case "edit": lePays = Controleur.selectWherePays(codepays);break;		
		}
	}
%>


<% 
	if (request.getParameter("Valider") != null)
	{
		 
		String nompays = request.getParameter("nompays");
		
		
		//On instancie la classe client
		Pays unPays = new Pays(nompays);
		
		//appel du controleur pour execute l'insertion
		Controleur.insertPays(unPays);
		//out.print("<br/>  Insertion réussie");
		
		
	}
if (request.getParameter("Modifier") != null)
{
	int codepays = Integer.parseInt(request.getParameter("codepays"));	
	String nompays = request.getParameter("nompays");	
	Pays unpays = new Pays(codepays, nompays);	
	Controleur.updatePays(unpays);	
	//out.print("<br/>  Modification réussie");	
	response.sendRedirect("indexswap.jsp?page=2");
}

	ArrayList<Pays> lesPays =  Controleur.selectAllPays();
%>

<%@ include file="vue/vueInsertPays.jsp" %>

<%@ include file="vue/vueLesPays.jsp" %>

</div>
</div>