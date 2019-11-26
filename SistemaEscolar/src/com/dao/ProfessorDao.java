package com.dao;

import java.sql.*;
import java.util.ArrayList;

import com.model.*;

public class ProfessorDao implements java.io.Serializable {
	
	public ProfessorDao() {
		
	}
	
	public boolean inserir(Professor p) {
		
		try {
			
			Connection con = Conecta.getConexao();
			
			String sql = "INSERT INTO Professor(nome,sobrenomve) VALUES(?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getSobrenome());
			
			ps.execute();
			ps.close();
			con.close();
			
			return true;
			
		}
		catch(Exception ex) {
			return false;
		}
		
	}
	
	public boolean alterar(Professor p) {
		
		try {
			
			Connection con = Conecta.getConexao();
			
			String sql = "UPDATE Professor SET nome = ?, sobrenomve = ? WHERE id_professor = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getSobrenome());
			ps.setInt(3, p.getId_professor());
			
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
			
			String sql = "DELETE FROM Professor WHERE id_professor = ?";
			
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
	
	public Professor pesquisarId(int id) {
		
		Professor professor = new Professor();
		
		try {
			
			Connection con = Conecta.getConexao();
			
			String sql = "SELECT * FROM Professor WHERE id_professor = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				professor.setId_professor(rs.getInt("id_professor"));
				professor.setNome(rs.getString("nome"));
				professor.setSobrenome(rs.getString("sobrenomve"));
			}
			else {
				professor = null;
			}
			
			rs.close();
			ps.close();
			con.close();
			
		}
		catch(Exception ex) {
			professor = null;
		}
		
		return professor;
		
	}
	
	public ArrayList<Professor> getProfessores(){
		
		ArrayList<Professor> lista = new ArrayList<Professor>();
		
		try {
			
			Connection con = Conecta.getConexao();
			
			String sql = "SELECT * FROM Professor";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Professor p = new Professor();
				p.setId_professor(rs.getInt("id_professor"));
				p.setNome(rs.getString("nome"));
				p.setSobrenome(rs.getString("sobrenomve"));
				
				lista.add(p);
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
	
	public ArrayList<Professor> getProfessoresNome(String nome){
		
		ArrayList<Professor> lista = new ArrayList<Professor>();
		
		try {
			
			Connection con = Conecta.getConexao();
			
			String sql = "SELECT * FROM Professor WHERE nome LIKE ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			String nomeC = "%"+nome+"%";
			ps.setString(1, nomeC);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Professor p = new Professor();
				p.setId_professor(rs.getInt("id_professor"));
				p.setNome(rs.getString("nome"));
				p.setSobrenome(rs.getString("sobrenomve"));
				
				lista.add(p);
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
