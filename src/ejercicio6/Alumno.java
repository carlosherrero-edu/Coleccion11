package ejercicio6;

/**
 * @author Carlos Herrero
 * @version 1.0
 * Clase Alumno con un array de calificaciones y un me&acute;todo de ca&acute; de la nota media
 */
public class Alumno implements Comparable<Alumno>{
	
	//propiedades
	private int nia;
	private String nombre;
	private String apellidos;
	private int num_asig;
	private double[] calificaciones;
	
	//constructor único de la clase, sin validaciones
	public Alumno (int nia, String nom, String apell, int num_asig){
		this.nia = nia;
		this.nombre = nom;
		this.apellidos = apell;
		this.num_asig = num_asig;
	
	}
	

	//métodos getXxX
	public int getNia() {
		return this.nia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}
	
	public int getNum_asig() {
		return this.num_asig;
	}


	public String toString(){
		return "NIA : " +getNia() +"--Apellidos y nombre:"+ 
				getApellidos().trim()+ " "+ getNombre().trim();
	}
	
	/**
	 * Método para actualizar la lista de calificaciones a partir de una lista de entrada
	 * @param notas array-lista numérico con las calificaciones que queremos asignar al alumno
	 */
	public void asignarCalificaciones (double[] notas){
		if (notas.length >0){
			this.num_asig = notas.length;
			this.calificaciones = notas;
		} else 
			System.out.println("Error: se ha pasado un array de calificaciones vacio");		
		
	}
	
	/**
	 * Método para calcular la nota media de un alumno 
	 * @return nota media a partir de su array de calificaciones, o -1 si no se le han asignado calificaciones
	 */
	public double getNotaMedia(){
		if (calificaciones.length >0){
			double suma= 0.0;
			for (double nota:calificaciones)
					suma += nota;
			
			return suma/num_asig;
		} else
			return -1; //condicio&acute;n de error
	}


	@Override
	public int compareTo(Alumno o) {
		
		if (this.getNotaMedia()<o.getNotaMedia()) {
			return -1;
		} else {
			if (this.getNotaMedia()>o.getNotaMedia()) {
				return +1;
			} else {
				return 0;
			}
		}
		
		
		/*
		 return  ((Double)this.getNotaMedia()).compareTo((Double)o.getNotaMedia());
		 */
	}


}