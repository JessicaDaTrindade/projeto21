<!DOCTYPE html>
<%@page import="br.com.site.dao.MateriaDao"%>
<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>SGE | Matérias</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" media="screen and (min-width: 1200px)" href="css/style.css" />
    <link rel="stylesheet" type="text/css" media="screen and (min-width: 1000px) and (max-width: 1199px)" href="css/style_projetor.css" />
    <link rel="stylesheet" type="text/css" media="screen and (max-width: 480px)" href="css/style_smartphone.css" />
    
    <link rel="stylesheet" type="text/css" media="screen and (min-width: 1200px)" href="css/materias.css" />
    <link rel="stylesheet" type="text/css" media="screen and (min-width: 1000px) and (max-width: 1199px)" href="css/materias_projetor.css" />
    <link rel="stylesheet" type="text/css" media="screen and (max-width: 480px)" href="css/materias_smartphone.css" />




<!-- JQuery -->
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Valida Materia-->
<script language="JavaScript" src="script/validaMateria.js"></script>


<!-- Bootstrap -->
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



</head>

<body>
	<!-- PRINCIPAL -->
	<main> <!-- MENU -->
	<section id="menu">

		<!-- LISTA -->
		<ul>
			
		   <li><a href="index.jsp">INÍCIO</a></li>
                <!-- <hr> -->
                <li><a href="colaboradores.jsp">COLABORADORES</a></li>
                <!-- <hr> -->
                <li><a href="alunos.jsp">ALUNOS</a></li>
                <!-- <hr> -->
                <li><a href="materias.jsp">MATÉRIAS</a></li>
                <!-- <hr> -->
                <li><a href="turmas.html">TURMAS</a></li>
                <!-- <hr> -->
                <li><a href="login.html">SAIR</a></li>
		</ul>

	</section>

	<!-- CONTEÃšDO -->
	<section id="conteudo">

		<!-- PAINEL -->
		<div id="painel">

			<!-- CONTEÃšDO PAINEL -->
			<h1 id="titulo">MATÉRIAS</h1>

			<hr class="linha">

			<!-- DIV CONTEÃšDO -->
			<div id="materias">

				<!-- BOTÃƒO CADASTRAR -->
				<input type="button" value="CADASTRAR" id="btnCadastrar"
					data-toggle="modal" data-target="#myModal">

				<!-- DIV LISTA MATÉRIAS -->
				<div id="divLista">

					<!-- TABELA MATÉRIAS -->
										
					<% out.print(new MateriaDao().listarMateria()); %>
					<%@ include file="script/checkbox.jsp" %>
					
					
				</div>				
				
			</div>



		</div>


	</section>


	</main>
	<!-- RODAPÃ‰ -->
	<footer> E21 - 2018</footer>

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog estiloModal" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">CADASTRAR MATÉRIAS</h4>
				</div>
				<div class="modal-body">
					<div>

						<form action="acoes/materiaAcao.jsp" name="formMateria" id="formMateria" onSubmit="return enviardados();">

							<!-- CADASTRAR MATÉRIA -->
							<li>
								<input type="text" name="nomeMateria" id="txtNomeMateria" placeholder="Nome Matéria">
								<!-- enviar para o banco de dados -->
								<input type="submit" value="Cadastrar" class="button button-primary">
							</li>
							
							<li>
							<label class="fieldObrigatorio" id="lblNomeMateria">Campo obrigatório</label>
							</li>
							
							
						</form>


					</div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>