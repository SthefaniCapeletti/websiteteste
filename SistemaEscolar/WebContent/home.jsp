<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
if(session.getAttribute("objLogin") == null){
	response.sendRedirect("index.jsp");
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página Inicial</title>
</head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/datatables.min.css">

<style>
	.jumbotron{
		background-color: rgb(151, 201, 232) !important;
		color: white !important;	
	}
	
	.card{
		 box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)  !important;
	}
</style>
<body>

<jsp:useBean id="listprof" class="com.dao.ProfessorDao"></jsp:useBean>
<jsp:useBean id="listaturma" class="com.dao.TurmaDao"></jsp:useBean>
<jsp:useBean id="listaaluno" class="com.dao.AlunoDao"></jsp:useBean>


<div class="container">
	
	<a href="SEController?comando=sair">Sair</a>

	<div class="jumbotron jumbotron-fluid">
 		 <div class="container">
   			 <h1 class="display-4">WhiteBoard</h1>
    		<p class="lead">
    			<strong>Gerenciamento escolar</strong>
    		</p>
  		</div>
	</div>
	

	<div class="row mt-4">
		<div class="col col-lg-4 col-sm-12 mt-4">
			<input type="button" id="btn1" value="Cadastrar Professor" class="btn btn-outline-primary btn-block">
		 </div>
		<div class="col col-lg-4 col-sm-12 mt-4">
			<input type="button" id="btn3" value="Cadastrar Aluno" class="btn btn-outline-primary btn-block">
		 </div>
		<div class="col col-lg-4 col-sm-12 mt-4">	
			<input type="button" id="btn2" value="Cadastrar Turma" class="btn btn-outline-primary btn-block"> 
		</div>
	</div>	
	
	
	<br>
	
	<input type="hidden" id="msg" value="${param.msg }" >
	<div id="caixa-msg" role="alert">
		${param.msg }
	</div> 
	<br> <br>
	
	
	<br> <br>

	<div id="caixa1">
		
		<div class="card">
		
			<div class="card-body">
				<h3>Cadastrar professor <span class="badge badge-secondary card-title">+</span></h3>
				
				<form action="SEController" method="post" class="form-group">
			
					<div class="card-text">
					
						<strong>Nome:</strong> <br>
						<input type="text" name="nome"  required class="form-control">
					
						<br> 
						
						<strong>Sobrenome:</strong> <br>
						<input type="text" name="sobrenome" required class="form-control">
						
						<br> <br>
						
						<input type="submit" value="Cadastrar" class="btn btn-primary">
						<input type="hidden" name="comando" value="cadastrarProfessor">
					
						<br> <br>
						
						<table class="table table-hover" id="tabela2">
						
							<thead style="background-color:rgb(151, 201, 232) !important;">
								<tr>
									<th> ID </th>
									<th> Nome </th>
									<th> Sobrenome </th>
									<th> Ações </th>
								</tr>
							</thead>
							
							<tbody>
								
								<c:forEach var="prof" items="${listprof.professores }">
								
									<tr>
										
										<td>${prof.id_professor }</td>
										<td>${prof.nome }</td>
										<td>${prof.sobrenome }</td>
										<td>
											<a href="SEController?comando=pesquisarProfessorID&id=${prof.id_professor }">Alterar</a>
											<a onclick="return confirm('Deseja remover este professor?')" href="SEController?comando=deletarProfessor&id=${prof.id_professor }">Deletar</a>
										</td>
									</tr>
								
								</c:forEach>
								
							</tbody>
						
						</table>
						
					</div>
			
				</form>
			</div>
			
			
		
		</div>
	
			<hr class="my-4">
	</div>
	


	<div id="caixa2">
		
		<div class="card">
			
			<div class="card-body">
					<h3>Cadastrar turma <span class="badge badge-secondary card-title">+</span></h3>
					
						<form action="SEController" method="post" class="form-group">
		
						<div class="card-text">
								<strong>Número:</strong> <br>
							<select name="numero" required class="form-control">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
							</select>
							
								
							<br> <br>
							
							<strong>Letra:</strong><br>
							<select name="letra" id="letra" required class="form-control">
								<option value="A">A</option>
								<option value="B">B</option>
								<option value="C">C</option>
								<option value="D">D</option>
								<option value="E">E</option>
								<option value="F">F</option>
								<option value="G">G</option>
								<option value="H">H</option>
								<option value="I">I</option>
								<option value="J">J</option>
								<option value="K">K</option>
								<option value="L">L</option>
								<option value="M">M</option>
								<option value="N">N</option>
								<option value="O">O</option>
								<option value="P">P</option>
								<option value="Q">Q</option>
								<option value="R">R</option>
								<option value="S">S</option>
								<option value="T">T</option>
								<option value="U">U</option>
								<option value="V">V</option>
								<option value="W">W</option>
								<option value="X">X</option>
								<option value="Y">Y</option>
								<option value="Z">Z</option>
							</select>
			
				
							<br> <br>
							
							<strong>Escolha o professor:</strong> <br>
							<select name="idprof" required  class="form-control">
							
								<c:forEach var="prof" items="${listprof.professores }">
								
									<option value="${prof.id_professor }">${prof.id_professor } -  ${prof.nome } ${prof.sobrenome }</option>
							
								</c:forEach>
							
							</select>
						
							<br> <br>
							
							<input type="submit" value="Cadastrar" class="btn btn-primary">
							<input type="hidden" name="comando" value="cadastrarTurma">
							
							<br> <br>
							
							<table class="table table-hover" id="tabela3">
								<thead style="background-color:rgb(151, 201, 232) !important;">
									<tr>
										<th>ID</th>
										<th>Número</th>
										<th>Letra</th>
										<th>ID_Professor</th>
										<th>Ações</th>
									</tr>
								</thead>
								
								<tbody>
									
									<c:forEach var="turma" items="${listaturma.turmas }">
										
										<tr>
											
											<td>${turma.id_turma } </td>
											<td>${turma.numero } </td>
											<td>${turma.letra } </td>
											<td>${turma.id_professor }</td>
											<td>
												<a href="SEController?comando=pesquisarTurmaID&id=${turma.id_turma }">Alterar</a>
												<a href="SEController?comando=deletarTurma&id=${turma.id_turma }">Deletar</a>
											</td>
										</tr>
									
									</c:forEach>
									
								</tbody>
							</table>
							
					</div>
			
		
				</form>
			</div>
		
	
			
		
		
		</div>
		
		<hr class="my-4">
	</div>
	
	
	
	
	
	<div id="caixa3">
		
	
		<div class="card">
		<div class="card-body">
			<h3>Cadastrar aluno <span class="badge badge-secondary">+</span></h3>
			<div class="card-text"> 
					<form action="SEController" method="post" onsubmit="return validaNota()" class="form-group">
		
			<strong>RA:</strong> <br>
			<input type="text" id="ra" name="ra" required class="form-control"> 
			
			<br> <br>
			
			<strong>Nome:</strong> <br>
			<input type="text" name="nome" required class="form-control">
		
			<br> <br>
			
			<strong>Sobrenome:</strong> <br>
			<input type="text" name="sobrenome" required class="form-control">
			
			<br> <br>
			
			<strong>Nota Final:</strong> <br>
			<input type="text" name="notafinal" id="notafinal" required class="form-control">
			
			<br> <br>
			
			<strong>Turma:</strong> <br>
			<select name="idturma" class="form-control">
				
				<c:forEach var="turma" items="${listaturma.turmas }">
				
						
						<option value="${turma.id_turma }">${turma.numero }º ${turma.letra }  </option>
				
				
				</c:forEach>
			
			
			</select>
						
			<br> <br>
			
			<input type="submit" value="Cadastrar" class="btn btn-primary">
			<input type="hidden" name="comando" value="cadastrarAluno">
		
			</form>
			
			<br>
	
		<table id="tabela" class="table table-hover">
			<thead style="background-color:rgb(151, 201, 232) !important;">
				<tr>
					<th>RA</th>
					<th>Nome</th>
					<th>Sobrenome</th>
					<th>Nota</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="aluno" items="${listaaluno.alunos }">
					<tr>
						<td>${aluno.ra }</td>
						<td>${aluno.nome }</td>
						<td>${aluno.sobrenome }</td>
						<td>${aluno.nota_final }</td>
						<td> 
							<a href="SEController?comando=pesquisarAlunoRA&ra=${aluno.ra }">Alterar</a>
							<a href="SEController?comando=deletarAluno&ra=${aluno.ra }">Deletar</a>
						</td>
					</tr>
				</c:forEach>
		
			</tbody>
		</table>
			</div>
		</div>
	</div>
		
	
	</div>
	
</div>

<script src="js/jquery-3.3.1.slim.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-mask.js"></script>
<script src="js/datatables.min.js"></script>
<script>
	
	function validaNota(){
	
		var nota = parseFloat($("#notafinal").val());
		
		if(nota > 10 || nota < 0){
			alert("Digite uma nota valida (entre 0 e 10)");
			return false;
		}
		else{
			return true;
		}
	}


	
 	$(function(){
 		$("#caixa1").hide();
 		$("#caixa2").hide();
 		$("#caixa3").hide();
 		
 		$("#tabela").DataTable();
 		$("#tabela2").DataTable();
 		$("#tabela3").DataTable();
 		
 		$("#ra").mask("9999999-9");
 		
 		
 		$("#btn1").click(function(){
 			$("#caixa1").toggle();
 		})
 		$("#btn2").click(function(){
 			$("#caixa2").toggle();
 		})
 		$("#btn3").click(function(){
 			$("#caixa3").toggle();
 		})
 		
 		var msg = $("#msg").val();
 		
 		if(msg != ""){
 			$("#caixa-msg").addClass("alert alert-primary");
 		}
 		
 	})
 	
 	
</script>
</div>
</body>
</html>