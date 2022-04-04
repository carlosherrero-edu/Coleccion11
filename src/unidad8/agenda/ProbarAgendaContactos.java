package unidad8.agenda;

public class ProbarAgendaContactos {

	public static void main(String[] args) {
		

		//creo la agenda
		AgendaContactos miAgenda= new AgendaContactos();
		
		//doy de alta contactos
		miAgenda.agregarContacto("Carlos" , "Herrero", "678678678");
		miAgenda.agregarContacto("Maria" , "Perez", "914445566");
		miAgenda.agregarContacto("Pilar" , "Gomez", "979445566");
		miAgenda.agregarContacto("Rafael" , "Mora", "956333444");
		miAgenda.agregarContacto("Beatriz" , "Franco", "645888999");
		miAgenda.agregarContacto("Antonio" , "Castellanos", "988777666");
		miAgenda.agregarContacto("Sandra" , "Mora", "988989990");
		
		//listo los contactos
		
		miAgenda.listarAgenda();
		
		//recupero unos cuantos contactos
		
		String [] buscado= {"Franco", "Mora", "Alvarez"};
		
		for (String clave: buscado) {
			
			System.out.format( "Apellido buscado: %s : Resultado: %s \n", 
					clave, miAgenda.buscarContacto(clave));
		}
		
		
		

	}

}
