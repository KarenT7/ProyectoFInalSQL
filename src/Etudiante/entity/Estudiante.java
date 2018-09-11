package Etudiante.entity;

public class Estudiante {
	private int codigoEstudiante;
	private int codigoCuenta;
	private String Nombre;
	private String Apellido;
	private int CI;
	private int fechaNacimiento;
	private int telefono;
	private String Direccion;
	private boolean PAA;
	private int semestre;
	private String Campus;
	private String Carrera;


	public Estudiante(int codigoEstudiante, int codigoCuenta, String nombre, String apellido, int cI,
			int fechaNacimiento, int telefono, String direccion, boolean pAA, int semestre, String campus,
			String carrera) {
		super();
		this.codigoEstudiante = codigoEstudiante;
		this.codigoCuenta = codigoCuenta;
		Nombre = nombre;
		Apellido = apellido;
		CI = cI;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		Direccion = direccion;
		PAA = pAA;
		this.semestre = semestre;
		Campus = campus;
		Carrera = carrera;
	}


	public int getCodigoEstudiante() {
		return codigoEstudiante;
	}


	public void setCodigoEstudiante(int codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}


	public int getCodigoCuenta() {
		return codigoCuenta;
	}


	public void setCodigoCuenta(int codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
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


	public String getDireccion() {
		return Direccion;
	}


	public void setDireccion(String direccion) {
		Direccion = direccion;
	}


	public boolean isPAA() {
		return PAA;
	}


	public void setPAA(boolean pAA) {
		PAA = pAA;
	}


	public int getSemestre() {
		return semestre;
	}


	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}


	public String getCampus() {
		return Campus;
	}


	public void setCampus(String campus) {
		Campus = campus;
	}


	public String getCarrera() {
		return Carrera;
	}


	public void setCarrera(String carrera) {
		Carrera = carrera;}


	@Override
	public String toString() {
		return "Estudiante [codigoEstudiante=" + codigoEstudiante + ", codigoCuenta=" + codigoCuenta + ", Nombre="
				+ Nombre + ", Apellido=" + Apellido + ", CI=" + CI + ", fechaNacimiento=" + fechaNacimiento
				+ ", telefono=" + telefono + ", Direccion=" + Direccion + ", PAA=" + PAA + ", semestre=" + semestre
				+ ", Campus=" + Campus + ", Carrera=" + Carrera + "]";
	}









}
