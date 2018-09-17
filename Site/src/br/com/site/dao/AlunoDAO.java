package br.com.site.dao;

//IMPORTATAR
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.com.site.bean.AlunoBEAN;
import br.com.site.bean.MateriaBean;
import br.com.site.connection.Conexao;

public class AlunoDAO {

	// Atributo contendo a conexão com o bd
	Connection conexao;

	// Construtor
	public AlunoDAO() {
		this.conexao = new Conexao().obterConexao();
	}

	// Método de cadastro
	public void cadastrarAluno(AlunoBEAN obj) {

		// Tentar realizar o cadastro do aluno
		try {

			// SQL
			String sql = "INSERT INTO cadastrosalunos ( nome, sobrenome, sexo, dataNascimento, estadoCivil, cpf, rg, cep, logradouro, numero,"
					+ "bairro, municipio, complemento, telefone,celular, nomeDaMae, nomeDoPai,"
					+ "responsavel, telResponsavel, celResponsavel, email) VALUES "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			// Preparar a conexão
			PreparedStatement pstmt = conexao.prepareStatement(sql);

			// Parâmetros
			pstmt.setString(1, obj.getNome());
			pstmt.setString(2, obj.getSobrenome());
			pstmt.setString(3, obj.getSexo());
			pstmt.setString(4, obj.getDataNascimento());
			pstmt.setString(5, obj.getEstadoCivil());
			pstmt.setString(6, obj.getCpf());
			pstmt.setString(7, obj.getRg());
			pstmt.setString(8, obj.getCep());
			pstmt.setString(9, obj.getLogradouro());
			pstmt.setString(10, obj.getNumero());
			pstmt.setString(11, obj.getBairro());
			pstmt.setString(12, obj.getMunicipio());
			pstmt.setString(13, obj.getComplemento());
			pstmt.setString(14, obj.getTelefone());
			pstmt.setString(15, obj.getCelular());
			pstmt.setString(16, obj.getNomeDaMae());
			pstmt.setString(17, obj.getNomeDoPai());
			pstmt.setString(18, obj.getResponsavel());
			pstmt.setString(19, obj.getTelResponsavel());
			pstmt.setString(20, obj.getCelResponsavel());
			pstmt.setString(21, obj.getEmail());

			// Executar comando
			pstmt.execute();
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("Falha ao cadastrar " + e.getMessage());
		}

	}

	// Metodo para selecionar alunos
	public String listarAlunos() {

		// SQL
		String sql = "select * From cadastrosalunos";

		// Estrutura
		String estrutura = "<table class='table table-striped' id='tabela' >";

		// Cabeçalho da tabela
		estrutura += "<thead>";
		estrutura += "<tr>";
		estrutura += "<th class='lefth'>Número Matrícula</th>";
		estrutura += " <th class='right'>Nome</th>";
		estrutura += "<th class='lefth'>Excluir</th>";
		estrutura += " <th class='right'>Alterar</th>";
		estrutura += "</tr>";
		estrutura += "</thead>";

		// Conteúdos da tabela
		estrutura += "<tbody>";

		try {
			Statement stmt = conexao.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				estrutura += "<tr>";
				estrutura += "<td class='tdLeft' >" + rs.getInt("idCadastro") + "</td>";
				estrutura += "<td class='tdRight'>" + rs.getString("nome") + " " + rs.getString("sobrenome") + "</td>";
				estrutura += "<td class='tdRight'>";
				// estrutura+="<a
				// href='acoes/excluirAluno.jsp?codigo="+rs.getInt("idCadastro")+"'>";
				estrutura += "<a href='' data-toggle='modal' data-target='#modalExcluir" + rs.getInt("idCadastro")
						+ "'>";
				estrutura += "<span class='glyphicon glyphicon-trash'> ";
				estrutura += "</a>";
				estrutura += "</td>";
				estrutura += "<td class='tdRight'>";
				estrutura += "<a href='' data-toggle='modal' data-target='#modalAlterar" + rs.getString("idCadastro")+"'>"; 
				estrutura += "<span class='glyphicon glyphicon-pencil'>";
				estrutura += "</a>";
				estrutura += "</td>";

				estrutura += "</tr>";

				estrutura += modalExcluir(rs.getString("idCadastro"));
				estrutura += modalAlterar(rs.getString("idCadastro"));
			}

		} catch (Exception e) {

		}

		estrutura += "</tbody>";
		// Término da tabela
		estrutura += "</table>";

		// Retorno
		return estrutura;
	}

	// MÉTODO MODAL EXCLUIR ALUNO
	public String modalExcluir(String idCadastro) {

		String estruturaExcluir = "<div class='modal fade' id='modalExcluir" + idCadastro
				+ "' tabindex='-1' role='dialog'>";
		estruturaExcluir += "<div class='modal-dialog' role='document'>";
		estruturaExcluir += "<div class='modal-content'>";
		estruturaExcluir += "<div class='modal-header'>";
		estruturaExcluir += "<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>";
		estruturaExcluir += "<h4 class='modal-title'>Excluir Aluno</h4>";
		estruturaExcluir += "</div>";
		estruturaExcluir += "<div class='modal-body'>";
		estruturaExcluir += "<p>Deseja realmente excluir?</p>";

		estruturaExcluir += "</div>";
		estruturaExcluir += "<div class='modal-footer'>";
		estruturaExcluir += "<a class='btn btn-danger' href='acoes/excluirAluno.jsp?idCadastro=" + idCadastro
				+ "'>Excluir</a>";
		estruturaExcluir += "<button type='button' class='btn btn-default' data-dismiss='modal'>Cancelar</button>";
		estruturaExcluir += "</div>";
		estruturaExcluir += "</div><!-- /.modal-content -->";
		estruturaExcluir += "</div><!-- /.modal-dialog -->";
		estruturaExcluir += "</div><!-- /.modal -->";

		return estruturaExcluir;
	}

	// Método para excluir
	public void excluirAluno(int idCadastro) {

		// SQL
		String sql = "DELETE FROM cadastrosalunos WHERE idCadastro = ?";

		// Tenta realizar a exclusão
		try {

			// Preparar a exclusão
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idCadastro);

			// Executar comando
			pstmt.execute();

			// Finalizar conexão com o banco de dados
			pstmt.close();

			// Mensagem
			System.out.println("Excluído com sucesso!");

		} catch (Exception e) {
			System.out.println("Falha ao excluir");
		}
	}

	// MÉTODO OBTER DADOS SELECIONADO ############################
	public AlunoBEAN dadosAluno(String idCadastro) {

		AlunoBEAN obj = new AlunoBEAN();

		// Tenta realizar a exclusão
		try {

			// SQL
			String sql = "SELECT * FROM cadastrosalunos WHERE idCadastro = ?";

			// Prepara a conexão
			PreparedStatement pstmt = conexao.prepareStatement(sql);

			// Parâmetro
			pstmt.setString(1, idCadastro);

			// Executa a ação
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				obj.setIdCadastro(rs.getInt(1));
				obj.setNome(rs.getString(2));
				obj.setSobrenome(rs.getString(3));
				obj.setSexo(rs.getString(4));
				obj.setRg(rs.getString(5));
				obj.setCpf(rs.getString(6));
				obj.setDataNascimento(rs.getString(7));
				obj.setEstadoCivil(rs.getString(8));
				obj.setCep(rs.getString(9));
				obj.setLogradouro(rs.getString(10));
				obj.setNumero(rs.getString(11));
				obj.setBairro(rs.getString(12));
				obj.setMunicipio(rs.getString(13));
				obj.setTelefone(rs.getString(14));
				obj.setCelular(rs.getString(15));
				obj.setComplemento(rs.getString(16));
				obj.setEmail(rs.getString(17));
				obj.setResponsavel(rs.getString(18));
				obj.setTelResponsavel(rs.getString(19));
				obj.setCelResponsavel(rs.getString(20));
				obj.setNomeDaMae(rs.getString(21));
				obj.setNomeDoPai(rs.getString(22));

			}

		} catch (Exception e) {
			System.out.println("Falha ao selecionar Aluno. " + e);
		}

		// Retorno
		return obj;

	}

	// MÉTODO MODAL #########################################################
	public String modalAlterar(String idCadastro) {

		// Instanciar objeto usuário
			AlunoBEAN aluno = new AlunoBEAN();
			aluno = new AlunoDAO().dadosAluno(idCadastro);
		

		// CAMPOS FORMULÁRIO
		String estruturaAlterar = "<div class='modal fade' id='modalAlterar"+idCadastro+"' tabindex='-1' role='dialog' >";
		estruturaAlterar+="<div class='modal-dialog' role='document'>";
		estruturaAlterar+="<div class='modal-content'>";
		estruturaAlterar += "<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>";
		estruturaAlterar+="<div class='modal-header'>";
		estruturaAlterar += "<h4 class='modal-title titulo' id='myModalLabel'>Alterar Aluno</h4>";
		estruturaAlterar += "</div>";
		estruturaAlterar += "<div class='modal-body'>";
		estruturaAlterar += "<div>";
		estruturaAlterar += "<form action='acoes/alterarAluno.jsp'>";
		estruturaAlterar += "<input type='hidden' name='idCadastro' value='"+aluno.getIdCadastro()+"'>"; 
		estruturaAlterar += "<label>Nome";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<input type='text' name='nome' value='"+aluno.getNome()+"'>";
		estruturaAlterar += "</label>";
		estruturaAlterar += "<label>Sobrenome";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<input type='text' name='sobrenome' value='"+aluno.getSobrenome()+"'>";
		estruturaAlterar += "</label>";
		estruturaAlterar += "<label>Sexo" ;
		estruturaAlterar += "<br>";
		if(aluno.getSexo().equals("M")){
			
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
		estruturaAlterar += "<input type='text' name='rg' value='"+aluno.getRg()+"'>";
		estruturaAlterar += "</label>";
		estruturaAlterar += "<label>CPF";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<input type='text' class=' cpf-mask ' name='cpf' placeholder='Ex.: 000.000.000-00'value='"+aluno.getCpf()+"'>";
		estruturaAlterar += "</label>";
		estruturaAlterar += "<label>Data de nascimento";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<input type='date' name='dataNascimento'value='"+aluno.getDataNascimento()+"'>";
		estruturaAlterar += "</label>";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<label>Nome da Mãe";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<input type='text' name='nomeDaMae'value='"+aluno.getNomeDaMae()+"'>";
		estruturaAlterar += "</label>";
		estruturaAlterar += "<label>Nome do Pai";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<input type='text' name='nomeDoPai' value='"+aluno.getNomeDoPai()+"'>";
		estruturaAlterar += "</label>";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<label>Telefone";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<input type='text' id='name' class='phone-ddd-mask' name='telefone' placeholder='Ex.: (00) 0000-0000'value='"+aluno.getTelefone()+"'>";
		estruturaAlterar += "</label>";
		estruturaAlterar += "<label>Celular";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<input type='text' class='phone-ddd-mask' name='celular' placeholder='Ex.: (00) 0000-0000'value='"+aluno.getCelular()+"'>";
		estruturaAlterar += "</label>";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<label>E-mail";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<input type='email' name='email' placeholder='exemplo@exemplo.com.br'value='"+aluno.getEmail()+"'>";
		estruturaAlterar += "</label>";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<label>Estado Civil";
		estruturaAlterar += "<br>";
		if(aluno.getEstadoCivil().equals("Solteiro(a)")){
			estruturaAlterar += "<input type='radio' value='Solteiro(a)' name='estadoCivil' checked>Solteiro(a)";
			estruturaAlterar += "<input type='radio' value='Casado(a)' name='estadoCivil'>Casado(a)";
			estruturaAlterar += "<input type='radio' value='Divorciado(a)' name='estadoCivil'>Divorciado(a)";
			estruturaAlterar += "<input type='radio' value='Viuvo(a)' name='estadoCivil'>Viúvo(a)";
			
		}else if(aluno.getEstadoCivil().equals("Casado(a)")){
			estruturaAlterar += "<input type='radio' value='Solteiro(a)' name='estadoCivil' >Solteiro(a)";
			estruturaAlterar += "<input type='radio' value='Casado(a)' name='estadoCivil' checked>Casado(a)";
			estruturaAlterar += "<input type='radio' value='Divorciado(a)' name='estadoCivil'>Divorciado(a)";
			estruturaAlterar += "<input type='radio' value='Viuvo(a)' name='estadoCivil'>Viúvo(a)";
			
		}else if(aluno.getEstadoCivil().equals("Divorciado(a)")){
			estruturaAlterar += "<input type='radio' value='Solteiro(a)' name='estadoCivil' >Solteiro(a)";
			estruturaAlterar += "<input type='radio' value='Casado(a)' name='estadoCivil' Casado(a)";
			estruturaAlterar += "<input type='radio' value='Divorciado(a)' name='estadoCivil'checked>Divorciado(a)";
			estruturaAlterar += "<input type='radio' value='Viuvo(a)' name='estadoCivil'>Viúvo(a)";
			
		}else{
			estruturaAlterar += "<input type='radio' value='Solteiro(a)' name='estadoCivil' >Solteiro(a)";
			estruturaAlterar += "<input type='radio' value='Casado(a)' name='estadoCivil' Casado(a)";
			estruturaAlterar += "<input type='radio' value='Divorciado(a)' name='estadoCivil' >Divorciado(a)";
			estruturaAlterar += "<input type='radio' value='Viuvo(a)' name='estadoCivil'checked>Viúvo(a)";
		}
		estruturaAlterar += "</label>";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<hr class='separador'>";
		estruturaAlterar += "<h5 id='titulo'>Dados Responsável</h5>";
		estruturaAlterar += "<label>Nome Responsável";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<input type='text' name='responsavel' value='"+aluno.getResponsavel()+"'>";
		estruturaAlterar += "</label>";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<label>Telefone Responsável";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<input type='text' id='name' class='phone-ddd-mask' name='telResponsavel' placeholder='Ex.: (00) 0000-0000' value='"+aluno.getTelResponsavel()+"'>";
		estruturaAlterar += "</label>";
		estruturaAlterar += "<label>Celular Responsável";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<input type='text' class='phone-ddd-mask' name='celResponsavel' placeholder='Ex.: (00) 0000-0000' value='"+aluno.getCelResponsavel()+"'>";
		estruturaAlterar += "</label>";
		estruturaAlterar += "<hr class='separador'>";
		estruturaAlterar += "<h6 id='titulo'>Endereço</h6>";
		estruturaAlterar += "<input type='text' name='cep' placeholder='CEP' value='"+aluno.getCep()+"'>";
		estruturaAlterar += "<input type='text' name='logradouro' placeholder='LOGRADOURO' value='"+aluno.getLogradouro()+"'>";
		estruturaAlterar += "<input type='text' name='numero' placeholder='Nº' value='"+aluno.getNumero()+"'>";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<input type='text' name='bairro' placeholder='BAIRRO' value='"+aluno.getBairro()+"'>";
		estruturaAlterar += "<input type='text' name='municipio' placeholder='MUNICÍPIO' value='"+aluno.getMunicipio()+"'>";
		estruturaAlterar += "<input type='text' name='complemento' placeholder='COMPLEMENTO' value='"+aluno.getComplemento()+"'>";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<br>";
		estruturaAlterar += "<div id='botao'>";
		estruturaAlterar += "<input type='submit' class='btn btn-primary' value='Salvar'>";
		estruturaAlterar += "<br>";
		estruturaAlterar += "</div>";
		estruturaAlterar += "</form>";
		estruturaAlterar += "</div>";
		estruturaAlterar += "<div class='modal-footer'>";
		estruturaAlterar += "</div>";
		estruturaAlterar += "</div>";
		estruturaAlterar += "</div>";
		estruturaAlterar += "</div>";

		return estruturaAlterar;
	}

	// MÉTODO ALTERAR ALUNO ###############################################
	public void alterarAluno(AlunoBEAN obj) {

		// Tenta atualizar
		try {

			

			// SQL
			String sql = "UPDATE cadastrosalunos SET  nome = ? WHERE idCadastro = ?";

			// Prepara a conexão
			PreparedStatement pstmt = conexao.prepareStatement(sql);

			// Parâmetros
			pstmt.setString(1, obj.getNome());
			pstmt.setInt(2, obj.getIdCadastro());

			// Executar
			pstmt.execute();

			

		} catch (Exception e) {
			System.out.println("Falha ao alterar");
		}

	}

}
