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
class DefinirOrden implements Comparator<PoligonoSinComparator>{
	
	//sólo codificamos el método compare()
	@Override
	public int compare(PoligonoSinComparator o1, PoligonoSinComparator o2) {
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
	
} //fin de la clase DefinirOrden

public class OrdenarPoligonos {
	
	
	//lista estática con los polígonos que guardaremos
	static ArrayList<PoligonoSinComparator> listaPoligonos=new ArrayList<>();
	
	
	
	//método para rellenar la lista
	static void rellenarLista() {
		listaPoligonos.add(new PoligonoSinComparator(5,20));
		listaPoligonos.add(new PoligonoSinComparator(8,30));
		listaPoligonos.add(new PoligonoSinComparator(3,50));
		listaPoligonos.add(new PoligonoSinComparator(3,20));
		listaPoligonos.add(new PoligonoSinComparator(8,45));
		listaPoligonos.add(new PoligonoSinComparator(5,45));
		listaPoligonos.add(new PoligonoSinComparator(8,20));
	}
	
	//método para imprimir la lista
	static void mostrarLista() {
		for (PoligonoSinComparator poli: listaPoligonos) {
			System.out.println(poli.toString());
		}
	}

	public static void main(String[] args) {
		rellenarLista();
		
		
		//ordenamos la lista pasando un objeto creado al vuelo de la clase DefinirOrden
		Collections.sort(listaPoligonos, new DefinirOrden());
		//Collections.sort(listaPoligonos);
		
		mostrarLista();

	}

}
