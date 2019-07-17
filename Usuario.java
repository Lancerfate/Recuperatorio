package usuarioMail;

public class Usuario 
{
	private String email;
	private String contrasenia;
	
	public Usuario(String email, String contrasenia)
	{
		this.email = email;
		this.contrasenia = contrasenia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public String toString()
	{
		return("El email es " + email + " y su contrasenia es " + contrasenia);
	}

}
