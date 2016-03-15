import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dm.uniandes.program1.FileFinder;
import dm.uniandes.program1.Statistics;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class Main {

	public static void main(String[] args) {

		port(Integer.valueOf(System.getenv("PORT")));
		staticFileLocation("/public");
		
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
		result1.add(avg1 - (2*dev1));
		result1.add(avg1 - dev1);
		result1.add(avg1);
		result1.add(avg1 + dev1);
		result1.add(avg1 + (2*dev1));
		result1 = (ArrayList<Double>) Statistics.antiLogaritList(result1);
		result1 = (ArrayList<Double>) Statistics.roundDown(result1, 4);
		
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
		result2.add(avg2 - (2*dev2));
		result2.add(avg2 - dev2);
		result2.add(avg2);
		result2.add(avg2 + dev2);
		result2.add(avg2 + (2*dev2));
		result2 = (ArrayList<Double>) Statistics.antiLogaritList(result2);
		result2 = (ArrayList<Double>) Statistics.roundDown(result2, 4);
		String a1 = result1.get(0).toString();
		String a2 = result1.get(1).toString();
		String a3 = result1.get(2).toString();
		String a4 = result1.get(3).toString();
		String a5 = result1.get(4).toString();
		String b1 = result2.get(0).toString();
		String b2 = result2.get(1).toString();
		String b3 = result2.get(2).toString();
		String b4 = result2.get(3).toString();
		String b5 = result2.get(4).toString();

		get("/", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("A1", a1);
			attributes.put("A2", a2);
			attributes.put("A3", a3);
			attributes.put("A4", a4);
			attributes.put("A5", a5);
			attributes.put("B1", b1);
			attributes.put("B2", b2);
			attributes.put("B3", b3);
			attributes.put("B4", b4);
			attributes.put("B5", b5);

			return new ModelAndView(attributes, "index.ftl");
		} , new FreeMarkerEngine());

	}

}
