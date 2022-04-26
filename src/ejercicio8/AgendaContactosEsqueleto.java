package ejercicio8;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class AgendaContactosEsqueleto {

	// objeto mapa donde vamos a guardar todos los contactos, ordenados por
	// apellidos
	static TreeMap<String, String> agendaContactos = new TreeMap<>();
	static Scanner lector = new Scanner(System.in);

	static int mostrarMenu() {

		int eleccion;
		do {
			String menu = """
					Listado de opciones:
					--------------------
					        1 - Agregar nuevo contacto
					        2 - Listar la agenda
					        3 - Recuperar contactos por nombre
					        4 - Localizar contacto por teléfono
					        5 - Actualizar un contacto
					        6 - Eliminar un contactgo
					        7 - Salir.

					        Elige una opción. 7 para Salir: >>>
						"""; // fin de cadena multlínea
			System.out.print(menu);

			eleccion = lector.nextInt();
		} while (eleccion < 1 || eleccion > 7);

		return eleccion;

	} // fin del método mostrarMenú

	/*
	 * MÃ©todo para agregar un nuevo contacto a la agenda
	 * 
	 * @param nombre
	 * 
	 * @param apellidos
	 * 
	 * @param telefono Agrega un nuevo contacto a la agenda, o lo sobreescribe si ya
	 * hay otro contacto con el mismo apellido
	 */
	static public boolean agregarContacto(String nombre, String apellidos, String telefono) {

		return false;

	}// fin del método

	/**
	 * MÃ©todo para mostrar la lista de contactos en la agenda Se recupera la lista
	 * (Set) de apellidos ordenada alfabÃ©ticamente para mostrar los contactos
	 * ordenados
	 */

	static public void listarAgenda() {

		

	}// fin del método

	/**
	 * MÃ©todo que busca y recupera un contacto en la agenda
	 * 
	 * @param apellidos apellido del contacto que deseamos buscar
	 * @return informaciÃ³n del contacto -si existe- o cadena vacÃ­a- si no existe-
	 */
	static public List<String> localizarContacto(String apellidos) {

		return null;
	}

	static public String localizarTelefono(String telefono) {
		return null;
	}

	static public boolean actualizarContacto(String nombre, String apellidos, String telefono) {
		return false;
	}

	static public boolean eliminarContacto(String nombre, String apellidos) {

		return false;
	}

	static boolean existeContacto(String apellidos, String nombre) {
		if (agendaContactos.containsKey(apellidos.toUpperCase() + " " + nombre.toUpperCase())) {
			return true;
		} else {
			return false;
		}
	}

	static boolean validarNombre(String nombre) {
		if (nombre.trim().length() >= 3) {
			return true;
		} else {
			return false;
		}
	}

	static boolean validarTelefono(String telefono) {
		if (telefono.matches("^\\d{9,}$")) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		int opcion;

		// la estructura do-while permite que utilice sucesivamente
		// el programa mientras no elija la última opción
		do {

			opcion = mostrarMenu();

			switch (opcion) {
			case 1:
				// TODO
				break;

			case 2:
				// TODO

				break;

			case 3:
				// TODDO

				break;

			case 4:

				// TODO
				break;
			case 5:
				// TODO
				break;
			case 6:
				// TODO
				break;

			}

		} while (opcion != 7);

		// cuando salgamos, eliminamos los objetos abiertos
		lector.close();

		System.out.println("GRacias por usar mi programa. Hasta la próxima...");
	}

}
