<!DOCTYPE html>
<%@page import="br.com.site.dao.TurmaDAO"%>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>SGE - TURMAS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="main.js"></script>

<!-- CSS -->
<link rel="stylesheet" type="text/css" media="screen and (min-width: 1200px)" href="css/style.css" />
<link rel="stylesheet" type="text/css" media="screen and (min-width: 1000px) and (max-width: 1199px)" href="css/style_projetor.css" />
<link rel="stylesheet" type="text/css" media="screen and (max-width: 480px)" href="css/style_smartphone.css" />

<link rel="stylesheet" type="text/css" media="screen and (min-width: 1200px)" href="css/turmas.css" />
<link rel="stylesheet" type="text/css" media="screen and (min-width: 1000px) and (max-width: 1199px)" href="css/turmas_projetor.css" />
<link rel="stylesheet" type="text/css" media="screen and (max-width: 480px)" href="" />

<!-- JQuery -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Boostrap CSSS -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


</head>
<body>
    
    <main>
        
        <!-- MENU -->
        <section id="menu">

            <ul>
            
                <li><a href="index.jsp">INÍCIO</a></li>
                
                <li><a href="colaboradores.jsp">COLABORADORES</a></li>
                
                <li><a href="alunos.jsp">ALUNOS</a></li>
                
                <li><a href="materias.jsp">MATÉRIAS</a></li>
                
                <li><a href="turmas.jsp">TURMAS</a></li>
                
                <li><a href="login.jsp">SAIR</a></li>

            </ul>

        </section>
        
        <!-- CONTEÚDO -->
        <section id="conteudoTurmas">

            <div id="painelTurmas">

                <h1 id="titulo">TURMAS</h1>

                <hr class="linha">

				<!-- Modelo Link -->
                <!--<a href="https://comps.canstockphoto.com.br/selo-testado-aprovado-imagem_csp20208679.jpg" class="btn btn-green"><h4 id="subtitulo">1ºano - a</h4></a>-->
                
                 <% out.print(new TurmaDAO().listarTurma());%>
               

                
            </div>
            

        </section>

        


    </main>

    <footer> E21 - 2018 </footer>

</body>
</html>