<%@page import="br.com.site.dao.MateriaDao"%>
<%

	//Obter o idMatéria
	int idMateria = Integer.parseInt(request.getParameter("idMateria"));

	//Executar a exclusão
	new MateriaDao().excluirMateria(idMateria);
	
	//Redirecionamento
	//response.sendRedirect("../painel.jsp?msg=usuarioExcluido");
	response.sendRedirect("../materias.jsp");

%>