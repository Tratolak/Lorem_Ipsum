package pckg;

import java.awt.BorderLayout;
import java.awt.EventQueue;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import javax.swing.border.LineBorder;
//import java.awt.Color;


/**
 * \class Main_Window
 *
 * \brief Tøída pro GUI
 *
 * Tøídá øídící GUI a jeho signály.
 *
 */
public class Main_Window extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton Button1 = new JButton("=");
	private JLabel Lab1 = new JLabel("");
	//private CalcActionListener ActionListener = new CalcActionListener(Lab1, Button1, Button2);

	/**
	 * Spuštìní aplikace
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
	 * Vytvoøení frame a inicializace signálù
	 */
	public Main_Window() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		
		contentPane = new JPanel();
		
		Button1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "NUMPAD5" ), "doNum5Action" );
	//	Button1.getActionMap().put( "doNum5Action", ActionListener );
		Button1.setBounds(310, 528, 90, 130);
		Button1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
	//	Button1.addActionListener(ActionListener);
		
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 10, 424, 102);
		textArea.setLineWrap(true);
		
		JButton button_2 = new JButton("+");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(310, 386, 90, 131);
		contentPane.setLayout(null);
		Lab1.setBounds(0, 0, 434, 0);
		contentPane.add(Lab1);
		contentPane.add(Button1);
		contentPane.add(textArea);
		contentPane.add(button_2);
		
		JButton button_14 = new JButton("0");
		button_14.setBounds(10, 599, 190, 60);
		contentPane.add(button_14);
		
		JButton button_15 = new JButton("- / +");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_15.setBounds(210, 599, 90, 60);
		contentPane.add(button_15);
		
		JButton button_16 = new JButton("New button");
		button_16.setBounds(310, 204, 90, 60);
		contentPane.add(button_16);
		
		JButton button_17 = new JButton("-");
		button_17.setBounds(310, 315, 90, 60);
		contentPane.add(button_17);
		
		JButton btnDel = new JButton("del");
		btnDel.setBounds(310, 133, 90, 60);
		contentPane.add(btnDel);
		
		JButton button_1 = new JButton("1");
		button_1.setBounds(10, 528, 90, 60);
		contentPane.add(button_1);
		
		JButton button_4 = new JButton("2");
		button_4.setBounds(110, 528, 90, 60);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("3");
		button_5.setBounds(210, 528, 90, 60);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.setBounds(210, 457, 90, 60);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("5");
		button_7.setBounds(110, 457, 90, 60);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("4");
		button_8.setBounds(10, 457, 90, 60);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("7");
		button_9.setBounds(10, 386, 90, 60);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("8");
		button_10.setBounds(110, 386, 90, 60);
		contentPane.add(button_10);
		
		JButton button_11 = new JButton("9");
		button_11.setBounds(210, 386, 90, 60);
		contentPane.add(button_11);
		
		JButton button_12 = new JButton("New button");
		button_12.setBounds(210, 133, 90, 60);
		contentPane.add(button_12);
		
		JButton button_13 = new JButton("New button");
		button_13.setBounds(110, 133, 90, 60);
		contentPane.add(button_13);
		
		JButton button_18 = new JButton("New button");
		button_18.setBounds(10, 133, 90, 60);
		contentPane.add(button_18);
		
		JButton button_19 = new JButton("New button");
		button_19.setBounds(10, 204, 90, 60);
		contentPane.add(button_19);
		
		JButton button_20 = new JButton("New button");
		button_20.setBounds(110, 204, 90, 60);
		contentPane.add(button_20);
		
		JButton button_21 = new JButton("New button");
		button_21.setBounds(210, 204, 90, 60);
		contentPane.add(button_21);
		
		JButton btnC = new JButton("C");
		btnC.setBounds(10, 315, 90, 60);
		contentPane.add(btnC);
		
		JButton button_23 = new JButton("/");
		button_23.setBounds(110, 315, 90, 60);
		contentPane.add(button_23);
		
		JButton button_24 = new JButton("*");
		button_24.setBounds(210, 315, 90, 60);
		contentPane.add(button_24);
	}
}