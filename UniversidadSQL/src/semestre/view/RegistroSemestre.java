package semestre.view;

import java.util.Date;
import java.util.Scanner;

import semestre.entity.Semestre;
import universidad.view.InputTypes;

public class RegistroSemestre {
	public static Semestre ingresarSemestre(Scanner scanner)
	{
	
		int idSemestre=InputTypes.readInt("Ingrese el codigo de identificacion del semestre :", scanner);
		int modulo =InputTypes.readInt("Ingrese el  modulo del semestre :", scanner);
		Date anio=InputTypes.readDate("Ingrese el anio del semestre  :", scanner);

		return new Semestre( idSemestre, modulo, anio);
	}

}
