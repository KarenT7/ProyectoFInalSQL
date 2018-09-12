package Estudiante.View;

import java.util.Scanner;

import Etudiante.entity.Estudiante;
import General.InputTypesUniversidad;

public class RegistroEstudiante {
	public static Estudiante ingresarEstudiante(Scanner scanner)
	{
		int codigoEstudiante=InputTypesUniversidad.readInt("Ingrese su codigo de estudiante:", scanner);
		int codigoCuenta=InputTypesUniversidad.readInt("Ingrese el numero de cuenta:", scanner);
		String Nombre=InputTypesUniversidad.readString("Nombre:", scanner);
		String Apellido=InputTypesUniversidad.readString("Apellido: ", scanner);
		int CI=InputTypesUniversidad.readInt("Carnet de Identidad:", scanner);
		int fechaNacimiento=InputTypesUniversidad.readInt("Fecha de nacimiento:", scanner);
		int telefono=InputTypesUniversidad.readInt("Telefono:", scanner);
		String Direccion=InputTypesUniversidad.readString("Direccion:", scanner);
        boolean PAA=InputTypesUniversidad.readBoolean("Dio la Prueba de Aptitud Academica? true(si)/false(no)", scanner);
        int IdClase=InputTypesUniversidad.readInt("Codigo de la clase:", scanner);				

		return new Estudiante(codigoEstudiante,codigoCuenta, Nombre,Apellido, fechaNacimiento, telefono, Direccion, PAA, CI, IdClase);
	}

}
