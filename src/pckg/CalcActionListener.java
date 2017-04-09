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
    /*
    private Integer mocnina = 0;
    private Integer odmocnina = 0;
    private Integer nasobeni = 0;
    private Integer deleni = 0;
    */
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
    	if (druhec==""){
    		Components.priklad.setText(Components.priklad.getText()+ Components.vysledek.getText() );
    		druhec=Components.vysledek.getText();
    	}
    	else
    	{
    		Components.priklad.setText(Components.priklad.getText()+ druhec );
    	}
    	if (operace==""){
    		Components.priklad.setText(Components.vysledek.getText());
    	}
    	else{
    	Components.vysledek.setText(vypocitej(prvnic,druhec,operace));
    	operace="";
    	prvnic="";
    	druhec="";
    	zadavamdo=1;
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
    /**
     * Funkce pro vypisováni čísel jednak do GUI, ale také do příslušné proměné
     * @param cislo Cislo, které se má vypsat
     */
    private void vypis(String cislo){
    	if (zadavamdo==0){
    		Components.vysledek.setText(Components.vysledek.getText() + cislo);
    		prvnic=prvnic+cislo;
    	}
    	else if (zadavamdo==1 && druhec.isEmpty() ){
    		druhec=cislo;
    		Components.vysledek.setText(cislo);
    	}
    	else if (zadavamdo==1){
    		Components.vysledek.setText(Components.vysledek.getText() + cislo);
    		druhec=druhec+cislo;
    	}
    	
    	else {
    		Components.vysledek.setText("");
    		zadavamdo=0;
    		Components.vysledek.setText(Components.vysledek.getText() + cislo);
    		prvnic=prvnic+cislo;
    	}
    	
    }
    
    
    private double castvys=0;
    private Integer poccarek=0;
    private Calc_Lib calclib = new Calc_Lib();
    /**
     * funkce pro volani příslušných mat. funkcí
     * @param prvni prvni argument pro vypocet
     * @param druhe druhy argument pro vypocet
     * @param operace operace ktera se ma provest 
     * @return vypocitane cislo formou stringu
     */
    private String vypocitej(String prvni, String druhe, String operace)
    {
    	for(int i = 0; i < prvni.length(); i++)
    	{
    		if (prvni.charAt(i)=='.'){poccarek+=1;}
    	}
    	if (poccarek>1){
    		poccarek=0;return "Neplatne cislo";
    		}
    	else{poccarek=0;}
    	for(int i = 0; i < druhe.length(); i++)
    	{
    		if (druhe.charAt(i)=='.'){poccarek+=1;}
    	}
    	if (poccarek>1){
    		poccarek=0;return "Neplatne cislo";
    		}else{poccarek=0;}	
    		
    	if (prvni.isEmpty()){prvni="0";}
    	if (druhe.isEmpty()){if (operace=="/"){
    		druhe="1";return "Neplatne cislo";
    		}
    	else{druhe="0";}}
    	System.out.print("op"+operace+"po");
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
    		System.out.print(prvni+"to bzlo prvni nasleduje druhe :");
    		System.out.print(druhe + "konec");
    		castvys = calclib.power(Double.valueOf(prvni), Double.valueOf(druhe));
    	}
    	else if(operace == "√"){
    		System.out.print(prvni+"to bzlo prvni nasleduje druhe :");
    		System.out.print(druhe + "konec");
    		castvys = calclib.root( Double.valueOf(prvni),Double.valueOf(druhe));
    	}
    	return Double.toString(castvys) ;
    }
    /**
     * operace plus
     */
    private void plusPressed()
    {
    	if (zadavamdo == 0 ){
    		prvnic=Components.vysledek.getText().toString();
    		Components.priklad.setText(Components.vysledek.getText()+" + ");
    		zadavamdo=1;
    		operace="+";
    	}
    	else if (zadavamdo == 1 && operace!="")
    	{
    		druhec=Components.vysledek.getText().toString();
    		prvnic=vypocitej(prvnic,druhec,operace); 
    		Components.priklad.setText(Components.priklad.getText() + druhec +" + ");
    		operace="+";
    		druhec="";
    		Components.vysledek.setText(prvnic);
    		
    	}
    	else if (zadavamdo == 1 && operace.isEmpty() && Components.vysledek.getText()!="")
    	{
    		prvnic=Components.vysledek.getText().toString(); 
    		Components.priklad.setText(Components.priklad.getText() +" + ");
    		operace="+";
    	}
    	else{
    		//chyba=1; rovna se
    		
    	}
    }
    
    private void btn0Pressed()
    {
    	vypis("0");
    }
    
    private void btn1Pressed()
    {
    	vypis("1");
    }
    
    private void btn2Pressed()
    {
    	vypis("2");
    }
    
    
    private void btn3Pressed()
    {
    	vypis("3");
    }
    
    private void btn4Pressed()
    {
    	vypis("4");
    }
    
    private void btn5Pressed()
    {
    	vypis("5");
    }
    
    private void btn6Pressed()
    {
    	vypis("6");
    }
    
    private void btn7Pressed()
    {
    	vypis("7");
    }
    
    private void btn8Pressed()
    {
    	vypis("8");
    }
    
    private void btn9Pressed()
    {
    	vypis("9");
    }
    private void btnminPressed()
    {
    	if (prvnic.isEmpty() && zadavamdo == 0){
    		prvnic="-";
    		Components.vysledek.setText("-");
    		
    	}
    	else if (zadavamdo==1 && druhec=="" && operace != "")
    	{	
    		druhec="-";
    		Components.vysledek.setText("-");
    	}
    	else if (zadavamdo == 0 ){
    		prvnic=Components.vysledek.getText().toString();
    		Components.priklad.setText(Components.vysledek.getText()+" - ");
    		Components.vysledek.setText("");
    		zadavamdo=1;
    		operace="-";
    	}
    	else if (zadavamdo == 1 && operace!="")
    	{
    		druhec=Components.vysledek.getText().toString();
    		prvnic=vypocitej(prvnic,druhec,operace); 
    		Components.priklad.setText(Components.priklad.getText() + druhec +" - ");
    		operace="-";
    		druhec="";
    		Components.vysledek.setText(prvnic);
    		
    	}
    	else if (zadavamdo == 1 && operace.isEmpty() && Components.vysledek.getText()!="")
    	{
    		prvnic=Components.vysledek.getText().toString(); 
    		Components.priklad.setText(Components.priklad.getText() +" - ");
    		operace="-";
    	}
    	else{
    		//chyba=1; rovna se
    		
    	}
    	
    	
    }
    private void btnkratPressed()
    {
    	if (zadavamdo == 0 ){
    		prvnic=Components.vysledek.getText().toString();
    		Components.priklad.setText(Components.vysledek.getText()+" * ");
    		zadavamdo=1;
    		operace="*";
    	}
    	else if (zadavamdo == 1 && operace!="")
    	{
    		druhec=Components.vysledek.getText().toString();
    		prvnic=vypocitej(prvnic,druhec,operace); 
    		Components.priklad.setText(Components.priklad.getText() + druhec +" * ");
    		operace="*";
    		druhec="";
    		Components.vysledek.setText(prvnic);
    		
    	}
    	else if (zadavamdo == 1 && operace.isEmpty() && Components.vysledek.getText()!="")
    	{
    		prvnic=Components.vysledek.getText().toString(); 
    		Components.priklad.setText(Components.priklad.getText() +" * ");
    		operace="*";
    	}
    	else{
    		//chyba=1; rovna se
    		
    	}
    	
    }
    private void btndelenoPressed()
    {
    	if (zadavamdo == 0 ){
    		prvnic=Components.vysledek.getText().toString();
    		Components.priklad.setText(Components.vysledek.getText()+" / ");
    		zadavamdo=1;
    		operace="/";
    	}
    	else if (zadavamdo == 1 && operace!="")
    	{
    		druhec=Components.vysledek.getText().toString();
    		prvnic=vypocitej(prvnic,druhec,operace); 
    		Components.priklad.setText(Components.priklad.getText() + druhec +" / ");
    		operace="/";
    		druhec="";
    		Components.vysledek.setText(prvnic);
    		
    	}
    	else if (zadavamdo == 1 && operace.isEmpty() && Components.vysledek.getText()!="")
    	{
    		prvnic=Components.vysledek.getText().toString(); 
    		Components.priklad.setText(Components.priklad.getText() +" / ");
    		operace="/";
    	}
    	else{
    		//chyba=1; rovna se
    		
    	}
    	
    }
    private void btncarPressed()
    {
    	vypis(".");
    }
    
    private void btnmoc2()
    {
    	if (zadavamdo == 0 ){
    		prvnic=Components.vysledek.getText().toString();
    		Components.priklad.setText(Components.vysledek.getText()+" ^ ");
    		zadavamdo=1;
    		operace="^";
    		druhec="2";
    		rovnasePressed();
    	}
    	else if (zadavamdo == 1 && operace!="")
    	{
    		druhec=Components.vysledek.getText().toString();
    		prvnic=vypocitej(prvnic,druhec,operace); 
    		Components.priklad.setText(Components.priklad.getText() + druhec +" ^");
    		operace="^";
    		druhec="2";
    		rovnasePressed();
    		
    	}
    	else if (zadavamdo == 1 && operace.isEmpty() && Components.vysledek.getText()!="")
    	{
    		prvnic=Components.vysledek.getText().toString(); 
    		Components.priklad.setText(Components.priklad.getText() +" ^");
    		operace="^";
    		druhec="2";
    		rovnasePressed();
    	}
    	else{
    		//chyba=1; rovna se
    		
    	}
    }
    private void btnmocn()
    {
    	if (zadavamdo == 0 ){
    		prvnic=Components.vysledek.getText().toString();
    		Components.priklad.setText(Components.vysledek.getText()+" ^ ");
    		zadavamdo=1;
    		operace="^";
    	}
    	else if (zadavamdo == 1 && operace!="")
    	{
    		druhec=Components.vysledek.getText().toString();
    		prvnic=vypocitej(prvnic,druhec,operace); 
    		Components.priklad.setText(Components.priklad.getText() + druhec +" ^ ");
    		operace="^";
    		druhec="";
    		Components.vysledek.setText(prvnic);
    		
    	}
    	else if (zadavamdo == 1 && operace.isEmpty() && Components.vysledek.getText()!="")
    	{
    		prvnic=Components.vysledek.getText().toString(); 
    		Components.priklad.setText(Components.priklad.getText() +" ^ ");
    		operace="^";
    	}
    	else{
    		//chyba=1; rovna se
    		
    	}
    }
    /**
     * Funkce pro vypocet 2 odmocniny z x
     * @todo obraceny vypis
     */
    private void btnodm2()
    {
    	if (zadavamdo == 0 ){
    		prvnic=Components.vysledek.getText().toString();
    		Components.priklad.setText(Components.vysledek.getText()+" √ ");
    		zadavamdo=1;
    		operace="√";
    		druhec="2";
    		rovnasePressed();
    	}
    	else if (zadavamdo == 1 && operace!="")
    	{
    		druhec=Components.vysledek.getText().toString();
    		prvnic=vypocitej(prvnic,druhec,operace); 
    		Components.priklad.setText(Components.priklad.getText() + druhec +" √");
    		operace="√";
    		druhec="2";
    		rovnasePressed();
    		
    	}
    	else if (zadavamdo == 1 && operace.isEmpty() && Components.vysledek.getText()!="")
    	{
    		prvnic=Components.vysledek.getText().toString(); 
    		Components.priklad.setText(Components.priklad.getText() +" √");
    		operace="√";
    		druhec="2";
    		rovnasePressed();
    	}
    	else{
    		//chyba=1; rovna se
    		
    	}
    }
    /**
     * Funkce pro vypocet n odmocniny z x
     * @todo obraceny vypis
     */
    private void btnodmn()
    {
    	if (zadavamdo == 0 ){
    		prvnic=Components.vysledek.getText().toString();
    		Components.priklad.setText(Components.vysledek.getText()+" √ ");
    		zadavamdo=1;
    		operace="√";
    	}
    	else if (zadavamdo == 1 && operace!="")
    	{
    		druhec=Components.vysledek.getText().toString();
    		prvnic=vypocitej(prvnic,druhec,operace); 
    		Components.priklad.setText(Components.priklad.getText() + druhec +" √ ");
    		operace="√";
    		druhec="";
    		Components.vysledek.setText(prvnic);
    		
    	}
    	else if (zadavamdo == 1 && operace.isEmpty() && Components.vysledek.getText()!="")
    	{
    		prvnic=Components.vysledek.getText().toString(); 
    		Components.priklad.setText(Components.priklad.getText() +" √ ");
    		operace="√";
    	}
    	else{
    		//chyba=1; rovna se
    		
    	};
    }
    private void btnCPressed()
    {
    	Components.priklad.setText("");
    	Components.vysledek.setText("");
    	prvnic="";
    	druhec="";
    	operace="";
    	zadavamdo=0;
    }
    
    private String str = "";
    private void btnbackspace()
    {
    	if (zadavamdo==0){
    		str= Components.vysledek.getText();
    	 	if (str != null && str.length() > 0) {
    	        str = str.substring(0, str.length()-1);
    	    }
    	
    	Components.vysledek.setText(str);
    	prvnic=str;
    	}
    	else{
    		str= Components.vysledek.getText();
        	if (str != null && str.length() > 0) {       		
        	        str = str.substring(0, str.length()-1);
        	    }
        	
        	Components.vysledek.setText(str);
        	druhec=str;
    	}
    }
}