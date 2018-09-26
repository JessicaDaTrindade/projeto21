package br.com.site.dao;

import java.sql.Connection;

import br.com.site.connection.Conexao;

public class notaDAO {
	
	Connection conexao;
	
	public notaDAO(){
		
		this.conexao = new Conexao().obterConexao();	
	}
	
	public void listarNotas() {
		
		
		
	}

}
