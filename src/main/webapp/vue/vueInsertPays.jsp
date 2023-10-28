<h3 class="sous_titre"> Ajouter d'un nouveau pays</h3>
<form method="post">
	<table class="insert_info">
		<tr>
		 	<td> Nom du pays </td>
		 	<td> <input type="text" name ="nompays" 
		 	value='<%= (lePays!=null)?lePays.getNompays() : "" %>'> </td>
		 </tr>
		 
		 <tr>
		 	<td><input type="reset" name="Annuler" value="Annuler"> </td>
		 	<td> <input type="submit" 
		 	<%=  (lePays!=null)? "name ='Modifier' value='Modifier'" :
		 				"name ='Valider' value='Valider'" %>
		 	> </td>
		 </tr>
		 <%=  (lePays!=null)? "<input type='hidden' name='codepays' value ='"+ lePays.getCodepays()+"'>" : "" %>
	</table>
</form>