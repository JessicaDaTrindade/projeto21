<!DOCTYPE html>
<html>

<head>
<!-- verificar sessão -->
<%@include file="include/incSessao.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Chamadas</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- CSS -->
<link rel="stylesheet" type="text/css"
	media="screen and (min-width: 1200px)" href="css/style.css" />
<link rel="stylesheet" type="text/css"
	media="screen and (min-width: 1000px) and (max-width: 1199px)"
	href="css/style_projetor.css" />


<link rel="stylesheet" type="text/css"
	media="screen and (min-width: 1200px)" href="css/chamada.css" />
<link rel="stylesheet" type="text/css"
	media="screen and (min-width: 1000px) and (max-width: 1199px)"
	href="css/chamada_projetor.css" />



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
		out.print("<img src=img/LECIONA.png class='logo' height='80px' width='100px' margin-top: 20px;>"+
				"<li><a href='index.jsp'>INÍCIO</a></li><li><a href='notas.jsp'>NOTAS</a></li><li><a href='chamada.jsp'>CHAMADA</a></li><li><a href='acoes/logout.jsp'>SAIR</a></li>");
	}
%>

		</ul>

	</section>


	<!-- CONTEÚDO -->
	<section id="conteudo">

		<div id="chamada">

			<h1>CHAMADA</h1>
			<hr class="separador">
			<br>

			<!-- listar Chamadas -->
			<div id="listarChamadas">

				<!-- tabela -->

				<table class="table table-striped">

					<thead>
						<tr>
							<th class="coluna1 ">Número Matrícula</th>
							<th class="coluna2 ">Nome</th>
							<th class="coluna3 colunaPresenca">Presença</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="coluna1">1</td>
							<td class="coluna2">Mark</td>
							<td class="coluna3">
								<form>

									<fieldset>

										<input id="radioPresente01" value="Presente" name="presenca"
											type="radio" id="radioPresenca"> <label
											for="radioPresente01">PRESENTE</label> <input
											id="radioAusente01" value="Ausente" name="presenca"
											type="radio" id="radioPresenca "> <label
											for="radioAusente01">AUSENTE</label>

									</fieldset>
								</form>
							</td>
						</tr>
						<tr>
							<td class="coluna1">2</td>
							<td class="coluna2">Jacob</td>
							<td class="coluna3">
								<form>

									<fieldset>

										<input id="radioPresente02" value="Presente" name="presenca"
											type="radio" id="radioPresenca"> <label
											for="radioPresente02">PRESENTE</label> <input
											id="radioAusente02" value="Ausente" name="presenca"
											type="radio" id="radioPresenca "> <label
											for="radioAusente02">AUSENTE</label>

									</fieldset>
								</form>
							</td>
						</tr>
						<tr>
							<td class="coluna1">3</td>
							<td class="coluna2">Larry</td>
							<td class="coluna3">
								<form>

									<fieldset>

										<input id="radioPresente03" value="Presente" name="presenca"
											type="radio" id="radioPresenca"> <label
											for="radioPresente03">PRESENTE</label> <input
											id="radioAusente03" value="Ausente" name="presenca"
											type="radio" id="radioPresenca "> <label
											for="radioAusente03">AUSENTE</label>

									</fieldset>
								</form>
							</td>
						</tr>
						<tr>
							<td class="coluna1">1</td>
							<td class="coluna2">Mark</td>
							<td class="coluna3">
								<form>

									<fieldset>

										<input id="radioPresente04" value="Presente" name="presenca"
											type="radio" id="radioPresenca"> <label
											for="radioPresente04">PRESENTE</label> <input
											id="radioAusente04" value="Ausente" name="presenca"
											type="radio" id="radioPresenca "> <label
											for="radioAusente04">AUSENTE</label>

									</fieldset>
								</form>
							</td>
						</tr>
						<tr>
							<td class="coluna1">2</td>
							<td class="coluna2">Jacob</td>
							<td class="coluna3">
								<form>

									<fieldset>

										<input id="radioPresente05" value="Presente" name="presenca"
											type="radio" id="radioPresenca"> <label
											for="radioPresente05">PRESENTE</label> <input
											id="radioAusente05" value="Ausente" name="presenca"
											type="radio" id="radioPresenca "> <label
											for="radioAusente05">AUSENTE</label>

									</fieldset>
								</form>
							</td>
						</tr>
						<tr>
							<td class="coluna1">3</td>
							<td class="coluna2">Larry</td>
							<td class="coluna3">
								<form>

									<fieldset>

										<input id="radioPresente06" value="Presente" name="presenca"
											type="radio" id="radioPresenca"> <label
											for="radioPresente06">PRESENTE</label> <input
											id="radioAusente06" value="Ausente" name="presenca"
											type="radio" id="radioPresenca "> <label
											for="radioAusente06">AUSENTE</label>

									</fieldset>
								</form>
							</td>
						</tr>
						<tr>
							<td class="coluna1">3</td>
							<td class="coluna2">Larry</td>
							<td class="coluna3">
								<form>

									<fieldset>

										<input id="radioPresente06" value="Presente" name="presenca"
											type="radio" id="radioPresenca"> <label
											for="radioPresente06">PRESENTE</label> <input
											id="radioAusente06" value="Ausente" name="presenca"
											type="radio" id="radioPresenca "> <label
											for="radioAusente06">AUSENTE</label>

									</fieldset>
								</form>
							</td>
						</tr>
						<tr>
							<td class="coluna1">3</td>
							<td class="coluna2">Larry</td>
							<td class="coluna3">
								<form>

									<fieldset>

										<input id="radioPresente06" value="Presente" name="presenca"
											type="radio" id="radioPresenca"> <label
											for="radioPresente06">PRESENTE</label> <input
											id="radioAusente06" value="Ausente" name="presenca"
											type="radio" id="radioPresenca "> <label
											for="radioAusente06">AUSENTE</label>

									</fieldset>
								</form>
							</td>
						</tr>
						<tr>
							<td class="coluna1">3</td>
							<td class="coluna2">Larry</td>
							<td class="coluna3">
								<form>

									<fieldset>

										<input id="radioPresente06" value="Presente" name="presenca"
											type="radio" id="radioPresenca"> <label
											for="radioPresente06">PRESENTE</label> <input
											id="radioAusente06" value="Ausente" name="presenca"
											type="radio" id="radioPresenca "> <label
											for="radioAusente06">AUSENTE</label>

									</fieldset>
								</form>
							</td>
						</tr>
						<tr>
							<td class="coluna1">3</td>
							<td class="coluna2">Larry</td>
							<td class="coluna3">
								<form>

									<fieldset>

										<input id="radioPresente06" value="Presente" name="presenca"
											type="radio" id="radioPresenca"> <label
											for="radioPresente06">PRESENTE</label> <input
											id="radioAusente06" value="Ausente" name="presenca"
											type="radio" id="radioPresenca "> <label
											for="radioAusente06">AUSENTE</label>

									</fieldset>
								</form>
							</td>
						</tr>
					</tbody>

				</table>

			</div>

		</div>

		<!-- BOTÃO CONFIRMAR -->
		<input type="button" id="btnInferior" value="CONFIRMAR">


	</section>




	</main>

	<footer> E21 - 2018</footer>

</body>

</html>