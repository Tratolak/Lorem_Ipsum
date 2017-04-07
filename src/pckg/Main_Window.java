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
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;
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
	
	
	public class ComponentContainer {
		public JButton b1 = Button1;
		public JButton b2 = button_2;
		public JTextArea tA = textArea;
		}
	
	private ComponentContainer comc= new ComponentContainer();
	
	private JPanel contentPane;
	private JButton Button1 = new JButton("=");
	private JButton button_2 = new JButton("+");
	private JTextArea textArea = new JTextArea();
	private JButton button_14 = new JButton("0");
	private JButton button_15 = new JButton("- / +");
	private JButton button_16 = new JButton("New button");
	private JButton button_17 = new JButton("-");
	private JButton btnDel = new JButton("del");
	private JButton button_4 = new JButton("2");
	private JButton button_1 = new JButton("1");
	private JButton button_5 = new JButton("3");
	private JButton button_6 = new JButton("6");
	private JButton button_7 = new JButton("5");
	private JButton button_8 = new JButton("4");
	private JButton button_9 = new JButton("7");
	private JButton button_10 = new JButton("8");
	private JButton button_11 = new JButton("9");
	private JButton button_12 = new JButton("New button");
	private JButton button_13 = new JButton("New button");
	private JButton button_18 = new JButton("New button");
	private JButton button_19 = new JButton("New button");
	private JButton button_20 = new JButton("New button");
	private JButton button_21 = new JButton("New button");
	private JButton btnC = new JButton("C");
	private JButton button_23 = new JButton("/");
	private JButton button_24 = new JButton("*");
	
	private CalcActionListener ActionListener = new CalcActionListener(comc);

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
	public void KeyPressed (KeyEvent e){
		
		
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
	 	Button1.getActionMap().put( "doNum5Action", ActionListener );
		Button1.setBounds(310, 528, 90, 130);
		Button1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		Button1.addActionListener(ActionListener);
		
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		
		
		textArea.setEditable(false);
		textArea.setRows(2);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textArea.setBounds(10, 10, 390, 102);
		
		
		
		button_2.setBounds(310, 386, 90, 131);
		button_2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "ADD" ), "numplus" );
		button_2.getActionMap().put( "numplus", ActionListener );
		button_2.addActionListener(ActionListener);
		
		contentPane.setLayout(null);
		contentPane.add(Button1);
		contentPane.add(textArea);
		contentPane.add(button_2);
		
		
		button_14.setBounds(10, 599, 190, 60);
		contentPane.add(button_14);
		
		
		button_15.setBounds(210, 599, 90, 60);
		contentPane.add(button_15);
		
		button_16.setBounds(310, 204, 90, 60);
		contentPane.add(button_16);
		
		
		button_17.setBounds(310, 315, 90, 60);
		contentPane.add(button_17);
		
		
		btnDel.setBounds(310, 133, 90, 60);
		contentPane.add(btnDel);
		
		
			
		button_1.setBounds(10, 528, 90, 60);
		contentPane.add(button_1);
		
		
		button_4.setBounds(110, 528, 90, 60);
		contentPane.add(button_4);
		
		
		button_5.setBounds(210, 528, 90, 60);
		contentPane.add(button_5);
		
		
		button_6.setBounds(210, 457, 90, 60);
		contentPane.add(button_6);
		
		
		button_7.setBounds(110, 457, 90, 60);
		contentPane.add(button_7);
		
		
		button_8.setBounds(10, 457, 90, 60);
		contentPane.add(button_8);
		
		
		button_9.setBounds(10, 386, 90, 60);
		contentPane.add(button_9);
		
		
		button_10.setBounds(110, 386, 90, 60);
		contentPane.add(button_10);
		
		
		button_11.setBounds(210, 386, 90, 60);
		contentPane.add(button_11);
		
		
		button_12.setBounds(210, 133, 90, 60);
		contentPane.add(button_12);
		
		
		button_13.setBounds(110, 133, 90, 60);
		contentPane.add(button_13);
		
		
		button_18.setBounds(10, 133, 90, 60);
		contentPane.add(button_18);
		
		
		button_19.setBounds(10, 204, 90, 60);
		contentPane.add(button_19);
		
		
		button_20.setBounds(110, 204, 90, 60);
		contentPane.add(button_20);
		
		
		button_21.setBounds(210, 204, 90, 60);
		contentPane.add(button_21);
		
		
		btnC.setBounds(10, 315, 90, 60);
		contentPane.add(btnC);
		
		
		button_23.setBounds(110, 315, 90, 60);
		contentPane.add(button_23);
		
		
		button_24.setBounds(210, 315, 90, 60);
		contentPane.add(button_24);
	}
}