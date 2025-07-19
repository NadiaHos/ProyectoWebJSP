package entidades;

import java.sql.Timestamp;

import entidades.TipoCuenta;

public class Cuenta {
	
	private int idCuenta;
	private Cliente cliente;
	private TipoCuenta tipoCuenta;
	private String nroCuenta;
	private String cbu;
	private double  saldo;
	private Timestamp  fechaCreacion;
	private boolean estado;
	
	public Cuenta() {}

	public Cuenta(int idCuenta, Cliente cliente, TipoCuenta tipoCuenta, String nroCuenta, String cbu, double saldo,
			Timestamp fechaCreacion, boolean estado) {
		super();
		this.idCuenta = idCuenta;
		this.cliente = cliente;
		this.tipoCuenta = tipoCuenta;
		this.nroCuenta = nroCuenta;
		this.cbu = cbu;
		this.saldo = saldo;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
