package pckg;

import java.awt.BorderLayout;
import java.awt.EventQueue;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
//import javax.swing.border.LineBorder;
//import java.awt.Color;

public class Main_Window extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton Button1 = new JButton("Test");
	private JLabel Lab1 = new JLabel("");
	private final JButton Button2 = new JButton("New button");
	
	private CalcActionListener ActionListener = new CalcActionListener(Lab1, Button1, Button2);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Window frame = new Main_Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main_Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setFocusable(true);
		
        // HERE ARE THE KEY BINDINGS
		Button1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "NUMPAD5" ), "doNum5Action" );
		Button1.getActionMap().put( "doNum5Action", ActionListener );
		Button2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "NUMPAD6" ), "doNum6Action" );
		Button2.getActionMap().put( "doNum6Action", ActionListener );
		
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(Button1, BorderLayout.SOUTH);
		contentPane.add(Button2, BorderLayout.WEST);
		contentPane.add(Lab1, BorderLayout.NORTH);
		
		Button1.addActionListener(ActionListener);
		Button2.addActionListener(ActionListener);
	}
}


