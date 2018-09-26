package br.com.site.dao;

import java.sql.Connection;

import br.com.site.connection.Conexao;

public class ProfessorDAO {
	
	Connection conexao;
	
	public ProfessorDAO(){
		
		this.conexao = new Conexao().obterConexao();	
	}
	


}
