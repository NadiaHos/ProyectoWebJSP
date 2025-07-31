package datosImpl;

import java.sql.*;
import datos.UsuarioDao;
import entidades.Usuario;
import entidades.Cliente;
import entidades.TipoUsuario;
import entidades.Provincia;
import entidades.Localidad;

public class UsuarioDaoImpl implements UsuarioDao {

    private Connection conexion;

    public UsuarioDaoImpl() {
        conexion = Conexion.getConexion().getSQLConexion();
    }

    private static final String SELECT_USUARIO_BASE = "SELECT "
            + "u.id_usuario, u.id_cliente, u.id_tipo_usuario, u.usuario, u.password, u.estado, "
            + "tu.id_tipo_usuario AS tu_id, tu.descripcion AS tu_descripcion, "
            + "c.id_cliente AS c_id, c.dni AS c_dni, c.cuil AS c_cuil, c.nombre AS c_nombre, c.apellido AS c_apellido, "
            + "c.sexo AS c_sexo, c.nacionalidad AS c_nacionalidad, c.fecha_nacimiento AS c_fecha_nacimiento, "
            + "c.direccion AS c_direccion, c.id_localidad AS c_id_localidad, "
            + "l.nombre AS c_localidad, p.nombre AS c_provincia, "
            + "c.email AS c_email, c.telefono AS c_telefono, c.estado AS c_estado "
            + "FROM Usuarios u "
            + "INNER JOIN Tipos_Usuario tu ON u.id_tipo_usuario = tu.id_tipo_usuario "
            + "LEFT JOIN Clientes c ON u.id_cliente = c.id_cliente "
            + "LEFT JOIN Localidades l ON c.id_localidad = l.id_localidad "
            + "LEFT JOIN Provincias p ON l.id_provincia = p.id_provincia";

    private static final String INSERT_USUARIO = "INSERT INTO Usuarios (id_cliente, id_tipo_usuario, usuario, password, estado) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_USUARIO_BY_ID = SELECT_USUARIO_BASE + " WHERE u.id_usuario = ?";
    private static final String SELECT_USUARIO_BY_CREDENCIALES = SELECT_USUARIO_BASE + " WHERE u.usuario = ? AND u.password = ? AND u.estado = true";
    private static final String UPDATE_USUARIO = "UPDATE Usuarios SET id_cliente = ?, id_tipo_usuario = ?, usuario = ?, password = ?, estado = ? WHERE id_usuario = ?";
    private static final String DELETE_USUARIO = "UPDATE Usuarios SET estado = 0 WHERE id_usuario = ?";
    private static final String CHECK_USERNAME_EXISTS = "SELECT COUNT(*) FROM Usuarios WHERE usuario = ?";

    @Override
    public Usuario obtenerVerificacion(String usuario, String password) {
        Usuario u = null;
        try (PreparedStatement pst = conexion.prepareStatement(SELECT_USUARIO_BY_CREDENCIALES)) {
            pst.setString(1, usuario);
            pst.setString(2, password);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    u = mapearUsuario(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error en obtenerVerificacion: " + e.getMessage());
        }
        return u;
    }

    @Override
    public boolean agregarUsuario(Usuario usuario) {
        boolean exito = false;
        try {
            conexion.setAutoCommit(false);
            try (PreparedStatement pst = conexion.prepareStatement(INSERT_USUARIO)) {
                if (usuario.getCliente() != null) {
                    pst.setInt(1, usuario.getCliente().getIdCliente());
                } else {
                    pst.setNull(1, Types.INTEGER);
                }
                pst.setInt(2, usuario.getTipoUsuario().getIdTipoUsuario());
                pst.setString(3, usuario.getUsuario());
                pst.setString(4, usuario.getPassword());
                pst.setBoolean(5, usuario.isEstado());

                if (pst.executeUpdate() > 0) {
                    conexion.commit();
                    exito = true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al agregar usuario: " + e.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException e1) {
                System.err.println("Rollback fallido: " + e1.getMessage());
            }
        }
        return exito;
    }

    @Override
    public Usuario obtenerUsuarioPorId(int idUsuario) {
        Usuario usuario = null;
        try (PreparedStatement pst = conexion.prepareStatement(SELECT_USUARIO_BY_ID)) {
            pst.setInt(1, idUsuario);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    usuario = mapearUsuario(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener usuario por ID: " + e.getMessage());
        }
        return usuario;
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        boolean exito = false;
        try {
            conexion.setAutoCommit(false);
            try (PreparedStatement pst = conexion.prepareStatement(UPDATE_USUARIO)) {
                if (usuario.getCliente() != null) {
                    pst.setInt(1, usuario.getCliente().getIdCliente());
                } else {
                    pst.setNull(1, Types.INTEGER);
                }
                pst.setInt(2, usuario.getTipoUsuario().getIdTipoUsuario());
                pst.setString(3, usuario.getUsuario());
                pst.setString(4, usuario.getPassword());
                pst.setBoolean(5, usuario.isEstado());
                pst.setInt(6, usuario.getIdUsuario());

                if (pst.executeUpdate() > 0) {
                    conexion.commit();
                    exito = true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException e1) {
                System.err.println("Rollback fallido: " + e1.getMessage());
            }
        }
        return exito;
    }

    @Override
    public boolean eliminarUsuario(int idUsuario) {
        boolean exito = false;
        try {
            conexion.setAutoCommit(false);
            try (PreparedStatement pst = conexion.prepareStatement(DELETE_USUARIO)) {
                pst.setInt(1, idUsuario);
                if (pst.executeUpdate() > 0) {
                    conexion.commit();
                    exito = true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException e1) {
                System.err.println("Rollback fallido: " + e1.getMessage());
            }
        }
        return exito;
    }

    @Override
    public boolean existeNombreUsuario(String nombreUsuario) {
        boolean existe = false;
        try (PreparedStatement pst = conexion.prepareStatement(CHECK_USERNAME_EXISTS)) {
            pst.setString(1, nombreUsuario);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    existe = true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar existencia de usuario: " + e.getMessage());
        }
        return existe;
    }
    
    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(rs.getInt("id_usuario"));
        usuario.setUsuario(rs.getString("usuario"));
        usuario.setPassword(rs.getString("password")); // antes era setContrasena
        usuario.setEstado(rs.getBoolean("estado"));

        TipoUsuario tipo = new TipoUsuario();
        tipo.setIdTipoUsuario(rs.getInt("tu_id"));
        tipo.setDescripcion(rs.getString("tu_descripcion"));
        usuario.setTipoUsuario(tipo);

        int idCliente = rs.getInt("c_id");
        if (!rs.wasNull()) {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(idCliente);
            cliente.setDni(rs.getString("c_dni"));
            cliente.setCuil(rs.getString("c_cuil"));
            cliente.setNombre(rs.getString("c_nombre"));
            cliente.setApellido(rs.getString("c_apellido"));
            cliente.setSexo(rs.getString("c_sexo"));
            cliente.setNacionalidad(rs.getString("c_nacionalidad"));
            cliente.setFechaNacimiento(rs.getDate("c_fecha_nacimiento")); // sin .toLocalDate()
            cliente.setDireccion(rs.getString("c_direccion"));
            cliente.setEmail(rs.getString("c_email"));
            cliente.setTelefono(rs.getString("c_telefono"));
            cliente.setEstado(rs.getBoolean("c_estado"));

            // Mapeo de Localidad y Provincia
            Localidad localidad = new Localidad();
            localidad.setIdLocalidad(rs.getInt("c_id_localidad"));
            localidad.setNombre(rs.getString("c_localidad"));

            Provincia provincia = new Provincia();
            provincia.setNombre(rs.getString("c_provincia"));
            localidad.setProvincia(provincia);

            cliente.setLocalidad(localidad);

            usuario.setCliente(cliente);
        }

        return usuario;
    }



}
