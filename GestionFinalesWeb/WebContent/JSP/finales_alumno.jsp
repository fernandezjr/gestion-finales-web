<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<title>Listado de Finales - UNPAZ</title>
	<meta charset="UTF-8">
	<meta name="description" content="Listado de finales de UNPAZ">
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
		<h1>Listado de Finales</h1>
		
		<h3>Alumno: ${ALUMNO.getNombre()} ${ALUMNO.getApellido()}</h3>
	
					<c:if test="${STATUS == 1}">
						<h3>Operacion finalizada exitosamente</h3>
					</c:if>
	
	
					<table>
					<thead>
						<tr>
							<th>Materia</th>
							<th>Nombre</th>
							<th>Apellido</th>
							<th>Nota</th>
							<th>Fecha</th>
							<th>Operaciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="finales" items="${FINALES}">
						    <tr>
								<td>${finales.getMateria().getDescripcion()}</td>
								<td>${finales.getAlumno().getNombre()}</td>
								<td>${finales.getAlumno().getApellido()}</td>
								<td>${finales.getNota()}</td>
								<td>${finales.getFecha().getFormato()}</td>
								<td>
									<a href="./ModificacionFinal?materia=${finales.getMateria().getId()}&alumno=${finales.getAlumno().getLegajo()}&fecha=${finales.getFecha().getFormato()}">Modificar</a>
									<input type="button" value="Eliminar" onclick="fborrar('./BajaFinal?materia=${finales.getMateria().getId()}&alumno=${finales.getAlumno().getLegajo()}&fecha=${finales.getFecha().getFormato()}')">
								</td>				
							</tr>
						</c:forEach>
					</tbody>
					</table>	
	
	
					<a href="/GestionFinalesWeb/Alumnos">Volver</a>
		<footer>
			&copy; UNPAZ 2019
		</footer>
</body>

<script type="text/javascript">
	function fborrar(param)
	{
		var result = confirm("¿Esta seguro que desea borrar el final seleccionado?");
		if(result)
			window.location.href = param;
	}
</script>
</html>