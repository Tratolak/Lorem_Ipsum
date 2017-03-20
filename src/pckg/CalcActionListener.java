package pckg;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class CalcActionListener implements ActionListener{

    private JLabel Lab1;
    private JButton Button1;
    private JButton Button2;
    //...

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
    	Lab1.setText("Button1 was pressed!");
    }

    private void button2Pressed()
    {
    	Lab1.setText("Button2 was pressed!");
    }
}