package clase.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import clase.entity.Clase;
import clase.entity.NoExisteClase;
import universidad.control.Conexion;
import universidad.view.InputTypes;

public class ClasesView {
	private Conexion conexion;
	private Scanner scanner;

	public ClasesView(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void addClase() {
		Clase clase = RegistroClase.ingresarClase(scanner);
			String sql = "Insert into clase ( CodigoDocente, IdSemestre)" + "values(?,?)";
			try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, clase.getIdClase());
			conexion.getSentencia().setInt(2, clase.getCodigoDocente());
			conexion.getSentencia().setInt(3, clase.getIdSemestre());
			conexion.modificacion();
			} catch (SQLException e) {
				System.out.println(e.getSQLState());
			}
}
	
		public void deleteClase() throws SQLException {
			int idClase = InputTypes.readInt("C�digo identificacion de la clase: ", scanner);
			String sql = "delete " + "from clase " + "where idClase = ?";
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, idClase);
			conexion.modificacion();

		}

	

	public void updateClase() throws NoExisteClase, SQLException {
		ResultSet resultSet;
		Clase clase;
		int  codigoDocente;
		int idSemestre;
		int idClase = InputTypes.readInt("Identificacion del C�digo de la Clase: ", scanner);
		String sql = "select * from clase where IdClase = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, idClase);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			codigoDocente = resultSet.getInt("CodigoDocente");
			idSemestre = resultSet.getInt("IdSemestre");
			clase = new Clase(idClase, codigoDocente , idSemestre);
		} else {
			throw new NoExisteClase();
		}

		System.out.println(clase);
		MenuClase.menuModificar(scanner, clase);

		sql = "update clase set codigoDocente = ?, idSemestre = ? where IdClase = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, clase.getCodigoDocente());
		conexion.getSentencia().setInt(2, clase.getIdSemestre());
		conexion.getSentencia().setInt(2, clase.getIdClase());

		conexion.modificacion();
	}

	public void listarClase() throws SQLException {
		Clase clase;
		String sql = "select * from clase ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			clase = new Clase(resultSet.getInt("IdClase"), resultSet.getInt("CodigoDocente"),
					resultSet.getInt("IdSemestre"));
			System.out.println(clase);
		}
	}
}
