package entidades;

public class TipoCuenta {
	
	private int tipoCuenta;
	private String descripcion;
	
	
	public TipoCuenta() {}


	public TipoCuenta(int tipoCuenta, String descripcion) {
		super();
		this.tipoCuenta = tipoCuenta;
		this.descripcion = descripcion;
	}


	public int getTipoCuenta() {
		return tipoCuenta;
	}


	public void setTipoCuenta(int tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
