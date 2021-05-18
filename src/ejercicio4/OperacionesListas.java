package ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class OperacionesListas<T> {

	public static <T> ArrayList<T> unirListas(List<T> lista1, List<T> lista2) {

		ArrayList<T> resultado = new ArrayList<>();

		// recorremos primero lista1
		for (T item : lista1) {
			if (resultado.indexOf(item) < 0) {
				
				// si el elemento no está en la lista
				resultado.add(item);
			}
		}

		// recorremos después lista2 y hacemos la misma operación
		for (T item : lista2) {
			if (resultado.indexOf(item) < 0) {
				// si el elemento no está en la lista
				resultado.add(item);
			}
		}

		return resultado;
	}

	public static <T> ArrayList<T> intersectarListas(List<T> lista1, List<T> lista2) {

		ArrayList<T> resultado = new ArrayList<>();
		// recorremos la primera lista y vemos si sus elementos están en la segunda
		for (T item : lista1) {
			if (resultado.indexOf(item) < 0 && lista2.indexOf(item) >= 0) {
				// si el elemento no está en resultado pero sí está en lista2
				resultado.add(item);
			}
		}
		// no necesito recorrer lista2, ya que sólo me interesan los elementos comunes

		return resultado;
	}

	public static <T> ArrayList<T> restarListas(List<T> lista1, List<T> lista2) {

		ArrayList<T> resultado = new ArrayList<>();
		// recorremos la primera lista y comprobamos que los elementos no estén en
		// lista2
		for (T item : lista1) {
			if (resultado.indexOf(item) < 0 && lista2.indexOf(item) < 0) {
				// si el elemento no está en resultado pero sí está en lista2
				resultado.add(item);
			}
		}

		return resultado;
	}
}
