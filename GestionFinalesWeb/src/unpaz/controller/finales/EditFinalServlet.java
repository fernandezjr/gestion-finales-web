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

import unpaz.model.Fecha;
import unpaz.model.Finales;
import unpaz.service.AlumnoService;
import unpaz.service.FinalService;
import unpaz.service.MateriaService;

@WebServlet("/ModificacionFinal")
public class EditFinalServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private int legajoAlumno;
	private int idMateriaOriginal;
	private String fechaOriginal;
       
    public EditFinalServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("STATUS", request.getParameter("status"));
		idMateriaOriginal = Integer.parseInt(request.getParameter("materia"));
		legajoAlumno = Integer.parseInt(request.getParameter("alumno"));
		fechaOriginal = request.getParameter("fecha");		
		try
		{
			request.setAttribute("MATERIAS", MateriaService.getNotApprovedByAlumno(legajoAlumno));
			request.setAttribute("FINALES", FinalService.getByPK(idMateriaOriginal, legajoAlumno, Fecha.toDate(fechaOriginal)));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/JSP/final_modificacion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{		
		int idMateria = Integer.parseInt(request.getParameter("materia"));
		BigDecimal nota = BigDecimal.valueOf(Double.parseDouble(request.getParameter("nota")));
		String fechaString = request.getParameter("fecha");
		Date fecha = Fecha.toDate(fechaString);
		try
		{
			FinalService.edit(new Finales(MateriaService.getById(idMateria), 
					AlumnoService.getByLegajo(legajoAlumno), nota, fecha), idMateriaOriginal, legajoAlumno, Fecha.toDate(fechaOriginal));
			response.sendRedirect("/GestionFinalesWeb/FinalesPorAlumno?alumno=" + legajoAlumno + "&status=1");
		}
		catch (SQLException e)
		{
			response.sendRedirect("/GestionFinalesWeb/ModificacionFinal?materia=" + idMateriaOriginal  
					+ "&alumno=" + legajoAlumno + "&fecha=" + fechaOriginal + "&status=0");
		}
	}
}