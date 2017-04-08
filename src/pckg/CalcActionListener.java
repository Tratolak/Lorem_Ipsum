package pckg;

import java.awt.event.ActionEvent;
import javax.swing.*;


/**
 * \class CalcActionListener
 *
 * \brief Třída pro zpracování signálů
 *
 * Zpracovává signály od GUI a volá patřičné metody.
 *
 */
public class CalcActionListener extends AbstractAction{

	private static final long serialVersionUID = 1L;
	
	Main_Window.ComponentContainer Components;

    /**
     * Konstruktor
     */
    public CalcActionListener( Main_Window.ComponentContainer container){
    	Components = container;
    }
    
    /**
     * Odchytávač signálů
     */
    public void actionPerformed(ActionEvent e) {
    	
    	//System.out.print(e.getSource().equals(b2));
    	
    	if(e.getSource().equals(Components.btnrov))
    	{
    		rovnasePressed();
    	}
    	else if(e.getSource().equals(Components.btnplus))
    	{
    		plusPressed();
    	}
    	else if(e.getSource().equals(Components.btn0))
    	{
    		btn0Pressed();
    	}
    	else if(e.getSource().equals(Components.btn1))
    	{
    		btn1Pressed();
    	}
    	else if(e.getSource().equals(Components.btn2))
    	{
    		btn2Pressed();
    	}
    	else if(e.getSource().equals(Components.btn3))
    	{
    		btn3Pressed();
    	}
    	else if(e.getSource().equals(Components.btn4))
    	{
    		btn4Pressed();
    	}
    	else if(e.getSource().equals(Components.btn5))
    	{
    		btn5Pressed();
    	}
    	else if(e.getSource().equals(Components.btn6))
    	{
    		btn6Pressed();
    	}
    	else if(e.getSource().equals(Components.btn7))
    	{
    		btn7Pressed();
    	}
    	else if(e.getSource().equals(Components.btn8))
    	{
    		btn8Pressed();
    	}
    	else if(e.getSource().equals(Components.btn9))
    	{
    		btn9Pressed();
    	}
    	else if(e.getSource().equals(Components.btnminus))
    	{
    		btnminPressed();
    	}
    	else if(e.getSource().equals(Components.btnkrat))
    	{
    		btnkratPressed();
    	}
    	else if(e.getSource().equals(Components.btndeleno))
    	{
    		btndelenoPressed();
    	}
    	else if(e.getSource().equals(Components.btncar))
    	{
    		btncarPressed();
    	}
    	else if(e.getSource().equals(Components.btnC))
    	{
    		btnCPressed();
    	}
    	else if(e.getSource().equals(Components.btnDel))
    	{
    		btnbackspace();
    	}
    	else if(e.getSource().equals(Components.btnmoc2))
    	{
    		btnmoc2();
    	}
    	else if(e.getSource().equals(Components.btnmocn))
    	{
    		btnmocn();
    	}
    	else if(e.getSource().equals(Components.btnodm2))
    	{
    		btnodm2();
    	}
    	else if(e.getSource().equals(Components.btnodmocn))
    	{
    		btnodmn();
    	}
    	else{
    		System.out.print("toto se nemelo stat");
    	}
    }
    private Integer mocnina = 0;
    private Integer odmocnina = 0;
    private Integer nasobeni = 0;
    private Integer deleni = 0;
    private String priklad="";
    private String prvnic ="";
    private String druhec ="";
    private String operace="";
    private String vys="";
    private Integer jednou=0;
    /* 
    
    private Integer konec1=-1;
    private Integer od=0;
    */
    private void rovnasePressed()
    {
    	priklad = Components.priklad.getText().toString();
    	jednou=0;
    	for(int i = 0; i < priklad.length(); i++)
    	{
    		
    		if (priklad.charAt(i) == '+'){
    			for(int j = i-1; j>=0 && priklad.charAt(j)!= '+' && priklad.charAt(j)!= '-' && priklad.charAt(j)!= '*' && priklad.charAt(j)!= '/' && priklad.charAt(j)!= '^' && priklad.charAt(j)!= '√'; j--){
					prvnic=priklad.substring(j, i);		
					
				}
				for(int j = i+1; j<priklad.length() && priklad.charAt(j)!= '+' && priklad.charAt(j)!= '-' && priklad.charAt(j)!= '*' && priklad.charAt(j)!= '/' && priklad.charAt(j)!= '^' && priklad.charAt(j) != '√';j++ ){
					druhec=priklad.substring(i+1,j+1);		
				}
				operace="+";
				vys = vypocitej(prvnic, druhec, operace);
				prvnic="";
				druhec="";
				jednou+=1;
    		}
    		
    		if (priklad.charAt(i) == '-'){
    			for(int j = i-1; j>=0 && priklad.charAt(j)!= '+' && priklad.charAt(j)!= '-' && priklad.charAt(j)!= '*' && priklad.charAt(j)!= '/' && priklad.charAt(j)!= '^' && priklad.charAt(j)!= '√'; j--){
					prvnic=priklad.substring(j, i);		
					
				}
				for(int j = i+1; j<priklad.length() && priklad.charAt(j)!= '+' && priklad.charAt(j)!= '-' && priklad.charAt(j)!= '*' && priklad.charAt(j)!= '/' && priklad.charAt(j)!= '^' && priklad.charAt(j) != '√';j++ ){
					druhec=priklad.substring(i+1,j+1);		
				}
				operace="-";
				vys = vypocitej(prvnic, druhec, operace);
				prvnic="";
				druhec="";
				jednou+=1;
    		}
    		if (priklad.charAt(i) == '^'){
    			for(int j = i-1; j>=0 && priklad.charAt(j)!= '+' && priklad.charAt(j)!= '-' && priklad.charAt(j)!= '*' && priklad.charAt(j)!= '/' && priklad.charAt(j)!= '^' && priklad.charAt(j)!= '√'; j--){
					prvnic=priklad.substring(j, i);		
					
				}
				for(int j = i+1; j<priklad.length() && priklad.charAt(j)!= '+' && priklad.charAt(j)!= '-' && priklad.charAt(j)!= '*' && priklad.charAt(j)!= '/' && priklad.charAt(j)!= '^' && priklad.charAt(j) != '√';j++ ){
					druhec=priklad.substring(i+1,j+1);		
				}
				operace="^";
				vys = vypocitej(prvnic, druhec, operace);
				prvnic="";
				druhec="";
				jednou+=1;
    		}
    		if (priklad.charAt(i) == '√'){
    			for(int j = i-1; j>=0 && priklad.charAt(j)!= '+' && priklad.charAt(j)!= '-' && priklad.charAt(j)!= '*' && priklad.charAt(j)!= '/' && priklad.charAt(j)!= '^' && priklad.charAt(j)!= '√'; j--){
					prvnic=priklad.substring(j, i);		
					
				}
				for(int j = i+1; j<priklad.length() && priklad.charAt(j)!= '+' && priklad.charAt(j)!= '-' && priklad.charAt(j)!= '*' && priklad.charAt(j)!= '/' && priklad.charAt(j)!= '^' && priklad.charAt(j) != '√';j++ ){
					druhec=priklad.substring(i+1,j+1);		
				}
				operace="√";
				vys = vypocitej(prvnic, druhec, operace);
				prvnic="";
				druhec="";
				jednou+=1;
    		}
    		if (priklad.charAt(i) == '*'){
    			for(int j = i-1; j>=0 && priklad.charAt(j)!= '+' && priklad.charAt(j)!= '-' && priklad.charAt(j)!= '*' && priklad.charAt(j)!= '/' && priklad.charAt(j)!= '^' && priklad.charAt(j)!= '√'; j--){
					prvnic=priklad.substring(j, i);		
					
				}
				for(int j = i+1; j<priklad.length() && priklad.charAt(j)!= '+' && priklad.charAt(j)!= '-' && priklad.charAt(j)!= '*' && priklad.charAt(j)!= '/' && priklad.charAt(j)!= '^' && priklad.charAt(j) != '√';j++ ){
					druhec=priklad.substring(i+1,j+1);		
				}
				operace="*";
				vys = vypocitej(prvnic, druhec, operace);
				prvnic="";
				druhec="";
				jednou+=1;
    		}
    		if (priklad.charAt(i) == '/'){
    			for(int j = i-1; j>=0 && priklad.charAt(j)!= '+' && priklad.charAt(j)!= '-' && priklad.charAt(j)!= '*' && priklad.charAt(j)!= '/' && priklad.charAt(j)!= '^' && priklad.charAt(j)!= '√'; j--){
					prvnic=priklad.substring(j, i);		
					
				}
				for(int j = i+1; j<priklad.length() && priklad.charAt(j)!= '+' && priklad.charAt(j)!= '-' && priklad.charAt(j)!= '*' && priklad.charAt(j)!= '/' && priklad.charAt(j)!= '^' && priklad.charAt(j) != '√';j++ ){
					druhec=priklad.substring(i+1,j+1);		
				}
				operace="/";
				vys = vypocitej(prvnic, druhec, operace);
				prvnic="";
				druhec="";
				jednou+=1;
    		}
			
				
    	}
    	if (jednou>1)
    	{vys="SyntaxError";}
    	Components.vysledek.setText(vys);	
    	
    	
    	
    	
    	
    	
    	
    	/*
    	priklad = Components.priklad.getText().toString();
    	if (odmocnina > 0){
    		for(int i = 0; i < priklad.length(); i++)
        	{
    			
    			
    			
        	
    			
    		//	System.out.print(i);
    			if (priklad.charAt(i) == '√'){	
    				for(int j = i-1; j>=0 && priklad.charAt(j)!= '+' && priklad.charAt(j)!= '-' && priklad.charAt(j)!= '*' && priklad.charAt(j)!= '/' && priklad.charAt(j)!= '^' && priklad.charAt(j)!= '√'; j--){
    					prvnic=priklad.substring(j, i);		
    					
    				}
    				for(int j = i+1; j<priklad.length() && priklad.charAt(j)!= '+' && priklad.charAt(j)!= '-' && priklad.charAt(j)!= '*' && priklad.charAt(j)!= '/' && priklad.charAt(j)!= '^' && priklad.charAt(j) != '√';j++ ){
    					druhec=priklad.substring(i+1,j+1);		
    				}
    				operace="√";
    				reg=prvnic+"√"+druhec;
    				System.out.print(reg);
    				priklad.regionMatches(toffset, vypocitej(prvnic, druhec, operace), 0, vypocitej(prvnic, druhec, operace).length() );// tady ma bzt matchovani dle regex
    				System.out.print(vypocitej(prvnic, druhec, operace));
    				prvnic="";
    				druhec="";
    			}
    			
        	}
    		
    	}
    	System.out.print(priklad);
    	for(int i = 0; i < priklad.length(); i++)
    	{
    		System.out.print(i);
    		if (priklad.charAt(i) == '+'){
    			if (prvnic==""){
    			prvnic=priklad.substring(konec1+1, i);
    			operace="+";
    			konec1= i;   			
    			}
    			else {
    				druhec = priklad.substring(konec1+1, i);
    				konec1=i; 				
    				vys=vypocitej(prvnic, druhec, operace);
    				prvnic="";
    				druhec="";
    			}
    		}
    		else if (priklad.charAt(i) == '-'){
    			
    		}		
    		
    	}
    	*/
    	
    }
    
    private double castvys=0;
    private Calc_Lib calclib = new Calc_Lib();
    private String vypocitej(String prvni, String druhe, String operace)
    {
    	if (operace == "+"){
    		
    		System.out.print(prvni+"to bzlo prvni nasleduje druhe :");
    		System.out.print(druhe + "konec");
    		castvys = calclib.add(Integer.valueOf(prvni), Integer.valueOf(druhe));
    	}
    	else if(operace == "-"){
    		castvys = calclib.sub(Integer.valueOf(prvni), Integer.valueOf(druhe));
    	}
    	else if(operace == "*"){
    		castvys = calclib.mult(Integer.valueOf(prvni), Integer.valueOf(druhe));
    	}
    	else if(operace == "/"){
    		castvys = calclib.divide(Integer.valueOf(prvni), Integer.valueOf(druhe));
    	}
    	else if(operace == "^"){
    		castvys = calclib.power(Integer.valueOf(prvni), Integer.valueOf(druhe));
    	}
    	else if(operace == "√"){
    		System.out.print(prvni+"to bzlo prvni nasleduje druhe :");
    		System.out.print(druhe + "konec");
    		castvys = calclib.root(Integer.valueOf(druhe), Integer.valueOf(prvni));
    	}
    	return Double.toString(castvys) ;
    }
    private void plusPressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "+");
    }
    
    private void btn0Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "0");
    }
    
    private void btn1Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "1");
    }
    
    private void btn2Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "2");
    }
    
    private void btn3Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "3");
    }
    
    private void btn4Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "4");
    }
    
    private void btn5Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "5");
    }
    
    private void btn6Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "6");
    }
    
    private void btn7Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "7");
    }
    
    private void btn8Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "8");
    }
    
    private void btn9Pressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "9");
    }
    private void btnminPressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "-");
    }
    private void btnkratPressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "*");
    	nasobeni+=1;
    }
    private void btndelenoPressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + "/");
    	deleni+=1;
    }
    private void btncarPressed()
    {
    	Components.priklad.setText(Components.priklad.getText() + ",");
    }
    
    private void btnmoc2()
    {
    	Components.priklad.setText(Components.priklad.getText() + "^2");
    	mocnina+=1;
    }
    private void btnmocn()
    {
    	Components.priklad.setText(Components.priklad.getText() + "^");
    	mocnina+=1;
    }
    private void btnodm2()
    {
    	Components.priklad.setText(Components.priklad.getText() + "2√");
    	odmocnina+=1;
    }
    private void btnodmn()
    {
    	Components.priklad.setText(Components.priklad.getText() + "√");
    	odmocnina+=1;
    }
    private void btnCPressed()
    {
    	Components.priklad.setText("");
    	Components.vysledek.setText("");
    }
    
    private String str = "";
    private void btnbackspace()
    {
    	str= Components.priklad.getText();
    	if (str != null && str.length() > 0) {
    			if ((str.charAt(str.length()-1))=='*'){ nasobeni-=1; }
    			else if ((str.charAt(str.length()-1))=='/'){ deleni-=1; }
    			else if ((str.charAt(str.length()-1))=='^'){ mocnina -= 1; }
    			else if ((str.charAt(str.length()-1))=='√'){ odmocnina -=1; }
    		
    	        str = str.substring(0, str.length()-1);
    	    }
    	
    	Components.priklad.setText(str);
    }
}