package unpaz.controller.alumno;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unpaz.service.AlumnoService;

@WebServlet("/Alumnos")
public class AlumnosServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public AlumnosServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			request.setAttribute("ALUMNOS", AlumnoService.getAll());
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		request.setAttribute("STATUS", request.getParameter("status"));
		getServletContext().getRequestDispatcher("/JSP/alumnos.jsp").forward(request, response);
	}
}