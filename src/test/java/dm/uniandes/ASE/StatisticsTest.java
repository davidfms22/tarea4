package dm.uniandes.ASE;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dm.uniandes.ASE.Statistics;

/**
 * Unit test for simple StatisticsTest.
 */
public class StatisticsTest {

	public ArrayList<Double> lista;
	public ArrayList<Double> result1;
	public ArrayList<Double> result2;

	@Before
	public void antesDelTest() {

		this.lista = new ArrayList<Double>();
		lista.add(new Double(2));
		lista.add(new Double(4));
		lista.add(new Double(5));
		lista.add(new Double(2));

	}

	@After
	public void despuesDelTest() {

	}

	@Test
	public void testSumatoria() {

		Double resultado = Statistics.sumatoria(lista);
		assertEquals("La sumatoria deberia ser 13", new Double(13), resultado, 1e-4);
	}

	@Test
	public void testMean() {

		Double resultado = Statistics.mean(lista);
		assertEquals("La media deberia ser 3.25", new Double(3.25), resultado, 1e-4);
	}

	@Test
	public void testVariance() {

		Double resultado = Statistics.variance(lista);
		assertEquals("La varianza deberia ser 0.2241", new Double(0.2241), resultado, 1e-4);
	}

}
