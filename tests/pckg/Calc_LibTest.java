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
    public void addDouble(){
        try{
            calc.add(Double.MAX_VALUE, 1);
            fail();
        } catch (Exception e){
            final String expected = "Double overflow";
            assertEquals(expected,e.getMessage());
        }
        System.out.println(Double.MAX_VALUE);

        try{
            calc.add(Double.MIN_VALUE, -1);
            fail();
        } catch (Exception e){
            final String expected = "Double underflow";
            assertEquals(expected,e.getMessage());
        }

        double add_result = calc.add(105.4,45.6);
        Assert.assertEquals(151,add_result,0);
    }

    @Test
    public void addInt(){
        try{
            calc.add(Integer.MAX_VALUE, 1);
            fail();
        } catch (Exception e){
            final String expected = "Integer overflow";
            assertEquals(expected,e.getMessage());
        }

        try{
            calc.add(Integer.MIN_VALUE, -1);
            fail();
        } catch (Exception e){
            final String expected = "Integer underflow";
            assertEquals(expected,e.getMessage());
        }

        double add_result = calc.add(107,103);
        Assert.assertEquals(210,add_result,0);
    }
    @Test
    public void sub() throws Exception {
    }

    @Test
    public void mult() throws Exception {
    }

    @Test
    public void divide() throws Exception {
    }

    @Test
    public void factorial() throws Exception {
    }

    @Test
    public void power() throws Exception {
    }

    @Test
    public void root() throws Exception {
    }

    @Test
    public void st_Dev() throws Exception {
    }

}