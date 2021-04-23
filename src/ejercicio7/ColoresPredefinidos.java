package ejercicio7;

import java.awt.Color;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;



public class ColoresPredefinidos {

	public static void main(String[] args) {
		
		//lista de colores predefinidos en Castellano. La vamos a mantener en un 
		

		// mapa para almacenarlos
		//Map<String,Color> colores= new HashMap<>();
		
		//Si queremos mostrar la lista ordenada, usaremos la clase TreeMap
		Map<String, Color> colores= new TreeMap<>(); 
		
		colores.put("negro", Color.BLACK);
		colores.put("azul", Color.BLUE);
		colores.put("azul marino", Color.CYAN);
		colores.put("gris", Color.GRAY);
		colores.put("gris oscuro", Color.DARK_GRAY);
		colores.put("gris claro", Color.LIGHT_GRAY);
		colores.put("verde", Color.GREEN);
		colores.put("magenta", Color.MAGENTA);
		colores.put("naranja", Color.ORANGE);
		colores.put("rosa", Color.PINK);
		colores.put("rojo", Color.RED);
		colores.put("blanco", Color.WHITE);
		colores.put("amarillo", Color.YELLOW);
		
		//los mostramos por orden
		Set<String> listaColores= colores.keySet();
		
		for (String color: listaColores){
			System.out.println(color + "---->"+colores.get(color));
		}
		
		

	}

}
