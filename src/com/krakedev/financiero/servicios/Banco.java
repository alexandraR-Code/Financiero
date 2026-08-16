package com.krakedev.financiero.servicios;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;


public class Banco {
	// atributos
	private int ultimoCodigo = 1000;

	// metodos getter y setter

	public int getUltimoCodigo() {
		return ultimoCodigo;
	}

	public void setUltimoCodigo(int ultimoCodigo) {
		this.ultimoCodigo = ultimoCodigo;
	}
	
	//Constructor
	public Banco() {
	}
	
	//metodo crearCuenta
	public Cuenta crearCuenta(Cliente cliente) {
	    // Convertir ultimoCodigo a String
	    String codigoStr = ultimoCodigo + "";
	    // Incrementar ultimoCodigo
	    ultimoCodigo++;
	    // Crear la cuenta con ese ID (constructor solo recibe id)
	    Cuenta cuenta = new Cuenta(codigoStr);
	    // Asignar el cliente recibido
	    cuenta.setPropietario(cliente);
	    // Retorna la cuenta creada
	    return cuenta;
	}
	//metodo depositar
	public boolean depositar(double monto, Cuenta cuenta) {
		if(monto > 0 ) {
			cuenta.setSaldoActual(cuenta.getSaldoActual() + monto);
			return true;
		}else {
			return false;
		}
	}
	// metodo retirar
		public boolean retirar(double monto, Cuenta cuenta) {
			if(monto > 0 && monto <= cuenta.getSaldoActual()) {
				cuenta.setSaldoActual(cuenta.getSaldoActual() - monto);
				return true;
			}else {
				return false;	
			}
		}
	

}
