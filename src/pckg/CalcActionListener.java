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
	 private String str = ""; //pro spr8vnou funkci tlačítka Del
	 private String prvnic =""; //prvni zadavane cislo
	 private String druhec =""; //druhe zadavane cislo
	 private String operace=""; //zvolena operace
	 private Integer zadavamdo=0; //uzivatel prave zapisuje bud prvni nebo druhe cislo 
	 private String posledniplatny=""; //posledni platny vysledek
	 private Long factorial; //vypocteny factorial
	 private double castvys=0;//castecnz vzsledek funkce vypocitej- take posledni platna hodnota 
	 private Integer poccarek=0;//pocet carek v cisle pri parsovani
	 private String cesta="";//pro funkci odchylky
     Main_Window.ComponentContainer Components;

    /**
     * Konstruktor  
     *@param Main_Window.ComponentContainer předán container s graf. prvky
     */
    public CalcActionListener( Main_Window.ComponentContainer container){
    	Components = container;
    }
    
    /**
     * Odchytávač signálů
     * volá příslušné funkce tlačítek
     * @param ActionEvent předán ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
    	
    	if(e.getSource().equals(Components.btnrov))
    	{
    		rovnasePressed();
    	}
    	else if(e.getSource().equals(Components.btnplus))
    	{
    		unoperace("+");
    	}
    	else if(e.getSource().equals(Components.btn0))
    	{
    		vypis("0");
    	}
    	else if(e.getSource().equals(Components.btn1))
    	{
    		vypis("1");
    	}
    	else if(e.getSource().equals(Components.btn2))
    	{
    		vypis("2");
    	}
    	else if(e.getSource().equals(Components.btn3))
    	{
    		vypis("3");
    	}
    	else if(e.getSource().equals(Components.btn4))
    	{
    		vypis("4");
    	}
    	else if(e.getSource().equals(Components.btn5))
    	{
    		vypis("5");
    	}
    	else if(e.getSource().equals(Components.btn6))
    	{
    		vypis("6");
    	}
    	else if(e.getSource().equals(Components.btn7))
    	{
    		vypis("7");
    	}
    	else if(e.getSource().equals(Components.btn8))
    	{
    		vypis("8");
    	}
    	else if(e.getSource().equals(Components.btn9))
    	{
    		vypis("9");
    	}
    	else if(e.getSource().equals(Components.btnminus))
    	{
    		unoperace("-");
    	}
    	else if(e.getSource().equals(Components.btnkrat))
    	{
    		unoperace("*");
    	}
    	else if(e.getSource().equals(Components.btndeleno))
    	{
    		unoperace("/");
    	}
    	else if(e.getSource().equals(Components.btncar))
    	{
    		vypis(".");
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
    		unoperace("^");
    	}
    	else if(e.getSource().equals(Components.btnodm2))
    	{
    		btnodm2();
    	}
    	else if(e.getSource().equals(Components.btnodmocn))
    	{
    		unoperace("yroot");
    	}
    	else if(e.getSource().equals(Components.btnAns))
    	{
    		btnAns();
    	}
    	else if(e.getSource().equals(Components.btnodch))
    	{
    		btnodch();
    	}
    	else if(e.getSource().equals(Components.btnplmi))
    	{
    		btnplmi();
    	}
    	else if(e.getSource().equals(Components.btnfakt))
    	{
    		btnfakt();
    	}
    	else if(e.getSource().equals(Components.btnHelp))
    	{
    		final String napoveda = "<html>   <h2>Funkce kalckulačky: </h2>   <table>      <tr>         <td>  Operace:  </td>         <td> Znak</td>         <td>  Podmínky: </td>      </tr>    <tr>         <td>sčítání</td>         <td>+</td>         <td>---</td>      </tr>      <tr>         <td>odčítání</td>         <td>-</td>         <td>---</td>      </tr>      <tr>         <td>násobení</td>         <td>*</td>         <td>---</td>      </tr>      <tr>         <td>dělení</td>         <td>/</td>         <td>Nelze dělit nulou.</td>      </tr>      <tr>         <td>n-tá mocnina</td>         <td>xⁿ</td>         <td>---</td>      </tr>      <tr>         <td>druhá mocnina</td>         <td>x²</td>         <td>---</td>      </tr>      <tr>         <td>druhá odmocnina</td>         <td>√ᵪ</td>         <td>Nelze vypočítat odmocninu se záporného čísla.</td>      </tr>      <tr>         <td>n-tá odmocnina</td>         <td> ⁿ√ᵪ</td>         <td>Nelze vypočítat odmocninu se záporného čísla.</td>      </tr>      <tr>         <td>směrodatná odcdylka</td>         <td>σ</td>         <td>Při neplatném souboru se výpočet neprovede.</td>      <tr>         <td>faktoriál</td>         <td>!</td>         <td>Nelze vypočítat faktoriál se záporného čísla.</td>      </tr>   </table>   <p>      Při výpočtu je výraz hodnocen z leva do prava -> nejsou upřednostněny operace násobení, dělení, faktoriál, mocnina a odmocnina před sčítáním a odčítáním.    </p>   <p>Zadaný výraz je vyhodnocen až po kliknutí na tlačítko '=', případně po zmáčknutí klávesy ENTER.</p></html>";    		
    		Main_Window.infoBox(napoveda);    	
    	}    	    	
    	else{    		
    		System.out.print("toto se nemelo stat"); //nenastane se, kazde tlacitko je osetreno    }    
    	}
    }
    private void rovnasePressed()
    {
    	if (operace.equals("!")){operace="";}
    	if (druhec.isEmpty()){
    		if (Components.vysledek.getText().isEmpty()){
    			Components.priklad.setText(Components.priklad.getText()+ "0" );
        		druhec="0";
    			
    		}
    		else{
    		Components.priklad.setText(Components.priklad.getText()+ Components.vysledek.getText() );
    		druhec=Components.vysledek.getText();
    		}
    	}
    	else
    	{
    		Components.priklad.setText(Components.priklad.getText()+ druhec );
    	}
    	if (operace==""){
    		Components.priklad.setText(Components.vysledek.getText());
    	}
    	else{
    	try{
    	posledniplatny=vypocitej(prvnic,druhec,operace);
    	}
    	catch (Exception e){
    		exeption_handler(e); //volaní exception_handler pro reseni výjimky
    		return;
    		
    	}
    	
    	Components.vysledek.setText(posledniplatny);
    	//Components.priklad.setText("");
    	operace="";
    	prvnic="";
    	druhec="";
    	zadavamdo=0;
    	
    	}
    	
    }
    
    /**
     * Funkce pro vypisováni čísel jednak do GUI, ale také do příslušné proměné
     * @param cislo Cislo, které se má vypsat
     */
    private void vypis(String cislo){
    	if (zadavamdo==0) //pokud zadavam uplne prvni cislo
    	{
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
    
    
    
 //   private Calc_Lib calclib = new Calc_Lib();
    /**
     * funkce pro volani příslušných mat. funkcí
     * při volani odchytávana výjimka pro pozdější zpracovanání
     * před dosazením hodnot parsovani příslušých stringů
     * @param prvni prvni argument pro vypocet
     * @param druhe druhy argument pro vypocet
     * @param operace operace ktera se ma provest 
     * @return vypocitane cislo formou stringu
     * @throws Exception cislo ma vice desetinych carek 
     */
    private String vypocitej(String prvni, String druhe, String operace) throws Exception
    {
    	System.out.print("op:"+operace);
    	for(int i = 0; i < prvni.length(); i++)
    	{
    		if (prvni.charAt(i)=='.'){poccarek+=1;}
    	}
    	if (poccarek>1){
    		poccarek=0;
    		throw new Exception("Neplatnecislo");
    		}
    	else
    	{
    		poccarek=0;
    	}
    	for(int i = 0; i < druhe.length(); i++)
    	{
    		if (druhe.charAt(i)=='.'){poccarek+=1;}
    	}
    	if (poccarek>1)
    	{
    		poccarek=0;	
    		throw new Exception("Neplatnecislo");
    	}
    	else
    	{
    		poccarek=0;
    	}	
    	if (operace == "+"){
    		try
    		{
    			castvys = Calc_Lib.add(Double.valueOf(prvni), Double.valueOf(druhe));
    		}
    		catch (Exception e)
    		{
    			throw new Exception("MathError");
    		}
    	}
    	else if(operace == "-"){    		
    		try
    		{
    			castvys = Calc_Lib.sub(Double.valueOf(prvni), Double.valueOf(druhe));
    		}
    		catch (Exception e)
    		{
    			throw new Exception("MathError");		
    		}
    	}
    	else if(operace == "*"){
    		try
    		{
    			castvys = Calc_Lib.mult(Double.valueOf(prvni), Double.valueOf(druhe));
    		}
    		catch (Exception e)
    		{
    			throw new Exception("MathError");
    		}
    		
    	}
    	else if(operace == "/"){
    		try
    		{
    			castvys = Calc_Lib.divide(Double.valueOf(prvni), Double.valueOf(druhe));
    		}
    		catch (Exception e)
    		{
    			throw new Exception("MathError");   			
    		}
    		
    	}
    	else if(operace == "^"){
    		try
    		{
    			castvys = Calc_Lib.power(Double.valueOf(prvni), Double.valueOf(druhe));
    		}
    		catch (Exception e)
    		{
    			throw new Exception("MathError");
    		}
    		
    	}
    	else if(operace == "yroot"){
    		System.out.print(prvni+"to bzlo prvni nasleduje druhe :");
    		System.out.print(druhe + "konec");
    		try
    		{
    			castvys = Calc_Lib.root( Double.valueOf(prvni),Double.valueOf(druhe));
    		}
    		catch (Exception e)
    		{
    			throw new Exception("MathError");	
    		}
    		
    	}
    	
    	else if(operace.equals("!")){
    		try
    		{ 
    			factorial = Calc_Lib.factorial(Long.parseLong( String.format( "%.0f",Double.valueOf(prvni))));//parsovani double na long
    			castvys= factorial.doubleValue();
    		}
    		catch (Exception e)
    		{
    			throw new Exception("MathError");//vyhozeni prislusne výjimky pro pozdější zpracování
    		}
    		
    	}
    	
    	castvys= Math.round(castvys*100000); //zaokrouhleni na 5 desetinych mist
    	castvys=castvys/100000;
    	
    	return Double.toString(castvys) ;
    }
    
    
         
    /**
     * Univerzalni operace zpracovani binarnich operaci
     * @param op druh operace
     */
    private void unoperace(String op){
    	if (zadavamdo == 0 ) // zadavam prvni operaci
    	{
    		Components.priklad.setText("");
    		if (Components.vysledek.getText().toString().isEmpty() || prvnic.equals("-")) //pokud prvni cislo nebylo zadano
    		{
    			prvnic="0";
    			
    		}
    		else{ //jinak nastavi prvni cislo
    			prvnic=Components.vysledek.getText().toString();	
    			
    		} 		
    		Components.priklad.setText(prvnic+" "+op+" ");
    		Components.vysledek.setText("");
    		druhec="";
    		zadavamdo=1;
    		operace=op;
    	}
    	else //jiz zadavam druhe cislo
    	{
    		if(druhec.isEmpty()){//menim operaci
    			if (operace.equals("yroot")){
    				Components.priklad.setText(Components.priklad.getText().substring(0, Components.priklad.getText().length()-7));
    			}
    			else
    			{
    				Components.priklad.setText(Components.priklad.getText().substring(0, Components.priklad.getText().length()-3));
    			}
    			Components.priklad.setText(Components.priklad.getText() + " "+op+" ");
    			operace=op;
    		}
    		else {//uz delam dalsi operaci
    		druhec=Components.vysledek.getText().toString();
    		try{
    			prvnic=vypocitej(prvnic,druhec,operace); 
    		}
    		catch (Exception e) {
    			exeption_handler(e); //volaní exception_handler pro reseni výjimky
        		return;
    		}
    		Components.priklad.setText(Components.priklad.getText() + druhec +" "+op+" ");
    		operace=op;
    		druhec="";
    		Components.vysledek.setText("");
    		}
    	}
    }
   
    
    
    
   
    
    private void btnmoc2()
    {
    	rovnasePressed();
    	prvnic=Components.vysledek.getText().toString();
    	Components.priklad.setText(prvnic+" ^  2");
    	druhec="2";
    	try{
    	Components.vysledek.setText(vypocitej(prvnic,druhec,"^")); 
    	}
    	catch(Exception e){
    		exeption_handler(e); //volaní exception_handler pro reseni výjimky
    		    		
    	}
    	operace="";
    	
    }
    
    /**
     * Funkce pro vypocet 2 odmocniny z x
     * @todo obraceny vypis
     */
    private void btnodm2()
    { 
    	rovnasePressed();
    	prvnic=Components.vysledek.getText().toString();
    	Components.priklad.setText(prvnic+" yroot  2");
    	druhec="2";
    	try{
    	Components.vysledek.setText(vypocitej(prvnic,druhec,"yroot")); 
    	}
    	catch(Exception e){
    		exeption_handler(e); //volaní exception_handler pro reseni výjimky
    		
    	}
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
    private void btnAns()
    {
    	if(zadavamdo==0){
    		prvnic="";
    	}
    	else{
    		druhec="";
    	}
    	Components.vysledek.setText("");
    	vypis(Double.toString(castvys));
    }
    
    private void btnodch(){
    	btnCPressed();
        int returnVal = Components.fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
             cesta = Components.fc.getSelectedFile().getPath().toString();
        } else {
            cesta="";
        }
    	if (cesta.isEmpty()){
    		
    	}
    	else{
    		System.out.print(cesta);
    		try{
    			Components.vysledek.setText(Double.toString(Calc_Lib.st_Dev(cesta)));
    		}
    		catch (Exception e)
    		{
    			exeption_handler(e); //volaní exception_handler pro reseni výjimky
        			
    		}
    	}
    }
    /**
     * funkce pridava ci odebira znaminko - u zadavaneho cisla 
     */
    private void btnplmi(){
    	if (zadavamdo == 0 ){
    		if(prvnic.length()>0){
    			if(prvnic.charAt(0)=='-'){
    				prvnic=prvnic.substring(1);
    			}
    			else{
    				prvnic="-"+prvnic;
    			}
    		}
    		else
    		{
    			prvnic="-";
    		}
    	Components.vysledek.setText(prvnic);	
    	}
    	else{
    		if(druhec.length()>0){
    			if(druhec.charAt(0)=='-'){
    				druhec=druhec.substring(1);
    			}
    			else{
    				druhec="-"+druhec;
    			}
    		}
    		else
    		{
    			druhec="-";
    		}
    		Components.vysledek.setText(druhec);	
    		
    	}
    	
    }
    /**
     * Funkce pro zpracovani argumentu pro faktorial
     * volá funkci vypocitej s operaci !
     */
    private void btnfakt(){
    	
    	rovnasePressed();
    	prvnic=Components.vysledek.getText().toString();
    	Components.priklad.setText(prvnic+" ! ");
    	druhec="0";
    	try{
    	Components.vysledek.setText(vypocitej(prvnic,druhec,"!")); 
    	}
    	catch(Exception e){
    		
    		exeption_handler(e); //volaní exception_handler pro reseni výjimky
    	}
    	operace="";
    	
    	
    }
    /**
     * Funkce pro centralní zpracovaní výjimek
     * @param e výjimka pro zpracovani
     */
    private void exeption_handler(Exception e){
    	if (e.getMessage().equals("MathError")){
			Components.priklad.setText("MathError");
			Components.vysledek.setText("");
			prvnic="";
	    	druhec="";
	    	operace="";
	    	zadavamdo=0;
			
		}
		else {
			Components.priklad.setText("Neplatná hodnota");
			Components.vysledek.setText("");
			prvnic="";
	    	druhec="";
	    	operace="";
	    	zadavamdo=0;
			
		}
    	
    	
    }
}