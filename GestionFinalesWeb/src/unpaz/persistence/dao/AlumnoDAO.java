package unpaz.persistence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import unpaz.model.Alumno;

public class AlumnoDAO extends DataAccesObject
{
	private static final String readAll = "SELECT * FROM Alumno ORDER BY Legajo ASC";
	private static final String create = "INSERT INTO Alumno (Legajo, DNI, Nombre, Apellido, Genero) "
			+ "VALUES (?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM Alumno WHERE Legajo = ?";
	private static final String update = "UPDATE Alumno SET DNI = ?, Nombre = ?, "
			+ "Apellido = ?, Genero = ? WHERE Legajo = ?";
	private static final String readByLegajo = "SELECT * FROM Alumno WHERE Legajo = ?";
	
	public static List<Alumno> readAll() throws SQLException
	{
		List<Alumno> alumnos = new ArrayList<Alumno>();
		
		statement = connection.prepareStatement(readAll);
		resultSet = statement.executeQuery();
		
		while(resultSet.next())
		{
			int legajo = resultSet.getInt("Legajo");
			int dni = resultSet.getInt("DNI");
			String nombre = resultSet.getString("Nombre");
			String apellido = resultSet.getString("Apellido");
			String genero = resultSet.getString("Genero");
			alumnos.add(new Alumno(legajo, dni, nombre, apellido, genero));								
		}
		closeResultSet();
		closeStatement();
//		connection.close();
		
		return alumnos;
	}
	
	public static int create(Alumno nuevo) throws SQLException
	{
		int affectedRows = 0;
		try
		{			
			statement = connection.prepareStatement(create);
			connection.setAutoCommit(false);
			statement.setInt(1, getNextLegajo());
			statement.setInt(2, nuevo.getDni());
			statement.setString(3, nuevo.getNombre());
			statement.setString(4, nuevo.getApellido());
			statement.setString(5, nuevo.getGenero());
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
	
	public static int delete(int legajo) throws SQLException
	{
		int affectedRows = 0;
		try
		{			
			statement = connection.prepareStatement(delete);
			statement.setInt(1, legajo);
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
	
	public static int update(Alumno actualizado) throws SQLException
	{
		int affectedRows = 0;
		try
		{
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(update);
			statement.setInt(1, actualizado.getDni());
			statement.setString(2, actualizado.getNombre());
			statement.setString(3, actualizado.getApellido());
			statement.setString(4, actualizado.getGenero());
			statement.setInt(5, actualizado.getLegajo());
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
	
	public static Alumno readByLegajo(int legajo) throws SQLException
	{
		PreparedStatement statement = connection.prepareStatement(readByLegajo);
		statement.setInt(1, legajo);
		ResultSet resultSet = statement.executeQuery();
		Alumno alumno = null;
		resultSet.next();
		if(resultSet != null)
		{
			int dni = resultSet.getInt("DNI");
			String nombre = resultSet.getString("Nombre");
			String apellido = resultSet.getString("Apellido");
			String genero = resultSet.getString("Genero");
			alumno = new Alumno(legajo, dni, nombre, apellido, genero);
		}
		return alumno;
	}
	
	private static int getNextLegajo() throws SQLException
	{
		PreparedStatement statement = connection.prepareStatement("SELECT ISNULL(MAX(Legajo), 0) AS Last_Legajo FROM Alumno");
		ResultSet resultSet = statement.executeQuery();
		resultSet.next();
		int nextLegajo = resultSet.getInt("Last_Legajo") + 1;
		statement.close();
		return nextLegajo;
	}
}