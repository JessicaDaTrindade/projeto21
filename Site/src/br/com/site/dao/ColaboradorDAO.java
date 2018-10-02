package br.com.site.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.site.bean.ColaboradorBEAN;
import br.com.site.bean.MateriaBean;
import br.com.site.connection.Conexao;

public class ColaboradorDAO {

	// Atributos contendo a conex�o com o Banco de Dados
	Connection conexao;

	// Contrutor
	public ColaboradorDAO() {
		this.conexao = new Conexao().obterConexao();
	}

	// M�todo de cadastro
	public void cadastrarColaborador(ColaboradorBEAN obj) {

		// Tentar realizar o cadastro do aluno
		try {

			// SQL
			String sql = "INSERT INTO cadastrofuncionarios (nome, sobrenome, sexo, rg, cpf, dataNascimento, estadoCivil, cep, logradouro, numero, bairro, municipio, complemento, telefone, celular, email, idCargo, salario) VALUES "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			// Preparar a conex�o
			PreparedStatement pstmt = conexao.prepareStatement(sql);

			// Par�metros
			pstmt.setString(1, obj.getNome());
			pstmt.setString(2, obj.getSobrenome());
			pstmt.setString(3, obj.getSexo());
			pstmt.setString(4, obj.getRg());
			pstmt.setString(5, obj.getCpf());
			pstmt.setString(6, obj.getDataNascimento());
			pstmt.setString(7, obj.getEstadoCivil());
			pstmt.setString(8, obj.getCep());
			pstmt.setString(9, obj.getLogradouro());
			pstmt.setString(10, obj.getNumero());
			pstmt.setString(11, obj.getBairro());
			pstmt.setString(12, obj.getMunicipio());
			pstmt.setString(13, obj.getComplemento());
			pstmt.setString(14, obj.getTelefone());
			pstmt.setString(15, obj.getCelular());
			pstmt.setString(16, obj.getEmail());
			pstmt.setString(17, obj.getIdCargo());
			pstmt.setString(18, obj.getSalario());

			// Executar comando
			pstmt.execute();

		} catch (Exception e) {
			System.out.println("Falha ao cadastrar " + e.getMessage());
		}

	}

	// M�todo para pegar as informa��es dos Colaboradores
	public String listarColaboradores() {

		// Estrutura
		String estrutura = "<table class='table table-striped'>";
		estrutura += "<thead>";
		estrutura += "<tr>";
		estrutura += "<th class='celulaCargo'>Cargo</th>";
		estrutura += "<th class='celulaColaborador'>Nome</th>";
		estrutura += "<th class='celulaAlterar'>Alterar</th>";
		estrutura += "<th class='celulaExcluir'>Excluir</th>";
		estrutura += "</tr>";
		estrutura += "</thead>";
		estrutura += "<tbody>";

		// Obter os dados dos usu�rios
		try {
			
			// SQL
			String sql = "select cadastrofuncionarios.idCadastro, cargos.nomeCargo, cadastrofuncionarios.nome, cadastrofuncionarios.sobrenome FROM cargos\r\n" + 
					"INNER JOIN cadastrofuncionarios ON cargos.idCargo = cadastrofuncionarios.idCargo";

			// Comando para executar o SQL
			Statement stmt = conexao.createStatement();

			// Executar o comando e obter os dados
			ResultSet rs = stmt.executeQuery(sql);

			// La�o
			while (rs.next()) {
				estrutura += "<tr>";
				estrutura += "<td class='celulaCargo'>" + rs.getString(2) + "</td>";
				estrutura += "<td class='celulaColaborador'><a href='#' data-toggle='modal' data-target='#modalDetalhes"
						+ rs.getString(1) + "' title='Detalhes'>" + rs.getString(3) + " " + rs.getString(4)
						+ "</a></td>";
				estrutura += "<td class='celulaAlterar'><a href='#' data-toggle='modal' data-target='#modalAlterar"
						+ rs.getString(1)
						+ "' title='Alterar'><span class='celulaAlterar glyphicon glyphicon-pencil'></span></a></td>";
				estrutura += "<td class='celulaExcluir'><a href='#' data-toggle='modal' data-target='#modalExcluir"
						+ rs.getString(1)
						+ "' title='Excluir'><span class='celulaExcluir glyphicon glyphicon-trash'></span></a></td>";
				estrutura += "</tr>";

				estrutura +=modalAlterar(rs.getString(1));
				estrutura +=modalExcluir(rs.getString(1));
			}

			// Finalizar a estrutura
			estrutura += "</tbody>";
			estrutura += "</table>";

			// Voltar rs para o Indice 0
			rs.beforeFirst();

			while (rs.next()) {

				estrutura += "<div class='modal fade' id='modalDetalhes" + rs.getString(1)
						+ "' tabindex='-1' role='dialog'>";
				estrutura += "<div class='modal-dialog' role='document'>";
				estrutura += "<div class='modal-content'>";
				estrutura += "<div class='modal-header'>";
				estrutura += "<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>";
				estrutura += "<h4 class='modal-title'>DETALHES</h4>";
				estrutura += "</div>";
				estrutura += "<div class='modal-body'>";
				estrutura += "</div>";
				estrutura += "<div class='modal-footer'>";
				estrutura += "<button type='button' class='btn btn-default' data-dismiss='modal'>Fehar</button>";
				estrutura += "</div>";
				estrutura += "</div><!-- /.modal-content -->";
				estrutura += "</div><!-- /.modal-dialog -->";
				estrutura += "</div><!-- /.modal -->";

			}

		} catch (Exception e) {
			System.out.println("Falha ao listar."+e);
		}

		// Retorno
		return estrutura;

	}

	// M�todo para pegar os detalhes do professor
	public String detalhesColaborador(String idColaborador) {

		// Estrutura
		String estruturaDetalhes = "<table class='table table-striped tabela'>";
		estruturaDetalhes += "<thead>";
		estruturaDetalhes += "<tr>";
		estruturaDetalhes += "<th class='celulaCod'>C�digo</th>";
		estruturaDetalhes += "<th class='celulaNome'>Nome</th>";
		estruturaDetalhes += "</tr>";
		estruturaDetalhes += "</thead>";

		// Obter os dados do funcion�rio
		try {

			// SQL
			String sql = "SELECT cadastrofuncionarios.idCadastro, cadastrofuncionarios.nome";

			// PREPARAR CONEX�O
			PreparedStatement pstmt = conexao.prepareStatement(sql);

			// PAR�METROS
			pstmt.setString(1, idColaborador);

			// EXECUTAR COMANDO
			ResultSet rs = pstmt.executeQuery();

			// La�o
			while (rs.next()) {

				estruturaDetalhes += "<tr>";
				estruturaDetalhes += "<td class='celulaCod'>" + rs.getString(1) + "</td>";
				estruturaDetalhes += "<td class='celulaNome'>" + rs.getString(2) + "</td>";
				estruturaDetalhes += "</tr>";
			}
		} catch (Exception e) {
			System.out.println("Falha ao listar.");

		}

		// Finalizar a estrutura
		estruturaDetalhes += "</table>";

		// Retorno
		return estruturaDetalhes;

	}
	
	//M�TODO PARA EXCLUIR MAT�RIA
	public void excluirColaborador(int idColaborador) {
		
		//Tenta realizar a exclus�o
		try {
			
			//SQL
			String sql = "DELETE FROM cadastrofuncionarios WHERE idCadastro = ?";
			
			//Prepara a conex�o
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			//Par�metro
			pstmt.setInt(1, idColaborador);
			
			//Executa a a��o
			pstmt.execute();
			
		}catch(Exception e) {
			System.out.println("Falha ao excluir Colaborador.");
		}
	}
	
	//M�todo para Obter dados do Funcion�rio
		public ColaboradorBEAN dadosColaborador(String idCadastro){
			
			ColaboradorBEAN obj = new ColaboradorBEAN();
			
			//Tenta realizar a exclus�o
			try {
				
				//SQL
				String sql = "SELECT * FROM cadastrofuncionarios WHERE idCadastro = ?";
				
				//Prepara a conex�o
				PreparedStatement pstmt = conexao.prepareStatement(sql);
				
				//Par�metro
				pstmt.setString(1, idCadastro);
				
				//Executa a a��o
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					obj.setNome(rs.getString(3));
					obj.setSobrenome(rs.getString(4));
					obj.setSexo(rs.getString(5));
					obj.setRg(rs.getString(6));
					obj.setCpf(rs.getString(7));
					obj.setDataNascimento(rs.getString(8));
					obj.setEstadoCivil(rs.getString(9));
					obj.setCep(rs.getString(10));
					obj.setLogradouro(rs.getString(11));
					obj.setNumero(rs.getString(12));
					obj.setBairro(rs.getString(13));
					obj.setMunicipio(rs.getString(14));
					obj.setComplemento(rs.getString(15));
					obj.setTelefone(rs.getString(16));
					obj.setCelular(rs.getString(17));
					obj.setEmail(rs.getString(18));
					obj.setIdCargo(rs.getString(19));
					obj.setSalario(rs.getString(20));

				}	
				
			}catch(Exception e) {
				System.out.println("Falha ao selecionar colaborador. "+e);
			}
			
			//Retorno
			return obj;
			
		}
		
		//M�todo Modal
		public String modalAlterar(String idCadastro) {
			
			//String estruturaAlterar = "<% if(request.getParameter('idUsuario') == null){ %>";
			String estruturaAlterar = "<div class='modal fade' id='modalAlterar"+idCadastro+"' tabindex='-1' role='dialog'>";
			estruturaAlterar+="<div class='modal-dialog' role='document'>";
			estruturaAlterar+="<div class='modal-content'>";
			
			//IN�CIO FORMULARIO
			estruturaAlterar+="<form action='acoes/alterarColaborador.jsp'>";
			
			estruturaAlterar+="<div class='modal-header'>";
			estruturaAlterar+="<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>";
			estruturaAlterar+="<h4 class='modal-title'>Alterar Colaborador</h4>";
			estruturaAlterar+="</div>";
			estruturaAlterar+="<div class='modal-body'>";
			estruturaAlterar+="<p>Dados do cadastro: </p>";
			
			//Instanciar objeto usu�rio
			ColaboradorBEAN colaborador = new ColaboradorBEAN();
			colaborador = new ColaboradorDAO().dadosColaborador(idCadastro);
			
			
			//CAMPOS FORMUL�RIO
			estruturaAlterar+="<input type='hidden' name='idCadastro' id='idCadastro' value='"+colaborador.getIdCadastro()+"'><br>";
			estruturaAlterar += "<label>Nome";
			estruturaAlterar += "<br>";
			estruturaAlterar += "<input type='text' name='nome' value='"+colaborador.getNome()+"'>";
			estruturaAlterar += "</label>";
			estruturaAlterar += "<label>Sobrenome";
			estruturaAlterar += "<br>";
			estruturaAlterar += "<input type='text' name='sobrenome' value='"+colaborador.getSobrenome()+"'>";
			estruturaAlterar += "</label>";
			estruturaAlterar += "<label>Sexo" ;
			estruturaAlterar += "<br>";
		if(colaborador.getSexo().equals("M")){
				
				estruturaAlterar += "<input type='radio' value='F' name='sexo'>Feminino";
				estruturaAlterar += "<input type='radio' value='M' name='sexo' checked>Masculino";
				
			}else {
				
				estruturaAlterar += "<input type='radio' value='F' name='sexo' checked>Feminino";
				estruturaAlterar += "<input type='radio' value='M' name='sexo'>Masculino";
			}
			estruturaAlterar += "</label>";
			estruturaAlterar += "<br>";
			estruturaAlterar += "<label>RG";
			estruturaAlterar += "<br>";
			estruturaAlterar += "<input type='text' name='rg' value='"+colaborador.getRg()+"'>";
			estruturaAlterar += "</label>";
			estruturaAlterar += "<label>CPF";
			estruturaAlterar += "<br>";
			estruturaAlterar += "<input type='text' class=' cpf-mask ' name='cpf' placeholder='Ex.: 000.000.000-00'value='"+colaborador.getCpf()+"'>";
			estruturaAlterar += "</label>";
			estruturaAlterar += "<label>Data de nascimento";
			estruturaAlterar += "<br>";
			estruturaAlterar += "<label>Telefone";
			estruturaAlterar += "<br>";
			estruturaAlterar += "<input type='text' id='name' class='phone-ddd-mask' name='telefone' placeholder='Ex.: (00) 0000-0000'value='"+colaborador.getTelefone()+"'>";
			estruturaAlterar += "</label>";
			estruturaAlterar += "<label>Celular";
			estruturaAlterar += "<br>";
			estruturaAlterar += "<input type='text' class='phone-ddd-mask' name='celular' placeholder='Ex.: (00) 0000-0000'value='"+colaborador.getCelular()+"'>";
			estruturaAlterar += "</label>";
			estruturaAlterar += "<br>";
			estruturaAlterar += "<label>E-mail";
			estruturaAlterar += "<br>";
			estruturaAlterar += "<input type='email' name='email' placeholder='exemplo@exemplo.com.br'value='"+colaborador.getEmail()+"'>";
			estruturaAlterar += "</label>";
			estruturaAlterar += "<br>";
			estruturaAlterar += "<label>Estado Civil";
			estruturaAlterar += "<br>";
			if(colaborador.getEstadoCivil().equals("Solteiro(a)")){
				estruturaAlterar += "<input type='radio' value='Solteiro(a)' name='estadoCivil' checked>Solteiro(a)";
				estruturaAlterar += "<input type='radio' value='Casado(a)' name='estadoCivil'>Casado(a)";
				estruturaAlterar += "<input type='radio' value='Divorciado(a)' name='estadoCivil'>Divorciado(a)";
				estruturaAlterar += "<input type='radio' value='Viuvo(a)' name='estadoCivil'>Vi�vo(a)";
				
			}else if(colaborador.getEstadoCivil().equals("Casado(a)")){
				estruturaAlterar += "<input type='radio' value='Solteiro(a)' name='estadoCivil' >Solteiro(a)";
				estruturaAlterar += "<input type='radio' value='Casado(a)' name='estadoCivil' checked>Casado(a)";
				estruturaAlterar += "<input type='radio' value='Divorciado(a)' name='estadoCivil'>Divorciado(a)";
				estruturaAlterar += "<input type='radio' value='Viuvo(a)' name='estadoCivil'>Vi�vo(a)";
				
			}else if(colaborador.getEstadoCivil().equals("Divorciado(a)")){
				estruturaAlterar += "<input type='radio' value='Solteiro(a)' name='estadoCivil' >Solteiro(a)";
				estruturaAlterar += "<input type='radio' value='Casado(a)' name='estadoCivil' Casado(a)";
				estruturaAlterar += "<input type='radio' value='Divorciado(a)' name='estadoCivil'checked>Divorciado(a)";
				estruturaAlterar += "<input type='radio' value='Viuvo(a)' name='estadoCivil'>Vi�vo(a)";
				
			}else{
				estruturaAlterar += "<input type='radio' value='Solteiro(a)' name='estadoCivil' >Solteiro(a)";
				estruturaAlterar += "<input type='radio' value='Casado(a)' name='estadoCivil' Casado(a)";
				estruturaAlterar += "<input type='radio' value='Divorciado(a)' name='estadoCivil' >Divorciado(a)";
				estruturaAlterar += "<input type='radio' value='Viuvo(a)' name='estadoCivil'checked>Vi�vo(a)";
			}
			estruturaAlterar += "<h6 id='titulo'>Endere�o</h6>";
			estruturaAlterar += "<input type='text' name='cep' placeholder='CEP' value='"+colaborador.getCep()+"'>";
			estruturaAlterar += "<input type='text' name='logradouro' placeholder='LOGRADOURO' value='"+colaborador.getLogradouro()+"'>";
			estruturaAlterar += "<input type='text' name='numero' placeholder='N�' value='"+colaborador.getNumero()+"'>";
			estruturaAlterar += "<br>";
			estruturaAlterar += "<br>";
			estruturaAlterar += "<input type='text' name='bairro' placeholder='BAIRRO' value='"+colaborador.getBairro()+"'>";
			estruturaAlterar += "<input type='text' name='municipio' placeholder='MUNIC�PIO' value='"+colaborador.getMunicipio()+"'>";
			estruturaAlterar += "<input type='text' name='complemento' placeholder='COMPLEMENTO' value='"+colaborador.getComplemento()+"'>";
			estruturaAlterar += "<br>";
			estruturaAlterar += "<br>";
			
			estruturaAlterar+="</div>";
			estruturaAlterar+="<div class='modal-footer'>";
			
			//BOT�O SALVAR FORMULARIO
			estruturaAlterar+="<input type='submit' class='btn btn-primary' value='Salvar'>";
			
			estruturaAlterar+="<button type='button' class='btn btn-default' data-dismiss='modal'>Cancelar</button>";
			estruturaAlterar+="</div>";
			
			//FIM FORMUL�RIO
			estruturaAlterar+="</form>";
			
			estruturaAlterar+="</div><!-- /.modal-content -->";
			estruturaAlterar+="</div><!-- /.modal-dialog -->";
			estruturaAlterar+="</div><!-- /.modal -->";
			
			return estruturaAlterar;
		}
		
		//M�todo para Alterar Colaborador
		public void alterarDadosColaborador(ColaboradorBEAN obj) {
			
			//Tenta atualizar
			try {
				
				//SQL - #### VOU TER QUE ADD TODOS OS CAMPOS DE CADASTRO ####
				String sql = "UPDATE cadastrofuncionarios SET nome=? , sobrenome=? , sexo=? , rg=? , cpf=? , dataNascimento=? , estadoCivil=? , cep=? , logradouro=? , numero=? , bairro=? , municipio=? , complemento=? , telefone=? , celular=? , email=? , idCargo=? , salario= ? WHERE idCadastro =?";
				
				//Prepara a conex�o
				PreparedStatement pstmt = conexao.prepareStatement(sql);
				
				//Par�metros
				pstmt.setString(1, obj.getNome());
				pstmt.setString(2, obj.getSobrenome());
				pstmt.setString(3, obj.getSexo());
				pstmt.setString(4, obj.getRg());
				pstmt.setString(5, obj.getCpf());
				pstmt.setString(6, obj.getDataNascimento());
				pstmt.setString(7, obj.getEstadoCivil());
				pstmt.setString(8, obj.getCep());
				pstmt.setString(9, obj.getLogradouro());
				pstmt.setString(10, obj.getNumero());
				pstmt.setString(11, obj.getBairro());
				pstmt.setString(12, obj.getMunicipio());
				pstmt.setString(13, obj.getComplemento());
				pstmt.setString(14, obj.getTelefone());
				pstmt.setString(15, obj.getCelular());
				pstmt.setString(16, obj.getEmail());
				pstmt.setString(17, obj.getIdCargo());
				pstmt.setString(18, obj.getSalario());
				pstmt.setInt(19, obj.getIdCadastro());
				
				
				
				//Executar
				pstmt.execute();
				
			}catch(Exception e) {
				System.out.println("Falha ao alterar");
			}
			
		}
		
		//M�TODO MODAL EXCLUIR MAT�RIA
		public String modalExcluir(String idColaborador){
			//String estruturaAlterar = "<% if(request.getParameter('idUsuario') == null){ %>";
			String estruturaExcluir = "<div class='modal fade' id='modalExcluir"+idColaborador+"' tabindex='-1' role='dialog'>";	
			estruturaExcluir+="<div class='modal-dialog' role='document'>";
			estruturaExcluir+="<div class='modal-content'>";
			estruturaExcluir+="<div class='modal-header'>";
			estruturaExcluir+="<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>";
			estruturaExcluir+="<h4 class='modal-title'>Excluir Colaborador</h4>";
			estruturaExcluir+="</div>";
			estruturaExcluir+="<div class='modal-body'>";
			estruturaExcluir+="<p>Deseja realmente excluir?</p>";
						
			estruturaExcluir+="</div>";
			estruturaExcluir+="<div class='modal-footer'>";
			estruturaExcluir+="<a class='btn btn-danger' href='acoes/excluirColaborador.jsp?idCadastro="+idColaborador+"'>Excluir</a>";
			estruturaExcluir+="<button type='button' class='btn btn-default' data-dismiss='modal'>Cancelar</button>";
			estruturaExcluir+="</div>";
			estruturaExcluir+="</div><!-- /.modal-content -->";
			estruturaExcluir+="</div><!-- /.modal-dialog -->";
			estruturaExcluir+="</div><!-- /.modal -->";
			
			return estruturaExcluir;
		}
	
}
