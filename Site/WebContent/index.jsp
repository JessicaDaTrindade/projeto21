<!-- IMPORTAR CLASSES JAVA  -->
<%@page import="br.com.site.bean.UserLoginBEAN"%>
<%@ page import="br.com.site.connection.*"%>
<!DOCTYPE html>
<html>
<head>

	
<%
	//Verificar se h� sess�o
	UserLoginBEAN user = new UserLoginBEAN();
	try{
		
		user = (UserLoginBEAN) session.getAttribute("user");
		if(user.getUsuario() == null){
			response.sendRedirect("index.jsp");
		}
		
	}catch(Exception erro){
		user = new UserLoginBEAN();
		response.sendRedirect("login.jsp");
	}
%>

    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>In�cio</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen and (min-width: 1200px)" href="css/style.css" />
    <link rel="stylesheet" type="text/css" media="screen and (min-width: 1000px) and (max-width: 1199px)" href="css/style_projetor.css" />
    <link rel="stylesheet" type="text/css" media="screen and (min-width: 1200px)" href="css/inicio.css" />
    <link rel="stylesheet" type="text/css" media="screen and (min-width: 1000px) and (max-width: 1199px)" href="css/inicio_projetor.css" />


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
    
    <main>
    
    <%
		Conexao c = new Conexao();
		c.obterConexao();
	%>
        
        <!-- MENU -->
        <section id="menu">

            <ul>
                <li><a href="index.jsp">IN�CIO</a></li>
                <!-- <hr> -->
                <li><a href="colaboradores.jsp">COLABORADORES</a></li>
                <!-- <hr> -->
                <li><a href="alunos.jsp">ALUNOS</a></li>
                <!-- <hr> -->
                <li><a href="materias.jsp">MAT�RIAS</a></li>
                <!-- <hr> -->
                <li><a href="turmas.html">TURMAS</a></li>
                <!-- <hr> -->
                <li><a href="login.html">SAIR</a></li>

            </ul>

        </section>
        
        <!-- CONTE�DO -->
        <section id="conteudoInicio">

            <div id="painelInicio">

                <h1 id="titulo">BEM-VINDO</h1>

                <hr class="linha">

                <div class="card">
                    <div class="container">
                          <h4 id="not">Aqui v�o as notifica��es da escola. E qualquer outra porcaria que voc� queira ler!</h4> 
                    </div>
                </div>

                <h3 id="subtitulo">Calendario escolar</h3>

                <iframe src="https://calendar.google.com/calendar/embed?showTitle=0&amp;showPrint=0&amp;showCalendars=0&amp;showTz=0&amp;height=600&amp;wkst=1&amp;bgcolor=%23ffffff&amp;src=igirvue9k08c34jotcunagc5tg%40group.calendar.google.com&amp;color=%23AB8B00&amp;ctz=America%2FSao_Paulo" id="calendario"></iframe>

            </div>

        </section>


    </main>

    <footer> E21 - 2018</footer>

</body>
</html>