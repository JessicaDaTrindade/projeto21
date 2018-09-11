package br.com.site.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.text.Document;

import br.com.site.bean.MateriaBean;
import br.com.site.connection.Conexao;

public class MateriaDao {
	
	//Atributo contendo coexão com BD
	Connection conexao;
	
	//Contrutor
	public MateriaDao() {
		this.conexao = new Conexao().obterConexao();
	}
	
	//MÉTODO CADASTRO #####################################################
	public void cadastrarMateria(MateriaBean obj) {
		
		//Tentar realizar cadastro do aluno
		try {
			
			//SQL
			String sql = "INSERT INTO materias (nomeMateria) VALUES (?)";
			
			//PREPARAR CONEXÃO
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			//PARÂMETROS
			pstmt.setString(1, obj.getNomeMateria());
			
			//EXECUTAR COMANDO
			pstmt.execute();
			
			
		} catch (Exception e) {
			System.out.println("Falha ao cadastrar "+e.getMessage());
		}
		
	}
	
	//MÉTODO LISTAGEM DAS MATÉRIAS ########################################
	public String listarMateria() {
		
		//Estrutura
		String estrutura = "<table class='table table-striped'>";
		estrutura += "<thead>";
		estrutura += "<tr>";
		estrutura += "<th class='celulaCod'>Código</th>"; 
		estrutura += "<th class='celulaMateria'>Nome</th>";
		estrutura += "<th class='celulaAlterar'>Alterar</th>"; 
		estrutura += "<th class='celulaExcluir'>Excluir</th>";
		estrutura += "</tr>";
		estrutura += "</thead>";
		estrutura += "<tbody>";
		
		//Obter os dados dos usuários
		try {
			
			//SQL
			String sql = "SELECT * FROM materias";
			
			
			//Comando para executar o comando SQL
			Statement stmt = conexao.createStatement();
			
			//Executar o comando e obter os dados
			ResultSet rs = stmt.executeQuery(sql);
			
			//Laço
			while(rs.next()) {
				
				estrutura += "<tr>";	
				estrutura += "<td class='celulaCod'>"+rs.getString(1)+"</td>";
				estrutura += "<td class='celulaMateria'><a href='#' data-toggle='modal' data-target='#modalDetalhes"+rs.getString(1)+"' title='Detalhes'>"+rs.getString(2)+"</a></td>";
				estrutura += "<td class='celulaAlterar'><a href='#' data-toggle='modal' data-target='#modalAlterar"+rs.getString(1)+"' title='Alterar'><span class='celulaAlterar glyphicon glyphicon-pencil'></span></a></td>";
				estrutura += "<td class='celulaExcluir'><a href='#' data-toggle='modal' data-target='#modalExcluir"+rs.getString(1)+"' title='Excluir'><span class='celulaExcluir glyphicon glyphicon-trash'></span></a></td>";				
				estrutura += "</tr>";
				
				estrutura +=modalAlterar(rs.getString(1));
				estrutura +=modalExcluir(rs.getString(1));
			}
			
			//Finalizar a estrutura
			estrutura += "</tbody>";
			estrutura += "</table>";
			
			//Voltar rs para o índice 0
			rs.beforeFirst();
			
			while(rs.next()) {
				
				estrutura+="<div class='modal fade' id='modalDetalhes"+rs.getString(1)+"' tabindex='-1' role='dialog'>";
				estrutura+="<div class='modal-dialog' role='document'>";
				estrutura+="<div class='modal-content'>";
				estrutura+="<div class='modal-header'>";
				estrutura+="<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>";
				estrutura+="<h4 class='modal-title'>DETALHES</h4>";
				estrutura+="</div>";
				estrutura+="<div class='modal-body'>";
				estrutura+="<p>Professores da disciplina "+rs.getString(2)+"</p>";
				estrutura+=detalhesMateria(rs.getString(1));
				estrutura+="</div>";
				estrutura+="<div class='modal-footer'>";
				estrutura+="<button type='button' class='btn btn-default' data-dismiss='modal'>Fehar</button>";	
				estrutura+="</div>";
				estrutura+="</div><!-- /.modal-content -->";
				estrutura+="</div><!-- /.modal-dialog -->";
				estrutura+="</div><!-- /.modal -->";
				
				
			}
			
		}catch(Exception e) {
			System.out.println("Falha ao listar matérias.");
		}
		

		
		
		//Retorno
		return estrutura;
		
	}
	
	//MÉTODO LISTAR VÍNCULOS MATÉRIA #######################################
	public String detalhesMateria(String idMateria){
	
	//Estrutura
	String estruturaDetalhes = "<table class='table table-striped tabela'>";
	estruturaDetalhes += "<thead>";
	estruturaDetalhes += "<tr>";
	estruturaDetalhes += "<th class='celulaCod'>Código</th>"; 
	estruturaDetalhes += "<th class='celulaNome'>Nome</th>";  
	estruturaDetalhes += "</tr>";
	estruturaDetalhes += "</thead>";
	
	//Obter os dados dos usuários
	try {
		
		//SQL
		String sql = "SELECT cadastrofuncionarios.idCadastro, cadastrofuncionarios.nome FROM cadastrofuncionarios INNER JOIN funcionarios ON funcionarios.idCadastro = cadastrofuncionarios.idCadastro INNER JOIN leciona ON leciona.idFuncionario = funcionarios.idFuncionario WHERE leciona.idMateria = ?";
		
		//PREPARAR CONEXÃO
		PreparedStatement pstmt = conexao.prepareStatement(sql);
		
		//PARÂMETROS
		pstmt.setString(1, idMateria);
		
		//EXECUTAR COMANDO
		ResultSet rs = pstmt.executeQuery();
		
		//Laço
		while(rs.next()) {
	
			estruturaDetalhes += "<tr>";
			estruturaDetalhes += "<td class='celulaCod'>"+rs.getString(1)+"</td>";
			estruturaDetalhes += "<td class='celulaNome'>"+rs.getString(2)+"</td>";
			estruturaDetalhes += "</tr>";
}
		
	}catch(Exception e) {
		System.out.println("Falha ao listar.");
	}
	
	//Finalizar a estrutura
	estruturaDetalhes += "</table>";
	
	
	//Retorno
	return estruturaDetalhes;		
	}
	
	//MÉTODO PARA EXCLUIR MATÉRIA ##########################################
	public void excluirMateria(int idMateria) {
		
		//Tenta realizar a exclusão
		try {
			
			//SQL
			String sql = "DELETE FROM materias WHERE idMateria = ?";
			
			//Prepara a conexão
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			//Parâmetro
			pstmt.setInt(1, idMateria);
			
			//Executa a ação
			pstmt.execute();
			
		}catch(Exception e) {
			System.out.println("Falha ao excluir matéria.");
		}
	}
	
	//MÉTODO OBTER DADOS DA MATÉRIA SELECIONADA ############################
	public MateriaBean dadosMateria(String idMateria){
		
		MateriaBean obj = new MateriaBean();
		
		//Tenta realizar a exclusão
		try {
			
			//SQL
			String sql = "SELECT * FROM materias WHERE idMateria = ?";
			
			//Prepara a conexão
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			//Parâmetro
			pstmt.setString(1, idMateria);
			
			//Executa a ação
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
			
				obj.setIdMateria(rs.getInt(1));
				obj.setNomeMateria(rs.getString(2));
				
			}	
			
		}catch(Exception e) {
			System.out.println("Falha ao selecionar matéria. "+e);
		}
		
		//Retorno
		return obj;
		
	}
	
	//MÉTODO MODAL #########################################################
	public String modalAlterar(String idMateria) {
		
		//String estruturaAlterar = "<% if(request.getParameter('idUsuario') == null){ %>";
		String estruturaAlterar = "<div class='modal fade' id='modalAlterar"+idMateria+"' tabindex='-1' role='dialog'>";
		estruturaAlterar+="<div class='modal-dialog' role='document'>";
		estruturaAlterar+="<div class='modal-content'>";
		
		//INÍCIO FORMULARIO
		estruturaAlterar+="<form action='acoes/alterarMateria.jsp'>";
		
		estruturaAlterar+="<div class='modal-header'>";
		estruturaAlterar+="<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>";
		estruturaAlterar+="<h4 class='modal-title'>Alterar Cadastro</h4>";
		estruturaAlterar+="</div>";
		estruturaAlterar+="<div class='modal-body'>";
		estruturaAlterar+="<p>Dados do cadastro: </p>";
		
		//Instanciar objeto usuário
		MateriaBean materia = new MateriaBean();
		materia = new MateriaDao().dadosMateria(idMateria);
		
		
		//CAMPOS FORMULÁRIO
		estruturaAlterar+="<input type='hidden' name='idMateria' id='idMateria' value='"+materia.getIdMateria()+"'><br>";
		estruturaAlterar+="<input type='text' name='nomeMateria' id='nomeMateria' value='"+materia.getNomeMateria()+"'><br>";	
		
		estruturaAlterar+="</div>";
		estruturaAlterar+="<div class='modal-footer'>";
		
		//BOTÃO SALVAR FORMULARIO
		estruturaAlterar+="<input type='submit' class='btn btn-primary' value='Salvar'>";
		
		estruturaAlterar+="<button type='button' class='btn btn-default' data-dismiss='modal'>Cancelar</button>";
		estruturaAlterar+="</div>";
		
		//FIM FORMULÁRIO
		estruturaAlterar+="</form>";
		
		estruturaAlterar+="</div><!-- /.modal-content -->";
		estruturaAlterar+="</div><!-- /.modal-dialog -->";
		estruturaAlterar+="</div><!-- /.modal -->";
		
		return estruturaAlterar;
	}
	
	//MÉTODO ALTERAR MATÉRIA ###############################################
	public void alterarDadosMateria(MateriaBean obj) {
		
		//Tenta atualizar
		try {
			
			//SQL
			String sql = "UPDATE materias SET nomeMateria = ? WHERE idMateria = ?";
			
			//Prepara a conexão
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			//Parâmetros
			pstmt.setString(1, obj.getNomeMateria());
			pstmt.setInt(2, obj.getIdMateria());
			
			//Executar
			pstmt.execute();
			
		}catch(Exception e) {
			System.out.println("Falha ao alterar");
		}
		
	}
	
	//MÉTODO MODAL EXCLUIR MATÉRIA
	public String modalExcluir(String idMateria){
		//String estruturaAlterar = "<% if(request.getParameter('idUsuario') == null){ %>";
		String estruturaExcluir = "<div class='modal fade' id='modalExcluir"+idMateria+"' tabindex='-1' role='dialog'>";	
		estruturaExcluir+="<div class='modal-dialog' role='document'>";
		estruturaExcluir+="<div class='modal-content'>";
		estruturaExcluir+="<div class='modal-header'>";
		estruturaExcluir+="<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>";
		estruturaExcluir+="<h4 class='modal-title'>Excluir matéria</h4>";
		estruturaExcluir+="</div>";
		estruturaExcluir+="<div class='modal-body'>";
		estruturaExcluir+="<p>Deseja realmente excluir?</p>";
		
		
		
		
		
		estruturaExcluir+="</div>";
		estruturaExcluir+="<div class='modal-footer'>";
		estruturaExcluir+="<a class='btn btn-danger' href='acoes/excluirMateria.jsp?idMateria="+idMateria+"'>Excluir</a>";
		estruturaExcluir+="<button type='button' class='btn btn-default' data-dismiss='modal'>Cancelar</button>";
		estruturaExcluir+="</div>";
		estruturaExcluir+="</div><!-- /.modal-content -->";
		estruturaExcluir+="</div><!-- /.modal-dialog -->";
		estruturaExcluir+="</div><!-- /.modal -->";
		
		return estruturaExcluir;
	}
}
