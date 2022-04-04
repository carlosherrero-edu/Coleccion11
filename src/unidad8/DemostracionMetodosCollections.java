package unidad8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DemostracionMetodosCollections {

	// método para imprimir una lista de String

	static void imprimir(List<String> lista) {

		for (String cad : lista) {
			System.out.println(cad);
		}
	}

	// método para sacar cartas al azar
	static String dameCarta(List<String> cartas, List<String> palos) {
		// barajamos las listas de cartas
		Collections.shuffle(cartas);
		Collections.shuffle(palos);
		// devolvemos la primera carta de cada montón
		return cartas.get(0) + " de " + palos.get(0);

	}

	public static void main(String[] args) {

		String[] palos = { "Bastos", "Copas", "Espadas", "Oros" };

		String[] cartas = { "As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Sota", "Caballo",
				"Rey" };

		// obtención de listas dinámicas a partir de los arrays anteriores
		List<String> listaCartas = Arrays.asList(cartas);
		List<String> listaPalos = Arrays.asList(palos);

		// ordenación de la lista alfabéticamente de A-Z
		Collections.sort(listaCartas);
		System.out.println("**** Lista de Cartas de A-Z");
		imprimir(listaCartas);

		// ordenación de la lista alfabéticamente de Z-A
		Collections.sort(listaCartas, Collections.reverseOrder());
		System.out.println("**** Lista de Cartas de Z-A");
		imprimir(listaCartas);

		// inversión del orden de la lista
		Collections.reverse(listaCartas);
		System.out.println("**** Lista de Cartas invirtiendo el orden en la última lista.");
		imprimir(listaCartas);

		// creamos una lista vacía con 12 elementos
		String[] cartasVacias = new String[12];
		List<String> otraListaCartas = Arrays.asList(cartasVacias);

		// la rellenamos con una única carta.
		Collections.fill(otraListaCartas, "Comodín");
		System.out.println("****Nueva Lista de Cartas rellenadas e iguales");
		imprimir(otraListaCartas);

		// copiamos una lista en la otra
		Collections.copy(otraListaCartas, listaCartas);
		System.out.println("****Nueva Lista de Cartas una vez hecha la copia");
		imprimir(otraListaCartas);

		// buscamos dos cartas
		System.out.println("La carta Sota está en la posición  " + Collections.binarySearch(listaCartas, "Sota"));

		System.out.println("La carta Picas está en la posición  " + Collections.binarySearch(listaCartas, "Picas"));

		// comparamos las listas de cartas y de palos
		System.out.printf("%n listaCartas y listaPalos  %s  elementos comunes",
				(Collections.disjoint(listaCartas, listaPalos) ? " no tienen " : " tienen "));

		// y sacamos por último 3 cartas al azar basándonos en el método shuffle
		for (int i = 1; i <= 6; i++) {
			System.out.format("%n  Carta %d : %s", i, dameCarta(listaCartas, listaPalos));
		}

	}

}
