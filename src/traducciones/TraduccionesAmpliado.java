package traducciones;

import java.util.HashMap;

public class TraduccionesAmpliado {

	static final int VALOR_MIN = 0;
	static final int VALOR_MAX = 999;

	static final int[] UNIDADES = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static final int[] DECENAS = { 20, 30, 40, 50, 60, 70, 80, 90 };
	static final int[] NUM_TEENS = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };

	static HashMap<Integer, String> dicUnidadesES, dicDecenasES, dicTeensES;
	static HashMap<Integer, String> dicUnidadesEN, dicDecenasEN, dicTeensEN;

	static void rellenarUnidades() {
		dicUnidadesES = new HashMap<Integer, String>();
		dicUnidadesEN = new HashMap<Integer, String>();

		String[] nombres = { "cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve" };

		String[] nombresEN = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

		for (int i = 0; i < UNIDADES.length; i++) {
			dicUnidadesES.put(UNIDADES[i], nombres[i]);
			dicUnidadesEN.put(UNIDADES[i], nombresEN[i]);
		}

	}

	static void rellenarDecenas() {
		dicDecenasES = new HashMap<Integer, String>();
		dicDecenasEN = new HashMap<Integer, String>();

		String[] nombres = { "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa" };
		String[] nombresEN = { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

		for (int i = 0; i < DECENAS.length; i++) {
			dicDecenasES.put(DECENAS[i], nombres[i]);
			dicDecenasEN.put(DECENAS[i], nombresEN[i]);
		}

	}

	static void rellenarTeens() {
		dicTeensES = new HashMap<Integer, String>();
		dicTeensEN = new HashMap<Integer, String>();

		String[] nombres = { "diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete",
				"dieciocho", "diecinueve" };

		String[] nombresEN = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fiftenn", "sixteen", "seventeen",
				"eighteen", "nineteen" };

		for (int i = 0; i < NUM_TEENS.length; i++) {
			dicTeensES.put(NUM_TEENS[i], nombres[i]);
			dicTeensEN.put(NUM_TEENS[i], nombresEN[i]);
		}

	}

	static void rellenarDiccionarios() {
		rellenarUnidades();
		rellenarDecenas();
		rellenarTeens();
	}
	
	
	static String traducirUnidades(Idiomas opcion, int unidad) {

		String traduccion = switch (opcion) {
		case ES -> {
			yield dicUnidadesES.get(Integer.valueOf(unidad));
		}

		case EN -> {
			yield dicUnidadesEN.get(Integer.valueOf(unidad));
		}
		};

		return traduccion;

	}
	

	static String traducir11A20(Idiomas opcion, int numero) {

		String traduccion = switch (opcion) {
		case ES -> {
			yield dicTeensES.get(Integer.valueOf(numero));
		}

		case EN -> {
			yield dicTeensEN.get(Integer.valueOf(numero));
		}
		};

		return traduccion;

	}

	private static String traducirHasta99(Idiomas opcion, int numero) {
		String traduccion = "";

		if (numero < 10) {
			traduccion = traducirUnidades(opcion, numero);

		} else if (numero < 20) {
			traduccion =traducir11A20(opcion, numero);

		} else {

			int decenas = 10 * (int) (numero / 10);
			int unidades = numero % 10;

			switch (opcion) {
			case ES -> {
				traduccion = dicDecenasES.get(Integer.valueOf(decenas));
				if (unidades > 0) {
					traduccion = traduccion + " y " + traducirUnidades(Idiomas.ES, unidades);
				}

			}

			case EN -> {
				traduccion = dicDecenasEN.get(Integer.valueOf(decenas));
				if (unidades > 0) {
					traduccion = traduccion + " " + traducirUnidades(Idiomas.EN, unidades);
				}
			}
			}

		}

		return traduccion;

	}

	public static String traducirNumero(Idiomas opcion, int numero) {

		String traduccionFinal = "";

		if (dicUnidadesES == null || dicUnidadesEN == null) {
			// si no están inicializados los diccionarios, lo hacemos una vez
			rellenarDiccionarios();
		}

		if (numero < VALOR_MIN || numero > VALOR_MAX) {
			String mensaje = switch (opcion) {
			case ES -> {
				yield "\n Sólo admito números entre " + VALOR_MIN + " y " + VALOR_MAX;
			}

			case EN -> {
				yield "\n I just can translate numbers between " + VALOR_MIN + " and " + VALOR_MAX;
			}
			};
			throw new IllegalArgumentException(mensaje);
		}

		if (numero < 100) {
			// llamamos al método para traducir hasta 100
			traduccionFinal = traducirHasta99(opcion, numero);

		} else {
			int centenas = (int) (numero / 100);
			int resto = numero % 100;
			String traduccionHasta99 = "";

			// traducimos la parte que corresponde a las centenas
			String principio = traducirUnidades(opcion, centenas);

			// si el resto es >0, tenemos que traducir la parte de las decenas y unidades
			if (resto > 0) {
				traduccionHasta99 = traducirHasta99(opcion, resto);
			}

			switch (opcion) {
			case ES -> {
				// aquí hay varios casos particulares por las irregularidades del español
				if (numero == 100) {
					traduccionFinal = "cien";

				} else {
					String traduccionCentenas = switch (centenas) {
					case 1 -> {
						yield "ciento";
					}
					case 5 -> {
						yield "quinientos";
					}
					case 7 -> {
						yield "setecientos";
					}
					case 9 -> {
						yield "novecientos";
					}
					default -> {
						yield principio + "cientos";
					}
					};

					traduccionFinal = traduccionCentenas + " " + traduccionHasta99;
				}

			}

			case EN -> {
				if (resto > 0) {
					traduccionFinal = principio + " hundred and " + traduccionHasta99;
				} else {
					traduccionFinal = principio + " hundred";
				}
			}
			}

		}

		// colocamos la primera letra en mayúsculas

		traduccionFinal = traduccionFinal.substring(0, 1).toUpperCase() + traduccionFinal.substring(1);

		return traduccionFinal;
	}

}
