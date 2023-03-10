package misTools;
/**
 * @author victor
 * Excepcion generica definida por uno mismo.
 */
public class CustomException extends Exception {
	
	private static final long serialVersionUID = 34390014111499493L;
	
	public CustomException() {
		super("Excepción Genérica. Probablemente haya saltado x fallo lógico.");
	}
	public CustomException(Throwable t) {
		super(t);
	}
	public CustomException(String descripcion) {
		super(descripcion);
	}
	public CustomException(String descripcion, Throwable t) {
		super(descripcion, t);
	}
	public CustomException(String descripcion, Throwable t, boolean enableSuppression, boolean writableStackTrace) {
		super(descripcion, t, enableSuppression, writableStackTrace);
	}

}
