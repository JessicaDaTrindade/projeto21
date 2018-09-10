package br.com.site.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	
	//Método para retornar a conexão
	public Connection obterConexao() {
		
		//Variável contendo a conexão
		Connection conectar = null;
		
		//Tentar obter a conexão
		try {
			
			//Dados de acesso
			String url = "jdbc:mysql://localhost/projeto";
			String user = "root";
			String password = "";
			
			//Referenciar o driver de conexão
			Class.forName("com.mysql.jdbc.Driver");
			
			//Obter a conexão
			conectar = DriverManager.getConnection(url, user, password);
			
			//System.out.println("Conexão ok");
		}catch(Exception e) {
			//System.out.println("Falha: "+e.getMessage());
		}
		
		//Retorno
		return conectar;
		
	}
	
}
