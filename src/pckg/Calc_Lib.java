package pckg;

import java.io.*;
import java.util.*;

/**
 * Matematicka knihovna obsahujici funkce pro vypocet: souctu, rozdilu,
 * soucinu, podilu, faktorialu, mocniny, odmocniny a smerodatne odchylky.
 * V pripade chyby vyvola kazda z funkci vyjimku.
 */
public class Calc_Lib {

	/**
	 * Provadi soucet dvou realnych cisel. V pripade preteceni vyvola vyjimku.
	 *
	 * @param x double
	 * @param y double
	 * @return Vysledek po secteni vstupnich parametru.
	 * @throws Exception (Add overflow)
	 */
	public static double add(double x, double y) throws Exception {
		double result = x + y;
		if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY) {
			throw new Exception("Add overflow");
		}
		return result;
	}

	/**
	 * Provadi rozdil dvou realnych cisel. V pripade preteceni vyvola vyjimku.
	 *
	 * @param x double
	 * @param y double
	 * @return Vysledny rozdil dvou vstupnich parametru.
	 * @throws Exception (Sub overflow)
	 */
	public static double sub(double x, double y) throws Exception {
		double result = x - y;
		if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY) {
			throw new Exception("Sub overflow");
		}
		return result;
	}

	/**
	 * Provadi nasobeni dvou realnych cisel. V pripade preteceni vyvola vyjimku.
	 *
	 * @param x double
	 * @param y double
	 * @return Vysledek po nasobeni dvou vstupnich parametru.
	 * @throws Exception (Mult overflow)
	 */
	public static double mult(double x, double y) throws Exception {
		double result = x * y;
		if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY) {
			throw new Exception("Mult overflow");
		}
		return result;
	}

	/**
	 * Provadi vypoce podilu dvou cisel. Pokud je delitel 0 vyvola vyjimku
	 *
	 * @param x - delenec
	 * @param y - delitel
	 * @return vysledek po nasobeni
	 * @throws Exception (Dividing by zero)
	 */
	public static double divide(double x, double y) throws Exception {
		if (y == 0) {
			throw new Exception("Dividing by zero");
		}
		return x / y;
	}

	/**
	 * Provadi vypocet faktorialu. Pokud je cislo 'x' zaporne nebo dojde k preteceni vyvola vyjimku.
	 *
	 * @param x - cislo pro vypocet faktorialu
	 * @return hdnotu faktorialu
	 * @throws Exception (Factorial from negative number) || (Factorial overflow)
	 */
	public static long factorial(long x) throws Exception {
		if (x < 0) {
			throw new Exception("Factorial from negative number");
		}
		long result = 1;
		do {
			if (result >= Long.MAX_VALUE / x) {
				throw new Exception("Factorial overflow");
			}
			result = result * x;
			x--;
		} while (x > 0);
		return result;
	}

	/**
	 * Provadi vypocet mocniny pomoci Taylorova polynomu. Pokud je zaklad zaporne cislo, provede se kontrola jestli je
	 * exponent sude nebo liche cislo. Pokud je exponent sudy, zaklad je vynasoben -1 a nasledne je proveden vypocet.
	 * Pokud je exponent lichy aplikuje se stejny postu a na zaver je vysledek vynasoben -1. Pokud exponent neni cele
	 * cislo je vysledek roven hodnote NaN.
	 *
	 * @param x - zaklad
	 * @param n - exponent
	 * @return umocnene cislo
	 * @throws Exception (Power overflow)
	 */
	public static double power(double x, double n) throws Exception {
		boolean neg_flag = false; //
		double step = 1; //cast polynomu
		double prev_result = 1;
		double result = 0;
		int iterator = 1;
		//mocnina se zaporneho cisla
		if (x < 0 && n % 1 == 0) { //kotrola jestli je zaklad zaporny a exponent je typu int
			if (n % 2 != 0) //kontrola jestli je cislo sude
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
			if (neg_flag) //kontrola jestli byl zaklad zaporne cislo
				return result * (-1);
			else
				return result;
		}
	}

	/**
	 * Provadi vypocet odmocniny n^sqrt(x). Jestlize je x<0 nebo n==0 vyvola vyjimku.
	 *
	 * @param x - zaklad
	 * @param n - stupen odmocniny
	 * @return vysledek po odmocnovani
	 * @throws Exception (Root from negative number) || (Can't count zero root)
	 */
	public static double root(double x, double n) throws Exception {
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

	/**
	 * Vypočítá směrodatnou odchylku z hodnot, které se nacházejí v souboru zadaném cestou 'filename'. <br>
	 * Čísla uvnitř souboru jsou ve fromátu: cislo1 'whitespace chars' cislo2' whitespace chars'... cislo n <br>
	 * Směrodatnou odchylku počítá podle vzorečku: ((suma(od i=0 do n)(xi - Xprumer)^2)/(n-1))^0.5 <br>
	 * @param filename - Cesta k souboru s čísly
	 * @return hodnota směrodatné odchylky
	 * @throws Exception
	 */
	public static double st_Dev(String filename) throws Exception {
		List<Double> doubles = new ArrayList<>();

		BufferedReader br = new BufferedReader(new FileReader(filename));
		try
		{
		    String line = br.readLine();
		    String StringArr[];

		    while (line != null)
		    {
		    	StringArr = line.split("\\s+");

		    	for(String item : StringArr)
		    	{
		    		doubles.add(Double.parseDouble(item));
		    	}

		        line = br.readLine();
		    }
		}
		catch(IOException | NumberFormatException e)
		{
			throw new Exception("Invalid input file");
		}
		finally
		{
		    br.close();
		}

		//pocitani prumeru
		double average = 0.0;

		for(Double item : doubles)
		{
			try
			{
				average = add(average, item);
			}
			catch(Exception e)
			{
				throw e;
			}
		}

		try
		{
			average = divide(average, doubles.size());
		}
		catch(Exception e)
		{
			throw e;
		}

		double sum = 0.0;

		//pocitani suma(0-n)(xi - Xprumer)^2
		for(Double item : doubles)
		{
			try
			{
				sum = add(sum,power(sub(item, average),2));
			}
			catch(Exception e)
			{
				throw e;
			}
		}

		//vysledek (suma/n-1)^0.5
		return root(divide(sum, doubles.size()-1),2);
	}

}
