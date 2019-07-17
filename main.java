package usuarioMail;

import java.util.Scanner;

public class main 
{

	public static void main(String[] args) 
	{
		Scanner teclado = new Scanner(System.in);
		
		Server unlam = new Server(10);
		System.out.println("Bienvenido al sistema de registro de la unlam");
		int opcionIngresada = 0;
		
		do 
		{
			System.out.println("Ingrese 1 si quiere crear un usuario.");
			System.out.println("Ingrese 2 si quiere ordenar los usuario por mail.");
			System.out.println("Ingrese 3 si desea ver la lista de usuarios");
			System.out.println("Ingrese 4 si quiere ver los mails que empiezan con a.");
			System.out.println("Ingrese 0 si desea salir");
			opcionIngresada = teclado.nextInt();
			
			switch(opcionIngresada)
			{
			case 1:
				System.out.println("Ingrese su email");
				String email = teclado.next();
				System.out.println("Ingrese su contrasenia");
				String contrasenia = teclado.next();
				
				Usuario miUsuario = new Usuario(email, contrasenia);
				unlam.agregarUsuario(miUsuario);
				break;
			case 2:
				unlam.ordenarPorMail();
				break;
			case 3:
				unlam.verListaUsuarios();
				break;
			case 4:
				unlam.obtenerUsuariosConMailQueEmpiecenConA();
				break;
			
			}
			
		}while(opcionIngresada != 0);

	}

}
