package unidad8.agenda;

import java.util.Set;
import java.util.TreeMap;

public class AgendaContactos {

	// objeto mapa donde vamos a guardar todos los contactos, ordenados por
	// apellidos
	TreeMap<String, Contacto> agendaContactos;

	/**
	 * Constructor único de la clase
	 */
	public AgendaContactos() {
		// instancio la agenda: es decir, el objeto TreeMap inicialmente sin contactos
		agendaContactos = new TreeMap<String, Contacto>();

	}

	/*
	 * Método para agregar un nuevo contacto a la agenda
	 * 
	 * @param nombre
	 * 
	 * @param apellidos
	 * 
	 * @param telefono Agrega un nuevo contacto a la agenda, o lo sobreescribe si ya
	 * hay otro contacto con el mismo apellido
	 */
	public void agregarContacto(String nombre, String apellidos, String telefono) {

		Contacto miContacto = new Contacto(nombre, apellidos, telefono);

		this.agendaContactos.put(apellidos.toUpperCase(), miContacto);

	}

	/**
	 * Método para mostrar la lista de contactos en la agenda Se recupera la lista
	 * (Set) de apellidos ordenada alfabéticamente para mostrar los contactos
	 * ordenados
	 */

	public void listarAgenda() {

		// obtenemos la lista con las claves
		Set<String> listaApellidos = agendaContactos.keySet();

		Contacto miContacto;

		// iteramos sobre la lista de claves
		for (String apellido : listaApellidos) {

			miContacto = agendaContactos.get(apellido);
			System.out.println(miContacto.toString());

		}

	}

	/**
	 * Método que busca y recupera un contacto en la agenda
	 * 
	 * @param apellidos apellido del contacto que deseamos buscar
	 * @return información del contacto -si existe- o cadena vacía- si no existe-
	 */
	public String buscarContacto(String apellidos) {

		String resultado = "No Encontrado";

		// usamos el método containsKey para saber si tengo ese contacto
		apellidos=apellidos.toUpperCase(); //normalizo la cadena de búsqueda
		if (agendaContactos.containsKey(apellidos)) {

			Contacto miContacto = agendaContactos.get(apellidos);
			resultado = miContacto.toString();

		}

		return resultado;

	}

}
