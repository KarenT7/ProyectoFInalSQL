package Docente.View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

import Docente.entity.Docente;
import Docente.entity.DocenteSinRegistro;
import universidad.control.Conexion;
import universidad.view.InputTypes;

public class DocenteView {
	private Conexion conexion;
	private Scanner scanner;

	public DocenteView(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void addDocente() {
		Docente docente = RegistroDocente.ingresarDocente(scanner);
		String sql = "Insert into docente ( Nombres,Apellidos,Titulacion,SeguroMedico,FechaDeNacimiento,Celular) "
				+ "values(?,?,?,?,?,?,?)";
		try {
			conexion.consulta(sql);
//			conexion.getSentencia().setInt(1, docente.getCodigoDocente());
			conexion.getSentencia().setString(1, docente.getNombre());
			conexion.getSentencia().setString(2, docente.getApellido());
			conexion.getSentencia().setString(3, docente.getGradoDeTitulacion());
			conexion.getSentencia().setInt(4, docente.getNumeroSeguroMedico());
			conexion.getSentencia().setInt(5, docente.getFechaNacimiento());
			conexion.getSentencia().setInt(6, docente.getCelular());
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	public void deleteDocente() throws SQLException {
		int codigoDocente = InputTypes.readInt("C�digo del docente: ", scanner);
		String sql = "delete " + "from docente " + "where CodigoDocente = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoDocente);
		conexion.modificacion();
	}

	public void updateDocente() throws SQLException, DocenteSinRegistro {
		ResultSet resultSet;
		Docente docente;
		String Nombre;
		String Apellido;
		String GradoTitulacion;
		int seguroMedico;
		int fechaNacimiento;
		int celular;
		int codigoDocente = InputTypes.readInt("C�digo del docente: ", scanner);
		String sql = "select * from docente where CodigoDocente = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoDocente);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			Nombre = resultSet.getString("Nombres");
			Apellido = resultSet.getString("Apellidos");
			fechaNacimiento = resultSet.getInt("FechaDeNacimiento");
			celular = resultSet.getInt("Celular");
			GradoTitulacion = resultSet.getString("Titulacion");
			seguroMedico = resultSet.getInt("SeguroMedico");

			docente = new Docente(codigoDocente, Nombre, Apellido, fechaNacimiento, celular, GradoTitulacion,
					seguroMedico);
		} else {
			throw new DocenteSinRegistro();
		}

		System.out.println(docente);
		MenuDocente.ModificarDocente(scanner, docente);
		sql = "update docente set Nombres = ?, Apellidos = ?, FechaDeNacimiento = ?, Celular = ?, Titulacion = ?, SeguroMedico = ? , where CodigoDocente = ?";

		conexion.consulta(sql);
//		conexion.getSentencia().setInt(1, docente.getCodigoDocente());
		conexion.getSentencia().setString(1, docente.getNombre());
		conexion.getSentencia().setString(2, docente.getApellido());
		conexion.getSentencia().setString(3, docente.getGradoDeTitulacion());
		conexion.getSentencia().setInt(4, docente.getNumeroSeguroMedico());
		conexion.getSentencia().setInt(5, docente.getFechaNacimiento());
		conexion.getSentencia().setInt(6, docente.getCelular());
		conexion.modificacion();
	}

	public void listarDocente() throws SQLException {
		Docente docente;
		String sql = "select * from docente ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			docente = new Docente(resultSet.getInt("CodigoDocente"), resultSet.getString("Nombres"),
					resultSet.getString("Apellidos"), resultSet.getInt("FechaNacimiento"),
					resultSet.getInt("SeguroMedico"), resultSet.getString("Titulacion"), resultSet.getInt("Celular"));
			System.out.println(docente);
		}
	}
}
