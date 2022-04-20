package ejercicio2;

import java.util.LinkedList;
import java.util.ListIterator;

public class Pila<T> {
	
	//propiedad �nica
	LinkedList<T> lista;

	public Pila() {
		lista=new LinkedList<>();
	}
	
	public void agregar (T nodo) {
		lista.push(nodo);
	}
	
	public T eliminar() {
		if (lista.isEmpty()) {
			return null;
		} else {
			return lista.pop();
		}	
		
	}
	
	public String proximoEnSalir() {
		if (lista.isEmpty()) {
			return null;
		} else {
			return lista.getFirst().toString();
		}
		
	}
	
	public int cuantos() {
		return lista.size();
	}
	
	@Override
	public String toString() {
		String resultado="";
		ListIterator<T> li= lista.listIterator(lista.size());
		
		while (li.hasPrevious()) {
			resultado+=li.previous().toString()+"\n";
		}
		return resultado;
	}
	
	public static void main(String[] args) {
		
		Pila<String> listaNombres= new Pila<>();
		
		listaNombres.agregar("Pepe");
		listaNombres.agregar("Marta");
		listaNombres.agregar("Joaquín");
		listaNombres.agregar("Carmen");
		
		System.out.println("Elementos :"+ listaNombres.cuantos());
		
		System.out.println("Próximo en salir  :"+ listaNombres.proximoEnSalir());
		
		System.out.println(listaNombres.toString());
		
	}

}
