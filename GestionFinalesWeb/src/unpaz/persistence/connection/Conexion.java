package unpaz.persistence.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexion 
{
	private Connection connection;
	
	private static Conexion conexion;
	
	private static final String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String url = "jdbc:sqlserver://localhost:1433;instance=SQLEXPRESS;databaseName=UNPAZ";
	private static final String user = "appuser";
	private static final String password = "87654321";
	
	private Conexion() throws ClassNotFoundException, SQLException
	{
		Class.forName(driverClass);		
		connection = DriverManager.getConnection(url, user, password);
	}
	
	public static Conexion getConnection()
	{
		if(conexion == null)
		{
			try
			{
				conexion = new Conexion();
			}
			catch (ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
			}
		}
		return conexion;
	}
	
	public void close() throws SQLException
	{
		if(connection != null)
		{
			connection.close();
		}
	}
	
	public void commit() throws SQLException
	{
		if(connection != null)
		{
			connection.commit();
			connection.setAutoCommit(true);
		}				
	}
	
	public void rollback() throws SQLException
	{
		if(connection != null)
		{
			connection.rollback();
			connection.setAutoCommit(true);
		}
	}
	
	public PreparedStatement prepareStatement(String sql) throws SQLException
	{
		return connection.prepareStatement(sql);
	}
	
	public void setAutoCommit(boolean autoCommit) throws SQLException
	{
		connection.setAutoCommit(autoCommit);
	}
}