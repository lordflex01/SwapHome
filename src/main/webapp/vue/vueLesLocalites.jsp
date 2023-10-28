<h3 class="sous_titre"> Liste des Localites</h3>

<table class="table_admin">
	<tr>
		<th>Code localite</th> 
		<th> Libelle </th> 
		<th> codePays </th>
		<th> Action </th>
		
	</tr>
	
	<%
		String chaineLoca = ""; 
		for (Localite uneLocalite : lesLocalites)
		{
			chaineLoca += "<tr> <td>"+uneLocalite.getCodelocalite()+"</td>"; 
			chaineLoca += "     <td>"+uneLocalite.getLibelle()+"</td>"; 
			chaineLoca += "     <td>"+uneLocalite.getCodepays()+"</td>"; 
			chaineLoca += "<td> "; 
			
			chaineLoca += "<a href='indexswap.jsp?page=4&action=sup&codelocalite="+uneLocalite.getCodelocalite()+"'>";
			chaineLoca += "<img src='images/sup.png' height='20' width='20'> </a>";
			
			chaineLoca += "<a href='indexswap.jsp?page=4&action=edit&codelocalite="+uneLocalite.getCodelocalite()+"'>";
			chaineLoca += "<img src='images/edit.png' height='20' width='20'> </a>";
			
			chaineLoca += "</td>";
			chaineLoca += "</tr>";
		}
		out.print(chaineLoca); 
	%>
</table>