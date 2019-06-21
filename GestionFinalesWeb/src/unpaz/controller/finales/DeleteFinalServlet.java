package unpaz.controller.finales;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unpaz.model.Fecha;
import unpaz.service.FinalService;

@WebServlet("/BajaFinal")
public class DeleteFinalServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public DeleteFinalServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int idMateria = Integer.parseInt(request.getParameter("materia"));
		int legajoAlumno = Integer.parseInt(request.getParameter("alumno"));
		Date fecha = Fecha.toDate(request.getParameter("fecha"));
		try
		{
			FinalService.delete(idMateria, legajoAlumno, fecha);
			response.sendRedirect("/GestionFinalesWeb/FinalesPorAlumno?alumno=" + legajoAlumno + "&status=1");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}