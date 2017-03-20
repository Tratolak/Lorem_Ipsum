package pckg;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class CalcKeyListener implements KeyListener {
	
	public JLabel Lab1;
	
	public CalcKeyListener(JLabel lab1){
		this.Lab1 = lab1;
	}
	
    public void keyTyped(KeyEvent e) {
    	Lab1.setText("Something");
    }

    @Override
    public void keyPressed(KeyEvent e) {
    	Lab1.setText("Something");
        if (e.getKeyCode() == KeyEvent.VK_NUMPAD1 ) {
        	Lab1.setText("You have typed one");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        	Lab1.setText("You have pressed left arrow key");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    	Lab1.setText("Something");
    }

}
