package ejercicio8;

import java.util.ArrayList;
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

		// primero valido los campos
		if (!(validarNombre(nombre) && validarNombre(apellidos) && validarTelefono(telefono))) {
			throw new IllegalArgumentException("Hay campos incorrectos, por favor revísalos...");

		}
		// compruebo que no está en la agenda
		if (existeContacto(apellidos, nombre)) {
			return false;
		} else {
			String clave = apellidos.toUpperCase() + " " + nombre.toUpperCase();
			agendaContactos.put(clave, telefono);
			return true;
		}

	}// fin del método

	/**
	 * MÃ©todo para mostrar la lista de contactos en la agenda Se recupera la lista
	 * (Set) de apellidos ordenada alfabÃ©ticamente para mostrar los contactos
	 * ordenados
	 */

	static public void listarAgenda() {
		if (agendaContactos.isEmpty()) {
			System.out.println("La agenda está vacía");
			return;
		}
		Set<String> nombres = agendaContactos.keySet();

		System.out.format("\n%30s   %15s", "Apellidos y Nombre", "Teléfono");
		System.out.format("\n%30s   %15s", "------------------------------", "--------------");
		for (String nombre : nombres) {

			System.out.format("\n%30s   %15s", nombre, agendaContactos.get(nombre));
		}

	}// fin del método

	/**
	 * MÃ©todo que busca y recupera un contacto en la agenda
	 * 
	 * @param apellidos apellido del contacto que deseamos buscar
	 * @return informaciÃ³n del contacto -si existe- o cadena vacÃ­a- si no existe-
	 */
	static public List<String> localizarContacto(String patron) {
		List<String> listaContactos = new ArrayList<>();


		if (!agendaContactos.isEmpty()) {
				//obtengo la lista de todas las claves

			Set<String> nombres = agendaContactos.keySet();
			
			// hago un iterador y compruebo si la clave se ajusta al patrón de búsqueda
			for (String nombre : nombres) {
				if (nombre.matches(patron)) {
					listaContactos.add(String.format("\n%30s   %15s", nombre, agendaContactos.get(nombre)));
				}

			} // fin del bucle for

		} 
		return listaContactos;
	}

	static public String localizarTelefono(String telefono) {
		String resultado;
		if (agendaContactos.isEmpty()) {

			resultado = "La agenda está vacía";
		} else {
			// obtengo la lista de todas las claves

			Set<String> nombres = agendaContactos.keySet();
			resultado = "Teléfono no encontrado";
			// hago un iterador hasta que encuentre el teléfono que busco
			for (String nombre : nombres) {

				if (agendaContactos.get(nombre).equals(telefono)) {
					resultado = String.format("El teléfono %s pertenece a %s", telefono, nombre);
					break;
				}

			} // fin del bucle

		}
		return resultado;
	}

	static public boolean actualizarContacto(String nombre, String apellidos, String telefono) {
		// primero valido los campos
		if (!validarTelefono(telefono)) {
			throw new IllegalArgumentException("Por favor, revisa el teléfono...");

		}
		// compruebo que no está en la agenda
		if (existeContacto(apellidos, nombre)) {
			String clave = apellidos.toUpperCase() + " " + nombre.toUpperCase();
			agendaContactos.replace(clave, telefono);
			return true;
		} else {
			// no existe el contacto, no puedo actualizar
			return false;
		}
	}

	static public boolean eliminarContacto(String nombre, String apellidos) {

		if (existeContacto(apellidos, nombre)) {
			String clave = apellidos.toUpperCase() + " " + nombre.toUpperCase();
			agendaContactos.remove(clave);
			return true;
		} else {
			// no existe el contacto, no puedo eliminar
			return false;
		}
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
		String nombre, apellidos, telefono;
		List<String> listaContactos;

		// la estructura do-while permite que utilice sucesivamente
		// el programa mientras no elija la última opción
		do {

			opcion = mostrarMenu();

			switch (opcion) {
			case 1:
				System.out.println("Escribe la información del nuevo contacto");
				System.out.print("Nombre: >>");
				nombre = lector.next();
				System.out.print("\nApellido: >>");
				apellidos = lector.next();
				System.out.print("\nTeléfono: >>");
				telefono = lector.next();
				
				if (agregarContacto(nombre,apellidos,telefono)) {
					System.out.println("Se ha agregado el contacto a la agenda");
				}else {
					System.out.println("Este contacto ya está en la agenda");
				}
				break;

			case 2:
				listarAgenda();
				break;

			case 3:
				System.out.println("Escribe el nombre, apellidos o una parte de los mismos");

				String cadena = lector.next();
				listaContactos=localizarContacto(cadena.toUpperCase());
				if (listaContactos.isEmpty()) {
					System.out.println("No hay ningún contacto con esa cadena en el nombre/apellidos");
				} else {
					System.out.format("\n%30s   %15s", "Apellidos y Nombre", "Teléfono");
					System.out.format("\n%30s   %15s", "------------------------------", "--------------");
					for (String elemento:listaContactos) {
						System.out.println(elemento);
					}
				}
				break;

			case 4:

				System.out.println("Escribe el teléfono que quieres buscar");

				System.out.print("\n Teléfono: >>");
				telefono = lector.next();
				System.out.println(localizarTelefono(telefono));
				break;

			case 5:
				System.out.println("Escribe la información del contacto que vamos a actualizar");
				System.out.print("Nombre: >>");
				nombre = lector.next();
				System.out.print("\n Apellido: >>");
				apellidos = lector.next();
				System.out.print("\n Nuevo Teléfono: >>");
				telefono = lector.next();
				if (actualizarContacto(nombre,apellidos,telefono)) {
					System.out.println("Se ha actualizado el teléfono de " +nombre+" "+apellidos);
				}else {
					System.out.println("No se ha encontrado en la agenda a esta persona");
				}
				break;
				
			case 6:
				System.out.println("Escribe el nombre y apellidos del contacto a eliminar:");
				System.out.print("Nombre: >>");
				nombre = lector.next();
				System.out.print("\n Apellido: >>");
				apellidos = lector.next();
				if (eliminarContacto(nombre,apellidos)) {
					System.out.println("Se ha eliminado de la agenda a  " +nombre+" "+apellidos);
				}else {
					System.out.println("No se ha encontrado en la agenda a esta persona");
				}
				break;

			}

		} while (opcion != 7);

		// cuando salgamos, eliminamos los objetos abiertos
		lector.close();

		System.out.println("GRacias por usar mi programa. Hasta la próxima...");
	}

}
