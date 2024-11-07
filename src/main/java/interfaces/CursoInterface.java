package interfaces;

import java.util.List;

import model.Curso;

public interface CursoInterface {
	//solo se colocan los métodos 
	public int registrar(Curso curso);
	public int actualizar(Curso curso);
	
	public List <Curso> listar();
	public Curso obtenerCurso(int codigo);
	public int eliminar(int codigo);
	
}
