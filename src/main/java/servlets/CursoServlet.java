package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import mantenimientos.GestionCurso;
import model.Curso;
/**
 * Servlet implementation class CursoServlet
 */
@WebServlet("/cursoServlet")
public class CursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CursoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String opcion = request.getParameter("opcion");
		System.out.println("get opcion -->"+opcion);
		
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
  
			String opcion =request.getParameter("opcion");
			System.out.println(" opcion -->" +opcion);
			 
			switch (opcion) {
			case "reg":  
						registrar(request,response); 
						break;
			case "act":  
						actualizar(request,response); 
						break;	
			case "lis":
						listar(request, response);
						break;
			case "nue":
						nuevo(request, response);
						break;
			case "bus":
						buscar(request, response);
						break;
			case "eli":
						eliminar(request, response);
						break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}

		
	}



	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables
		String mensaje="";
		
		//Entradas
		int codigo=  Integer.parseInt(request.getParameter("cod"));
	  
		//Procesos
		GestionCurso gestionCurso = new GestionCurso();
		int ok=gestionCurso.eliminar(codigo);
		
		if(ok==0) {
			mensaje+=" <script> alert('"+" Error al eliminar los datos" +"') </script>";
			 
		}else {
			mensaje+=" <script> alert('"+"Eliminación del Curso  "+codigo+" OK" +"') </script>";
		 
		}
		
		//Salida
		request.setAttribute("mensaje", mensaje);
		
		//Invocamos a Listar
		listar(request,response);

}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//entradas 
		int codigo= Integer.parseInt(request.getParameter("cod"));
		
		//procesos
		GestionCurso gestionCurso = new GestionCurso();
		Curso curso = gestionCurso.obtenerCurso(codigo);
		
		//salidas
		request.setAttribute("curso", curso);
		request.getRequestDispatcher("curso/actualizarCurso.jsp").forward(request, response);
		
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("curso/registrarCurso.jsp").forward(request, response);
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// procesos
		GestionCurso gestionCurso = new GestionCurso();
		List<Curso> lista = gestionCurso.listar();
		
		//salida
		request.setAttribute("lstCursos", lista);
		request.getRequestDispatcher("curso/listarCursos.jsp").forward(request, response);
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//variables
			String mensaje="";
	 
			//Entradas	
			String nombre= request.getParameter("txtNombre");
			int nivel= Integer.parseInt(request.getParameter("cboNivel"));
	        int modalidad= Integer.parseInt(request.getParameter("cboModalidad"));
			int creditos= Integer.parseInt(request.getParameter("txtCreditos")); 
			double precio= Double.parseDouble(request.getParameter("txtPrecio"));
			  
			//Contructor con 5 parámetros
			Curso objCurso = new Curso( nombre,nivel,modalidad, creditos , precio );
		  
			//Procesos
			GestionCurso  gestionCurso = new GestionCurso();
			int ok=gestionCurso.registrar(objCurso);
			
			if(ok==0) {
				mensaje+=" <script> alert('"+" Error al registrar los datos" +"') </script>";
				 
			}else {
				mensaje+=" <script> alert('"+"Registro exitoso" +"') </script>";		 
			}
			
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("curso/registrarCurso.jsp").forward(request, response);
	}
 
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//variables
			String mensaje="";
	 
			//Entradas	
			int codigo= Integer.parseInt(request.getParameter("txtCodigo"));
			String nombre= request.getParameter("txtNombre");
			int nivel= Integer.parseInt(request.getParameter("cboNivel"));
	        int modalidad= Integer.parseInt(request.getParameter("cboModalidad"));
			int creditos= Integer.parseInt(request.getParameter("txtCreditos")); 
			double precio= Double.parseDouble(request.getParameter("txtPrecio"));
			  
			//Contructor con 5 parámetros
			Curso objCurso = new Curso( codigo,nombre,nivel,modalidad, creditos , precio );
		  
			//Procesos
			GestionCurso  gestionCurso = new GestionCurso();
			int ok=gestionCurso.actualizar(objCurso);
			
			if(ok==0) {
				mensaje+=" <script> alert('"+" Error al actualizar los datos" +"') </script>";
				 
			}else {
				mensaje+=" <script> alert('"+"Actualización exitosa" +"') </script>";		 
			}
			
			request.setAttribute("mensaje", mensaje);
			listar(request, response);
		
	}
	

}
