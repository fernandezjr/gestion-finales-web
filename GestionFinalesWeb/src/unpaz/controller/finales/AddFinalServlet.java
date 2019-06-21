package unpaz.controller.finales;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unpaz.model.Alumno;
import unpaz.model.Fecha;
import unpaz.model.Finales;
import unpaz.service.AlumnoService;
import unpaz.service.FinalService;
import unpaz.service.MateriaService;

@WebServlet("/AltaFinal")
public class AddFinalServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private Alumno alumno;
       
    public AddFinalServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{		
		int legajoAlumno = Integer.parseInt(request.getParameter("legajo"));
		request.setAttribute("STATUS", request.getParameter("status"));
		try
		{
			alumno = AlumnoService.getByLegajo(legajoAlumno);			
			request.setAttribute("ALUMNO", alumno);
			request.setAttribute("MATERIAS", MateriaService.getNotApprovedByAlumno(legajoAlumno));			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/JSP/final_alta.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int idMateria = Integer.parseInt(request.getParameter("materia"));
		BigDecimal nota = BigDecimal.valueOf(Double.parseDouble(request.getParameter("nota")));
		Date fecha = Fecha.toDate(request.getParameter("fecha"));		
		try
		{
			FinalService.add(new Finales(MateriaService.getById(idMateria), 
					alumno, nota, fecha));
			response.sendRedirect("/GestionFinalesWeb/Finales?status=1");
			
		}
		catch (SQLException e)
		{
			response.sendRedirect("/GestionFinalesWeb/AltaFinal?legajo=" + alumno.getLegajo() + "&status=0");
		}				
	}
}