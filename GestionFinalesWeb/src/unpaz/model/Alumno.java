package unpaz.model;

public class Alumno
{
	private int legajo;
	private int dni;
	private String nombre;
	private String apellido;
	private String genero;
	
	public Alumno(int legajo, int dni, String nombre, String apellido, String genero)
	{
		this.legajo = legajo;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
	}		

	public Alumno(int dni, String nombre, String apellido, String genero)
	{
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
	}

	public int getLegajo()
	{
		return legajo;
	}

	public int getDni()
	{
		return dni;
	}

	public String getNombre()
	{
		return nombre;
	}

	public String getApellido()
	{
		return apellido;
	}

	public String getGenero()
	{
		return genero;
	}
}