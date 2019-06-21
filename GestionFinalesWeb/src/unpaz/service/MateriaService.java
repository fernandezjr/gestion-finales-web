package unpaz.service;

import java.sql.SQLException;
import java.util.List;

import unpaz.model.Materia;
import unpaz.persistence.dao.MateriaDAO;

public class MateriaService
{
	public static List<Materia> getAll() throws SQLException
	{
		return MateriaDAO.readAll();
	}
	
	public static void add(Materia nueva) throws SQLException
	{
		MateriaDAO.create(nueva);
	}
	
	public static void edit(Materia editada) throws SQLException
	{
		MateriaDAO.update(editada);
	}
	
	public static void delete(int id) throws SQLException
	{
		MateriaDAO.delete(id);
	}
	
	public static Materia getById(int idMateria) throws SQLException
	{
		return MateriaDAO.readById(idMateria);
	}
	
	public static List<Materia> getNotApprovedByAlumno(int legajoAlumno) throws SQLException
	{
		return MateriaDAO.readNotApprovedByAlumno(legajoAlumno);
	}
	
	public static List<Materia> getByMateriaWithFinales() throws SQLException
	{
		return MateriaDAO.readByMateriaWithFinales();
	}
}