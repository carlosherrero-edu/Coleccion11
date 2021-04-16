package ejercicio6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.TreeSet;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;



import plantillas.Alumno;

@TestMethodOrder(OrderAnnotation.class)
class ListaOrdenadaAlumnosTest {
	
	static Alumno alu1, alu2, alu3, alu4, alu5, alu6;
	
	static ListaOrdenadaAlumnos loAlu;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		// Creo varias instancias de alumno
		
				 alu1=new Alumno (100001, "Luis","Berlanga",4);
				 alu2=new Alumno (200002, "Pilar","Miro",4);
				 alu3=new Alumno (300003, "Iztiar","Boallin",4);
				 alu4=new Alumno (400004, "Luis","Buñuel",4);
				 alu5=new Alumno (500005, "Isabel","Coixet",4);
				 alu6=new Alumno (600006, "Mario","Camus",4);
				
				// a continuación les asigno calificaciones
				// 3 aprueban y 3 suspenden
				alu1.asignarCalificaciones( new double[]{6.5, 3.5,7,4.25} ); //media:5.3125
				alu2.asignarCalificaciones( new double[]{6.25, 3.5,7,4.25} ); //media: 5.25
				alu3.asignarCalificaciones( new double[]{6.5, 3.5,7.5,4.25} ); //media: 5.4375
				alu4.asignarCalificaciones( new double[]{6.5, 3.5,5,3.25} ); // media: 4.5625
				alu5.asignarCalificaciones( new double[]{6.25, 3.5,5,3.25} ); // media: 4.5
				alu6.asignarCalificaciones( new double[]{6.5, 3.5,5.5,3.25} ); // media: 4.6875
				
			//creo el array de alumnos
			Alumno[]  arrAlu= { alu1, alu2, alu3, alu4, alu5, alu6};
				

			//ahora construimos una instancia de ListaOrdenadaAlumnos
			loAlu= new ListaOrdenadaAlumnos(arrAlu);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		loAlu=null;
	}

	@Test
	@Order(1)
	@DisplayName("Probando el constructor")
	void testListaOrdenadaAlumnos() {
		assertNotNull(loAlu);
	}

	@Test
	@Order(2)
	@DisplayName("Probando el filtrado de los alumnos aprobados")
	void testObtenerAlumnosAprobados() {
		TreeSet<Alumno> aprobados= loAlu.obtenerAlumnosAprobados();
		// tiene que contener a alu2, alu1 y alu3
		assertTrue(aprobados.contains(alu1));
		assertTrue(aprobados.contains(alu2));
		assertTrue(aprobados.contains(alu3));
		//no debe contener al resto
		assertFalse(aprobados.contains(alu4));
		assertFalse(aprobados.contains(alu5));
		assertFalse(aprobados.contains(alu6));
		
	}

	@Test
	@Order(3)
	@DisplayName("Probando el filtrado de los alumnos suspensos")
	void testObtenerAlumnosSuspensos() {
		TreeSet<Alumno> suspensos= loAlu.obtenerAlumnosSuspensos();
		// tiene que contener a alu4, alu5 y alu6
		assertTrue(suspensos.contains(alu4));
		assertTrue(suspensos.contains(alu5));
		assertTrue(suspensos.contains(alu6));
		//no debe contener al resto
		assertFalse(suspensos.contains(alu1));
		assertFalse(suspensos.contains(alu2));
		assertFalse(suspensos.contains(alu3));
	}

}
