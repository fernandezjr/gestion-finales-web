package unpaz.persistence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import unpaz.model.Materia;

public class MateriaDAO extends DataAccesObject 
{
	private static final String create = "INSERT INTO Materia (ID, Descripcion) VALUES (?, ?)";
	private static final String readAll = "SELECT * FROM Materia ORDER BY ID ASC";
	private static final String update = "UPDATE Materia SET Descripcion = ? WHERE ID = ?";
	private static final String delete = "DELETE FROM Materia WHERE ID = ?";
	private static final String readById = "SELECT * FROM Materia WHERE ID = ?";
	private static final String readNotApprovedByAlumno = "SELECT ID, Descripcion FROM Materia "
			+ "WHERE ID NOT IN(SELECT ID_Materia FROM Final WHERE Legajo_Alumno = ? "
			+ "AND Nota >= 4)";
	
	private static final String readByMateriaWithFinales = "SELECT * FROM MATERIA WHERE ID IN(SELECT "
			+ "ID_Materia FROM Final GROUP BY ID_Materia) ORDER BY ID ASC";
	
	
	public static int create(Materia nueva) throws SQLException
	{
		int affectedRows = 0;
		try
		{
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(create);
			statement.setInt(1, getMaxId() + 1);
			statement.setString(2, nueva.getDescripcion());
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
//			connection.close();
		}
		return affectedRows;
	}
	
	public static List<Materia> readAll() throws SQLException
	{
		List<Materia> materias = new ArrayList<Materia>();		
		statement = connection.prepareStatement(readAll);
		resultSet = statement.executeQuery();
		while(resultSet.next())
		{
			int id = resultSet.getInt("ID");
			String descripcion = resultSet.getString("Descripcion");
			materias.add(new Materia(id, descripcion));
		}
		closeResultSet();
		closeStatement();
//		connection.close();
		return materias;
	}
	
	public static int update(Materia actualizada) throws SQLException
	{
		int affectedRows = 0;
		try
		{
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(update);
			statement.setString(1, actualizada.getDescripcion());
			statement.setInt(2, actualizada.getId());
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
//			connection.close();
		}
		return affectedRows;
	}
	
	public static int delete(int id) throws SQLException
	{
		int affectedRows = 0;
		try
		{			
			statement = connection.prepareStatement(delete);
			statement.setInt(1, id);
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
//			connection.close();
		}
		return affectedRows;
	}
	
	public static Materia readById(int id) throws SQLException
	{
		PreparedStatement statement = connection.prepareStatement(readById);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		Materia materia = null;
		resultSet.next();
		if(resultSet != null)
		{
			String descripcion = resultSet.getString("Descripcion");
			materia = new Materia(id, descripcion);
		}
		return materia;
	}
	
	private static int getMaxId() throws SQLException
	{
		PreparedStatement statement = connection.prepareStatement("SELECT ISNULL(MAX(ID), 0) AS Max_ID FROM Materia");
		resultSet = statement.executeQuery();
		resultSet.next();
		int maxId = resultSet.getInt("Max_ID");
		statement.close();
		return maxId;
	}
	
	public static List<Materia> readNotApprovedByAlumno(int legajoAlumno) throws SQLException
	{
		List<Materia> materiasNoAprobadas = new ArrayList<Materia>();		
		PreparedStatement statement = connection.prepareStatement(readNotApprovedByAlumno);
		statement.setInt(1, legajoAlumno);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next())
		{
			int id = resultSet.getInt("ID");
			String descripcion = resultSet.getString("Descripcion");
			materiasNoAprobadas.add(new Materia(id, descripcion));
		}
		closeResultSet();
		closeStatement();
//		connection.close();
		return materiasNoAprobadas;
	}
	
	public static List<Materia> readByMateriaWithFinales() throws SQLException
	{
		List<Materia> materiasConFinales = new ArrayList<Materia>();		
		statement = connection.prepareStatement(readByMateriaWithFinales);
		resultSet = statement.executeQuery();
		while(resultSet.next())
		{
			int id = resultSet.getInt("ID");
			String descripcion = resultSet.getString("Descripcion");
			materiasConFinales.add(new Materia(id, descripcion));
		}
		closeResultSet();
		closeStatement();
//		connection.close();
		return materiasConFinales;
	}
}