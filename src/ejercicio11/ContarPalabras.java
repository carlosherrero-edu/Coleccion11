package ejercicio11;

import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * Plantilla para plantear el ejercicio 11 de la Colección 11
 * 
 * @author CArlos Herrero
 *
 */
public class ContarPalabras {
	
	static final String RUTA_FICHERO="C:/Users/Alumno/Documents/muestra.txt";
	
	
	/**
	 * Método para leer un texto de un fichero usando la clase Scanner
	 * @param ruta ruta absoluta al fichero de texto
	 * @return cadena con el contenido del fichero
	 * @throws Exception si no existe el fichero, hay errores con el objeto Escáner...
	 */
	static String leerDeFichero(String ruta) throws Exception {

		try {
			//definimos un objeto File que señale al fichero de origen
			File fichero = new File(ruta);
			//definimos e instanciamos un objeto Scanner que tome como entrada la referencia al fichero
			Scanner teclado = new Scanner(fichero);
			String texto = "";
			//leemos el contenido del fichero línea a línea y lo agregamos a la cadena de texto a devolver
			while (teclado.hasNext()) {
				texto = texto + teclado.nextLine() + "\n";
			}
			teclado.close();
			return texto;

		} catch (Exception e) {
			throw e;

		}

	}

	/**
	 * Método para separar las palabras de un texto y rellenar un objeto TreeMap en
	 * el cual se guardarán: -- LAs palabras que aparecen en el texto -ordenadas
	 * alfabéticamente- -- El número de ocurrencias de cada palabra en el texto
	 * 
	 * @param diccio objeto TreeMap donde se guarda la lsita de palabras y sus
	 *               frecuencias
	 * @param texto  cadena de texto de la que se desean separar las palabras
	 */
	static void rellenarDiccionario(TreeMap<String, Integer> diccio, String texto) {

		

	}

	/**
	 * Método que muestra la lista de palabras ordenadas, junto con sus frecuencias
	 * 
	 * @param diccio objeto TreeMap con la lista de palabras y sus frecuencias
	 */
	static void mostrarDiccionario(TreeMap<String, Integer> diccio) {

		

	}

	

	public static void main(String[] args) {
		
		String frase="";
		
		try {
			frase= leerDeFichero(RUTA_FICHERO);
			
		} catch (Exception e) {
			//imprimimos el error y cerramos el programa
			e.printStackTrace();
			System.exit(1);
		}
	

		// objeto TreeMap donde la guardaremos. Elegimos TreeMap para mantener la lista
		// ordenada
		TreeMap<String, Integer> diccio = new TreeMap<>();

		// realizamos el conteo de palabras
		rellenarDiccionario(diccio, frase);

		// mostramos resultados
		mostrarDiccionario(diccio);

	} // fin del metodo main

}