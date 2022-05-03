package ejercicio8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class AgendaContactos {

	// objeto mapa donde vamos a guardar todos los contactos, ordenados por
	// apellidos
	static TreeMap<String, String> agendaContactos = new TreeMap<>();
	static Scanner lector = new Scanner(System.in);

	/**
	 * Método para mostrar el menú de opciones de la aplicación y recoger una opción
	 * @return entero con la opción elegida por el usuario
	 */
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
	 * @param nombre cadena con el nombre (al menos 3 caracteres)
	 * @param apellidos cadena con el nombre (al menos 3 caracteres)
	 * @param telefono cadena con el teléfono (al menos 9 dígitos)
	 * @return Verdadero si el contacto no existía en la agenda y se pudo agregar, Falso en otro caso
	 * @throws IllegalArgumentException si alguno de los campos no cumple la condición de validación 
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
	 * Método para buscar contactos en la agenda por un patrón de búsqueda
	 * @param patron cadena buscada, puede ser una parte del nombre o apellido
	 * @return Lista con todos los contactos cuyo nombre y/o apellido contienen la cadena buscada
	 */
	static public List<String> localizarContacto(String patron) {
		List<String> listaContactos = new ArrayList<>();


		if (!agendaContactos.isEmpty()) {
				//obtengo la lista de todas las claves

			Set<String> nombres = agendaContactos.keySet();
			
			// hago un iterador y compruebo si la clave se ajusta al patrón de búsqueda
			for (String nombre : nombres) {
			
			
				if (nombre.contains(patron)) {
					listaContactos.add(String.format("\n%30s   %15s", nombre, agendaContactos.get(nombre)));
				}

			} // fin del bucle for

		} 
		return listaContactos;
	}

	/**
	 * Método para localizar un contacto por el número de teléfono
	 * @param telefono Cadena con el número de teléfono a buscar
	 * @return Cadena con los datos del contacto al que pertenece ese número de teléfono, si se encuentra
	 */
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

	/**
	 * Método para actualizar el número de teléfono de un contacto ya existente
	 * @param nombre Cadena con el nombre del contacto a actualizar
	 * @param apellidos Cadena con los apellidos
	 * @param telefono Cadena con el nuevo número de teléfono
	 * @return Verdadero si se encuentra el contacto  y se puede sustituir su teléfono, Falso en caso contrario
	 */
	static public boolean actualizarContacto(String nombre, String apellidos, String telefono) {
		// el teléfono ya nos llega validado; no es necesario volverlo a comprobar

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

	/**
	 * Método para eliminar un contacto de la agenda
	 * @param nombre Cadena con el nombre
	 * @param apellidos Cadena con el apellido del contacto a eliminar
	 * @return Verdadero si se encontraba en la agenda y se pudo eliminar, Falso en otro caso
	 */
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

	/**
	 * Método para comprobar si un contacto existe ya en la agenda
	 * @param apellidos apellido del contacto
	 * @param nombre nombre del Contacto
	 * @return Verdadero si ya existe en la agenda, Falso en otro caso
	 */
	static boolean existeContacto(String apellidos, String nombre) {
		if (agendaContactos.containsKey(apellidos.toUpperCase() + " " + nombre.toUpperCase())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Método para validar un nombre o apellido
	 * @param nombre Cadena a validar
	 * @return Verdadero si al menos tiene 3 caracteres, Falso en otro caso
	 */
	static boolean validarNombre(String nombre) {
		if (nombre.trim().length() >= 3) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Método para validar un número de teléfono
	 * @param telefono Cadena con el número de teléfono
	 * @return Verdadero si consta de al menos 9 dígitos, Falso en otro caso
	 */
	static boolean validarTelefono(String telefono) {
		if (telefono.matches("^\\d{9,}$")) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		int opcion;
		String nombre, apellidos, telefono="";
		List<String> listaContactos;

		// la estructura do-while permite que utilice sucesivamente
		// el programa mientras no elija la última opción
		do {

			opcion = mostrarMenu();

			switch (opcion) {
			case 1:
				
				boolean repetir=true;
				//el bucle se repite hasta que se introduzca un contacto con los campos válidos
				while (repetir) {
					try {
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
						repetir=false;
					} catch (Exception e) {
						System.out.println("Error " + e.getMessage()+"\n Por favor, repite de nuevo");
					}
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
				boolean telefonoOK=false;
				while(!telefonoOK) {
					System.out.print("\n Nuevo Teléfono: >>");
					telefono = lector.next();
					if (validarTelefono(telefono)) {
						//teléfono válido. Provocamos la salida del bucle
						telefonoOK=true;
					}else {
						System.out.println("El teléfono no es válido. Por favor, escríbelo de nuevo");
					}
				}
				
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
