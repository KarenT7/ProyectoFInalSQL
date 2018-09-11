package Estudiante.View;

import java.util.Scanner;



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
	public static void menuEstudiante(Scanner scanner, EstudiantesView EstudiantesView) {
		
		boolean salir=false;
		while(!salir)
		{
			switch(encabezadoMenuEstudiante(scanner))
			{
			case 0:
				salir=true;
				break;
			case 1:
				EstudiantesView.addEstudiante();
				break;
			case 2:
				EstudiantesView.listarEstudiate();
				break;
			case 3:
				try {
					EstudiantesView.deleteEstudiante();
				} catch (EstudianteNoRegistrado e) {
					System.out.println("El estudiante no se halla registrado");				}
				break;
			}
		}
	}

}
