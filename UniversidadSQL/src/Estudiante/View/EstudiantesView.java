package Estudiante.View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

import Estudiante.entity.Estudiante;
import Estudiante.entity.EstudianteNoRegistrado;
import universidad.control.Conexion;
import universidad.view.InputTypes;

public class EstudiantesView {
	private Conexion conexion;
	private Scanner scanner;

	public EstudiantesView(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void addEstudiante() {
		Estudiante estudiante = RegistroEstudiante.ingresarEstudiante(scanner);
		String sql = "Insert into estudiante (CodigoCuenta, Nombres,Apellidos, CI, FechaNacimiento, Telefono, Direccion, PAA,IdClase) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		try {
			conexion.consulta(sql);
			// conexion.getSentencia().setInt(1, estudiante.getCodigoEstudiante());
			conexion.getSentencia().setInt(1, estudiante.getCodigoCuenta());
			conexion.getSentencia().setString(2, estudiante.getNombre());
			conexion.getSentencia().setString(3, estudiante.getApellido());
			conexion.getSentencia().setInt(4, estudiante.getCI());
			conexion.getSentencia().setInt(5, estudiante.getFechaNacimiento());
			conexion.getSentencia().setInt(6, estudiante.getTelefono());
			conexion.getSentencia().setString(7, estudiante.getDireccion());
			conexion.getSentencia().setBoolean(8, estudiante.isPAA());
			conexion.getSentencia().setInt(9, estudiante.getIdCLase());
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	public void deleteEstudiante() throws SQLException {
		int codigoEstudiante = InputTypes.readInt("Código del estudiante: ", scanner);
		String sql = "delete " + "from estudiante " + "where CodigoEstudiante = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoEstudiante);
		conexion.modificacion();
	}
	// teamviewer

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

		int codigoEstudiante = InputTypes.readInt("Código del estudiante: ", scanner);
		String sql = "select * from estudiante where CodigoEstudiante = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoEstudiante);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			Nombre = resultSet.getString("Nombres");
			Apellido = resultSet.getString("Apellidos");
			codigoCuenta = resultSet.getInt("CodigoCuenta");
			CI = resultSet.getInt("CI");
			fechaNacimiento = resultSet.getInt("FechaNacimiento");
			telefono = resultSet.getInt("Telefono");
			Direccion = resultSet.getString("Direccion");
			PAA = resultSet.getBoolean("PAA");
			IdCLase = resultSet.getInt("IdClase");

			estudiante = new Estudiante(codigoEstudiante, codigoCuenta, Nombre, Apellido, fechaNacimiento, telefono,
					Direccion, PAA, CI, IdCLase);
		} else {
			throw new EstudianteNoRegistrado();
		}

		System.out.println(estudiante);
		MenuEstudiante.ModificarEstudiante(scanner, estudiante);
		sql = "update estudiante set Nombres = ?, Apellidos = ?, CodigoCuenta = ?, CI = ?, FechaNacimiento = ?, Telefono = ?, Direccion = ?, PAA =?, IdClase = ?, where CodigoEstudiante = ?";

		conexion.consulta(sql);
		// conexion.getSentencia().setInt(1, estudiante.getCodigoEstudiante());
		conexion.getSentencia().setInt(1, estudiante.getCodigoCuenta());
		conexion.getSentencia().setString(2, estudiante.getNombre());
		conexion.getSentencia().setString(3, estudiante.getApellido());
		conexion.getSentencia().setInt(4, estudiante.getCI());
		conexion.getSentencia().setInt(5, estudiante.getFechaNacimiento());
		conexion.getSentencia().setInt(6, estudiante.getTelefono());
		conexion.getSentencia().setString(7, estudiante.getDireccion());
		conexion.getSentencia().setBoolean(8, estudiante.isPAA());
		conexion.getSentencia().setInt(9, estudiante.getIdCLase());
		conexion.modificacion();
	}

	public void listarEstudiate() throws SQLException {
		Estudiante estudiante;
		String sql = "select * from estudiante ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			estudiante = new Estudiante(resultSet.getInt("CodigoEstudiante"), resultSet.getInt("CodigoCuenta"),
					resultSet.getString("Nombres"), resultSet.getString("Apellidos"),
					resultSet.getInt("FechaNacimiento"), resultSet.getInt("Telefono"), resultSet.getString("Direccion"),
					resultSet.getBoolean("PAA"), resultSet.getInt("CI"), resultSet.getInt("IdClase"));
			System.out.println(estudiante);
		}
	}
}
