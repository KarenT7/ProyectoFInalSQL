package Materia.View;
import java.util.Scanner;
import General.InputTypesUniversidad;
import Materia.entity.Materia;

public class RegistrarMateria {
	public static Materia ingresarMateria(Scanner scanner)
	{
		int codigoMateria=InputTypesUniversidad.readInt("Ingrese el codigo de la materia:", scanner);
		int creditos=InputTypesUniversidad.readInt("Cantidad de creditos:", scanner);
		String estado=InputTypesUniversidad.readString("Aprobado/Reprobado/Cursando: ", scanner);
		int idCarrera=InputTypesUniversidad.readInt("Ingrese codigo de la carrera:", scanner);
		int idCLase=InputTypesUniversidad.readInt("Ingrese el codigo de la clase:", scanner);
		
		return new Materia(codigoMateria,creditos, estado, idCarrera, idCLase);
	}

}
