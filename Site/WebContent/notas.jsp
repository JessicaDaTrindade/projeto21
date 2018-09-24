<!DOCTYPE html>
<html>

<head>
<!-- verificar sessão -->
<%@include file = "include/incSessao.jsp"%>

  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Notas</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" media="screen" href="css/style.css" />
  <link rel="stylesheet" type="text/css" media="screen" href="css/Notas.css" />
  <script src="main.js"></script>



  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
    crossorigin="anonymous">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
    crossorigin="anonymous">

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
    crossorigin="anonymous"></script>

</head>

<body>

  <main>

    <!-- MENU -->
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
        <div id="legenda">
            <h5 id="legenda1">Clique neste icone para lançar as notas no sistema.</h5>
            <h5 id="legenda2">Clique neste icone para alterar as notas que estão registradas no sistema.</h5>
            <h5 id="legenda3">Clique neste icone para Excluir as notas que estão regostradas no sistema.</h5>
        </div>
          

        <h1>NOTAS</h1>
        <hr class="separador">

        <!-- listar Notas -->
        <div id="listarNotas">

          <!-- tabela -->

          <table class="table table-striped">

            <thead>
              <tr>
                <th class="lefth">Número Matrícula</th>
                <th class="right">Nome</th>
                <th class="right">Nota 1</th>
                <th class="right">Nota 2</th>
                <th class="right">Nota 3</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td class="tdLeft">1</td>
                <td class="tdRight">Paulo Alexis Cortes Vasquez</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
              </tr>
              <tr>
                <td class="tdLeft">2</td>
                <td class="tdRight">João da Silva</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
              </tr>
              <tr>
                <td class="tdLeft">3</td>
                <td class="tdRight">Ana dos Santos</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
              </tr>
              <tr>
                <td class="tdLeft">4</td>
                <td class="tdRight">Mária Aparecida Silvestre</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
              </tr>
              <tr>
                <td class="tdLeft">5</td>
                <td class="tdRight">Bruna de SOusa Alves</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
              </tr>
              <tr>
                <td class="tdLeft">6</td>
                <td class="tdRight">Leonardo Brito de Oliveira</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
              </tr>
              <tr>
                <td class="tdLeft">7</td>
                <td class="tdRight">Taís Nascimento Araújo</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
              </tr>
              <tr>
                <td class="tdLeft">8</td>
                <td class="tdRight">Taynara Carla Nanis</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
              </tr>
              <tr>
                <td class="tdLeft">9</td>
                <td class="tdRight">Victor Gustavo de Carvalho</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
              </tr>
              <tr>
                <td class="tdLeft">10</td>
                <td class="tdRight">Vinícius Pereira</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
              </tr>
              <tr>
                <td class="tdLeft">11</td>
                <td class="tdRight">Felipe Torres Fernandes</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
              </tr>
              <tr>
                <td class="tdLeft">12</td>
                <td class="tdRight">Renata Pereira Pinto</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
              </tr>
              <tr>
                <td class="tdLeft">13</td>
                <td class="tdRight">Pâmela Cristina Fernandes</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
                <td class="tdRight">10</td>
              </tr>
            </tbody>

          </table>

        </div>

        

      </div>

    </section>

  </main>

  <footer> E21 - 2018</footer>

</body>

</html>