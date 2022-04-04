package unidad8.ejemplosset;



import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;



/**
 * Clase de prueba para dividir una frase en palabras y generar una lista 
 * en la que cada palabra aparezca una sola vez
 * Se usa HashSet como clase base
 * @author Carlos
 *
 */
public class EjemploHashSet {

	/**
	 * @param lista
	 */
	
	
	
	static void eliminaDuplicados (Collection<String> lista){
		
		Set<String> listaUnicos= new HashSet<String>(lista);
	
		// se imprimen los elementos de la lista
		System.out.println("\n\nValores no repetidos de la lista");
		int contador=0;
		for (String cad: listaUnicos){
			System.out.format("%20s   ",cad);
			//cada 5 palabras, agrego salto de línea
			if (++contador%5 ==0) {
				System.out.println();
			}
		}
		System.out.println("\n Elementos en la lista: "+listaUnicos.size());
	
	} //fin eliminaDuplicados
	
	public static void main(String[] args) {
		String frase= "Una mañana, tras un sueño intranquilo, Gregorio Samsa se despertó convertido en un monstruoso insecto."
				+ "Estaba echado de espaldas sobre un duro caparazón y, al alzar la cabeza, vio su vientre convexo y oscuro, surcado por curvadas callosidades, "
				+ "sobre el que casi no se aguantaba la colcha, que estaba a punto de escurrirse hacia el suelo.";
		
		//dividimos la frase en palabras usando el método split con una expresión regular
		String[] palabras =frase.split("[\\s\\.\\,](\\s)*");
		
		//generamos una lista con las palabras obtenidas
		List<String> lista= Arrays.asList(palabras);
		
		//ordenamos la lista
		Collections.sort(lista);
		// se imprimen los elementos de la lista
		System.out.println("\n\nValores de la lista de palabras");
				int contador=0;
				for (String cad: lista){
					System.out.format("%20s   ",cad);
					//cada 5 palabras, agrego salto de línea
					if (++contador%5 ==0) {
						System.out.println();
					}
				}
				System.out.println("\n Elementos en la lista: "+lista.size());
		//llamamos ahora al método para construir e imprimir la lista sin duplicados
		eliminaDuplicados(lista);
		
	}

}
