package ejercicio3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;


@TestMethodOrder(OrderAnnotation.class)
class ColaTest {
	
	static Cola<Integer> colaPrueba;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		colaPrueba=new Cola<Integer>();
		colaPrueba.agregar(100);
		colaPrueba.agregar(200);
		colaPrueba.agregar(300);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		colaPrueba = null;
	}

	@Test
	@Order(1)
	@DisplayName("Entrada de un elemento")
	void testAgregar() {
		colaPrueba.agregar(400);
		assertTrue(colaPrueba.cuantos()==4);
	
	}
	
	

	@Test
	@Order(2)
	@DisplayName("Salen 2 elementos")
	void testEliminar() {
		int tamanio= colaPrueba.cuantos();
		Integer elem= colaPrueba.eliminar();
		assertTrue(elem.intValue()==100);
		assertTrue(colaPrueba.cuantos()== (tamanio-1));
		Integer elem2= colaPrueba.eliminar();
		assertTrue(elem2.intValue()==200);
		assertTrue(colaPrueba.cuantos()==(tamanio-2));

	}

	
	@Test
	@Order(3)
	@DisplayName("Comprobamos el siguiente elemento en salir")
	void testProximoSalir() {
		String elem=colaPrueba.proximoEnSalir();
		assertTrue(elem.contains("300"));
		assertTrue(colaPrueba.cuantos()==2);
		
	}
	
	@Test
	@Order(4)
	@DisplayName("Extraemos todos los elementos de la cola")
	void testDejarColaVacia() {
		colaPrueba.eliminar();
		colaPrueba.eliminar();
		assertNull(colaPrueba.eliminar());
		assertTrue(colaPrueba.cuantos()==0);
		
		
	}
	

}
