package com.dao;

import java.sql.*;
import com.model.*;
import java.util.ArrayList;

public class TurmaDao implements java.io.Serializable {

	public TurmaDao() {
		
	}
	
	public boolean inserir(Turma t) {
		
		try {
			
			Connection con = Conecta.getConexao();
			
			String sql = "INSERT INTO Turma(numero,letra,id_professor) VALUES(?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, t.getNumero());
			ps.setString(2, t.getLetra());
			ps.setInt(3, t.getId_professor());
			
			ps.execute();
			ps.close();
			con.close();
			
			return true;
			
		}
		catch(Exception ex) {
			return false;
		}
		
	}
	
	public boolean alterar(Turma t) {
		
		try {
			
			Connection con = Conecta.getConexao();
			
			String sql = "UPDATE Turma SET id_professor = ? WHERE id_turma = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, t.getId_professor());
			ps.setInt(2, t.getId_turma());
			
			ps.execute();
			ps.close();
			con.close();
			
			return true;
			
		}
		catch(Exception ex) {
			return false;
		}
		
	}
	
	public boolean deletar(int id) {
		
		try {
			
			Connection con = Conecta.getConexao();
			
			String sql = "DELETE FROM Turma WHERE id_turma = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.execute();
			ps.close();
			con.close();
			
			return true;
			
		}
		catch(Exception ex) {
			return false;
		}
		
	}
	
	public Turma pesquisarId(int id) {
		
		Turma t = new Turma();
		
		try {
		
			Connection con = Conecta.getConexao();
			
			String sql = "SELECT * FROM Turma WHERE id_turma = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				t.setId_turma(rs.getInt("id_turma"));
				t.setNumero(rs.getInt("numero"));
				t.setLetra(rs.getString("letra"));
				t.setId_professor(rs.getInt("id_professor"));
			}
			else {
				t = null;
			}
			
			rs.close();
			ps.close();
			con.close();
			
		}
		catch(Exception ex) {
			t = null;
		}
		
		return t;
	}
	
	public ArrayList<Turma> getTurmas(){
		
		ArrayList<Turma> lista = new ArrayList<Turma>();
		
		try {
			
			Connection con = Conecta.getConexao();
			
			String sql = "SELECT * FROM Turma";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Turma t = new Turma();
				t.setId_turma(rs.getInt("id_turma"));
				t.setNumero(rs.getInt("numero"));
				t.setLetra(rs.getString("letra"));
				t.setId_professor(rs.getInt("id_professor"));
				
				lista.add(t);
			}
			rs.close();
			ps.close();
			con.close();
		}
		catch(Exception ex) {
			lista = null;
		}
		return lista;
	}
	
	public ArrayList<Turma> getTurmasNumero(int id){
		
		ArrayList<Turma> lista = new ArrayList<Turma>();
		
		try {
			
			Connection con = Conecta.getConexao();
			
			String sql = "SELECT * FROM Turma WHERE id_turma = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Turma t = new Turma();
				t.setId_turma(rs.getInt("id_turma"));
				t.setNumero(rs.getInt("numero"));
				t.setLetra(rs.getString("letra"));
				t.setId_professor(rs.getInt("id_professor"));
				
				lista.add(t);
			}
			
			rs.close();
			ps.close();
			con.close();
			
		}
		catch(Exception ex) {
			lista = null;
		}
		return lista;
	}
	
	
}
