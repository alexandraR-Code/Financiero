package com.krakedev.financiero.testsJUnit;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRetirarJUnit {

	@Test
	public void retirarMontoValidoRetornaTrue() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta cuenta = banco.crearCuenta(cliente);
		banco.depositar(100, cuenta);

		boolean resultado = banco.retirar(50, cuenta);
		assertEquals(true, resultado);
	}

	@Test
	public void retirarMontoValidoDisminuyeSaldo() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta cuenta = banco.crearCuenta(cliente);
		banco.depositar(100, cuenta);

		banco.retirar(30, cuenta);
		assertEquals(70, cuenta.getSaldoActual(), 0.001);
	}

	@Test
	public void retirarMontoIgualAlSaldoRetornaTrue() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta cuenta = banco.crearCuenta(cliente);
		banco.depositar(100, cuenta);

		boolean resultado = banco.retirar(100, cuenta);
		assertEquals(true, resultado);
	}

	@Test
	public void retirarMontoIgualAlSaldoDejaSaldoEnCero() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta cuenta = banco.crearCuenta(cliente);
		banco.depositar(100, cuenta);

		banco.retirar(100, cuenta);
		assertEquals(0, cuenta.getSaldoActual(), 0.001);
	}

	@Test
	public void retirarMontoMayorAlSaldoRetornaFalse() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta cuenta = banco.crearCuenta(cliente);
		banco.depositar(100, cuenta);

		boolean resultado = banco.retirar(150, cuenta);
		assertEquals(false, resultado);
	}

	@Test
	public void retirarMontoMayorAlSaldoNoModificaSaldo() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta cuenta = banco.crearCuenta(cliente);
		banco.depositar(100, cuenta);

		banco.retirar(150, cuenta);
		assertEquals(100, cuenta.getSaldoActual(), 0.001);
	}

	@Test
	public void retirarMontoCeroRetornaFalse() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta cuenta = banco.crearCuenta(cliente);
		banco.depositar(100, cuenta);

		boolean resultado = banco.retirar(0, cuenta);
		assertEquals(false, resultado);
	}

	@Test
	public void retirarMontoNegativoRetornaFalse() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta cuenta = banco.crearCuenta(cliente);
		banco.depositar(100, cuenta);

		boolean resultado = banco.retirar(-20, cuenta);
		assertEquals(false, resultado);
	}
}