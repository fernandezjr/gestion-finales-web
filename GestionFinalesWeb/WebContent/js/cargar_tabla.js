window.onload = function()
{
	loadFinales(document.getElementById("comboMaterias").value);
};

function loadFinales(idMateria)
{
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			var finalesArray = JSON.parse(this.responseText);
			var finalesTable = document.getElementById("tablaFinales");
			finalesTable.innerHTML = "";
			createTable(finalesArray, finalesTable);
		}
	};
	xmlHttp.open("POST", "./Finales?materia=" + idMateria, true);
	xmlHttp.send();
}

function createTable(array, table)
{
	var tempTable = "<table><tr><th>Materia</th><th>Nombre</th><th>Apellido</th><th>Nota</th><th>Fecha</th></tr>";
	for (var i = 0; i < array.length; i++)
	{
		tempTable += "<tr>";
		tempTable += "<td>" + array[i].materia.descripcion + "</td>";
		tempTable += "<td>" + array[i].alumno.nombre + "</td>";
		tempTable += "<td>" + array[i].alumno.apellido + "</td>";
		tempTable += "<td>" + array[i].nota + "</td>";
		tempTable += "<td>" + array[i].fecha.formato + "</td>";
		tempTable += "</tr>";
	}
	table.innerHTML = tempTable + "</table>";
}