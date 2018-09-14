package Estudiante.View;

import java.util.Scanner;

import Estudiante.entity.Estudiante;
import universidad.view.InputTypes;



public class RegistroEstudiante {
	public static Estudiante ingresarEstudiante(Scanner scanner)
	{
		int codigoEstudiante=InputTypes.readInt("Ingrese su codigo de estudiante:", scanner);
		int codigoCuenta=InputTypes.readInt("Ingrese el numero de cuenta:", scanner);
		String Nombre=InputTypes.readString("Nombre:", scanner);
		String Apellido=InputTypes.readString("Apellido: ", scanner);
		int CI=InputTypes.readInt("Carnet de Identidad:", scanner);
		int fechaNacimiento=InputTypes.readInt("Fecha de nacimiento:", scanner);
		int telefono=InputTypes.readInt("Telefono:", scanner);
		String Direccion=InputTypes.readString("Direccion:", scanner);
        boolean PAA=InputTypes.readBoolean("Dio la Prueba de Aptitud Academica? true(si)/false(no)", scanner);
        int IdClase=InputTypes.readInt("Codigo de la clase:", scanner);				

		return new Estudiante(codigoEstudiante,codigoCuenta, Nombre,Apellido, fechaNacimiento, telefono, Direccion, PAA, CI, IdClase);
	}

}
