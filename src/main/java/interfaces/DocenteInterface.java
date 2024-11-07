package interfaces;

import java.util.List;

import model.Docente;

public interface DocenteInterface {
	public int registrar(Docente docente);
	public int actualizar(Docente docente);
	
	public List<Docente> listar(); //listado de docentes
	public Docente obtenerDocente(int codigo);//te va a devolver un objeto docente 
	public int eliminar(int codigo);//te va a devolver un entero
}
