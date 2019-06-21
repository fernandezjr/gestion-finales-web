<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificacion de Final - UNPAZ</title>
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
	<h1>Modificacion de Final</h1>
	
	<h3>Alumno: ${FINALES.getAlumno().getNombre()} ${FINALES.getAlumno().getApellido()}</h3>
	
	<c:if test="${STATUS == 0}">
						<h3>Error al modificar final</h3>
					</c:if>
	
	<form action="/GestionFinalesWeb/ModificacionFinal" method="post">
		<label for="">Materia:</label>
		<select name="materia" required>
			<option value="${FINALES.getMateria().getId()}" selected>${FINALES.getMateria().getDescripcion()}</option>
			<c:forEach var="materia" items="${MATERIAS}">				
					<c:if test="${materia.getId() != FINALES.getMateria().getId()}">
						<option value="${materia.getId()}">${materia.getDescripcion()}</option>
					</c:if>				
			</c:forEach>		
		</select>
		<br>
		<label for="">Nota:</label>
		<input type="number" name="nota" min="1" max="10" required="required" value="${FINALES.getNota()}">
		<br>
		<label for="">Fecha</label>
		<input type="text" name="fecha" required="required" value="${FINALES.getFecha().getFormato()}">
		<br>
		<input type="submit" value="Modificar"> 		
	</form>
	<a href="/GestionFinalesWeb/FinalesPorAlumno?alumno=${FINALES.getAlumno().getLegajo()}">Volver</a>
	<footer>
			&copy; UNPAZ 2019
	</footer>

</body>

</html>