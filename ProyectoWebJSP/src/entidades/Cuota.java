package entidades;

import java.sql.Date;

import entidades.Prestamo;

public class Cuota {
	
	private int idCuota;
	private Prestamo prestamo;
	private int nroCuota;
	private double monto;
	private Date fechaPago;
	private boolean estado;
	
	public Cuota() {}

	public Cuota(int idCuota, Prestamo prestamo, int nroCuota, double monto, Date fechaPago, boolean estado) {
		super();
		this.idCuota = idCuota;
		this.prestamo = prestamo;
		this.nroCuota = nroCuota;
		this.monto = monto;
		this.fechaPago = fechaPago;
		this.estado = estado;
	}

	public int getIdCuota() {
		return idCuota;
	}

	public void setIdCuota(int idCuota) {
		this.idCuota = idCuota;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public int getNroCuota() {
		return nroCuota;
	}

	public void setNroCuota(int nroCuota) {
		this.nroCuota = nroCuota;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	

}
