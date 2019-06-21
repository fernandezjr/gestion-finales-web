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
	<script type="text/javascript" src="./js/cargar_tabla.js"></script>
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
		<div id="contenido">
		<h1>Listado de Finales</h1>
		
		<c:if test="${STATUS == 1}">
			<h3>Operacion finalizada exitosamente</h3>
		</c:if>
	
					<label for="">Filtrar por Materia:</label>
					<select name="materias" onchange="loadFinales(this.options[this.selectedIndex].value)" 
							id="comboMaterias">
						<option selected value="0">Ver Todas</option>
						<c:forEach var="materia" items="${MATERIAS}">
							<option value="${materia.getId()}"
								<c:if test="${SELECCIONADA == materia.getId()}">
									<c:out value="seleccionada"></c:out>
								</c:if>
							>${materia.getDescripcion()}</option>
						</c:forEach>		
					</select>
					<div id="tablaFinales"></div>	
	
	
					<a href="/GestionFinalesWeb/">Volver</a>
		</div>
		<footer>
			&copy; UNPAZ 2019
		</footer>		
</body>
</html>