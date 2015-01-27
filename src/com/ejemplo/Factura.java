package com.ejemplo;

public class Factura {

	private String cliente;

	private double cantidad;

	public Factura(String cliente, double cantidad) {
		this.cliente = cliente;
		this.cantidad = cantidad;
	}

	public double getCantidad() {
		return cantidad;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

}
