package semestre.entity;

import java.util.Date;

public class Semestre {
	private int idSemestre;
	private int  modulo;
	private Date anio;
	
	public Semestre(int idSemestre, int modulo, Date anio) {
		super();
		this.idSemestre = idSemestre;
		this.modulo = modulo;
		this.anio = anio;
	}

	public int getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(int idSemestre) {
		this.idSemestre = idSemestre;
	}

	public int getModulo() {
		return modulo;
	}

	public void setModulo(int modulo) {
		this.modulo = modulo;
	}

	public java.sql.Date getAnio() {
		return (java.sql.Date) anio;
	}

	public void setAnio(Date anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "Semestre [idSemestre=" + idSemestre + ", modulo=" + modulo + ", anio=" + anio + "]";
	}
/*
	public boolean equals(Object o) {
		boolean respuesta = false;
		if ( o != null) {
			Semestre semestre = (Semestre) o;
			if(this.getIdSemestre()==semestre.getIdSemestre()) {
				respuesta = !respuesta;
			}
		}
		return respuesta;
	}
	
	public int hashCode() {
		return this.getIdSemestre().hashCode();
	}
	*/

}
