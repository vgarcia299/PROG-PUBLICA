package misTools;
/**
 * Excepcion generica que salta cuando algo se hace de una forma indeseada.
 * @author victor
 */
public class CheckedException extends Exception {
	private static final long serialVersionUID = 34390014111499493L;
	public CheckedException() {
		super("Excepción Genérica. Probablemente haya saltado x fallo lógico.");
	}
	public CheckedException(String descripcion) {
		super("descripcion");
	}
}