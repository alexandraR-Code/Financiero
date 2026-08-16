package com.krakedev.financiero.entidades;

public class Cliente {

	// atributos
	private String cedula;
	private String nombre;
	private String apellido;

	// constructor
	public Cliente() {
		
	}

	// Metodos setter y getter

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	// Metodo imprimir
	
	public void imprimir() {
		System.out.println("Cedula: " + this.getCedula());
		System.out.println("Nombre: " + this.getNombre());
		System.out.println("Apellido: " + this.getApellido());
	}

}
