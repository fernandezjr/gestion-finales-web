package unpaz.persistence.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import unpaz.model.Alumno;
import unpaz.model.Finales;
import unpaz.model.Materia;

public class FinalDAO extends DataAccesObject
{
	private static final String create = "INSERT INTO Final (ID_Materia, Legajo_Alumno, Fecha, Nota) "
			+ "VALUES (?, ?, ?, ?)";
	
	private static final String readAll = "SELECT * FROM Final";
	
	private static final String update = "UPDATE Final SET ID_Materia = ?, Legajo_Alumno = ?, "
			+ "Fecha = ?, Nota = ? WHERE ID_Materia = ? AND Legajo_Alumno = ? AND Fecha = ?";
	private static final String delete = "DELETE FROM Final WHERE ID_Materia = ? "
			+ "AND Legajo_Alumno = ? AND Fecha = ?";	
	
	private static final String readByPK = "SELECT * FROM Final WHERE ID_Materia = ? "
			+ "AND Legajo_Alumno = ? AND Fecha = ?";
	
	private static final String readByMateria = "SELECT * FROM Final WHERE ID_Materia = ?";
	
	private static final String readByAlumno = "SELECT * FROM Final WHERE Legajo_Alumno = ?";
	
	public static int create(Finales nuevo) throws SQLException
	{
		int affectedRows = 0;
		try
		{
			statement = connection.prepareStatement(create);
			connection.setAutoCommit(false);
			statement.setInt(1, nuevo.getMateria().getId());
			statement.setInt(2, nuevo.getAlumno().getLegajo());
			statement.setDate(3, nuevo.getFecha().getDate());
			statement.setBigDecimal(4, nuevo.getNota());			
			affectedRows = statement.executeUpdate();
			connection.commit();
		}
		catch (SQLException e)
		{
			connection.rollback();
			throw e;
		}
		finally
		{
			closeStatement();
		}
		return affectedRows;
	}
	
	public static List<Finales> readAll() throws SQLException
	{
		List<Finales> finales = new ArrayList<Finales>();
		statement = connection.prepareStatement(readAll);
		resultSet = statement.executeQuery();		
		while(resultSet.next())
		{
			Materia materia = MateriaDAO.readById(resultSet.getInt("ID_Materia"));
			Alumno alumno = AlumnoDAO.readByLegajo(resultSet.getInt("Legajo_Alumno"));
			BigDecimal nota = resultSet.getBigDecimal("Nota");
			Date fecha = resultSet.getDate("Fecha");
			finales.add(new Finales(materia, alumno, nota, fecha));
		}
		closeResultSet();
		closeStatement();
		return finales;
	}
	
	public static int update(Finales actualizado, int idMateria, int legajoAlumno, Date fecha) throws SQLException
	{
		int affectedRows = 0;
		try
		{
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(update);
			statement.setInt(1, actualizado.getMateria().getId());
			statement.setInt(2, actualizado.getAlumno().getLegajo());
			statement.setDate(3, actualizado.getFecha().getDate());
			statement.setBigDecimal(4, actualizado.getNota());			
			statement.setInt(5, idMateria);
			statement.setInt(6, legajoAlumno);
			statement.setDate(7, fecha);
			affectedRows = statement.executeUpdate();
			connection.commit();
		}
		catch(SQLException e)
		{
			connection.rollback();
			throw e;
		}
		finally
		{
			closeStatement();
		}
		return affectedRows;
	}
	
	public static int delete(int idMateria, int legajoAlumno, Date fecha) throws SQLException
	{
		int affectedRows = 0;
		try
		{			
			statement = connection.prepareStatement(delete);
			statement.setInt(1, idMateria);
			statement.setInt(2, legajoAlumno);
			statement.setDate(3, fecha);
			affectedRows = statement.executeUpdate();
			connection.commit();
		}
		catch(SQLException e)
		{
			connection.rollback();
			throw e;
		}
		finally
		{
			closeStatement();
		}
		return affectedRows;
	}
	
	public static Finales readByPK(int idMateria, int legajoAlumno, Date fecha) throws SQLException
	{
		Finales buscado = null;
		PreparedStatement statement = connection.prepareStatement(readByPK);
		statement.setInt(1, idMateria);
		statement.setInt(2, legajoAlumno);
		statement.setDate(3, fecha);
		ResultSet resultSet = statement.executeQuery();
		resultSet.next();
		if(resultSet != null)
		{
			Materia materia = MateriaDAO.readById(idMateria);
			Alumno alumno = AlumnoDAO.readByLegajo(legajoAlumno);
			BigDecimal nota = resultSet.getBigDecimal("Nota");
			buscado = new Finales(materia, alumno, nota, fecha);
		}
		return buscado;
	}
	
	public static List<Finales> readByMateria(int idMateria) throws SQLException
	{
		List<Finales> finalesPorMateria = new ArrayList<Finales>();
		PreparedStatement statement = connection.prepareStatement(readByMateria);
		statement.setInt(1, idMateria);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next())
		{
			Materia materia = MateriaDAO.readById(resultSet.getInt("ID_Materia"));
			Alumno alumno = AlumnoDAO.readByLegajo(resultSet.getInt("Legajo_Alumno"));
			BigDecimal nota = resultSet.getBigDecimal("Nota");
			Date fecha = resultSet.getDate("Fecha");
			finalesPorMateria.add(new Finales(materia, alumno, nota, fecha));
		}
		return finalesPorMateria;
	}
	
	public static List<Finales> readByAlumno(int legajoAlumno) throws SQLException
	{
		List<Finales> finalesPorAlumno = new ArrayList<Finales>();
		PreparedStatement statement = connection.prepareStatement(readByAlumno);
		statement.setInt(1, legajoAlumno);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next())
		{
			Materia materia = MateriaDAO.readById(resultSet.getInt("ID_Materia"));
			Alumno alumno = AlumnoDAO.readByLegajo(resultSet.getInt("Legajo_Alumno"));
			BigDecimal nota = resultSet.getBigDecimal("Nota");
			Date fecha = resultSet.getDate("Fecha");
			finalesPorAlumno.add(new Finales(materia, alumno, nota, fecha));
		}
		return finalesPorAlumno;
	}
	
}