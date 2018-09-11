package Docente.entity;

public class Docente {
	private int codigoDocente;
	private String Nombre;
	private String Apellido;
	private int CI;
	private int fechaNacimiento;
	private int telefono;
	private String GradoDeTitulacion;
	private String Campus;
	private int NumeroSeguroMedico;
	public Docente(int codigoDocente, String nombre, String apellido, int cI, int fechaNacimiento, int telefono,
			String gradoDeTitulacion, String campus, int numeroSeguroMedico) {
		super();
		this.codigoDocente = codigoDocente;
		Nombre = nombre;
		Apellido = apellido;
		CI = cI;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		GradoDeTitulacion = gradoDeTitulacion;
		Campus = campus;
		NumeroSeguroMedico = numeroSeguroMedico;
	}
	public int getCodigoDocente() {
		return codigoDocente;
	}
	public void setCodigoDocente(int codigoDocente) {
		this.codigoDocente = codigoDocente;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public int getCI() {
		return CI;
	}
	public void setCI(int cI) {
		CI = cI;
	}
	public int getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(int fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getGradoDeTitulacion() {
		return GradoDeTitulacion;
	}
	public void setGradoDeTitulacion(String gradoDeTitulacion) {
		GradoDeTitulacion = gradoDeTitulacion;
	}
	public String getCampus() {
		return Campus;
	}
	public void setCampus(String campus) {
		Campus = campus;
	}
	public int getNumeroSeguroMedico() {
		return NumeroSeguroMedico;
	}
	public void setNumeroSeguroMedico(int numeroSeguroMedico) {
		NumeroSeguroMedico = numeroSeguroMedico;
	}
	@Override
	public String toString() {
		return "Docente [codigoDocente=" + codigoDocente + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", CI="
				+ CI + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", GradoDeTitulacion="
				+ GradoDeTitulacion + ", Campus=" + Campus + ", NumeroSeguroMedico=" + NumeroSeguroMedico + "]";
	}


	






}
