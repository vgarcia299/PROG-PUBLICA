package misTools;
/**
 * Excepcion generica que salta cuando algo se hace de una forma indeseada.
 * @author victor
 */
public class CustomException extends Exception {
	private static final long serialVersionUID = 34390014111499493L;
	public CustomException() {
		super("Excepción Genérica. Probablemente haya saltado x fallo lógico.");
	}
	public CustomException(String descripcion) {
		super("descripcion");
	}
}
