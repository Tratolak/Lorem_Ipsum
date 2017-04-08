package pckg;

import java.io.*;
import java.util.*;

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
	public static double add(double x, double y) throws Exception {
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
	public static double sub(double x, double y) throws Exception {
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
	public static double mult(double x, double y) throws Exception {
		double result = x * y;
		if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY) {
			throw new Exception("Mult overflow");
		}
		return result;
	}

	public static double divide(double x, double y) {
		return x/y;
	}

	public static long factorial(long x) {
		return 1;
	}

	/**
	 * Counts power with Taylor's series
	 * @param x - base
	 * @param n - exponent
	 * @return powered number
	 * @throws Exception
	 */
	public static double power(double x, double n) throws Exception {
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
	 * Vypočítá směrodatnou odchylku z hodnot, které se nacházejí v souboru zadaném cestou 'filename'.
	 * Čísla uvnitř souboru jsou ve fromátu: cislo1 'whitespace chars' cislo2' whitespace chars'... cislo n
	 * Směrodatnou odchylku počítá podle vzorečku: ((suma(od i=0 do n)(xi - Xprumer)^2)/(n-1))^0.5
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
