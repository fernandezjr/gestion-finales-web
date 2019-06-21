<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listado de Materias - UNPAZ</title>
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
		
		<h1>Listado de Materias</h1>
	
		<c:if test="${STATUS == 1}">
			<h3>Operacion finalizada correctamente</h3>
		</c:if>
				
		<table>
			<tr>
				<th>ID</th>
				<th>Descripcion</th>
				<th>Operaciones</th>				
			</tr>
			<c:forEach var="materia" items="${MATERIAS}">
			    <tr>
					<td><c:out value="${materia.getId()}" /></td>
					<td><c:out value="${materia.getDescripcion()}" /></td>
					<td>
						<a href="./ModificacionMateria?id=<c:out value="${materia.getId()}"/>">Modificar</a>
						<input type="button" value="Eliminar" onclick="fborrar('./BajaMateria?id=<c:out value="${materia.getId()}')"/>">
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<a href="/GestionFinalesWeb/AltaMateria">Nueva materia</a>
	
	<a href="/GestionFinalesWeb/">Volver</a>
	
	<footer>
			&copy; UNPAZ 2019
	</footer>
	</body>
	<script type="text/javascript">
	function fborrar(param)
	{
		var result = confirm("Advertencia: si borra esta materia tambien se borraran sus finales");
		if(result)
			window.location.href = param;
	}
	</script>
</html>