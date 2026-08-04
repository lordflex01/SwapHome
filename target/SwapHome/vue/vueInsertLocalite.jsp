<h3 class="sous_titre"> Ajout d'un nouveau Localite</h3>

<%
			String optionPays = "";
			for (Pays unPays : lesPays1)
			{
				optionPays +=  "<option value=\"" + unPays.getCodepays() + "\" " + (unPays!=null && unPays.getCodepays() == unPays.getCodepays() ? " \"selected \"" : "") + " >" + unPays.getNompays() + "</option>";
			}
		 	
		 	%>



<form method="post">
	<table class="insert_info">
		<tr>
		 	<td> Libelle </td>
		 	<td> <input type="text" name ="libelle" 
		 	value='<%= (laLocalite!=null)?laLocalite.getLibelle() : "" %>'> </td>
		 </tr>
		 
		
		 <tr>
		 	<td> Pays </td>
		 	<td> 
		 	<select name="codepays" id="codepays">  
		 	 <%= optionPays%> 
		 	 </td>
		 </tr>
	 
		 <tr>
		 	<td><input type="reset" name="Annuler" value="Annuler"> </td>
		 	<td> <input type="submit" 
		 	<%=  (laLocalite!=null)? "name ='Modifier' value='Modifier'" :
		 				"name ='Valider' value='Valider'" %>
		 	> </td>
		 </tr>
		 <%=  (laLocalite!=null)? "<input type='hidden' name='codelocalite' value ='"+ laLocalite.getLibelle()+"'>" : "" %>
	</table>
</form>