package usuarioMail;

public class Server 
{
	private Usuario[] listaUsuarios;
	private int usuariosRegistrados;
	private int maximoUsuarios;

	public Server(int tamanioServer)
	{
		maximoUsuarios = tamanioServer;
		listaUsuarios = new Usuario[tamanioServer];
		usuariosRegistrados = 0;
	}
	
	/*AGREGA UN USUARIO A LA LISTA SOLO SI CUMPLE CON LA CONDICION VALIDAR EMAIL Y AUN NO SE ALCANZO LA CANTIDAD
	MAXIMA DE USUARIOS REGISTRADOS*/
	public boolean agregarUsuario(Usuario usuario)
	{
		if(validarMail(usuario.getEmail()) && usuariosRegistrados < maximoUsuarios)
			/*SI EL METODO VALIDAR EMAIL ME DEVUELVE TRUE Y AUN SE PUEDEN REGISTRAR USUARIOS VA A AGREGAR AL 
			USUARIO QUE SE PASA POR PARAMETRO*/
		{
			for(int i = 0; i <= usuariosRegistrados ; i++)
			{
				if(listaUsuarios[i] == null)
					/*FOR PARA RECORRER LA LISTA DE USUARIOS Y SI ENCUENTRA UN LUGAR VACIO VA AGREGAR AL USUARIO 
					 * EN ESE LUGAR*/
				{
					listaUsuarios[i] = usuario;
					usuariosRegistrados++;
					System.out.println("El usuario se agrego con exito.");
					return true;
				}
			}
		}
		else
		{
			System.out.println("Error al registrar usuario.");
		}
		return false;
	}
	
	
	/*VALIDA EL EMAIL SOLO SI TIENE UN @ Y TIENE UN PUNTO DOS POSICIONES DESPUES O +
	 * EJEMPLO: XXXXX@.SDAL <--- MAL
	 *          ZZZZZ@Z.ZZ <---- BIEN
	 *          ZZZZZ@ZZZ. <---- BIEN   
	 */
	public boolean validarMail(String email)
	{
		for(int i = 0; i < email.length() ; i++)
		{//fOR QUE VA A RECORRER EL MAIL POR LO TANTO SE USA EL EMAIL.LENGTH PARA QUE DURE EL LARGO DEL MAIL
			if(email.charAt(i) == '@')
			{//SI EN ALGUN PUNTO SE ENCUENTRA EL @ VA A SEGUIR CON LO DE ADENTRO SINO SALTE A DEVOLVER UN FALSE
				for(int j = i; j < email.length(); j++)
				{ //OTRO FOR PARA SEGUIR RECORRIENDO EL EMAIL DESDE DOS POSICIONES DESPUES DE DONDE ENCONTRO EL @
					if(email.charAt(j+2) == '.')
						/*SI ENCUENTRA UN '.' APARTIR DE DOS POSICIONES DESPUES O +
						DE DONDE ENCONTRO EL @ VA A DEVOLVER UN TRUE Y VALIDA EL MAIL*/ 
					{
						return true;
					}
				}
			}
			
		}
		return false;
	}
	
	//VA A ORDENAR A LOS USUARIOS POR MAIL
	public void ordenarPorMail()
	{
		for(int i = 0; i < usuariosRegistrados; i++)
		{
			for(int j = 0; j < usuariosRegistrados -1; j++)
			{
				if(listaUsuarios[j].getEmail().compareTo(listaUsuarios[j+1].getEmail()) > 1)
				{
					Usuario temporal = null;
					temporal = listaUsuarios[j];
					listaUsuarios[j] = listaUsuarios[j+1];
					listaUsuarios[j+1] = temporal;
				}
			}
		}
	}
	
	
	//VA A CREAR UNA NUEVA LISTA. Buscara LOS USUARIOS QUE EMPIECEN CON A EN LA LISTA ANTERIOR Y LOS COPIARA A LA NUEVA
	public Usuario[] obtenerUsuariosConMailQueEmpiecenConA()
	{
		Usuario[] mailsA = new Usuario[usuariosRegistrados]; //CREO LA NUEVA LISTA
		int usuariosAregistrados = 0; /*CONTADOR DE LOS USUARIOS CON A Y TAMBIEN LO VOY A USAR PARA
		DETERMINAR LA POSICION DE DONDE SE VAN A GUARDAR EN LA NUEVA LISTA*/
		
		for(int i = 0; i < usuariosRegistrados; i++)
			//FOR QUE VOY A USAR PARA BUSCAR ESOS MAILS QUE EMPIEZAN CON A Y LLENAR LA NUEVA LISTA
		{
			if(listaUsuarios[i].getEmail().charAt(0) == 'A' || listaUsuarios[i].getEmail().charAt(0) == 'a' )
			{
				mailsA[usuariosAregistrados] = listaUsuarios[i];
				usuariosAregistrados++;
			}
		}
		
		
		for(int i = 0; i <usuariosAregistrados; i++)
			//NUEVO FOR PARA RECORRER EL NUEVO ARRAY Y MOSTRARLO EN PANTALLA
		{
			System.out.println(mailsA[i]);
		}
		
		return mailsA;//DEVUELVO LA NUEVA LISTA
	}
	
	//AGREGO METODO PARA VER LOS USUARIOS REGISTRADOS Y VERIFICAR QUE SE ORDENEN POR MAIL
	
	public void verListaUsuarios()
	{
		for(int i = 0; i < usuariosRegistrados; i++)
		{
			System.out.println(listaUsuarios[i].toString());
		}
		
	}
	
	
}
