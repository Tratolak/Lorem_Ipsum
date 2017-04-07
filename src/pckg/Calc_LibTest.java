package pckg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class Calc_LibTest {

    private Calc_Lib calc;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void init(){
       calc = new Calc_Lib();

    }

    @Test
    public void add() throws Exception{
        try{
            calc.add(Double.MAX_VALUE, Double.MAX_VALUE);
            fail();
        } catch (Exception e){
            final String expected = "Add overflow";
            assertEquals(expected, e.getMessage());
        }

        try{
            calc.add(-Double.MAX_VALUE, -Double.MAX_VALUE);
            fail();
        } catch (Exception e){
            final String expected = "Add overflow";
            assertEquals(expected, e.getMessage());
        }

        double result = calc.add(-105.4,45.6);
        Assert.assertEquals(-59.8, result,0.0001);
    }


    @Test
    public void sub() throws Exception {
		try{
			calc.sub(-Double.MAX_VALUE, Double.MAX_VALUE);
			fail();
		} catch (Exception e){
			final String expected = "Sub overflow";
			assertEquals(expected, e.getMessage());
		}

		try{
			calc.sub(Double.MAX_VALUE, -Double.MAX_VALUE);
			fail();
		} catch (Exception e){
			final String expected = "Sub overflow";
			assertEquals(expected, e.getMessage());
		}

		double result = calc.sub(105.4,45.6);
		Assert.assertEquals(59.8, result,0.0001);
    }


    @Test
    public void mult() throws Exception {
		try{
			calc.mult(Double.MAX_VALUE, 2);
			fail();
		} catch (Exception e){
			final String expected = "Mult overflow";
			assertEquals(expected, e.getMessage());
		}
		try{
			calc.mult(Double.MAX_VALUE, -2);
			fail();
		} catch (Exception e){
			final String expected = "Mult overflow";
			assertEquals(expected, e.getMessage());
		}

		double result = calc.mult(105.4,5);
		Assert.assertEquals(527, result,0);
    }

    @Test
    public void divide() throws Exception {
		try{
			calc.divide(100, 0);
			fail();
		} catch (Exception e){
			final String expected = "Dividing by zero";
			assertEquals(expected, e.getMessage());
		}

		double result = calc.divide(105.4,6);
		Assert.assertEquals(17.5668, result,0.0001);
		Assert.assertEquals(17.5666, result,0.0001);
    }

    @Test
    public void factorial() throws Exception {
		try{
			calc.factorial(1000);
			fail();
		} catch (Exception e){
			final String expected = "Factorial overflow";
			assertEquals(expected, e.getMessage());
		}

		long result = calc.factorial(8);
		Assert.assertEquals(40320, result);
    }

    @Test
    public void power() throws Exception {
		try{
			calc.power(Double.MAX_VALUE, 2);
			fail();
		} catch (Exception e){
			final String expected = "Power overflow";
			assertEquals(expected, e.getMessage());
		}

		double result = calc.power(8.5,5.1);
		Assert.assertEquals(54958.70883, result,0.00001);

		result = calc.power(-4.5,4);
		Assert.assertEquals(410.0625, result,0.00001);

		result = calc.power(-8.5,5);
		Assert.assertEquals(-44370.53125, result,0.00001);

		result = calc.power(-8.5,5.4);
		Assert.assertEquals(Double.NaN, result,0);
	}

    @Test
    public void root() throws Exception {
		try{
			calc.root(-4, 2);
			fail();
		} catch (Exception e){
			final String expected = "Root from negative number";
			assertEquals(expected, e.getMessage());
		}
		try{
			calc.root(4, 0);
			fail();
		} catch (Exception e){
			final String expected = "Can't count zero root";
			assertEquals(expected, e.getMessage());
		}

		double result = calc.root(0,4);
		Assert.assertEquals(0, result,0);

		result = calc.root(8.2,-3.1);
		Assert.assertEquals(0.507249, result,0.00001);
    }

    @Test
    public void st_Dev() throws Exception {
		double result;
		result = calc.st_Dev("st_Dev_00.txt");
		Assert.assertEquals(45.05729, result,0.00001);

		try{
			calc.st_Dev("st_Dev_01.txt");
			fail();
		} catch (Exception e){
			final String expected = "Invalid input file";
			assertEquals(expected, e.getMessage());
		}
	}
}
