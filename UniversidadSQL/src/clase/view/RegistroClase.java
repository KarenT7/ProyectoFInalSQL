package clase.view;

import java.util.Scanner;

import clase.entity.Cuenta;
import universidad.view.InputTypes;

public class RegistroClase {
	public static Cuenta ingresarClase(Scanner scanner)
	{
	
		int idClase=InputTypes.readInt("Ingrese su codigo de identificacion de la clase :", scanner);
		int codigoDocente=InputTypes.readInt("Ingrese el codigo  del docente :", scanner);
		int idSemestre=InputTypes.readInt("Ingrese el codigo de identificacion del semestre :", scanner);


		return new Cuenta(idClase, codigoDocente, idSemestre);
	}

}
