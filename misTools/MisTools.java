package misTools;

import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Normalizer;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;

/**
 * {@summary clase que contiene métodos estáticos que considero útiles y suelo usar.}
 * @author victor
 * @methods
 * {@linkplain #getFilePath(String)},  
 * {@linkplain #getAllLines(String)},  
 * {@linkplain #writerLoop(java.io.Writer) writerLoop(writer)}, 
 * {@linkplain #writerLoop(java.io.Writer, Scanner) writerLoop(writer, Scanner)}, 
 * {@linkplain #CopyAndFormatFile(String, boolean)}
 * @apiNote
 * IMPORTANTE:
 * Siempre que en un método me refiera al nombre de un archivo de texto (ya sea para encontrarlo o para crearlo), 
 * este ha de estar ubicado en el source folder asociado a la clase donde ejecutas dicho método.
 */
public class MisTools {
	
	/*
	 * NOTA:readAllLines(fileName) puede ser sustituido por estas opciones en cualquier sitio que implemente ese método.
	 * 	a) Files.readAllLines(MisTools.getFilePath(fileName))
	 *  b) Files.readAllLines(FileSystems.getDefault().getPath(fileName))
	 */
	
	/**
	 * @author victor
	 * @param fileName (String) el nombre del archivo al que nos queremos referir <br>(ejemplo: nombreArchivo.txt) 
	 * @return Path del archivo correspondiente
	 */
	public static Path getFilePath(String fileName) {
		return FileSystems.getDefault().getPath(fileName);
	}

	/**
	 * {@summary con este metodo evitamos tener que declarar un throws IO cada vez que vamos a usar Files.readAllLines()}
	 * creo que es la mierda + sin sentido que he programado, todo para evitar declarar un throws
	 * @author victor
	 * @throws {@link misTools.CleanException}
	 * @param fileName (String) nombre del archivo a buscar 
	 * (ha de estar ubicado en el source folder de la clase donde ejecutas este método)
	 */
	public static List<String> readAllLines(String fileName) {
		try {
			return Files.readAllLines(MisTools.getFilePath(fileName));			
		
		} catch (java.io.IOException F) {
			throw new RuntimeException(F.getMessage(), F);
		} 
		
	}
	
	/**
	 * metodo con el que imprimimos el contenido de un archivo
	 * @author victor
	 * @param fileName (String) nombre del archivo que queremos imprimir<br>(ejemplo: nombreArchivo.txt)
	 * @return una unica String con el contenido legible del archivo
	 * @throws CleanException
	 * @see {@link #readAllLines(String)}
	 */
	public static String getAllLines(String fileName) {
		String bigStr="";
		for (String line : readAllLines(fileName))
			bigStr += line+"\n";
		
		return bigStr;
	}

	/**
	 * @author victor
	 * @param fileName (String) nombre del archivo. Ejemplo: diccionario.txt
	 * @return String con el contenido de una linea aleatoria del archivo
	 * @throws CleanException
	 * @see {@link #readAllLines(String)}
	 */
	public static String getRandomLine(String fileName) {
		List<String> file= readAllLines(fileName);
		return file.get(new Random().nextInt(0, file.size()-1));	
	}	
			
	/**
	 * @author victor
	 * mientras que el usuario no introduzca '!exit' el writer aceptara toda String que el usuario introduzca, 
	 * añadiendo un salto de linea con cada input
	 * @param writer {@linkplain java.io.Writer Writer} que usaremos, incluye sus subclases (BufferedWriter, FileWriter, etc...)
	 * @throws IOException
	 */
	public static void writerLoop(java.io.Writer writer) throws IOException {
		writerLoop(writer, new Scanner(System.in));
	}
	
	/**
	 * mientras que el usuario no introduzca '!exit' el writer aceptara toda String que el usuario introduzca, 
	 * añadiendo un salto de linea con cada input
	 * @author victor
	 * @param writer {@linkplain java.io.Writer Writer} que usaremos, incluye sus subclases (BufferedWriter, FileWriter, etc...)
	 * @param scanner (Scanner) a utilizar
	 * @throws IOException
	 */
	public static void writerLoop(java.io.Writer writer, Scanner scanner) throws IOException {
		while (true) {			
			String line= scanner.nextLine();
			
			if (line.equals("!exit")) 
				break;
			else				
				writer.write(line+"\n");		
		} 
	}
	
	/**
	 * <b> Convierte una String a formato estándar </b> 
	 * <br>
	 * <br> Defino como formato estándar:
	 * <br> - todo en mayusculas / minusculas
	 * <br> - sin espacios en inicio o fin de línea
	 * <br> - sin tildes, diéresis, etc
	 * <br> - sin caracteres ascii no alfanumericos
	 * @author victor
	 * @param uppercase (boolean) true si quieres que el resultado sea en mayusculas, false para minusuculas.
	 * @param text (String) la String a transformar
	 * @return la String introducida en formato estándar
	 */
	public static String formatText(String text, boolean uppercase) {
		if (uppercase)
			return 	Normalizer.normalize(text.toUpperCase().trim(), 
					Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		else
			return	Normalizer.normalize(text.toLowerCase().trim(), 
					Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
	
	/**
	 * <b> Toma un archivo de texto plano y crea una copia del mismo con un formato estándar.<br>
	 *     El nombre del nuevo archivo es: NombreArchivoOriginal_formatted.txt </b>
	 * <br>
	 * <br> Defino como formato estándar:
	 * <br> - todo en mayusculas / minusculas
	 * <br> - sin espacios en inicio o fin de línea
	 * <br> - sin tildes, diéresis, etc
	 * <br> - sin caracteres ascii no alfanumericos
	 * @author victor
	 * @param isUppercase (boolean) true si quieres que el resultado sea en mayusculas, false para minusuculas.
	 * @param originalFilename (String) nombre del archivo que tomaremos como referencia. Ejemplo: diccionario.txt
	 * @see #formatText(String, boolean)
	 */
	public static void CopyAndFormatFile(String originalFilename, boolean isUppercase) {
		try 
		{
			List<String> archivo= readAllLines(originalFilename);
			BufferedWriter writer= new BufferedWriter(new FileWriter(originalFilename+"_formatted.txt"));

			for (String line : archivo) 
				writer.write(formatText(line,isUppercase)+"\n");
										
			writer.close();
						
		} catch (IOException F) {
			throw new RuntimeException(F.getMessage(), F);
	//		F.printStackTrace();
		}

	}
	
}
