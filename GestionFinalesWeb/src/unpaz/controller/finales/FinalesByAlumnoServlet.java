package unpaz.controller.finales;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unpaz.service.AlumnoService;
import unpaz.service.FinalService;

@WebServlet("/FinalesPorAlumno")
public class FinalesByAlumnoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public FinalesByAlumnoServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int legajoAlumno = Integer.parseInt(request.getParameter("alumno"));
		try
		{
			request.setAttribute("ALUMNO", AlumnoService.getByLegajo(legajoAlumno));
			request.setAttribute("FINALES", FinalService.getByAlumno(legajoAlumno));
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		request.setAttribute("STATUS", request.getParameter("status"));
		getServletContext().getRequestDispatcher("/JSP/finales_alumno.jsp").forward(request, response);
	}
}