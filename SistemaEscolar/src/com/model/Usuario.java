package com.model;

public class Usuario {
	
	private String username;
	private String senha;
	public boolean valido;
	
	public void setValido(boolean valido) {
		this.valido = valido;
	}
	
	public boolean isValido() {
		return valido;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}
