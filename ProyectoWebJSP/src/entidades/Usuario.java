package entidades;

import entidades.Cliente;
import entidades.TipoUsuario;

public class Usuario {

    private int idUsuario;
    private String usuario;
    private String password;
    private boolean estado;

    private Cliente cliente;
    private TipoUsuario tipoUsuario;

    public Usuario() {
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    // M�todos auxiliares
    public boolean esCliente() {
        return cliente != null && tipoUsuario != null && tipoUsuario.getDescripcion().equalsIgnoreCase("cliente");
    }

    public boolean esAdmin() {
        return cliente == null && tipoUsuario != null && tipoUsuario.getDescripcion().equalsIgnoreCase("admin");
    }
}
