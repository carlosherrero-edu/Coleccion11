package ejercicio6;
import plantillas.Alumno;

import java.util.TreeSet;

public class ProbarListasAlumnos {

	public static void main (String[] args) {
		// Creo varias instancias de alumno
		
		Alumno alu1=new Alumno (100001, "Luis","Berlanga",4);
		Alumno alu2=new Alumno (200002, "Pilar","Miro",4);
		Alumno alu3=new Alumno (300003, "Iztiar","Boallin",4);
		Alumno alu4=new Alumno (400004, "Luis","Buñuel",4);
		Alumno alu5=new Alumno (500005, "Isabel","Coixet",4);
		Alumno alu6=new Alumno (600006, "Mario","Camus",4);
		
		// a continuaciÃ³n les asigno calificaciones
		// 3 aprueban y 3 suspenden
		alu1.asignarCalificaciones( new double[]{6.5, 3.5,7,4.25} ); //media:5.3125
		alu2.asignarCalificaciones( new double[]{6.25, 3.5,7,4.25} ); //media: 5.25
		alu3.asignarCalificaciones( new double[]{6.5, 3.5,7.5,4.25} ); //media: 5.4375
		alu4.asignarCalificaciones( new double[]{6.5, 3.5,5,3.25} ); // media: 4.5625
		alu5.asignarCalificaciones( new double[]{6.25, 3.5,5,3.25} ); // media: 4.5
		alu6.asignarCalificaciones( new double[]{6.5, 3.5,5.5,3.25} ); // media: 4.6875
		
		//creo el array de alumnos
		Alumno[]  arrAlu= { alu1, alu2, alu3, alu4, alu5, alu6};
		

		//ahora construimos una instancia de TreeSet
		ListaOrdenadaAlumnos loAlu= new ListaOrdenadaAlumnos(arrAlu);
		
		//llamamos a sus mÃ©todos para obtener los alumnos aprobados y suspensos
		TreeSet<Alumno> arbolAprobados= loAlu.obtenerAlumnosAprobados();
		TreeSet<Alumno> arbolSuspensos= loAlu.obtenerAlumnosSuspensos();
		
		//recorremos las listas para comprobarlo
		
		System.out.println("\n\nRelación ordenada de alumnos aprobados");
				for (  Alumno alu:arbolAprobados){
					System.out.println(alu);
				}
				
		System.out.println("\n\nRelacón ordenadade alumnos suspensos");
				for (  Alumno alu:arbolSuspensos){
					System.out.println(alu);
		}
		
		
		
		
		
		
		}//fin mÃ©todo main
		
		
	

}
