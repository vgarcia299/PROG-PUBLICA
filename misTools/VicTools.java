package misTools;

import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Normalizer;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
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
 * {@linkplain #CopyAndFormatFile(String)}
 * @apiNote
 * IMPORTANTE:
 * Siempre que en un método me refiera al nombre de un archivo de texto (ya sea para encontrarlo o para crearlo), 
 * este ha de estar ubicado en el source folder asociado a la clase donde ejecutas dicho método.
 */
public class VicTools {
	
	/**
	 * @author victor
	 * @param fileName (String) el nombre del archivo al que nos queremos referir <br>(ejemplo: nombreArchivo.txt) 
	 * @return Path del archivo correspondiente
	 */
	public static Path getFilePath(String fileName) {
		return FileSystems.getDefault().getPath(fileName);
	}

	/**
	 * @author victor
	 * metodo con el que imprimimos el contenido de un archivo
	 * @param fileName (String) nombre del archivo que queremos imprimir<br>(ejemplo: nombreArchivo.txt)
	 * @return una unica String con el contenido legible del archivo
	 * @throws IOException
	 */
	public static String getAllLines(String fileName) throws IOException {
		String allLines="";
		List<String> doc= Files.readAllLines(getFilePath(fileName));
		
		for (String line : doc)
			allLines += line+"\n";
		
		return allLines;
	}

	/**
	 * @author victor
	 * @param fileName (String) nombre del archivo. Ejemplo: diccionario.txt
	 * @return String con el contenido de una linea aleatoria del archivo
	 * @throws IOException
	 */
	public static String getRandomLine(String fileName) throws IOException {
		List<String> all_Lines= Files.readAllLines(getFilePath(fileName));
		return all_Lines.get(new Random().nextInt(0, all_Lines.size()-1));	
	}	
		
	/**
	 * @author victor
	 * mientras que el usuario no introduzca '!exit' el writer aceptara toda String que el usuario introduzca, 
	 * añadiendo un salto de linea con cada input
	 * @param writer {@linkplain java.io.Writer Writer} que usaremos, incluye sus subclases (BufferedWriter, FileWriter, etc...)
	 * @throws IOException
	 */
	public static void writerLoop(java.io.Writer writer) throws IOException {
		Scanner nuestroEscaner= new Scanner(System.in);
		while (true) {			
			String line= nuestroEscaner.nextLine();
			
			if (line.equals("!exit")) 
				break;
			else				
				writer.write(line+"\n");		
		
		} nuestroEscaner.close();
	}
	
	/**
	 * @author victor
	 * mientras que el usuario no introduzca '!exit' el writer aceptara toda String que el usuario introduzca, 
	 * añadiendo un salto de linea con cada input
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
	 * Toma un archivo de texto plano y crea una copia del mismo con un formato estándar.<br>
	 * El nombre del nuevo archivo es: NombreArchivoOriginal_formatted.txt
	 * <br>
	 * <br> Defino como formato estándar:
	 * <br> - sin espacios en inicio o fin de línea
	 * <br> - sin tildes, diéresis, etc
	 * <br> - sin caracteres ascii no alfanumericos
	 * @param isUppercase (boolean) true si quieres que el resultado sea en mayusculas, false para minusuculas.
	 * @param originalFilename (String) nombre del archivo que tomaremos como referencia. Ejemplo: diccionario.txt
	 */
	public static void CopyAndFormatFile(String originalFilename, boolean isUppercase) {
		try {
			List<String> archivo= Files.readAllLines(getFilePath(originalFilename));
			BufferedWriter writer= new BufferedWriter (new FileWriter(originalFilename+"_formatted.txt"));

			for (String line : archivo) 
				writer.write(formatterAux(line, isUppercase)+"\n");
										
			writer.close();
			
		} catch (FileNotFoundException omegaF) {
			System.err.println("FileNotFound was caught");
	//		omegaF.printStackTrace();
			
		} catch (IOException F) {
			System.err.println("IOE was caught");
	//		F.printStackTrace();
		}

		
	} private static String formatterAux(String text, boolean uppercase) {
		if (uppercase)
			return 	Normalizer.normalize(text.toUpperCase().trim(), 
					Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		else
			return	Normalizer.normalize(text.toLowerCase().trim(), 
					Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
	
}
