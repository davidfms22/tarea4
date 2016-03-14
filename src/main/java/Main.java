import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class Main {

	public static void main(String[] args) {

		port(Integer.valueOf(System.getenv("PORT")));
		staticFileLocation("/public");

		get("/", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("A1", "0.0000");
			attributes.put("A2", "0.0000");
			attributes.put("A3", "0.0000");
			attributes.put("A4", "0.0000");
			attributes.put("A5", "0.0000");
			attributes.put("B1", "0.0000");
			attributes.put("B2", "0.0000");
			attributes.put("B3", "0.0000");
			attributes.put("B4", "0.0000");
			attributes.put("B5", "0.0000");

			return new ModelAndView(attributes, "index.ftl");
		} , new FreeMarkerEngine());

	}

}
