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
		String sql = "Insert into Categoría (nombre, descripción) " + "values(?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setString(1, estudiante.getNombre());
			conexion.getSentencia().setString(2, estudiante.getDescripción());
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	
	
	public void deleteEstudiante() throws SQLException {
		int codCategoría = InputTypesUniversidad.readInt("Código de categoría: ", scanner);
		String sql = "delete " + "from categoría " + "where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codCategoría);
		conexion.modificacion();
	}
	
	public void update() throws EstudianteNoRegistrado, SQLException {
		ResultSet resultSet;
		Estudiante estudiante;
		String nombre;
		String descripción;
		int codCategoría = InputTypesUniversidad.readInt("Código de categoría: ", scanner);
		String sql = "select * from categoría where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codCategoría);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			nombre = resultSet.getString("nombre");
			descripción = resultSet.getString("descripción");
			estudiante = new Estudiante(codigoEstudiante,codigoCuenta, Nombre,Apellido, CI, fechaNacimiento, telefono, Direccion, PAA, Semestre, Campus, Carrera);
		} else {
			throw new EstudianteNoRegistrado();
		}

		System.out.println(categoría);
		Menú.menúModificar(scanner, categoría);

		sql = "update categoría set nombre = ?, descripción = ? where código = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setString(1, categoría.getNombre());
		conexion.getSentencia().setString(2, categoría.getDescripción());
		conexion.getSentencia().setInt(3, categoría.getCodCategoría());
		conexion.modificacion();
	}
	public void listarEstudiate() throws SQLException {
		Estudiante estudiante;
		String sql = "select * from categoría ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			estudiante = new Estudiante(resultSet.getInt("código"), resultSet.getString("nombre"),
					resultSet.getString("descripción"));
			System.out.println(estudiante);
		}
	}
}
