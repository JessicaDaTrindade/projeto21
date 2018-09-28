<%@page import="java.sql.Date"%>
<%@page import="br.com.site.bean.*, br.com.site.dao.*"%>

<%
	//Obter dados matéria
	String nome = request.getParameter("nomeMateria");

	//Criar obketo matéria
	MateriaBean obj = new MateriaBean();
	obj.setNomeMateria(nome);
	
	//Executar comando DAO
	new MateriaDao().cadastrarMateria(obj);

	//Redirecionamento
	response.sendRedirect("../materias.jsp"); 
	
	


%>