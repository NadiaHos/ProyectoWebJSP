package entidades;

import entidades.Cliente;
import entidades.TipoUsuario;

public class Usuario {
	
    private int idUsuario;
    private String usuario;
    private String contrasena;
    private boolean estado;

    private Cliente cliente;              // Asociado si el usuario es cliente
    private TipoUsuario tipoUsuario;     // Siempre presente (admin, cliente, etc.)

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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    // Métodos auxiliares
    public boolean esCliente() {
        return cliente != null && tipoUsuario != null && tipoUsuario.getDescripcion().equalsIgnoreCase("cliente");
    }

    public boolean esAdmin() {
        return cliente == null && tipoUsuario != null && tipoUsuario.getDescripcion().equalsIgnoreCase("admin");
    }

}
