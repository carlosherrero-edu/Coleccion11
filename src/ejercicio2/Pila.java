package ejercicio2;

import java.util.ArrayList;
import java.util.Iterator;

public class Pila<T> {
	
	//propiedad, lista donde guardamos los objetos de T
    private ArrayList<T> miPila;

    //constructor, instanciamos la lista
    public Pila() {
    
        miPila = new ArrayList<>();
    }
    
    
    public void agregar (T obj) {
    	//lo agregamos al final
        
        miPila.add(obj);
        
        
    }
    
    
    public T eliminar() {
        
        T resultado;
        
        if(miPila.isEmpty()) {
            resultado = null;
        } else {
            resultado = miPila.remove(miPila.size()-1);
        }
        
        return resultado;
    }

    
    public String proximoEnSalir() {
        
        String resultado;
        
        resultado = miPila.get(miPila.size()-1).toString();
        
        return resultado;
            
    }
    
    public int cuantos() {
        
        int resultado = 0;
        
        for (int i = 0; i < miPila.size(); i++) {
            resultado++;
        }
        return resultado;
    }

    @Override
    public String toString() {

        String cadena;
        String cadena2 = null;
        T unItem;

        for (Iterator<T> iterator = miPila.iterator(); iterator.hasNext();) {
        	unItem=iterator.next();
         
            cadena = "\n " + unItem.toString();
            cadena2 += cadena;
        }
        return cadena2;
    }
	
	

}
