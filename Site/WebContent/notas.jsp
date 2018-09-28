<!DOCTYPE html>
<%@page import="br.com.site.dao.AlunoDAO"%>
<%@page import="br.com.site.dao.TurmaDAO"%>
<html>

<head>
<!-- verificar sessão -->
<%@include file="include/incSessao.jsp"%>

<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Notas</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css"
	media="screen and (min-width: 1200px)" href="css/style.css" />
<link rel="stylesheet" type="text/css"
	media="screen and (min-width: 1000px) and (max-width: 1199px)"
	href="css/style_projetor.css" />
<link rel="stylesheet" type="text/css"
	media="screen and (max-width: 480px)" href="css/style_smartphone.css" />

<link rel="stylesheet" type="text/css"
	media="screen and (min-width: 1200px)" href="css/notas.css" />
<link rel="stylesheet" type="text/css"
	media="screen and (min-width: 1000px) and (max-width: 1199px)"
	href="css/notas_projetor.css" />





<!-- JQuery -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Valida Materia-->
<script language="JavaScript" src="script/validaMateria.js"></script>


<!-- Bootstrap  -->
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

	<main> <!-- MENU -->
	<section id="menu">

		<ul>
			<%
	

	if (user.getCargo() == 1) {
		response.sendRedirect("index.jsp");
	} else if (user.getCargo() == 3) {
		response.sendRedirect("index.jsp");
	}else if (user.getCargo() == 2) {
		out.print(
				"<li><a href='index.jsp'>INÍCIO</a></li><li><a href='notas.jsp'>NOTAS</a></li><li><a href='chamada.jsp'>CHAMADA</a></li><li><a href='acoes/logout.jsp'>SAIR</a></li>");
	}
%>

		</ul>

	</section>


	<!-- CONTEÚDO -->
	<section id="conteudo">

		<div id="nota">

<br>
			<h1 id="titulo">NOTAS</h1>
			<hr class="separador">

			<!-- listar Notas -->
			<div id="conteudo">

				<div id="areaNotas">

					<div id="legenda">
				<p><span class='glyphicon glyphicon-plus' alt='Lançar nota'>	Clique neste icone para lançar as notas no
					sistema.</p>
				<p><sapn class="glyphicon glyphicon-pencil">	Clique neste icone para alterar as notas que
					estão registradas no sistema.</p>
				<p><span class='glyphicon glyphicon-trash' alt='Excluir'>	Clique neste icone para Excluir as notas que
					estão regostradas no sistema.</p>
			</div>
			<br><br>
					<form id="frmNotas">
						<div id="filtTurma">
						<select name="frmTurmas" form="frmNotas">
						<option value="-1">Selecionar Turma</option>
							<% 
							String funcionarioLogado = String.valueOf(user.getCodFunc());
							out.print(new TurmaDAO().selectTurmasProf(funcionarioLogado));
							%>
						</select>
						<p>Filtrar turmas</p>
						</div>

					</form>
					<br><br>
					<% out.print(new AlunoDAO().listarAlunosProf(funcionarioLogado)); %>

				</div>


			</div>



		</div>

	</section>

	</main>

	<footer> E21 - 2018</footer>

</body>

</html>