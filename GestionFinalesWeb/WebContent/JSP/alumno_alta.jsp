<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Alta de Alumno - UNPAZ</title>
	<meta charset="UTF-8">
	<meta name="description" content="Listado de alumnos de UNPAZ">
	<meta name="keywords" content="Alumnos,UNPAZ,Listado">
	<meta name="author" content="Practica Integradora Team">
	<link href="./CSS/estilos.css" rel="stylesheet"/>
</head>
<body>
	<header>
			<p>UNPAZ</p>
		</header>
		<nav id="botonera_principal"> 
			<ul>
				<li><a href="/GestionFinalesWeb/">Inicio</a></li>
				<li><a href="./Alumnos">Alumnos</a></li>
				<li><a href="./Materias">Materias</a></li>
				<li><a href="./Finales">Finales</a></li>
			</ul>
			
		</nav>
	<h1>Alta de Alumno</h1>
	
	<c:if test="${STATUS == 0}">
		<h3>Error al guardar alumno</h3>
	</c:if>
	
	<form action="/GestionFinalesWeb/AltaAlumnos" method="post">
		<label for="">DNI</label>
		<input type="number" name="dni" required>
		<br>
		<label for="">Nombre</label>
		<input type="text" name="nombre" required>
		<br>
		<label for="">Apellido</label>
		<input type="text" name="apellido" required>
		<br>
		<label for="">Genero</label>
		<select name="genero" required>
			<option selected disabled="disabled">Seleccione Genero</option>
			<option value="Masculino">Masculino</option>
			<option value="Femenino">Femenino</option>
		</select>
		<br>
		<input type="submit" value="Enviar">
	</form>
	<a href="/GestionFinalesWeb/Alumnos">Volver</a>
	<footer>
			&copy; UNPAZ 2019
	</footer>
</body>
</html>