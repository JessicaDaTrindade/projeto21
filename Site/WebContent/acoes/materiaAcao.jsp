<%@page import="java.sql.Date"%>
<%@page import="br.com.site.bean.*, br.com.site.dao.*" %>

<%
	//Obter dados mat�ria
	String nome = request.getParameter("nomeMateria");

	//Criar obketo mat�ria
	MateriaBean obj = new MateriaBean();
	obj.setNomeMateria(nome);
	
	//Executar comando DAO sdsd
	new MateriaDao().cadastrarMateria(obj);

	//Redirecionamento
	response.sendRedirect("../materias.jsp");
	
	


%>