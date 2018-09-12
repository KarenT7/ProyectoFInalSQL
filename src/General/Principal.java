package General;

import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			Estudiante.View.MenuEstudiante.menuEstudiante(scanner);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		scanner.close();
	}
	
}
