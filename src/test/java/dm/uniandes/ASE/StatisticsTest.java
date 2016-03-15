package dm.uniandes.ASE;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;  

import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;

import dm.uniandes.ASE.Statistics;  

/**
 * Unit test for simple App.
 */
public class StatisticsTest { 
	
	public ArrayList<Double> lista;  
	  
    @Before  
    public void antesDelTest() {  
        
    	this.lista = new ArrayList<Double>();  
    	lista.add(new Double(2));
    	lista.add(new Double(4));
    	lista.add(new Double(5));
    	lista.add(new Double(2));
        
    }  
  
    @After  
    public void despuesDelTest() {  
         
    }  
  
    @Test  
    public void testSumatoria() {  
    	
    	Double resultado = Statistics.sumatoria(lista); 
    	assertEquals("La sumatoria deberia ser 13", new Double(13), resultado, 1e-6);  
    }  
  
}  
