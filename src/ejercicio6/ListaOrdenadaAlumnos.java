package ejercicio6;

import java.util.Arrays;
import java.util.TreeSet;

public class ListaOrdenadaAlumnos {
	
	//campo �nico
	TreeSet<Alumno> listaAlum;

	public ListaOrdenadaAlumnos(Alumno[] arrayAlum) {
		
		
		listaAlum= new TreeSet<>(Arrays.asList(arrayAlum));
		// TODO Auto-generated constructor stub
	}
	
	public Set<Alumno> obtenerAlumnosAprobados(){
		
		/*
		 * 1. Localizar el primer alumno cuya nota media es mayor a igual a 5
		 * 2. llamar al m�todo tailSet() pas�ndole ese alumno y el par�metro true
		 */
	}
	
public Set<Alumno> obtenerAlumnosSuspensos(){
		
		/*
		 * 1. Localizar el primer alumno cuya nota media es mayor a igual a 5
		 * 2. llamar al m�todo headSet() pas�ndole ese alumno y el par�metro false
		 */
	}

}
