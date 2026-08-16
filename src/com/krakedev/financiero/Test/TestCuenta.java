package com.krakedev.financiero.Test;

import com.krakedev.financiero.entidades.Cuenta;

public class TestCuenta {

	public static void main(String[] args) {
		Cuenta cuenta1 = new Cuenta("123648549");
		cuenta1.imprimir();
	}
}