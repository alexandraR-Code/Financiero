package com.krakedev.financiero.entidades;

public class Cuenta {

	// atributos
	private String id;
	private double saldoActual;
	private String tipo;
	private Cliente propietario;

	// Constructor

	public Cuenta(String id) {
		this.id = id;
		this.saldoActual = 0;
		this.tipo = "A";
		this.propietario = new Cliente();
	}

	// Metodos getter y setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	// Metodo imprimir
	public void imprimir() {
		System.out.println("ID: " + id);
		System.out.println("Saldo actual: " + saldoActual);
		System.out.println("Tipo: " + tipo);
		System.out.println("Cédula cliente: " + propietario.getCedula());
		System.out.println("Nombre cliente: " + propietario.getNombre());
		System.out.println("Apellido cliente: " + propietario.getApellido());
	}

	// metodo getter y setter de propietario

	public Cliente getPropietario() {
		return propietario;
	}

	public void setPropietario(Cliente propietario) {
		this.propietario = propietario;
	}

}
