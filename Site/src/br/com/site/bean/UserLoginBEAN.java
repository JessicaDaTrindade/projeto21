package br.com.site.bean;

public class UserLoginBEAN {
	
	//Atrib
	private String usuario, senha;
	private int cargo, codFunc;
	

	
	public int getCodFunc() {
		return codFunc;
	}

	public void setCodFunc(int codFunc) {
		this.codFunc = codFunc;
	}

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
