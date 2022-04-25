package ejercicio7;
import java.awt.Color;


import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ColoresPredefinidos {
	
	public static void main(String[] args) {
		Map<String,Color> diccioColores= new TreeMap<String,Color>();
		
		//agrego los 13 colores al diccionario
		
		diccioColores.put("negro", Color.black);
		diccioColores.put("azul", Color.blue);
		diccioColores.put("cian", Color.cyan);
		diccioColores.put("gris oscuro", Color.darkGray);
		diccioColores.put("gris", Color.gray);
		diccioColores.put("verde", Color.green);
		diccioColores.put("gris claro", Color.lightGray);
		diccioColores.put("magenta", Color.magenta);
		diccioColores.put("naranja", Color.orange);
		diccioColores.put("rosa", Color.pink);
		diccioColores.put("rojo", Color.red);
		diccioColores.put("blanco", Color.white);
		diccioColores.put("amarillo", Color.yellow);
		diccioColores.put("colorado", Color.red);
		
		System.out.format("%n He agregado %d colores %n",
								diccioColores.size());
		
		Set<String> nombres=diccioColores.keySet();
		
		for (String nombre: nombres) {
			
			System.out.format("%n Color: %s  :  %s",
									nombre,
									diccioColores.get(nombre).toString());
		}
		
//		Collection<Color> colores=diccioColores.values();
//		
//		for (Color color: colores) {
//			System.out.format("%n Color:  %s",
//				
//					color.toString());
//		}
		
		
		
		
		
	}
	


	

}
