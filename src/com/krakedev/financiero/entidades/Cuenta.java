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
	
	//Metodo imprimir
	public void imprimir() {
		System.out.println("Id: " + this.getId());
		System.out.println("Saldo actual: " + this.getSaldoActual());
		System.out.println("Tipo de cuenta: " + this.getTipo());
		System.out.println("Propietario de cuenta: " + propietario.getCedula());
	}
	
	//metodo getter y setter de propietario

	public Cliente getPropietario() {
		return propietario;
	}

	public void setPropietario(Cliente propietario) {
		this.propietario = propietario;
	}
	
	
	
	
	
	
	

}
