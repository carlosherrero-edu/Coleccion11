import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import plantillas.*;


/**
 * Clase para mostrar c�mo se ordenan objetos utilizando la interfaz Comparator
 * 
 * El orden se realizar� bas�ndonos en el n�mero de lados y en su longitud
 * @author Carlos Herrero
 *
 */
class DefinirOrden implements Comparator<PoligonoSinComparator>{
	
	//s�lo codificamos el m�todo compare()
	@Override
	public int compare(PoligonoSinComparator o1, PoligonoSinComparator o2) {
		int resultado;
		if (o1.getNum_lados() <o2.getNum_lados()) {
			resultado=-1;
		} else if (o1.getNum_lados() > o2.getNum_lados()) {
			resultado=+1;
		} else {
			//decidir en funci�n de la longitud del lado
			Double longitud1= Double.valueOf(o1.getLado());
			Double longitud2= Double.valueOf(o2.getLado());
			resultado= longitud1.compareTo(longitud2);
			
			
		}
		return resultado;
	}
	
} //fin de la clase DefinirOrden

public class OrdenarPoligonos {
	
	
	//lista est�tica con los pol�gonos que guardaremos
	static ArrayList<PoligonoSinComparator> listaPoligonos=new ArrayList<>();
	
	
	
	//m�todo para rellenar la lista
	static void rellenarLista() {
		listaPoligonos.add(new PoligonoSinComparator(5,20));
		listaPoligonos.add(new PoligonoSinComparator(8,30));
		listaPoligonos.add(new PoligonoSinComparator(3,50));
		listaPoligonos.add(new PoligonoSinComparator(3,20));
		listaPoligonos.add(new PoligonoSinComparator(8,45));
		listaPoligonos.add(new PoligonoSinComparator(5,45));
		listaPoligonos.add(new PoligonoSinComparator(8,20));
	}
	
	//m�todo para imprimir la lista
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
