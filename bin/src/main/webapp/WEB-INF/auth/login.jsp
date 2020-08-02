<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--|===================================================|-->
<!--|== Inicio - Plantilla Log-In ======================|-->
<!--|===================================================|-->
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Page Title - SB Admin</title>
<link href="<c:out value='/css/styles.css' />" rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="bg-primary">
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-5">
							<div class="card shadow-lg border-0 rounded-lg mt-5">
								<!--|== Inicio - tÃ­tulo ==========================|-->
								<div class="card-header">
									<h3 class="text-center font-weight-light my-4">Ingreso al
										sistema</h3>
								</div>
								<!--|== Fin - tÃ­tulo    ==========================|-->
								<div class="card-body">
									<!--|== Inicio - Formulario ======================|-->

									<!--|== Inicio - Mensaje error ======================|-->
									<c:if test="${error}">
										<div class="alert alert-warning alert-dismissible fade show"
											role="alert">
											<strong>¡Error!</strong> credenciales inválidas
											<button type="button" class="close" data-dismiss="alert"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
									</c:if>

									<!--|== Fin - Mensaje error =========================|-->
									<form action="<c:url value='/login' />" method="post">

										<div class="form-group">
											<label class="small mb-1" for="inputEmailAddress">Correo</label>
											<input id="email" name="email" class="form-control py-4"
												id="inputEmailAddress" type="email"
												placeholder="Ingrese su correo" />
										</div>

										<div class="form-group">
											<label class="small mb-1" for="inputPassword">Contraseña</label>
											<input id="password" name="password"
												class="form-control py-4" id="inputPassword" type="password"
												placeholder="Ingrese su contraseña" />
										</div>

										<div
											class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
											<button class="btn btn-primary" type="submit">Ingresar</button>
										</div>
									</form>
									<!--|== Fin - Formulario ======================|-->
								</div>
								<!--|== Inicio - Enlace al registro ===============|-->
								<div class="card-footer text-center">
									<div class="small"></div>
								</div>
								<!--|== Fin - Enlace al registro ==================|-->
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
		<div id="layoutAuthentication_footer">
			<!--|== Inicio - piÃ© de pÃ¡gina =======|-->
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2020</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
					</div>
				</div>
			</footer>
			<!--|== Fin - piÃ© de pÃ¡gina ==========|-->
		</div>
	</div>
	<!--|== Inicio - javascript para bootstrap =======|-->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<!--|== Fin - javascript para bootstrap ===========|-->
	<script src="js/scripts.js"></script>
</body>
</html>
<!--|===================================================|-->
<!--|== Fin - Plantilla Log-In =========================|-->
<!--|===================================================|-->
