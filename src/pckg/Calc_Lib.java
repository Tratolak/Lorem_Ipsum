package pckg;

/**
 * Matematicka knihovna obsahujici funkce pro vypocet: souctu, rozdilu,
 * soucinu, podilu, faktorialu, mocniny, odmocniny a smerodatne odchylky.
 * V pripade chyby vraci kazda z funkci vyjimku.
 */
public class Calc_Lib {

	/**
	 * Provadi soucet dvou realnych cisel. V pripade preteceni vraci vyjimku.
	 *
	 * @param x double
	 * @param y double
	 * @return Vysledek po secteni vstupnich parametru.
	 * @throws Exception (Add overflow)
	 */
	public double add(double x, double y) throws Exception {
		double result = x + y;
		if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY) {
			throw new Exception("Add overflow");
		}
		return result;
	}

	/**
	 * Provadi rozdil dvou realnych cisel. V pripade preteceni vraci vyjimku.
	 *
	 * @param x double
	 * @param y double
	 * @return Vysledny rozdil dvou vstupnich parametru.
	 * @throws Exception (Sub overflow)
	 */
	public double sub(double x, double y) throws Exception {
		double result = x - y;
		if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY) {
			throw new Exception("Sub overflow");
		}
		return result;
	}

	/**
	 * Provadi nasobeni dvou realnych cisel. V pripade preteceni vraci vyjimku.
	 *
	 * @param x double
	 * @param y double
	 * @return Vysledek po nasobeni dvou vstupnich parametru.
	 * @throws Exception (Mult overflow)
	 */
	public double mult(double x, double y) throws Exception {
		double result = x * y;
		if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY) {
			throw new Exception("Mult overflow");
		}
		return result;
	}

	public double divide(double x, double y) {
		return 111.1;
	}

	public long factorial(long x) {
		return 1;
	}

	/**
	 * Counts power with Taylor's series
	 * @param x - base
	 * @param n - exponent
	 * @return powered number
	 * @throws Exception
	 */
	public double power(double x, double n) throws Exception {
		boolean neg_flag = false; //detect if ne is  negative
		double step = 1; //part of polynomial
		double prev_result = 1;
		double result = 0;
		int iterator = 1;
		//power of negative number
		if (x < 0 && n % 1 == 0) { //check if base is negative and exponent is int type
			if (n % 2 != 0) //check if number is even
				neg_flag = true;
			x *= (-1);
		}
		while (Math.abs(prev_result - result) >= 0.00001) {
			prev_result = result;
			result += step;
			step *= ((n * Math.log(x)) / iterator);
			iterator++;
		}
		result += step;
		if (result == Double.POSITIVE_INFINITY) {
			throw new Exception("Power overflow");
		} else {
			if (neg_flag)
				return result * (-1);
			else
				return result;
		}
	}

	/**
	 * Counts root n^sqrt(x) and returns result. If x<0 or n ==0 throws exception.
	 *
	 * @param x - root base
	 * @param n - root stage
	 * @return result of root
	 * @throws Exception
	 */
	public double root(double x, double n) throws Exception {
		double result = 1;
		double previous = 2;
		if (x < 0) {
			throw new Exception("Root from negative number");
		} else if (n == 0) {
			throw new Exception("Can't count zero root");
		}
		if (x == 0)
			return 0;
		if (n < 0) {
			x = 1 / x;
			n *= (-1);
		}
		while (Math.abs(previous - result) >= 0.0001) {
			previous = result;
			result = (1 / n) * ((n - 1) * result + (x / power(result, n - 1)));
		}
		return result;
	}

	public double st_Dev(String filename) {
		return 2.555;
	}

}
