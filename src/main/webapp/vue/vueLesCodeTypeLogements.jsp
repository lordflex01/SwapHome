<h3 class="sous_titre"> Liste des type logement</h3>

<table class="table_admin">
	<tr>
		<th>Code</th> 
		<th> Libelle </th> 
		<th> Action </th>
		
	</tr>
	
	<%
	
		String chaineLoge = ""; 	
		for (TypeLogement unTypeLogement : lesTypeLogements)
		{			
			chaineLoge += "<tr> <td>"+unTypeLogement.getCodetypelogement()+"</td>"; 
			chaineLoge += "     <td>"+unTypeLogement.getLibelle()+"</td>"; 
			
			chaineLoge += "<td> "; 
			
			chaineLoge += "<a href='indexswap.jsp?page=3&action=sup&codetypelogement="+unTypeLogement.getCodetypelogement()+"'>";
			chaineLoge += "<img src='images/sup.png' height='20' width='20'> </a>";
			
			chaineLoge += "<a href='indexswap.jsp?page=3&action=edit&codetypelogement="+unTypeLogement.getCodetypelogement()+"'>";
			chaineLoge += "<img src='images/edit.png' height='20' width='20'> </a>";
			
			chaineLoge += "</td>";
			chaineLoge += "</tr>";
			
		}
		out.print(chaineLoge);
		
	%>
</table>