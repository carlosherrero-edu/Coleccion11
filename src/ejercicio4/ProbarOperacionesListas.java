package ejercicio4;

import java.util.Arrays;
import java.util.List;

public class ProbarOperacionesListas {

	public static void main(String[] args) {
		//defino varias listas de nombres
		String[] lista1= { "Carlos","Ana","Jorge","Julia","Santiago","Isabel",
							"Pedro","Martina","Lucas","Camila"};
		
		String [] lista2 = {"Manuel", "Julia", "Jorge","Rosana","Fidel","Camila",
							"Lucas", "Lorena"};
		
		//convierto las listas en arraylists
		List<String> lista1AL = Arrays.asList(lista1);
		List<String> lista2AL = Arrays.asList(lista2);
		
		//obtengo ahora las listas unión, intersección y diferencia
		
		List<String> union= OperacionesListas.unirListas(lista1AL, lista2AL);
		
		List<String> interseccion = OperacionesListas.intersectarListas(lista1AL, lista2AL);
		
		List<String> resta= OperacionesListas.restarListas(lista1AL, lista2AL);
		
		//presentamos resultados
		System.out.println("\n\n  UNIÓN DE LAS LISTAS ");
		for (String item: union) {
			System.out.format("%s *** ", item);
		}
		
		
		System.out.println("\n\n  iNTERSECCIÓN DE LAS LISTAS ");
		for (String item: interseccion) {
			System.out.format("%s *** ", item);
		}
		
		System.out.println("\n\n  DIFERENCIA DE LAS LISTAS ");
		for (String item: resta) {
			System.out.format("%s *** ", item);
		}

	}

}
