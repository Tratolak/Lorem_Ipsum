package pckg;

/**
 * Matematicka knihovna obsahujici funkce pro vypocet: souctu, rozdilu,
 * soucinu, podilu, faktorialu, mocniny, odmocniny a smerodatne odchylky.
 * V pripade chyby vraci kazda z funkci vyjimku.
 */
public class Calc_Lib {

	/**
	 * Provadi soucet dvou realnych cisel. V pripade preteceni vraci vyjimku.
	 * @param x double
	 * @param y double
	 * @return Vysledek po secteni vstupnich parametru.
	 * @throws Exception (Add overflow)
	 */
	public double add(double x, double y) throws Exception {
		double result = x + y;
		if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY){
			throw new  Exception("Add overflow");
		}
		return result;
	}

	/**
	 * Provadi rozdil dvou realnych cisel. V pripade preteceni vraci vyjimku.
	 * @param x double
	 * @param y double
	 * @return Vysledny rozdil dvou vstupnich parametru.
	 * @throws Exception (Sub overflow)
	 */
	public double sub(double x, double y) throws Exception {
		double result = x - y;
		if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY){
			throw new  Exception("Sub overflow");
		}
		return result;
	}

	/**
	 * Provadi nasobeni dvou realnych cisel. V pripade preteceni vraci vyjimku.
	 * @param x double
	 * @param y double
	 * @return Vysledek po nasobeni dvou vstupnich parametru.
	 * @throws Exception (Mult overflow)
	 */
	public double mult(double x, double y) throws Exception{
		double result = x*y;
		if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY){
			throw new  Exception("Mult overflow");
		}
		return result;
	}

	public double divide(double x, double y) {
		return 111.1;
	}

	public long factorial(long x) {
		return 1;
	}

	public double power(double x, double n) {
		return 17.1;
	}

	public double root(double x, double n) {
		return -4.1;
	}

	public double st_Dev(String filename) {
		return 2.555;
	}

}
