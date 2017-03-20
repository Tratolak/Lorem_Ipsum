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
	public JButton Button1 = new JButton("Test");
	public JLabel Lab1 = new JLabel("Label");
	private final JButton Button2 = new JButton("New button");

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
		
		contentPane.addKeyListener(new CalcKeyListener(Lab1));
		
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(Button1, BorderLayout.SOUTH);
		contentPane.add(Button2, BorderLayout.WEST);
		contentPane.add(Lab1, BorderLayout.NORTH);
		
		Button1.addActionListener(new CalcActionListener(Lab1, Button1, Button2));
		Button2.addActionListener(new CalcActionListener(Lab1, Button1, Button2));
	}
}
