package br.com.site.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.site.bean.UserLoginBEAN;
import br.com.site.connection.Conexao;

public class UserLoginDAO {
	
	//Atributo contendo coex�o com BD
	Connection conexao;
	
	//Contrutor
	public UserLoginDAO() {
		this.conexao = new Conexao().obterConexao();
	}
	
	//M�todo Login
	public UserLoginBEAN login(String cpf, String senhaFuncionario) {
		
		//Objeto UserLoginBEAN
		UserLoginBEAN obj = new UserLoginBEAN();
		
		//Tenta obter os dados do BD
		try {
			
			//SQL
			String sql = "SELECT idCargo, cpf, senhaFuncionario, idCadastro FROM cadastroFuncionarios WHERE cpf = ? AND senhaFuncionario = ?";
			
			//Preparar conex�o
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			
			//Par�metros do SQL
			pstmt.setString(1, cpf);
			pstmt.setString(2, senhaFuncionario);
			
			//Armazenar os resultados do comando SQL
			ResultSet rs = pstmt.executeQuery();
			
			//Obter a �ltima linha
			rs.last();
			
			//Atributos do objeto UserLoginBEAN
			obj.setCargo(rs.getInt(1));
			obj.setUsuario(rs.getString(2));
			obj.setSenha(rs.getString(3));
			obj.setCodFunc(rs.getInt(4));
			
			
		}catch(Exception e) {
			System.out.println("Falha ao obter os dados.");

		}
		
		//Retorno
		return obj;
	}

}
