package entidades;

public class TipoUsuario {
	
	private int idTipoUsuario;
	private String descripcion;
	
	
	public TipoUsuario() {}


	public TipoUsuario(int idTipoUsuario, String descripcion) {
		this.idTipoUsuario = idTipoUsuario;
		this.descripcion = descripcion;
	}


	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}


	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
