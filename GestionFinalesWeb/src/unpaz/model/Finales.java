package unpaz.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Finales
{
	private Materia materia;
	private Alumno alumno;
	private BigDecimal nota;
	private Fecha fecha;
	
	public Finales(Materia materia, Alumno alumno, BigDecimal nota, Date fecha)
	{
		this.materia = materia;
		this.alumno = alumno;
		this.nota = nota;
		this.fecha = new Fecha(fecha);
	}

	public Materia getMateria()
	{
		return materia;
	}

	public Alumno getAlumno()
	{
		return alumno;
	}

	public BigDecimal getNota()
	{
		return nota;
	}

	public Fecha getFecha()
	{
		return fecha;
	}	
}