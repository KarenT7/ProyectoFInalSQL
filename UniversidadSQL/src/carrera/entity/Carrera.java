package carrera.entity;

public class Carrera {
	
	private int idCarrera;
	//private int  codigoDocente;
	private String jefeDeCarrera;
	private String nombreCarrera;
	
	
	public Carrera(int idCarrera, String jefeDeCarrera, String nombreCarrera) {
		super();
		this.idCarrera = idCarrera;
		this.jefeDeCarrera = jefeDeCarrera;
		this.nombreCarrera = nombreCarrera;

	}
	

	public String getNombreCarrera() {
		return nombreCarrera;
	}


	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}


	public Integer getIdCarrera() {
		return idCarrera;
	}


	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}


	public String getJefeDeCarrera() {
		return jefeDeCarrera;
	}


	public void setJefeDeCarrera(String jefeDeCarrera) {
		this.jefeDeCarrera = jefeDeCarrera;
	}


	


	@Override
	public String toString() {
		return "Carrera [idCarrera=" + idCarrera + ", jefeDeCarrera=" + jefeDeCarrera + ", nombreCarrera="
				+ nombreCarrera + "]";
	}


	public boolean equals(Object o) {
		boolean respuesta = false;
		if ( o != null) {
			Carrera carrera = (Carrera) o;
			if(this.getIdCarrera()==carrera.getIdCarrera()) {
				respuesta = !respuesta;
			}
		}
		return respuesta;
	}
	
	public int hashCode() {
		return this.getIdCarrera().hashCode();
	}
	

}
