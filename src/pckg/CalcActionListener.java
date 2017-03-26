package pckg;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class CalcActionListener extends AbstractAction implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JLabel Lab1;
    private JButton Button1;
    private JButton Button2;

    public CalcActionListener(JLabel lab1, JButton button1, JButton button2){
        this.Lab1 = lab1;
        this.Button1 = button1;
        this.Button2 = button2;
    }

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