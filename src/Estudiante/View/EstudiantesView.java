package Estudiante.View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

import Control.Conexion;
import Etudiante.entity.Estudiante;
import Etudiante.entity.EstudianteNoRegistrado;
import General.InputTypesUniversidad;

public class EstudiantesView {
private Conexion conexion;
private Scanner scanner;
	public EstudiantesView(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}
	public void addEstudiante() {
		Estudiante estudiante = RegistroEstudiante.ingresarEstudiante(scanner);
		String sql = "Insert into estudiante (codigoEstudiante,codigoCuenta, Nombre,Apellido, CI, fechaNacimiento, telefono, Direccion, PAA,IdClase) " + "values(?,?,?,?,?,?,?,?,?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, estudiante.getCodigoEstudiante());
			conexion.getSentencia().setInt(2, estudiante.getCodigoCuenta());
			conexion.getSentencia().setString(3, estudiante.getNombre());
			conexion.getSentencia().setString(4, estudiante.getApellido());
			conexion.getSentencia().setInt(5, estudiante.getCI());
			conexion.getSentencia().setInt(6, estudiante.getFechaNacimiento());
			conexion.getSentencia().setInt(7, estudiante.getTelefono());
			conexion.getSentencia().setString(8,estudiante.getDireccion());
			conexion.getSentencia().setBoolean(9, estudiante.isPAA());
			conexion.getSentencia().setInt(10, estudiante.getIdCLase());
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	
	
	public void deleteEstudiante() throws SQLException {
		int codigoEstudiante = InputTypesUniversidad.readInt("Código del estudiante: ", scanner);
		String sql = "delete " + "from estudiante " + "where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoEstudiante);
		conexion.modificacion();
	}
	//teamviewer
	
	public void update() throws EstudianteNoRegistrado, SQLException {
		ResultSet resultSet;
		Estudiante estudiante;
		String Nombre;
		String Apellido;
		int codigoCuenta;
		int CI;
		int fechaNacimiento;
		int telefono;
		String Direccion;
		boolean PAA;
		int IdCLase;
			
		int codigoEstudiante = InputTypesUniversidad.readInt("Código del estudiante: ", scanner);
		String sql = "select * from estudiante where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoEstudiante);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			Nombre = resultSet.getString("Nombres");
			Apellido = resultSet.getString("Apellidos");
			codigoCuenta=resultSet.getInt("codigoCuenta");
			CI=resultSet.getInt("CI");
			fechaNacimiento=resultSet.getInt("FechaNacimiento");
			telefono=resultSet.getInt("Telefono");
			Direccion=resultSet.getString("Direccion");
			PAA=resultSet.getBoolean("PAA");
			IdCLase=resultSet.getInt("IdCLase");
			
			estudiante = new Estudiante(codigoEstudiante,codigoCuenta, Nombre,Apellido, fechaNacimiento, telefono, Direccion, PAA,CI,IdCLase);
		} else {
			throw new EstudianteNoRegistrado();
		}

		System.out.println(estudiante);
		MenuEstudiante.ModificarEstudiante(scanner,estudiante);
		sql = "update categoría set nombre = ?, descripción = ? where código = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, estudiante.getCodigoEstudiante());
		conexion.getSentencia().setInt(2, estudiante.getCodigoCuenta());
		conexion.getSentencia().setString(3, estudiante.getNombre());
		conexion.getSentencia().setString(4, estudiante.getApellido());
		conexion.getSentencia().setInt(5, estudiante.getCI());
		conexion.getSentencia().setInt(6, estudiante.getFechaNacimiento());
		conexion.getSentencia().setInt(7, estudiante.getTelefono());
		conexion.getSentencia().setString(8,estudiante.getDireccion());
		conexion.getSentencia().setBoolean(9, estudiante.isPAA());
		conexion.getSentencia().setInt(10, estudiante.getIdCLase());
		conexion.modificacion();
	}
	public void listarEstudiate() throws SQLException {
		Estudiante estudiante;
		String sql = "select * from estudiante ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			estudiante = new Estudiante(resultSet.getInt("CodigoEstudiante"),
					resultSet.getInt("CodigoCuenta"), 
					resultSet.getString("Nombres"),
					resultSet.getString("Apellidos"),
					resultSet.getInt("FechaNacimiento"),
					resultSet.getInt("Telefono"),
					resultSet.getString("Direccion"),
					resultSet.getBoolean("PAA"),
					resultSet.getInt("CI"),
					resultSet.getInt("IdClase"));
			System.out.println(estudiante);
		}
	}
}
