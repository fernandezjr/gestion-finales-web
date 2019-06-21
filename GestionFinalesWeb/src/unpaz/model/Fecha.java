package unpaz.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Fecha
{
	private Date date;
	private String formato;
	
	public Fecha(Date date)
	{
		this.date = date;
		formato = new SimpleDateFormat("dd/MM/yyyy").format(date);
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public static Date toDate(String date)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date parsed = null;
		try
		{
			parsed = dateFormat.parse(date);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return new Date(parsed.getTime()); 
	}

	public String getFormato()
	{
		return formato;
	}
}