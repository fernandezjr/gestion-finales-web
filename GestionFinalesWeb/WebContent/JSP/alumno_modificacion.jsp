<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Modificacion de Alumno - UNPAZ</title>
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
	<h1>Modificacion de Alumno</h1>
	<c:if test="${STATUS == 0}">
		<h3>Error al modificar alumno</h3>
	</c:if>
	
	<form action="/GestionFinalesWeb/ModificacionAlumno" method="post">
		<label for="">Legajo</label>
		<input type="number" name="legajo" required readonly value ="${ALUMNO.getLegajo()}">
		<br>
		<label for="">DNI</label>
		<input type="number" name="dni" required value="${ALUMNO.getDni()}">
		<br>
		<label for="">Nombre</label>
		<input type="text" name="nombre" required value="${ALUMNO.getNombre()}">
		<br>
		<label for="">Apellido</label>
		<input type="text" name="apellido" required value ="${ALUMNO.getApellido()}">
		<br>
		<label for="">Genero</label>
		<select name="genero" required>
			<option value="${ALUMNO.getGenero()}" selected>${ALUMNO.getGenero()}</option>
			<c:choose>
				<c:when test="${ALUMNO.getGenero().equals('Masculino')}">
					<option value="Femenino">Femenino</option>
				</c:when>
				<c:otherwise>
					<option value="Masculino">Masculino</option>
				</c:otherwise>
			</c:choose>
		</select>
		<br>
		<input type="submit" value="Modificar">
	</form>
	<a href="/GestionFinalesWeb/Alumnos">Volver</a>
	
<footer>
			&copy; UNPAZ 2019
	</footer>
</body>
</html>