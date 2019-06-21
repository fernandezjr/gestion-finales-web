package unpaz.controller.materia;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unpaz.service.MateriaService;

@WebServlet("/Materias")
public class MateriasServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public MateriasServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			request.setAttribute("MATERIAS", MateriaService.getAll());
			request.setAttribute("STATUS", request.getParameter("status"));
			getServletContext().getRequestDispatcher("/JSP/materias.jsp").forward(request, response);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}