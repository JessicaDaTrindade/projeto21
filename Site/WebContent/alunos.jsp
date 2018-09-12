<!DOCTYPE html>
<%@page import="br.com.site.dao.AlunoDAO"%>
<html>

<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>SGE | Alunos</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" media="screen" href="css/style.css" />
  <link rel="stylesheet" type="text/css" media="screen" href="css/alunos.css" />
  <script src="main.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
    crossorigin="anonymous">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
    crossorigin="anonymous">

  <!-- Latest compiled and minified JavaScript  -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
    crossorigin="anonymous"></script>
    
    <script src="js/script.js"></script>

</head>

<body>

  <main>

    <!-- MENU -->
    <section id="menu">

      <ul>
        <h1>SGE</h1>
        <li>
          <a href="index.jsp">INÍCIO</a>
        </li>
        <hr>
        <li>
          <a href="colaboradores.jsp">COLABORADORES</a>
        </li>
        <hr>
        <li>
          <a href="alunos.jsp">ALUNOS</a>
        </li>
        <hr>
        <li>
          <a href="materias.jsp">MATÉRIAS</a>
        </li>
        <hr>
        <li>
          <a href="turmas.html">TURMAS</a>
        </li>
        <hr>
        <li>
          <a href="login.html">SAIR</a>
        </li>

      </ul>

    </section>


    <!-- CONTEÚDO -->
    <section id="conteudo">

      <div id="aluno">

        <h1>ALUNOS </h1>

        <hr class="linha">
        
        <li class="separador"></li>

        <!-- cadastrar alunos -->
        <input type="button" value="CADASTRAR" id="btnCadastrar" data-toggle="modal" data-target="#myModal">

        <!-- pesquisar alunos -->
        
        <input type="text" id="pesquisarAluno"  placeholder="Pesquisar Aluno">

        <!-- listar alunos -->
        <div id="listarAlunos">

          <!-- tabela -->

          <%
          	out.print(new AlunoDAO().listarAlunos());
          	
          %>

        </div>

      </div>

      <!-- BOTÃO ALTERAR 
      <input type="button" id="btnInferior" value="Alterar">
        BOTÃO EXLCUIR 
      <input type="button" id="btnInferior" value="Excluir"> -->

    </section>




  </main>

  <footer> E21 - 2018</footer>
  

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog estiloModal " role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        
        <h4 class="modal-title titulo" id="myModalLabel">Cadastrar Aluno</h4>
       
      </div>
      <div class="modal-body">
      <div>
        
        <form action="acoes/alunoAcao.jsp">
        
	        <!-- Cdastrar nome e sobrenome -->
	        <label>Nome
	        <br>
	        <input type="text" name="nome">
	        </label>
	        <label>Sobrenome
	        <br>
	        <input type="text" name="sobrenome" >
        	</label>
        	
        	 <!-- Cadastrar Sexo  -->
        	<label>Sexo
        	<br>
        	<input type="radio" value="F" name="sexo">Feminino
        	<input type="radio" value="M" name="sexo">Masculino 
        	</label>
        	
        	<br>
        	
        	
        	<!-- Cadastrar RG e CPF  -->
        	<label>RG
        	<br>
        	<input type="text" name="rg" >
        	</label>
        	
        	<label>CPF
        	<br>
        	<input type="text" class=" cpf-mask	" name="cpf" placeholder="Ex.: 000.000.000-00" >
        	</label>
        	
        	<!-- cadastrar data de Nascimento -->
        	<label>Data de nascimento
        	<br>
        	<input type="date" name="dataNascimento" >
        	</label>
        	<br>	        	
        	<label>Nome da Mãe
        	<br>
        	<input type="text" name="nomeDaMae">
        	</label>
        	<label>Nome do Pai
        	<br>
        	<input type="text" name="nomeDoPai" >
        	</label>
        	<br>
        	        	
        	<!-- Cadastrar Telefone -->
        	<label>Telefone
        	 <br>      	 
        	 <input type="text" id="name" class="phone-ddd-mask" name="telefone" placeholder="Ex.: (00) 0000-0000">
        	 </label>  
        	 
        	 <label>Celular  
        	 <br>     	 
        	 <input type="text" class="phone-ddd-mask" name="celular" placeholder="Ex.: (00) 0000-0000">
        	</label> 
        	<br>
        	<!-- Cadastrar e-mail -->
        	<label>E-mail
        	<br>
        	<input type="email" name="email" placeholder="exemplo@exemplo.com.br">
        	</label>
        	<br>
        	
        	<!-- Cadastrar estado civil -->
        	<label>Estado Civil
        	<br>
        	<input type="radio" value="Solteiro(a)" name="estadoCivil">Solteiro(a)
        	<input type="radio" value="Casado(a)" name="estadoCivil">Casado(a)
        	<input type="radio" value="Divorciado(a)" name="estadoCivil">Divorciado(a)
        	<input type="radio" value="Viuvo(a)" name="estadoCivil">Viúvo(a)
        	</label>
        	<br>
        	<hr class="separador">
        	
        	<!-- Cadastrar Telefones para contato e responsável  -->
        	 <h5 id="titulo">Dados Responsável</h5>
        	
        	<label>Nome Responsável
        	<br>
        	<input type="text" name="responsavel">
        	</label>
        	<br>
        	<label>Telefone Responsável
        	 <br>      	 
        	 <input type="text" id="name" class="phone-ddd-mask" name="telResponsavel" placeholder="Ex.: (00) 0000-0000">
        	 </label>  
        	 
        	 <label>Celular Responsável 
        	 <br>     	 
        	 <input type="text" class="phone-ddd-mask" name="celResponsavel" placeholder="Ex.: (00) 0000-0000">
        	</label> 
        	
        	<hr class="separador">
        	
        	<!-- Cadastrar dados do endereço -->
        	<h6 id="titulo">Endereço</h6>
        	       	
        	<input type="text" name="cep" placeholder="CEP"> 
        	<input type="text" name="logradouro" placeholder="LOGRADOURO">
        	<input type="text" name="numero" placeholder="Nº">
        	<br>
        	<br>
        	<input type="text" name="bairro" placeholder="BAIRRO">
        	<input type="text" name="municipio" placeholder="MUNICÍPIO">
        	<input type="text" name="complemento" placeholder="COMPLEMENTO">
        	
        	<br>
        	<br>
        	
        	<div id="botao">	
        	<!-- enviar para o banco de dados -->
        	<input type="submit" value="Cadastrar"> 
        	<br>
        	</div>
        </form>
        
      
      </div>
      <div class="modal-footer">
       
    </div>
  </div>
</div>
</div>
</div>

</body>

</html>