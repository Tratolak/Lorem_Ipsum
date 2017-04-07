package pckg;

import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * \class CalcActionListener
 *
 * \brief T��da pro zpracov�n� sign�l�
 *
 * Zpracov�v� sign�ly od GUI a vol� pat�i�n� metody.
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
       
    }
    
    /**
     * Odchyt�va� sign�l�
     */
    public void actionPerformed(ActionEvent e) {
    	
    	if(e.getSource() == b1)
    	{
    		rovnasePressed();
    	}
    	else if(e.getActionCommand() == "+")
    	{
    		System.out.print("cokoli");
    		//plusPressed();
    	}
    	else{
    		System.out.print(e.getActionCommand());
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