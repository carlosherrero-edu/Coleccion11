package traducciones;
import java.util.HashMap;

public class Traducciones {
	
	static final int VALOR_MIN=0;
	static final int VALOR_MAX=99;
	
	static final int[] UNIDADES= {0,1,2,3,4,5,6,7,8,9};
	static final int[] DECENAS= {20,30,40,50,60,70,80,90};
	static final int[] NUM_TEENS= { 10,11,12,13,14,15,16,17,18,19};
	
	
	static  HashMap<Integer, String> dicUnidades , dicDecenas ,dicTeens;

	
	
	
	static void rellenarUnidades() {
		dicUnidades= new HashMap<Integer,String>();
		
		String [] nombres= {"cero", "uno", "dos","tres", "cuatro", "cinco","seis", 
							"siete", "ocho", "nueve"};
		
		
		for (int i=0; i<UNIDADES.length; i++) {
			dicUnidades.put(UNIDADES[i], nombres[i]	);
		}
		
	}
	
	static void rellenarDecenas() {
		dicDecenas= new HashMap<Integer,String>();
		
		String [] nombres= {"veinte", "treinta", "cuarenta", "cincuenta", "sesenta",
							"setenta", "ochenta", "noventa"};
		
		for (int i=0; i<DECENAS.length; i++) {
			dicDecenas.put(DECENAS[i], nombres[i]	);
		}
		
		
	}
	
	static void rellenarTeens() {
		dicTeens= new HashMap<Integer,String>();
		
		String [] nombres= {"diez", "once", "doce","trece", "catorce", "quince",
				"dieciséis", "diecisiete", "dieciocho", "diecinueve"};
		
		for (int i=0; i<NUM_TEENS.length; i++) {
			dicTeens.put(NUM_TEENS[i], nombres[i]	);
		}
		
	}
	
	static void rellenarDiccionarios() {
		rellenarUnidades();
		rellenarDecenas();
		rellenarTeens();
	}
	
	public static String traducirNumero (int numero) {
		
		String traduccion="";
		
		if (dicUnidades==null) {
			//si no están inicializados los diccionarios, lo hacemos una vez
			rellenarDiccionarios();
		}
		
		if (numero<VALOR_MIN || numero> VALOR_MAX) {
			throw new IllegalArgumentException("Sólo admito números entre "+ VALOR_MIN + " y "+ VALOR_MAX);
		}
		
		
		
		if (numero <10) {
			traduccion= dicUnidades.get(Integer.valueOf(numero));
		} else if (numero<20) {
			traduccion= dicTeens.get(Integer.valueOf(numero));
		} else {
			int decenas=10*(int)(numero/10);
			int unidades= numero%10;
			traduccion= dicDecenas.get(Integer.valueOf(decenas));
			if (unidades>0) {
				traduccion = traduccion+" y "+ dicUnidades.get(Integer.valueOf(unidades));
			}
		}
			
		//colocamos la primera letra en mayúsculas
			
		traduccion =traduccion.substring(0, 1).toUpperCase()+ traduccion.substring(1);
		
		return traduccion;
	}
	

	

}
