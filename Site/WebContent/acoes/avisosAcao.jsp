<%@page import="br.com.site.bean.*, br.com.site.dao.*"%>

<%
	//Obter os dados do aluno
	String avisos = request.getParameter("txtAvisos");

	
	//Cria um objeto aluno
	AvisosBean obj = new AvisosBean();
	obj.setAvisos(avisos);
	
	
	//Executar o comando DAO
	new AvisosDao().cadastrarAvisos(obj);
	
	//Redirecionamento
	response.sendRedirect("../index.jsp");
	
	
%>