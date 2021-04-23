package ejercicio6;

import java.util.Arrays;
import java.util.TreeSet;
import plantillas.*;

/**
 * @author Alberto del Pozo
 *
 */
public class ListaOrdenadaAlumnos {

	private TreeSet<Alumno> alumnos;

	public ListaOrdenadaAlumnos(Alumno[] arrayAlum) {

		alumnos = new TreeSet<>(Arrays.asList(arrayAlum));

	}

	public TreeSet<Alumno> obtenerAlumnosAprobados() {

		Alumno aprobado = null;

		for (Alumno alu : alumnos) {
			if (alu.getNotaMedia() >= 5) {
				aprobado = alu;
				break;
			}
		}

		return (TreeSet<Alumno>) alumnos.tailSet(aprobado, true);

	}

	public TreeSet<Alumno> obtenerAlumnosSuspensos() {

		Alumno aprobado = null;

		for (Alumno alu : alumnos) {
			if (alu.getNotaMedia() >= 5) {
				aprobado = alu;
				break;
			}
		}
		return (TreeSet<Alumno>) alumnos.headSet(aprobado, false);
	}
}
