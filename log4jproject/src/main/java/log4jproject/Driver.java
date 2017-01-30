package log4jproject;

//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.s3s.projects.Calculator;

public class Driver {
	public static Logger logger = Logger.getLogger(Driver.class);
	public static void main(String[] args) {
		
     // BasicConfigurator.configure();
	 // Logger.getRootLogger().setLevel(Level.DEBUG);
	  
	  Calculator calc = new Calculator();
	  calc.add(3, 6);
	}
	
	

}
