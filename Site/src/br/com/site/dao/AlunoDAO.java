package br.com.site.dao;

//IMPORTATAR
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.com.site.bean.AlunoBEAN;
import br.com.site.connection.Conexao;

public class AlunoDAO {

	//Atributo contendo a conexão com o bd
	Connection conexao;
	
	//Construtor
	public AlunoDAO() {
		this.conexao = new Conexao().obterConexao();
	}
	
	//Método de cadastro
	public void cadastrarAluno(AlunoBEAN obj) {
		
		//Tentar realizar o cadastro do aluno
		try {
			
			//SQL
			String sql = "INSERT INTO cadastrosalunos ( nome, sobrenome, sexo, dataNascimento, estadoCivil, cpf, rg, cep, logradouro, numero,"
					+ "bairro, municipio, complemento, telefone,celular, nomeDaMae, nomeDoPai,"
					+ "responsavel, telResponsavel, celResponsavel, email) VALUES "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			//Preparar a conexão
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			//Parâmetros
			pstmt.setString(1, obj.getNome());
			pstmt.setString(2, obj.getSobrenome());
			pstmt.setString(3, obj.getSexo());
			pstmt.setString(4, obj.getDataNascimento());
			pstmt.setString(5, obj.getEstadoCivil());
			pstmt.setString(6, obj.getCpf());
			pstmt.setString(7, obj.getRg());
			pstmt.setString(8, obj.getCep());
			pstmt.setString(9, obj.getLogradouro());
			pstmt.setString(10, obj.getNumero());
			pstmt.setString(11, obj.getBairro());
			pstmt.setString(12, obj.getMunicipio());
			pstmt.setString(13, obj.getComplemento());
			pstmt.setString(14, obj.getTelefone());			
			pstmt.setString(15, obj.getCelular());
			pstmt.setString(16, obj.getNomeDaMae());
			pstmt.setString(17, obj.getNomeDoPai());
			pstmt.setString(18, obj.getResponsavel());
			pstmt.setString(19, obj.getTelResponsavel());
			pstmt.setString(20, obj.getCelResponsavel());
			pstmt.setString(21, obj.getEmail());
			
			
			//Executar comando
			pstmt.execute();
			
		}catch (Exception e) {
			System.out.println("Falha ao cadastrar "+e.getMessage());
		}
		
	}
	
	//Metodo para selecionar alunos
	public String listarAlunos() {
		
		//SQL
		String sql = "select * From cadastrosalunos";
		
		//Estrutura
		String estrutura = "<table class='table table-striped' id='tabela'>";
			
			//Cabeçalho da tabela
         	estrutura+= "<thead>";
         		estrutura+="<tr>";
         			estrutura+="<th class='lefth'>Número Matrícula</th>";
         			estrutura+=" <th class='right'>Nome</th>";
         		estrutura+="</tr>";
         	estrutura+="</thead>";
         	
         	
         	//Conteúdos da tabela
         	estrutura+="<tbody>";
         	
         	try {
         	Statement stmt = conexao.createStatement();
         	
         	ResultSet rs = stmt.executeQuery(sql);
         	
         	while(rs.next()) {
         	
         		estrutura+="<tr>";
         			estrutura+="<td class='tdLeft' >"+rs.getInt("idCadastro")+"</td>";
         			estrutura+="<td class='tdRight'>"+rs.getString("nome")+" "+rs.getString("sobrenome")+"</td>";
         			estrutura+="<td class='tdRight'>";
         			estrutura+="<a href='excluirAluno.jsp?codigo="+rs.getInt("idCadastro")+"'>";
         			estrutura+="<img src='img/delete.png'>";
         			estrutura+="</a>";
         			
         			estrutura+="</td>";
         			
         		estrutura+="</tr>";
         		
         	}
         	
         	}catch(Exception e) {
         		
         	}
         	
         	
         	//Término da tabela
         	estrutura += "</table>";
         	
         	//Retorno
         	return estrutura;
	}
	
	//Método para excluir 
	public void excluirAluno(int idCadastro) {
		
		//SQL
		String sql = "DELETE FROM cadastrosalunos WHERE idCadastro = ?";
		
		//Tenta realizar a exclusão
		try {
			
			//Preparar a exclusão
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idCadastro);
			
			
			//Executar comando
			pstmt.execute();
			
			//Finalizar conexão com o banco de dados
			pstmt.close();
			
			//Mensagem
			System.out.println("Excluído com sucesso!");
			
		}catch(Exception e) {
			System.out.println( "Falha ao excluir");
		}
		
	}
	
}
