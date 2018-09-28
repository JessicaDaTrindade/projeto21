<%@page import="java.sql.Date"%>
<%@page import="br.com.site.bean.*, br.com.site.dao.*"%>

<%
	//Obter os dados do aluno
	String nome = request.getParameter("nome");
	String sobrenome = request.getParameter("sobrenome");
	String sexo = request.getParameter("sexo");
	String dataNascimento = request.getParameter("dataNascimento");
	String estadoCivil = request.getParameter("estadoCivil");
	String cpf = request.getParameter("cpf");
	String rg = request.getParameter("rg");
	String cep = request.getParameter("cep");
	String logradouro = request.getParameter("logradouro");
	String numero = request.getParameter("numero");
	String bairro = request.getParameter("bairro");
	String municipio = request.getParameter("municipio");
	String complemento = request.getParameter("complemento");
	String telefone = request.getParameter("telefone");
	String celular = request.getParameter("celular");
	String nomeDaMae = request.getParameter("nomeDaMae");
	String nomeDoPai = request.getParameter("nomeDoPai");
	String responsavel = request.getParameter("responsavel");
	String telResponsavel = request.getParameter("telResponsavel");
	String celResponsavel = request.getParameter("celResponsavel");
	String email = request.getParameter("email");
	
	//Cria um objeto aluno
	AlunoBEAN obj = new AlunoBEAN();
	obj.setNome(nome);
	obj.setSobrenome(sobrenome);
	obj.setSexo(sexo);
	obj.setDataNascimento(dataNascimento);
	obj.setEstadoCivil(estadoCivil);
	obj.setCpf(cpf);
	obj.setRg(rg);
	obj.setCep(cep);
	obj.setLogradouro(logradouro);
	obj.setNumero(numero);
	obj.setBairro(bairro);
	obj.setMunicipio(municipio);
	obj.setComplemento(complemento);
	obj.setTelefone(telefone);
	obj.setCelular(celular);
	obj.setNomeDaMae(nomeDaMae);
	obj.setNomeDoPai(nomeDoPai);
	obj.setResponsavel(responsavel);
	obj.setTelResponsavel(telResponsavel);
	obj.setCelResponsavel(celResponsavel);
	obj.setEmail(email);
	
	
	//Executar o comando DAO
	new AlunoDAO().cadastrarAluno(obj);
	
	//Redirecionamento
	response.sendRedirect("../alunos.jsp");
	
	
%>