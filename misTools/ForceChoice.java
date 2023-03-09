package misTools;
/**
 * @author <b> victor <br> <hr>
 * Los métodos de esta clase se aseguran que se introduzca una o varias opcion(es) preestablecidas de un tipo de dato determinado.<br>
 * Evitaremos InputMismatchs usando los metodos correspondientes de {@linkplain SafeInput} 
 * <hr> @metodos </b>
 * {@linkplain #Boolean					(java.util.Scanner, boolean)				Boolean()				}, 
 * {@linkplain #Character				(java.util.Scanner, String)					Character()				},
 * {@linkplain #String	 				(java.util.Scanner, String, String...)		String()				}, 
 * {@linkplain #String_case_sensitive	(java.util.Scanner, String, String...)		String_case_sensitive()	}, 
 * {@linkplain #Byte					(java.util.Scanner, byte, byte...) 			Byte()					}, 
 * {@linkplain #Integer	 				(java.util.Scanner, int, int...) 			Integer()				}, 
 * {@linkplain #Double	 				(java.util.Scanner, double, double...) 		Double()				}, 
 * {@linkplain #Long	 				(java.util.Scanner, long, long...) 			Long()					},
 * {@linkplain #Float	 				(java.util.Scanner, float, float...)		Float()					}
 * <br><br>
 * @see {@linkplain SafeInput}
 */
public class ForceChoice {

	/**
	 * Método recursivo que, además de funcionar como SafeInput, solo acepta un valor que haya sido introducido por parámetros.
	 * @param scanner		Scanner con el que queremos introducir el dato.
	 * @param forcedBoolean	boolean que forzaremos a que introduzca el usuario.
	 * @return boolean introducido por el usuario.
	 * @see SafeInput#Boolean(java.util.Scanner)
	 */
	public static boolean Boolean(java.util.Scanner scanner, boolean forcedBoolean) {
		try {
			boolean choice= SafeInput.Boolean(scanner);		
			if (choice == forcedBoolean) 
				return choice;	
			else
				throw new CustomException();
									
		} catch (CustomException F) {
			System.err.print("caught CustomException... inténtalo de nuevo: ");
			return Boolean(scanner, forcedBoolean); 
		}		
	}

	/**
	 * Método recursivo que, además de funcionar como SafeInput, solo acepta un valor que haya sido introducido por parámetros.
	 * @param scanner		Scanner con el que queremos introducir el dato.
	 * @param forcedChars	String que contiene los chars que forzaremos a que introduzca el usuario.
	 * @return char introducido por el usuario.
	 * @see SafeInput#Character(java.util.Scanner)
	 */		
	public static char Character(java.util.Scanner scanner, String forcedChars) {
		try {
			char choice= SafeInput.Character(scanner);					
			for (char c:forcedChars.toCharArray())
				if (c==choice)
					return choice;
				
			throw new CustomException();
									
		} catch (CustomException F) {
			System.err.print("caught CustomException... inténtalo de nuevo: ");
			return Character(scanner, forcedChars); 
		}		
	}

	/**
	 * Método recursivo que, además de funcionar como SafeInput, solo acepta un valor que haya sido introducido por parámetros.
	 * @apiNote no es case-sensitive
	 * @param scanner		Scanner con el que queremos introducir el dato.
	 * @param forcedStr1	String que forzaremos a que introduzca el usuario.
	 * @param forcedStrs	Strings adicionales que tambien acepta el método.
	 * @return String introducido por el usuario.
	 * @see SafeInput#String(java.util.Scanner)
	 * @see #String_case_sensitive(java.util.Scanner, String, String...)
	 */
	public static String String(java.util.Scanner scanner, String forcedStr1, String...forcedStrs) {
		try {
			String choice= SafeInput.String(scanner).toLowerCase();		
			if (choice.equals(forcedStr1.toLowerCase()))
				return choice;	
			
			for (String str:forcedStrs)
				if (choice.equals(str.toLowerCase()))
					return choice;
				
			throw new CustomException();
									
		} catch (CustomException F) {
			System.err.print("caught CustomException... inténtalo de nuevo: ");
			return String(scanner, forcedStr1, forcedStrs); 
		}		
	}

	/**
	 * Método recursivo que, además de funcionar como SafeInput, solo acepta un valor que haya sido introducido por parámetros.
	 * @apiNote es case-sensitive
	 * @param scanner		Scanner con el que queremos introducir el dato.
	 * @param forcedStr1	String que forzaremos a que introduzca el usuario.
	 * @param forcedStrs	Strings adicionales que tambien acepta el método.
	 * @return String introducido por el usuario.
	 * @see SafeInput#String(java.util.Scanner)
	 * @see #String(java.util.Scanner, String, String...)
	 */
	public static String String_case_sensitive(java.util.Scanner scanner, String forcedStr1, String...forcedStrs) {
		try {
			String choice= SafeInput.String(scanner);		
			if (choice.equals(forcedStr1)) 
				return choice;	
			
			for (String str:forcedStrs)
				if (str.equals(choice))
					return choice;
				
			throw new CustomException();
									
		} catch (CustomException F) {
			System.err.print("caught CustomException... inténtalo de nuevo: ");
			return String_case_sensitive(scanner, forcedStr1, forcedStrs); 
		}		
	}

	/**
	 * Método recursivo que, además de funcionar como SafeInput, solo acepta un valor que haya sido introducido por parámetros.
	 * @param scanner		Scanner con el que queremos introducir el dato.
	 * @param forcedByte1	byte que forzaremos a que introduzca el usuario.
	 * @param forcedBytes	bytes adicionales que tambien acepta el método.
	 * @return byte introducido por el usuario.
	 * @see SafeInput#Byte(java.util.Scanner)
	 */
	public static byte Byte(java.util.Scanner scanner, byte forcedByte1, byte...forcedBytes) {
		try {
			byte choice= SafeInput.Byte(scanner);		
			if (choice==forcedByte1) 
				return choice;	
			
			for (byte b:forcedBytes)
				if (b==choice)
					return choice;
				
			throw new CustomException();
									
		} catch (CustomException F) {
			System.err.print("caught CustomException... inténtalo de nuevo: ");
			return Byte(scanner, forcedByte1, forcedBytes); 
		}		
	}
	
	/**
	 * Método recursivo que, además de funcionar como SafeInput, solo acepta un valor que haya sido introducido por parámetros.
	 * @param scanner		Scanner con el que queremos introducir el dato.
	 * @param forcedInt1	int que forzaremos a que introduzca el usuario.
	 * @param forcedInts	ints adicionales que tambien acepta el método.
	 * @return int introducido por el usuario.
	 * @see SafeInput#Integer
	 * (java.util.Scanner)
	 */
	public static int Integer(java.util.Scanner scanner, int forcedInt1, int...forcedInts) {
		try {
			int choice= SafeInput.Integer(scanner);		
			if (choice==forcedInt1) 
				return choice;	
			
			for (int i:forcedInts)
				if (i==choice)
					return choice;
				
			throw new CustomException();
									
		} catch (CustomException F) {
			System.err.print("caught CustomException... inténtalo de nuevo: ");
			return Integer(scanner, forcedInt1, forcedInts); 
		}		
	}
	
	/**
	 * Método recursivo que, además de funcionar como SafeInput, solo acepta un valor que haya sido introducido por parámetros.
	 * @param scanner		Scanner con el que queremos introducir el dato.
	 * @param forcedDouble1	double que forzaremos a que introduzca el usuario.
	 * @param forcedDoubles	doubles adicionales que tambien acepta el método.
	 * @return double introducido por el usuario.
	 * @see SafeInput#Double(java.util.Scanner)
	 */
	public static double Double(java.util.Scanner scanner, double forcedDouble1, double...forcedDoubles) {
		try {
			double choice= SafeInput.Double(scanner);		
			if (choice==forcedDouble1) 
				return choice;	
			
			for (double d:forcedDoubles)
				if (d==choice)
					return choice;
				
			throw new CustomException();
									
		} catch (CustomException F) {
			System.err.print("caught CustomException... inténtalo de nuevo: ");
			return Double(scanner, forcedDouble1, forcedDoubles); 
		}		
	}
	
	/**
	 * Método recursivo que, además de funcionar como SafeInput, solo acepta un valor que haya sido introducido por parámetros.
	 * @param scanner		Scanner con el que queremos introducir el dato.
	 * @param forcedLong1	long que forzaremos a que introduzca el usuario.
	 * @param forcedLongs	longs adicionales que tambien acepta el método.
	 * @return long introducido por el usuario.
	 * @see SafeInput#Long(java.util.Scanner)
	 */
	public static long Long(java.util.Scanner scanner, long forcedLong1, long...forcedLongs) {
		try {
			long choice= SafeInput.Long(scanner);		
			if (choice==forcedLong1) 
				return choice;	
			
			for (long l:forcedLongs)
				if (l==choice)
					return choice;
				
			throw new CustomException();
									
		} catch (CustomException F) {
			System.err.print("caught CustomException... inténtalo de nuevo: ");
			return Long(scanner, forcedLong1, forcedLongs); 
		}		
	}
		
	/**
	 * Método recursivo que, además de funcionar como SafeInput, solo acepta un valor que haya sido introducido por parámetros.
	 * @param scanner		Scanner con el que queremos introducir el dato.
	 * @param forcedFloat	float que forzaremos a que introduzca el usuario.
	 * @param forcedFloats	floats adicionales que tambien acepta el método.
	 * @return float introducido por el usuario.
	 * @see SafeInput#Float(java.util.Scanner)
	 */
	public static float Float(java.util.Scanner scanner, float forcedFloat, float...forcedFloats) {
		try {
			float choice= SafeInput.Float(scanner);		
			if (choice==forcedFloat) 
				return choice;	
			
			for (float f:forcedFloats)
				if (f==choice)
					return choice;
				
			throw new CustomException();
									
		} catch (CustomException F) {
			System.err.print("caught CustomException... inténtalo de nuevo: ");
			return Float(scanner, forcedFloat, forcedFloats); 
		}		
	}
	
}
