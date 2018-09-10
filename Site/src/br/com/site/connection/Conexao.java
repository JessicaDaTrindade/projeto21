package br.com.site.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	
	//M�todo para retornar a conex�o
	public Connection obterConexao() {
		
		//Vari�vel contendo a conex�o
		Connection conectar = null;
		
		//Tentar obter a conex�o
		try {
			
			//Dados de acesso
			String url = "jdbc:mysql://localhost/projeto";
			String user = "root";
			String password = "";
			
			//Referenciar o driver de conex�o
			Class.forName("com.mysql.jdbc.Driver");
			
			//Obter a conex�o
			conectar = DriverManager.getConnection(url, user, password);
			
			//System.out.println("Conex�o ok");
		}catch(Exception e) {
			//System.out.println("Falha: "+e.getMessage());
		}
		
		//Retorno
		return conectar;
		
	}
	
}
