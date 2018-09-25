package br.com.site.dao;

//IMPORTATAR
import java.sql.Connection;
import java.sql.PreparedStatement;
import br.com.site.bean.AvisosBean;
import br.com.site.connection.Conexao;

public class AvisosDao {

	// Atributo contendo a conexão com o bd
	Connection conexao;

 //Construtor
	public AvisosDao() {
		this.conexao = new Conexao().obterConexao();
	}
	
	// Método de cadastro
		public void cadastrarAvisos(AvisosBean obj) {

			// Tentar realizar o cadastro do aluno
			try {

				// SQL
				String sql = "INSERT INTO avisos VALUES (null, ?)";

				// Preparar a conexão
				PreparedStatement pstmt = conexao.prepareStatement(sql);

				// Parâmetros
				pstmt.setString(1, obj.getAvisos());
			
				// Executar comando
				pstmt.execute();

		} catch (Exception e) {
			System.out.println("Falha ao cadastrar aviso" + e.getMessage());
		
			}
		}
		
}