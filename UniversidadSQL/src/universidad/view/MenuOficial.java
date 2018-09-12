package universidad.view;

import java.sql.SQLException;
import java.util.Scanner;

import clase.view.ClasesView;
import universidad.control.Conexion;


public class MenuOficial {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("****************************************************************************************");
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("		        	Ingrese una opcion  : 			");
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("****************************************************************************************");

			System.out.println("1. Clase");
		//	System.out.println("2. Producto ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 1) {
				return opcion;
			}
		}
	}


	public static void menú(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;
		
		Conexion conexión = new Conexion("root","","universidad");
		ClasesView claseV = new ClasesView(conexión, scanner);
		//ProductosIO productosIO = new ProductosIO(conexión, scanner);
		
		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				clase.view.MenuClase.menuClase(scanner, claseV);
				break;
			/*case 2:
				producto.view.MenuOficial.menú(scanner, productosIO);
				break;
		
			*/}
		}
		conexión.close();
	}
}
