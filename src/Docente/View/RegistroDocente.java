package Docente.View;

import java.util.Scanner;

import Docente.entity.Docente;
import General.InputTypesUniversidad;

public class RegistroDocente {
	public static Docente ingresarDocente(Scanner scanner)
	{
		int codigoDocente=InputTypesUniversidad.readInt("Ingrese su codigo de estudiante:", scanner);
		String Nombre=InputTypesUniversidad.readString("Nombre:", scanner);
		String Apellido=InputTypesUniversidad.readString("Apellido: ", scanner);
		int CI=InputTypesUniversidad.readInt("Carnet de Identidad:", scanner);
		int fechaNacimiento=InputTypesUniversidad.readInt("Fecha de nacimiento:", scanner);
		int celular=InputTypesUniversidad.readInt("Telefono:", scanner);
		String titulacion=InputTypesUniversidad.readString("Direccion:", scanner);
        int numeroSeguroMedico=InputTypesUniversidad.readInt("Codigo de la clase:", scanner);				

		return new Docente(codigoDocente, Nombre,Apellido, fechaNacimiento, celular, titulacion, numeroSeguroMedico);
	}

}
