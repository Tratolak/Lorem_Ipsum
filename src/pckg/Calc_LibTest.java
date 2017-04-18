package pckg;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class Calc_LibTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void add() throws Exception{
        try{
            Calc_Lib.add(Double.MAX_VALUE, Double.MAX_VALUE);
            fail();
        } catch (Exception e){
            final String expected = "Add overflow";
            assertEquals(expected, e.getMessage());
        }

        try{
            Calc_Lib.add(-Double.MAX_VALUE, -Double.MAX_VALUE);
            fail();
        } catch (Exception e){
            final String expected = "Add overflow";
            assertEquals(expected, e.getMessage());
        }

        double result = Calc_Lib.add(-105.4,45.6);
        Assert.assertEquals(-59.8, result,0.0001);
    }


    @Test
    public void sub() throws Exception {
		try{
			Calc_Lib.sub(-Double.MAX_VALUE, Double.MAX_VALUE);
			fail();
		} catch (Exception e){
			final String expected = "Sub overflow";
			assertEquals(expected, e.getMessage());
		}

		try{
			Calc_Lib.sub(Double.MAX_VALUE, -Double.MAX_VALUE);
			fail();
		} catch (Exception e){
			final String expected = "Sub overflow";
			assertEquals(expected, e.getMessage());
		}

		double result = Calc_Lib.sub(105.4,45.6);
		Assert.assertEquals(59.8, result,0.0001);
    }


    @Test
    public void mult() throws Exception {
		try{
			Calc_Lib.mult(Double.MAX_VALUE, 2);
			fail();
		} catch (Exception e){
			final String expected = "Mult overflow";
			assertEquals(expected, e.getMessage());
		}
		try{
			Calc_Lib.mult(Double.MAX_VALUE, -2);
			fail();
		} catch (Exception e){
			final String expected = "Mult overflow";
			assertEquals(expected, e.getMessage());
		}

		double result = Calc_Lib.mult(105.4,5);
		Assert.assertEquals(527, result,0);
    }

    @Test
    public void divide() throws Exception {
		try{
			Calc_Lib.divide(100, 0);
			fail();
		} catch (Exception e){
			final String expected = "Dividing by zero";
			assertEquals(expected, e.getMessage());
		}

		double result = Calc_Lib.divide(105.4,6);
		Assert.assertEquals(17.5666, result,0.0001);
    }

    @Test
    public void factorial() throws Exception {
		try{
			Calc_Lib.factorial(100);
			fail();
		} catch (Exception e){
			final String expected = "Factorial overflow";
			assertEquals(expected, e.getMessage());
		}
		try{
			Calc_Lib.factorial(-4);
			fail();
		} catch (Exception e){
			final String expected = "Factorial from negative number";
			assertEquals(expected, e.getMessage());
		}

		long result = Calc_Lib.factorial(8);
		Assert.assertEquals(40320, result);
    }

    @Test
    public void power() throws Exception {
		try{
			Calc_Lib.power(Double.MAX_VALUE, 2);
			fail();
		} catch (Exception e){
			final String expected = "Power overflow";
			assertEquals(expected, e.getMessage());
		}

		double result = Calc_Lib.power(8.5,5.1);
		Assert.assertEquals(54958.70883, result,0.00001);

		result = Calc_Lib.power(-4.5,4);
		Assert.assertEquals(410.0625, result,0.00001);

		result = Calc_Lib.power(-8.5,5);
		Assert.assertEquals(-44370.53125, result,0.00001);

		result = Calc_Lib.power(-8.5,5.4);
		Assert.assertEquals(Double.NaN, result,0);
	}

    @Test
    public void root() throws Exception {
		try{
			Calc_Lib.root(-4, 2);
			fail();
		} catch (Exception e){
			final String expected = "Root from negative number";
			assertEquals(expected, e.getMessage());
		}
		try{
			Calc_Lib.root(4, 0);
			fail();
		} catch (Exception e){
			final String expected = "Can't count zero root";
			assertEquals(expected, e.getMessage());
		}

		double result = Calc_Lib.root(0,4);
		Assert.assertEquals(0, result,0);

		result = Calc_Lib.root(8.2,-3.1);
		Assert.assertEquals(0.507249, result,0.00001);
    }

    @Test
    public void st_Dev() throws Exception {
		double result;
		result = Calc_Lib.st_Dev("src/pckg/st_Dev_00.txt");
		Assert.assertEquals(46.58169, result,0.00001);

		try{
			Calc_Lib.st_Dev("src/pckg/st_Dev_01.txt");
			fail();
		} catch (Exception e){
			final String expected = "Invalid input file";
			assertEquals(expected, e.getMessage());
		}
	}
}
