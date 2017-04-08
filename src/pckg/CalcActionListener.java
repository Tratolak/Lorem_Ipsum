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
    		System.out.print("huraplus");
    		plusPressed();
    	}
    	else if(e.getSource().equals(Components.btn0))
    	{
    		 
    	}
    	else{
    		
    	}
    }
    
    private void rovnasePressed()
    {
    	
    }

    private void plusPressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "+");
    }
}