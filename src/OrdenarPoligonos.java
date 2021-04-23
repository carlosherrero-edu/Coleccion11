import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import plantillas.*;


/**
 * Clase para mostrar cómo se ordenan objetos utilizando la interfaz Comparator
 * 
 * El orden se realizará basándonos en el número de lados y en su longitud
 * @author Carlos Herrero
 *
 */
class DefinirOrden implements Comparator<Poligono>{
	
	//sólo codificamos el método compare()
	@Override
	public int compare(Poligono o1, Poligono o2) {
		int resultado;
		if (o1.getNum_lados() <o2.getNum_lados()) {
			resultado=-1;
		} else if (o1.getNum_lados() > o2.getNum_lados()) {
			resultado=+1;
		} else {
			//decidir en función de la longitud del lado
			Double longitud1= Double.valueOf(o1.getLado());
			Double longitud2= Double.valueOf(o2.getLado());
			resultado= longitud1.compareTo(longitud2);
			
			
		}
		return resultado;
	}
	
}

public class OrdenarPoligonos {
	
	
	//lista estáticoa con los polígonos que guardaremos
	static ArrayList<Poligono> listaPoligonos;
	
	//constructor
	public OrdenarPoligonos() {
		listaPoligonos= new ArrayList<>();
	}
	
	//método para rellenar la lista
	static void rellenarLista() {
		listaPoligonos.add(new Poligono(5,20));
		listaPoligonos.add(new Poligono(8,30));
		listaPoligonos.add(new Poligono(3,50));
		listaPoligonos.add(new Poligono(3,20));
		listaPoligonos.add(new Poligono(8,45));
		listaPoligonos.add(new Poligono(5,45));
		listaPoligonos.add(new Poligono(8,20));
	}
	
	//método para imprimir la lista
	static void mostrarLista() {
		for (Poligono poli: listaPoligonos) {
			System.out.println(poli.toString());
		}
	}

	public static void main(String[] args) {
		rellenarLista();
		
		//ordenamos la lista pasando un objeto creado al vuelo de la clase DefinirOrden
		Collections.sort(listaPoligonos, new DefinirOrden());
		
		mostrarLista();

	}

}
