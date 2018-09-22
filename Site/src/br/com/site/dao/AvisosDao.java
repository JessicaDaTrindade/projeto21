package br.com.site.dao;


//IMPORTATAR
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import br.com.site.bean.AlunoBEAN;
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

			// Tentar realizar o cadastro do aluno
			try {

				// SQL
				String sql = "INSERT INTO avisos (avisos) VALUES "+"( ?,)";

				// Preparar a conex�o
				PreparedStatement pstmt = conexao.prepareStatement(sql);

				// Par�metros
				pstmt.setString(1, obj.getAvisos());
			
			// Executar comando
			pstmt.execute();
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("Falha ao cadastrar " + e.getMessage());
		
			}
		}
		
}