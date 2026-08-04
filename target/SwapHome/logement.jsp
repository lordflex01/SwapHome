<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="controleur.*" %>
<%@ page import="java.util.*" %>

<div class="background_logement1" >
<% 
	ArrayList<Logement> lesLogements =  Controleur.selectAllLogements();
%>

<%@ include file="vue/ListeDesLogement.jsp" %>

</div>



