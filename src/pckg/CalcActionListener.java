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
    private Integer zadavamdo=0;
    private Integer chyba=0;
    /* 
    
     private Integer jednou=0;
     
    private Integer konec1=-1;
    private Integer od=0;
    */
    private void rovnasePressed()
    {
    	Components.priklad.setText(Components.priklad.getText()+Components.vysledek.getText());
    	if (operace==""){
    		Components.priklad.setText(Components.vysledek.getText());
    	}
    	else{
    	Components.vysledek.setText(vypocitej(prvnic,druhec,operace));
    	operace="";
    	prvnic="";
    	druhec="";
    	zadavamdo=3;
    	}
    	/* jednoduchy parser
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
    	
    	
    	
    	
    	
    	*/
    	
    	/* slozity parser
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
    		castvys = calclib.add(Double.valueOf(prvni), Double.valueOf(druhe));
    	}
    	else if(operace == "-"){
    		System.out.print(prvni+"to bzlo prvni nasleduje druhe :");
    		System.out.print(druhe + "konec");
    		castvys = calclib.sub(Double.valueOf(prvni), Double.valueOf(druhe));
    	}
    	else if(operace == "*"){
    		castvys = calclib.mult(Double.valueOf(prvni), Double.valueOf(druhe));
    	}
    	else if(operace == "/"){
    		castvys = calclib.divide(Double.valueOf(prvni), Double.valueOf(druhe));
    	}
    	else if(operace == "^"){
    		castvys = calclib.power(Double.valueOf(prvni), Double.valueOf(druhe));
    	}
    	else if(operace == "√"){
    		System.out.print(prvni+"to bzlo prvni nasleduje druhe :");
    		System.out.print(druhe + "konec");
    		castvys = calclib.root( Double.valueOf(prvni),Double.valueOf(druhe));
    	}
    	return Double.toString(castvys) ;
    }
    private void plusPressed()
    {
    	if (zadavamdo==1 )
    	{	
    		druhec=Components.vysledek.getText().toString();
    		prvnic=vypocitej(prvnic,druhec,operace); 
    		Components.priklad.setText(prvnic+"+");
    		operace="+";
    		Components.vysledek.setText("");
    	}
    	else if (zadavamdo == 0 || zadavamdo==3){
    		prvnic=Components.vysledek.getText().toString();
    		Components.priklad.setText(Components.vysledek.getText()+"+");
    		Components.vysledek.setText("");
    		zadavamdo=1;
    		operace="+";
    	}
    	else{
    		//chyba=1; rovna se
    		
    	}
    }
    
    private void btn0Pressed()
    {
    	if (zadavamdo==0){
    		Components.vysledek.setText(Components.vysledek.getText() + "0");
    		prvnic=prvnic+"0";
    	}
    	else if (zadavamdo==1){
    		Components.vysledek.setText(Components.vysledek.getText() + "0");
    		druhec=druhec+"0";
    	}
    	else {
    		Components.vysledek.setText("");
    		zadavamdo=0;
    		Components.vysledek.setText(Components.vysledek.getText() + "0");
    		prvnic=prvnic+"0";
    	}
    }
    
    private void btn1Pressed()
    {
    	if (zadavamdo==0){
    		Components.vysledek.setText(Components.vysledek.getText() + "1");
    		prvnic=prvnic+"1";
    	}
    	else if (zadavamdo==1){
    		Components.vysledek.setText(Components.vysledek.getText() + "1");
    		druhec=druhec+"1";
    	}
    	else {
    		Components.vysledek.setText("");
    		zadavamdo=0;
    		Components.vysledek.setText(Components.vysledek.getText() + "1");
    		prvnic=prvnic+"1";
    	}
    }
    
    private void btn2Pressed()
    {
    	if (zadavamdo==0){
    		Components.vysledek.setText(Components.vysledek.getText() + "2");
    		prvnic=prvnic+"2";
    	}
    	else if (zadavamdo==1){
    		Components.vysledek.setText(Components.vysledek.getText() + "2");
    		druhec=druhec+"2";
    	}
    	else {
    		Components.vysledek.setText("");
    		zadavamdo=0;
    		Components.vysledek.setText(Components.vysledek.getText() + "2");
    		prvnic=prvnic+"2";
    	}
    }
    
    
    private void btn3Pressed()
    {
    	if (zadavamdo==0){
    		Components.vysledek.setText(Components.vysledek.getText() + "3");
    		prvnic=prvnic+"3";
    	}
    	else if (zadavamdo==1){
    		Components.vysledek.setText(Components.vysledek.getText() + "3");
    		druhec=druhec+"3";
    	}
    	else {
    		Components.vysledek.setText("");
    		zadavamdo=0;
    		Components.vysledek.setText(Components.vysledek.getText() + "3");
    		prvnic=prvnic+"3";
    	}
    }
    
    private void btn4Pressed()
    {
    	if (zadavamdo==0){
    		Components.vysledek.setText(Components.vysledek.getText() + "4");
    		prvnic=prvnic+"4";
    	}
    	else if (zadavamdo==1){
    		Components.vysledek.setText(Components.vysledek.getText() + "4");
    		druhec=druhec+"4";
    	}
    	else {
    		Components.vysledek.setText("");
    		zadavamdo=0;
    		Components.vysledek.setText(Components.vysledek.getText() + "4");
    		prvnic=prvnic+"4";
    	}
    }
    
    private void btn5Pressed()
    {
    	if (zadavamdo==0){
    		Components.vysledek.setText(Components.vysledek.getText() + "5");
    		prvnic=prvnic+"5";
    	}
    	else if (zadavamdo==1){
    		Components.vysledek.setText(Components.vysledek.getText() + "5");
    		druhec=druhec+"5";
    	}
    	else {
    		Components.vysledek.setText("");
    		zadavamdo=0;
    		Components.vysledek.setText(Components.vysledek.getText() + "5");
    		prvnic=prvnic+"5";
    	}
    }
    
    private void btn6Pressed()
    {
    	if (zadavamdo==0){
    		Components.vysledek.setText(Components.vysledek.getText() + "6");
    		prvnic=prvnic+"6";
    	}
    	else if (zadavamdo==1){
    		Components.vysledek.setText(Components.vysledek.getText() + "6");
    		druhec=druhec+"6";
    	}
    	else {
    		Components.vysledek.setText("");
    		zadavamdo=0;
    		Components.vysledek.setText(Components.vysledek.getText() + "6");
    		prvnic=prvnic+"6";
    	}
    }
    
    private void btn7Pressed()
    {
    	if (zadavamdo==0){
    		Components.vysledek.setText(Components.vysledek.getText() + "7");
    		prvnic=prvnic+"7";
    	}
    	else if (zadavamdo==1){
    		Components.vysledek.setText(Components.vysledek.getText() + "7");
    		druhec=druhec+"7";
    	}
    	else {
    		Components.vysledek.setText("");
    		zadavamdo=0;
    		Components.vysledek.setText(Components.vysledek.getText() + "7");
    		prvnic=prvnic+"7";
    	}
    }
    
    private void btn8Pressed()
    {
    	if (zadavamdo==0){
    		Components.vysledek.setText(Components.vysledek.getText() + "8");
    		prvnic=prvnic+"8";
    	}
    	else if (zadavamdo==1){
    		Components.vysledek.setText(Components.vysledek.getText() + "8");
    		druhec=druhec+"8";
    	}
    	else {
    		Components.vysledek.setText("");
    		zadavamdo=0;
    		Components.vysledek.setText(Components.vysledek.getText() + "8");
    		prvnic=prvnic+"8";
    	}
    }
    
    private void btn9Pressed()
    {
    	if (zadavamdo==0){
    		Components.vysledek.setText(Components.vysledek.getText() + "9");
    		prvnic=prvnic+"9";
    	}
    	else if (zadavamdo==1){
    		Components.vysledek.setText(Components.vysledek.getText() + "9");
    		druhec=druhec+"9";
    	}
    	else {
    		Components.vysledek.setText("");
    		zadavamdo=0;
    		Components.vysledek.setText(Components.vysledek.getText() + "9");
    		prvnic=prvnic+"9";
    	}
    }
    private void btnminPressed()
    {
    	
    	if (Components.vysledek.getText().isEmpty() && zadavamdo == 0){
    		prvnic="-";
    		Components.vysledek.setText("-");
    		
    	}
    	else if (zadavamdo==1 && druhec=="" )
    	{	
    		druhec="-";
    		Components.vysledek.setText("-");
    	}
    	else if (zadavamdo == 0 || zadavamdo==3){
    		prvnic=Components.vysledek.getText().toString();
    		Components.priklad.setText(Components.vysledek.getText()+"-");
    		Components.vysledek.setText("");
    		zadavamdo=1;
    		operace="-";
    	}
    	else if (zadavamdo == 1)
    	{
    		druhec=Components.vysledek.getText().toString();
    		prvnic=vypocitej(prvnic,druhec,operace); 
    		Components.priklad.setText(prvnic+"-");
    		operace="-";
    		Components.vysledek.setText("");
    		
    	}
    	else{
    		//chyba=1; rovna se
    		
    	}
    	
    	
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