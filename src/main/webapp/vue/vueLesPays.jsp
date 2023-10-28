<h3 class="sous_titre"> Liste des Pays</h3>

<table class="table_admin">
	<tr>
		<th>Code Pays</th> 
		<th> Libelle </th> 
		<th> Action </th> 
		
	</tr>
	
	<%
		String chainePays = ""; 
		for (Pays unPays : lesPays)
		{
			chainePays += "<tr> <td>"+unPays.getCodepays()+"</td>"; 
			chainePays += "     <td>"+unPays.getNompays()+"</td>"; 
			
			chainePays += "<td> "; 
			
			chainePays += "<a href='indexswap.jsp?page=2&action=sup&codepays="+unPays.getCodepays()+"'>";
			chainePays += "<img src='images/sup.png' height='20' width='20'> </a>";
			
			chainePays += "<a href='indexswap.jsp?page=2&action=edit&codepays="+unPays.getCodepays()+"'>";
			chainePays += "<img src='images/edit.png' height='20' width='20'> </a>";
			
			chainePays += "</td>";
			chainePays += "</tr>";
		}
		out.print(chainePays); 
	%>
</table>