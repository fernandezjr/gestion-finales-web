package unpaz.controller.materia;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unpaz.service.MateriaService;

@WebServlet("/BajaMateria")
public class DeleteMateriaServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public DeleteMateriaServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		try
		{
			MateriaService.delete(id);
			response.sendRedirect("/GestionFinalesWeb/Materias?status=1");
		}
		catch (SQLException e)
		{
			response.sendRedirect("/GestionFinalesWeb/BajaMateria?status=0");
		}
	}
}