package traducciones;

public class ProbarTraduccionesAmpliado {

	public static void main(String[] args) {
		int[] pruebas = {-1, 0,1,9,10,11,19,20,21,29,30,31,39, 98,99,100,101,102,110,111,199,200,201,210,211,299,300,400,500,600,700,800,900,999,1000};
		
		for (int numero: pruebas) {
			try {
				System.out.format("\n Número: %d \t *En español: %s. \t *In english: %s.", 
									numero,TraduccionesAmpliado.traducirNumero(Idiomas.ES, numero),
									TraduccionesAmpliado.traducirNumero(Idiomas.EN, numero));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
