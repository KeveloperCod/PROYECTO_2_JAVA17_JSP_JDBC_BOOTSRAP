package model;

public class Profesion {
	
	private int idProfesion;
	private String profesion;
	
	public Profesion() {}

	public Profesion(String profesion) {
		this.profesion = profesion;
	}

	public Profesion(int idProfesion, String profesion) {
		this.idProfesion = idProfesion;
		this.profesion = profesion;
	}

	public int getIdProfesion() {
		return idProfesion;
	}

	public void setIdProfesion(int idProfesion) {
		this.idProfesion = idProfesion;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
}
