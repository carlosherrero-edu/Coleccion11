package ejercicio4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperacionesListasTest {

	// defino varias listas de nombres
	String[] lista1 = { "Carlos", "Ana", "Jorge", "Julia", "Santiago", "Isabel", "Pedro", "Martina", "Lucas",
			"Camila" };

	String[] lista2 = { "Manuel", "Julia", "Jorge", "Rosana", "Fidel", "Camila", "Lucas", "Lorena" };

	// convierto las listas en arraylists
	List<String> lista1AL = Arrays.asList(lista1);
	List<String> lista2AL = Arrays.asList(lista2);

	List<String> resultadoAL;



	@Test
	@DisplayName("Probando la unión de listas")
	void testUnirListas() {
		String[] esperado = { "Carlos", "Ana", "Jorge", "Julia", "Santiago", "Isabel", "Pedro", "Martina", "Lucas",
				"Camila", "Manuel", "Rosana", "Fidel", "Lorena" };

		resultadoAL = OperacionesListas.unirListas(lista1AL, lista2AL);

		String[] resultado = new String[resultadoAL.size()];
		resultadoAL.toArray(resultado);

		assertTrue(resultado.length == esperado.length);

		assertArrayEquals(resultado, esperado);
	}

	@Test
	@DisplayName("Probando la intersección de listas")
	void testIntersectarListas() {
		String[] esperado = { "Jorge", "Julia", "Lucas", "Camila" };

		resultadoAL = OperacionesListas.intersectarListas(lista1AL, lista2AL);

		String[] resultado = new String[resultadoAL.size()];
		resultadoAL.toArray(resultado);

		assertTrue(resultado.length == esperado.length);

		assertArrayEquals(resultado, esperado);
	}

	@Test
	@DisplayName("Probando la diferencia/resta de listas")
	void testRestarListas() {
		String[] esperado = { "Carlos", "Ana", "Santiago", "Isabel", "Pedro", "Martina", };

		resultadoAL = OperacionesListas.restarListas(lista1AL, lista2AL);

		String[] resultado = new String[resultadoAL.size()];
		resultadoAL.toArray(resultado);

		assertTrue(resultado.length == esperado.length);

		assertArrayEquals(resultado, esperado);
	}

}
