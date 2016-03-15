package dm.uniandes.ASE;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class MainTest {

	public ArrayList<Double> answer1;
	public ArrayList<Double> answer2;

	@Before
	public void antesDelTest() {

		this.answer1 = new ArrayList<Double>();
		answer1.add(new Double(4.3953));
		answer1.add(new Double(8.5081));
		answer1.add(new Double(16.4696));
		answer1.add(new Double(31.8811));
		answer1.add(new Double(61.7137));
		answer1 = (ArrayList<Double>) Statistics.roundDown(answer1, 3);

		this.answer2 = new ArrayList<Double>();
		answer2.add(new Double(6.3375));
		answer2.add(new Double(8.4393));
		answer2.add(new Double(11.2381));
		answer2.add(new Double(14.9650));
		answer2.add(new Double(19.9280));
		answer2 = (ArrayList<Double>) Statistics.roundDown(answer2, 3);

	}

	@After
	public void despuesDelTest() {

	}

	@Test
	public void test1() {

		ArrayList<Double> data1 = new ArrayList<Double>();
		try {
			data1 = (ArrayList<Double>) FileFinder.getData("test1.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Double> log1 = (ArrayList<Double>) Statistics.logaritList(data1);
		Double avg1 = Statistics.mean(log1);
		Double var1 = Statistics.variance(data1);
		Double dev1 = Math.sqrt(var1);
		ArrayList<Double> result1 = new ArrayList<Double>();
		result1.add(avg1 - (2 * dev1));
		result1.add(avg1 - dev1);
		result1.add(avg1);
		result1.add(avg1 + dev1);
		result1.add(avg1 + (2 * dev1));
		result1 = (ArrayList<Double>) Statistics.antiLogaritList(result1);
		result1 = (ArrayList<Double>) Statistics.roundDown(result1, 3);

		assertEquals("Resultado Incorrecto", answer1, result1);
	}

	@Test
	public void test2() {

		ArrayList<Double> data2 = new ArrayList<Double>();
		try {
			data2 = (ArrayList<Double>) FileFinder.getData("test2.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Double> log2 = (ArrayList<Double>) Statistics.logaritList(data2);
		Double avg2 = Statistics.mean(log2);
		Double var2 = Statistics.variance(data2);
		Double dev2 = Math.sqrt(var2);
		ArrayList<Double> result2 = new ArrayList<Double>();
		result2.add(avg2 - (2 * dev2));
		result2.add(avg2 - dev2);
		result2.add(avg2);
		result2.add(avg2 + dev2);
		result2.add(avg2 + (2 * dev2));
		result2 = (ArrayList<Double>) Statistics.antiLogaritList(result2);
		result2 = (ArrayList<Double>) Statistics.roundDown(result2, 3);

		assertEquals("Resultado Incorrecto", answer2, result2);
	}

}
