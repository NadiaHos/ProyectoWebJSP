package entidades;

import entidades.TipoMovimiento;

import java.sql.Date;

import entidades.Cuenta;

public class Movimiento {
	
	private int idMovimiento;
	private Cuenta cuenta;
	private TipoMovimiento tipoMovimiento;
	private Date fecha;
	private String concepto;
	private double importe;
	
	
	public Movimiento() {}


	public Movimiento(int idMovimiento, Cuenta cuenta, TipoMovimiento tipoMovimiento, Date fecha, String concepto,
			double importe) {
		super();
		this.idMovimiento = idMovimiento;
		this.cuenta = cuenta;
		this.tipoMovimiento = tipoMovimiento;
		this.fecha = fecha;
		this.concepto = concepto;
		this.importe = importe;
	}


	public int getIdMovimiento() {
		return idMovimiento;
	}


	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}


	public Cuenta getCuenta() {
		return cuenta;
	}


	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}


	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}


	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getConcepto() {
		return concepto;
	}


	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}


	public double getImporte() {
		return importe;
	}


	public void setImporte(double importe) {
		this.importe = importe;
	}
}
