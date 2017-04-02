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
	
	private JLabel Lab1;
    private JButton Button1;
    private JButton Button2;

    /**
     * Konstruktor
     */
    public CalcActionListener(JLabel lab1, JButton button1, JButton button2){
        this.Lab1 = lab1;
        this.Button1 = button1;
        this.Button2 = button2;
    }
    
    /**
     * Odchyt�va� sign�l�
     */
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == Button1)
    	{
    		button1Pressed();
    	}
    	else if(e.getSource() == Button2)
    	{
    		button2Pressed();
    	}
    }
    
    private void button1Pressed()
    {
    	Lab1.setText(Lab1.getText() + "5");
    }

    private void button2Pressed()
    {
    	Lab1.setText(Lab1.getText() + "6");
    }
}