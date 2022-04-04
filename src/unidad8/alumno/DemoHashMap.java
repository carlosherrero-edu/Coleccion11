package unidad8.alumno;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DemoHashMap {

	public static void main(String[] args) {
		// Creo varias instancias de alumno

		Alumno alu1 = new Alumno(100001, "Luis", "Berlanga", 4);
		Alumno alu2 = new Alumno(200002, "Pilar", "Miro", 4);
		Alumno alu3 = new Alumno(300003, "Iztiar", "Boallin", 4);
		Alumno alu4 = new Alumno(400004, "Luis", "Buñuel", 4);
		Alumno alu5 = new Alumno(500005, "Isabel", "Coixet", 4);
		Alumno alu6 = new Alumno(600006, "Mario", "Camus", 4);
		Alumno alu7 = new Alumno(700007, "Jose Luis", "Garci", 4);

		// a continuacion les asigno calificaciones
		// 3 aprueban y 3 suspenden
		alu1.asignarCalificaciones(new double[] { 6.5, 3.5, 7, 4.25 });
		alu2.asignarCalificaciones(new double[] { 6.25, 3.5, 7, 4.25 });
		alu3.asignarCalificaciones(new double[] { 6.5, 3.5, 7.5, 4.25 });
		alu4.asignarCalificaciones(new double[] { 6.5, 3.5, 5, 3.25 });
		alu5.asignarCalificaciones(new double[] { 6.25, 3.5, 5, 3.25 });
		alu6.asignarCalificaciones(new double[] { 6.5, 3.5, 5.5, 3.25 });
		alu7.asignarCalificaciones(new double[] { 6.5, 3.5, 5.5, 3.55 });

		// creo el array de alumnos, pero sin el alumno 7
		Alumno[] arrayAlu = { alu3, alu2, alu6, alu1, alu5, alu4 };

		// defino el haspmap de Alumnos
		Map<Integer, Alumno> miTabla = new HashMap<Integer, Alumno>();

		// voy guardando los alumnos en el hashMap por su clave nia
		// notar que encapsulamos el nia en la clase envolvente Integer

		for (Alumno alu : arrayAlu) {
			miTabla.put(Integer.valueOf(alu.getNia()), alu);
			System.out.format(" %n Alumno con Nia %d correctamente agregado ", alu.getNia());
		}

		// guardo un nuevo elemento, comprobando antes que no existe por la clave
		if (miTabla.containsKey(Integer.valueOf(alu7.getNia()))) {
			System.out.format(" %n El alumno con nia %d ya existe ", alu7.getNia());
		} else { // el alumno no existe, puedo a�adirlo
			miTabla.put(Integer.valueOf(alu7.getNia()), alu7);
			System.out.format(" %n Alumno con Nia %d correctamente agregado ", alu7.getNia());
		}

		// pero no necesito comprobarlo, pues no se guardan elementos duplicados por la
		// clave
		miTabla.put(Integer.valueOf(alu7.getNia()), alu7);

		// recorremos los elementos del mapa, bas�ndonos en el set de sus claves
		Set<Integer> listaClaves = miTabla.keySet();

		for (Integer clave : listaClaves) {
			System.out.format("%n\tNIA:  %d***Apellidos y Nombre: %-20s *** Nota media: %.2f", clave.intValue(),
					miTabla.get(clave).getApellidos() + " " + miTabla.get(clave).getNombre(),
					miTabla.get(clave).getNotaMedia());

		}

		System.out.println("\nNumero de alumnos: " + miTabla.size());

	}

}
