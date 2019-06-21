<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<title>Listado de Alumnos - UNPAZ</title>
	<meta charset="UTF-8">
	<meta name="description" content="Listado de alumnos de UNPAZ">
	<meta name="keywords" content="Alumnos, UNPAZ, Listado">
	<meta name="author" content="Rodrigo Fernández">
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
		
			<h1>Listado de alumnos</h1>
	
		<c:if test="${STATUS == 1}">
			<h3>Operacion finalizada correctamente</h3>
		</c:if>
		<c:if test="${STATUS == 0}">
			<h3>Error al realizar la operacion</h3>
		</c:if>
			
		<table>
			<tr>
				<th>Legajo</th>
				<th>DNI</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Genero</th>
				<th>Operaciones</th>
				<th>Finales</th>
			</tr>
			<c:forEach var="alumno" items="${ALUMNOS}">
			    <tr>
					<td>${alumno.getLegajo()}</td>
					<td>${alumno.getDni()}</td>
					<td>${alumno.getNombre()}</td>
					<td>${alumno.getApellido()}</td>
					<td>${alumno.getGenero()}</td>
					<td>
						<a href="./ModificacionAlumno?legajo=${alumno.getLegajo()}">Modificar</a>
						<input type="button" value="Eliminar" onclick="fborrar('./BajaAlumno?legajo=${alumno.getLegajo()}')">						
					</td>
					<td>
						<a href="./AltaFinal?legajo=${alumno.getLegajo()}">Agregar Final</a>
						<a href="./FinalesPorAlumno?alumno=${alumno.getLegajo()}">Ver Finales</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="/GestionFinalesWeb/AltaAlumnos">Nuevo alumno</a>
		<a href="/GestionFinalesWeb/">Volver</a>
	
	<footer>
			&copy; UNPAZ 2019
	</footer>
	
</body>

<script type="text/javascript">
	function fborrar(param)
	{
		var result = confirm("Advertencia: si borra este alumno tambien se borraran sus finales");
		if(result)
			window.location.href = param;
	}
</script>
</html>