<%@page import="br.com.site.dao.ColaboradorDAO"%>
<%@page import="br.com.site.bean.ColaboradorBEAN"%>
<%

//Objeto
ColaboradorBEAN obj = new ColaboradorBEAN();


	//Obter dados
	String idCadastro = request.getParameter("idCadastro");
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
	
	obj.setIdCadastro(Integer.parseInt(idCadastro));
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


//Executar método
new ColaboradorDAO().alterarDadosColaborador(obj);

//Redirecionar
response.sendRedirect("../colaboradores.jsp");

%>