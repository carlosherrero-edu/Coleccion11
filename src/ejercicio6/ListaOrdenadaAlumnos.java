package ejercicio6;

import java.util.Arrays;

import java.util.TreeSet;

public class ListaOrdenadaAlumnos {

	// campo único
	TreeSet<Alumno> listaAlum;

	public ListaOrdenadaAlumnos(Alumno[] arrayAlum) {

		listaAlum = new TreeSet<>(Arrays.asList(arrayAlum));
		// TODO Auto-generated constructor stub
	}

	public TreeSet<Alumno> obtenerAlumnosAprobados() {

		/*
		 * 1. Localizar el primer alumno cuya nota media es mayor a igual a 5
		 * 
		 * 2. llamar al método tailSet() pasándole ese alumno y el parámetro true
		 */
		Alumno primerAprobado = null;
		// localizo el primer alumno aprobado
		for (Alumno alu : listaAlum) {
			if (alu.getNotaMedia() >= 5) {
				primerAprobado = alu;
				break;
			}
		} // fin del for
			// devuelvo la sublista de alumnos a partir de primerAprobado
		return (TreeSet<Alumno>) listaAlum.tailSet(primerAprobado, true);
	}

	public TreeSet<Alumno> obtenerAlumnosSuspensos() {

		/*
		 * 1. Localizar el primer alumno cuya nota media es mayor a igual a 5 2. llamar
		 * al método headSet() pasándole ese alumno y el parámetro false
		 */
		Alumno primerAprobado = null;
		// localizo el primer alumno aprobado
		for (Alumno alu : listaAlum) {
			if (alu.getNotaMedia() >= 5) {
				primerAprobado = alu;
				break;
			}
		} // fin del for
			// devuelvo la sublista de alumnos a partir de primerAprobado
		return (TreeSet<Alumno>) listaAlum.headSet(primerAprobado, false);
	}

}
