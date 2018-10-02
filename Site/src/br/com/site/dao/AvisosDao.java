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

					try {
						// SQL
						String sql = "SELECT * FROM avisos"; 
						
						
						Statement stmt = conexao.createStatement();

						ResultSet rs = stmt.executeQuery(sql);
			
						
						while (rs.next()) {
							
							listarAvisos += rs.getString("avisos")+("   |   ")+System.getProperty("line.separator")+System.lineSeparator();
							 
						}
						

					} catch (Exception e) {
						System.out.println("Falha ao listar avisos: "+e);
					}

					return listarAvisos;
					
				}
				
				// Metodo para selecionar avisos
				public String tabelaAvisos() {

					

					// Estrutura
					String estrutura = "<table class='table table-striped' id='tabela' >";

					// Cabeçalho da tabelaa
					estrutura += "<thead>";
					estrutura += "<tr>";
					estrutura += " <th class='idAvisosCSS'>Código</th>";
					estrutura += " <th class='AvisosCSS'>Avisos</th>";
					estrutura += "<th class='Alterar'>Alterar</th>"; 
					estrutura += "<th class='Excluir'>Excluir</th>";
					estrutura += "</tr>";
					estrutura += "</thead>";

					// Conteúdos da tabela
					estrutura += "<tbody>";

					try {
						// SQL
						String sql = "SELECT * From avisos";
						Statement stmt = conexao.createStatement();

						ResultSet rs = stmt.executeQuery(sql);

						while (rs.next()) {

							estrutura += "<tr>";
							estrutura += "<td class='idAvisosCSS' >" + rs.getInt("idAvisos") + "</td>";
							estrutura += "<td class='AvisosCSS'>" + rs.getString("avisos") +"</td>";
							estrutura += "<td class='Alterar'><a href='#' data-toggle='modal' data-target='#modalAlterar" + rs.getString("idAvisos")+"'>";
							estrutura += "<span class='Alterar glyphicon glyphicon-pencil'></a></td>";
							estrutura += "<td class='Excluir'><a href='#' data-toggle='modal' data-target='#modalExcluir" + rs.getInt("idAvisos")+ "'>";
							estrutura += "<span class='Excluir glyphicon glyphicon-trash'></a></td>";
							estrutura += "</tr>";
							estrutura += modalAlterar(rs.getString("idAvisos"));
							estrutura += modalExcluir(rs.getString("idAvisos"));
						}

					} catch (Exception e) {

					}

					estrutura += "</tbody>";
					// Término da tabela
					estrutura += "</table>";

					// Retorno
					return estrutura;
				}
				
				// MÉTODO MODAL EXCLUIR AVISOS
				public String modalExcluir(String idAvisos) {

					String estruturaExcluir = "<div class='modal fade' id='modalExcluir" + idAvisos
							+ "' tabindex='-1' role='dialog'>";
					estruturaExcluir += "<div class='modal-dialog' role='document'>";
					estruturaExcluir += "<div class='modal-content'>";
					estruturaExcluir += "<div class='modal-header'>";
					estruturaExcluir += "<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>";
					estruturaExcluir += "<h4 class='modal-title'>Excluir Avisos</h4>";
					estruturaExcluir += "</div>";
					estruturaExcluir += "<div class='modal-body'>";
					estruturaExcluir += "<p>Deseja realmente excluir?</p>";
					estruturaExcluir += "</div>";
					estruturaExcluir += "<div class='modal-footer'>";
					estruturaExcluir += "<a class='btn btn-danger' href='acoes/excluirAvisos.jsp?idAvisos=" +idAvisos+ "'>Excluir</a>";
					estruturaExcluir += "<button type='button' class='btn btn-default' data-dismiss='modal'>Cancelar</button>";
					estruturaExcluir += "</div>";
					estruturaExcluir += "</div><!-- /.modal-content -->";
					estruturaExcluir += "</div><!-- /.modal-dialog -->";
					estruturaExcluir += "</div><!-- /.modal -->";

					return estruturaExcluir;
				}

				//M�TODO PARA EXCLUIR AVISOS
				public void excluirAvisos(int idAvisos) {
					
					//Tenta realizar a exclus�o
					try {
						
						//SQL
						String sql = "DELETE FROM avisos WHERE idAvisos = ?";
						
						//Prepara a conex�o
						PreparedStatement pstmt = conexao.prepareStatement(sql);
						
						//Par�metro
						pstmt.setInt(1, idAvisos);
						
						//Executa a a��o
						pstmt.execute();
						
						
					}catch(Exception e) {
						System.out.println("Falha ao excluir avisos.");
					}
				}
				
				// MÉTODO OBTER DADOS SELECIONADO ############################
				public AvisosBean dadosAvisos(String idAvisos) {

					AvisosBean obj = new AvisosBean();

					// Tenta realizar a exclusão
					try {

						// SQL
						String sql = "SELECT * FROM avisos WHERE idAvisos = ?";

						// Prepara a conexãoo
						PreparedStatement pstmt = conexao.prepareStatement(sql);

						// Parâmetro
						pstmt.setString(1, idAvisos);

						// Executa a ação
						ResultSet rs = pstmt.executeQuery();

						while (rs.next()) {
							obj.setIdAvisos(rs.getInt(1));
							obj.setAvisos(rs.getString(2));
							

						}

					} catch (Exception e) {
						System.out.println("Falha ao selecionar avisos " + e);
					}

					// Retorno
					return obj;

				}
				
				//M�TODO MODAL #########################################################
				public String modalAlterar(String idAvisos) {
					
					
					String estruturaAlterar = "<div class='modal fade' id='modalAlterar"+idAvisos+"' tabindex='-1' role='dialog'>";
					estruturaAlterar+="<div class='modal-dialog' role='document'>";
					estruturaAlterar+="<div class='modal-content'>";
					
					//IN�CIO FORMULARIO
					estruturaAlterar+="<form action='acoes/alterarAvisos.jsp'>";
					
					estruturaAlterar+="<div class='modal-header'>";
					estruturaAlterar+="<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>";
					estruturaAlterar+="<h4 class='modal-title'>Alterar Avisos</h4>";
					estruturaAlterar+="</div>";
					estruturaAlterar+="<div class='modal-body'>";
					estruturaAlterar+="<p>Dados do cadastro: </p>";
					
					//Instanciar objeto usu�rio
					AvisosBean avisos = new AvisosBean();
					avisos = new AvisosDao().dadosAvisos(idAvisos);
					
					
					//CAMPOS FORMUL�RIO
					estruturaAlterar+="<input type='hidden' name='idAvisos' id='idAvisos' value='"+avisos.getIdAvisos()+"'><br>";
					estruturaAlterar+="<input type='text' name='avisos' id='avisos' value='"+avisos.getAvisos()+"'><br>";	
					
					estruturaAlterar+="</div>";
					estruturaAlterar+="<div class='modal-footer'>";
					
					//BOT�O SALVAR FORMULARIO
					estruturaAlterar+="<input type='submit' class='btn btn-primary' value='Salvar'>";
					
					estruturaAlterar+="<button type='button' class='btn btn-default' data-dismiss='modal'>Cancelar</button>";
					estruturaAlterar+="</div>";
					
					//FIM FORMUL�RIO
					estruturaAlterar+="</form>";
					
					estruturaAlterar+="</div><!-- /.modal-content -->";
					estruturaAlterar+="</div><!-- /.modal-dialog -->";
					estruturaAlterar+="</div><!-- /.modal -->";
					
					return estruturaAlterar;
				}
				
				//M�TODO ALTERAR AVISOS
				public void alterarAvisos(AvisosBean obj) {
					
					//Tenta atualizar
					try {
						
						//SQL
						String sql = "UPDATE avisos SET avisos = ? WHERE idAvisos = ?";
						
						//Prepara a conex�o
						PreparedStatement pstmt = conexao.prepareStatement(sql);
						
						//Par�metros
						pstmt.setString(1, obj.getAvisos());
						pstmt.setInt(2, obj.getIdAvisos());
						
						//Executar
						pstmt.execute();
						System.out.println(obj.getIdAvisos());
						System.out.println(obj.getAvisos());
						
					}catch(Exception e) {
						System.out.println("Falha ao alterar");
					}
					
				}
		


		
}
