package ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class OperacionesListas<T> {

	public static <T> ArrayList<T> unirListas(List<T> lista1, List<T> lista2) {

		ArrayList<T> resultado = new ArrayList<>();

		// recorremos primero lista1
		for (T item : lista1) {
			if (resultado.indexOf(item) < 0) {
				
				// si el elemento no est� en la lista
				resultado.add(item);
			}
		}

		// recorremos despu�s lista2 y hacemos la misma operaci�n
		for (T item : lista2) {
			if (resultado.indexOf(item) < 0) {
				// si el elemento no est� en la lista
				resultado.add(item);
			}
		}

		return resultado;
	}

	public static <T> ArrayList<T> intersectarListas(List<T> lista1, List<T> lista2) {

		ArrayList<T> resultado = new ArrayList<>();
		// recorremos la primera lista y vemos si sus elementos est�n en la segunda
		for (T item : lista1) {
			if (resultado.indexOf(item) < 0 && lista2.indexOf(item) >= 0) {
				// si el elemento no est� en resultado pero s� est� en lista2
				resultado.add(item);
			}
		}
		// no necesito recorrer lista2, ya que s�lo me interesan los elementos comunes

		return resultado;
	}

	public static <T> ArrayList<T> restarListas(List<T> lista1, List<T> lista2) {

		ArrayList<T> resultado = new ArrayList<>();
		// recorremos la primera lista y comprobamos que los elementos no est�n en
		// lista2
		for (T item : lista1) {
			if (resultado.indexOf(item) < 0 && lista2.indexOf(item) < 0) {
				// si el elemento no est� en resultado pero s� est� en lista2
				resultado.add(item);
			}
		}

		return resultado;
	}
}
