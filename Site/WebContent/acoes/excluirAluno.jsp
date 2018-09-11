 <%@page import="br.com.site.dao.AlunoDAO"%>
<%
				//Obter dados do idCdastro
          	    int idCadastro = Integer.parseInt(request.getParameter("idCadastro"));
 
                //Executar o comando DAO
 				new AlunoDAO().excluirAluno(idCadastro);
 				
 				//Redirecionamento
 				response.sendRedirect("../alunos.jsp");
          	
          	
  %>
  