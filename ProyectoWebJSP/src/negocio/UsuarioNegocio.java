package negocio;

import entidades.Usuario;

public interface UsuarioNegocio {
	
	Usuario login(String nombreUsuario, String passwordHasheado);

}
