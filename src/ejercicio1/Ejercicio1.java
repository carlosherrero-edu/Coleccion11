package ejercicio1;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Ejercicio1 {
	
	static final int MAXIMO=100; 
	
	static Random azar=new Random();
	

	public static void main(String[] args) {
		
		
		LinkedList<Integer> miLista= new LinkedList<>();
		
		//generar y agregar números aleatorios
		
		for (int i=0; i<25; i++) {
			miLista.add(azar.nextInt(MAXIMO+1));
		}
		 
		//calcular la suma
		int suma=0;
		
		for (Iterator<Integer> it=miLista.listIterator(); it.hasNext();) {
			
			suma+=it.next().intValue();
		}
		
		System.out.format ("\n Suma : %d \n Promedio: %.2f %n" ,
								suma, suma/(double)miLista.size());
		
		//ordenar la lista
		Collections.sort(miLista);
		
		//recorrerla ordenada
		
		int contador=0;
		for (Integer numero:miLista) {
			contador++;
			System.out.printf("%3d ", numero);
			if (contador==5) {
				System.out.println();
				contador=0;
			}
		
		}
		
		
		
		
		
	}

}
