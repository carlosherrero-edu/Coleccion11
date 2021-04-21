package ejercicio1;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author Miguel Rodríguez
 *
 */
public class Ejercicio1 {

	//propiedad lista donde guardo los números
	private static List<Integer> listaAleatoria = new LinkedList<>();
	
	//constantes definidas
	static final int VALOR_MAXIMO=100;
	static final int LONGITUD=25;
	
	//elemento estático de SecureRandom para generar valores aleatorios
	static Random rand = new SecureRandom();
	
	
	/**
	 * Método para generar un número aleatorio entre 0 y VALOR_MAXIMO
	 * @return entero ocn el valor generado
	 */
	public static int numAleatorio() {
		int numero= 0;
		numero = rand.nextInt(VALOR_MAXIMO+1);
		return numero;
	}
	
	/**
	 * Método para rellenar la lista con valores enteros
	 * @param lista colección de tipo List que rellenamos con valores aleatorios
	 */
	public static void llenarLista(List<Integer> lista) {
		for (int i = 0; i < LONGITUD; i++) {
			listaAleatoria.add(numAleatorio());
		}
	}
	
	/**
	 * M´étodo para calcular la suma de los elementos de una lista
	 * @param lista colección de tipo List con una lista de enteros
	 * @return valor de la suma
	 */
	public static int sumaLista(List<Integer> lista) {
		int suma = 0;
		for (Integer integer : lista) {
			suma += integer;
		}
		return suma;
	}
	
	/**
	 * M´étodo para calcular el rpomedio de los elementos de una lista
	 * @param lista colección de tipo List con una lista de enteros
	 * @return valor del promedio de la lista
	 */
	public static double mediaLista(List<Integer> lista) {
		double media = 0;
		
		media = (sumaLista(lista)/lista.size());
		return media;
	}
	
	public static void main(String[] args) {
		
		String mediaRedondeada = null;
		llenarLista(listaAleatoria);
		System.out.println(listaAleatoria);
		System.out.format("\n La suma de los elementos de la lista es ... %d ",sumaLista(listaAleatoria));
		
		mediaRedondeada = String.format("%.2f", mediaLista(listaAleatoria));
		System.out.format("\n El promedio los elementos de la lista es ... %s\n",mediaRedondeada);
		
		Collections.sort(listaAleatoria);
		
	
		for (int i = 0; i < listaAleatoria.size(); i++) {
			System.out.format("  %2d",listaAleatoria.get(i));
			if(i != 0 && (i+1)%5 == 0)
				System.out.println();
			
		}
	}

}

