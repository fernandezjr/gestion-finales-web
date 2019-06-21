package unpaz.controller.alumno;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unpaz.model.Alumno;
import unpaz.service.AlumnoService;

@WebServlet("/ModificacionAlumno")
public class EditAlumnoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public EditAlumnoServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("STATUS", request.getParameter("status"));
		int legajo = Integer.parseInt(request.getParameter("legajo"));
		try
		{
			request.setAttribute("ALUMNO", AlumnoService.getByLegajo(legajo));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/JSP/alumno_modificacion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int legajo = Integer.parseInt(request.getParameter("legajo"));
		int dni = Integer.parseInt(request.getParameter("dni"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String genero = request.getParameter("genero");
		try
		{
			AlumnoService.edit(new Alumno(legajo, dni, nombre, apellido, genero));
			response.sendRedirect("/GestionFinalesWeb/Alumnos?status=1");
		}
		catch (SQLException e)
		{
			response.sendRedirect("/GestionFinalesWeb/ModificacionAlumno?legajo=" + legajo +"&status=0");
		}
	}
}