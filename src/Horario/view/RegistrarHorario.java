package Horario.view;

import java.sql.Date;
import java.util.Scanner;

import Docente.entity.Docente;
import General.InputTypesUniversidad;
import Horario.entity.Horario;

public class RegistrarHorario {
	public static Horario ingresarHorario(Scanner scanner)
	{
		int codigoHorario=InputTypesUniversidad.readInt("Ingrese su codigo de estudiante:", scanner);
		String paralelo=InputTypesUniversidad.readString("Nombre:", scanner);
		int IdClase=InputTypesUniversidad.readInt("Carnet de Identidad:", scanner);
		String modalidad=InputTypesUniversidad.readString("Apellido: ", scanner);
		Date fechaInicio=InputTypesUniversidad.leerFecha("Fecha de nacimiento:", scanner);
		Date fechaFinal=InputTypesUniversidad.leerFecha("Telefono:", scanner);
		
		return new Horario(codigoHorario, paralelo,IdClase, modalidad, fechaInicio, fechaFinal);
	}

}
