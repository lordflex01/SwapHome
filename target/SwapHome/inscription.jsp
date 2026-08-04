<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="controleur.*" %>
<%@ page import="java.util.*" %>


	<p class="titre_inscription">Form d'inscription</p>
	<div class="form_inscription">
	
	<form class="w3-container w3-card-4" method="post">
	  <label class="w3-text-blue" >Nom :</label>
	  <input class="w3-input w3-border" type="text" id="nom" name="nom" placeholder="NICOLAS..."><br>
	  
	  <label class="w3-text-blue">Prénom : </label><br>
	  <input class="w3-input w3-border" type="text" id="prenom" name="prenom"  placeholder="Anais..."><br>
	  
	  <label class="w3-text-blue">Adresse : </label><br>
	  <input class="w3-input w3-border" type="text" id="adresse" name="adresse" placeholder="100 rue de Liberte"><br>
	  
	  <label class="w3-text-blue">Email : </label><br>
	  <input class="w3-input w3-border" type="text" id="email" name="email"  placeholder="a@gmail.com"><br>
	  
	  <label class="w3-text-blue">Telephone : </label><br>
	  <input class="w3-input w3-border" type="text" id="telephone" name="telephone" placeholder="0767452312"><br>
	  
	  <label class="w3-text-blue">Code Postal : </label><br>
	  <input class="w3-input w3-border" type="text" id="codepostal" name="cp" placeholder="75001"><br>
	  
	  <label class="w3-text-blue">Ville : </label><br>
	  <input class="w3-input w3-border" type="text" id="ville" name="ville" placeholder="Villebon"><br>
	  
	  <label class="w3-text-blue">Login : </label><br>
	  <input class="w3-input w3-border" type="text" id="login" name="login" ><br>
	  
	  <label class="w3-text-blue">Mot de passe : </label><br>
	  <input class="w3-input w3-border" type="password" id="mdp" name="mdp" ><br><br>
	  
	 
	 
	  <input style="padding:10px;background-color:#2196F3;font-size:15px;color:white;margin-bottom:20px;border:solid 0.5px #2196F3 " type="submit" value="Inscrire" name="Inscrire">
	</form> 

<% 
	
	if (request.getParameter("Inscrire") != null)
	{
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		
		
		
		User unUser=new User(nom,prenom,adresse,email,tel,cp,ville,login,mdp);
		//insert into table user
		Controleur.insertUser(unUser);
		
		// select where user login
		User newUser = Controleur.selectWhereIdUser(login,mdp);
	
		// getid
		int idusertrouve=newUser.getIduser();
		//out.print(idusertrouve);
		
		//out.print("<br/>  Insertion réussie");
		//response.sendRedirect("vue/vueProfil.jsp?id_user=" + Integer.toString(idusertrouve));
		response.sendRedirect("indexswap.jsp?page=14&id_user=" + idusertrouve);
	}

%>


</div>

<footer>
  <p>Author: Ilios Travel<br>
  <a style="text-decoration:none;" href="mailto:hege@example.com">info@iliostravel.com</a></p>
</footer>

























