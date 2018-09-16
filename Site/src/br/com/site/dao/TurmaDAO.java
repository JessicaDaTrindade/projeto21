package br.com.site.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.site.connection.Conexao;

public class TurmaDAO {
	
	
	//Atributo contendo coexão com BD
	Connection conexao;
	
	//Contrutor
	public TurmaDAO() {
		this.conexao = new Conexao().obterConexao();
	}
	
	//MÉTODO CADASTRO #####################################################
	public String listarTurma() {
		
		String estrutura = "";
		
		try {
			
			//Var
			String sql = "SELECT * FROM TURMAS";
			
			//Executar SQL 
			Statement stmt = conexao.createStatement();
			
			
			//Resultados
			ResultSet rs = stmt.executeQuery(sql);
			
			//Laço resultados
			while(rs.next()) {
				estrutura += "<a href='#' class='btn btn-green' data-toggle='modal' data-target='#modalTurma"+rs.getString(1)+"' title='Detalhes'><h4 id='subtitulo'>"+rs.getString(2)+"</h4></a>";
				estrutura += modalDetalhes(rs.getString(1));
			}
			
		}catch(Exception e) {
			System.out.println("Falha ao listar turmas:"+e);
		}
		
		return estrutura;
		
	}
	
	//Listar alunos de determinada turma
	public String alunosTurma(String idTurma) {
		
		String estrutura = "";
		
		//
		try {
			
			String sql = "SELECT cadastrosalunos.nome FROM cadastrosalunos INNER JOIN alunos on alunos.idCadastro = cadastrosalunos.idCadastro WHERE alunos.idTurma = ?";
			
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			pstmt.setString(1, idTurma);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				estrutura+=rs.getString(1)+"<br>";
			}
			
			
		}catch(Exception e) {
			System.out.println("Falha ao listar alunos"+e);
		}
		
		return estrutura;
	}
	
	//Método modal detalhes
	public String modalDetalhes(String idTurma) {
		
			String estrutura="<div class='modal fade' id='modalTurma"+idTurma+"' tabindex='-1' role='dialog'>";
			estrutura+="<div class='modal-dialog' role='document'>";
			estrutura+="<div class='modal-content'>";
			estrutura+="<div class='modal-header'>";
			estrutura+="<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>";
			estrutura+="<h4 class='modal-title'>DETALHES</h4>";
			estrutura+="</div>";
			estrutura+="<div class='modal-body'>";
			estrutura+="<p>Alunos turma cód: "+idTurma+"</p>";
			estrutura+=alunosTurma(idTurma);
			estrutura+="</div>";
			estrutura+="<div class='modal-footer'>";
			estrutura+="<button type='button' class='btn btn-default' data-dismiss='modal'>Fehar</button>";	
			estrutura+="</div>";
			estrutura+="</div><!-- /.modal-content -->";
			estrutura+="</div><!-- /.modal-dialog -->";
			estrutura+="</div><!-- /.modal -->";
			
			return estrutura;
	}
}
