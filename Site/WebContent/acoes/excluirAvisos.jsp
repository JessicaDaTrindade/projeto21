
<%@page import="br.com.site.dao.AvisosDao"%>

<%
				//Obter dados do idAvisos
          	    int idAvisos = Integer.parseInt(request.getParameter("idAvisos"));
 
                //Executar o comando DAO
 				new AvisosDao().excluirAvisos(idAvisos);
 				
 				//Redirecionamento
 			//	response.sendRedirect("../index.jsp");
          	
          	
  %>
