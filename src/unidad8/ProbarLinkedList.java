package unidad8;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;


public class ProbarLinkedList {
	


		public static void main(String[] args) {
			// Agregamos pol�gonos
			Poligono penta = new Poligono(5,10, 0, 0);
			Poligono hexa = new Poligono(6,20, 1, 1);
			Poligono hepta = new Poligono(7,30, 2, 2);
			Poligono octo = new Poligono(8,40, 3, 3);
			Poligono enea = new Poligono(9,50, 4, 4);
			Poligono deca = new Poligono(10,60, 5, 5);
			
			
			//creo la lista inicialmente vac�a
			LinkedList<Poligono> miLista= new LinkedList<>();
			
			//agrego elementos a la lista
			
			miLista.add(penta);
			miLista.add(hexa);
			miLista.add(hepta);
			
			//compruebo cu�ntos tengo
			System.out.printf(" Ahora tengo en lista  %d  poligonos %n", miLista.size());
			
			//creo una sublista y los agrego a la primera
			
			LinkedList<Poligono>subLista = new LinkedList<>();
			subLista.add(octo);
			subLista.add(enea);
			
			//agrego la sublista a la lista
			miLista.addAll(subLista);
			
			//vuelvo a comprobar cu�ntos tengo
			
			System.out.printf(" Ahora tengo en lista  %d  pol�gonos%n ", miLista.size());
			
			//los voy a mostrar:
			System.out.println("*** Contenido de la lista con un For ***");
			for (Poligono poli: miLista){
				System.out.println(poli);
			}
			
			//otra forma de mostrarlos, con un iterador
			System.out.println("*** Contenido de la lista con un Iterator ***");
			
			for (Iterator<Poligono> it=miLista.iterator(); it.hasNext(); ){
				
				System.out.println(it.next().toString());
				
			}
			
			//podemos tambi�n recorrerlo al rev�s, con un ListIterator
			System.out.println("*** Contenido de la lista con un ListIterator ***");
			ListIterator<Poligono> li = miLista.listIterator(miLista.size());
			
			while (li.hasPrevious())
			{
				System.out.println(li.previous().toString());
			}
			
			//pruebo los métodos de LinkedList pop() y push() para gestionar una pila
			System.out.println("Quito del comienzo el elemento..." + miLista.pop());
			System.out.println("Quito del comienzo el elemento..." + miLista.pop());
			System.out.println("Agrego al comienzo el elemento..." + deca.toString());
			miLista.push(deca);
			
			//muestro ahora lo que tengo

			System.out.println("*** Contenido de la lista tras usar pop ***");

			for (Poligono poli: miLista){
				System.out.println(poli);
			}
			
			

		} // fin clase main()

	}


