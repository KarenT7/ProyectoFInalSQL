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
			String sql = "Insert into cuenta( SaldoPagar, ImportePagado, DescuentoBeca, PlanDePagos)" + "values(?,?,?,?)";
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
			String sql = "delete " + "from cuenta " + "where CodigoCuenta = ?";
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
		int codigoCuenta = InputTypes.readInt("Identificacion del Código de la cuenta: ", scanner);
		String sql = "select * from cuenta where CodigoCuenta = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoCuenta);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			saldoApagar = resultSet.getDouble("SaldoPagar");
			importePagado = resultSet.getDouble("ImportePagado");
			descuentoBeca = resultSet.getDouble("DescuentoBeca");
			planDePagos = resultSet.getString("PlanDePagos");
			
			cuenta = new Cuenta(codigoCuenta, saldoApagar , importePagado, descuentoBeca, planDePagos);
		} else {
			throw new NoExisteCuenta();
		}

		System.out.println(cuenta);
		MenuCuenta.menuModificar(scanner, cuenta);

		sql = "update cuenta set SaldoPagar = ?, ImportePagado = ?, DescuentoBeca = ?, PlanDePagos = ?,  where CodigoCuenta = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setDouble(1, cuenta.getSaldoApagar());
		conexion.getSentencia().setDouble(2, cuenta.getImportePagado());
		conexion.getSentencia().setDouble(3, cuenta.getDescuentoBeca());
		conexion.getSentencia().setString(3, cuenta.getPlanDePagos());
		
		conexion.modificacion();
	}

	public void listarCuenta() throws SQLException {
		Cuenta cuenta;
		String sql = "select * from cuenta ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			cuenta = new Cuenta(resultSet.getInt("CodigoCuenta"),resultSet.getDouble("SaldoPagar"), resultSet.getDouble("ImportePagado"), resultSet.getDouble("DescuentoBeca"), resultSet.getString("PlanDePagos"));
			System.out.println(cuenta);
		}
	}
}
