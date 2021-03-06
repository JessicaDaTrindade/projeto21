<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="br.com.site.dao.ColaboradorDAO"%>
<%@page import="br.com.site.bean.ColaboradorBEAN"%>


<html>
<head>
<!-- verificar sessão -->
<%@include file="include/incSessao.jsp"%>

<meta charset="utf-8" />
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>COLABORADORES</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css"
	media="screen and (min-width: 1200px)" href="css/style.css" />
<link rel="stylesheet" type="text/css"
	media="screen and (min-width: 1000px) and (max-width: 1199px)"
	href="css/style_projetor.css" />
<link rel="stylesheet" type="text/css"
	media="screen and (max-width: 480px)" href="css/style_smartphone.css" />

<link rel="stylesheet" type="text/css"
	media="screen and (min-width: 1200px)" href="css/colaboradores.css" />
<link rel="stylesheet" type="text/css"
	media="screen and (min-width: 1000px) and (max-width: 1199px)"
	href="css/colaboradores_projetor.css" />
<link rel="stylesheet" type="text/css"
	media="screen and (max-width: 480px)"
	href="css/colaboradores_smartphone.css" />

<script src="main.js"></script>



<!-- JQuery -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
	
	<!-- MÁSCARA CPF -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
<script>
    $(document).ready(function () { 
        var $seuCampoCpf = $("#CPF");
        $seuCampoCpf.mask('000.000.000-00', {reverse: true});
       
        
    });
</script>

<link rel="stylesheet" media="screen" type="text/css" href="css/sobrepoe.css">
</head>
<body>

	<main> <!-- MENU -->
	<section id="menu">

		<ul>
			<%
	

	if (user.getCargo() == 1) {
		out.print("<img src=img/LECIONA.png class='logo' height='80px' width='100px' margin-top: 20px;>"+
				"<li><a href='index.jsp'>INÍCIO</a></li><li><a href='colaboradores.jsp'>COLABORADORES</a></li><li><a href='alunos.jsp'>ALUNOS</a></li><li><a href='materias.jsp'>MATÉRIAS</a></li><li><a href='turmas.jsp'>TURMAS</a></li><li><a href='acoes/logout.jsp'>SAIR</a></li>");
	} else if (user.getCargo() == 3) {
		out.print("<img src=img/LECIONA.png class='logo' height='80px' width='100px' margin-top: 20px;>"+
				"<li><a href='index.jsp'>INÍCIO</a></li><li><a href='alunos.jsp'>ALUNOS</a></li><li><a href='materias.jsp'>MATÉRIAS</a></li><li><a href='turmas.jsp'>TURMAS</a></li><li><a href='acoes/logout.jsp'>SAIR</a></li>");
	}
%>

		</ul>

	</section>

	<!-- CONTEÃÂDO -->
	<section id="conteudoColaboradores">

		<div id="painel">

			<h1 id="titulo">COLABORADORES</h1>

			<hr class="linha">

			<!-- DIV CONTEÃÅ¡DO -->
			<div id="colaboradores">

				<!-- BOTÃÆO CADASTRAR -->
				<input type="button" value="CADASTRAR" id="btnCadastrar"
					data-toggle="modal" data-target="#myModal">

				<!-- DIV LISTA COLABORADORES -->
				<div id="divLista">

					<!-- TABELA COLABORADORES -->
					<%
						out.print(new ColaboradorDAO().listarColaboradores());
					%>
				</div>


			</div>
	</section>




	</main>

	<footer> E21 - 2018</footer>

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog estiloModal " role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>

					<h4 class="modal-title titulo" id="myModalLabel">CADASTRAR
						COLABORADOR</h4>

				</div>
				<div class="modal-body">
					<div>

						<form action="acoes/colaboradorAcao.jsp">

							<!-- Cadastrar nome e sobrenome -->
							<label> Nome <br> <input type="text" name="nome">
							</label> <label> Sobrenome <br> <input type="text"
								name="sobrenome">
							</label>

							<!-- Cadastrar Sexo  -->
							<label>Sexo <br> <input type="radio" value="F"
								name="sexo">Feminino <input type="radio" value="M"
								name="sexo">Masculino
							</label> <br>


							<!-- Cadastrar RG e CPF  -->
							<label> RG <br> <input type="text" name="rg" maxlength="15">
							</label> <label> CPF <br> <input type="text"
								 name="cpf" id="CPF" maxlength="14" placeholder="Ex.: 000.000.000-00">
							</label>

							<!-- cadastrar data de Nascimento -->
							<label> Data de nascimento <br> <input type="date"
								name="dataNascimento">
							</label>

							<!-- Cadastrar eatado civil -->
							<label> Estado Civil <br> <input type="radio"
								value="S" name="estadoCivil"> Solteiro(a) <input
								type="radio" value="Casado(a)" name="estadoCivil">
								Casado(a) <input type="radio" value="Divorciado(a)"
								name="estadoCivil"> Divorciado(a) <input type="radio"
								value="Viuvo(a)" name="estadoCivil">Viúvo(a)
							</label> <br>

							<hr class="separador">

							<!-- Cadastrar CEP -->
							<h6 id="titulo2">Endereço</h6>

							<input type="text" name="cep" placeholder="CEP"> <input
								type="text" name="logradouro" placeholder="LOGRADOURO">
							<input type="text" name="numero" placeholder="Nº"> <br>
							<br> <input type="text" name="bairro" placeholder="BAIRRO">
							<input type="text" name="municipio" placeholder="MUNICÍPIO">
							<input type="text" name="complemento" placeholder="COMPLEMENTO">
							<hr class="separador">

							<!-- Contato -->
							</label> <br> <label>Telefone <br> <input type="text"
								 id="TEL" name="telefone"  
								placeholder="Ex.: (00) 0000-0000">
							</label> <label>Celular <br> <input type="text"
								id="TEL" name="celular"
								placeholder="Ex.: (00) 0000-0000">
							</label> <label>Email <br> <input type="text" name="celular"
								placeholder="Ex.: exemplo@gmail.com">
							</label> <br> <br>
							<hr class="separador">

							<!-- CARGO -->
							<h6 id="titulo2">Cargo</h6>
							<label> <br> <input type="radio" value="Diretor"
								name="Cargo">Diretor(a) <input type="radio"
								value="Professor" name="Cargo" onclick="Mudarestado('minhaDiv')">Professor(a)
								<input type="radio" value="Coordenador" name="Cargo">Coordenador(a)
								<input type="radio" value="Secretário(a)" name="Cargo">Secretário(a)
								<input type="radio" value="Serviços Gerais" name="Cargo">Serviços
								Gerais <input type="radio" value="Cozinheiro" name="Cargo">Cozinheiro(a)
								<input type="radio" value="Bibliotecário(a)" name="Cargo">Bibliotecário(a)
							</label> <label>Salário <br> <input type="text"
								name="Salário" placeholder="0.000,00">
							</label>

							<script>
								function Mudarestado(el) {
									var display = document.getElementById(el).style.display;
									if (display == "none")
										document.getElementById(el).style.display = 'none';
									else
										document.getElementById(el).style.display = 'block';
								}
							</script>

							<div id="minhaDiv">

								<label> <br> <input type="checkbox"
									value="História" name="Cargo">História <input
									type="checkbox" value="Matemática" name="Cargo">Matemática
									<input type="checkbox" value="Física" name="Cargo">Física
									<input type="checkbox" value="Português" name="Cargo">Português
									<input type="checkbox" value="Artes" name="Cargo">Artes
									<input type="checkbox" value="Educação Física" name="Cargo">Educação
									Física <input type="checkbox" value="Ciências" name="Cargo">Ciências
									<input type="checkbox" value="Biologia" name="Cargo">Biologia
									<input type="checkbox" value="Inglês" name="Cargo">Inglês
									<input type="checkbox" value="Espanhol" name="Cargo">Espanhol
									<input type="checkbox" value="Geografia" name="Cargo">Geografia
									<input type="checkbox" value="Química" name="Cargo">Química
									<input type="checkbox" value="Sociologia" name="Cargo">Sociologia
									<input type="checkbox" value="Informática" name="Cargo">Informática
								</label>

							</div>



							<br> <br>
							<div id="botao">
								<!-- enviar para o banco de dados -->
								<input type="submit" value="Cadastrar">
							</div>
						</form>


					</div>
					<div class="modal-footer"></div>
				</div>
			</div>
</body>
</html>