import java.util.Scanner;

public class ProbarEscaner {
	
	public static void main(String[] args) {
		
		
		//objeto de tipo Scanner para pedir datos por teclado
		Scanner entrada= new Scanner(System.in);
		
		String linea, textoleido="";
		
		linea =  entrada.nextLine();
				
		while (!linea.trim().equalsIgnoreCase("fin")) {
			
						
			//si no nos salimos, agregamos la l�nea al texto le�do	
			textoleido = textoleido+ linea+'\n';
			//leemos la siguiente l�nea
			linea =  entrada.nextLine();
		}
		
		System.out.println(textoleido);
		
		entrada.close();
		
		
		
	}

}
