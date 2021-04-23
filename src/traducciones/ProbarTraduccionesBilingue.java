package traducciones;

public class ProbarTraduccionesBilingue {

	public static void main(String[] args) {
		int[] pruebas = {-1, 0,1,9,10,11,19,20,21,29,30,31,39, 98,99,100};
		
		for (int numero: pruebas) {
			try {
				System.out.format("\n Número: %d \t *En español: %s. \t *In english: %s.", 
									numero,TraduccionesBilingue.traducirNumero(Idiomas.ES, numero),
									TraduccionesBilingue.traducirNumero(Idiomas.EN, numero));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
