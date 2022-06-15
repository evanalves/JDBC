<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp"></jsp:include>

<body>
	<!-- Pre-loader start -->

	<jsp:include page="theme-loader.jsp"></jsp:include>

	<!-- Pre-loader end -->
	<div id="pcoded" class="pcoded">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">

			<jsp:include page="navbar.jsp"></jsp:include>

			<div class="pcoded-main-container">
				<div class="pcoded-wrapper">
					<jsp:include page="navbarmainmenu.jsp"></jsp:include>
					<div class="pcoded-content">

						<!-- Page-header start -->
						<jsp:include page="page-header.jsp"></jsp:include>
						<!-- Page-header end -->
						<div class="pcoded-inner-content">
							<!-- Main-body start -->
							<div class="main-body">


								<div class="page-wrapper">
									<!-- Page-body start -->
									<div class="page-body">



										<div class="row">
											<div class="col-sm-12">
												<!-- Basic Form Inputs card start -->
												<div class="card">

													<div class="card-block">
														<h4 class="sub-title">Cadastro de Usu�rio</h4>


														<form class="form-material"
															action="<%=request.getContextPath()%>/ServletUsuarioController"
															method="post" id="formUser">


														<input type="hidden" name="acao" id="acao" value="">


															<div class="form-group form-default form-static-label">
																<input type="text" name="id" id="id" class="form-control" readonly="readonly" value="${modelLogin.id}"> <span class="form-bar"></span> <label class="float-label">ID:</label>
															</div>
															<div class="form-group form-default form-static-label">
																<input type="text" name="nome" id="nome" maxlength="100" class="form-control" required="required" value="${modelLogin.nome}"> <span class="form-bar"></span> <label class="float-label">Nome:</label>
															</div>
															<div class="form-group form-default form-static-label">
																<input type="email" name="email" id="email" maxlength="50" class="form-control" required="required" autocomplete="off" value="${modelLogin.email}">
																<span class="form-bar"></span> <label class="float-label">E-mail:</label>
															</div>

															<div class="form-group form-default form-static-label">
																<input type="text" name="login" id="login" maxlength="50" class="form-control" required="required" autocomplete="off" value="${modelLogin.login}">
																<span class="form-bar"></span> <label class="float-label">Login:</label>
															</div>

															<div class="form-group form-default form-static-label">
																<input type="password" name="senha" id="senha" autocomplete="off" maxlength="24" class="form-control" required="required" value="${modelLogin.senha}">
																<span class="form-bar"></span> <label class="float-label">Senha:</label>
															</div>

															<button class="btn btn-primary waves-effect waves-light" onclick="limparForm()">Novo</button>
															<button class="btn btn-success waves-effect waves-light">Salvar</button>
															<button type="button" class="btn btn-info waves-effect waves-light" onclick="criaDeleteComAjax()">Excluir</button>
															<button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#exampleModalUsuario">Pesquisar</button>

														</form>

													</div>
												</div>
											</div>
										</div>
									</div>

									<span id="msg">${msg}</span>

									<!-- Page-body end -->
								</div>
								<div id="styleSelector"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Required Jquery -->
	<jsp:include page="javascriptfile.jsp"></jsp:include>
	
	<div class="modal fade" id="exampleModalUsuario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Pesquisa de usu�rio</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
      <!--<form>
      </form>
      -->
      
    <div class="input-group mb-3">
       	<input type="text" class="form-control" placeholder="Nome" aria-label="nome" id="nomeBusca" aria-describedby="basic-addon2">
  		<div class="input-group-append">
    <button class="btn btn-success" type="button" onclick="buscarUsuario()">Buscar</button>
    
  </div>
</div>
      <table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Nome</th>
      <th scope="col">Ver</th>
    </tr>
  </thead>
  <tbody>
   
  </tbody>
</table>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
      </div>
    </div>
  </div>
	
	
	

	<script type="text/javascript">
	
		function buscarUsuario(){
			
			var nomeBusca = document.getElementById('nomeBusca').value;
			
			if(nomeBusca != null && nomeBusca  != '' && nomeBusca.trim() != ''){ /*validando que tem que ter valor para buscar no banco de dados*/
				
			var urlAction = document.getElementById('formUser').action;	
				
				$.ajax({

					method : "get",
					url : urlAction,
					data : "nomeBusca=" + nomeBusca + '&acao=buscarUserAjax', 
					success : function(response) {
						
						alert(response);
						
						<!-- document.getElementById('msg').textContent = response; -->
	
					}

				}).fail(
						function(xhr, status, errorThrown) {
							alert('Erro ao Buscar usu�rio por nome: ' + xhr.responseText);

			    });
			}
		}
	
	
	
		function criaDeleteComAjax() {

			if (confirm('Deseja realmente Excluir so dados ?')) {
				var urlAction = document.getElementById('formUser').action;
				var idUser = document.getElementById('id').value;

				$.ajax({

					method : "get",
					url : urlAction,
					data : "id=" + idUser + '&acao=deletarajax',
					success : function(response) {
						limparForm();
						document.getElementById('msg').textContent = response;
					}

				}).fail(
						function(xhr, status, errorThrown) {
							alert('Erro ao deletar usu�rio com o id'
									+ xhr.responseText);

						});

			}

		}

		function criarDelete() {

			if (confirm('Deseja Realmente Excluir os dados ?')) {

				document.getElementById("formUser").method = 'get';
				document.getElementById("acao").value = 'deletar';
				document.getElementById("formUser").submit();

			}

		}

		function limparForm() {

			//document.getElementById("formUser").reset();

			var elements = document.getElementById("formUser").elements;/*retorna os elementos HTML dentro do fomr*/
			for (p = 0; p < elements.length; p++) {
				elements[p].value = '';

			}
		}
	</script>
</body>

</html>





