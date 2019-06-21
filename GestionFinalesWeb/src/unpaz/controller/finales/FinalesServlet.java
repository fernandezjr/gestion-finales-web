package unpaz.controller.finales;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import unpaz.model.Finales;
import unpaz.service.FinalService;
import unpaz.service.MateriaService;

@WebServlet("/Finales")
public class FinalesServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public FinalesServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{		
		String idMateria = request.getParameter("materias");
		try
		{
			if(idMateria != null && !idMateria.equals("0"))
			{
				request.setAttribute("SELECCIONADA", Integer.parseInt(idMateria));
			}
			request.setAttribute("MATERIAS", MateriaService.getByMateriaWithFinales());
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		request.setAttribute("STATUS", request.getParameter("status"));
		getServletContext().getRequestDispatcher("/JSP/finales.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String idMateria = request.getParameter("materia");
		List<Finales> finalesPorMateria = null;
		try
		{
			if(idMateria != null && !idMateria.equals("0"))
			{
				finalesPorMateria = FinalService.getByMateria(Integer.parseInt(idMateria));
			}
			else
			{
				finalesPorMateria = FinalService.getAll();
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(finalesPorMateria));
	}		
}