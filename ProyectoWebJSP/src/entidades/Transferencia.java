package entidades;

import java.sql.Date;

import entidades.Cuenta;


public class Transferencia {
	
	private int idTransferencia;
	private Cuenta cuentaOrigen;
	private Cuenta cuentaDestino;
	private Date fecha;
	private double importe;
	private String concepto;
	
	public Transferencia() {}

	public Transferencia(int idTransferencia, Cuenta cuentaOrigen, Cuenta cuentaDestino, Date fecha, double importe,
			String concepto) {
		super();
		this.idTransferencia = idTransferencia;
		this.cuentaOrigen = cuentaOrigen;
		this.cuentaDestino = cuentaDestino;
		this.fecha = fecha;
		this.importe = importe;
		this.concepto = concepto;
	}

	public int getIdTransferencia() {
		return idTransferencia;
	}

	public void setIdTransferencia(int idTransferencia) {
		this.idTransferencia = idTransferencia;
	}

	public Cuenta getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(Cuenta cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	public Cuenta getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(Cuenta cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	
	
	

}
