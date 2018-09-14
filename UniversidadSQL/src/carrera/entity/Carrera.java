package carrera.entity;

public class Carrera {

	private int idCarrera;
	private String nombreCarrera;

	// private int codigoDocente;
	// private String jefeDeCarrera;

	public Carrera(int idCarrera, String nombreCarrera) {
		super();
		this.idCarrera = idCarrera;
		// this.jefeDeCarrera = jefeDeCarrera;
		this.nombreCarrera = nombreCarrera;

	}

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	@Override
	public String toString() {
		return "Carrera [idCarrera=" + idCarrera + ", nombreCarrera=" + nombreCarrera + "]";
	}
/*************************************************
	public boolean equals(Object o) {
		boolean respuesta = false;
		if (o != null) {
			Carrera carrera = (Carrera) o;
			if (this.getIdCarrera() == carrera.getIdCarrera()) {
				respuesta = !respuesta;
			}
		}
		return respuesta;
	}

	public int hashCode() {
		return this.getIdCarrera().hashCode();
	}
************************************************/
}
