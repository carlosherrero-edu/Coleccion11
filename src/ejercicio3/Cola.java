package ejercicio3;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Cola<T> {
	
	//propiedad única
		LinkedList<T> lista;

	public Cola() {
		lista=new LinkedList<>();		
	}
	
	//métodos
	public void agregar (T nodo) {
		//agregamos los nodos por el final
		lista.addLast(nodo);
	}
	
	public T eliminar() {
		if (lista.isEmpty()) {
			return null;
		} else {
			return lista.pop();
		}	
	}
	
	public String proximoEnSalir() {
		
		try {
			return lista.getFirst().toString();
		} catch (NoSuchElementException e) {
			return null;
		}
	}
	
	public int cuantos() {
		return lista.size();
	}
	
	@Override()
	public String toString() {
		/* 
		 * Tenemos que recorrer la cola del principio al final
		 * el elemento más antiguo está al comienzo
		 * el último elemento en llegar está al fianl
		 */
		String resultado="";
		
		
		ListIterator<T> li= lista.listIterator(0);
		
		while (li.hasNext()) {
			resultado+=li.next().toString()+"\n";
		}
		return resultado;
	}
	
	

}
