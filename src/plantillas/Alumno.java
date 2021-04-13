package plantillas;

/**
 * @author Carlos Herrero
 * @version 1.0
 * Clase Alumno con un array de calificaciones y un metodo de cálculo de nota media
 */
public class Alumno implements Comparable<Alumno> {
	
	//propiedades
	private int nia;
	private String nombre;
	private String apellidos;
	private int num_asig;
	private double[] calificaciones;
	
	//constructor
	public Alumno (int nia, String nom, String apell, int num_a){
		this.nia = nia;
		this.nombre = nom;
		this.apellidos = apell;
		this.num_asig = num_a;
		
	}
	
	public Alumno(){
		super();
	}
	
	//métodos getXxX
	public int getNia() {
		return nia;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}
	
	public String toString(){
		return "NIA : " +getNia() +"-- Apellidos y nombre : "+ 
				getApellidos().trim()+ " "+ getNombre().trim();
	}
	
	
	public void asignarCalificaciones (double[] notas){
		if (notas.length >0){
			this.num_asig = notas.length;
			calificaciones = notas;
		} else 
			System.out.println("Error: se ha pasado un array de califiaciones vacio");		
		
	}
	
	public double getNotaMedia(){
		if (calificaciones.length >0){
			double suma= 0.0;
			for (double nota:calificaciones) {
					suma += nota;
			}
			return suma/num_asig;
		} else
			return -1; //condicion de error
	}
	
	/**
	 *Implementación de la interfaz Comparable para poder ordenar 2 objetos Alumno
	 *Se ordenarán según el valor de su nota media
	 */
	@Override
	public int compareTo(Alumno otro){
		if (this.getNotaMedia() < otro.getNotaMedia())
			return -1;
		else if (this.getNotaMedia() > otro.getNotaMedia())
			return 1;
		else
			return 0;
	}

}
