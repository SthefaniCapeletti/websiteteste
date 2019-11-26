<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entrar</title>
<link rel="stylesheet" href="css/bootstrap.min.css">

<style>
	body{
		background-color: lightblue;
	}
	.card{
		box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19) !important;
	 
	}
	
	.form-control{
		width: 100% !important;
	}
	
	.card-img-top{
	 	margin: 0 auto;
		justify-content: center;
		text-align: center;
		align-content: center;
		width: 6rem !important;
		height: 6rem !important;
	}
</style>

</head>
<body>

<div class="container">

	
			<div class="blank-space">
				<br>
			</div>
		
			<div class="card mt-4 mx-auto" style="text-align:center; width: 50%">

				<img class="img img-fluid card-img-top mt-3" src="img/images2.png">
				<div class="card-body">
					
					<div class="card-title"><h3>Entrar</h3></div>
					
						<hr class="my-4">
						
						<div class="card-text">
								
								
							<form action="SEController" method="post" class="form-group">
				
								<input type="text" name="username" placeholder="Usuario..." class="form-control"> <br>
								
								<input type="password" name="senha" placeholder="Senha..." class="form-control"> <br>
								
								<input type="hidden" name="error" value="${msg }" id="error">
								<div id="alerta"  role="alert">${msg }</div>
								<br>
								
								<input type="submit" value="Entrar" class="btn btn-primary">
								<input type="hidden" name="comando" value="entrar">
				
				
							</form>
								
						</div>
					</div>
	
		</div>
		
	
	
	


</div>

<br>


<script src="js/jquery-3.3.1.slim.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script>

	$(function(){
		var msg = $("#error").val();
		
		if(msg != ""){
			$("#alerta").addClass("alert alert-primary");
		}
	})	
</script>

</body>
</html>