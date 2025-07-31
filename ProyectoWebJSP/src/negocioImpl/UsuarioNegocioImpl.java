package negocioImpl;

import datos.UsuarioDao;
import datosImpl.UsuarioDaoImpl;
import entidades.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio {

    private UsuarioDao usuarioDao = new UsuarioDaoImpl();

    @Override
    public Usuario login(String nombreUsuario, String passwordHasheado) {
        return usuarioDao.obtenerVerificacion(nombreUsuario, passwordHasheado);
    }
}
