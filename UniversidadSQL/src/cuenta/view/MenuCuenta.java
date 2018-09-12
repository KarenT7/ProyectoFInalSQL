package cuenta.view;

import java.sql.SQLException;
import java.util.Scanner;


import clase.entity.Cuenta;
import clase.entity.NoExisteClase;
import universidad.view.InputTypes;

public class MenuCuenta {
	private static int encabezadoMenuClase(Scanner scanner) {
		int opcion;
		while (true) {
			System.out.println("--------------------------------------");
			System.out.println("	Ingrese una opcion	: ");
			System.out.println("--------------------------------------");
			System.out.println("1.Ingresar Clase: ");
			System.out.println("2.Listar Clase: ");
			System.out.println("3.Eliminar Clase:");
			System.out.println("4. Modificar Clase ");
			// System.out.println("5. Productos por Categor�a ");
			System.out.println("0.Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su Opcion?", scanner);
			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}

	}

	public static void menuClase(Scanner scanner, CuentaView claseV) {

		boolean salir = false;
		while (!salir) {
			switch (encabezadoMenuClase(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				claseV.addCuenta();
				break;
			case 2:
				try {
					claseV.listarClase();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				break;
			case 3:
				try {
					claseV.deleteCuenta();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			case 4:
				try {
					claseV.updateCuenta();
				} catch (NoExisteClase | SQLException e) {
					System.out.println("No existe clase!");
				}
				break;
			/*
			 * case 5:try { claseV.listarClase(); }catch( NoExisteClase e) {
			 * System.out.println("No existe clase!"); }break;
			 */
			}
		}
	}

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("--------------------------------------");
			System.out.println("	Ingrese una opcion	: ");
			System.out.println("--------------------------------------");
			System.out.println("1. Modificar codigo docente");
			System.out.println("2. Modificar la identificacion del semestre ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	public static void menuModificar(Scanner scanner, Cuenta clase) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				clase.setCodigoDocente(InputTypes.readInt("Ingrese el nuevo codigo del docente: ", scanner));
				break;
			case 2:
				clase.setIdSemestre(
						InputTypes.readInt("Ingrese el nuevo codigo de identificacion del semestre: ", scanner));
				break;
			}
		}
	}
}