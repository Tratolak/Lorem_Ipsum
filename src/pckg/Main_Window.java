package pckg;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;
import javax.swing.border.LineBorder;
import java.awt.Color;






/**
 * \class Main_Window
 *
 * \brief Třída pro GUI
 *
 * Třída řídící GUI a jeho signály.
 *
 */
public class Main_Window extends JFrame{
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * \class ComponentContainer
	 *
	 * \brief Třída pro předaní tlačítek action listeneru
	 *
	 * Rato třída slouží pouze jako container pro předaní.
	 *
	 */
	
	public class ComponentContainer
	 {
		public JButton btnrov;
		public JButton btnplus;
		public JButton btn0;
		public JButton btncar;
		public JButton btnodch;
		public JButton btnminus;
		public JButton btnC;
		public JButton btn2;
		public JButton btn1;
		public JButton btn3;
		public JButton btn6;
		public JButton btn5;
		public JButton btn4;
		public JButton btn7;
		public JButton btn8;
		public JButton btn9;
		public JButton btnDel;
		public JButton btnodm2;
		public JButton btnmoc2;
		public JButton btnmocn;
		public JButton btnodmocn;
		public JButton btnAns;
		public JButton btnfakt;
		public JButton btndeleno;
		public JButton btnkrat;
		public JTextField priklad;
		public JTextField vysledek;   
	 }

	private Main_Window.ComponentContainer CompContainer = new Main_Window.ComponentContainer();
	
	private JPanel contentPane;
	private JButton btnrov = new JButton("=");
	private JButton btnplus = new JButton("+");
	private JButton btn0 = new JButton("0");
	private JButton btncar = new JButton(",");
	private JButton btnodch = new JButton("σ");
	private JButton btnminus = new JButton("-");
	private JButton btnC = new JButton("C");
	private JButton btn2 = new JButton("2");
	private JButton btn1 = new JButton("1");
	private JButton btn3 = new JButton("3");
	private JButton btn6 = new JButton("6");
	private JButton btn5 = new JButton("5");
	private JButton btn4 = new JButton("4");
	private JButton btn7 = new JButton("7");
	private JButton btn8 = new JButton("8");
	private JButton btn9 = new JButton("9");
	private JButton btnDel = new JButton("DEL");
	private JButton btnodm2 = new JButton("√ᵪ");
	private JButton btnmoc2 = new JButton("x²");
	private JButton btnmocn = new JButton("xⁿ");
	private JButton btnodmocn = new JButton("ⁿ√ᵪ");
	private JButton btnAns = new JButton("Ans");
	private JButton btnfakt = new JButton("!");
	private JButton btndeleno = new JButton("/");
	private JButton btnkrat = new JButton("*");
	private JTextField priklad = new JTextField();
	private JTextField vysledek = new JTextField();
	
	private CalcActionListener ActionListener;
	private final JScrollPane scrollPane = new JScrollPane();

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
		setBounds(100, 100, 415, 700);
		
		
		CompContainer.btnrov = btnrov;
		CompContainer.btnplus = btnplus;
		CompContainer.btn0 = btn0;
		CompContainer.btncar = btncar;
		CompContainer.btnodch = btnodch;
		CompContainer.btnminus = btnminus;
		CompContainer.btnC = btnC ;
		CompContainer.btn2 = btn2;
		CompContainer.btn1 = btn1;
		CompContainer.btn3 = btn3;
		CompContainer.btn6 = btn6;
		CompContainer.btn5 = btn5;
		CompContainer.btn4 = btn4;
		CompContainer.btn7 = btn7;
		CompContainer.btn8 = btn8;
		CompContainer.btn9 = btn9;
		CompContainer.btnDel = btnDel;
		CompContainer.btnodm2 = btnodm2;
		CompContainer.btnmoc2 = btnmoc2;
		CompContainer.btnmocn = btnmocn;
		CompContainer.btnodmocn = btnodmocn;
		CompContainer.btnAns = btnAns;
		CompContainer.btnfakt = btnfakt;
		CompContainer.btndeleno = btndeleno;
		CompContainer.btnkrat = btnkrat;
		CompContainer.priklad = priklad;
		CompContainer.vysledek = vysledek;  
		
		ActionListener = new CalcActionListener(CompContainer);
	
		
		
		
		
		
		contentPane = new JPanel();
		
		btnrov.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "ENTER" ), "enter" );
	 	btnrov.getActionMap().put( "enter", ActionListener );
		btnrov.setBounds(310, 528, 90, 130);
		btnrov.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnrov.addActionListener(ActionListener);
		
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		btnplus.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		
		
		btnplus.setBounds(310, 386, 90, 131);
		btnplus.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "ADD" ), "numplus" );
		btnplus.getActionMap().put( "numplus", ActionListener );
		btnplus.addActionListener(ActionListener);
		
		contentPane.setLayout(null);
		contentPane.add(btnrov);
		contentPane.add(btnplus);
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		
		btn0.setBounds(10, 599, 190, 60);
		btn0.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "NUMPAD0" ), "num0" );
		btn0.getActionMap().put( "num0", ActionListener );
		btn0.addActionListener(ActionListener);
		contentPane.add(btn0);
		
		btncar.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btncar.setBounds(210, 599, 90, 60);
		btncar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "DECIMAL" ), "car" );
		btncar.getActionMap().put( "car", ActionListener );
		btncar.addActionListener(ActionListener);
		contentPane.add(btncar);
		
		btnodch.setFont(new Font("Tahoma", Font.PLAIN, 30));		
		btnodch.setBounds(210, 216, 90, 60);
		btnodch.addActionListener(ActionListener);
		contentPane.add(btnodch);
		
		btnminus.setFont(new Font("Tahoma", Font.PLAIN, 30));		
		btnminus.setBounds(310, 315, 90, 60);
		btnminus.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "SUBTRACT" ), "nminus" );
		btnminus.getActionMap().put( "nminus", ActionListener );
		btnminus.addActionListener(ActionListener);
		contentPane.add(btnminus);
		
		
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 30));		
		btnC.setBounds(310, 145, 90, 60);	
		btnC.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "DELETE" ), "del" );
		btnC.getActionMap().put( "del", ActionListener );
		btnC.addActionListener(ActionListener);
		contentPane.add(btnC);
		
		
		
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn1.setBounds(10, 528, 90, 60);
		btn1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "NUMPAD1" ), "num1" );
		btn1.getActionMap().put( "num1", ActionListener );
		btn1.addActionListener(ActionListener);
		contentPane.add(btn1);
	
		
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 30));	
		btn2.setBounds(110, 528, 90, 60);
		btn2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "NUMPAD2" ), "num2" );
		btn2.getActionMap().put( "num2", ActionListener );
		btn2.addActionListener(ActionListener);
		contentPane.add(btn2);
	
		
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn3.setBounds(210, 528, 90, 60);
		btn3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "NUMPAD3" ), "num3" );
		btn3.getActionMap().put( "num3", ActionListener );
		btn3.addActionListener(ActionListener);
		contentPane.add(btn3);
	
		
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 30));	
		btn6.setBounds(210, 457, 90, 60);
		btn6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "NUMPAD6" ), "num6" );
		btn6.getActionMap().put( "num6", ActionListener );
		btn6.addActionListener(ActionListener);
		contentPane.add(btn6);
		
		
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 30));	
		btn5.setBounds(110, 457, 90, 60);
		btn5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "NUMPAD5" ), "num5" );
		btn5.getActionMap().put( "num5", ActionListener );
		btn5.addActionListener(ActionListener);
		contentPane.add(btn5);
		
		
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 30));		
		btn4.setBounds(10, 457, 90, 60);
		btn4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "NUMPAD4" ), "num4" );
		btn4.getActionMap().put( "num4", ActionListener );
		btn4.addActionListener(ActionListener);
		contentPane.add(btn4);
		
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn7.setBounds(10, 386, 90, 60);
		btn7.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "NUMPAD7" ), "num7" );
		btn7.getActionMap().put( "num7", ActionListener );
		btn7.addActionListener(ActionListener);
		contentPane.add(btn7);
		
		
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn8.setBounds(110, 386, 90, 60);
		btn8.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "NUMPAD8" ), "num8" );
		btn8.getActionMap().put( "num8", ActionListener );
		btn8.addActionListener(ActionListener);
		contentPane.add(btn8);
		
		
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn9.setBounds(210, 386, 90, 60);
		btn9.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "NUMPAD9" ), "num9" );
		btn9.getActionMap().put( "num9", ActionListener );
		btn9.addActionListener(ActionListener);
		contentPane.add(btn9);

		
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnDel.setBounds(210, 386, 90, 60);
		btnDel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "BACK_SPACE" ), "back" );
		btnDel.getActionMap().put( "back", ActionListener );
		btnDel.addActionListener(ActionListener);
		btnDel.setBounds(210, 145, 90, 60);
		contentPane.add(btnDel);
		
		
		btnodm2.setFont(new Font("Tahoma", Font.PLAIN, 30));	
		btnodm2.setBounds(110, 145, 90, 60);
		btnodm2.addActionListener(ActionListener);
		contentPane.add(btnodm2);
		
		btnmoc2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnmoc2.setBounds(10, 145, 90, 60);
		btnmoc2.addActionListener(ActionListener);
		contentPane.add(btnmoc2);
		
		
		
		btnmocn.setFont(new Font("Tahoma", Font.PLAIN, 30));	
		btnmocn.setBounds(10, 216, 90, 60);
		btnmocn.addActionListener(ActionListener);
		contentPane.add(btnmocn);
		
		
		btnodmocn.setFont(new Font("Tahoma", Font.PLAIN, 30));		
		btnodmocn.setBounds(110, 216, 90, 60);
		btnodmocn.addActionListener(ActionListener);
		contentPane.add(btnodmocn);
		
		
		btnAns.setFont(new Font("Tahoma", Font.PLAIN, 30));		
		btnAns.setBounds(310, 216, 90, 60);
		btnAns.addActionListener(ActionListener);
		contentPane.add(btnAns);
		
		
		btnfakt.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnfakt.setBounds(10, 315, 90, 60);
		btnfakt.addActionListener(ActionListener);
		contentPane.add(btnfakt);
		
		
		btndeleno.setFont(new Font("Tahoma", Font.PLAIN, 30));		
		btndeleno.setBounds(110, 315, 90, 60);
		btndeleno.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "DIVIDE" ), "deleni" );
		btndeleno.getActionMap().put( "deleni", ActionListener );
		btndeleno.addActionListener(ActionListener);
		contentPane.add(btndeleno);
		
		
		btnkrat.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnkrat.setBounds(210, 315, 90, 60);
		btnkrat.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( KeyStroke.getKeyStroke( "MULTIPLY" ), "nummult" );
		btnkrat.getActionMap().put( "nummult", ActionListener );
		btnkrat.addActionListener(ActionListener);
		contentPane.add(btnkrat);
		
		
		
		
		priklad.setEditable(false);
		priklad.setFont(new Font("Tahoma", Font.PLAIN, 26));
		priklad.setBackground(Color.WHITE);
		priklad.setForeground(Color.BLACK);
		priklad.setBounds(31, 11, 389, 40);
		priklad.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JScrollPane scroll = new JScrollPane (priklad, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(10, 11, 390, 60);
		scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(scroll);
		
		
		
		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 70, 389, 60);
		scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(scrollPane);
		
		
		
		
		scrollPane.setViewportView(vysledek);
		
	

		vysledek.setBackground(Color.WHITE);
		vysledek.setFont(new Font("Tahoma", Font.PLAIN, 27));
		vysledek.setHorizontalAlignment(SwingConstants.TRAILING);
		vysledek.setColumns(10);
		vysledek.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		vysledek.setEditable(false);
		
		
		
	}
}