package unpaz.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import unpaz.model.Finales;
import unpaz.persistence.dao.FinalDAO;

public class FinalService
{
	public static List<Finales> getAll() throws SQLException
	{
		return FinalDAO.readAll();
	}
	
	public static void add(Finales nuevo) throws SQLException
	{
		FinalDAO.create(nuevo);
	}
	
	public static void edit(Finales actualizado, int idMateria, int legajoAlumno, Date fecha) throws SQLException
	{
		FinalDAO.update(actualizado, idMateria, legajoAlumno, fecha);
	}
	
	public static void delete(int idMateria, int legajoAlumno, Date fecha) throws SQLException
	{
		FinalDAO.delete(idMateria, legajoAlumno, fecha);
	}
	
	public static List<Finales> getByAlumno(int legajoAlumno) throws SQLException
	{
		return FinalDAO.readByAlumno(legajoAlumno);
	}
	
	public static List<Finales> getByMateria(int idMateria) throws SQLException
	{
		return FinalDAO.readByMateria(idMateria);
	}
	
	public static Finales getByPK(int idMateria, int legajoAlumno, Date fecha) throws SQLException
	{
		return FinalDAO.readByPK(idMateria, legajoAlumno, fecha);
	}
}