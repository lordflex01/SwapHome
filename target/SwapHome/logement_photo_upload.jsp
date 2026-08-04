<%@ page import="controleur.*" %>
<%@ page import="java.util.*" %>
<div style="padding-top:30px;" class="background_demandeEchange">
<%
	int idlogement_add_photo= Integer.parseInt(request.getParameter("idlogement"));


	//if(request.getParameter("idLogement") != null)
		//idLogement = request.getParameter("idLogement");
		int idLogement = idlogement_add_photo;
	


	//out.print(idLogement);
%>
<form action="indexswap.jsp?page=16&idLogement=<%=idLogement%>" method="post"
                        enctype="multipart/form-data">
   <input type = "file" name = "file" size = "50" />   
   <br />
   <input type = "submit" name="submit" value = "Upload File" />
</form>
<!-- 
insert photo
 -->
</div>