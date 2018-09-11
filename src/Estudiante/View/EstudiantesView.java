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
		String sql = "Insert into Categor�a (nombre, descripci�n) " + "values(?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setString(1, estudiante.getNombre());
			conexion.getSentencia().setString(2, estudiante.getDescripci�n());
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	
	
	public void deleteEstudiante() throws SQLException {
		int codCategor�a = InputTypesUniversidad.readInt("C�digo de categor�a: ", scanner);
		String sql = "delete " + "from categor�a " + "where c�digo = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codCategor�a);
		conexion.modificacion();
	}
	
	public void update() throws EstudianteNoRegistrado, SQLException {
		ResultSet resultSet;
		Estudiante estudiante;
		String nombre;
		String descripci�n;
		int codCategor�a = InputTypesUniversidad.readInt("C�digo de categor�a: ", scanner);
		String sql = "select * from categor�a where c�digo = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codCategor�a);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			nombre = resultSet.getString("nombre");
			descripci�n = resultSet.getString("descripci�n");
			estudiante = new Estudiante(codigoEstudiante,codigoCuenta, Nombre,Apellido, CI, fechaNacimiento, telefono, Direccion, PAA, Semestre, Campus, Carrera);
		} else {
			throw new EstudianteNoRegistrado();
		}

		System.out.println(categor�a);
		Men�.men�Modificar(scanner, categor�a);

		sql = "update categor�a set nombre = ?, descripci�n = ? where c�digo = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setString(1, categor�a.getNombre());
		conexion.getSentencia().setString(2, categor�a.getDescripci�n());
		conexion.getSentencia().setInt(3, categor�a.getCodCategor�a());
		conexion.modificacion();
	}
	public void listarEstudiate() throws SQLException {
		Estudiante estudiante;
		String sql = "select * from categor�a ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			estudiante = new Estudiante(resultSet.getInt("c�digo"), resultSet.getString("nombre"),
					resultSet.getString("descripci�n"));
			System.out.println(estudiante);
		}
	}
}
