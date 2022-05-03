package ejercicio6;

import java.util.Arrays;
import java.util.TreeSet;

public class ListaOrdenadaAlumnos {
	
	//campo único
	TreeSet<Alumno> listaAlum;

	public ListaOrdenadaAlumnos(Alumno[] arrayAlum) {
		
		
		listaAlum= new TreeSet<>(Arrays.asList(arrayAlum));
		// TODO Auto-generated constructor stub
	}
	
	public Set<Alumno> obtenerAlumnosAprobados(){
		
		/*
		 * 1. Localizar el primer alumno cuya nota media es mayor a igual a 5
		 * 2. llamar al método tailSet() pasándole ese alumno y el parámetro true
		 */
	}
	
public Set<Alumno> obtenerAlumnosSuspensos(){
		
		/*
		 * 1. Localizar el primer alumno cuya nota media es mayor a igual a 5
		 * 2. llamar al método headSet() pasándole ese alumno y el parámetro false
		 */
	}

}
