package br.com.site.dao;

//IMPORTATAR
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.site.bean.AvisosBean;
import br.com.site.connection.Conexao;


public class AvisosDao {

	// Atributo contendo a conex�o com o bd
	Connection conexao;

 //Construtor
	public AvisosDao() {
		this.conexao = new Conexao().obterConexao();
	}
	
	// M�todo de cadastro
		public void cadastrarAvisos(AvisosBean obj) {
			
			
			

			// Tentar realizar o cadastro do aviso
			try {

				// SQL
				String sql = "INSERT INTO avisos VALUES (null, ?)";

				// Preparar a conex�o
				PreparedStatement pstmt = conexao.prepareStatement(sql);

				// Par�metros
				pstmt.setString(1, obj.getAvisos());
			
				// Executar comando
				pstmt.execute();
			
		} catch (Exception e) {
			System.out.println("Falha ao listar avisos: "+e);
		
			}
		}
		
		
		// Metodo para listar avisos
		public String listarAvisos() {
			
			String listarAvisos="";

			// SQL
			
			
			
			try {
				String sql = "SELECT * FROM avisos"; 
				
				
				Statement stmt = conexao.createStatement();

				ResultSet rs = stmt.executeQuery(sql);
	
				
				while (rs.next()) {
					
					listarAvisos += rs.getString("avisos")+System.getProperty("line.separator")+System.lineSeparator();
					 
				}
				

			} catch (Exception e) {
				System.out.println("Falha ao listar avisos: "+e);
			}

			return listarAvisos;
			
		}

}
