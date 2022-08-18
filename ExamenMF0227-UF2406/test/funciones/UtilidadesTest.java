package funciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UtilidadesTest {

	private static Utilidades util;
	
	@BeforeAll
	static void inicioUtilidades() {
		util = new Utilidades();
	}
	
	@Test
	void devuelveNotaTest() {
		assertEquals("Suspenso",util.devuelveNota(1), "Error de nota");
		assertEquals("Bien",util.devuelveNota(5), "Error de nota");
		assertEquals("Notable",util.devuelveNota(7), "Error de nota");
		assertEquals("Sobresaliente",util.devuelveNota(9), "Error de nota");
		assertEquals("Matrícula",util.devuelveNota(10), "Error de nota");
		assertThrows(ArithmeticException.class,()->util.devuelveNota(11), "Debe estar entre 0 y 10");
		assertThrows(ArithmeticException.class,()->util.devuelveNota(0), "Debe estar entre 0 y 10");

	}

}
