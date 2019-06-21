<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Modificacion de Materia - UNPAZ</title>
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
	<h1>Modificacion de Materia</h1>
	<c:if test="${STATUS == 0}">
		<h3>Error al modificar materia</h3>
	</c:if>
	
	<form action="/GestionFinalesWeb/ModificacionMateria" method="post">
		<label for="">ID</label>
		<input type="number" name="id" required readonly value ="${MATERIA.getId()}">
		<br>
		<label for="">Descripcion</label>
		<input type="text" name="descripcion" required value="${MATERIA.getDescripcion()}">
		<br>
		<input type="submit" value="Modificar">
	</form>
	<a href="/GestionFinalesWeb/Materias">Volver</a>	
	<footer>
			&copy; UNPAZ 2019
	</footer>
</body>
</html>