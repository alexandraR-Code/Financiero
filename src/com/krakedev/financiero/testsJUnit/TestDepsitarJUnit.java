package com.krakedev.financiero.testsJUnit;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDepsitarJUnit {

	@Test
	public void depositarMontoValidoRetornaTrue() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta cuenta = banco.crearCuenta(cliente);

		boolean resultado = banco.depositar(100, cuenta);
		assertEquals(true, resultado);
	}

	@Test
	public void depositarMontoValidoAumentaSaldo() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta cuenta = banco.crearCuenta(cliente);

		banco.depositar(100, cuenta);
		assertEquals(100, cuenta.getSaldoActual(), 0.001);
	}

	@Test
	public void depositarVariosMontosAcumulaSaldo() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta cuenta = banco.crearCuenta(cliente);

		banco.depositar(100, cuenta);
		banco.depositar(50, cuenta);
		assertEquals(150, cuenta.getSaldoActual(), 0.001);
	}

	@Test
	public void depositarMontoCeroRetornaFalse() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta cuenta = banco.crearCuenta(cliente);

		boolean resultado = banco.depositar(0, cuenta);
		assertEquals(false, resultado);
	}

	@Test
	public void depositarMontoNegativoRetornaFalse() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta cuenta = banco.crearCuenta(cliente);

		boolean resultado = banco.depositar(-50, cuenta);
		assertEquals(false, resultado);
	}

	@Test
	public void depositarMontoInvalidoNoModificaSaldo() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta cuenta = banco.crearCuenta(cliente);

		banco.depositar(-50, cuenta);
		assertEquals(0, cuenta.getSaldoActual(), 0.001);
	}
}
