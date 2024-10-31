package calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CaluladoraImplTest {

	private Calculadora calculadora;

	@BeforeEach
	void tearUp() {
		calculadora = new CaluladoraImpl();
	}

	@Test
	void test_debe_sumar_cuando_se_utiliza_mas() {
		int resultado = calculadora.calcular(1, '+', 2);
		Assertions.assertEquals(3, resultado);
	}

	@Test
	void test_debe_restar_cuando_se_utiliza_menos() {
		int resultado = calculadora.calcular(1, '-', 2);
		Assertions.assertEquals(-1, resultado);
	}

}
