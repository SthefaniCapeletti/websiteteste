package com.dao;

import java.sql.*;
import com.model.*;
import java.util.ArrayList;

public class AlunoDao implements java.io.Serializable{

	public AlunoDao() {
		
	}
	
	public boolean inserir(Aluno a) {
		
		try {
			
			Connection con = Conecta.getConexao();
			
			String sql = "INSERT INTO Aluno(ra,nome,sobrenome,nota_final,id_turma) VALUES(?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getRa());
			ps.setString(2, a.getNome());
			ps.setString(3, a.getSobrenome());
			ps.setFloat(4, a.getNota_final());
			ps.setInt(5, a.getId_turma());
			
			ps.execute();
			ps.close();
			con.close();
			
			return true;
			
		}
		catch(Exception ex) {
			return false;
		}
		
		
	}
	
	public boolean alterar(Aluno a) {
		
		try {
			
			Connection con = Conecta.getConexao();
			
			String sql = "UPDATE Aluno SET nome=?, sobrenome=?, nota_final=?, id_turma=? WHERE ra=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getNome());
			ps.setString(2, a.getSobrenome());
			ps.setFloat(3, a.getNota_final());
			ps.setInt(4, a.getId_turma());
			ps.setString(5, a.getRa());
			
			ps.execute();
			ps.close();
			con.close();
			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
		
	}
	
	public boolean deletar(String ra) {
		
		try {
			
			Connection con = Conecta.getConexao();
			
			String sql = "DELETE FROM Aluno WHERE ra = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ra);
			
			ps.execute();
			ps.close();
			con.close();
			
			return true;
			
			
		}
		catch(Exception ex) {
			return false;
		}
		
		
	}
	
	public Aluno pesquisarRa(String ra) {
		
		Aluno a = new Aluno();
		
		try {
			
			Connection con = Conecta.getConexao();
			
			String sql = "SELECT * FROM Aluno WHERE ra = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ra);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				a.setRa(rs.getString("ra"));
				a.setNome(rs.getString("nome"));
				a.setSobrenome(rs.getString("sobrenome"));
				a.setNota_final(rs.getFloat("nota_final"));
				a.setId_turma(rs.getInt("id_turma"));
			}
			
			rs.close();
			ps.close();
			con.close();
			
		}
		catch(Exception ex) {
			a = null;
		}
		
		return a;
	}
	
	public ArrayList<Aluno> getAlunos(){
		
		ArrayList<Aluno> lista = new ArrayList<Aluno>();
		
		try {
			
			Connection con = Conecta.getConexao();
			
			String sql = "SELECT * FROM Aluno";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Aluno a = new Aluno();
				a.setRa(rs.getString("ra"));
				a.setNome(rs.getString("nome"));
				a.setSobrenome(rs.getString("sobrenome"));
				a.setNota_final(rs.getFloat("nota_final"));
				a.setId_turma(rs.getInt("id_turma"));
				
				lista.add(a);
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
	
	public ArrayList<Aluno> getAlunosNome(String nome){
		
		ArrayList<Aluno> lista = new ArrayList<Aluno>();
		
		try {
			
			Connection con = Conecta.getConexao();
			
			String sql = "SELECT * FROM Aluno WHERE nome LIKE ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			String nomeC = "%"+nome+"%";
			ps.setString(1, nomeC);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Aluno a = new Aluno();
				a.setRa(rs.getString("ra"));
				a.setNome(rs.getString("nome"));
				a.setSobrenome(rs.getString("sobrenome"));
				a.setNota_final(rs.getFloat("nota_final"));
				a.setId_turma(rs.getInt("id_turma"));
				
				lista.add(a);
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
