<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="controleur.*" %>
<%@ page import="java.util.*" %>

<!--  
<center>
	<form method="post">
		<label for="login">Login:</label>
    	<input type="text" id="login" name="login"><br>
			
    	<label for="mdp">Password:</label>
    		<input type="password" id="mdp" name="mdp" required><br>
		
		<input type="submit" value="Sign in" name="Verifier">	
	</form>

</center>
 
-->



<div class="container">
	<div class="screen">
		<div class="screen__content">
			<form method="post" class="login">
				<div class="login__field">
					<i class="login__icon fas fa-user"></i>
					<input type="text" class="login__input" placeholder="Login" id="login" name="login">
				</div>
				<div class="login__field">
					<i class="login__icon fas fa-lock"></i>
					<input type="password" class="login__input" placeholder="Password" name="mdp" id="mdp">
				</div>
				<button type="submit" class="button login__submit" name="Verifier">
					<span class="button__text">Se connecter</span>
					<i class="button__icon fas fa-chevron-right"></i>
				</button>				
			</form>
			<div class="social-login">
				<h3>log in via</h3>
				<div class="social-icons">
					<a href="#" class="social-login__icon fab fa-instagram"></a>
					<a href="#" class="social-login__icon fab fa-facebook"></a>
					<a href="#" class="social-login__icon fab fa-twitter"></a>
				</div>
			</div>
		</div>
		<div class="screen__background">
			<span class="screen__background__shape screen__background__shape4"></span>
			<span class="screen__background__shape screen__background__shape3"></span>		
			<span class="screen__background__shape screen__background__shape2"></span>
			<span class="screen__background__shape screen__background__shape1"></span>
		</div>		
	</div>
</div>



<%
if (request.getParameter("Verifier") != null)
{
	String login = request.getParameter("login");
	String mdp = request.getParameter("mdp");
	
	User User_check = Controleur.selectWhereLoginUser(login,mdp);
	if (User_check != null)
	{		
		session.setAttribute("login",login);			// set session value
		session.setAttribute("nom",User_check.getNom());			// set session value
		session.setAttribute("prenom",User_check.getPrenom());			// set session value
		
		// Get proprietaire ici  avec User_check.id
		
		int idpropri = User_check.getIduser();
		Proprietaire User_check_proprietaire = Controleur.selectWhereLoginUserProprietaire(idpropri);
		int idproprietaire3 = User_check_proprietaire.getIdproprietaire();
		
		if(User_check_proprietaire !=null)
		{
			//int idproprietaire=User_check_proprietaire.getIdproprietaire();
			session.setAttribute("idproprietaire",User_check_proprietaire.getIdproprietaire());
		}
		
		// session.setAttribute("EstProprietaire",True);			
		
		response.sendRedirect("indexswap.jsp?page=1");
		Controleur.updateDernierConnxeion(idproprietaire3);
	}
	
	else {
		out.print("Votre login ou mot de passe n'est pas correct");
	}
}




%>