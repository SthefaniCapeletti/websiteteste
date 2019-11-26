<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	if(session.getAttribute("objLogin") == null){
		response.sendRedirect("index.jsp");
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/datatables.min.css">
</head>
<body>

<div class="container">

	<div class="card mt-4">
	
		<div class="card-body">
		
			<div class="card-title"><h3>Alterar dados do professor ${obj.nome } ${obj.sobrenome }</h3></div>
		
			<div class="card-text">
			
				<form action="SEController" class="form-group">
					
					<strong>ID:</strong> <br>
					<input type="text" value="${obj.id_professor }" disabled class="form-control"> 
					<input type="hidden" name="id" value="${obj.id_professor }">
					
					<br>
					
					<strong>Nome:</strong> <br>
					<input type="text" name="nome" value="${obj.nome }" class="form-control">
				
					<br>
					
					<strong>Sobrenome: </strong> <br>
					<input type="text" name="sobrenome" value="${obj.sobrenome }" class="form-control">
					
					<br> <br>
					
					<input type="submit" value="Alterar" class="btn btn-primary">
					<input type="hidden" name="comando" value="alterarProfessor">
				
				</form>
			
			</div>
			
		</div>
	
	
	</div>

</div>



<script src="js/jquery-3.3.1.slim.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-mask.js"></script>
<script src="datatables.min.js"></script>
</body>
</html>