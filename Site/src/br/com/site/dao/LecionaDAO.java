package br.com.site.dao;

import java.sql.Connection;

import br.com.site.connection.Conexao;

public class LecionaDAO {
	//Atributo contendo coex�o com BD
	Connection conexao;
	
	//Contrutor
	public LecionaDAO() {
		this.conexao = new Conexao().obterConexao();
	}
	
	//M�todo ler registro leciona
	public void obterRegistro() {
		
		try {
			
			String sql = "SELECT * FROM leciona WHERE "
			
		}catch (Exception e) {
			System.out.println("[ERRO] Leciona (Obter Registro): "+e);
		}
		
	}
}
