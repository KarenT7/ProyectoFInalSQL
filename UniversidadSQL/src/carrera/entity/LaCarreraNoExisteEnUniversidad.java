package carrera.entity;

public class LaCarreraNoExisteEnUniversidad extends Exception {
	private static final long serialVersionUID = 1L;

	public LaCarreraNoExisteEnUniversidad() {
		super("La carrera no  existe en esta universidad ");
	}


}
