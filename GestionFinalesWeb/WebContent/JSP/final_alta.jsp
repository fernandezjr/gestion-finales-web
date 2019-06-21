
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta de Final - UNPAZ</title>
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

	<h1>Alta de Final</h1>
	
	<c:if test="${STATUS == 0}">
		<h3>Error al guardar final</h3>
	</c:if>
	
	<h3>Alumno: ${ALUMNO.getNombre()} ${ALUMNO.getApellido()}</h3>
	<c:forEach var="alumno" items="${ALUMNOS}">
		<h3>Alumno: "${alumno.getNombre}" + "${alumno.getApellido}"</h3>
	</c:forEach>
	
	<form action="/GestionFinalesWeb/AltaFinal" method="post">
		<label for="">Materia:</label>
		<select name="materia" required>
			<option selected disabled="disabled">Seleccione Materia</option>
			<c:forEach var="materia" items="${MATERIAS}">
				<option value="${materia.getId()}">${materia.getDescripcion()}</option>
			</c:forEach>		
		</select>
		<br>
		<label for="">Nota:</label>
		<input type="number" name="nota" min="1" max="10" required="required">
		<br>
		<label for="">Fecha</label>
		<input type="text" name="fecha" required="required" placeholder="dd/MM/yyyy">
		<br>
		<input type="submit" value="Agregar"> 
	</form>	
	<a href="/GestionFinalesWeb/Alumnos">Volver</a>
	
<footer>
			&copy; UNPAZ 2019
	</footer>

</body>

</html>