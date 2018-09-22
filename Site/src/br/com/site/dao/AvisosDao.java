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
				String sql = "INSERT INTO avisos (avisos) VALUES "+"( ?,)";

				// Preparar a conexão
				PreparedStatement pstmt = conexao.prepareStatement(sql);

				// Parâmetros
				pstmt.setString(1, obj.getAvisos());
			
			// Executar comando
			pstmt.execute();
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("Falha ao cadastrar " + e.getMessage());
		
			}
		}
		
}