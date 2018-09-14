package Horario.view;

import java.sql.SQLException;
import java.util.Scanner;

import Control.Conexion;
import Docente.entity.Docente;
import Docente.entity.DocenteSinRegistro;
import Etudiante.entity.Estudiante;
import Etudiante.entity.EstudianteNoRegistrado;
import General.InputTypesUniversidad;
import Horario.entity.Horario;

public class MenuHorario {
	private static int encabezadoMenuHorario(Scanner scanner)
	{
		int opcion;
		while(true)
		{
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1.Ingresar Horario: ");
			System.out.println("2.Listar Horarios: ");
			System.out.println("3.Eliminar Horario:");
			System.out.println("4.Modificar Horario:");
			System.out.println("0.Salir");
			System.out.println();

			opcion=InputTypesUniversidad.readInt("¿Su Opcion?", scanner);
			if(opcion >=0 && opcion<=4)
			{return opcion;}
		}

	}
	public static void menuHorario(Scanner scanner) throws ClassNotFoundException, SQLException {
		Conexion conexión = new Conexion("root","","universidaddatabase");
		HorarioView horarioView=new HorarioView(conexión, scanner);
		boolean salir=false;
		while(!salir)
		{
			switch(encabezadoMenuHorario(scanner))
			{
			case 0:
				salir=true;
				break;
			case 1:
				horarioView.addHorario();
				break;
			case 2:
				try {
					horarioView.listarHorario();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case 3:
				try {
					horarioView.deleteHorario();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					horarioView.updateHorario();
				} catch (DocenteSinRegistro e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static int encabezadoModificarHorario(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar Codigo del horario");
			System.out.println("2. Modificar Paralelo ");
			System.out.println("3. Modificar IdClase ");
			System.out.println("4. Modificar Modalidad ");
			System.out.println("5. Modificar Fecha de Inicio ");
			System.out.println("6. Modificar Fecha Final ");
            System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypesUniversidad.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 6) {
				return opcion;
			}
		}
	}
	public static void ModificarHorario(Scanner scanner, Horario horario) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificarHorario(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				horario.setCodigoHorario(InputTypesUniversidad.readInt("Ingrese el nuevo codigo del horario: ", scanner));
				break;
			case 2:
				horario.setParalelo(InputTypesUniversidad.readString("Ingrese el nuevo paralelo: ", scanner));
				break;
			case 3:
				horario.setIdClase(InputTypesUniversidad.readInt("Ingrese el nuevo nidentificador de la clase: ", scanner));
				break;
			case 4:
				horario.setModalidad(InputTypesUniversidad.readString("Ingrese la nueva modalidad: ", scanner));
				break;
			case 5:
				horario.setFechaInicion(InputTypesUniversidad.leerFecha("Ingrese la nueva fecha de inicio: ", scanner));
				break;
			case 6:
				horario.setFechaFinal(InputTypesUniversidad.leerFecha("Ingrese la nueva fecha de finalizacion: ", scanner));
				break;
				
			}

}
	
	}}
