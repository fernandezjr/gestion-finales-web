package unpaz.service;

import java.sql.SQLException;
import java.util.List;

import unpaz.model.Alumno;
import unpaz.persistence.dao.AlumnoDAO;

public class AlumnoService
{
	public static List<Alumno> getAll() throws SQLException
	{
		return AlumnoDAO.readAll();
	}
	
	public static void add(Alumno nuevo) throws SQLException
	{
		AlumnoDAO.create(nuevo);
	}
	
	public static void edit(Alumno editado) throws SQLException
	{
		AlumnoDAO.update(editado);
	}
	
	public static void delete(int legajo) throws SQLException
	{
		AlumnoDAO.delete(legajo);
	}
	
	public static Alumno getByLegajo(int legajo) throws SQLException
	{
		return AlumnoDAO.readByLegajo(legajo);
	}
}