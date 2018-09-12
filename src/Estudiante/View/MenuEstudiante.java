package Estudiante.View;

import java.sql.SQLException;
import java.util.Scanner;

import Control.Conexion;
import Etudiante.entity.Estudiante;
import Etudiante.entity.EstudianteNoRegistrado;
import General.InputTypesUniversidad;

public class MenuEstudiante {
	private static int encabezadoMenuEstudiante(Scanner scanner)
	{
		int opcion;
		while(true)
		{
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1.Ingresar Estudiante: ");
			System.out.println("2.Listar Estudiantes: ");
			System.out.println("3.Eliminar Estudiante:");
			System.out.println("0.Salir");
			System.out.println();

			opcion=InputTypesUniversidad.readInt("¿Su Opcion?", scanner);
			if(opcion >=0 && opcion<=3)
			{return opcion;}
		}

	}
	public static void menuEstudiante(Scanner scanner) throws ClassNotFoundException, SQLException {
		Conexion conexión = new Conexion("root","","universidaddatabase");
		EstudiantesView estudiantesView=new EstudiantesView(conexión, scanner);
		boolean salir=false;
		while(!salir)
		{
			switch(encabezadoMenuEstudiante(scanner))
			{
			case 0:
				salir=true;
				break;
			case 1:
				estudiantesView.addEstudiante();
				break;
			case 2:
				try {
					estudiantesView.listarEstudiate();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case 3:
				try {
					estudiantesView.deleteEstudiante();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}
	private static int encabezadoModificarEstudiante(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar Codigo de Estudiante");
			System.out.println("2. Modificar Codigo de Cuenta ");
			System.out.println("3. Modificar Nombres ");
			System.out.println("4. Modificar Apellidos ");
			System.out.println("5. Modificar Fecha de Nacimiento ");
			System.out.println("6. Modificar Telefono ");
			System.out.println("7. Modificar Direccion ");
			System.out.println("8. Modificar PAA ");
			System.out.println("9. Modificar CI ");
			System.out.println("10. Modificar IdClase ");
            System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypesUniversidad.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}
	public static void ModificarEstudiante(Scanner scanner, Estudiante estudiante) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificarEstudiante(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				estudiante.setCodigoEstudiante(InputTypesUniversidad.readInt("Ingrese el nuevo codigo de Estudiante: ", scanner));
				break;
			case 2:
				estudiante.setCodigoCuenta(InputTypesUniversidad.readInt("Ingrese el nuevo codigo de Cuenta: ", scanner));
				break;
			case 3:
				estudiante.setNombre(InputTypesUniversidad.readString("Ingrese el nuevo nombre: ", scanner));
				break;
			case 4:
				estudiante.setApellido(InputTypesUniversidad.readString("Ingrese el nuevo Apellido: ", scanner));
				break;
				
			case 5:
				estudiante.setFechaNacimiento(InputTypesUniversidad.readInt("Ingrese la nueva fecha de nacimiento: ", scanner));
				break;
			case 6:
				estudiante.setTelefono(InputTypesUniversidad.readInt("Ingrese el nuevo telefono: ", scanner));
				break;
			case 7:
				estudiante.setDireccion(InputTypesUniversidad.readString("Ingrese la nueva Direccion: ", scanner));
				break;
			case 8:
				estudiante.setPAA(InputTypesUniversidad.readBoolean("Ingrese el nuevo estado de la PAA: ", scanner));
				break;
			case 9:
				estudiante.setCI(InputTypesUniversidad.readInt("Ingrese el nuevo Carnet de Estudiante: ", scanner));
				break;
			case 10:
				estudiante.setIdCLase(InputTypesUniversidad.readInt("Ingrese el nuevo codigo de clase: ", scanner));
				break;
				
			}

}
	
	}}
