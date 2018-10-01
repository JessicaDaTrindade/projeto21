<!-- IMPORTAR CLASSES JAVA  -->

<%@page import="br.com.site.dao.AvisosDao"%>
<%@page import="br.com.site.dao.AlunoDAO"%>
<%@page import="br.com.site.bean.UserLoginBEAN"%>
<%@ page import="br.com.site.connection.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<!-- verificar sessão -->
<%@include file = "include/incSessao.jsp"%>

<!-- comentario jessica -->
<!-- comentario amilton -->
<!-- jessica -->

    <meta charset="utf-8" />	
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Início</title>
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
	
	
<script language="javascript">
function enviarAviso(){
	document.getElementById("frmAvisos").submit();
}
</script>
<script language="javascript">
function alterarAviso(){
	document.getElementById("frmAlterarAvisos").submit();
}
</script>
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


<%
	

	if (user.getCargo() == 1) {
		out.print("<img src=img/LECIONA.png class='logo' height='80px' width='100px' margin-top: 20px;>"+
				"<li><a href='index.jsp'>INÍCIO</a></li><li><a href='colaboradores.jsp'>COLABORADORES</a></li><li><a href='alunos.jsp'>ALUNOS</a></li><li><a href='materias.jsp'>MATÉRIAS</a></li><li><a href='turmas.jsp'>TURMAS</a></li><li><a href='acoes/logout.jsp'>SAIR</a></li>");
	} else if (user.getCargo() == 3) {
		out.print("<img src=img/LECIONA.png class='logo' height='80px' width='100px' margin-top: 20px;>"+
				"<li><a href='index.jsp'>INÍCIO</a></li><li><a href='alunos.jsp'>ALUNOS</a></li><li><a href='materias.jsp'>MATÉRIAS</a></li><li><a href='turmas.jsp'>TURMAS</a></li><li><a href='acoes/logout.jsp'>SAIR</a></li>");
	}else if (user.getCargo() == 2) {
		out.print("<img src=img/LECIONA.png class='logo' height='80px' width='100px' margin-top: 20px;>"+
				"<li><a href='index.jsp'>INÍCIO</a></li><li><a href='notas.jsp'>NOTAS</a></li><li><a href='chamada.jsp'>CHAMADA</a></li><li><a href='acoes/logout.jsp'>SAIR</a></li>");
	}
%>
				
            </ul>
             </section>
             
             
             
             
              <!-- CONTEÚDO -->
        <section id="conteudoInicio">

            <div id="painelInicio">

                <h1 id="titulo">BEM-VINDO</h1>

                <hr class="linha">

                <div class="card">
                    <div class="container">
                          <h4 id="not">
                          <!-- listar Avisos -->
        			

         <MARQUEE class= "marqueAviso" direction="left" onmouseover='this.stop()' onmouseout='this.start()'>
          		<% out.print(new AvisosDao().listarAvisos()); %>
          	
          </marquee>
						</h4> 
						
        </div>
                          
                    </div>
                </div>

                <h3 id="subtitulo">Calendário escolar</h3>

                <iframe src="https://calendar.google.com/calendar/embed?showTitle=0&amp;showPrint=0&amp;showCalendars=0&amp;showTz=0&amp;height=600&amp;wkst=1&amp;bgcolor=%23ffffff&amp;src=igirvue9k08c34jotcunagc5tg%40group.calendar.google.com&amp;color=%23AB8B00&amp;ctz=America%2FSao_Paulo" id="calendario"></iframe>
				
				
				
					<%
					
					
						if (user.getCargo() == 1) {
								
								out.print("<form name='frmAvisos' id='frmAvisos' action='acoes/avisosAcao.jsp'> ");  
								out.print("<input type='text' name='txtAvisos' id='txtAvisos' placeholder='Cadastrar avisos'>");
								out.print("<a href='#' onclick='javascript:enviarAviso();'><span class='Enviar glyphicon glyphicon-ok'></a>");
								out.print("</form>");
								
							
						} else if (user.getCargo() == 3) {
							
							out.print("<form name='frmAvisos' id='frmAvisos' action='acoes/avisosAcao.jsp'> ");  
							out.print("<input type='text' name='txtAvisos' id='txtAvisos' placeholder='Cadastrar avisos'>");
							out.print("<li><a href='#' onclick='javascript:enviarAviso();'><span class='Enviar glyphicon glyphicon-ok'> Enviar</a></li>");
							out.print("</form>");						
									
						}
					out.print(new AvisosDao().tabelaAvisos());
					%>
           

        </section>
             
        
        </main>
        
        <footer> E21 - 2018</footer>
    

</body>
</html>