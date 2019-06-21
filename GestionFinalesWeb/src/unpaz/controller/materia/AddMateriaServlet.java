package unpaz.controller.materia;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unpaz.model.Materia;
import unpaz.service.MateriaService;

@WebServlet("/AltaMateria")
public class AddMateriaServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public AddMateriaServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("STATUS", request.getParameter("status"));
		getServletContext().getRequestDispatcher("/JSP/materia_alta.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String descripcion = request.getParameter("descripcion");
		try
		{
			MateriaService.add(new Materia(descripcion));
			response.sendRedirect("/GestionFinalesWeb/Materias?status=1");
		}
		catch (SQLException e)
		{
			response.sendRedirect("/GestionFinalesWeb/AltaMateria?status=0");
		}
	}
}