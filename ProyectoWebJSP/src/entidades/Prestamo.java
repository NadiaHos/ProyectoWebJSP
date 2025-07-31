package entidades;

import java.sql.Date;

import entidades.Cliente;
import entidades.Cuenta;

public class Prestamo {
	
	private int idPrestamo;
	private Cliente cliente;
	private Cuenta cuenta;
	private Date fechaAlta;
	private double importe;
	private int plazoMeses;
	private double cuotaMensual;
	private EstadoPrestamo estado;
	private int cuotasPendientes;
	private int cuotasPagas;
	
	public Prestamo() {}

	public Prestamo(int idPrestamo, Cliente cliente, Cuenta cuenta, Date fechaAlta, double importe, int plazoMeses,
			double cuotaMensual, EstadoPrestamo estado, int cuotasPendientes, int cuotasPagas) {
		super();
		this.idPrestamo = idPrestamo;
		this.cliente = cliente;
		this.cuenta = cuenta;
		this.fechaAlta = fechaAlta;
		this.importe = importe;
		this.plazoMeses = plazoMeses;
		this.cuotaMensual = cuotaMensual;
		this.estado = estado;
		this.cuotasPendientes = cuotasPendientes;
		this.cuotasPagas = cuotasPagas;
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public int getPlazoMeses() {
		return plazoMeses;
	}

	public void setPlazoMeses(int plazoMeses) {
		this.plazoMeses = plazoMeses;
	}

	public double getCuotaMensual() {
		return cuotaMensual;
	}

	public void setCuotaMensual(double cuotaMensual) {
		this.cuotaMensual = cuotaMensual;
	}

	public EstadoPrestamo getEstado() {
		return estado;
	}

	public void setEstado(EstadoPrestamo estado) {
		this.estado = estado;
	}

	public int getCuotasPendientes() {
		return cuotasPendientes;
	}

	public void setCuotasPendientes(int cuotasPendientes) {
		this.cuotasPendientes = cuotasPendientes;
	}

	public int getCuotasPagas() {
		return cuotasPagas;
	}

	public void setCuotasPagas(int cuotasPagas) {
		this.cuotasPagas = cuotasPagas;
	}
	
	

}
