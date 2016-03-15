package dm.uniandes.ASE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Statistics {

	public static Double mean(List<Double> data) {
		Double result = new Double(0.00);
		result = (sumatoria(data) / (data.size()));

		return result;
	}

	public static Double calculateStandardDeviation(List<Double> data) {
		Double result = new Double(0.00);
		Double sum = 0.00;
		Double localMean = mean(data);

		for (int i = 0; i < data.size(); i++) {
			Double resta = data.get(i) - (localMean);
			Double raiz = Math.pow(resta, 2);
			sum = sum + raiz;
		}

		result = Math.sqrt(sum / (data.size() - 1));
		return result;
	}

	public static HashMap<String, Double> linearRegression(List<Double> pX, List<Double> pY) {

		int n = pX.size();
		Double xAvg = mean(pX);
		Double yAvg = mean(pY);
		Double xSum = sumatoria(pX);
		Double ySum = sumatoria(pY);
		ArrayList<Double> pXY = new ArrayList<Double>();
		for (int i = 0; i < n; i++) {
			Double num = pX.get(i) * pY.get(i);
			pXY.add(num);
		}
		Double xySum = sumatoria(pXY);
		Double xxSum = sumatoria(squaring(pX));
		Double yySum = sumatoria(squaring(pY));

		Double beta1 = (xySum - (n * xAvg * yAvg)) / (xxSum - n * xAvg * xAvg);
		Double beta0 = yAvg - beta1 * xAvg;
		Double up = (n * xySum) - (xSum * ySum);
		Double down = Math.sqrt(((n * xxSum) - Math.pow(xSum, 2)) * ((n * yySum) - Math.pow(ySum, 2)));
		Double rXY = up / down;
		Double r2 = rXY * rXY;
		Double yK = beta0 + (beta1 * 386);

		HashMap<String, Double> result = new HashMap<String, Double>();
		result.put("beta1", beta1);
		result.put("beta0", beta0);
		result.put("rXY", rXY);
		result.put("r2", r2);
		result.put("yK", yK);

		return result;
	}

	public static Double sumatoria(List<Double> pData) {
		Double result = new Double(0.00);
		for (int i = 0; i < pData.size(); i++) {
			result += pData.get(i);
		}
		return result;
	}

	public static List<Double> squaring(List<Double> pData) {
		for (int i = 0; i < pData.size(); i++) {
			Double sqrt = pData.get(i) * pData.get(i);
			pData.set(i, sqrt);
		}
		return pData;
	}

	public static List<Double> roundDown(List<Double> number, int digit) {
		ArrayList<Double> result = new ArrayList<Double>();
		int decimal = (int) Math.pow(10, digit);
		for (int i = 0; i < number.size(); i++) {
			Double num = Math.rint(number.get(i) * decimal) / decimal;
			result.add(num);
		}

		return result;
	}

	public static List<Double> logaritList(List<Double> data) {
		ArrayList<Double> result = new ArrayList<Double>();
		Double log = new Double(0.00);
		for (int i = 0; i < data.size(); i++) {
			log = Math.log(data.get(i));
			result.add(log);
		}
		return result;
	}

	public static Double variance(List<Double> pData) {
		Double result = new Double(0.00);
		Double avg = new Double(0.00);
		Double sum = new Double(0.00);
		Double n = new Double(0.00);
		n = (double) pData.size();
		ArrayList<Double> loglist = (ArrayList<Double>) logaritList(pData);
		avg = mean(loglist);
		
		for (int i = 0; i < n; i++) {
			loglist.set(i, (loglist.get(i) - avg));
		}
		sum = sumatoria(squaring(loglist));
		result = sum / (n - 1);
		return result;
	}

	public static List<Double> antiLogaritList(List<Double> data) {
		ArrayList<Double> result = new ArrayList<Double>();
		Double exp = new Double(0.00);
		for (int i = 0; i < data.size(); i++) {
			exp = Math.exp(data.get(i));
			result.add(exp);
		}
		return result;
	}

}
