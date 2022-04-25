package ejercicio9;

import java.util.Scanner;

public class Ejercicio9 {
	
	static Scanner teclado= new Scanner(System.in);
	
	static final String SEPARADOR="[\\p{Space}\\p{Punct}]\\p{Space}*";

	public static void main(String[] args) {
		
		System.out.println("Escribe tu frase");
		String frase= teclado.nextLine();
		
		String[] palabras= frase.toLowerCase().split(SEPARADOR);
		
		
		for (String termino: palabras) {
			System.out.format(" %s, ", termino);
		}
		
	}

}
