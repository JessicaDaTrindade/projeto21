<!DOCTYPE html>
<%@page import="br.com.site.bean.UserLoginBEAN"%>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="main.js"></script>


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

<!-- CSS -->
<link rel="stylesheet" type="text/css" media="screen"
	href="css/style.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="css/login.css" />



</head>
<body>

	<!-- DIV CONTEÚDO-->
	<div id="teste">

		<!-- DIV LOGIN -->
		<div class="login">


			<form method="post" action="acoes/logar.jsp" id="frmLogin">


				<input type="text" class="form-control " id="usuario" name="usuario"
					placeholder="CPF"> <br> <input type="password"
					class="form-control " id="senha" name="senha" placeholder="Senha">
				<br> <br> <br>
				<button type="submit" class="btn btn-default btn-lg btn-block">ENTRAR</button>

			</form>


		</div>

	</div>

	<footer> E21 - 2018</footer>

</body>
</html>