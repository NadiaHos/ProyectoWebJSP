package datos;

import entidades.Usuario;

public interface UsuarioDao {
	
	Usuario obtenerVerificacion(String usuario, String contraseņa);
	boolean agregarUsuario(Usuario usuario);
	Usuario obtenerUsuarioPorId(int idUsuario);
	boolean actualizarUsuario(Usuario usuario);
	boolean eliminarUsuario(int idUsuario);
	boolean existeNombreUsuario(String nombreUsuario);
	

}
