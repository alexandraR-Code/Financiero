package com.krakedev.financiero.testsJUnit;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BancoTestJUnit {

	@Test
	public void primeraCuentaTieneCodigoInicial1000() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("124588", "Carolina", "Prieto");
		Cuenta cuenta = banco.crearCuenta(cliente);
		assertEquals("1000", cuenta.getId());
	}

	@Test
	public void segundaCuentaTieneCodigo1001() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("154265", "Ana", "Rodriguez");
		banco.crearCuenta(cliente);
		Cuenta cuenta2 = banco.crearCuenta(cliente);
		assertEquals("1001", cuenta2.getId());
	}

	@Test
	public void codigosConsecutivosAlCrearVariasCuentas() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("1584854", "Tatiana", "Salazar");
		Cuenta cuenta1 = banco.crearCuenta(cliente);
		Cuenta cuenta2 = banco.crearCuenta(cliente);
		Cuenta cuenta3 = banco.crearCuenta(cliente);

		assertEquals("1000", cuenta1.getId());
		assertEquals("1001", cuenta2.getId());
		assertEquals("1002", cuenta3.getId());
	}

	@Test
	public void ultimoCodigoSeIncrementaTrasCrearCuenta() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("8484446", "Jose", "Cardenas");
		banco.crearCuenta(cliente);
		assertEquals(1001, banco.getUltimoCodigo());
	}

	@Test
	public void cuentaCreadaEsDeTipoAhorros() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("151551", "Julian", "Tellez");
		Cuenta cuenta = banco.crearCuenta(cliente);
		assertEquals("A", cuenta.getTipo());
	}

	@Test
	public void cuentaCreadaAsignaClienteRecibido() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("1848462", "Alexandra", "Ramirez");
		Cuenta cuenta = banco.crearCuenta(cliente);
		assertEquals("1848462", cuenta.getPropietario().getCedula());
	}

	@Test
	public void cuentaCreadaIniciaConSaldoCero() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente("484666", "David", "Ballesteros");
		Cuenta cuenta = banco.crearCuenta(cliente);
		assertEquals(0, cuenta.getSaldoActual(), 0.001);
	}
}