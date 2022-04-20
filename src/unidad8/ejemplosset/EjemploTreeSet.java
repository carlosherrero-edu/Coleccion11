package unidad8.ejemplosset;

import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Clase de prueba para dividir una frase en palabras y generar una lista en la
 * que cada palabra aparezca una sola vez, y además la lista esté ordenada Se
 * usa TreeSet como clase base
 * 
 * @author Carlos
 *
 */
public class EjemploTreeSet {

	/**
	 * Método para imprimir en columnas de 5 una colección de objetos de la clase String
	 * @param miCol referencia a la colección de cadenas String que deseamos imprimir
	 * La definimos de la interfaz Collection para poder pasarle elementos de tipo List o Set
	 */
	static void imprimirColeccion(Collection<String> miCol) {
		// hacemos la conversión descendente

		int contador = 0;

		for (String cad : miCol) {
			System.out.format("%20s   ", cad);
			// cada 5 palabras, agrego salto de línea
			if (++contador % 5 == 0) {
				System.out.println();
			}
		}

	}

	/**
	 * Método demostrativo del uso de TreeSet, construyendo un objeto TreeSet a partir de un objeto Collection
	 * @param lista referencia a la colección de cadenas String que deseamos convertir a TreeSet
	 */
	static void eliminaDuplicados(Collection<String> lista) {

		/*
		 * Se puede definir la referencia de tipo TreeSet o SortedSet, 
		 * pero no de tipo Set, pues perderíamos los métodos propios de los Set ordenados
		 */
		TreeSet<String> listaUnicos = new TreeSet<String>(lista);

		// se imprimen los elementos de la lista
		System.out.println("\n\nValores no repetidos de la lista");
		imprimirColeccion(listaUnicos);
		System.out.println("\n Elementos en la lista: " + listaUnicos.size());

//		// probamos los métodos específicos de TreeSet
		System.out.println("Primer elemento :" + listaUnicos.first());
		System.out.println("Último elemento :" + listaUnicos.last());
//
//		// imprimimos los elementos que preceden a "insecto"
System.out.println("\n\nElementos que preceden a \"insecto\"");
imprimirColeccion(listaUnicos.headSet("insecto",true));
//
//		// imprimimos los elementos que siguen a "insecto"
System.out.println("\n\nElementos a continuación de  \"insecto\"");
	imprimirColeccion(listaUnicos.tailSet("insecto", false));

	} // fin eliminaDuplicados

	public static void main(String[] args) {
		String frase = "Una mañana, tras un sueño intranquilo, Gregorio Samsa se despertó convertido en un monstruoso insecto."
				+ "Estaba echado de espaldas sobre un duro caparazón y, al alzar la cabeza, vio su vientre convexo y oscuro, surcado por curvadas callosidades, "
				+ "sobre el que casi no se aguantaba la colcha, que estaba a punto de escurrirse hacia el suelo.";

		String[] palabras = frase.split("[\\s\\.\\,](\\s)*");

		// generamos una lista con las palabras obtenidas
		List<String> lista = Arrays.asList(palabras);

		// se imprimen los elementos de la lista
		System.out.println("\n\nValores de la lista de palabras");
		imprimirColeccion(lista);
		System.out.println("\n Elementos en la lista: " + lista.size());
		// llamamos ahora al método para imrpimir la lista sin duplicados
		eliminaDuplicados(lista);

	}

}
