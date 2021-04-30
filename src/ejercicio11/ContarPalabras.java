package ejercicio11;

import java.io.File;
import java.util.Formatter;
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
	static final String RUTA_SALIDA="C:/Users/Alumno/Documents/resultado.txt";
	/* es mucho mejor usar una ruta local a la aplicación, como la siguiente:
	 * static final String RUTA_FICHERO="files/muestra.txt";
	 */
	
	
	/**
	 * Método para leer un texto de un fichero usando la clase Scanner
	 * @param ruta ruta absoluta al fichero de texto
	 * @return cadena con el contenido del fichero
	 * @throws Exception si no existe el fichero, hay errores con el objeto Escáner...
	 */
	static String leerDeFichero(String ruta) throws Exception {
		//definimos un objeto File que señale al fichero de origen
		File fichero = new File(ruta);
		//definimos e instanciamos un objeto Scanner que tome como entrada la referencia al fichero
		try  (Scanner teclado = new Scanner(fichero)){
			
		
			String texto = "";
			//leemos el contenido del fichero línea a línea y lo agregamos a la cadena de texto a devolver
			while (teclado.hasNextLine()) {
				texto = texto + teclado.nextLine() + "\n";
			}
	
			return texto;

		} catch (Exception e) {
			throw e;
		}

	}
	
	/**
	 * Método para escribir el contenido del diccionario en un fichero usando la clase Formatter
	 * 
	 * @param ruta cadena con la ruta  al fichero de texto destino
	 * @param diccio   diccionario/Map con los pares palabras-ocurrencias que escribiremos en el fichero
	 * @throws Exception si no existe el fichero, hay errores con el objeto
	 *                   Escáner...
	 */
	static void escribirEnFichero(String ruta, TreeMap<String, Integer> diccio) throws Exception {

		try {
			// definimos un objeto File que señale al fichero de origen
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
	 * Método para separar las palabras de un texto y rellenar un objeto TreeMap en
	 * el cual se guardarán: -- LAs palabras que aparecen en el texto -ordenadas
	 * alfabéticamente- -- El número de ocurrencias de cada palabra en el texto
	 * 
	 * @param diccio objeto TreeMap donde se guarda la lsita de palabras y sus
	 *               frecuencias
	 * @param texto  cadena de texto de la que se desean separar las palabras
	 */
	static void rellenarDiccionario(TreeMap<String, Integer> diccio, String texto) {
		
		//Divido el texto en palabras
		String [] palabras = texto.split("[\\p{Space}\\p{Punct}]\\p{Space}*");
		// recorro el array
		for (int i=0; i<palabras.length; i++) {
			//veo si tengo esa palabra en el diccionario
			String clave=palabras[i].toUpperCase();  //convierto la clave a mayúscula
			if (!diccio.containsKey(clave)) {
				//si no tengo esa palabra en el diccionario...
				diccio.put(clave, Integer.valueOf(1));
			}  else {//en caso contrario, si ya la tengo, incremento el número de veces que ha aparecido
				int rep= diccio.get(clave);
				diccio.put(clave, Integer.valueOf(rep+1));
			} 
		
				
			} //fin del bucle for
		}
	

	/**
	 * Método que muestra la lista de palabras ordenadas, junto con sus frecuencias
	 * 
	 * @param diccio objeto TreeMap con la lista de palabras y sus frecuencias
	 */
	static void mostrarDiccionario(TreeMap<String, Integer> diccio) {
		
		Set<String> lista= diccio.keySet();
		
		for (String elem: lista) {
			System.out.println(elem+ " \t "+ diccio.get(elem));
		}

		

	}

	

	/**
	 * Módulo principal /controlador de nuestra aplicación
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