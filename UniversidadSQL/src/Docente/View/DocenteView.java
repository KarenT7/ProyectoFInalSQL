package Docente.View;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public void addDocente() throws SQLException {
		Docente docente = RegistroDocente.ingresarDocente(scanner);
		String sql = "Insert into docente ( Nombres,Apellidos,Titulacion,SeguroMedico,FechaDeNacimiento,Celular) "
				+ "values(?,?,?,?,?,?)";
			conexion.consulta(sql);
		//conexion.getSentencia().setInt(1, docente.getCodigoDocente());
			conexion.getSentencia().setString(1, docente.getNombre());
			conexion.getSentencia().setString(2, docente.getApellido());
			conexion.getSentencia().setString(3, docente.getGradoDeTitulacion());
			conexion.getSentencia().setInt(4, docente.getSeguroMedico());
			conexion.getSentencia().setDate(5, new  java.sql.Date( docente.getFechaNacimiento().getTime()));
			conexion.getSentencia().setInt(6, docente.getCelular());
			conexion.modificacion();
		
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
		String nombre;
		String apellido;
		String gradoTitulacion;
		int seguroMedico;
		Date fechaNacimiento;
		int celular;
		int codigoDocente = InputTypes.readInt("C�digo del docente: ", scanner);
		String sql = "select * from docente where CodigoDocente = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoDocente);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			nombre = resultSet.getString("Nombres");
			apellido = resultSet.getString("Apellidos");
			fechaNacimiento = resultSet.getDate("FechaDeNacimiento");
			celular = resultSet.getInt("Celular");
			gradoTitulacion = resultSet.getString("Titulacion");
			seguroMedico = resultSet.getInt("SeguroMedico");

			docente = new Docente(codigoDocente, nombre, apellido, gradoTitulacion, seguroMedico, fechaNacimiento, celular);
		} else {
			throw new DocenteSinRegistro();
		}

		System.out.println(docente);
		MenuDocente.ModificarDocente(scanner, docente);
		sql = "update docente set Nombres = ?, Apellidos = ?, FechaDeNacimiento = ?, Celular = ?, Titulacion = ?, SeguroMedico = ? , where CodigoDocente = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, docente.getCodigoDocente());
		conexion.getSentencia().setString(2, docente.getNombre());
		conexion.getSentencia().setString(3, docente.getApellido());
		conexion.getSentencia().setString(4, docente.getGradoDeTitulacion());
		conexion.getSentencia().setInt(5, docente.getSeguroMedico());
		conexion.getSentencia().setDate(6, (java.sql.Date) docente.getFechaNacimiento());
		conexion.getSentencia().setInt(7, docente.getCelular());
		conexion.modificacion();
	}

	public void listarDocente() throws SQLException {
		Docente docente;
		String sql = "select * from docente ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			docente = new Docente(resultSet.getInt("CodigoDocente"), resultSet.getString("Nombres"),
					resultSet.getString("Apellidos"),resultSet.getString("Titulacion"), resultSet.getInt("SeguroMedico"), resultSet.getDate("FechaDeNacimiento"),
					 resultSet.getInt("Celular"));
			System.out.println(docente);
		}
	}
}
