package unpaz.persistence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import unpaz.persistence.connection.Conexion;

public class DataAccesObject 
{
	protected static final Conexion connection = Conexion.getConnection();
	protected static ResultSet resultSet;
	protected static PreparedStatement statement;
	
	protected static void closeResultSet()
	{
		if(resultSet != null)
		{
			try
			{
				resultSet.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	protected static void closeStatement()
	{
		if(statement != null)
		{
			try
			{
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}