package Horario.view;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Control.Conexion;
import Docente.entity.DocenteSinRegistro;
import General.InputTypesUniversidad;
import Horario.entity.Horario;

public class HorarioView {
	private Conexion conexion;
	private Scanner scanner;
	public HorarioView(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}
	public void addHorario() {
		Horario horario = RegistrarHorario.ingresarHorario(scanner);
		String sql = "Insert into horario (CodigoHorario, Paralelo,IdClase,Modalidad,FechaInicio,FechaFinal) " + "values(?,?,?,?,?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, horario.getCodigoHorario());
			conexion.getSentencia().setString(2, horario.getParalelo());
			conexion.getSentencia().setInt(3, horario.getIdClase());
			conexion.getSentencia().setString(4, horario.getModalidad());
			conexion.getSentencia().setDate(5, horario.getFechaInicion());
			conexion.getSentencia().setDate(6, horario.getFechaFinal());
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}


	public void deleteHorario() throws SQLException {
		int codigoHorario = InputTypesUniversidad.readInt("C�digo del horario: ", scanner);
		String sql = "delete " + "from horarios " + "where c�digo = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoHorario);
		conexion.modificacion();
	}
	//teamviewer

	public void updateHorario() throws  SQLException, DocenteSinRegistro {
		ResultSet resultSet;
		Horario horario;
		String Paralelo;
		String Modalidad;	
		int IdClase;
		Date fechaInicio;
		Date fechaFinal;	
		int codigoHorario = InputTypesUniversidad.readInt("C�digo del horario: ", scanner);
		String sql = "select * from horarios where c�digo = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoHorario);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			Paralelo = resultSet.getString("Paralelo");
			Modalidad = resultSet.getString("Modalidad");
			IdClase=resultSet.getInt("IdClase");
			fechaInicio=resultSet.getDate("FechaInicio");
			fechaFinal=resultSet.getDate("FechaFinal");

			horario = new Horario(codigoHorario, Paralelo,IdClase, Modalidad, fechaInicio,fechaFinal);
		} else {
			throw new DocenteSinRegistro();
		}

		System.out.println(horario);
		MenuHorario.ModificarHorario(scanner, horario);
		sql = "update horarios set nombre = ?, descripci�n = ? where c�digo = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, horario.getCodigoHorario());
		conexion.getSentencia().setString(2, horario.getParalelo());
		conexion.getSentencia().setString(3, horario.getModalidad());
		conexion.getSentencia().setInt(4, horario.getIdClase());
		conexion.getSentencia().setDate(5, horario.getFechaInicion());
		conexion.getSentencia().setDate(6, horario.getFechaFinal());
		conexion.modificacion();
	}
	public void listarHorario() throws SQLException {
		Horario horario;
		String sql = "select * from horarios ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			horario = new Horario(resultSet.getInt("CodigoHorario"),
					resultSet.getString("Paralelo"),
					resultSet.getInt("IdClase"),
					resultSet.getString("Modalidad"),
					resultSet.getDate("FechaInicio"),
					resultSet.getDate("FechaFinal"));
			System.out.println(horario);
		}
	}
}
