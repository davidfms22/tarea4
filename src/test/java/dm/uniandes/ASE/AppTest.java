package dm.uniandes.ASE;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;  

/**
 * Unit test for simple App.
 */
public class AppTest { 
	
	public ArrayList<Double> lista1;  
	public ArrayList<Double> lista2;
  
    @Before  
    public void antesDelTest() {  
        
    	this.lista1 = new ArrayList<Double>();  
    	lista1.add(new Double(4.3953));
    	lista1.add(new Double(8.5081));
    	lista1.add(new Double(16.4696));
    	lista1.add(new Double(31.8811));
    	lista1.add(new Double(61.7137));
    	
    	this.lista2 = new ArrayList<Double>();  
    	lista2.add(new Double(6.3375));
    	lista2.add(new Double(8.4393));
    	lista2.add(new Double(11.2381));
    	lista2.add(new Double(14.9650));
    	lista2.add(new Double(19.9280));
        
    } 
	
  
    @After  
    public void despuesDelTest() {  
         
    }  
  
    @Test  
    public void test1() {  
    	
    	assertTrue(true);  
    } 
    
    @Test  
    public void test2() {  
    	
    	assertTrue(true);  
    } 
  
}  
