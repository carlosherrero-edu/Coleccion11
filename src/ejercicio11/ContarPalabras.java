package ejercicio11;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * Plantilla para plantear el ejercicio 11 de la Colecci�n 11
 * 
 * @author CArlos Herrero
 *
 */
public class ContarPalabras {
	
	
	static final String RUTA_FICHERO="C:/Users/Alumno/Documents/muestra.txt";
	static final String RUTA_SALIDA="C:/Users/Alumno/Documents/resultado.txt";
	/* es mucho mejor usar una ruta local a la aplicaci�n, como la siguiente:
	 * static final String RUTA_FICHERO="files/muestra.txt";
	 */
	
	
	/**
	 * M�todo para leer un texto de un fichero usando la clase Scanner
	 * @param ruta ruta absoluta al fichero de texto
	 * @return cadena con el contenido del fichero
	 * @throws Exception si no existe el fichero, hay errores con el objeto Esc�ner...
	 */
	static String leerDeFichero(String ruta) throws Exception {

		try {
			//definimos un objeto File que se�ale al fichero de origen
			File fichero = new File(ruta);
			//definimos e instanciamos un objeto Scanner que tome como entrada la referencia al fichero
			Scanner teclado = new Scanner(fichero);
			String texto = "";
			//leemos el contenido del fichero l�nea a l�nea y lo agregamos a la cadena de texto a devolver
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
	 * M�todo para escribir el contenido del diccionario en un fichero usando la clase Formatter
	 * 
	 * @param ruta cadena con la ruta  al fichero de texto destino
	 * @param diccio   diccionario/Map con los pares palabras-ocurrencias que escribiremos en el fichero
	 * @throws Exception si no existe el fichero, hay errores con el objeto
	 *                   Esc�ner...
	 */
	static void escribirEnFichero(String ruta, TreeMap<String, Integer> diccio) throws Exception {

		try {
			// definimos un objeto File que se�ale al fichero de origen
			File fichero = new File(ruta);
			// definimos e instanciamos un flujo de tipo Formatter que tome como entrada la
			// referencia al fichero
			Formatter salida=new Formatter(fichero);
			Set<String> lista_palabras = diccio.keySet();

			//recorremos el diccionario iterando sobre lista_palabras
			//guardamos lso pares   "palabra/ocurrencia" en el fichero
			for (String palabra : lista_palabras) {
				salida.format("%20s\t\t%d%n", palabra, diccio.get(palabra));
			}
			//cerramos los recursos utilizados
			salida.close();
			

		} catch (Exception e) {
			throw e;

		}

	}

	/**
	 * M�todo para separar las palabras de un texto y rellenar un objeto TreeMap en
	 * el cual se guardar�n: -- LAs palabras que aparecen en el texto -ordenadas
	 * alfab�ticamente- -- El n�mero de ocurrencias de cada palabra en el texto
	 * 
	 * @param diccio objeto TreeMap donde se guarda la lsita de palabras y sus
	 *               frecuencias
	 * @param texto  cadena de texto de la que se desean separar las palabras
	 */
	static void rellenarDiccionario(TreeMap<String, Integer> diccio, String texto) {

		

	}

	/**
	 * M�todo que muestra la lista de palabras ordenadas, junto con sus frecuencias
	 * 
	 * @param diccio objeto TreeMap con la lista de palabras y sus frecuencias
	 */
	static void mostrarDiccionario(TreeMap<String, Integer> diccio) {

		

	}

	

	/**
	 * M�dulo principal /controlador de nuestra aplicaci�n
	 * @param args
	 */
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
		
		//los guardamos en un fichero
				try {
					escribirEnFichero(RUTA_SALIDA,diccio);

				} catch (Exception e) {
					// imprimimos el error 
					e.printStackTrace();
					
				}

	} // fin del metodo main

}