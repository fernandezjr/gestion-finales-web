package unpaz.model;

public class Materia
{
	private int id;
	private String descripcion;
	
	public Materia(int id, String descripcion)
	{
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public Materia(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public int getId()
	{
		return id;
	}

	public String getDescripcion()
	{
		return descripcion;
	}
}