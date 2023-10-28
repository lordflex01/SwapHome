<h3 class="sous_titre"> Ajout d'un nouveau typelogement</h3>
<form method="post">
	<table class="insert_info">
		<tr>
		 	<td> Libelle </td>
		 	<td> <input type="text" name ="libelle" 
		 	value='<%= (leTypeLogement!=null)?leTypeLogement.getLibelle() : "" %>'> </td>
		 </tr>
		 
		 <tr>
		 	<td><input type="reset" name="Annuler" value="Annuler"> </td>
		 	<td> <input type="submit" 
		 	<%=  (leTypeLogement!=null)? "name ='Modifier' value='Modifier'" :
		 				"name ='Valider' value='Valider'" %>
		 	> </td>
		 </tr>
		 <%=  (leTypeLogement!=null)? "<input type='hidden' name='codetypelogement' value ='"+ leTypeLogement.getLibelle()+"'>" : "" %>
	</table>
</form>