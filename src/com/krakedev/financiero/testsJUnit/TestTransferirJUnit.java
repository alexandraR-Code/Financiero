package com.krakedev.financiero.testsJUnit;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTransferirJUnit {

	@Test
	public void transferirConSaldoValidoRetornaTrue() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta origen = banco.crearCuenta(cliente);
		Cuenta destino = banco.crearCuenta(cliente);
		banco.depositar(100, origen);

		boolean resultado = banco.transferir(origen, destino);
		assertEquals(true, resultado);
	}

	@Test
	public void transferirDejaOrigenEnCero() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta origen = banco.crearCuenta(cliente);
		Cuenta destino = banco.crearCuenta(cliente);
		banco.depositar(100, origen);

		banco.transferir(origen, destino);
		assertEquals(0, origen.getSaldoActual(), 0.001);
	}

	@Test
	public void transferirAumentaSaldoDestino() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta origen = banco.crearCuenta(cliente);
		Cuenta destino = banco.crearCuenta(cliente);
		banco.depositar(100, origen);

		banco.transferir(origen, destino);
		assertEquals(100, destino.getSaldoActual(), 0.001);
	}

	@Test
	public void transferirConDestinoConSaldoPrevioAcumula() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta origen = banco.crearCuenta(cliente);
		Cuenta destino = banco.crearCuenta(cliente);
		banco.depositar(100, origen);
		banco.depositar(50, destino);

		banco.transferir(origen, destino);
		assertEquals(150, destino.getSaldoActual(), 0.001);
	}

	@Test
	public void transferirConOrigenSaldoCeroRetornaFalse() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta origen = banco.crearCuenta(cliente);
		Cuenta destino = banco.crearCuenta(cliente);

		boolean resultado = banco.transferir(origen, destino);
		assertEquals(false, resultado);
	}

	@Test
	public void transferirConOrigenSaldoCeroNoModificaDestino() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("515162", "Ana", "Perez");
		Cuenta origen = banco.crearCuenta(cliente);
		Cuenta destino = banco.crearCuenta(cliente);
		banco.depositar(30, destino);

		banco.transferir(origen, destino);
		assertEquals(30, destino.getSaldoActual(), 0.001);
	}
}