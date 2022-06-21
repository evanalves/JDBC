<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Página em JSP</title>

<style type="text/css">
form {
	position: absolute;
	top: 40%;
	left: 33%;
	right: 33$%
}

h5 {
	position: absolute;
	top: 30%;
	left: 33%;
}

.msg {
	position: top;
	top: 10%;
	left: 33%;
	font-size: 15px;
	color: red;
	color: #664d03;
	background-color: #fff3cd;
	border-color: #ffecb5;
}
</style>


</head>

<body>

	<h5>Bem vindo faça seu Login</h5>


	<form action="<%=request.getContextPath()%>/ServletLogin" method="post"
		class="row g-3  needs-validation" novalidate>
		<input type="hidden" value="<%=request.getParameter("url")%>"
			name="url">

		<div class="col-mb-3">
			<label class="form-label" for="login">Login</label> <input
				class="form-control" name="login" type="text" required="required">
			<div class="invalid-feedback">preencha seu login</div>
			<div class="valid-feedback">Ok!</div>
		</div>

		<div class="col-mb-3">
			<label class="form-label" for="senha">Senha</label> <input
				class="form-control" name="senha" type="password"
				required="required">

			<div class="invalid-feedback">preencha sua senha</div>
			<div class="valid-feedback">Ok!</div>
		</div>


		<input class="btn btn-primary" type="submit" value="Acessar">


	</form>

	<h5 class="msg">${msg}</h5>
	
	<script>
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>


	<script type="text/javascript">
		//Example starter JavaScript for disabling form submissions if there are invalid fields
		(function() {
			'use strict'

			var forms = document.querySelectorAll('.needs-validation')

			Array.prototype.slice.call(forms).forEach(function(form) {
				form.addEventListener('submit', function(event) {
					if (!form.checkValidity()) {
						event.preventDefault()
						event.stopPropagation()
					}

					form.classList.add('was-validated')
				}, false)
			})
		})()
	</script>


</body>

</html>