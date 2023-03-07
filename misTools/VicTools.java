package misTools;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.FileSystems;

/**
 * {@summary clase que contiene métodos estáticos que considero útiles y suelo usar.}
 * @author victor
 * @methods
 * {@linkplain #getFilePath(String)},  
 * {@linkplain #getAllLines(String)},  
 * {@linkplain #writerLoop(java.io.Writer) writerLoop(writer)}
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
	
}
