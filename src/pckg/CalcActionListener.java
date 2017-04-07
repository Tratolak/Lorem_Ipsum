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
	
	private JButton b1;
	private JButton b2;
	private JTextArea tA;

    /**
     * Konstruktor
     */
    public CalcActionListener( Main_Window.ComponentContainer container){
    	this.tA = container.tA;
    	this.b1 = container.b1;
        this.b2 = container.b2;
        System.out.print(this.b2);
    }
    
    /**
     * Odchytávaè signálù
     */
    public void actionPerformed(ActionEvent e) {
    	
    	System.out.print(e.getSource().equals(b2));
    	
    	if(e.getSource() == b1)
    	{
    		rovnasePressed();
    	}
    	else if(e.getSource().equals(b1))
    	{
    		plusPressed();
    	}
    	else if(e.getSource().equals(b1))
    	{
    		plusPressed();
    	}
    	else{
    		
    	}
    }
    
    private void rovnasePressed()
    {
    	
    }

    private void plusPressed()
    {
    	tA.setText(tA.getText() + "+");
    }
}