package ejercicio9;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Ejercicio9 {
	
	static Scanner teclado= new Scanner(System.in);
	
	static final String SEPARADOR="[\\p{Space}\\p{Punct}]\\p{Space}*";
	
	static Map<String, Integer> diccionario= new TreeMap<>();

	public static void main(String[] args) {
		
		System.out.println("Escribe tu frase");
		String frase= teclado.nextLine();
		
		String[] palabras= frase.toLowerCase().split(SEPARADOR);
		
		//recorre la lista de palabras que he obtenido
		for (String termino: palabras) {
			
			//comprobar si la palabra está ya en el diccionario
			if (diccionario.containsKey(termino)) {
				//obtengo el número de veces que se había repetido
				int repeticiones= diccionario.get(termino);
				//lo vuelvo a guardar con ese número incrementado en 1
				diccionario.replace(termino, repeticiones+1);
				
			} else {
				//falso: el término no está en el diccionario
				diccionario.put(termino, 1);
			}
			
		}
		
		//mostramos el diccionario
		Set<String> indices=diccionario.keySet();
		
		
		for (String termino: indices) {
			System.out.format("\n %s : %2d", termino, diccionario.get(termino));
			
		}
		
		
	}

}
