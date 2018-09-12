package cuenta.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import cuenta.entity.Cuenta;
import cuenta.entity.NoExisteCuenta;
import universidad.control.Conexion;
import universidad.view.InputTypes;

public class CuentaView {
	private Conexion conexion;
	private Scanner scanner;

	public CuentaView(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void addCuenta() {
		Cuenta cuenta = RegistroCuenta.ingresarCuenta(scanner);
			String sql = "Insert into Clase ( saldoApagar, importePagado, descuentoBeca, planDePagos)" + "values(?,?,?,?)";
			try {
			conexion.consulta(sql);
			conexion.getSentencia().setDouble(1, cuenta.getSaldoApagar());
			conexion.getSentencia().setDouble(2, cuenta.getImportePagado());
			conexion.getSentencia().setDouble(3, cuenta.getDescuentoBeca());
			conexion.getSentencia().setString(4, cuenta.getPlanDePagos());

			conexion.modificacion();
			} catch (SQLException e) {
				System.out.println(e.getSQLState());
			}
}
	
		public void deleteCuenta() throws SQLException {
			int codigoCuenta = InputTypes.readInt("Código identificacion de la cuenta: ", scanner);
			String sql = "delete " + "from cuenta " + "where codigo = ?";
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, codigoCuenta);
			conexion.modificacion();
		}


	public void updateCuenta() throws NoExisteCuenta, SQLException {
		ResultSet resultSet;
		Cuenta cuenta;
		double  saldoApagar;
		double importePagado;
		double descuentoBeca;
		String planDePagos;
		int codigoCuenta = InputTypes.readInt("Identificacion del Código de la Clase: ", scanner);
		String sql = "select * from clase where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoCuenta);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			saldoApagar = resultSet.getInt("codigo del docente");
			importe = resultSet.getInt("codigo identificacion del semestre");
			cuenta = new Cuenta(codigoCuenta, saldoApagar , importe, notaFinal);
		} else {
			throw new NoExisteClase();
		}

		System.out.println(clase);
		MenuCuenta.menuModificar(scanner, clase);

		sql = "update clase set codigoDocente = ?, idSemestre = ? where id = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, clase.getCodigoDocente());
		conexion.getSentencia().setInt(2, clase.getIdSemestre());
		conexion.modificacion();
	}

	public void listarClase() throws SQLException {
		Cuenta clase;
		String sql = "select * from clase ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			clase = new Cuenta(resultSet.getInt("id Clase"), resultSet.getInt("codigo Docente"),
					resultSet.getInt("id Semestre"));
			System.out.println(clase);
		}
	}
}
