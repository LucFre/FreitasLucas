package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fecha.Fecha;
/**
 * Conjunto de pruebas que prueban el correcto funcionamiento de la clase Fecha.
 * @author Lucas
 */
public class PruebaFecha {

	@Test
	public void test() {
		Fecha fecha;
		
		fecha = new Fecha(1,1,1111);
		assertEquals(true, fecha.valida());
		// día no válido
		fecha = new Fecha(32,12,1111);
		assertEquals(false, fecha.valida());
		// mes no válido
		fecha = new Fecha(1,13,1111);
		assertEquals(false, fecha.valida());
		// año no válido
		fecha = new Fecha(1,1,-1111);
		assertEquals(false, fecha.valida());
		// día no válido con respecto al mes
		fecha = new Fecha(31,4,1111);
		assertEquals(false, fecha.valida());
		//día no válido febrero no bisiesto
		fecha = new Fecha(29,2,2017);
		assertEquals(false, fecha.valida());
		// día válido febrero bisiesto
		fecha = new Fecha(29,2,2016);
		assertEquals(true, fecha.valida());
	}

}
