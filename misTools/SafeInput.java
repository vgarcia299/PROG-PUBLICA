package misTools;
/**
 * @author <b> victor <br> <hr>
 * Los métodos de esta clase se aseguran que se introduzca el tipo de dato deseado, evitando InputMismatchs. 
 * <hr> @metodos </b>
 * {@linkplain 	#Boolean	(java.util.Scanner)  Boolean() },
 * {@linkplain 	#Byte		(java.util.Scanner)  Byte()	   },
 * {@linkplain 	#Integer	(java.util.Scanner)  Integer() },
 * {@linkplain 	#Double		(java.util.Scanner)  Double()  },
 * {@linkplain 	#Long		(java.util.Scanner)  Long()	   },
 * {@linkplain 	#Float		(java.util.Scanner)  Float()   }
 * <br><br>
 * @see {@linkplain java.util.Scanner Scanner}
 * @see {@linkplain java.util.InputMismatchException Input Mismatch Exception}
 * @see {@linkplain <a href="https://tinyurl.com/docs-oracle-inputmismatch".html>(traducido) inputmismatch</a>}
 * @see {@linkplain <a href="https://tinyurl.com/docs-oracle-exceptions".html>(traducido) excepciones</a>}
 */
public class SafeInput {
	/**
	 * <b>Summary: metodo recursivo que asegura que se introduzca un boolean.<hr></b>
	 * 
	 * Si salta un {@linkplain java.util.InputMismatchException Input Mismatch} como resultado de introducir la variable 
	 * <b>(Y SÓLO al introducir la variable!!!!)</b> muestra un mensaje de error y te pedirá que vuelvas a introducir 
	 * un valor hasta que el tipo de variable concuerde con la del metodo.
	 * 
	 * @param scanner	Scanner con el que queremos introducir el dato.
	 * 
	 * @return el valor del boolean introducido por el usuario.
	 */
	public static boolean Boolean(java.util.Scanner scanner) {
		try {
			return scanner.nextBoolean();
		
		} catch(java.util.InputMismatchException omegaF) {
			System.err.print("caught InputMismatchException... inténtalo de nuevo: ");
			scanner.next();
			return Boolean(scanner);
		}
	}
	 /**
	  * <b>Summary: metodo recursivo que asegura que se introduzca un char.<hr></b>
	  * 
	  * Si salta un {@linkplain java.util.InputMismatchException Input Mismatch} como resultado de introducir la variable 
	  * <b>(Y SÓLO al introducir la variable!!!!)</b> muestra un mensaje de error y te pedirá que vuelvas a introducir 
	  * un valor hasta que el tipo de variable concuerde con la del metodo.
	  * 
	  * @param scanner	Scanner con el que queremos introducir el dato.
	  * 
	  * @return el valor del char introducido por el usuario.
	  */
	public static char Character(java.util.Scanner scanner) {
		try {
			String auxiliar= scanner.next();
			if (auxiliar.length()!=1)
				throw new java.util.InputMismatchException();
			else
				return auxiliar.charAt(0);
			
		} catch(java.util.InputMismatchException omegaF) {
			System.err.print("caught InputMismatchException... inténtalo de nuevo: ");
			return Character(scanner);
		}
	}	
	 /**
	  * <b>Summary: metodo recursivo que asegura que se introduzca un String.<hr></b>
	  * 
	  * Si salta un {@linkplain java.util.InputMismatchException Input Mismatch} como resultado de introducir la variable 
	  * <b>(Y SÓLO al introducir la variable!!!!)</b> muestra un mensaje de error y te pedirá que vuelvas a introducir 
	  * un valor hasta que el tipo de variable concuerde con la del metodo.
	  * 
	  * @param scanner	Scanner con el que queremos introducir el dato.
	  * 
	  * @return el valor del String introducido por el usuario.
	  */
	public static String String(java.util.Scanner scanner) {
		try {
			return scanner.nextLine();
			
		} catch(java.util.InputMismatchException omegaF) {
			System.err.print("caught InputMismatchException... inténtalo de nuevo: ");
			return String(scanner);
		}
	}	
	/**
	 * <b>Summary: metodo recursivo que asegura que se introduzca un byte.<hr></b>
	 * 
	 * Si salta un {@linkplain java.util.InputMismatchException Input Mismatch} como resultado de introducir la variable 
	 * <b>(Y SÓLO al introducir la variable!!!!)</b> muestra un mensaje de error y te pedirá que vuelvas a introducir 
	 * un valor hasta que el tipo de variable concuerde con la del metodo.
	 * 
	 * @param scanner	Scanner con el que queremos introducir el dato.
	 * 
	 * @return el valor del byte introducido por el usuario.
	 */
	public static byte Byte(java.util.Scanner scanner) {
		try {
			return scanner.nextByte();
		
		} catch(java.util.InputMismatchException omegaF) {
			System.err.print("caught InputMismatchException... inténtalo de nuevo: ");
			scanner.next();
			return Byte(scanner);
		}
	}	
	/**
	 * <b>Summary: metodo recursivo que asegura que se introduzca un int.<hr></b>
	 * 
	 * Si salta un {@linkplain java.util.InputMismatchException Input Mismatch} como resultado de introducir la variable 
	 * <b>(Y SÓLO al introducir la variable!!!!)</b> muestra un mensaje de error y te pedirá que vuelvas a introducir 
	 * un valor hasta que el tipo de variable concuerde con la del metodo.
	 * 
	 * @param scanner	Scanner con el que queremos introducir el dato.
	 * 
	 * @return el valor del int introducido por el usuario.
	 */
	public static int Integer(java.util.Scanner scanner) {
		try {
			return scanner.nextInt();
		
		} catch(java.util.InputMismatchException omegaF) {
			System.err.print("caught InputMismatchException... inténtalo de nuevo: ");
			scanner.next();
			return Integer(scanner);
		}
	}	
	/**
	 * <b>Summary: metodo recursivo que asegura que se introduzca un double.<hr></b>
	 * 
	 * Si salta un {@linkplain java.util.InputMismatchException Input Mismatch} como resultado de introducir la variable 
	 * <b>(Y SÓLO al introducir la variable!!!!)</b> muestra un mensaje de error y te pedirá que vuelvas a introducir 
	 * un valor hasta que el tipo de variable concuerde con la del metodo.
	 * 
	 * @param scanner	Scanner con el que queremos introducir el dato.
	 * 
	 * @return el valor del double introducido por el usuario.
	 */
	public static double Double(java.util.Scanner scanner) {
		try {
			return scanner.nextDouble();
		
		} catch(java.util.InputMismatchException omegaF) {
			System.err.print("caught InputMismatchException... inténtalo de nuevo: ");
			scanner.next();
			return Double(scanner);
		}
	}
	/**
	 * <b>Summary: metodo recursivo que asegura que se introduzca un long.<hr></b>
	 * 
	 * Si salta un {@linkplain java.util.InputMismatchException Input Mismatch} como resultado de introducir la variable 
	 * <b>(Y SÓLO al introducir la variable!!!!)</b> muestra un mensaje de error y te pedirá que vuelvas a introducir 
	 * un valor hasta que el tipo de variable concuerde con la del metodo.
	 * 
	 * @param scanner	Scanner con el que queremos introducir el dato.
	 * 
	 * @return el valor del long introducido por el usuario.
	 */
	public static long Long(java.util.Scanner scanner) {
		try {
			return scanner.nextLong();
		
		} catch(java.util.InputMismatchException omegaF) {
			System.err.print("caught InputMismatchException... inténtalo de nuevo: ");
			scanner.next();
			return Long(scanner);
		}
	}
	/**
	 * <b>Summary: metodo recursivo que asegura que se introduzca un float.<hr></b>
	 * 
	 * Si salta un {@linkplain java.util.InputMismatchException Input Mismatch} como resultado de introducir la variable 
	 * <b>(Y SÓLO al introducir la variable!!!!)</b> muestra un mensaje de error y te pedirá que vuelvas a introducir 
	 * un valor hasta que el tipo de variable concuerde con la del metodo.
	 * 
	 * @param scanner	Scanner con el que queremos introducir el dato.
	 * 
	 * @return el valor del float introducido por el usuario.
	 */
	public static float Float(java.util.Scanner scanner) {
		try {
			return scanner.nextFloat();
		
		} catch(java.util.InputMismatchException omegaF) {
			System.err.print("caught InputMismatchException... inténtalo de nuevo: ");
			scanner.next();
			return Float(scanner);
		}
	}		
	
}