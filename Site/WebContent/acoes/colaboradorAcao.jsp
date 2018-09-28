<%@page import="java.sql.Date"%>
<%@page import="br.com.site.bean.*, br.com.site.dao.*"%>

<%
	//Obter os dados do Colaborador
	String nome = request.getParameter("nome");
	String sobrenome = request.getParameter("sobrenome");
	String sexo = request.getParameter("sexo");
	String rg = request.getParameter("rg");
	String cpf = request.getParameter("cpf");
	String dataNascimento = request.getParameter("dataNascimento");
	String estadoCivil = request.getParameter("estadoCivil");
	String cep = request.getParameter("cep");
	String logradouro = request.getParameter("logradouro");
	String numero = request.getParameter("numero");
	String bairro = request.getParameter("bairro");
	String municipio = request.getParameter("municipio");
	String complemento = request.getParameter("complemento");
	String telefone = request.getParameter("telefone");
	String celular = request.getParameter("celular");
	String email = request.getParameter("email");
	String cargo = request.getParameter("cargo");
	String salario = request.getParameter("salario");
	
	//Cria um objeto aluno
	ColaboradorBEAN obj = new ColaboradorBEAN();
	obj.setNome(nome);
	obj.setSobrenome(sobrenome);
	obj.setSexo(sexo);
	obj.setRg(rg);
	obj.setCpf(cpf);
	obj.setDataNascimento(dataNascimento);
	obj.setEstadoCivil(estadoCivil);
	obj.setCep(cep);
	obj.setLogradouro(logradouro);
	obj.setNumero(numero);
	obj.setBairro(bairro);
	obj.setMunicipio(municipio);
	obj.setComplemento(complemento);
	obj.setTelefone(telefone);
	obj.setCelular(celular);
	obj.setEmail(email);
	obj.setIdCargo(cargo);
	obj.setSalario(salario);
	
	//Executar o comando DAO
	new ColaboradorDAO().cadastrarColaborador(obj);
	
	//Redirecionamento
	response.sendRedirect("../index.jsp");
%>