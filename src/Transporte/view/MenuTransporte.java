package Transporte.view;

import java.sql.SQLException;
import java.util.Scanner;

import Control.Conexion;
import General.InputTypesUniversidad;
import Transporte.entity.Transporte;
import Transporte.entity.VehiculoNoRegistrado;

public class MenuTransporte {
	private static int encabezadoMenuVehiculo(Scanner scanner)
	{
		int opcion;
		while(true)
		{
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1.Ingresar Vehiculo: ");
			System.out.println("2.Listar Vehiculo: ");
			System.out.println("3.Eliminar Vehiculo:");
			System.out.println("4.Modificar Vehiculo:");
			System.out.println("0.Salir");
			System.out.println();

			opcion=InputTypesUniversidad.readInt("¿Su Opcion?", scanner);
			if(opcion >=0 && opcion<=4)
			{return opcion;}
		}

	}
	public static void menuTransporte(Scanner scanner) throws ClassNotFoundException, SQLException {
		Conexion conexión = new Conexion("root","","universidaddatabase");
		TransporteView transporteView=new TransporteView(conexión, scanner);
		boolean salir=false;
		while(!salir)
		{
			switch(encabezadoMenuVehiculo(scanner))
			{
			case 0:
				salir=true;
				break;
			case 1:
				transporteView.addVehiculo();
				break;
			case 2:
				try {
					transporteView.listarVehiculo();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case 3:
				try {
					transporteView.deleteVehiculo();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					transporteView.updateVehiculo();
				} catch (VehiculoNoRegistrado e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static int encabezadoModificarVehiculo(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar Codigo del vehiculo");
			System.out.println("2. Modificar Codigo del estudiante ");
			System.out.println("3. Modificar la placa ");
			System.out.println("4. Modificar la marca ");
			System.out.println("5. Modificar el color ");
			System.out.println("6. Modificar el estado del soat ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypesUniversidad.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 6) {
				return opcion;
			}
		}
	}
	public static void ModificarVehiculo(Scanner scanner, Transporte transporte) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificarVehiculo(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				transporte.setCodigoVehiculo(InputTypesUniversidad.readInt("Ingrese el nuevo codigo del vehiculo: ", scanner));
				break;
			case 2:
				transporte.setCodigoEstudiante(InputTypesUniversidad.readInt("Ingrese el nuevo codigo de Estudiante: ", scanner));
				break;
			case 3:
				transporte.setPlaca(InputTypesUniversidad.readString("Ingrese la nueva placa: ", scanner));
				break;
			case 4:
				transporte.setMarca(InputTypesUniversidad.readString("Ingrese la nueva marca: ", scanner));
				break;
			case 5:
				transporte.setColor(InputTypesUniversidad.readString("Ingrese el nuevo Color: ", scanner));
				break;
			case 6:
				transporte.setSoat(InputTypesUniversidad.readBoolean("Ingrese el nuevo estado del soat: ", scanner));
				break;


			}

		}

	}
}
