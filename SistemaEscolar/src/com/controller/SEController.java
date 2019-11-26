package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.*;
import com.model.*;
/**
 * Servlet implementation class SEController
 */
@WebServlet("/SEController")
public class SEController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 AlunoDao aD = new AlunoDao();
	 ProfessorDao pD = new ProfessorDao();
	 TurmaDao tD = new TurmaDao();
	 UsuarioDao uD = new UsuarioDao();
	 
	 String msg = "";
	 String url = "";
  
    public SEController() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String comando = request.getParameter("comando");
		
		try {
			
			switch(comando) {
			case "cadastrarProfessor":
				cadastrarProfessor(request,response);
				break;
			case "alterarProfessor":
				alterarProfessor(request,response);
				break;
			case "deletarProfessor":
				deletarProfessor(request,response);
				break;
			case "pesquisarProfessorID":
				pesquisarProfessorID(request,response);
				break;
			case "listarProfessores":
				listarProfessores(request,response);
				break;
			case "cadastrarTurma":
				cadastrarTurma(request,response);
				break;
			case "alterarTurma":
				alterarTurma(request,response);
				break;
			case "deletarTurma":
				deletarTurma(request,response);
				break;
			case "pesquisarTurmaID":
				pesquisarTurmaID(request,response);
				break;
			case "listarTurmas":
				listarTurmas(request,response);
				break;
			case "cadastrarAluno":
				cadastrarAluno(request,response);
				break;
			case "alterarAluno":
				alterarAluno(request,response);
				break;
			case "deletarAluno":
				deletarAluno(request,response);
				break;
			case "pesquisarAlunoRA":
				pesquisarAlunoRA(request,response);
				break;
			case "listarAlunos":
				listarAlunos(request,response);
				break;
			case "entrar":
				entrar(request,response);
				break;
			case "sair":
				sair(request,response);
				break;
			}
			
			
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
		}
		
	}

	private void sair(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			
			HttpSession session = request.getSession(true);
			session.removeAttribute("objLogin");
			session.invalidate();
			
			url = "index.jsp";
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
		}
		
		RequestDispatcher rq = request.getRequestDispatcher(url);
		rq.forward(request, response);
		
	}

	private void entrar(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		Usuario u = new Usuario();
		
		try {
			
			u.setUsername(request.getParameter("username"));
			u.setSenha(request.getParameter("senha"));
			
			u = uD.logar(u);
			
			if(u.isValido()) {
				HttpSession sessao = request.getSession(true);
				sessao.setAttribute("objLogin", u);
				url = "home.jsp";
				msg = "Olá, " + u.getUsername();
			}
			else {
				HttpSession sessao = request.getSession(true);
				sessao.removeAttribute("objLogin");
				sessao.invalidate();
				url = "index.jsp";
				msg = "Falha na autenticação: usuário/senha inválida";
			}
			
			request.setAttribute("msg", msg);
			
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
			url = "index.jsp";
		}
		
		RequestDispatcher rq = request.getRequestDispatcher(url);
		rq.forward(request, response);
	}

	private void listarAlunos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
	}

	private void listarTurmas(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
	}

	private void listarProfessores(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
	}

	private void pesquisarAlunoRA(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
	}

	private void pesquisarTurmaID(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			
			Turma t = tD.pesquisarId(Integer.parseInt(request.getParameter("id")));
			
			if(t != null) {
				request.setAttribute("obj", t);
				url = "alterarTurma.jsp";
			}
			else {
				url = "home.jsp";
			}
			
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
		}
		
		RequestDispatcher rq = request.getRequestDispatcher(url);
		rq.forward(request, response);
	}

	private void pesquisarProfessorID(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		try {
			
			Professor p = pD.pesquisarId(Integer.parseInt(request.getParameter("id")));
			
			if(p != null) {
				request.setAttribute("obj", p);
				url = "alterarProf.jsp";
			}
			else {
				msg = "Não foi possivel encontrar este professor";
				url = "home.jsp";
				request.setAttribute("msg", msg);
			}
			
			
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
		}
		
		RequestDispatcher rq = request.getRequestDispatcher(url);
		rq.forward(request, response);
		
	}

	private void deletarAluno(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		
	}

	private void deletarTurma(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
	}

	private void deletarProfessor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			
			if(pD.deletar(Integer.parseInt(request.getParameter("id")))) {
				msg = "Professor deletado com sucesso!";
			}
			else {
				msg = "Falha ao deletar professor: o mesmo está vinculado a uma turma";
			}
			
			url = "home.jsp?msg="+msg;
			
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
		}
		
		response.sendRedirect(url);
	}

	private void alterarAluno(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		
	}

	private void alterarTurma(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
	}

	private void alterarProfessor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Professor p = new Professor();
		
		try {
			p.setId_professor(Integer.parseInt(request.getParameter("id")));
			p.setNome(request.getParameter("nome"));
			p.setSobrenome(request.getParameter("sobrenome"));
			
			if(pD.alterar(p)) {
				msg = "Professor alterado com sucesso!";
			}
			else {
				msg = "Falha ao alterar professor";
			}
			
			url = "home.jsp?msg="+msg;
			
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
		}
		
		response.sendRedirect(url);
	}

	private void cadastrarAluno(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Aluno a = new Aluno();
		
		try {
			
			a.setRa(request.getParameter("ra"));
			a.setNome(request.getParameter("nome"));
			a.setSobrenome(request.getParameter("sobrenome"));
			a.setNota_final(Float.parseFloat(request.getParameter("notafinal")));
			a.setId_turma(Integer.parseInt(request.getParameter("idturma")));
			
			if(aD.inserir(a)) {
				msg = "Aluno cadastrado";
			}
			else {
				msg = "Aluno não cadastrado";
			}
			
			url = "home.jsp?msg="+msg;
			
			request.setAttribute("msg", msg);
			
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
		}
		
		response.sendRedirect(url);
		//PARA EVITAR DUPLACATAS, N USAR:
		//RequestDispatcher rq = request.getRequestDispatcher(url);
		//rq.forward(request, response);
	}

	private void cadastrarTurma(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Turma t = new Turma();
		
		try {
			
			t.setNumero(Integer.parseInt(request.getParameter("numero")));
			String letra = request.getParameter("letra");
			letra = letra.toUpperCase();
			t.setLetra(letra);
			t.setId_professor(Integer.parseInt(request.getParameter("idprof")));
			
			if(tD.inserir(t)) {
				msg = "Turma cadastrada";
			}
			else {
				msg = "Turma não cadastrada!";
			}
			
			request.setAttribute("msg", msg);
			url = "home.jsp?msg="+msg;
			
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
		}
		
		response.sendRedirect(url);
		
		//PARA EVITAR DUPLACATAS, N USAR:
		//RequestDispatcher rq = request.getRequestDispatcher(url);
		//rq.forward(request, response);
		
	}

	private void cadastrarProfessor(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		Professor p = new Professor();
		
		try {
			
			p.setNome(request.getParameter("nome"));
			p.setSobrenome(request.getParameter("sobrenome"));
			
			if(pD.inserir(p)) {
				msg = "Professor cadastrado com sucesso!";
			}
			else {
				msg = "Professor não cadastrado!";
			}
			url = "home.jsp?msg="+msg;
			
			request.setAttribute("msg", msg);
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
		}
		
		response.sendRedirect(url);
		
		//PARA EVITAR DUPLACATAS, N USAR:
		//RequestDispatcher rq = request.getRequestDispatcher(url);
		//rq.forward(request, response);
		
	}

}
