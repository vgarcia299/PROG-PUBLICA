package misTools;

import java.nio.file.Files;
import java.text.Normalizer;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * {@summary clase que contiene métodos estáticos que considero útiles y suelo usar.}
 * @author victor
 * @methods
 * {@linkplain #getFile(String, String...)}, 
 * {@linkplain #getAllLines(File)},  
 * {@linkplain #writerLoop(java.io.Writer) writerLoop(writer)}, 
 * {@linkplain #writerLoop(java.io.Writer, Scanner) writerLoop(writer, Scanner)}, 
 * {@linkplain #CopyAndFormatFile(File, boolean)}
 * @apiNote
 */
public class MisTools {

	/**
	 * @author victor
	 * @param fileName (String) nombre del archivo
	 * @param folderNames (String) nombre de cada carpeta.<br>Ejemplo: MisTools.getFile("nombre.txt", "Desktop")
	 * @return (File) acorde con la direccion y nombre correspondiente
	 */
	public static File getFile(String fileName, String...folderNames) 
	{
	    String path= System.getProperty("user.home");
	    for (String folderName : folderNames)
	    	path += "\\"+folderName+"\\";
	    
	    File archivo= new File(path+fileName);
	    if (archivo.exists())
	    	return archivo;
	    else
	    	throw new RuntimeException("no existe el archivo "+archivo);
	}

	/**
	 * {@summary con este metodo evitamos tener que declarar un throws IO cada vez que vamos a usar Files.readAllLines()}
	 * creo que es la mierda + sin sentido que he programado, todo para evitar declarar un throws
	 * @author victor
	 * @throws {@link java.lang.RunTimeException}
	 * @param archivo (File) 
	 */
	public static List<String> readAllLines(File archivo) {
		try {
			return Files.readAllLines(archivo.toPath());			
		
		} catch (IOException F) {
			throw new RuntimeException(F.getMessage(), F);
		} 
		
	}	

	/**
	 * metodo con el que reducimos el contenido de un archivo a una unica String
	 * @author victor
	 * @param archivo (File) archivo que queremos imprimir
	 * @return una unica String con el contenido legible del archivo
	 * @throws CleanException
	 * @see {@link #readAllLines(String)}
	 */
	public static String getAllLines(File archivo) {
		String bar="";
		for (String line : readAllLines(archivo))
			bar += line+"\n";
		
		return bar;
	}

	/**
	 * @author victor
	 * @param archivo (File) archivo
	 * @return String con el contenido de una linea aleatoria del archivo
	 * @see {@link #readAllLines(File)}
	 */
	public static String getRandomLine(File archivo) {
		List<String> contenido= readAllLines(archivo);
		return contenido.get(new Random().nextInt(0, contenido.size()-1));	
	}	
			
	/**
	 * <b> para salir "!exit"</b><br>
	 * mientras que el usuario no introduzca '!exit' el writer aceptara toda String que el usuario introduzca, 
	 * añadiendo un salto de linea con cada input
	 * @author victor
	 * @param writer {@linkplain java.io.Writer Writer} que usaremos, incluye sus subclases (BufferedWriter, FileWriter, etc...)
	 * @throws IOException
	 */
	public static void writerLoop(java.io.Writer writer) {
		writerLoop(writer, new Scanner(System.in));
	}
	
	/**
	 * <b> para salir "!exit"</b><br>
	 * mientras que el usuario no introduzca '!exit' el writer aceptara toda String que el usuario introduzca, 
	 * añadiendo un salto de linea con cada input
	 * @author victor
	 * @param writer {@linkplain java.io.Writer Writer} que usaremos, incluye sus subclases (BufferedWriter, FileWriter, etc...)
	 * @param scanner (Scanner) a utilizar
	 * @throws IOException
	 */
	public static void writerLoop(java.io.Writer writer, Scanner scanner) {
		try 
		{
			while (true) 
			{			
				String line= scanner.nextLine();
				if (line.equals("!exit")) 
					break;
				else				
					writer.write(line+"\n");		
			
		}} catch (IOException F) {
			throw new RuntimeException(F.getMessage(), F);
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
			return 	Normalizer.normalize(text.toUpperCase().trim() , 
					Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		else
			return	Normalizer.normalize(text.toLowerCase().trim() , 
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
	 * @param originalFilename (File) archivo
	 * @see #formatText(String, boolean)
	 */
	public static void CopyAndFormatFile(File originalFilename, boolean isUppercase) {
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
