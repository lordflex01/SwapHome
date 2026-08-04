<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="controleur.*" %>
<%@ page import="java.util.*" %>


<% 
	ArrayList<VueLogement> lesVuesLogements =  Controleur.selectAllOffres();
%>

<%@ include file="vue/ListeDesVueLogements.jsp" %>

<footer>
  <p>Author: Ilios Travel<br>
  <a style="text-decoration:none;" href="mailto:hege@example.com">info@iliostravel.com</a></p>
</footer>
