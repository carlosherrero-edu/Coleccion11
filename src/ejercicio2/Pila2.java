package ejercicio2;


	
	import java.util.ArrayList;
	import java.util.List;
	import java.util.ListIterator;

	public class Pila2<T> {
	    
	    private List<T> listaPrimitiva = null;
	    
	    public Pila2() {
	        listaPrimitiva = new ArrayList<T>();
	    }
	    
	    //considera el extremo activo la cabecera
	    public void agregar(T o) {
	        getListaPrimitiva().add(0, o);
	    }
	    
	    public T eliminar() {
	        T o = null;
	        if(getListaPrimitiva().size() != 0) {
	            o = getListaPrimitiva().remove(0);
	        }
	        return o;
	    }
	    
	    public String proximoEnSalir() {
	        return getListaPrimitiva().get(0).toString();
	    }
	    
	    public int cuantos() {
	        return getListaPrimitiva().size();
	    }
	    
	    public String toString() {
	        String impresionObjetos = null;
	        ListIterator<T> it = getListaPrimitiva().listIterator(getListaPrimitiva().size());
	        while(it.hasPrevious()) {
	            impresionObjetos += it.previous().toString();
	        }
	        return impresionObjetos;
	    }
	    
	    public List<T> getListaPrimitiva() {
	        return listaPrimitiva;
	    }

	    public void setListaPrimitiva(List<T> listaPrimitiva) {
	        this.listaPrimitiva = listaPrimitiva;
	    }

}
