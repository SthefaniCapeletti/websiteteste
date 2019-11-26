package com.dao;

import java.sql.*;
import com.model.*;
import java.util.ArrayList;

public class UsuarioDao implements java.io.Serializable {

	public UsuarioDao() {
		
	}
	
	public Usuario logar(Usuario u) {
		
		Usuario logou = new Usuario();
		
		try {
			
			Connection con = Conecta.getConexao();
			
			String sql = "SELECT * FROM Usuario WHERE username=? AND senha=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getSenha());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				logou.setUsername(rs.getString("username"));
				logou.setSenha(rs.getString("senha"));
				logou.setValido(true);
			}
			else {
				logou.setValido(false);
			}
			
		}
		catch(Exception ex) {
			logou.setValido(false);
		}
		
		return logou;
		
		
	}
	
}
