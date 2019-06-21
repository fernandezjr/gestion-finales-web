package unpaz.controller.alumno;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unpaz.service.AlumnoService;

@WebServlet("/BajaAlumno")
public class DeleteAlumnoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public DeleteAlumnoServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("STATUS", request.getParameter("status"));
		int legajo = Integer.parseInt(request.getParameter("legajo"));
		try
		{
			AlumnoService.delete(legajo);
			response.sendRedirect("/GestionFinalesWeb/Alumnos?status=1");
		}
		catch (SQLException e)
		{
			response.sendRedirect("/GestionFinalesWeb/BajaAlumno?status=0");
		}		
	}
}