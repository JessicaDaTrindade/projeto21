<%@page import="br.com.site.dao.MateriaDao"%>
<%

	//Obter o idMat�ria
	int idMateria = Integer.parseInt(request.getParameter("idMateria"));

	//Executar a exclus�o
	new MateriaDao().excluirMateria(idMateria);
	
	//Redirecionamento
	//response.sendRedirect("../painel.jsp?msg=usuarioExcluido");
	response.sendRedirect("../materias.jsp");

%>