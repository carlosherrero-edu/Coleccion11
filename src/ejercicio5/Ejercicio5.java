package ejercicio5;

import java.util.Scanner;

import java.util.TreeSet;

public class Ejercicio5 {

	static Scanner lector=new Scanner(System.in);
	
	TreeSet<String> nombres;
	
	
	
	public Ejercicio5() {
		nombres=new TreeSet<>();
	}
	
	
	
	
	public void leerNombres() {
		
		System.out.println("Escribe una lista de nombres, 'fin' para terminar");
		
		String leido;
		leido=lector.nextLine();
		while (!leido.equalsIgnoreCase("fin")) {
			nombres.add(leido);
			leido=lector.nextLine();
		}
		
	}
	
	public void recuperarNombres(){
		
		for (String leido: nombres) {
			System.out.println(leido);
		}
		
	}

	public void buscarNombres() {
		
	}
	
	public static void main(String[] args) {
		
		Ejercicio5 prueba=new Ejercicio5();
		prueba.leerNombres();
		prueba.recuperarNombres();
		prueba.leerNombres();
		prueba.recuperarNombres();
		
	}
		
	

}
