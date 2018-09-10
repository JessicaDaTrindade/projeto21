package br.com.site.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.site.bean.ColaboradorBEAN;
import br.com.site.connection.Conexao;

public class ColaboradorDAO {
	
	//Atributos contendo a conexão com o Banco de Dados
	Connection conexao;
	
	//Contrutor
	public ColaboradorDAO() {
		this.conexao = new Conexao().obterConexao();
	}
	
	//Método de cadastro
	public void cadastrarColaborador(ColaboradorBEAN obj) {
		
		//Tentar realizar o cadastro do aluno
		try {
			
			//SQL
			String sql = "INSERT INTO cadastrofuncionarios (nome, sobrenome, sexo, rg, cpf, dataNascimento, estadoCivil, cep, logradouro, numero, bairro, municipio, complemento, telefone, celular, email, idCargo, salario) VALUES "
													   + "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			//Preparar a conexão
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			//Parâmetros
			pstmt.setString(1, obj.getNome());
			pstmt.setString(2, obj.getSobrenome());
			pstmt.setString(3, obj.getSexo());
			pstmt.setString(4, obj.getRg());
			pstmt.setString(5, obj.getCpf());
			pstmt.setString(6, obj.getDataNascimento());
			pstmt.setString(7, obj.getEstadoCivil());		
			pstmt.setString(8, obj.getCep());
			pstmt.setString(9, obj.getLogradouro());
			pstmt.setString(10, obj.getNumero());
			pstmt.setString(11, obj.getBairro());
			pstmt.setString(12, obj.getMunicipio());
			pstmt.setString(13, obj.getComplemento());
			pstmt.setString(14, obj.getTelefone());
			pstmt.setString(15, obj.getCelular());
			pstmt.setString(16, obj.getEmail());
			pstmt.setString(17, obj.getIdCargo());
			pstmt.setString(18, obj.getSalario());
			
			//Executar comando
			pstmt.execute();
			
			}catch (Exception e) {
				System.out.println("Falha ao cadastrar "+e.getMessage());
			}
		
	}
	
	//Método para pegar as informações dos Colaboradores
	public String listarColaboradores() {
		
		//Estrutura
		String estrutura = "<table class='table table-striped tabela'>";
		estrutura += "<thead>";
		estrutura += "<tr>";
		estrutura += "<th class='celulaSelect'></th>";
		estrutura += "<th class='celulaNome'>Nome</th>";  
		estrutura += "<th class='celulaCargo'>Cargo</th>";
		estrutura += "</tr>";
		estrutura += "</thead>";
		
		//Obter os dados dos usuários
		try {
			
			//SQL
			String sql = "SELECT cadastrofuncinarios.nome, cadastrofuncinarios.sobrenome, cargos.nomeCargo FROM cadastrofuncinarios, cargos WHERE cargos.idCargo = cadastrofuncinarios.idCargo";
			
			
			//Comando para executar o SQL
			Statement stmt = conexao.createStatement();
			
			//Executar o comando e obter os dados
			ResultSet rs = stmt.executeQuery(sql);
			
			//Laço
			while(rs.next()) {
				estrutura += "<tr>";
				estrutura += "<td class='celulaSelect'> <input type='checkbox' class='checkSelect'></td>";	
				estrutura += "<td class='celulaColaborador'>"+rs.getString(1)+rs.getString(2)+"</td>";
				estrutura += "<td class='celulaColaborador'>"+rs.getString(3)+"</td>";
				estrutura += "</tr>";
			}
			
		}catch(Exception e) {
			System.out.println("Falha ao listar.");
		}
		
		//Finalizar a estrutura
		estrutura += "</table>";
		
		
		//Retorno
		return estrutura;
		
	}
	

}
