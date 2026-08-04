<%@ page import="java.io.File" %>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import = "javax.servlet.http.*" %>
<%@ page import = "org.apache.commons.fileupload.*" %>
<%@ page import = "org.apache.commons.fileupload.disk.*" %>
<%@ page import = "org.apache.commons.fileupload.servlet.*" %>
<%@ page import = "org.apache.commons.io.output.*" %> 
<%@ page import="controleur.*" %>  

<div class="background_demandeEchange">
    <%
   File file ;
   int maxFileSize = 5000 * 1024;
   int maxMemSize = 5000 * 1024;
   ServletContext context = pageContext.getServletContext();
   String filePath = "D:\\PersonalData\\Desktop\\Nouveau dossier\\SwapHome\\src\\main\\webapp\\images\\";
   int idLogement_UpdatePhoto = Integer.parseInt(request.getParameter("idLogement"));

   // Verify the content type
   String contentType = request.getContentType();
   
   if ((contentType.indexOf("multipart/form-data") >= 0)) {
      DiskFileItemFactory factory = new DiskFileItemFactory();
      // maximum size that will be stored in memory
      factory.setSizeThreshold(maxMemSize);
      
      // Location to save data that is larger than maxMemSize.
      factory.setRepository(new File("c:\\temp"));

      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);
      
      // maximum file size to be uploaded.
      upload.setSizeMax( maxFileSize );
      
      try { 
         // Parse the request to get file items.
         List fileItems = upload.parseRequest(request);

         // Process the uploaded file items
         Iterator i = fileItems.iterator();
         
         while ( i.hasNext () ) {
            FileItem fi = (FileItem)i.next();
            if ( !fi.isFormField () ) {
               // Get the uploaded file parameters
               String fieldName = fi.getFieldName();
               String fileName = fi.getName();
               boolean isInMemory = fi.isInMemory();
               long sizeInBytes = fi.getSize();
            
               // Write the file
               if( fileName.lastIndexOf("\\") >= 0 ) {
                  file = new File( filePath + 
                  fileName.substring( fileName.lastIndexOf("\\"))) ;
               } else {
                  file = new File( filePath + 
                  fileName.substring(fileName.lastIndexOf("\\")+1)) ;
               }
               fi.write( file ) ;
               //out.println("Uploaded Filename: " + filePath + 
               //fileName + "<br>");
               
               //out.println(filePath + "<br>");
               //out.println(fileName + "<br>");
               
               
               // enregistrer file name vao database
               String photo ="";
             
               photo="images/" + fileName;
               Controleur.updatePhoto(photo,idLogement_UpdatePhoto);
               //out.print(photo);
   
               // id-logement, request.getParameter("idLogement")
   
               // fileName (nom du photo)
               out.println("<div style=\"font-size:25px;padding-top:20px;font-weight:bolder;font-family: 'Chivo Mono', monospace;\">Vous avez réussi d'insérer des photos de votre logement</div><br>");
               out.println("<span class=\"material-symbols-outlined\">sentiment_satisfied</span>");
            }
         }
         out.println("</body>");
         out.println("</html>");
      } catch(Exception ex) {
         System.out.println(ex);
      }
   } 
%>


</div> 