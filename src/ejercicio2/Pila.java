package ejercicio2;

import java.util.LinkedList;

public class Pila<T> {
	
	//propiedad única
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
		return null;
	}

}
