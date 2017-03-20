package pckg;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Calc_LibTest {
    @Test
    public void add() throws Exception {
        Calc_Lib add_test = new Calc_Lib();
        double sum = add_test.add(5,5);
        Assert.assertEquals(5,sum,0);
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