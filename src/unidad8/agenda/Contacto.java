package unidad8.agenda;

public class Contacto {

	private String nombre;
	private String apellidos;
	private String telefono;

	/**
	 * Método para la validación del nombre
	 * 
	 * @param texto nombre: Debe empezar por mayúscula; el resto de caracteres
	 *              pueden ser letras, guión alto o el símbolo & Al menos debe
	 *              constar de 3 caracteres, y como máximo de 50
	 * @return true si cumple las condiciones de validación, false en caso contrario
	 */
	static boolean validaNombre(String texto) {
		return texto.matches("^[A-Z][\\w\\-&]{2,49}");
	}

	/**
	 * Método para la validación del apellido
	 * 
	 * @param texto apellido: Debe empezar por mayúscula; el resto de caracteres
	 *              pueden ser letras, guión alto o el símbolo & Al menos debe
	 *              constar de 3 caracteres, y como máximo de 100
	 * @return true si cumple las condiciones de validación, false en caso contrario
	 */
	static boolean validaApellidos(String texto) {
		return texto.matches("^[A-Z][\\w\\-&]{2,99}");
	}

	/**
	 * Método para la validación de un teléfono español
	 * 
	 * @param texto nombre: El primer dígito debe ser 6, 7 o 0. A continuación
	 *              tendrá otros 8 dígitos
	 * @return true si cumple las condiciones de validación, false en caso contrario
	 */
	static boolean validaTlfnoES(String texto) {
		return texto.matches("^[679][0-9]{8}");
	}

	/**
	 * Método para la validación de un número de teléfono extranjero
	 * 
	 * @param texto nombre: El primer carácter será '+'. El resto pueden ser dígitos
	 *              o guión alto, hasta 20 caracteres
	 * @return true si cumple las condiciones de validación, false en caso contrario
	 */
	static boolean validaTlfnoEX(String texto) {
		return texto.matches("^\\+[0-9\\-]{,20}");
	}

	/**
	 * Constructor de la clase ejecutando primero los validadores de cada campo
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param telefono
	 */
	public Contacto(String nombre, String apellido, String telefono) {

		if (validaNombre(nombre)) {
			this.nombre = nombre;
		} else {
			throw new IllegalArgumentException("El nombre no es correcto.");
		}

		if (validaApellidos(apellido)) {
			this.apellidos = apellido;
		} else {
			throw new IllegalArgumentException("El apellido no es correcto.");
		}

		if (validaTlfnoES(telefono) || validaTlfnoEX(telefono)) {
			this.telefono = telefono;

		} else {
			throw new IllegalArgumentException("El teléfono no es correcto.");
		}

	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	@Override
	public String toString() {
		return "Contacto: [Nombre: " + getNombre() + "\t Apellidos: " + getApellidos() + "\t Telefono: " + getTelefono()
				+ "]";
	}

}
