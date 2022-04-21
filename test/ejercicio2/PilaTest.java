package ejercicio2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class PilaTest {
	
	Pila<Integer> pilaPrueba;
	
	@BeforeEach
	void iniciarPila() {
		pilaPrueba=new Pila<Integer>();
		pilaPrueba.agregar(100);
		pilaPrueba.agregar(200);
		pilaPrueba.agregar(300);
	}
	
	@AfterEach
	void eliminarPila() {
		pilaPrueba = null;
	}

	@Test
	@DisplayName("Probando la agregaci�n de un elemento")
	void testAgregar() {
		pilaPrueba.agregar(400);
		assertTrue(pilaPrueba.cuantos()==4);
		
	}
	

	@Test
	@DisplayName("Probando que se elige correctamente el siguiente m�todo en salir")
	void testProximoEnSalir() {
		String elem=pilaPrueba.proximoEnSalir();
		assertTrue(elem.contains("300"));
		assertTrue(pilaPrueba.cuantos()==3);
	}


	@Test
	@DisplayName("Probando la correcta salida de elementos de la pila")
	void testEliminar() {
		Integer elem= pilaPrueba.eliminar();
		assertTrue(elem.intValue()==300);
		assertTrue(pilaPrueba.cuantos()==2);
		Integer elem2= pilaPrueba.eliminar();
		assertTrue(elem2.intValue()==200);
		assertTrue(pilaPrueba.cuantos()==1);
	}
	
	
	@Test
	@DisplayName("Extraemos todos los elementos de la pila")
	void testDejarPilaVacia() {
		pilaPrueba.eliminar();
		pilaPrueba.eliminar();
		pilaPrueba.eliminar();
		assertNull(pilaPrueba.eliminar());
		assertTrue(pilaPrueba.cuantos()==0);
		
		
	}
	
	@Test
	@Order(5)
	@DisplayName("Probamos que los nodos de la cola se listan correctamente")
	void testListarPila() {
	
		String[] lineas= pilaPrueba.toString().split("\n");
	
		assertTrue(lineas[0].contains("100"));
		assertTrue(lineas[1].contains("200"));
		assertTrue(lineas[2].contains("300"));
		
		
	}

	
}
