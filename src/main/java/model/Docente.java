package model;

public class Docente {
	
	private int codigo;
	private String nombre;
	private String apePaterno;
	private String apeMaterno;
	private String email;
	private long celular;
	private int idProfesion;
	
	public Docente () {}

	public Docente(String nombre, String apePaterno, String apeMaterno, String email, long celular, int idProfesion) {
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.email = email;
		this.celular = celular;
		this.idProfesion = idProfesion;
	}

	public Docente(int codigo, String nombre, String apePaterno, String apeMaterno, String email, long celular,
			int idProfesion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.email = email;
		this.celular = celular;
		this.idProfesion = idProfesion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getCelular() {
		return celular;
	}

	public void setCelular(long celular) {
		this.celular = celular;
	}

	public int getIdProfesion() {
		return idProfesion;
	}

	public void setIdProfesion(int idProfesion) {
		this.idProfesion = idProfesion;
	}

}
