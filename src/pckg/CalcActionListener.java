package pckg;

import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * \class CalcActionListener
 *
 * \brief Tøída pro zpracování signálù
 *
 * Zpracovává signály od GUI a volá patøièné metody.
 *
 */
public class CalcActionListener extends AbstractAction{

	private static final long serialVersionUID = 1L;
	
	Main_Window.ComponentContainer Components;

    /**
     * Konstruktor
     */
    public CalcActionListener( Main_Window.ComponentContainer container){
    	Components = container;
    }
    
    /**
     * Odchytávaè signálù
     */
    public void actionPerformed(ActionEvent e) {
    	
    	//System.out.print(e.getSource().equals(b2));
    	
    	if(e.getSource().equals(Components.btnrov))
    	{
    		rovnasePressed();
    	}
    	else if(e.getSource().equals(Components.btnplus))
    	{
    		plusPressed();
    	}
    	else if(e.getSource().equals(Components.btn0))
    	{
    		btn0Pressed();
    	}
    	else if(e.getSource().equals(Components.btn1))
    	{
    		btn1Pressed();
    	}
    	else if(e.getSource().equals(Components.btn2))
    	{
    		btn2Pressed();
    	}
    	else if(e.getSource().equals(Components.btn3))
    	{
    		btn3Pressed();
    	}
    	else if(e.getSource().equals(Components.btn4))
    	{
    		btn4Pressed();
    	}
    	else if(e.getSource().equals(Components.btn5))
    	{
    		btn5Pressed();
    	}
    	else if(e.getSource().equals(Components.btn6))
    	{
    		btn6Pressed();
    	}
    	else if(e.getSource().equals(Components.btn7))
    	{
    		btn7Pressed();
    	}
    	else if(e.getSource().equals(Components.btn8))
    	{
    		btn8Pressed();
    	}
    	else if(e.getSource().equals(Components.btn9))
    	{
    		btn9Pressed();
    	}
    	else if(e.getSource().equals(Components.btnminus))
    	{
    		btnminPressed();
    	}
    	else if(e.getSource().equals(Components.btnkrat))
    	{
    		btnkratPressed();
    	}
    	else if(e.getSource().equals(Components.btndeleno))
    	{
    		btndelenoPressed();
    	}
    	else if(e.getSource().equals(Components.btncar))
    	{
    		btncarPressed();
    	}
    	else if(e.getSource().equals(Components.btnC))
    	{
    		btnCPressed();
    	}
    	else if(e.getSource().equals(Components.btnDel))
    	{
    		btnbackspace();
    	}
    	else{
    		System.out.print("toto se nemelo stat");
    	}
    }
    
    private void rovnasePressed()
    {
    	Components.vysledek.setText(Components.priklad.getText());
    }

    private void plusPressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "+");
    }
    
    private void btn0Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "0");
    }
    
    private void btn1Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "1");
    }
    
    private void btn2Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "2");
    }
    
    private void btn3Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "3");
    }
    
    private void btn4Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "4");
    }
    
    private void btn5Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "5");
    }
    
    private void btn6Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "6");
    }
    
    private void btn7Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "7");
    }
    
    private void btn8Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "8");
    }
    
    private void btn9Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "9");
    }
    private void btnminPressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "-");
    }
    private void btnkratPressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "*");
    }
    private void btndelenoPressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "/");
    }
    private void btncarPressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + ",");
    }
    private void btnCPressed()
    {
    	Components.priklad.setText("");
    	Components.vysledek.setText("");
    }
    
    private String str = "";
    private void btnbackspace()
    {
    	str= Components.priklad.getText();
    	if (str != null && str.length() > 0) {
    	      str = str.substring(0, str.length()-1);
    	    }
    	
    	Components.priklad.setText(str);
    }
}