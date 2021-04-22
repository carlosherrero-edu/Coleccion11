package ejercicio5;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Asus
 *
 */
public class ListaNombres {

	/**
	 * Metodo para introducir una lista de nombres por teclado
	 * 
	 * @param lista    - Set : Referencia a una coleccion que hereda de la interfaz
	 *                 Set
	 * @param entrada- Scanner : referencia a un objeto de tipo Scanner para
	 *                 interactuar con el teclado Soluci�n de Adri�n
	 */
	static void leerNombres(Set<String> lista, Scanner entrada) {

		int halt = 1;
		String dova;
		do {
			System.out.println("Introduce el siguinete nombre. En caso de que no quieras introducir mas,teclea (fin)");
			dova = entrada.nextLine();
			switch (dova) {
			case "fin":
				halt = 0;
				break;
			default:
				lista.add(dova);
			}

		} while (halt != 0);

	} // fin metodo leerNombres

	/**
	 * Método para recuperar e imprimir la lista de nombres ordenada
	 * alfabéticamente
	 * 
	 * @param lista Set - colección de tipo TreeSet con los nombres introducidos
	 *              Soluci�n de F�lixfin
	 */
	static void recuperarNombres(Set<String> lista) {
		if (!lista.isEmpty()) {
			Iterator<String> it = lista.iterator();

			while (it.hasNext()) {
				System.out.println(it.next());
			}
		} else {
			System.out.println("Tu lista no tiene nombres...");
		}

	}// fin del método recuperarNombres

	/**
	 * Método para buscar sucesivamente si un nombre se encuentra o no en la lista
	 * 
	 * @param nombres  - Set : Referencia a una colección que hereda de la interfaz
	 *                 Set
	 * @param entrada- Scanner : referencia a un objeto de tipo Scanner para
	 *                 interactuar con el teclado
	 * soluci�n de Mauricio
	 */
	static void buscarNombres(Set<String> lista, Scanner entrada) {

		String nombre;
		System.out.println("Escribe un nombre a buscar en la lista ( para salir escribe fin):");
		System.out.print("Nombre a buscar >>>>>  ");
		do {
			nombre = entrada.nextLine();
			
			if (!nombre.trim().equalsIgnoreCase("fin")) {
				if (lista.contains(nombre)) {
					System.out.println(nombre + "  SI pertenece a la lista.");
				} else
					System.out.println(nombre + " NO pertenece a la lista.");
				
				//pedimos un nuevo nombre.
				System.out.print("Siguiente nombre a buscar >>>>>   ");
			}
		
		} while (!nombre.trim().equalsIgnoreCase("fin"));
		entrada.close();

	}

	public static void main(String[] args) {
		// objeto de tipo Scanner para pedir datos por teclado
		Scanner entrada = new Scanner(System.in);

		// coleccion donde vamos a guardar la lista de nombres.
		// Elegimos TreeSet para mantenerla ordenada
		Set<String> nombres = new TreeSet<>();

		// leemos los nombres por teclado
		leerNombres(nombres, entrada);

		// a cotninuación los recuperamos en orden alfabético
		recuperarNombres(nombres);

		// para buscar nombres, hacemos un bucle que pedirá un valor hasta que
		// escribamos "fin"

		 buscarNombres(nombres, entrada);

		// liberamos el objeto escáner

		entrada.close();

	} // fin del main

}
