package br.com.site.dao;

import java.sql.Connection;
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
				estrutura += "<a href='#' class='btn btn-green'><h4 id='subtitulo'>"+rs.getString(2)+"</h4></a>";
			}
			
		}catch(Exception e) {
			System.out.println("Falha ao listar turmas:"+e);
		}
		
		return estrutura;
		
	}

}
