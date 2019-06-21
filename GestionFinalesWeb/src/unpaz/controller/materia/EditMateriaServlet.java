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

@WebServlet("/ModificacionMateria")
public class EditMateriaServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public EditMateriaServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		try
		{
			request.setAttribute("MATERIA", MateriaService.getById(id));
			request.setAttribute("STATUS", request.getParameter("status"));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/JSP/materia_modificacion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String descripcion = request.getParameter("descripcion");
		try
		{
			MateriaService.edit(new Materia(id, descripcion));
			response.sendRedirect("/GestionFinalesWeb/Materias?status=1");
		}
		catch (SQLException e)
		{
			response.sendRedirect("/GestionFinalesWeb/ModificacionMateria?id=" + id + "&status=0");
		}
	}
}